/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp503assignment3;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author xuchang
 */
public class NewClass {
    
    private int num = 123;
    private String n = "asc";
    private Color b;
    private ArrayList aa;
    
    public NewClass(){
        
b= new Color(1);

        
        
        aa = new ArrayList();
        aa.add(num);
        aa.add(n);
        aa.add(b);
        System.out.println(aa.get(0));
        System.out.println(aa.get(1));
        System.out.println(aa.get(2));
        

        
 
    }
    
    public static void main(String[] args) {
        NewClass a = new NewClass();
        
    }
}
