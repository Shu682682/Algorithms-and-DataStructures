

public class Task2 {
    public static void main(String[] args) {
            String input = "10+20*2";//Ans=50
            String input2="20+10  >*5";
//            String input = "foo/30+7";//Ans=NaN
            String res = solution(input2);
            System.out.println(res);
        }
        //task2
        //T(c)=O(n)
        //S(c)=O(n)
        public static String solution(String input) {
            if(input==null || input.length()==0) return null;
            int currNum = 0;
            int sum = 0;
            String s="NaN";
            char sign='+';
            Stack stack = new Stack();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (Character.isDigit(c)) {//check whether the character is digit
                    currNum=c-'0';
                    //If there are more numbers following the current number, multiply it by 10 and continue checking forward until reaching a non-numeric character."
                    while(i+1<input.length() && Character.isDigit(input.charAt(i+1))){
                        currNum = currNum*10 + input.charAt(i+1) - '0';
                        i++;
                    }
                }
                //Confirm whether it is a non-digit and is not empty, or if it is the last element.
                if (!Character.isDigit(c) && c != ' ' || i == input.length() - 1) {
                    //If the element is addition or subtraction, push it onto the stack.
                    if (sign == '+') {
                        stack.push(currNum);
                    }
                    else if (sign == '-'){
                        stack.push(-currNum);
                    }
                    //If the element is multiplication or division, calculate it first and then push the result in.
                    else if (sign == '*') {
                        stack.push(stack.pop()*currNum);//Pop out the previous element, multiply, and then push it in.
                    }
                    else if (sign == '/') {
                        if(currNum==0) return "NaN";
                        stack.push(stack.pop()/ currNum);//Pop out the previous element, division, and then push it in.
                    }
                    else return s;
                    currNum = 0;
                    sign=c;
                }
            }

            while (!stack.isEmpty()) {
                sum += stack.pop();
            }
            return String.valueOf(sum);
        }
    }
