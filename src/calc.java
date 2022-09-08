import java.util.Scanner;
public class calc {
    static String[] arab = new String[]{"10", "1", "2", "3", "4", "5", "6", "7", "8", "9","10","11","12","13","14","15","16"
            ,"17","18","19", "20","21","24","25","27","28","30","32","35","36","40","42","45","48","49","50",
            "54","56","60","63","64","70","72","80","81","90","100" };
    static String[] rome = new String[]{"X", "I", "II", "III", "IV", "V","VI", "VII", "VIII", "IX","x","XI","XII","XIII","XIV"
            ,"XV", "XVI","XVII","XVIII","XIX","XX","XXI","XXIV","XXV","XXVII","XXVIII","XXX","XXXII","XXXV","XXXVI",
            "XXXX","XXXXII","XXXXV","XXXXVIII","XXXXIX","L",
            "LIV","LVI","LX","LXIII","LXIV",
            "LXX","LXXII","LXXX","LXXXI",
            "XC","C"
    };
    static boolean x = false;
    static boolean y = false;
    public static void main(String[] args) {
        // input task, splitting to numbers and activity
        // Ввод задачи, разбиение на числа и действие
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] elements = input.split(" ");
        // checking a and b are roman
        //проверка являются ли a и b римскими
        for (String s : rome) {
            if (elements[0].equals(s)) {
                x = true;
                break;
            }

        }
        for (String s : rome) {
            if (elements[2].equals(s)) {
                y = true;
                break;
            }

        }
        if (elements.length != 3) {
            System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        }
        else {
            if (x != y) {
                System.out.print("Разные системы счисления");
            } else {
                System.out.println(calculating(transAR(elements[0]), elements[1], transAR(elements[2])));
            }
        }
    }

    public static String calculating(int a, String operation, int b) {
        String res = switch (operation) {
            case ("+") -> String.valueOf(a + b);
            case ("-") -> String.valueOf(a - b);
            case ("*") -> String.valueOf(a * b);
            case ("/") -> String.valueOf(a / b);
            default -> "0";
        };
       if(x&y){
           res = transRA(res);
       }
       return res;
    }

    public static int transAR(String a) {
        // checking and transformation roman numbers to arab numbers
        // проверка и перевод римских цифр в арабские
        int n = 0;
        for (String s : arab) {
            if (a.equals(s)) {
                n = Integer.parseInt(s);
            }
        }
        for (int i = 0; i < rome.length; i++) {
            if (a.equals(rome[i])) {
                n = Integer.parseInt(arab[i]);
            }
        }
        return n;
    }
    public static String transRA(String a) {
        // checking and transformation arab numbers to roman numbers
        // проверка и перевод арабских цифр в римские
        String n = "";
        if(Integer.parseInt(a) < 1){
            n = "В римской системе нет отрицательных чисел";
        }
        else {
        for(int i = 0; i < arab.length; i++){
            if(a.equals(arab[i])){
                n = (rome[i]);
            }
         }
        }
        return n;
    }
}