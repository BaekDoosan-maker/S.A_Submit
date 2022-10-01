public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus();
        Bus bus1 = new Bus();

        if (bus.get_Number() == bus1.get_Number())
            System.out.println("버스 번호가 같습니다!");

        bus.currentPassenger(2);

        bus.oilRefill(-50);

        bus.changeStatus("차고지행");

        bus.oilRefill(10);

        bus.start();

        bus.currentPassenger(45);

        bus.currentPassenger(5);

        bus.oilRefill(-55);

        Taxi taxi = new Taxi();
        Taxi taxi1 = new Taxi();

        if (taxi.get_Number() == taxi1.get_Number())
            System.out.println("택시 번호가 같습니다!");

        taxi.currentPassenger(2, "서울역", 2);

        taxi.oilRefill(-80);

        taxi.payPricee();

        taxi.currentPassenger(5);

        taxi.currentPassenger(3, "구로디지털단지역", 12);

        taxi.oilRefill(-20);

        taxi.payPricee();

    }
}