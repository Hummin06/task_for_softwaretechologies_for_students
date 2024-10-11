package org.softwaretechnologies;

public final class ArrayFunctions {

    private ArrayFunctions() {
    }

    /**
     * Функция, меняющая порядок элементов в массиве array на обратный.
     * @param array массив, который будет перевернут.
     */
    public static void reverse(int[] array) {
        int size = array.length;
        int n = size;
        for(int i = 0; i< size/2; i++){
            int j = array[i];
            array[i] = array[n];
            array[n]= j;
            n--;
        }
        for(int i = 0; i!= size; i++){
            System.out.println(array[i]);
        }

    }

    /**
     * Функция, заменяющая строки матрицы на столбцы матрицы. Пример:
       1  2  3     1  4  7
       4  5  6     2  5  8
       7  8  9     3  6  9
     * Функция работает только с квадратными матрицами.
     * Если матрица не квадратная, то выведете на экран сообщение:
       Матрица не квадратная
     * @param matrix матрица, в которой столбцы будут заменены на строки.
     */
    public static void rotateMatrix(int[][] matrix) {
        int size = matrix.length;
        for(int i = 0 ; i<size; i++){
            for(int g = 0; g<size/2;g++){
                int j = matrix[i][g];
                matrix[i][g] = matrix[g][i];
                matrix[g][i]= j;

            }
        }
        // TODO: реализуйте вышеуказанную функцию
    }
}
