class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k=0;

        for(char c:s.toCharArray())
        {
            if(Character.isDigit(c))
            {
                k=k*10+(c-'0');
            }
            else if(c=='[')
            {
                countStack.push(k);
                stringStack.push(current);
                k=0;
                current=new StringBuilder();
            }
            else if(c==']')
            {
                int repeatCount=countStack.pop();
                StringBuilder decodeString=stringStack.pop();
                for(int i=0;i<repeatCount;i++)
                {
                    decodeString.append(current);
                }
                current=decodeString;
            }
            else
            {
                current.append(c);
            }
        }
        return current.toString();
    }
}