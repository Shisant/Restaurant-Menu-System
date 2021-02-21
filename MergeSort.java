package com.Menu;


import java.util.ArrayList;

public class MergeSort {

    public static void mSort(ArrayList<mClass> Menu) {
        if (Menu.size() <= 1) {
            return;
        }
        int midValue = Menu.size() / 2;
        ArrayList<mClass> firstHalf = new ArrayList<>(midValue);
        ArrayList<mClass> secondHalf = new ArrayList<>(Menu.size() - midValue);
        for (int i = 0; i < midValue; i++) {
            firstHalf.add(Menu.get(i));
        }
        for (int i = 0; i < (Menu.size()-midValue); i++) {
            secondHalf.add(Menu.get(i+midValue));
        }
        mSort(firstHalf);
        mSort(secondHalf);
        Merge(firstHalf, secondHalf, Menu);
    }

    public static void Merge(ArrayList<mClass> firstHalf, ArrayList<mClass> secondHalf, ArrayList<mClass> Menu) {
        int inFirst = 0;
        int inSecond = 0;
        int s = 0;

        while (inFirst < firstHalf.size() && inSecond < secondHalf.size()) {
            if (firstHalf.get(inFirst).getPrice() < secondHalf.get(inSecond).getPrice()) {
                Menu.set(s, firstHalf.get(inFirst));
                inFirst++;
            } else {
                Menu.set(s, secondHalf.get(inFirst));
                inSecond++;
            }
            s++;
        }
        while (inFirst < firstHalf.size()) {
            Menu.set(s, firstHalf.get(inFirst));
            inFirst++;
            s++;
        }
        while (inSecond < secondHalf.size()) {
            Menu.set(s, secondHalf.get(inSecond));
            inSecond++;
            s++;
        }
    }





    public static int binSearch(ArrayList<mClass> Menu, int value,  int low ,int high) {
        if (low <= high) {
            int mid = (low + high)/ 2;
            if (Menu.size()==0) {
                return 1;
            }
            if (Menu.get(mid).getPrice() == value) {
                return mid;
            } else if (Menu.get(mid).getPrice() < value) {
                return binSearch(Menu, value,mid + 1, high);
            } else {
                return binSearch(Menu, value, low, mid-1);
            }
        } else {
            return -1;
        }

    }

}