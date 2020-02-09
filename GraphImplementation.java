public class GraphImplementation implements GraphInterface {
    
    int value_arr[] = new int[10];
    int curr_index = 0;

    public int getValue(int index){
        return value_arr[index];
    }

    public void updateValue(int index){
        value_arr[index]++;
    }

    public void addValue(int value){
        value_arr[curr_index] = value;
    }
}