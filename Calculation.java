import java.util.Arrays;
import java.util.Scanner;
/*
Задача: программа “Калькулятор”
Описание:
Создайте консольное приложение “Калькулятор”.
Приложение должно читать из консоли введенные пользователем арифметические операции и выводить в консоль результат их выполнения.

Требования:
Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b.
Данные передаются в одну строку (смотрите пример)!
Решения, в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными.
Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числа.
Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.
На выходе числа не ограничиваются по величине и могут быть любыми.
Калькулятор умеет работать только с целыми числами.
Калькулятор умеет работать только с арабскими или римскими цифрами одновременно,
при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу.
При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.
При вводе пользователем строки не соответствующей одной из вышеописанных арифметических операций приложение выбрасывает исключение и завершает свою работу.
Пример работы программы:

Input:
1 + 2

Output:
3

Input:
VI / III

Output:
II

Принципы оценки работы:
Обратите внимание на принципы ООП, постарайтесь разбить программу на логические классы.
Решения, в которых весь код программы находится в одном классе будут низко оценены.
Продемонстрируйте своё умение в работе с разными синтаксическими конструкциями,
не забудьте про исключительные ситуации,
при которых выполнение программы невозможно из-за некорректных входных данных.

 */


public class Calculation {

    public static void main(String[] args) {
        System.out.println(" Начало работы программы \"Калькулятор\"  ");
        System.out.println(" Программа работает одновременно только с арабскими или только с римскими цифрами ");
        System.out.println(" Введите выражение для вычисления в одном из следующих форматов: a + b, a - b, a * b, a / b.");
        Scanner in = new Scanner (System.in);
        String calculation = in.nextLine();
        // решил убрать лишние пробелы в начале и в конце. соответственно, не будет сообщения о такой ошибке.
        calculation = calculation.trim();
        // ЕСЛИ МЕЖДУ ЗНАКАМИ БОЛЬШЕ ПРОБЕЛОВ ЧЕМ НУЖНО, ТО ВЫДАТЬ СООБЩЕНИЕ ОБ ОШИБКЕ
        String[] blocks = calculation.split(" ");

        /*  ДОБАВИТЬ ИСКЛЮЧЕНИЯ И ОШИБКИ, ПРОВЕРКУ УСЛОВИЙ ВВОДА
            И ПРЕДУСМОТРЕТЬ ВЫВОД СОБЩЕНИЯ ЕСЛИ В РЕЗУЛТАТЕ ДЕЛЕНИЯ БУДЕТ ПОЛУЧАТЬСЯ НОЛЬ.
            ПЕРЕПРИСВОИТЬ ПЕРЕМЕННЫЕ БЛОК ДЛЯ ЛУЧШЕГО ПОНИМАНИЯ КОДА
        */
        // СЮДА ВСТАВИТЬ ПРОВЕРКУ НА ОШИБОЧНЫЙ ВВОД

         if (arabicNumbers.isInputValueIsNumber(blocks[0])&&arabicNumbers.isInputValueIsNumber(blocks[2])&&operations.isInputOperationIsCorrect(blocks[1])) {
                System.out.print (blocks[0] + " " + blocks[1] + " " + blocks[2] +" = ");
                System.out.println (arabicNumbers.calculateArabicNumber(blocks[0],blocks[2],blocks[1]));
        }
        else if (romanNumbers.isInputValueIsNumber(blocks[0])&&romanNumbers.isInputValueIsNumber(blocks[2])&&operations.isInputOperationIsCorrect(blocks[1])) {
                System.out.print (blocks[0] + " " + blocks[1] + " " + blocks[2] +" = ");
                System.out.println(romanNumbers.calculateRomanNumbers(blocks[0],blocks[2],blocks[1]));
        }
        else {
                 System.out.println(" Внимание: проверьте правильность введенных данных на соответствие формату данных!");
                 System.out.println(" Конец работы.");
        }
        // ЗДЕСЬ ПРОВЕРИМ РИМСКИЕ ЛИ ЧИСЛА ВВЕДЕНЫ
        // ПРОВЕРКА ОПЕРАЦИЙ
        // ВЫВЕДЕМ ОШИБКУ ЕСЛИ НЕ РИМСКИЕ И НЕ АРАБСКИЕ, А ТАКЖЕ  ЕСЛИ МНОГО ПРОБЕЛОВ ИЛИ ДРУГОЙ ЗНАК ОПЕРАЦИИ.

        in.close();
    }

    static class arabicNumbers {
            static String[] arabicNums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

            static boolean isInputValueIsNumber (String value)
            {
                return Arrays.asList(arabicNums).contains(value);
            }

        public static int calculateArabicNumber (String value1, String value2, String operator)
                 {
                 int num1 = Integer.parseInt(value1);
                 char operation = operator.charAt(0);
                 int num2 = Integer.parseInt(value2);
                 int resultat = 0;

                switch(operation)
                {
                    case '+' : resultat = num1 + num2;
                        break;
                    case '-' : resultat = num1 - num2;
                        break;
                    case '*' : resultat = num1 * num2;
                        break;
                    case '/' : resultat = num1 / num2;
                 }
            return resultat;
        }
    }

    static class romanNumbers extends arabicNumbers{
        // предусмотреть ошибку если нацело не делится. или вывести отдельное сообщение.
            static String[] romanNums = new String [] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            static String[] romanNumsDec = new String [] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
            static int lenNums = romanNums.length;
            static int lenDec= romanNumsDec.length;
            static int lenAll = lenDec*lenNums;
            static String[] romanNumsAll = new String [lenAll];

        static boolean isInputValueIsNumber (String value)
             {
                 return Arrays.asList(romanNums).contains(value);
            }


        static String calculateRomanNumbers (String value1, String value2, String operator)
            {
                for (int j = 0; j < lenDec-1; j++) {
                    for (int i = 0; i < lenNums; i++) {
                        if (i == 9) romanNumsAll[j*10+i] = romanNumsDec[j+1];
                            else romanNumsAll[j*10+i] = romanNumsDec[j] + romanNums[i];
                    }
                }

                String value1toArabic = Integer.toString(Arrays.binarySearch(romanNums, value1)+1);
                String value2toArabic = Integer.toString(Arrays.binarySearch(romanNums, value2)+1);

                int resultatArabic = arabicNumbers.calculateArabicNumber(value1toArabic, value2toArabic, operator);
                //System.out.println(resultatArabic);

                //String resultRoman = romanNumsAll[resultatArabic-1];
                // А ЧТО ЕСЛИ РЕЗУЛЬТАТ ОТ ДЕЛЕНИЯ БУДЕТ РАВЕН НУЛЮ ???? ПРЕДУСМОТРЕТЬ
                //System.out.println(resultRoman);

            if (resultatArabic-1 >= 0) return romanNumsAll[resultatArabic-1];
            else return "ноль";
            }

        public static int findIndex(String[] list, String value)
            {
                 int len = list.length;
                 int index = 0;
                     for (int i=0; i < len; i++) {
                        if (list[i].equals(value))
                    index = i;
                    }
            return index;
        }
    }

    static class operations{
             public static String[] operations = {"+", "-", "*", "/"};
             public static boolean isInputOperationIsCorrect (String value)
             {
            return Arrays.asList(operations).contains(value);
             }



    }

}
