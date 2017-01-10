/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_group58;

import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author surya
 */
@SuppressWarnings("serial")
public class StartGUI extends javax.swing.JFrame implements Serializable {

    /**
     * Creates new form StartGUI
     */
    static ArrayList<Course> courseList = new ArrayList<>();
    static ArrayList<Transaction> cashbook = new ArrayList<>();
    static ArrayList<Item> itemList = new ArrayList<>();
    static ArrayList<Student> studentList = new ArrayList<>();
    static ArrayList<Transaction> researchList = new ArrayList<>();
    static ArrayList<Transaction> publicationList = new ArrayList<>();
    static double netIncome = 0.0;
    static double netExpenditure = 0.0;
    static String Transfilename = "TransList.dat";
    static String Itemfilename = "ItemList.dat";
    static String Coursefilename = "CourseList.dat";
    static String Studentfilename = "StudentList.dat";
    static String Resfilename = "ResList.dat";
    static String Pubfilename = "PubList.dat";
    
    static int canDelete = 0;//view course and view items
    static int index_stud = -1;
    static Item modifyItem = new Item();
    static Transaction modifyTransaction = new Transaction();
    static String key = "";//search keyt
    static Object[][] contact_object;
    static int[] index;
    static boolean R_or_P = false;//false corresponds to isPublication
    static int rollIndex = 1;//max roll number size
    static Course viewCourse = new Course();
    static int rollid = 1;//selected roll number
    static String rollID = "0";//used for conversion
    static Student viewStudent = new Student();
    static int attempt = 0;
    
