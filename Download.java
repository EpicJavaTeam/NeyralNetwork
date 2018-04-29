import java.util.Scanner;

public class Download {
    Scanner scan = new Scanner(System.in);
    int num = scan.nextInt();
    double DL;

    //вывести значение веса download
    double downloadWeight(){
        if (num < 1000) {DL = 0.0;}
        if (num >= 1000) {DL = 1.0;}
        return DL;
    }
}
