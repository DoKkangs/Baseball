import java.util.Scanner;

public class Baseball{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] random = new int[3];
        int[] answer = new int[3];

        // 랜덤 숫자 생성
        for (int i = 0; i < random.length; i++) {
            random[i] = (int)(Math.random() * 9) ;
            // 중복 제거
            for(int j = 0 ; j < i ; j++){
                if(random[i]==random[j]){
                    i--;
                    break;
                }
            }
        }

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰 보세요!");
        int count = 1;
        while(true){
            int strike = 0;
            int ball = 0;

            String str="";
            System.out.print(count+"번째 시도:");
            str = input.nextLine();
            if(str.length() < 3){
                System.out.println("숫자는 세자리를 입력해주세요.");
                continue;
            }
            boolean isCheck = false; // 중복일 경우 true
            // 문자열 입력 받아서 끊어서 숫자 배열에 저장
            for(int i = 0 ; i < answer.length; i++){
                answer[i] = str.charAt(i) - '0'; // 문자를 숫자로 변경
                // 중복 체크
                for(int j = 0 ; j < i ; j++){
                    if(answer[i] == answer[j]){
                        isCheck = true;  // 중복된 숫자가 있을 때 true, 반복문 종료
                        break;
                    }
                }
            }
            if(isCheck){
                System.out.println("숫자를 잘 못 입력하셨습니다. 다시 입력해 주세요.");
                continue;
            }
            // 반복문으로 정답과 입력 값을 비교하며 strike와 ball을 카운트
            for(int i = 0 ; i < random.length ; i++){
                for (int j = 0; j < answer.length; j++) {
                    if(random[i] == answer[j]){
                        if(i == j){
                            strike++;
                        }else{
                            ball++;
                        }
                    }
                }
            }
            // 정답 체크
            if(strike == 3){
                System.out.println(strike + "S");
                System.out.println(count+"번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }else{
                System.out.println(ball+"B"+strike+"S");
                count++;
            }
        }
    }
}
