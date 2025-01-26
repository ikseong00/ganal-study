package baekjoon.q32713;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        int size; //수열 길이
        int del; // 삭제 가능한 원소의 개수
        Scanner scan=new Scanner(System.in);
        List<Integer> lengs=new ArrayList<>();
        size =scan.nextInt();
        del= scan.nextInt();
        scan.nextLine();

        List<Integer> list=new ArrayList<>();
        for(int i = 0; i< size; i++){
            list.add(scan.nextInt());
        }

        for(int i=0;i<size;i++){
            int count=del; //삭제한 횟수
            int len=1; //연속 길이

            for(int j=i+1;j<size;j++){
                if(list.get(j).equals(list.get(i))){
                    len++;
                }
                else count--;
                if(count<0)
                    break;
            }
           lengs.add(len);
        }

        int max=0;

        for(int i=1;i<lengs.size();i++){
            if(lengs.get(i)>lengs.get(max))
                max=i;
        }
        System.out.println(lengs.get(max));






    }
}
