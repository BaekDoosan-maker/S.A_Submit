import java.text.DecimalFormat;

public class Taxi extends PublicTransport {
    private String destination; //목적지
    private int distance; // 기본거리
    private int destinationDistance; //목적지까지 거리
    private int price; // 기본요금
    private int totalPrice; // 축적된 총 요금
    private int changedPricePerMeter; // 미터당 변경된 요금

    public Taxi(String num) {
        super(num);
        this.destination = "";
        this.distance = 1;
        this.destinationDistance = 0;
        this.price = 3000;
        this.changedPricePerMeter = 1000;
        this.maxPassenger = 4;
        this.totalPrice = 0;
        System.out.println(num + "번 택시 운행중");
        System.out.println("주유량"+ this.oil);
        System.out.println("상태" +(this.status ? "일반" : "운행불가"));
    }
    @Override
    public void payFee() {
    }

    @Override
    void moveStart() {
        this.totalPrice += this.price + this.changedPricePerMeter * (this.destinationDistance - this.distance );
        this.currentPanssenger = 0;
        this.destination = "";
        this.status = true;
        this.destinationDistance = 0;
        System.out.println("누적 요금= " + totalPrice);
    }

    @Override
    void statusChange() {
    }

    @Override
    void pickUp(Passenger passenger) {
        if(currentPanssenger == 4) {
            System.out.println("최대 승객 수 초과");
            return;
        }
        this.currentPanssenger++;
        this.destination = passenger.getGoal();
        this.status = false;
        this.destinationDistance = passenger.getDestination();

    }

    @Override
    void speedChange() {
    }

    @Override
    void oilChange(int oil) {
        this.oil += (oil);
    }

    @Override
    void oilRefill() {
        System.out.println("주유량 =" + this.oil);
        if(this.oil == 0){
            this.status = false;
            System.out.println("상태 =" + (this.status ? "일반" : "운행불가"));
        }
    }

    @Override
    void getStatus() {
        System.out.println("상태 = "  +( this.status? " 일반" : "운행불가"));
        System.out.println("주요 필요");;
        System.out.println("주유량 0");
        System.out.println("누적 요금 18000");
    }

    public void printTaxi(){
        DecimalFormat df = new DecimalFormat("#.##");

        float distance = this.destinationDistance - this.distance;

        System.out.println("탑승 승객 수 = " + this.currentPanssenger);
        System.out.println("잔여 승객 수 = " + (this.maxPassenger - this.currentPanssenger));
        System.out.println("기본요금 확인 = "+ this.price);
        System.out.println("목적지 =" + this.destination);
        System.out.println("목적지까지 거리: " +  df.format(destinationDistance) + "km");
        System.out.println("지불 요금 = " + (this.price + this.changedPricePerMeter * (this.destinationDistance - this.distance)));
        System.out.println("상태 = " + (this.status ? "일반"  :"운행중"));
    }

    public void getOut(){
        this.currentPanssenger = 0 ;
        this.destination = "";
        this.status = true;
        this.destinationDistance =0;
    }
}