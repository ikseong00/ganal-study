package baekjoon.q32713;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //삭제가능 횟수를 고려하여 가능한 모든 연속길이 중 최고값을 출력해주는 방식
        int size; //입력되는 수열 길이
        int del; // 수열에서 삭제 가능한 원소의 개수
        Scanner scan = new Scanner(System.in);
        List<Integer> lengs = new ArrayList<>();  //가능한 연속길이들의 List

        //수열의 크기와 삭제 가능한 원소의 개수를 입력받는다.
        size = scan.nextInt();
        del = scan.nextInt();
        scan.nextLine();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(scan.nextInt());
        }

        //'가능한 모든 연속길이'를 어떻게 구하는가?
        //i번째 원소가 있으면 i+1번째부터 탐색을 시작한다
        //만약 i번째 원소와 같은 값이면 연속길이++;
        //i번째 원소와 다른 값이면 count값을 --;
        //count 값이 음수가 되는 순간 탐색을 종료하고 연속길이 값을 list에 저장한다.
        //이러한 탐색을 모든 원소에서 하므로 가능한 모든 연속길이를 파악할 수 있다.
        //탐색을 왜 i<(size-1)이 아니라 i<size 까지로 하는가? >>size가 1 일때 lengs가 empty여서 나중에 오류 발생...
        for (int i = 0; i < size; i++) {
            int count = del; //삭제한 횟수
            int len = 1; //연속 길이

            for (int j = i + 1; j < size; j++) {
                if (list.get(j).equals(list.get(i))) {
                    len++;
                } else count--;
                if (count < 0)
                    break;
            }
            lengs.add(len);
        }
        //저장된 연속 길이들 중 최댓값 구하기
        int max = 0;
        for (int i = 1; i < lengs.size(); i++) {
            if (lengs.get(i) > lengs.get(max))
                max = i;
        }

        System.out.println(lengs.get(max));
    }
}
