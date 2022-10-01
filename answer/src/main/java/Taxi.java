import java.util.Objects;
import java.util.UUID;

public class Taxi extends Transport{

    String destination;
    int default_distance;
    int Destination_distance;
    int default_price;
    int distance_price;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    int total;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDefault_distance() {
        return default_distance;
    }

    public void setDefault_distance(int default_distance) {
        this.default_distance = default_distance;
    }

    public int getDestination_distance() {
        return Destination_distance;
    }

    public void setDestination_distance(int getDestination_distance) {
        this.Destination_distance = getDestination_distance;
    }

    public int getDefault_price() {
        return default_price;
    }

    public void setDefault_price(int default_price) {
        this.default_price += default_price;
    }

    public int getDistance_price() {
        return distance_price;
    }

    public void setDistance_price(int distance_price) {
        this.distance_price = distance_price;
    }

    Taxi() {
        this(UUID.randomUUID().toString());
    }

    Taxi(String number) {
        this.set_Number(number);
        this.set_maxPassenger(4);
        this.setDefault_price(3000);
        this.setDistance_price(1000);
        this.setDefault_distance(1);
        this.setOilAmount(100);
        this.set_status("일반");
        this.set_currentSpeed(0);
        Taxi_info();



    }


    // 버스 정보 조회
    public void Taxi_info() {
        System.out.println("===============Taxi Status=================");
        System.out.println("택시번호 : " + get_Number());
        System.out.println("현재 승객수 : " + get_currentPassenger());
        System.out.println("최대 승객수 : " + get_maxPassenger());
        System.out.println("기본 요금: " + getPrice());
        System.out.println("주유량 : " + getOil());
        System.out.println("현재 속도 : " + get_currentSpeed());
        System.out.println("상태 : " + get_status());
        System.out.println("==========================================");
        System.out.println();
        System.out.println();
    }


    public void addPriceDistance(int distance) {
        setPrice(getDefault_price());
        if (distance > getDefault_distance()) {
            setPrice(getPrice() + getDistance_price() * (distance - getDefault_distance()));
        }
    }
    public void oilRefill(int feul) {
        oil += feul;
        System.out.println("주유량 = " + getOil());
        if (getOil() < 10) {
            changeStatus("운행불가");
            System.out.println("주유 필요");
        }
    }
    public void payPricee() {
        setTotal(getTotal() + getPrice());
        System.out.println("누적 요금 = " + getTotal());
        set_status("일반");
    }


    public void currentPassenger(int passenger, String destination, int distance) {
        if (Objects.equals(get_status(), "일반")) {
            setDestination(destination);
            addPriceDistance(distance);
            setDestination_distance(distance);
            set_status("운행중");
            set_currentPassenger(passenger);
            System.out.println("탑승 승객 수 = " + get_currentPassenger());
            System.out.println("잔여 승객 수 = " + (get_maxPassenger() - get_currentPassenger()));
            System.out.println("기본 요금 확인 = " + getDefault_price());
            System.out.println("목적지 = " + getDestination());
            System.out.println("목적지까지 거리 = " + getDestination_distance());
            System.out.println("지불할 요금 = " + getPrice());
            System.out.println("상태 = " + get_status());
        } else {
            System.out.println("탑승 불가");
        }
        System.out.println();
    }
}