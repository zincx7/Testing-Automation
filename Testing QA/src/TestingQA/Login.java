package TestingQA;
import java.util.Scanner;

public class Login {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = prompt("Masukan Password");
        String validPassword = "password";

        if (password.equals(validPassword)) {
            System.out.println("Sealamat Datang");
        } else {
            System.out.println("Password anda salah");
        }
        System.out.println("Terima kasih sudah menggunakan applikasi");
    }


    public static String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine();
    }
}
