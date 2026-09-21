package src.array;

public class convert {
    public String convert(String s, int numRows) {
     if(numRows<2||s.length()<numRows){return s;}
     StringBuilder [] rows=new StringBuilder[numRows];
     for(int i=0;i<numRows;i++){
         rows[i]=new StringBuilder();
     }
     int curRow=0,dir=-1;
     for(char c:s.toCharArray()){
         rows[curRow].append(c);
         if(curRow==0||curRow==numRows-1){
             dir=-dir;

         }
         curRow+=dir;
     }
     for(int i=1;i<numRows;i++){
         rows[0].append(rows[i]);

     }
        return rows[0].toString();
    }
}
