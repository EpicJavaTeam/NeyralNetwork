import java.util.ArrayList;
import java.util.Scanner;

public class NeySet {

    public static void main(String[] args) {
        double ping=0.0;   //переменные основных параметров
        double DL=0.0;
        double UL=0.0;

        System.out.print("Введите ping, мс: ");
        Ping pinger = new Ping(); //создаем объект класса Ping
        ping=pinger.pingWeight();       //метод pingWeight класса Ping возвращает вес

        System.out.print("Введите скорость загрузки (Download),Кбит/с: ");
        Download downloader = new Download(); //создаем объект класса Download
        DL=downloader.downloadWeight();    //метод downloadWeight окласса Download возвращает вес

        System.out.print("Введите скорость выгрузки (Upload),Кбит/с: ");
        Upload uploader = new Upload(); //создаем объект класса Upload
        UL=uploader.uploadWeight();        //метод uploadWeight окласса Upload возвращает вес

        if (getTransfer(ping, DL, UL)) {System.out.println("Передаём");}     //печатаем решение нейросети
        if (!getTransfer(ping, DL, UL)) {System.out.println("Не передаём");} //о передаче
    }

    public static boolean getTransfer(double ping, double DL, double UL){ //заставляем работать нейроны
       return TransfFin(Transf1(ping,DL,UL),Transf2(ping,DL,UL));         // с введёнными параметрами входов
    }

    public static int Transf1(double ping, double DL, double UL) {   //нейрон 1 уровня HiddenLayer
        ArrayList<Double> weight1 = new ArrayList<Double>();     //arraylist с весами входов
        weight1.add(0.25);   //веса заданы
        weight1.add(0.0);    //вручную
        weight1.add(0.25);   //для упрощения
        double result = ping*weight1.get(0)+DL*weight1.get(1)+UL*weight1.get(2);  //считаем сумму с входов
        int a=0;
        if (result>=0.5) {a=1;} //и решаем, что передать дальше
        if (result<0.5) {a=0;}  // 0 или 1
        return a; //передаём на выход 1 или 0
    }

    public static int Transf2(double ping, double DL, double UL) {      //нейрон 2 уровня HiddenLayer
        ArrayList<Double> weight2 = new ArrayList<Double>();              //arraylist с весами входов
        weight2.add(0.5);  //веса заданы
        weight2.add(-0.4); //вручную
        weight2.add(0.9);  //для упрощения
        double result = ping*weight2.get(0)+DL*weight2.get(1)+UL*weight2.get(2);  //считаем сумму с входов
        int b=0;
        if (result>=0.5) {b=1;}  //и решаем, что передать дальше
        if (result<0.5) {b=0;}   //0 или 1
        return b; //передаём на выход 1 или 0
    }

    public static boolean TransfFin(int a, int b) {   //конечный нейрон, решает передавать или нет
        return (a+b>=0.5);
    }
}
