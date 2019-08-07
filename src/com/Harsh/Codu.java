package com.Harsh;

import java.math.BigInteger;
import java.util.Scanner;

public class Codu {
    public static long findSteps(long bg){
       // BigInteger two=new BigInteger ( "2" );
//        if(bg==1 || bg==0){
//            return 1;
//        }
//        else if(bg==2){
//            return 2;
//        }
//        else {
//            return findSteps ( bg-3 )+findSteps ( bg-2 )+findSteps ( bg-1 );
//        }
        long[] sum=new long[(int)bg+1];
        sum[0]=1;
        sum[1]=1;
        sum[2]=2;
        for(int i=3;i<=bg;i++){
            sum[i]=sum[i-1]+sum[i-2]+sum[i-3];
        }
        return sum[(int)bg];
    }
    public static void main ( String[] args ) {
        Scanner sc=new Scanner(System.in);
        //String res=sc.nextLine ();
        long bg=sc.nextLong ();
        sc.close();

    long res1=findSteps(bg);
        System.out.println (res1%1000000007 );



    }
}
