public class HomeWorkMedium {
    public static void main(String[] args) {
        //todo Задача №1
        String numberString = "123";
        String someText = "Hello World!";
        int number = Integer.parseInt(numberString);
        int lengthString = someText.length();
        System.out.println(number + lengthString);

        //todo Задача №2
        int a = 3;
        int b = 5;
        System.out.println(Math.pow((a + b), 2));

        //todo Задача №3
        int[] firstArray = {1,2,5,7,10};
        int[] secondArray = {2,3,2,17,15};
        joinArrayAndMultiply(firstArray, secondArray);

        //todo Задача №4
        String beforeStr = "Hello world!";
        String afterStr = beforeStr.replaceAll("l", "r").toUpperCase().substring(0,8);
        System.out.println(afterStr);
    }

    public static void joinArrayAndMultiply(int[] firstArray, int[] secondArray) {
        int lengthJoinArray = firstArray.length + secondArray.length;
        int lengthJoinArrayMultiply = lengthJoinArray + (lengthJoinArray/2);
        int[] result = new int[lengthJoinArrayMultiply];
        int count = 0;
        for (int i = 0; i < firstArray.length; i++) {
            result[i] = firstArray[i];
            count++;
        }
        for (int j : secondArray) {
            result[count] = j;
            count++;
        }
        for (int i = 0; i < firstArray.length; i++) {
            result[count] = firstArray[i] * secondArray[i];
            count++;
        }
        for (int number : result) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
