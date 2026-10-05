/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktekweek3;

/**
 *
 * @author Lenovo
 */
public class Circle01 {
    public static final double PI = 3.1459;
    
    public static double radiansToDegrees(double rads){
        return rads * 180 / PI;  
    }
    
    public double r;
    
    public double area(){
        return PI * r * r;
    }
    
    public double circumference(){
        return 2 * PI * r;
    }
}
