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
public class Transaction implements Serializable
{
    private String title;
    private String authority;
    private String details;
    private Double investment;
    private Double profit;
    private String type;

    public void settitle(String topic)
    {
	this.title = topic;
    };
    public String gettitle()
    {
	return title;
    };
  
    public void setauthority(String coordi)
    {
	this.authority = coordi;
    };
    public String getauthority()
    {
	return authority;
    };
    
    public void setdetails(String info)
    {
	this.details = info;
    };
    public String getdetails()
    {
	return details;
    };
    
     public void setinvestment(Double expend)
    {
	this.investment = expend;
    };
    public Double getinvestment()
    {
	return investment;
    };
  
    public void setprofit(Double benefit)
    {
	this.profit = benefit;
    };
    public Double getprofit()
    {
	return profit;
    };
    
    public void settype(String typecasted)
    {
	this.type = typecasted;
    };
    public String gettype()
    {
	return type;
    };
    
}
