import java.util.Scanner;

public class Upload {
    Scanner scan = new Scanner(System.in);
    int num = scan.nextInt();
    double UL;

    //вывести значение веса upload
    double uploadWeight(){
        if (num < 1000) {UL = 0.0;}
        if (num >= 1000) {UL = 1.0;}
        return UL;
    }
}
