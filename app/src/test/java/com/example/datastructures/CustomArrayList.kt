package com.example.datastructures


import java.util.Arrays

class CustomArrayList<T> {
    private var capacity = 8
    private var currentSize = 0
    private var innerArray = arrayOfNulls<Any>(capacity) as Array<T>

    fun run() {

    }

    fun checkCapacity() {
        if (currentSize >= capacity) {
            // Copy array to bigger array.
            capacity *= 2
            innerArray = Arrays.copyOf(innerArray, capacity)
        }
    }

    fun add(thing: T) {
        innerArray[currentSize] = thing
        currentSize++
        checkCapacity()
    }

    //    public void remove(T thing) {
    //        int indexToRemove = -1;
    //        for (int i = 0; i < currentSize; i++) {
    //            if (innerArray[i] == thing) {
    //                indexToRemove = i;
    //                break;
    //            }
    //        }
    //
    //        if (indexToRemove == -1)
    //            return;
    //
    //        // src − This is the source array.
    //        // srcPos − This is the starting position in the source array.
    //        // dest − This is the destination array.
    //        // destPos − This is the starting position in the destination data.
    //        // length − This is the number of array elements to be copied.
    //
    //        T[] temp = System.arraycopy(innerArray, 0, );
    //        Arrays.copyOfRange(innerArray, 0, 3);
    //
    //    }
}
