package com.eulazurko.twitterTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class TwitterTest {

	/**
	 * Ссылка на статью с заданием http://habrahabr.ru/post/200190/
	 * 
	 * Взгляните на следующую картинку:
	 * 
	 * <img scr ="http://habr.habrastorage.org/post_images/113/84b/c48/11384bc48754ed1c66b7cd71bc575258.jpg">
	 * 
	 * На этой картинке у нас есть стены различной высоты. Картинка представлена
	 * массивом целых чисел, где индекс — это точка на оси X, а значение каждого
	 * индекса — это высота стены (значение по оси Y). Картинке выше
	 * соответствует массив [2,5,1,2,3,4,7,7,6].
	 * 
	 * Теперь представьте: идет дождь. Сколько воды соберется в «лужах» между
	 * стенами?
	 * 
	 * <img scr ="http://habr.habrastorage.org/post_images/0ca/4c0/046/0ca4c0046711fd9f8a743163a12f3c31.jpg">
	 * 
	 * Мы считаем единицей объема воды квадратный блок 1х1. На картинке выше
	 * все, что расположено слева от точки 1, выплескивается. Вода справа от
	 * точки 7 также прольется. У нас остается лужа между 1 и 6 — таким образом,
	 * получившийся объем воды равен 10.
	 */
	 
	private static int[] m;

	public static void main(String[] args) {

		BufferedReader bReader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("Make your choice: \n\n"
				+ "1.  Generate array automaticaly \n"
				+ "2.  Manual input elements of array\n");
		int choice;

		while (true) {
			try {
				choice = Integer.parseInt(bReader.readLine());
				if (choice <= 0 || choice > 2)
					throw new NumberFormatException();
				break;

			} catch (NumberFormatException e) {
				System.out
						.println("Please, input an integer not a negative number!"
								+ "\nTry again:\n");

			} catch (IOException e) {
				e.printStackTrace();

			}

		}

		switch (choice) {
		case 1:
			int size;

			System.out.println("OK, input size of array for construct: \n");

			while (true) {
				try {
					size = Integer.parseInt(bReader.readLine());
					if (size < 0)
						throw new NumberFormatException();
					break;

				} catch (NumberFormatException e) {
					System.out
							.println("Please, input an integer not a negative number!"
									+ "\nTry again:\n");

				} catch (IOException e) {
					e.printStackTrace();

				}
			}

			m = generate(size);
			System.out.println("Array construction is complete:\n"
					+ Arrays.toString(m));
			System.out.println("\nResult: " + calculate(m));
			break;

		case 2:
			System.out.println("OK, now please input a value of elements of array"
					+ " separated by spaces (i.e. 1 2 3 4 5 ): \n");

			while (true) {
				try {
					m = strToArray(bReader.readLine());
					break;

				} catch (NumberFormatException e) {
					System.out
							.println("Please, input an integer value (i.e. 1 2 3 4 5 )"
									+ "\nTry again:\n");

				} catch (IOException e) {
					e.printStackTrace();

				}
			}

			System.out.println("Array construction is complete:\n"
					+ Arrays.toString(m));
			System.out.println("\nResult: " + calculate(m));
			break;
		}

	}

	private static int calculate(int[] array) {

		int leftBorder = 0, i = leftBorder;
		int rightBoreder = array.length - 1, j = rightBoreder;
		int sum = 0;

		while (i < j) {

			if (array[leftBorder] <= array[rightBoreder]) {

				if (array[leftBorder] < array[i + 1]) {
					leftBorder = (i + 1);
					i++;
				} else {
					sum += (array[leftBorder] - array[i + 1]);
					i++;
				}
			}

			if (array[leftBorder] > array[rightBoreder]) {

				if (array[rightBoreder] < array[j - 1]) {
					rightBoreder = (j - 1);
					j--;
				} else {
					sum += (array[rightBoreder] - array[j - 1]);
					j--;
				}
			}

		}
		return sum;
	}

	public static int[] generate(int size) {
		int[] array = new int[size];
		Random rand = new Random();

		for (int i = 0; i < array.length; i++)
			array[i] = rand.nextInt(15);

		return array;
	}

	public static int[] strToArray(String str) throws IOException {

		int array[] = new int[str.split(" ").length];
		int index = 0;

		for (String element : str.split(" ")) {
			array[index] = Integer.parseInt(element);
			index++;
		}
		return array;

	}

}
