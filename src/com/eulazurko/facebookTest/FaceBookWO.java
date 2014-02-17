package com.eulazurko.facebookTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FaceBookWO {

	/**
	 * Написать функцию, которая принимала бы число (сторона квадрата) и
	 * выдавала бы спирально закрученную последовательность цифр.
	 */

	private static int[][] array;

	public static void main(String[] args) {
		BufferedReader breader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("Input size of side of the square:");
		int size = 0;

		while (true) {
			try {
				size = Integer.parseInt(breader.readLine());
				if(size < 0) throw new NumberFormatException();
				break;

			} catch (NumberFormatException e) {
				System.out.println("Please, input an integer not a negative number!"
						+ "\nTry again:\n");

			} catch (IOException e) {
				e.printStackTrace();

			}

		}

		array = new int[size][size];
		spiral(array.length);

		System.out.println("Here we're:\n");
		for (int[] x : array) {
			System.out.println(Arrays.toString(x));
			System.out.println();
		}

	}

	private static void spiral(int size) {
		int border = 0, start = 1;
		square(border, size, start);
	}

	private static void square(int border, int size, int start) {
		if (size == 1) {
			array[border][border] = start;
			return;
		}
		if (size == 0) {
			return;
		}
		int flag = 0, step = border, corner = 1, i = start;
		for (; start < (size - 1) * 4 + i; start++) {
			if (corner % size == 0) {
				flag++;
				corner = 1;
			}

			switch (flag) {
			case (0):
				array[border][step++] = start;
				corner++;
				break;

			case (1):
				array[(step++ - size) + 1][size - 1 + border] = start;
				corner++;
				break;

			case (2):
				array[size - 1 + border][(step-- - size) + 1] = start;
				corner++;
				break;

			case (3):
				array[step--][border] = start;
				corner++;
				break;
			}
		}

		square(border + 1, size - 2, start);

	}

}
