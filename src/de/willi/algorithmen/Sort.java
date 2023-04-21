package de.willi.algorithmen;

import java.util.Arrays;

public class Sort {


    public static void main(String[] args) {
        System.out.println("Start");
        int[] zahlen = {10,8,91,5,3,8,2,6,7,4,};
        bubbleSort(zahlen);
        System.out.println(Arrays.toString(zahlen));
    }

    public static void bubbleSort(int[] zahlen){
        for(int i = 0; i < zahlen.length; i++){
            for(int j = 1; j < zahlen.length; j++){
                System.out.println(zahlen[j-1] + " > " + zahlen[j]);
                if(zahlen[j-1] > zahlen[j]){
                    int tmp = zahlen[j-1];
                    zahlen[j-1] = zahlen[j];
                    zahlen[j] = tmp;
                }
            }
        }
    }


}
