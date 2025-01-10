package programmers.pccp;

/*
    [PCCP 기출문제] 1번 / 동영상 재생기
     * 언어 : JAVA
     * 수준 : Level 1
 */
public class PCCP_PastQuestion1 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        //Result : "06:55"
        System.out.println(solution.solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"}));
        //"07:22"	"04:05"	"00:15"	"04:07"	["next"]

    }

    public static class Solution {
        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            String answer = alignCurrentPos(pos, video_len);

            //오프닝 시간 확인
            answer = alignOpeningPanel(answer, op_start, op_end);

            for (String command : commands) {
                switch (command) {
                    case "next":
                        String[] nAnswer = answer.split(":");
                        int prevA = Integer.parseInt(nAnswer[0]);
                        int nextA = Integer.parseInt(nAnswer[1]);
                        nextA = nextA + 10;

                        prevA = prevA + (nextA / 60);
                        nextA = nextA % 60;


                        if (prevA < 10) answer = "0" + prevA;
                        else answer = Integer.toString(prevA);
                        if (nextA >= 10) answer = answer + ":" + nextA;
                        else answer = answer + ":0" + nextA;

                        //현재 위치 확인
                        answer = alignCurrentPos(answer, video_len);
                        //오프닝 시간 확인
                        answer = alignOpeningPanel(answer, op_start, op_end);
                        break;
                    case "prev":
                        String[] pAnswer = answer.split(":");
                        int prevB = Integer.parseInt(pAnswer[0]);
                        int nextB = Integer.parseInt(pAnswer[1]);
                        nextB = nextB - 10; // -13


                        if (nextB < 0) {
                            nextB = 60 + nextB;
                            prevB = prevB - 1;
                        }

                        //만약 분이 -1 이 나오면 처음으로 돌아간다.
                        if (prevB < 0) {
                            prevB = 0;
                            nextB = 0;
                        }


                        if (prevB < 10) {
                            answer = "0" + prevB;
                        } else {
                            answer = Integer.toString(prevB);
                        }

                        if (nextB >= 10) {
                            answer = answer + ":" + nextB;
                        } else {
                            answer = answer + ":0" + nextB;
                        }

                        //현재 위치 확인
                        answer = alignCurrentPos(answer, video_len);
                        //오프닝 시간 확인
                        answer = alignOpeningPanel(answer, op_start, op_end);
                        break;
                }

            }

            return answer;
        }

        public String alignOpeningPanel(String pos, String op_start, String op_end) {
            int cur = Integer.parseInt(pos.replace(":", ""));
            int opStartNum = Integer.parseInt(op_start.replace(":", ""));
            int opEndNum = Integer.parseInt(op_end.replace(":", ""));

            if (cur >= opStartNum && cur <= opEndNum)
                return op_end;

            return pos;
        }

        public String alignCurrentPos(String pos, String video_len) {
            String cPos = pos;
            int cPosNum = Integer.parseInt(cPos.replace(":", ""));
            int vlNum = Integer.parseInt(video_len.replace(":", ""));

            if (cPosNum < 10) return "00:00";
            else if (vlNum - cPosNum < 10) return video_len;
            else return cPos;
        }
    }

}

