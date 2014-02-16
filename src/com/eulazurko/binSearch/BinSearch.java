package com.eulazurko.binSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinSearch {

	/**
	 * Реализовать бинарный поиск элемента в массиве
	 */
	private static int[] array;

	public static void main(String[] args) {

		BufferedReader breader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("Input size of array to construct:");
		int size = 0;
		int value = 0;

		while (true) {
			try {
				size = Integer.parseInt(breader.readLine());
				if (size < 0)
					throw new NumberFormatException();
				break;

			} catch (NumberFormatException e) {
				System.out
						.println("Please, input an integer not negative number!"
								+ "\nTry again:\n");

			} catch (IOException e) {
				e.printStackTrace();

			}

		}

		fill(array = new int[size]);
		System.out.println("Array construction is complete:\n"
				+ Arrays.toString(array) + "\n");

		while (true) {
			try {
				System.out.println("Ok, now input the value for search:");
				value = Integer.parseInt(breader.readLine());
				if (value < 0)
					throw new NumberFormatException();
				break;

			} catch (NumberFormatException e) {
				System.out
						.println("Please, input an integer not negative number!"
								+ "\nTry again:\n");

			} catch (IOException e) {
				e.printStackTrace();

			}

		}

		System.out
				.println((value = bin(array, value, 0, array.length)) < 0 ? "Sorry, not found"
						: "Index of the desired value is: " + value);

	}

	public static int bin(int m[], int value, int first, int end) {
		int result;
		if (first == 0 & end == 0 || value > m[end - 1]) {
			result = -1;
		} else {
			result = m[(end - first) / 2 + first] == value ? (end - first) / 2
					+ first : (m[(end - first) / 2 + first] > value ? bin(m,
					value, first, ((end - first) / 2 + first)) : bin(m, value,
					((end - first) / 2 + first), end));

		}
		return result;
	}

	public static void fill(int[] array) {

		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
	}
}
