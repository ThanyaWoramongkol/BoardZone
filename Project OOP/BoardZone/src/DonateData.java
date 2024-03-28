/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pc
 */

public class DonateData extends javax.swing.JPanel{
    private String name, detail;
    private double price;
    
    public String getName(){
        return name;
    }
    public String getDetail(){
        return detail;
    }
    public double getPrice(){
        return price;
    }
    public void setDefault(String name, String detail, double price){
        this.name = name;
        this.detail = detail;
        this.price = price;
    } 
    public void setName(String name){
        this.name = name;
    }
    public void setDetail(String detail){
        this.detail = detail;
    }
    public void setPrice(double price){
        this.price = price;
    }
}
