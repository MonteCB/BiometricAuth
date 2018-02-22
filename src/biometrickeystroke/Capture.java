/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometrickeystroke;

import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Monte
 */
public class Capture implements KeyListener{
    
    
    ArrayList<String> codePressed;
    ArrayList<String> codeReleased;  
    ArrayList<Long> timePressed;
    ArrayList<Long> timeReleased;

    
    public Capture() {
        codePressed = new ArrayList();
        codeReleased = new ArrayList();
        timePressed = new ArrayList();
        timeReleased = new ArrayList();
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        System.out.print("");
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        timePressed.add(System.currentTimeMillis());
        codePressed.add(KeyEvent.getKeyText(ke.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        timeReleased.add(System.currentTimeMillis());
        codeReleased.add(KeyEvent.getKeyText(ke.getKeyCode()));
    }
    
    
    public void clear() {
        codePressed.clear();
        timePressed.clear();
        codeReleased.clear();
        timeReleased.clear();
        
        
    }
    
    public void keyPressDetail() {
        int t;
        System.out.print("Time Difference of Two keys-");
        for(int i = 1; i < timePressed.size(); i++) {
            t = (int) (timePressed.get(i) - timePressed.get(i - 1));
            System.out.print(t + " ");
        }
        System.out.print("   Time Difference of press and release of each key-");
        for(int i = 0; i < timeReleased.size(); i++) {
            t = (int) (timeReleased.get(i) - timePressed.get(i));
            System.out.print(t + " ");
        }
        System.out.print("   Keys-");
        for(int i = 0; i < codePressed.size(); i++) {
            System.out.print(codePressed.get(i) + " ");
        }
        System.out.println("");
    }
    
    public Integer[] getPressedDiff() {
        Integer[] t = new Integer[timePressed.size() - 1];
        for(int i = 1; i < timePressed.size(); i++) {
            t[i - 1] = (int) (timePressed.get(i) - timePressed.get(i - 1));
        }
        return t;
    }
    
    public String getPressedKeys() {
        String t = "";
        for(int i = 0; i < codePressed.size() - 1; i++) {
            t = t + codePressed.get(i) + " ";
        }
        t = t + codePressed.get(codePressed.size() - 1);
        
        return t;
    }
    
    public Integer[] getReleasedDiff() {
        Integer[] t = new Integer[timeReleased.size() - 1];
        for(int i = 1; i < timeReleased.size(); i++) {
            t[i - 1] = (int) (timeReleased.get(i) - timeReleased.get(i - 1));
        }
        return t;
    }
    
    public String[] getReleasedKeys() {
        String[] t = new String[codeReleased.size()];
        for(int i = 0; i < codeReleased.size(); i++) {
            t[i] = codeReleased.get(i);
        }
        return t;
    }
    
    public Integer[] getDiff() {
        Integer[] t = new Integer[timePressed.size()];
        for(int i = 0; i < timePressed.size(); i++) {
            t[i] = (int) (timePressed.get(i) - timeReleased.get(i));
        }
        return t;
    }
    
    
    
    
    
    
}
