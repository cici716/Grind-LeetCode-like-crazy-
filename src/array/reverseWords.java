package src.array;

public class reverseWords {
    public String reverseWords(String s) {
        s = s.trim();
        int j=s.length()- 1;
        int i=j;
        StringBuilder sb=new StringBuilder();
        while(i>=0){
            while (i>=0 && s.charAt(i)!=' '){
                i--;
            }
            sb.append(s.substring(i+1,j+1)).append(" ");

            while (i>=0&&s.charAt(i)==' '){
                i--;
            }
            j=i;
        }

        return sb.toString().trim();

    }
}
