package Hello.core.singleton;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int[] nums = new int[3];
        for(int i=0; i<3; i++){
            nums[i] = (int)(Math.random()*10);
                for (int j = 0; j < i; j++) {
                    if (nums[i] == nums[j]) {
                        i--;
                        break;
                    }
                }
            }
            System.out.println(Arrays.toString(nums));
            // 서로다른 숫자 뽑기 완료
            int n = 0;
            int B = 0;
            int S = 0;
            System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
            while(true){
                n++;
                S=0; B=0;
                System.out.print(n+ "번째 시도: "  );
                String input = sc.next(); // 12ㅇ
                int num1 = Integer.parseInt(input.substring(0, 1));
                int num2 = Integer.parseInt(input.substring(1, 2));
                int num3 = Integer.parseInt(input.substring(2));
                int[] num = {num1, num2, num3};
                for(int i=0; i<input.length(); i++){
                    if(nums[i] == num[i]){
                        S++;
                    }
                }
                // 숫자가 포함되어있지만, 순서가 다를 때
                for(int i=0; i<input.length(); i++){
                    for(int j=0; j<input.length();j++){
                        if(i!=j){
                            if(nums[i] == num[j]){
                                B++;
                            }
                        }
                    }
                }
                    if(B==3){
                        System.out.println(B+"B");
                    }else if(S==3){
                        System.out.println(n-1+"번 만에 맞히셨습니다.");
                        System.out.println("게임을 종료합니다.");
                        break;
                    }else{
                        System.out.println(B+"B"+S+"S");
                    }
            }
        }
    }

