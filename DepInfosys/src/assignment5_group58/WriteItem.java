/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_group58;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author surya
 */
public class WriteItem {
    public WriteItem(ArrayList<Item> ItemList,String file)
    {
        try {
        	FileOutputStream fileOut = new FileOutputStream(file); 
        	ObjectOutputStream Output = new ObjectOutputStream(fileOut);
            
        	Output.writeObject(ItemList);

    		//JOptionPane.showMessageDialog(null, "saved successfully");

           // System.out.println("Stored in database"); 
            fileOut.close(); 
            Output.close();
        }
        catch (FileNotFoundException e) 
        { 
    		JOptionPane.showMessageDialog(null, "save error");

            //System.err.println("File not found");
        }
        catch (IOException e)
        {
    		JOptionPane.showMessageDialog(null, "saved error IO ");
    		throw new RuntimeException(e);

        	//System.err.println("Read or write failed");
        }
    }
}
