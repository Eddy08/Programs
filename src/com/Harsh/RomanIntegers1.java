package com.Harsh;

import java.util.ArrayList;
import java.util.Scanner;

public class RomanIntegers1 {
    public static String convertInttoRoman(long numbers){
        int number=(int)numbers;
        String M_String[] = {"","M","MM","MMM"};

        String C_String[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};

        String X_String[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};

        String I_String[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};


        String thousand= M_String[number/1000];

        String hundered= C_String[(number%1000)/100];

        String ten=X_String[(number%100)/10];

        String ones=I_String[number%10];

        String res = thousand+hundered+ten+ones;

       System.out.println (res );
        return res;
    }


    public static long InttoRoman(long number){
        if(number >3999){
            return number;
        }
        else{
            String res=convertInttoRoman((int)number);
            String placeToValues[]={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
            char maxCharacter='0';
            for(int i=0;i<res.length ();i++){
                if(res.charAt ( i )>maxCharacter){
                    maxCharacter=res.charAt ( i );
                }
            }
            int index=0;
          for(int i=0;i<placeToValues.length;i++){
              if(placeToValues[i].equals ( String.valueOf ( maxCharacter ) )){
                  index=i;
              }
          }
          long res_number=0;
            ArrayList<String> al=new ArrayList<> (  );
            for(int i=0;i<placeToValues.length;i++){
                al.add ( placeToValues[i] );
            }
          System.out.println (index );
            int count=0;
          for(int i=res.length ()-1;i>=0;i--){

              res_number+=(long)(Math.pow ( index+1,i)*(al.indexOf (String.valueOf (   res.charAt ( count )) )));
             // System.out.println (res_number );
              count++;
          }
            System.out.println (res_number );
          return InttoRoman ( res_number );

            }
        }

    public static void main ( String[] args ) {
        Scanner sc =new Scanner ( System.in );
        long number=sc.nextLong ();

        if(0<=number && number <= 3999){
            System.out.println ( InttoRoman(number));
        }
    }
}
