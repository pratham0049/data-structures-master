package com.arrays;

import java.util.Arrays;

public class ArrayDS {
	
	private Object[] data; // Data in array is stored in form of objects.
	private int capacity; // This defines the capacity of the array.
	private int length; // This variable defines length of an array.
	
	public ArrayDS() {
		length = 0; // Initially length of an array is 0.
		capacity = 1; // Initially capacity of an array is 1. Which means there's place to store one object inside the array
		data = new Object[1]; // This line creates the space for one object to be stored.
	}
	
	public Object getItem(int index) {
		return data[index];
	}
	
	public void push(Object item) {
		if(capacity==length) {
			data = Arrays.copyOf(data, capacity*2); 
			/* when the capacity increases we don't adjust 
			it itself in the initial array we make copy of that array with increases capacity. */
			capacity *= 2; // Increases the capacity as array size increases.
		}
		
		data[length] = item;
		length++;
	}
	
	public Object pop() {
		Object poppedItem = data[length-1];
		data[length-1] = null;
		length--;
		return poppedItem;
	}
	
	public void shiftIndex(int index) {

		for(int i=index ; i<data.length-1 ;i++) {
			data[i] = data[i+1];
		}
		data[length] = null;
		length--;
	}
	
	public Object delete(int index) {
		Object deletedItem = data[index];
		data[index] = null;
		shiftIndex(index);
		return deletedItem;
	}
	
	public static void main(String[] args) {
		ArrayDS arr = new ArrayDS();
		for(int i=1;i<=10;i++) {
			arr.push(i);
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr.getItem(i)+" ");
		}
		System.out.println();
		System.out.println(arr);
		arr.pop();
		System.out.println(arr);
		System.out.println("Deleted Item:: " + arr.delete(2));
		System.out.println(arr);
		System.out.println("Item At Specific Index:: " + arr.getItem(3));
	}

	@Override
	public String toString() {
		return "ArrayDS [data=" + Arrays.toString(data) + ", capacity=" + capacity + ", length=" + length + "]";
	}
	
	
	
}
