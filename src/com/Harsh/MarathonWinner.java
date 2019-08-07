package com.Harsh;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class MarathonWinner {
    public static int participantIs(int noOfParticipant, int TotalTime, String[] StepData) {
        String Steps[] = new String[noOfParticipant];
        for (int i = 0; i < noOfParticipant; i++) {
            String res = String.valueOf(StepData[i].charAt(StepData[i].length() - 1));
            Steps[i] = res;

        }
        String StepData1[] = new String[StepData.length];
        for (int i = 0; i < noOfParticipant; i++) {
            String res = StepData[i];
            StepData1[i] = res.substring(0, res.length() - 1);
        }
        // System.out.println(Arrays.toString(Steps));
        // System.out.println(Arrays.toString(StepData1));

        List<int[]> lists = new ArrayList<>();
        for (String str : StepData1) {
            String[] participant = new String[StepData1.length];
            participant = str.substring(0, str.length() - 1).split(" ");
            int[] intValues = new int[participant.length];
            for (int i = 0; i < participant.length; i++) {
                intValues[i] = Integer.parseInt(participant[i]);
            }
            // System.out.println(Arrays.toString(intValues));
            lists.add(intValues);
        }

        List<Integer> leadingValue = new ArrayList<>();
        int finalVal[] = new int[lists.size()];
        for (int y = 0; y < lists.size(); y++) {
            leadingValue.add(0);
        }

        int value1 = 0;
        for (int i = 0; i < lists.get(0).length; i++) {

            for (int y = 0; y < lists.size(); y++) {
                finalVal[y] += Integer.parseInt(Steps[y]) * lists.get(y)[i];
                // value1 += Integer.parseInt(StepData[y]) * lists.get(y)[i];
                if (value1 < finalVal[y]) {
                    value1 = finalVal[y];
                }
            }
            for (int y = 0; y < lists.size(); y++) {
                if (value1 == finalVal[y]) {
                    leadingValue.set(y, leadingValue.get(y) + 1);
                }

            }
        }
        // System.out.println(Arrays.toString(finalVal));
        // System.out.println(leadingValue);

        return (maxIndex(leadingValue) + 1);
    }

    public static int maxIndex(List<Integer> list) {
        Integer i=0, maxIndex=-1, max=null;
        for (Integer x : list) {
            if ((x!=null) && ((max==null) || (x>max))) {
                max = x;
                maxIndex = i;
            }
            i++;
        }
        return maxIndex;
    }



    // 3
    // 8
    // 2 2 4 3 5 2 6 2 3
    // 3 5 7 4 3 9 3 2 2
    // 1 2 4 2 7 5 3 2 4
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstLine = sc.nextLine();
        String secondLine = sc.nextLine();
        int numberOfParticipant = Integer.parseInt(firstLine);
        int totalTimeofSprint = Integer.parseInt(secondLine);
        // System.out.println (numberOfParticipant );
        // System.out.println (totalTimeofSprint );
        String stepsData[] = new String[numberOfParticipant];
        for (int i = 0; i < numberOfParticipant; i++) {
            stepsData[i] = sc.nextLine();
        }
        sc.close();
        System.out.println(participantIs(numberOfParticipant, totalTimeofSprint, stepsData));
    }
}
