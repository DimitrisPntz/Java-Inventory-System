/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dimitris_pntz.classwork;

/**
 *
 * @author dimit
 */
import java.util.Scanner;
import dimitris_pntz.classwork.Item;

public class Classwork {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        Item[] Inventory = new Item[5];
        boolean ArrayFilled = false;
        
        int INVENTORYSIZE = 5;
        int IndexToUse = 0;
        
        while (true){
            System.out.println("What Would you like to do?: ");
            String Action = Scan.nextLine();

            if (Action.equals("ADD NEW ITEM")){
                //Guard Clause: Checks if Index to use is 4 then it will ask the user for where to put the item
                if(ArrayFilled){
                    System.out.println("Index to replace");
                    IndexToUse = Scan.nextInt();
                }

                // Get the New Items Name and Stock
                System.out.println("Item Name and Item Stock.");
                String NewItemInfo = Scan.nextLine();

                //Split the String to get the info
                String[] info = NewItemInfo.split(" ");

                // Make the Item and Update the Index to use
                Inventory[IndexToUse] = new Item(info[0], Integer.parseInt(info[1]));
                Inventory[IndexToUse].GetInfo();
                IndexToUse++;

                //Check if IndexToUse is 4 and turn on the flag for it
                if(IndexToUse == INVENTORYSIZE - 1){ArrayFilled = true;}

            }else if(Action.equals("ADD NEW STOCK")){
                System.out.println("Index to change and Stock");
                String NewStockInfo = Scan.nextLine();

                //Split the String to get the info
                String[] info = NewStockInfo.split(" ");

                int ItemIndex     = Integer.parseInt(info[0]);
                int ItemNewStock  = Integer.parseInt(info[1]);

                Inventory[ItemIndex].AddNewStock(ItemNewStock);
            }else if(Action.equals("REMOVE STOCK")){
                while (true){
                    System.out.println("Index to change and Stock");
                    String NewStockInfo = Scan.nextLine();

                    //Split the String to get the info
                    String[] info = NewStockInfo.split(" ");

                    int ItemIndex     = Integer.parseInt(info[0]);
                    int ItemNewStock  = Integer.parseInt(info[1]);

                    Boolean success = Inventory[ItemIndex].RemoveStock(ItemNewStock);

                    if(success){
                        System.out.println("Successfully changed inventory for item");
                        Inventory[ItemIndex].GetInfo();
                    }else{
                        System.out.println("Cannot have negative inventory!");
                    }
                }
            }else if(Action.equals("GET INVENTORY INFO")){
                for(int i=0;i<INVENTORYSIZE;i++){
                    Inventory[i].GetInfo();
                }
                
            }else if(Action.equals("EXIT")){
                break;
            }
        }
    }
}
