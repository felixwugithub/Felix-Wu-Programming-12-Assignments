package sortingHomework;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //unsorted array
        ArrayList<Integer> randomNumbersOneToHundred = new ArrayList<>();

        System.out.println("Random Array: ");
        for (int i = 0; i < 100; i++) {
            randomNumbersOneToHundred.add((int) (Math.random() * 100));
            System.out.print(randomNumbersOneToHundred.get(i) + ", ");
        }


        //sorted array
        System.out.println("");
        System.out.println("SORTED ARRAY: ");
        ArrayList<Integer> sorted = new ArrayList<>();
        sorted = mergeSort(randomNumbersOneToHundred);
        for (int i = 0; i < sorted.size(); i++) {
            System.out.print(sorted.get(i) + ">=");
        }



        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(22);
        arr1.add(17);
        arr1.add(11);
        arr1.add(9);
        arr1.add(3);
        arr1.add(1);


        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(30);
        arr2.add(17);
        arr2.add(15);
        arr2.add(8);
        arr2.add(6);
        arr2.add(4);
        arr2.add(3);
        arr2.add(3);
        arr2.add(3);
        arr2.add(3);







        ArrayList<Integer> arrM = new ArrayList<>();
        arrM = merge(arr1, arr2);


    }
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> array){

        if(array.size() <= 1){
            return array;
        }

        int midPoint = array.size() / 2;

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();



        for (int i = 0; i < midPoint; i++) {
            left.add(array.get(i));
        }
        for (int i = 0; i < array.size()-midPoint; i++) {
            right.add(array.get(i+midPoint));
        }


        ArrayList<Integer> result = new ArrayList<>();

        left = mergeSort(left);
        right = mergeSort(right);

        result = merge(left, right);

        return result;
    }




    public static ArrayList merge(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2){
        ArrayList<Integer> mergedArray = new ArrayList<>();
        for (int i = 0; i < arrayList1.size(); i++) {
            for (int j = 0; j < arrayList2.size(); j++) {
                if(arrayList1.get(i) < arrayList2.get(j)){
                    mergedArray.add(arrayList2.get(j));
                    arrayList2.remove(j);
                    j--;
                }else if(arrayList1.get(i) == arrayList2.get(j)){
                    mergedArray.add(arrayList1.get(i));
                    mergedArray.add(arrayList2.get(j));
                    arrayList1.remove(i);
                    arrayList2.remove(j);
                    j--;
                    i--;
                    break;
                }else if(arrayList1.get(i) > arrayList2.get(j)){
                    mergedArray.add(arrayList1.get(i));
                    arrayList1.remove(i);
                    i--;
                    break;
                }
            }
        }

        for (int i = 0; i < arrayList1.size(); i++) {
            mergedArray.add(arrayList1.get(i));

        }

        for (int i = 0; i < arrayList2.size(); i++) {
            mergedArray.add(arrayList2.get(i));

        }

    return mergedArray;

    }
}
