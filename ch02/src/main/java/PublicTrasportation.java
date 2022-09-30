abstract class PublicTransport {
    //상위클래스 요소
    public String num; //차번호
    public int oil; //주유량
    public int currentSpeed; //속도
    public int changeSpeed;  //속도변경
    public  int currentPanssenger; // 현재승객수
    public int maxPassenger; //최대승객수

    //상위클래스 기능
    public boolean status;  //운행시작

    //public int changeSpeed; //속도변경
    //public changeStatus//상태변경
    //public passengerRide; //승객탑승

    // 기본값
    //주유량 100
    // 속도 0
    public PublicTransport(String num){
        this.num = num;
        this.currentSpeed = 0;
        this.changeSpeed = 0;
        this.currentPanssenger = 0;
        this.status = true;
        this.oil = 100;
    }

    abstract void payFee();
    abstract void moveStart();
    abstract void statusChange();

    abstract void pickUp(Passenger passenger);

    abstract void speedChange();

    abstract void oilChange(int oil);

    abstract void oilRefill();
    abstract void getStatus();//printStats


}