import java.util.Scanner;

class Ping {
    Scanner scan = new Scanner(System.in);
    int num = scan.nextInt();
    double ping;

    //вывести значение веса ping
    double pingWeight(){
        if (num < 100) {ping = 1.0;}
        if (num >= 100) {ping = 0.0;}
        return ping;
    }
}
