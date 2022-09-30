/**
 * Bus 클래스 모델링
 * 1.최대승객수  maxPassenger
 * 2.현재승객수  passenger
 * 3.요금 price
 * 4.버스번호 busNum
 * 5.주유량  oil
 * 6. 현재속도 speed
 * 7. 상태 a.운행, 차고지행 status
 */
public class Bus extends PublicTransport {
    private int price; // 요금

    public Bus(String num) {
        super(num);
        this.maxPassenger = 30;
        this.price = 0;
        System.out.println(num + "번 버스가 생성되었습니다.");
    }

    @Override
    public void payFee(){ //payPrint()
        System.out.println("탑승승객 수=" +this.currentPanssenger);
        System.out.println("잔여승객 수=" +this.maxPassenger);
        System.out.println("요금 확인=" +this.price);
    }

    @Override
    public void moveStart(){
    }
    @Override
    public void statusChange(){
        if(this.oil <= 60) {
            this.status = false;
        }else{
            this.status = true;
        }
    }

    @Override
    public void pickUp(Passenger passenger) {
        if(!this.status){
            getStatus();
        }
        if(this.maxPassenger == 0) {
            System.out.println("최대 승객 수 초과");
            return;
        }
        this.maxPassenger--;
        this.currentPanssenger++;
        this.price += 1000;
    }

    @Override
    public void speedChange(){

    }
    @Override
    public void oilChange(int oil){
        this.oil += (oil);
        statusChange();
    }

    @Override
    public void oilRefill(){ //printOil
        System.out.println("주유량 =" + this.oil);
        if(this.oil <= 5) {
            System.out.println("주유 필요");
        }
    }

    @Override
    public void getStatus(){ //printStats // *상태
        System.out.println("상태 = " + (this.status ? "운행중" : "차고지행"));
    }
}