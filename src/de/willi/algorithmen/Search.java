package de.willi.algorithmen;

public class Search {
    public static void main(String[] args) {
        int[] numbers = {2,6,10,3,9,8,1,4,5,7};
        int index = linearSearch(11, numbers);
        System.out.println(index);
        Sort.bubbleSort(numbers);
        index = quickSearch(-10, numbers, 0, numbers.length - 1);
        System.out.println(index);
    }


    public static int linearSearch(int key, int[] numbers){
        for(int i = 0; i < numbers.length; i++){
            if(key == numbers[i]){
                return i;
            }
        }
        return -1;
    }

    public static int quickSearch(int key, int[] numbers,int low,int high){
        if(low > high){
            return -1;
        }
        int middle = low + ((high - low) / 2);
        if(numbers[middle] == key){
            return middle;
        }
        if(key > numbers[middle]){
            return quickSearch(key, numbers, middle+1, high);
        }
        if(key < numbers[middle]){
            return quickSearch(key, numbers, low, middle -1);
        }
        return -1;
    }

}
