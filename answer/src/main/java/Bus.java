import java.util.Objects;
import java.util.UUID;

public class Bus extends Transport {
    // 버스 생성
    Bus() {
        this(UUID.randomUUID().toString());
    }

    Bus(String Number) {
        set_Number(Number);
        set_maxPassenger(30);
        start();
        setPrice(1000);
        Bus_info();
    }

    // 버스 정보 조회
    public void Bus_info() {
        System.out.println("===============Bus Status=================");
        System.out.println("벼스번호 : " + get_Number());
        System.out.println("최대 승객수 : " + get_maxPassenger());
        System.out.println("현재 승객수 : " + get_currentPassenger());
        System.out.println("요금 : " + getPrice());
        System.out.println("주유량 : " + getOil());
        System.out.println("현재 속도 : " + get_currentSpeed());
        System.out.println("상태 : " + get_status());
        System.out.println("==========================================");
        System.out.println();
        System.out.println();
    }

    // 기름 관리
    public void oilRefill(int feul) {
        oil += feul;
        System.out.println("주유량 = " + getOil());
        if (getOil() < 10) {
            changeStatus("차고지행");
            System.out.println("주유 필요");
        }
    }

    // 승객 탑승
    public void currentPassenger(int passenger) {
        if (Objects.equals(this.get_status(), "운행")) {
            if (get_maxPassenger() == get_currentPassenger()) {
                System.out.println("현재 최대 탑승 인원이 탑승중입니다.");
                System.out.println();
                return;
            }
            if (get_currentPassenger() + passenger > get_maxPassenger()) {
                System.out.println("최대 탑승 인원수를 초과하였습니다.");
                System.out.println();
                return;
            }
            set_currentPassenger(passenger);
            System.out.println("탑승 승객 수 = " + get_currentPassenger());
            System.out.println("잔여 승객 수 = " + (get_maxPassenger() - get_currentPassenger()));
            System.out.println("요금 확인 = " + (getPrice() * get_currentPassenger()));
        } else {
            System.out.println("현재 상태가 운행중이 아닙니다.");
        }
        System.out.println();
    }

}