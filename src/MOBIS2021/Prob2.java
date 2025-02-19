package MOBIS2021;

/**
 * 어떤 문자열 s가 주어졌을 때, 당신은 이 s가 다음과 같은 규칙을 활용하여 만들어낼 수 있는 문자열인지 판별하는 프로그램을 작성하고자 합니다. 규칙은 다음과 같습니다.
 *  *
 *  * 맨 처음에는 한 글자짜리 문자열 "a"로 시작합니다.
 *  * 3번 규칙을 0번 이상 반복합니다.
 *  * 현재 문자열에 있는 'a'의 개수를 x라고 할 때, 다음 두 행동 중 하나를 합니다.
 *  * 문자열의 양 옆에 각각 x개만큼의 'b'를 추가합니다. 예를 들어, 현재 문자열이 "aba"라면 이 행동을 취한 뒤 문자열은 "bbababb"가 됩니다.
 *  * 문자열의 맨 앞 또는 맨 뒤에 'a'를 추가합니다. 예를 들어, 현재 문자열이 "aba"라면 이 행동을 취한 뒤 문자열은 "aaba" 또는 "abaa"가 됩니다.
 *  * "abab"는 "a" → "bab" → "abab" 로 만들어낼 수 있습니다.
 *  * "bbaa"는 주어진 규칙으로 만들어낼 수 없는 문자열입니다.
 *  * "bababa"는 주어진 규칙으로 만들어낼 수 없는 문자열입니다.
 *  * "bbbabababbbaa"는 "a" → "bab" → "abab" → "ababa" → "bbbabababbb" → "bbbabababbba" → "bbbabababbbaa" 로 만들어낼 수 있습니다.
 *  * 문자열 배열 a가 매개변수로 주어집니다. a에 있는 모든 문자열에 대해 해당 문자열이 주어진 규칙을 활용하여 만들어낼 수 있는 문자열이면 참값을, 그렇지 않다면 거짓값을 차례대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 */

import java.util.*;

public class Prob2 {

    static public boolean[] solution(String[] a) {
        boolean[] answer = new boolean[a.length];
        for(int i = 0; i < a.length; i++){
            String cur = a[i];
            int cntB = 0;
            int cntA = 0;
            //우선 a 제거
            for(int j = 0; cur.length() > 0; ){
                if(cur.charAt(j) == 'b' && cur.charAt(cur.length()-1-j) == 'b') break;
                else {
                    if(cur.charAt(j) == 'a') cur = cur.substring(j+1);
                    if(cur.charAt(cur.length()-1-j) == 'a') cur=cur.substring(0,cur.length()-1);
                }
            }
            while(cur.length() > 0){
                if(cur.charAt(0) == 'b' && cur.charAt(cur.length()-1) == 'b') {
                    cntB += 1;
                    cur = cur.substring(1,cur.length()-1);
                    continue;
                }
                else if(cur.charAt(0) == 'a') {
                    cntA +=1;
                    cur = cur.substring(1);
                }
                else if(cur.charAt(cur.length()-1) == 'a') {
                    cntA += 1;
                    cur = cur.substring(0, cur.length()-1);
                }
            }
            answer[i] = cntB == cntA;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"bbbabababbbaa"}));
    }

}
