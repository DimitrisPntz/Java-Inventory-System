/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dimitris_pntz.classwork;

/**
 *
 * @author dimit
 */
public class Item {
    String Name;
    int    Stock;
    
    public Item(String ItemName, int ItemStock){
        Name     = ItemName;
        Stock    = ItemStock;
    }
    
    public void AddNewStock(int NewStock){
        // Add new stock to existing stock
        Stock += NewStock;
        
        System.out.println("New Stock for " + Name + " is: " + Stock);
    }
    
    public Boolean RemoveStock(int StockToRemove){
        // Guard Clause: To Prevent user from having negative stock of an item
        if (StockToRemove > Stock){
            System.out.println("Cannot have negative stock of " + Name);
            return false;
        }
        
        Stock -= StockToRemove;
        System.out.println("New Stock for " + Name + " is: " + Stock);
        
        return true;
    }
    
    public void GetInfo(){
        System.out.println("Name: " + Name + " Stock: " + Stock);
    }
}