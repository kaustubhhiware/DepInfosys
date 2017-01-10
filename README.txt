------------------------------------------------------------------------
This is the project README file
------------------------------------------------------------------------



PROJECT TITLE:University_Department_Information_System

PURPOSE OF PROJECT:Assignment

VERSION or DATE:09 Apr 2016



HOW TO START THIS PROJECT:

Initially , try to run DepInfosys.jar .In ubuntu , you might have to write this in terminal

cd <location>
sudo chmod a+x DepInfosys.jar 

If none of this works , start it in the default way by running in Eclipse/NetBeans



AUTHORS:Kaustubh Hiware , 14CS30011


USER INSTRUCTIONS:



>>The password is "admin" without the quotes.



>>StartGUI.java is the main file . We have used a tabbed pane approach with this project
,
where seperate popups come for specific activities.



>>I have used some images as well.



>>When viewing a popup, you may directly click the close button as the Home Pane is always visible.



>>The records of each session are recorded using Serialisation in .dat files.
One may find
 some records in history folder.



>>Academics tab is used to add courses , add student , enroll them in available courses , 

checking that a student may not enroll in  a previously cleared subject.



>>Enter credits provides a window to enter the student grades.On clicking a course , all the students
 currently enrolled in it are displayed . By default , grade = -1.
A slider is used to grade the student
 as this removes the scope of invalid grade.



>>Print student first asks for the roll number to be viewed , in the given range.

Once entered , it pulls out the courses of the student , which are cleared , current or backlog .
Sem-wise CGPA ans SGPA is also kept track of.On clicking on "save as file ",the application generates a 
text file titled "rollnumber_semnumber.txt" which contains the data present in the table as well as the
 student's personal details.
The txt file may then be processed further as per requirement.



>>The user may not delete a course if  student is currently enrolled in it.However , cleared and backlog subjects
 may be removed.



>>The inventory is used for keeping track of the furniture and resources in the department. 
If one requires to store more details , you may sae it as a transaction in Treasury.



>>Cashbook pane is used to keep track of all finances . , mainly the income , expenditure 
 and balance .
 Whenever negative balance is encountered, a warning is displayed.
Also , one may check all the individual logs 
for debit and credit here .
 


>>Research and Publications can be stored/viewed in their tab.
Each research may/may not have investment and/or profit.
Hence  , if those fields are left empty , it is assumed 0.

>>Search operation is similar to search option in phones. 
E.g : If I just enter r in the textfield and click enter , all transactions containing r will be displayed.
	

						-X-