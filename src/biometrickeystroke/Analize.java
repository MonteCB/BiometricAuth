/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometrickeystroke;

import java.util.ArrayList;

/**
 *
 * @author Monte
 */
public class Analize {
    
    public Integer analyzed(Integer[] currentPress, Integer[] currentDiff, ArrayList<Integer[]> storePress, ArrayList<Integer[]> storeDiff) {
        int max = 0;
        int point = 0;
        for (int j = 0; j < storePress.size(); j++) {
            int t1 = compare(currentPress, storePress.get(j), 10);
            int t2 = compare(currentDiff, storeDiff.get(j), 1);
            int t = t1 + t2;
            System.out.println(Integer.toString(t));
            if (t > max) {
                max = t;
                point = j + 1;
            }
        }
        return point;
    }
    
    private Integer compare(Integer[] current, Integer[] stored, int error) {
        int marks = 0;
        for(int i = 0; i < current.length; i++) {
            if ((current[i] - stored[i] < error) && (current[i] - stored[i] > -error)) {
                marks++;
            }
        }
        return marks;
    }
}
