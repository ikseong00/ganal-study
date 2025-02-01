package example.baekJoon.no32713;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 1;
        int length = scanner.nextInt();
        int deleteCount = scanner.nextInt();

        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i <= deleteCount; i++) {
            int continuousLength = findMax(arr.clone(), i); // i개 삭제했을 때 최대 연속 길이
            if (continuousLength > max) {
                max = continuousLength;
            }
        }

        System.out.println(max);
    }

    // 최대 연속길이 찾기
    private static int findMax(int[] arr, int deleteCount) {
        int max = 1;

        if (deleteCount != 0) {
            for (int i = 0; i < arr.length; i++) {
                int len = 1;
                int count = deleteCount;

                if (arr[i] == arr[i+1]) {
                    len++;
                } else if (arr[i] == arr[i+2]) {
                    len++;
                    count--;
                    if (count == 0) {
                        break;
                    }
                }

                if (len > max) {
                    max = len;
                }
            }
        } else {
            max = findContinuousLength(arr); // deleteCount == 0
        }

        return max;
    }

    // 연속길이 구하기
    private static int findContinuousLength(int[] arr) {
        int[][] splitArr = new int[arr.length][];
        splitArr[0] = new int[] { arr[0] };
        int row = 0; // 분해한 수열 개수 - 1

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == arr[i+1]) { // i가 현재 원소 i+1이 다음 원소
                splitArr[row] = new int[splitArr[row].length + 1];
                Arrays.fill(splitArr[row], arr[i + 1]);
            } else {
                row++;
                splitArr[row] = new int[] { arr[i+1] };
            }
        }

        int max = 1;
        for (int i = 0; i < row+1; i++) {
            if (splitArr[i].length > max) {
                max = splitArr[i].length;
            }
        }

        return max;
    }

}
