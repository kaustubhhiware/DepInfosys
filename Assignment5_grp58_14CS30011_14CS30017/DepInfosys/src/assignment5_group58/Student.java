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
import java.util.ArrayList;
import java.io.Serializable;


@SuppressWarnings("serial")
public class Student implements Serializable
{
	private String name; 
	private String address;
	private String phone;
	private String mail;
	private int roll;
        private int prevCredits = 0;
        private int currCredits = 0;        
        public  ArrayList<Course> subjects = new ArrayList<>();
        public ArrayList<String> status = new ArrayList<>();
      	public  ArrayList<Double> sgpa = new ArrayList<>();
        public  ArrayList<Double> cgpa = new ArrayList<>();
        public ArrayList<Integer> grades = new ArrayList<>();
        public ArrayList<Integer> semSize = new ArrayList<>();
        public double cg = 0.0;
        public double sg = 0.0;
	public void setname(String naam)
	{
		this.name = naam;
	};
	public String getname()
	{
		return name;
	};
	public void setplace(String location)
	{
		this.address = location;
	};
	public String getplace()
	{
		return address;
	};
	
	public void setnumber(String num)
	{
		this.phone = num;
	};
	public String getnumber()
	{
		return phone;
	};
        
	public void setmail(String mail)
	{
		this.mail = mail;
	};
	public String getmail()
	{
		return mail;
	};
        
	public void setroll(int regnum)
	{
		this.roll = regnum;
	};
	public int getroll()
	{
		return roll;
	};
        
        public void setprevCredits(int totalCredits)
	{
		this.prevCredits = totalCredits;
	};
	public int getprevCredits()
	{
		return prevCredits;
	};
	
        public void setcurrCredits(int totalCredits)
	{
		this.currCredits = totalCredits;
	};
	public int getcurrCredits()
	{
		return currCredits;
	};
        
        public boolean AllGraded()
        {
            int i;
            for(i = 0; i < subjects.size();i++)
            {
                if(status.get(i).equals("current"))//check for each current course
                {
                    if(grades.get(i)==-1)//if any current course is not graded
                    {
                        return false;
                    }
                }
            }
            return true;
        };
        
        public boolean isClear(String Subject)
        {
            int i;
            for(i = 0; i < subjects.size();i++)
            {
                if(subjects.get(i).getname().equals(Subject))//check for each course
                {
                    if(grades.get(i)<5)//if course found , has insufficient grade
                    {
                        return false;// assuming grade below 5 is fail
                        //may need to check this at a later stage
                    }
                }
            }
            return true;
        }
  
        //called internally in code, hence assumed AllGraded is true
        public void updateCourses()
        {
            int i;
            for(i = 0; i < subjects.size();i++)
            {
                if(status.get(i).equals("current"))//check for each current course
                {
                    if(grades.get(i)>4)//if current course is passed
                    {
                        status.set(i, "clear");//get(i).setstatus("clear");
                    }
                    else//course is graded since AllGraded is true , and grade < 5
                    {
                        status.set(i, "backlog");//subjects.get(i).setstatus("backlog");
                    }
                }
            }
        }
        
        //return crredits of all courses marked current - mostly for testing
        public int getStudyingCredits()
        {
            int i;
            int count = 0;
            for(i = 0; i < subjects.size();i++)
            {
                if(status.get(i).equals("current"))//check for each current course
                {
                    count += this.subjects.get(i).getcredit();
                }
            }
            
            return count;
        }
            
}