    public StartGUI() {
        
        try   {
            FileInputStream infile = new FileInputStream(Transfilename);
            ObjectInputStream outfile = new ObjectInputStream(infile);
            cashbook = (ArrayList<Transaction>) outfile.readObject();
            //JOptionPane.showMessageDialog(null, "TransList.dat Read successfully");
            infile.close();
            outfile.close();
                        
        }
        catch (FileNotFoundException e) 
		{
           // System.err.println("File not found");
            try{
                File f = new File("TransList.dat");
                //JOptionPane.showMessageDialog(null, "Translist FILE CREATED successfully");
                boolean bool = false;
                bool = f.createNewFile();
                while(bool==false)
                {
                	f.delete();
                	bool = f.createNewFile();
                }
             }catch(HeadlessException | IOException ex){
             }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        try   {
            FileInputStream infile1 = new FileInputStream(Itemfilename);
            ObjectInputStream outfile1 = new ObjectInputStream(infile1);
            itemList = (ArrayList<Item>) outfile1.readObject();
            //JOptionPane.showMessageDialog(null, "ItemList.dat Read successfully");
            //updateCashbook(cashbook);
            infile1.close();
            outfile1.close();
			//JOptionPane.showMessageDialog(null, "I tried");
		}
        catch (FileNotFoundException e) 
		{
           
            try{
                File f = new File("ItemList.dat");
                //JOptionPane.showMessageDialog(null, "Itemlist FILE CREATED successfully");
                boolean bool = false;
                bool = f.createNewFile();
                while(bool==false)
                {
                	f.delete();
                	bool = f.createNewFile();
                }
             }catch(HeadlessException | IOException ex){
             }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try   {
            FileInputStream infile2 = new FileInputStream(Coursefilename);
            ObjectInputStream outfile2 = new ObjectInputStream(infile2);
            courseList = (ArrayList<Course>) outfile2.readObject();
            //JOptionPane.showMessageDialog(null, "CourseList.dat Read successfully");
            //updateCashbook(cashbook);
            infile2.close();
            outfile2.close();
			//JOptionPane.showMessageDialog(null, "I tried");
		}
        catch (FileNotFoundException e) 
		{
           
            try{
                File f = new File("CourseList.dat");
                //JOptionPane.showMessageDialog(null, "Course list FILE CREATED successfully");
                boolean bool = false;
                bool = f.createNewFile();
                while(bool==false)
                {
                	f.delete();
                	bool = f.createNewFile();
                }
             }catch(HeadlessException | IOException ex){
             }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try   {
            FileInputStream infile3 = new FileInputStream(Studentfilename);
            ObjectInputStream outfile3 = new ObjectInputStream(infile3);
            studentList = (ArrayList<Student>) outfile3.readObject();
            rollIndex = studentList.size()+1;
            //JOptionPane.showMessageDialog(null, "StudentList.dat Read successfully");
            //updateCashbook(cashbook);
            infile3.close();
            outfile3.close();
			//JOptionPane.showMessageDialog(null, "I tried");
		}
        catch (FileNotFoundException e) 
		{           
            try{
                File f = new File("StudentList.dat");
                //JOptionPane.showMessageDialog(null, "Student list FILE CREATED successfully");
                boolean bool = false;
                bool = f.createNewFile();
                while(bool==false)
                {
                	f.delete();
                	bool = f.createNewFile();
                }
             }catch(HeadlessException | IOException ex){
             }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try   {
            FileInputStream infile4 = new FileInputStream(Resfilename);
            ObjectInputStream outfile4 = new ObjectInputStream(infile4);
            researchList = (ArrayList<Transaction>) outfile4.readObject();
            //JOptionPane.showMessageDialog(null, "ResList.dat Read successfully");
            infile4.close();
            outfile4.close();
		//JOptionPane.showMessageDialog(null, "I tried");
		}
        catch (FileNotFoundException e) 
		{
            try{
                File f = new File("ResList.dat");
                //JOptionPane.showMessageDialog(null, "res list FILE CREATED successfully");      
                boolean bool = false;
                bool = f.createNewFile();
                while(bool==false)
                {
                	f.delete();
                	bool = f.createNewFile();
                }
             }catch(HeadlessException | IOException ex){
             }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try   {
            FileInputStream infile5 = new FileInputStream(Pubfilename);
            ObjectInputStream outfile5 = new ObjectInputStream(infile5);
            publicationList = (ArrayList<Transaction>) outfile5.readObject();
            //JOptionPane.showMessageDialog(null, "PubList.dat Read successfully");
            infile5.close();
            outfile5.close();
		//JOptionPane.showMessageDialog(null, "I tried");
		}
        catch (FileNotFoundException e) 
		{
           
            try{
                File f = new File("PubList.dat");
                //JOptionPane.showMessageDialog(null, "pub list FILE CREATED successfully");
                boolean bool = false;
                bool = f.createNewFile();
                while(bool==false)
                {
                	f.delete();
                	bool = f.createNewFile();
                }
             }catch(HeadlessException | IOException ex){
             }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initComponents();
        updateCashbook(cashbook);
        updateCashbook(researchList);
        updateCashbook(publicationList);
        updateItemList(itemList);
    }
    
    private void updateCashbook(ArrayList<Transaction> cashbook){
        ArrayList<Transaction> translist = cashbook;
        for(Transaction newTransaction : translist){
            netIncome += newTransaction.getprofit();
            netExpenditure += newTransaction.getinvestment();
            IncField.setText(Double.toString(netIncome));
            ExpField.setText(Double.toString(netExpenditure));
            BalField.setText(Double.toString(netIncome - netExpenditure));
            if(newTransaction.getprofit() != 0){
                updateDebitsArea(newTransaction);
            }
            if(newTransaction.getinvestment() != 0){
                updateCreditsArea(newTransaction);
            }
        }
    }
        
    private void updateItemList(ArrayList<Item> itemlist){
        ArrayList<Item> ItemList = itemlist;
        Transaction itemTrans = new Transaction();
        for(Item newItem : ItemList){
            itemTrans.settitle(newItem.getname());
            itemTrans.setauthority("Inventory"); //need this for search result
            itemTrans.setdetails("Location : "+newItem.getlocation());
            itemTrans.setinvestment(newItem.getprice());
            itemTrans.setprofit(0.0);
            itemTrans.settype("Item");
            
            netIncome += itemTrans.getprofit();
            netExpenditure += itemTrans.getinvestment();
            IncField.setText(Double.toString(netIncome));
            ExpField.setText(Double.toString(netExpenditure));
            BalField.setText(Double.toString(netIncome - netExpenditure));
            if(itemTrans.getprofit() != 0.0){
                updateDebitsArea(itemTrans);
            }
            if(itemTrans.getinvestment() != 0.0){
                updateCreditsArea(itemTrans);
            }
        }
    }
    
    //check if price is numeric
    public static boolean isNumeric(String str)  
    {  
      try  
      {  
           double d = Double.parseDouble(str);  
            if(d<1)
            {
                return false;
            }
      }  
      catch(NumberFormatException nfe)  
      {  
        return false;  
      }  
      return true;  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginPopup = new javax.swing.JFrame();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        LoginPwdError = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        OKButton = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        respubGroup = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        HomePane = new javax.swing.JTabbedPane();
        Hometab = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        welcome = new javax.swing.JLabel();
        iitKgp = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        devLabel = new javax.swing.JLabel();
        sunshineLabel = new javax.swing.JLabel();
        Acadstab = new javax.swing.JPanel();
        Coursepanel = new javax.swing.JPanel();
        AddCourse = new javax.swing.JButton();
        DelCourse = new javax.swing.JButton();
        ViewCourse = new javax.swing.JButton();
        Studentpanel = new javax.swing.JPanel();
        NewStudent = new javax.swing.JButton();
        EnrollStudent = new javax.swing.JButton();
        PrintStudent = new javax.swing.JButton();
        Evaluate = new javax.swing.JButton();
        Inventorytab = new javax.swing.JPanel();
        viewItem = new javax.swing.JButton();
        DelItem = new javax.swing.JButton();
        ModItem = new javax.swing.JButton();
        DispNum = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        itemName = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        itemLocation = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        itemPrice = new javax.swing.JTextField();
        saveItem = new javax.swing.JButton();
        Treasurytab = new javax.swing.JPanel();
        TransType = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PriceField = new javax.swing.JTextField();
        Details = new javax.swing.JScrollPane();
        DetailsArea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        AddTrans = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        TitleField = new javax.swing.JTextField();
        Cashbooktab = new javax.swing.JPanel();
        Logspanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        DebitsArea = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        CreditsArea = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        IncField = new javax.swing.JTextField(Double.toString(netIncome));
        ExpField = new javax.swing.JTextField(Double.toString(netExpenditure));
        BalField = new javax.swing.JTextField(Double.toString(netIncome - netExpenditure));
        ResPubtab = new javax.swing.JPanel();
        ResPubPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        ResRadioButton = new javax.swing.JRadioButton();
        PubRadioButton = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        respubTitle = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        respubAuthority = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        respubDetails = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        respubInvestment = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        respubProfit = new javax.swing.JTextField();
        saveRespub = new javax.swing.JButton();
        ViewResearchButton = new javax.swing.JButton();
        ViewPublicationButton = new javax.swing.JButton();
        Searchtab = new javax.swing.JPanel();
        SearchField = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        SearchResTable = new javax.swing.JTable();
        ViewSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        searchProfit = new javax.swing.JTextField();
        searchInvestment = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchDetails = new javax.swing.JTextArea();
        searchAuthority = new javax.swing.JTextField();
        searchType = new javax.swing.JTextField();
        searchTitle = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();

        LoginPopup.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        LoginPopup.setTitle("Login Page");
        LoginPopup.setMinimumSize(new java.awt.Dimension(240, 127));
        LoginPopup.setResizable(false);

        jButton1.setText("Enter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Password:");

        jLabel3.setText("Login to UDIS");

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginPopupLayout = new javax.swing.GroupLayout(LoginPopup.getContentPane());
        LoginPopup.getContentPane().setLayout(LoginPopupLayout);
        LoginPopupLayout.setHorizontalGroup(
            LoginPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPopupLayout.createSequentialGroup()
                .addGroup(LoginPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginPopupLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LoginPopupLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel3))
                    .addGroup(LoginPopupLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jButton1)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        LoginPopupLayout.setVerticalGroup(
            LoginPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPopupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(LoginPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
        );

        LoginPwdError.setTitle("Password Error");
        LoginPwdError.setLocation(new java.awt.Point(0, 0));
        LoginPwdError.setMinimumSize(new java.awt.Dimension(184, 140));
        LoginPwdError.setResizable(false);

        jLabel1.setText("Incorrect Password Entered");

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginPwdErrorLayout = new javax.swing.GroupLayout(LoginPwdError.getContentPane());
        LoginPwdError.getContentPane().setLayout(LoginPwdErrorLayout);
        LoginPwdErrorLayout.setHorizontalGroup(
            LoginPwdErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPwdErrorLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1))
            .addGroup(LoginPwdErrorLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        LoginPwdErrorLayout.setVerticalGroup(
            LoginPwdErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPwdErrorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(OKButton)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");

        HomePane.setName("Home"); // NOI18N
        HomePane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomePaneMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        welcome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        welcome.setText("Welcome to IIT KGP Department Information System");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(welcome)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        iitKgp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assignment5_group58/kgp_blur.png"))); // NOI18N
        iitKgp.setText("s");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Date and Time"));

        date.setText("date");

        time.setText("time");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(time, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(time, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Developers"));

        devLabel.setText("Kaustubh Hiware");

        sunshineLabel.setText("Surya Midatala");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(devLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sunshineLabel)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(devLabel)
                    .addComponent(sunshineLabel))
                .addContainerGap())
        );

        javax.swing.GroupLayout HometabLayout = new javax.swing.GroupLayout(Hometab);
        Hometab.setLayout(HometabLayout);
        HometabLayout.setHorizontalGroup(
            HometabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HometabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HometabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HometabLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(HometabLayout.createSequentialGroup()
                        .addComponent(iitKgp, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(HometabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HometabLayout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(24, 24, 24))
                            .addGroup(HometabLayout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))))
        );
        HometabLayout.setVerticalGroup(
            HometabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HometabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HometabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iitKgp, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addGroup(HometabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        HomePane.addTab("Home", Hometab);

        Coursepanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Course"));
        Coursepanel.setToolTipText("Course1");
        Coursepanel.setFont(Coursepanel.getFont().deriveFont(Coursepanel.getFont().getStyle() | java.awt.Font.BOLD));
        Coursepanel.setName("Course"); // NOI18N

        AddCourse.setText("Add Course");
        AddCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCourseActionPerformed(evt);
            }
        });

        DelCourse.setText("Delete Course");
        DelCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelCourseActionPerformed(evt);
            }
        });

        ViewCourse.setText("View Course");
        ViewCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewCourseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CoursepanelLayout = new javax.swing.GroupLayout(Coursepanel);
        Coursepanel.setLayout(CoursepanelLayout);
        CoursepanelLayout.setHorizontalGroup(
            CoursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CoursepanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(CoursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ViewCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DelCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        CoursepanelLayout.setVerticalGroup(
            CoursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CoursepanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(AddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DelCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(ViewCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Studentpanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Student"));

        NewStudent.setText("New Student");
        NewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewStudentActionPerformed(evt);
            }
        });

        EnrollStudent.setText("Enroll Student");
        EnrollStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnrollStudentActionPerformed(evt);
            }
        });

        PrintStudent.setText("Print Student");
        PrintStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StudentpanelLayout = new javax.swing.GroupLayout(Studentpanel);
        Studentpanel.setLayout(StudentpanelLayout);
        StudentpanelLayout.setHorizontalGroup(
            StudentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentpanelLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(StudentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EnrollStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PrintStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NewStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(66, 66, 66))
        );
        StudentpanelLayout.setVerticalGroup(
            StudentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentpanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(NewStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EnrollStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(PrintStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Evaluate.setText("Enter Credits");
        Evaluate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvaluateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AcadstabLayout = new javax.swing.GroupLayout(Acadstab);
        Acadstab.setLayout(AcadstabLayout);
        AcadstabLayout.setHorizontalGroup(
            AcadstabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AcadstabLayout.createSequentialGroup()
                .addGroup(AcadstabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AcadstabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Coursepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Studentpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AcadstabLayout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(Evaluate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AcadstabLayout.setVerticalGroup(
            AcadstabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AcadstabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AcadstabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Coursepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Studentpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(Evaluate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        HomePane.addTab("Academics", Acadstab);

        viewItem.setText("View all");
        viewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewItemActionPerformed(evt);
            }
        });

        DelItem.setText("Delete Item");
        DelItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelItemActionPerformed(evt);
            }
        });

        ModItem.setText("Modify Details");
        ModItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModItemActionPerformed(evt);
            }
        });

        DispNum.setText("Display by Numbers");
        DispNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DispNumActionPerformed(evt);
            }
        });

        jLabel12.setText("Name : ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("New item");

        jLabel14.setText("Location :");

        jLabel15.setText("Price : ");

        itemPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPriceActionPerformed(evt);
            }
        });

        saveItem.setText("Save");
        saveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemName)
                    .addComponent(itemLocation)
                    .addComponent(itemPrice)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(saveItem, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 102, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addComponent(saveItem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout InventorytabLayout = new javax.swing.GroupLayout(Inventorytab);
        Inventorytab.setLayout(InventorytabLayout);
        InventorytabLayout.setHorizontalGroup(
            InventorytabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventorytabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(InventorytabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DispNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DelItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ModItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        InventorytabLayout.setVerticalGroup(
            InventorytabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventorytabLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(viewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DelItem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ModItem, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(DispNum, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(InventorytabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        HomePane.addTab("Inventory", Inventorytab);

        TransType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grant", "Fund", "Non Inventory Expenture" }));
        TransType.setToolTipText("Select a transaction type");
        TransType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransTypeActionPerformed(evt);
            }
        });

        jLabel4.setText("Transaction Type:");

        jLabel5.setText("Price:");

        DetailsArea.setColumns(20);
        DetailsArea.setRows(5);
        Details.setViewportView(DetailsArea);

        jLabel6.setText("Details:");

        AddTrans.setText("Add Transaction");
        AddTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTransActionPerformed(evt);
            }
        });

        jLabel29.setText("Title :");

        javax.swing.GroupLayout TreasurytabLayout = new javax.swing.GroupLayout(Treasurytab);
        Treasurytab.setLayout(TreasurytabLayout);
        TreasurytabLayout.setHorizontalGroup(
            TreasurytabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TreasurytabLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(TreasurytabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TreasurytabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6))
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TreasurytabLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(9, 9, 9)))
                .addGap(26, 26, 26)
                .addGroup(TreasurytabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Details)
                    .addComponent(AddTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PriceField)
                    .addComponent(TransType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TitleField))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        TreasurytabLayout.setVerticalGroup(
            TreasurytabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TreasurytabLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(TreasurytabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(TreasurytabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TransType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TreasurytabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(PriceField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TreasurytabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Details, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(AddTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        HomePane.addTab("Treasury", Treasurytab);

        Logspanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Logs"));
        Logspanel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel10.setText("Debit");

        DebitsArea.setColumns(20);
        DebitsArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        DebitsArea.setRows(5);
        jScrollPane4.setViewportView(DebitsArea);

        CreditsArea.setColumns(20);
        CreditsArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        CreditsArea.setRows(5);
        jScrollPane5.setViewportView(CreditsArea);

        jLabel11.setText("Credit");

        javax.swing.GroupLayout LogspanelLayout = new javax.swing.GroupLayout(Logspanel);
        Logspanel.setLayout(LogspanelLayout);
        LogspanelLayout.setHorizontalGroup(
            LogspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogspanelLayout.createSequentialGroup()
                .addGroup(LogspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LogspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addGroup(LogspanelLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        LogspanelLayout.setVerticalGroup(
            LogspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogspanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LogspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LogspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );

        jLabel7.setText("Income :");

        jLabel8.setText("Expenditure :");

        jLabel9.setText("Balance :");

        javax.swing.GroupLayout CashbooktabLayout = new javax.swing.GroupLayout(Cashbooktab);
        Cashbooktab.setLayout(CashbooktabLayout);
        CashbooktabLayout.setHorizontalGroup(
            CashbooktabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CashbooktabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logspanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(CashbooktabLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addGroup(CashbooktabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CashbooktabLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BalField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CashbooktabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(CashbooktabLayout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ExpField))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CashbooktabLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(IncField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CashbooktabLayout.setVerticalGroup(
            CashbooktabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CashbooktabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CashbooktabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(IncField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CashbooktabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ExpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CashbooktabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(BalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Logspanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        HomePane.addTab("Cash book", Cashbooktab);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Research / Publication");

        respubGroup.add(ResRadioButton);
        ResRadioButton.setSelected(true);
        ResRadioButton.setText("Research");

        respubGroup.add(PubRadioButton);
        PubRadioButton.setText("Publication");

        jLabel17.setText("Title :");

        jLabel18.setText("In-charge :");

        jLabel19.setText("Details :");

        respubDetails.setColumns(20);
        respubDetails.setRows(5);
        jScrollPane1.setViewportView(respubDetails);

        jLabel20.setText("Investment :");

        jLabel21.setText("Profit :");

        saveRespub.setText("Save");
        saveRespub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveRespubActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ResPubPanelLayout = new javax.swing.GroupLayout(ResPubPanel);
        ResPubPanel.setLayout(ResPubPanelLayout);
        ResPubPanelLayout.setHorizontalGroup(
            ResPubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResPubPanelLayout.createSequentialGroup()
                .addGroup(ResPubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ResPubPanelLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ResPubPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(ResPubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ResPubPanelLayout.createSequentialGroup()
                                .addComponent(ResRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(PubRadioButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(ResPubPanelLayout.createSequentialGroup()
                                .addGroup(ResPubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel17)
                                    .addGroup(ResPubPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel21)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ResPubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(respubTitle)
                                    .addComponent(respubAuthority)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                    .addComponent(respubInvestment)
                                    .addComponent(respubProfit)
                                    .addGroup(ResPubPanelLayout.createSequentialGroup()
                                        .addComponent(saveRespub, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(27, 27, 27))
        );
        ResPubPanelLayout.setVerticalGroup(
            ResPubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResPubPanelLayout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ResPubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PubRadioButton)
                    .addComponent(ResRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ResPubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(respubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ResPubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(respubAuthority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ResPubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ResPubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(respubInvestment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ResPubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(respubProfit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addComponent(saveRespub, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ViewResearchButton.setText("View Research");
        ViewResearchButton.setMaximumSize(new java.awt.Dimension(105, 25));
        ViewResearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewResearchButtonActionPerformed(evt);
            }
        });

        ViewPublicationButton.setText("View Publication");
        ViewPublicationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewPublicationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ResPubtabLayout = new javax.swing.GroupLayout(ResPubtab);
        ResPubtab.setLayout(ResPubtabLayout);
        ResPubtabLayout.setHorizontalGroup(
            ResPubtabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResPubtabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ResPubPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(ResPubtabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ViewResearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ViewPublicationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        ResPubtabLayout.setVerticalGroup(
            ResPubtabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ResPubPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ResPubtabLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(ViewResearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(ViewPublicationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        HomePane.addTab("Research/Publication", ResPubtab);

        SearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchFieldKeyReleased(evt);
            }
        });

        SearchResTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Type"
            }
        ));
        jScrollPane7.setViewportView(SearchResTable);

        ViewSearch.setText("View");
        ViewSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewSearchActionPerformed(evt);
            }
        });

        jLabel22.setText("Title :");

        jLabel23.setText("In-charge :");

        jLabel24.setText("Details :");

        jLabel25.setText("Investment :");

        jLabel26.setText("Profit :");

        jLabel27.setText("Type :");

        searchDetails.setColumns(20);
        searchDetails.setRows(5);
        jScrollPane2.setViewportView(searchDetails);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Search Result");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchProfit))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel22)
                        .addComponent(jLabel27)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchInvestment)
                    .addComponent(searchAuthority)
                    .addComponent(searchType)
                    .addComponent(searchTitle)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(searchTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(searchAuthority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(searchInvestment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(searchProfit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel24))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout SearchtabLayout = new javax.swing.GroupLayout(Searchtab);
        Searchtab.setLayout(SearchtabLayout);
        SearchtabLayout.setHorizontalGroup(
            SearchtabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchtabLayout.createSequentialGroup()
                .addGroup(SearchtabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchtabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(SearchtabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(SearchField, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)))
                    .addGroup(SearchtabLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(ViewSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        SearchtabLayout.setVerticalGroup(
            SearchtabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchtabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ViewSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        HomePane.addTab("Search", Searchtab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomePane, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(HomePane, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateDebitsTextArea(final String text) {
    SwingUtilities.invokeLater(() -> {
        DebitsArea.append(text);
    });
    }
    
    private void updateCreditsTextArea(final String text) {
    SwingUtilities.invokeLater(() -> {
        CreditsArea.append(text);
    });
    }
    
    private void redirectSystemStreamstoDeb() {
    OutputStream out;
        out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                updateDebitsTextArea(String.valueOf((char) b));
            }
            
            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateDebitsTextArea(new String(b, off, len));
            }
            
            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };
 
    System.setOut(new PrintStream(out, true));
    System.setErr(new PrintStream(out, true));
    }
    
    private void redirectSystemStreamstoCred() {
    OutputStream out;
        out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                updateCreditsTextArea(String.valueOf((char) b));
            }
            
            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateCreditsTextArea(new String(b, off, len));
            }
            
            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };
 
    System.setOut(new PrintStream(out, true));
    System.setErr(new PrintStream(out, true));
    }
    
    //revert system streams
    
    private void revertstream(){
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
    
    //updating debits area
    private void updateDebitsArea(Transaction debit){
        redirectSystemStreamstoDeb();
        //System.out.println("\n______________________________");
        System.out.printf("Transaction Title: " + debit.gettitle());
        System.out.printf("\nProfit:" + debit.getprofit());
        System.out.printf("\nTransaction Details: " + debit.getdetails());
        System.out.println("\n____________________________");
        revertstream();
    }
    
    private void updateCreditsArea(Transaction credit){
        redirectSystemStreamstoCred();
        //System.out.println("\n______________________________");
        System.out.printf("Transaction Title: " + credit.gettitle());
        System.out.printf("\nInvestment:" + credit.getinvestment());
        System.out.println("\nTransaction Details: " + credit.getdetails());
        System.out.println("____________________________");
        revertstream();
    }
       
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String pwd = new String(this.jPasswordField1.getPassword());
        if (pwd.equals("admin")) {  //security threat !!                  
            this.LoginPopup.setVisible(false);
            this.setVisible(true);
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            this.time.setText(sdf.format(d));
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
            this.date.setText(sdf1.format(d));
        } else {
            this.LoginPwdError.setLocationRelativeTo(null);
            this.LoginPwdError.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        String pwd = new String(this.jPasswordField1.getPassword());
        if (pwd.equals("admin")) {      //security threat !!              
            this.LoginPopup.setVisible(false);
            this.setVisible(true);
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            this.time.setText(sdf.format(d));
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
            this.date.setText(sdf1.format(d));
        } else {
            this.LoginPwdError.setLocationRelativeTo(null);
            this.LoginPwdError.setVisible(true);
        }
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void TransTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TransTypeActionPerformed

    private void AddCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCourseActionPerformed
        AddCourseGUI newcoursegui;
        //todo : add exceptions here
        //try {
        newcoursegui = new AddCourseGUI(courseList);
        newcoursegui.setLocationRelativeTo(null);
        newcoursegui.setVisible(true);
        //optional 
        //setVisible(false);
        /*} catch (FileNotFoundException ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }//GEN-LAST:event_AddCourseActionPerformed

    
    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        this.LoginPwdError.setVisible(false);
    }//GEN-LAST:event_OKButtonActionPerformed

    private void DelCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelCourseActionPerformed
        ViewCourseGUI coursegui;
        //todo : add exceptions here
        //try {
        canDelete = 1;
        coursegui = new ViewCourseGUI(courseList,studentList,canDelete,viewCourse);
        coursegui.setLocationRelativeTo(null);
        coursegui.setTitle("Delete Course");
        coursegui.setVisible(true);
        //optional
        //setVisible(false);
        /*} catch (FileNotFoundException ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        //WriteCourse newwrite = new WriteCourse(courseList, Coursefilename);
    }//GEN-LAST:event_DelCourseActionPerformed

    private void ViewCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewCourseActionPerformed
        ViewCourseGUI coursegui;
        //todo : add exceptions here
        //try {
        canDelete = 0;
        coursegui = new ViewCourseGUI(courseList,studentList, canDelete,viewCourse);
        coursegui.setLocationRelativeTo(null);
        coursegui.setTitle("View Course");
        coursegui.setVisible(true);
        //optional
        //setVisible(false);
        /*} catch (FileNotFoundException ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_ViewCourseActionPerformed

    private void EvaluateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvaluateActionPerformed
        GradeStudentsGUI newgradegui;
        //todo : add exceptions here
        //try {
        newgradegui = new GradeStudentsGUI(courseList,studentList);
        newgradegui.setLocationRelativeTo(null);
        newgradegui.setTitle("Enter Grades");
        newgradegui.setVisible(true);
        //optional 
        //setVisible(false);
        /*} catch (FileNotFoundException ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_EvaluateActionPerformed

    private void NewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewStudentActionPerformed
        AddStudentGUI newgui;
        //todo : add exceptions here
        //try {
        newgui = new AddStudentGUI(studentList,rollIndex);
        newgui.setLocationRelativeTo(null);
        newgui.setVisible(true);
        //optional 
        //setVisible(false);
        /*} catch (FileNotFoundException ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_NewStudentActionPerformed

    private void AddTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTransActionPerformed
        // TODO add your handling code here:
        Transaction newTransaction = new Transaction();
        String selected = (String) TransType.getSelectedItem();
        
        if(TitleField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Need to enter title !");
        }
        else if(PriceField.getText().isEmpty()||!isNumeric(PriceField.getText())){
             JOptionPane.showMessageDialog(null, "Need to enter price correctly !");
        }
        else
        {
            newTransaction.settitle(TitleField.getText());
            newTransaction.setauthority("Treasurer");
            newTransaction.settype(selected);
            newTransaction.setdetails(DetailsArea.getText());
            
            if(selected.equals("Non Inventory Expenture"))
            {
                newTransaction.setprofit(0.0);
                newTransaction.setinvestment(Double.parseDouble(PriceField.getText()));
            }
            else
            {
                newTransaction.setinvestment(0.0);
                newTransaction.setprofit(Double.parseDouble(PriceField.getText()));
            }
            //transaction must be saved
            netIncome += newTransaction.getprofit();
            netExpenditure += newTransaction.getinvestment();
            cashbook.add(newTransaction);
            
           // JOptionPane.showMessageDialog(null,"Type : "+selected+" profit "
           //+newTransaction.getprofit()+" invest "+newTransaction.getinvestment());
           JOptionPane.showMessageDialog(null, "Current income = "+netIncome+
                   "\nCurrent expenditure : "+netExpenditure+
                   "\nCurrent balance : "+(netIncome - netExpenditure));
           
          // JOptionPane.showMessageDialog(null,"Title "+newTransaction.gettitle());
           if(netIncome < netExpenditure)
           {
               JOptionPane.showMessageDialog(null,"Negative balance! Suggested to add grant/fund");
           }
           //update incfiels and expfield
           IncField.setText(Double.toString(netIncome));
           ExpField.setText(Double.toString(netExpenditure));
           BalField.setText(Double.toString(netIncome - netExpenditure));
        
            if(newTransaction.getinvestment() == 0.0){
                updateDebitsArea(newTransaction);
            }else if(newTransaction.getprofit() == 0.0){
                updateCreditsArea(newTransaction);
            }
        
        WriteTrans newwrite = new WriteTrans(cashbook, Transfilename);
        
        //clear textfield for redundant saving
        TitleField.setText("");
        PriceField.setText("");
        DetailsArea.setText("");
        }
    }//GEN-LAST:event_AddTransActionPerformed

    private void saveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveItemActionPerformed
       // TODO add your handling code here:
        Item newItem = new Item();
        Transaction itemTrans = new Transaction();
        
        if(itemName.getText().isEmpty())
       {
            JOptionPane.showMessageDialog(null,"Need to enter name!");
        }
        else if(itemLocation.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Need to enter location!");
        }
        else if(itemPrice.getText().isEmpty()||!isNumeric(itemPrice.getText()))
        {
            JOptionPane.showMessageDialog(null,"Need to enter price correctly!");
        }
        else//non are empty
        {
            newItem.setname(itemName.getText());
            newItem.setlocation(itemLocation.getText());
            newItem.setprice(Double.parseDouble(itemPrice.getText()));
            itemList.add(newItem);
            JOptionPane.showMessageDialog(null,"Item "+newItem.getname()+" has been added!");
            
            itemTrans.settitle(newItem.getname());
            itemTrans.setauthority("Inventory"); //need this for search result
            itemTrans.setdetails("Location : "+newItem.getlocation());
            itemTrans.setinvestment(newItem.getprice());
            itemTrans.setprofit(0.0);
            itemTrans.settype("Item");
            
            netExpenditure += itemTrans.getinvestment();
            cashbook.add(itemTrans);
            JOptionPane.showMessageDialog(null, "Current income = "+netIncome+
                   "\nCurrent expenditure : "+netExpenditure+
                   "\nCurrent balance : "+(netIncome - netExpenditure));
           
           if(netIncome < netExpenditure)
           {
               JOptionPane.showMessageDialog(null,"Negative balance! Suggested to add grant/fund");
           }
           
           //update incfiels and expfield
           IncField.setText(Double.toString(netIncome));
           ExpField.setText(Double.toString(netExpenditure));
           BalField.setText(Double.toString(netIncome - netExpenditure));
           updateCreditsArea(itemTrans);
           WriteItem newwrite = new WriteItem(itemList, Itemfilename);
           WriteTrans newwrite2 = new WriteTrans(cashbook, Transfilename);
           //clear textfield to prevent accidental saving items
           itemName.setText("");
           itemLocation.setText("");
           itemPrice.setText("");
        }
        
    }//GEN-LAST:event_saveItemActionPerformed

    
    private void viewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewItemActionPerformed
        // TODO add your handling code here:
        canDelete = 0;
        ViewItemGUI newgui = new ViewItemGUI(itemList,cashbook,canDelete,modifyItem,modifyTransaction);
        //updateItemList(itemList);
        newgui.setLocationRelativeTo(null);
        newgui.setVisible(true);
        
    }//GEN-LAST:event_viewItemActionPerformed

    private void DelItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelItemActionPerformed
        // TODO add your handling code here:
                canDelete = 1;
        ViewItemGUI newgui = new ViewItemGUI(itemList,cashbook,canDelete,modifyItem,modifyTransaction);
        updateItemList(itemList);
        newgui.setLocationRelativeTo(null);
        newgui.setVisible(true);
    }//GEN-LAST:event_DelItemActionPerformed

    private void itemPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPriceActionPerformed
        // TODO add your handling code here:
        Item newItem = new Item();
        Transaction itemTrans = new Transaction();
        
        if(itemName.getText().isEmpty())
       {
            JOptionPane.showMessageDialog(null,"Need to enter name!");
        }
        else if(itemLocation.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Need to enter location!");
        }
        else if(itemPrice.getText().isEmpty()||!isNumeric(itemPrice.getText()))
        {
            JOptionPane.showMessageDialog(null,"Need to enter price correctly!");
        }
        else//non are empty
        {
            newItem.setname(itemName.getText());
            newItem.setlocation(itemLocation.getText());
            newItem.setprice(Double.parseDouble(itemPrice.getText()));
            itemList.add(newItem);
            JOptionPane.showMessageDialog(null,"Item "+newItem.getname()+" has been added!");
            
            itemTrans.settitle(newItem.getname());
            itemTrans.setauthority("Inventory"); //need this for search result
            itemTrans.setdetails("Location : "+newItem.getlocation());
            itemTrans.setinvestment(newItem.getprice());
            itemTrans.setprofit(0.0);
            itemTrans.settype("Item");
            
            netExpenditure += itemTrans.getinvestment();
            cashbook.add(itemTrans);
            JOptionPane.showMessageDialog(null, "Current income = "+netIncome+
                   "\nCurrent expenditure : "+netExpenditure+
                   "\nCurrent balance : "+(netIncome - netExpenditure));
           
           if(netIncome < netExpenditure)
           {
               JOptionPane.showMessageDialog(null,"Negative balance! Suggested to add grant/fund");
           }
           
           //update incfiels and expfield
           IncField.setText(Double.toString(netIncome));
           ExpField.setText(Double.toString(netExpenditure));
           BalField.setText(Double.toString(netIncome - netExpenditure));
           updateCreditsArea(itemTrans);
           WriteItem newwrite = new WriteItem(itemList, Itemfilename);
           WriteTrans newwrite2 = new WriteTrans(cashbook, Transfilename);
           //clear textfield to prevent accidental saving items
           itemName.setText("");
           itemLocation.setText("");
           itemPrice.setText("");
        }
        
    }//GEN-LAST:event_itemPriceActionPerformed

    private void ModItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModItemActionPerformed
        // TODO add your handling code here:
        canDelete = -1;
        ViewItemGUI newgui = new ViewItemGUI(itemList,cashbook,canDelete,modifyItem,modifyTransaction);
        
        
        //updateItemList(itemList);
        //updateCashbook(cashbook);
        newgui.setLocationRelativeTo(null);
        newgui.setVisible(true);
        
    }//GEN-LAST:event_ModItemActionPerformed

    private void DispNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DispNumActionPerformed
        // TODO add your handling code here:
        ItemNumGUI numgui = new ItemNumGUI(itemList);
        numgui.setLocationRelativeTo(null);
        numgui.setVisible(true);
    }//GEN-LAST:event_DispNumActionPerformed

    private void saveRespubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveRespubActionPerformed
        // TODO add your handling code here:
        Transaction newResPub = new Transaction();
        if(respubTitle.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Enter name !");
        }
        else if(respubAuthority.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Enter name of in-charge !");
        }
        else if(!isNumeric(respubInvestment.getText()) && !respubInvestment.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Enter numerical investment!- 0 if none ");
        }
        else if(!isNumeric(respubProfit.getText()) && !respubProfit.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Enter numerical profit!- 0 if none ");
        }
        else
        {//minimum details are present
            if(ResRadioButton.isSelected())
            {
                newResPub.settype("Research");
            }
            else
            {
                newResPub.settype("Publication");
            }
            
            newResPub.settitle(respubTitle.getText());
            newResPub.setauthority(respubAuthority.getText());
            newResPub.setdetails(respubDetails.getText() + "\nAuthority:" + respubAuthority.getText() + "\nType: " + newResPub.gettype());
           
            if(respubInvestment.getText().isEmpty()){
                newResPub.setinvestment(0.0);
            }
            else{
                newResPub.setinvestment(Double.parseDouble(respubInvestment.getText()));
            }
            if(respubProfit.getText().isEmpty()){
                newResPub.setprofit(0.0);
            }
            else{
                newResPub.setprofit(Double.parseDouble(respubProfit.getText()));
            }
            //transaction must be saved
            netIncome += newResPub.getprofit();
            netExpenditure += newResPub.getinvestment();
            cashbook.add(newResPub);
           JOptionPane.showMessageDialog(null,newResPub.gettype()+" "+newResPub.gettitle()+" added!");
           
           JOptionPane.showMessageDialog(null, "Current income = "+netIncome+
                   "\nCurrent expenditure : "+netExpenditure+
                   "\nCurrent balance : "+(netIncome - netExpenditure));
           
           if(netIncome < netExpenditure)
           {
               JOptionPane.showMessageDialog(null,"Negative balance! Suggested to add grant/fund");
           }
           //update incfiels and expfield
           IncField.setText(Double.toString(netIncome));
           ExpField.setText(Double.toString(netExpenditure));
           BalField.setText(Double.toString(netIncome - netExpenditure));
           
            updateCreditsArea(newResPub);
            updateDebitsArea(newResPub);
            if(newResPub.gettype().equals("Research"))
            {
                researchList.add(newResPub);
                WriteResearch newwrite = new WriteResearch(researchList, Resfilename);
            }
            else
            {
                publicationList.add(newResPub);
                WritePub newwrite = new WritePub(publicationList, Pubfilename);
            }
            WriteTrans newwrite2 = new WriteTrans(cashbook, Transfilename);
            
            //clear all fields
            respubTitle.setText("");
            respubAuthority.setText("");
            respubDetails.setText("");
            respubInvestment.setText("");
            respubProfit.setText("");
        }
        
    }//GEN-LAST:event_saveRespubActionPerformed

    private void ViewResearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewResearchButtonActionPerformed
        // TODO add your handling code here:
        R_or_P = false;
        ViewResPubGUI rpgui = new ViewResPubGUI(researchList,publicationList,R_or_P);
        rpgui.setLocationRelativeTo(null);
        rpgui.setVisible(true);
    }//GEN-LAST:event_ViewResearchButtonActionPerformed

    private void ViewPublicationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewPublicationButtonActionPerformed
        // TODO add your handling code here
        R_or_P = true;
        ViewResPubGUI rpgui = new ViewResPubGUI(researchList,publicationList,R_or_P);
        rpgui.setLocationRelativeTo(null);
        rpgui.setVisible(true);
    }//GEN-LAST:event_ViewPublicationButtonActionPerformed

    private void EnrollStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnrollStudentActionPerformed
        EnrollStudentGUI newgui;
        //todo : add exceptions here
        //try {
        newgui = new EnrollStudentGUI(studentList,courseList);
        newgui.setLocationRelativeTo(null);
        //newgui.setTitle("Select Course");
        newgui.setVisible(true);
        //optional 
        //setVisible(false);
        /*} catch (FileNotFoundException ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_EnrollStudentActionPerformed

    private void ViewSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewSearchActionPerformed
        
        int select =  SearchResTable.getSelectedRow();
        if(select==-1)
        {
            JOptionPane.showMessageDialog(null, "Select a transaction first!");
        }
        else
        {
            Transaction interest = cashbook.get(index[select]);
            searchTitle.setText(interest.gettitle());
            searchType.setText(interest.gettype());
            searchAuthority.setText(interest.getauthority());
            searchDetails.setText(interest.getdetails());
            searchInvestment.setText(Double.toString(interest.getinvestment()));
            searchProfit.setText(Double.toString(interest.getprofit()));
        }
    }//GEN-LAST:event_ViewSearchActionPerformed

    private void HomePaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomePaneMouseClicked
        // TODO add your handling code here:
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        this.time.setText(sdf.format(d));
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        this.date.setText(sdf1.format(d));
        ImageIcon img = new ImageIcon("/assignment5_group58/icon.jpg");
        this.setIconImage(img.getImage());
        //iitKgp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assignment5_group58/kgp_blur.png")));
    }//GEN-LAST:event_HomePaneMouseClicked

    private void validateRollID()
    {
        attempt++;
        rollID = JOptionPane.showInputDialog("Roll numbers are from 1 to "+(rollIndex-1)+"\nEnter roll number of student ");
        try
        {
            rollid = Integer.parseInt(rollID.trim());
            if(rollid < 1 || rollid > rollIndex-1)
            {
                if(attempt < 6){
                validateRollID();
                }
            }
        }
        catch (NumberFormatException nfe)
        {
            //System.out.println("NumberFormatException: " + nfe.getMessage());
            JOptionPane.showMessageDialog(null,"Need to enter number!");
            if(attempt > 6){
            validateRollID();
            }
        } 

    }
    
    private void PrintStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintStudentActionPerformed
        // validate input outside
        attempt = 0;//this is used to ensure the user does not keep on wasting time
        validateRollID();
        if(attempt < 6)
        {
            PrintStudentGUI newgui;
            newgui = new PrintStudentGUI(studentList.get(rollid-1));
            newgui.setLocationRelativeTo(null);
            newgui.setVisible(true);
        }
    }//GEN-LAST:event_PrintStudentActionPerformed

    private void SearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFieldKeyReleased
        // TODO add your handling code here:
        
        if(SearchField.getText().isEmpty())
        {
            key = "";
        } 
        else
        {
            key = SearchField.getText();
        }
        String[] columns = {"Name","Type"};
	int foundSize = 0;
	int i;
	for(i = 0; i < cashbook.size() ; i++)
        {
            
            if(cashbook.get(i).gettitle().toLowerCase().contains(key.toLowerCase())||
                    cashbook.get(i).gettitle().toLowerCase().startsWith(key.toLowerCase()))
            {
		foundSize++;
               //JOptionPane.showMessageDialog(null,key+" in "+cashbook.get(i).gettitle());
            }
            else
            {
                 //JOptionPane.showMessageDialog(null,key+" not in "+cashbook.get(i).gettitle());
                 //JOptionPane.showMessageDialog(null,cashbook.get(i).gettitle().toLowerCase().startsWith(key)+"<bool");
            }
	}
        index = new int[foundSize];
	contact_object  = new String[foundSize][2];
	int j =0;
		
	for(i = 0; i < cashbook.size(); i++)
	{
            if (cashbook.get(i).gettitle().toLowerCase().contains(key.toLowerCase())||
                    cashbook.get(i).gettitle().toLowerCase().startsWith(key.toLowerCase())) 
            { 
                Transaction found = cashbook.get(i);
                
                index[j] = i;
                contact_object[j][0] = found.gettitle();
                contact_object[j][1] = found.gettype();
                j++;
            }
        }
        SearchResTable = new javax.swing.JTable(contact_object,columns);
        jScrollPane7.setViewportView(SearchResTable);    
    }//GEN-LAST:event_SearchFieldKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    //javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    String laf = javax.swing.UIManager.getSystemLookAndFeelClassName();
                    javax.swing.UIManager.setLookAndFeel(laf);
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            StartGUI s = new StartGUI();
            s.LoginPopup.setLocationRelativeTo(null);
            s.LoginPopup.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Acadstab;
    private javax.swing.JButton AddCourse;
    private javax.swing.JButton AddTrans;
    public static javax.swing.JTextField BalField;
    private javax.swing.JPanel Cashbooktab;
    private javax.swing.JPanel Coursepanel;
    private javax.swing.JTextArea CreditsArea;
    private javax.swing.JTextArea DebitsArea;
    private javax.swing.JButton DelCourse;
    private javax.swing.JButton DelItem;
    private javax.swing.JScrollPane Details;
    private javax.swing.JTextArea DetailsArea;
    private javax.swing.JButton DispNum;
    private javax.swing.JButton EnrollStudent;
    private javax.swing.JButton Evaluate;
    public static javax.swing.JTextField ExpField;
    private javax.swing.JTabbedPane HomePane;
    private javax.swing.JPanel Hometab;
    public static javax.swing.JTextField IncField;
    private javax.swing.JPanel Inventorytab;
    private javax.swing.JFrame LoginPopup;
    private javax.swing.JDialog LoginPwdError;
    private javax.swing.JPanel Logspanel;
    private javax.swing.JButton ModItem;
    private javax.swing.JButton NewStudent;
    private javax.swing.JButton OKButton;
    private javax.swing.JTextField PriceField;
    private javax.swing.JButton PrintStudent;
    private javax.swing.JRadioButton PubRadioButton;
    private javax.swing.JPanel ResPubPanel;
    private javax.swing.JPanel ResPubtab;
    private javax.swing.JRadioButton ResRadioButton;
    private javax.swing.JTextField SearchField;
    private javax.swing.JTable SearchResTable;
    private javax.swing.JPanel Searchtab;
    private javax.swing.JPanel Studentpanel;
    private javax.swing.JTextField TitleField;
    private javax.swing.JComboBox<String> TransType;
    private javax.swing.JPanel Treasurytab;
    private javax.swing.JButton ViewCourse;
    private javax.swing.JButton ViewPublicationButton;
    private javax.swing.JButton ViewResearchButton;
    private javax.swing.JButton ViewSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel date;
    private javax.swing.JLabel devLabel;
    private javax.swing.JLabel iitKgp;
    private javax.swing.JTextField itemLocation;
    private javax.swing.JTextField itemName;
    private javax.swing.JTextField itemPrice;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField respubAuthority;
    private javax.swing.JTextArea respubDetails;
    private javax.swing.ButtonGroup respubGroup;
    private javax.swing.JTextField respubInvestment;
    private javax.swing.JTextField respubProfit;
    private javax.swing.JTextField respubTitle;
    private javax.swing.JButton saveItem;
    private javax.swing.JButton saveRespub;
    private javax.swing.JTextField searchAuthority;
    private javax.swing.JTextArea searchDetails;
    private javax.swing.JTextField searchInvestment;
    private javax.swing.JTextField searchProfit;
    private javax.swing.JTextField searchTitle;
    private javax.swing.JTextField searchType;
    private javax.swing.JLabel sunshineLabel;
    private javax.swing.JLabel time;
    private javax.swing.JButton viewItem;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}

