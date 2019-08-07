package com.Harsh;

public class RomanIntegers {

        public static int romanToInt(String s) {
//         String arr[]=s.split("");
//         int sum=0;
//         for(int i=0;i<arr.length;){
//             if(arr[i].equals("I") && i+1<arr.length && !arr[i+1].equals("I")){
//                 if(arr[i+1].equals("V")){
//                     sum+=4;

//                     }
//               if(arr[i+1].equals("X")){
//                     sum+=9;

//                     }
//                 i=i+2;
//                 }
//             else if(arr[i].equals("X") && i+1<arr.length && !arr[i+1].equals("X")){
//                 if(arr[i+1].equals("L")){
//                     sum+=40;

//                     }
//              if(arr[i+1].equals("C")){
//                     sum+=90;

//                     }
//                 i=i+2;
//                 }
//              else if(arr[i].equals("C") && i+1<arr.length && !arr[i+1].equals("C")){
//                 if(arr[i+1].equals("D")){
//                     sum+=400;

//                     }
//               if(arr[i+1].equals("M")){
//                     sum+=900;

//                     }
//                 i=i+2;
//                 }
//             else{
//         switch(arr[i]){
//             case "I":      sum+=1; break;
//             case "V":      sum+=5; break;
//             case "X":      sum+=10; break;
//             case "L":      sum+=50; break;
//             case "C":   sum+=100;   break;
//             case "D":   sum+=500;   break;
//             case "M":     sum+=1000; break;
//             }
//             i++;
//         }
//         }
//      return sum;
            // int sum=0;
            // char c[]=s.toCharArray();
            // int arr[]=new int[90];
            // arr['I']=1;
            // arr['V']=5;
            // arr['X']=10;
            // arr['L']=50;
            // arr['C']=100;
            // arr['D']=500;
            // arr['M']=1000;
            // for(int i=0;i< c.length;i++){
            //     int curr=arr[c[i]];
            //     if(i<arr.length-1 && arr[c[i]]>curr){
            //         sum-=curr;
            //     }
            //     else{
            //         sum+=curr;
            //     }
            // }
            // return sum;
            int sum = 0;
            int[] arr = new int[90]; //cause 'Z' ascii is 90;
            arr['I'] = 1; arr['V'] = 5; arr['X'] = 10; arr['L'] = 50;
            arr['C'] = 100; arr['D'] = 500; arr['M'] = 1000;

            char[] c = s.toCharArray();

            for(int i = 0; i < c.length; i++){
                int curr = arr[c[i]];
                if(i<c.length - 1 && arr[c[i+1]] > curr){
                    sum -= curr;
                }
                else{
                    sum += curr;
                }
            }
            System.out.println (sum );
            return sum;
        }

    public static void main ( String[] args ) {
     romanToInt ( "XVII" );

    }
}
