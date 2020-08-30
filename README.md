
To run:
1 clone the project
2 in terminal go to src/main/java folder
3 in terminal run
javac com/kbogova/matrices/*.java && java com/kbogova/matrices/Main
4 observe result in console

-----------------------------------------------------------
Project description

-function SquareMatrix.multiplyTo() realises the task

-tester.test() calls few variants of SquareMatrix.multiplyTo()
with different matrixes and different number of threads,
compares results of the function with expected
and puts information to console

-main function calls tester.test();

-----------------------------------------------------------
Задание
Программа произведения двух квадратных матриц в многопоточном приложении
Цель: В результате выполнения ДЗ вы сделаете решение задачи путем разделения её на потоки.
В данном задании тренируются навыки создания многопоточных приложений.
Даны две матрицы A и B размерности NxN. Необходимо вычислить их произведение: матрицу С.
C[i][j] = сумма по k от 1 до N A[i][k]*B[k][j].
Разработайте многопоточное приложение, выполняющее вычисление произведения матриц.
Элементы cij матрицы произведения С = A×B вычисляются параллельно p однотипными потоками.
Если некоторый поток уже вычисляет элемент cij матрицы C,
то следующий приступающий к вычислению поток выбирает для расчета элемент ci,j+1, если j
(оборвалось описание)
