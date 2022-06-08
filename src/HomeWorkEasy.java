public class HomeWorkEasy {

    public static void main(String[] args) {
        //todo Задача №1
        String hi = "                Hello ";
        String world = " WoRld!";
        char newLine = '\n';
        joinWordsPrintThree(hi, world, newLine);

        //todo Задача №2
        double height = 1.74;
        double weight = 66.0;
        System.out.println(getBodyMassIndex(height, weight));

        //todo Задача №3
        char[] charArray = {'a', 'b', 'c', 'd', 'e'};
        System.out.println(charArray);
        charArray[3] = 'h';
        System.out.println(charArray);
    }
    public static void joinWordsPrintThree(String firstWord, String secondWord, char newLine) {
        String joinWords = firstWord.trim() + secondWord.toLowerCase() + newLine;
        for (int i = 0; i < 3; i++) {
            System.out.print(joinWords);
        }
    }
    public static String getBodyMassIndex(double height, double weight) {
        return String.format("%.1f", (weight)/(height * height));
    }
}
