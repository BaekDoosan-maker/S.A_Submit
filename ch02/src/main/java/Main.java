import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================================");
        Bus a = new Bus(UUID.randomUUID().toString());
        Bus b = new Bus(UUID.randomUUID().toString());

        Passenger san = new Passenger(30, "서울역", "san");
        Passenger baekdoo = new Passenger(30, "서울역", "baekdoo");

        System.out.println();
        System.out.println("==================================================================");
        a.pickUp(san);
        a.pickUp(baekdoo);
        a.payFee();


        System.out.println();
        System.out.println("==================================================================");
        a.oilChange(-50);
        a.oilRefill();

        System.out.println();
        System.out.println("==================================================================");
        a.oilChange(10);
        a.oilRefill();
        a.getStatus();
        a.oilChange(20);


        System.out.println();
        System.out.println("==================================================================");
        for (int i = 1; i < 30; i++) {
            a.pickUp(new Passenger(30, "서울역", "san" + i + "번째 아들"));
        }


        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                b.pickUp(san);
            } else {
                b.pickUp(new Passenger(30, "서울역", "baekdoo" + i + "번째 아들"));
            }
        }

        System.out.println();
        System.out.println("==================================================================");
        b.payFee();


        System.out.println();
        System.out.println("===================================================================");
        b.oilChange(-95);
        b.oilRefill();
        b.getStatus();

        System.out.println("==================================================================");
        Taxi taxi1 = new Taxi(UUID.randomUUID().toString());
        Taxi taxi2 = new Taxi(UUID.randomUUID().toString());

        Passenger san2 = new Passenger(2, "서울역", "san2");
        Passenger baekdoo2 = new Passenger(2, "서울역", "baekdoo2");

        System.out.println("==================================================================");
        taxi1.pickUp(san2);
        taxi1.pickUp(baekdoo2);
        taxi1.printTaxi();

        System.out.println("==================================================================");
        taxi1.moveStart();
        taxi1.oilChange(-80);
        taxi1.oilRefill();

        System.out.println("==================================================================");
        for (int i = 1; i < 6; i++) {
            taxi1.pickUp(new Passenger(2, "서울역", "san2" + i + "번째 아들"));
        }
        taxi1.getOut();

        System.out.println("===================================================================");
        taxi1.pickUp(new Passenger(12, "구로 디지털 단지역", "san2"));
        taxi1.pickUp(new Passenger(12, "구로 디지털 단지역", "baekdoo2"));
        taxi1.pickUp(new Passenger(12, "구로 디지털 단지역", "baekdoosan2"));
        taxi1.printTaxi();

        System.out.println("==================================================================");
        taxi1.oilChange(-20);
        taxi1.oilRefill();
        taxi1.moveStart();
    }
}