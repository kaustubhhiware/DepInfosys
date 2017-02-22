/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_group58;

/**
 *
 * @author kaustubh
 */
import java.io.Serializable;

@SuppressWarnings("serial")
public class Item implements Serializable {
    
    private String name;
    private String location;
    private Double price;

    public void setname(String naam)
    {
	this.name = naam;
    };
    public String getname()
    {
	return name;
    };
  
    public void setlocation(String place)
    {
	this.location = place;
    };
    public String getlocation()
    {
	return location;
    };
    
    public void setprice(Double cost)
    {
	this.price = cost;
    };
    public Double getprice()
    {
	return price;
    };
}
