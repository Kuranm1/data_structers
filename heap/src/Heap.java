import java.util.ArrayList;
import java.util.List;
public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    public void insert(int value){
        heap.add(value);
        int index = length() - 1 ;
        int parent_index = parent(index);

        while (index > 0 && heap.get(index) > heap.get(parent_index)){
            swap(parent_index,index);
            index = parent_index;
            parent_index = parent(index);
        }
    }

    public Integer remove (){
        if (heap.isEmpty()) return null;
        if (length()==1) return heap.remove(0);
        int maxValue = heap.get(0);
        heap.set(0,heap.remove(length()-1));
        sinkDown(0);
        return maxValue;
    }

    private void sinkDown(int index){
        while (index < length()){

            boolean hasRightChild = rightChild(index) < length();
            boolean hasLeftChild = leftChild(index) < length();
            boolean isLeftGreater = hasRightChild ? heap.get(leftChild(index)) > heap.get(rightChild(index)) : true;

            if (hasLeftChild && isLeftGreater && heap.get(index) < heap.get(leftChild(index))){
                swap(index, leftChild(index));
                index = leftChild(index);
            }
            else if (hasRightChild && heap.get(index) < heap.get(rightChild(index))) {
                swap(index, rightChild(index));
                index = rightChild(index);
            }
            else break;

        }
    }

    private int parent(int index){
        return (index-1) / 2;
    }

    private int leftChild(int index){
        return index * 2 + 1 ;
    }

    private int rightChild(int index){
        return leftChild(index)+1;
    }

    private void swap(int firstIndex, int secondIndex){
        int temp = heap.get(firstIndex);
        heap.set(firstIndex,heap.get(secondIndex));
        heap.set(secondIndex, temp);
    }

    private int length(){
        return heap.size();
    }


}
