/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_group58;

import static assignment5_group58.StartGUI.courseList;
import static assignment5_group58.StartGUI.studentList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author kaustubh
 */
@SuppressWarnings("serial")
public class EnrollStudentGUI extends javax.swing.JFrame implements Serializable{

    private static int studentSelect = -1;

    /**
     * Creates new form SelectStudentGUI
     * @param studentList
     * @param courseList
     */
    public EnrollStudentGUI(ArrayList<Student> studentList , ArrayList<Course> courseList) {
        newinitComponents(studentList,courseList);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        availField = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        NameList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        currentField = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        availList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        currentList = new javax.swing.JList<>();
        AddCourseButton = new javax.swing.JButton();
        SelectStudentButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Enroll Student");

        availField.setText("Available courses");

        NameList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        NameList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(NameList);

        jLabel2.setText("Student");

        currentField.setText("Current courses of student");

        availList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        availList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(availList);

        currentList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(currentList);

        AddCourseButton.setText("Add course");
        AddCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCourseButtonActionPerformed(evt);
            }
        });

        SelectStudentButton.setText("Enroll");
        SelectStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectStudentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(SelectStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(availField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AddCourseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(currentField, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(availField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(currentField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddCourseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(SelectStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    static ArrayList<Course> applicableCourses = new ArrayList<>();
    static List<Integer> index = new ArrayList<>();
    static ArrayList<Course> currentCourses = new ArrayList<>();
    
    @SuppressWarnings("unchecked")
      private void newinitComponents(ArrayList<Student> studentList,ArrayList<Course> courseList) {

        availField = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        NameList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        currentField = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        availList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        currentList = new javax.swing.JList<>();
        AddCourseButton = new javax.swing.JButton();
        SelectStudentButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Enroll Student");

       availField.setText("Available courses");
        String[] names = new String[studentList.size()];
        DefaultListModel<String> model;
        model = new DefaultListModel<>();
        for(int n=0;n<studentList.size();n++)
        {
            names[n] = studentList.get(n).getname();
            model.add(n, names[n]);
        }
        
        NameList.setModel(model);
        NameList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        //NameList.setModel(new javax.swing.AbstractListModel<String>() {model});
        jScrollPane2.setViewportView(NameList);

        jLabel2.setText("Student");

        currentField.setText("Current courses of student");

        /*availList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });*/
        availList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(availList);

        /*currentList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });*/
        currentList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(currentList);

        AddCourseButton.setText("Add course");
        AddCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCourseButtonActionPerformed(evt);
            }
        });

        SelectStudentButton.setText("Enroll");
        SelectStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectStudentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(SelectStudentButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(availField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(currentField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddCourseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(availField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddCourseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(SelectStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
    }
    
    private void AddCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCourseButtonActionPerformed
        // TODO add your handling code here:
        int courseselect = availList.getSelectedIndex();
        if(courseselect==-1)
        {
            JOptionPane.showMessageDialog(null,"Need to select a course first!");
        }
        else
        { 
            //add current student's name in course for grading
            courseList.get(index.get(courseselect)).StudentsOnRoll.add(studentSelect+1);
            JOptionPane.showMessageDialog(null, studentList.get(studentSelect).getname()+
                    " added to "+courseList.get(index.get(courseselect)).getname());
            
            Course newCourse = new Course();
            newCourse = courseList.get(index.get(courseselect));
            //JOptionPane.showMessageDialog(null,newCourse.getstudentsonroll()+"<size");
            removeApplicable(courseselect); //remove from applicable course
            newCourse.setstatus("current");//update status
            studentList.get(studentSelect).subjects.add(newCourse);
            updateCurrentList();
        }
    }//GEN-LAST:event_AddCourseButtonActionPerformed

    //set current courses for updated list 
    private void updateCurrentList()
    {
        DefaultListModel<String> modelcurrent;
        modelcurrent = new DefaultListModel<>();
        currentCourses = new ArrayList<>();
        if(!studentList.get(studentSelect).subjects.isEmpty())
        {
            int subjectsize = studentList.get(studentSelect).subjects.size();
            for(int a=0;a<subjectsize;a++)
            {
                if(studentList.get(studentSelect).subjects.get(a).getstatus().equals("current"))
                //course is not in particular student's cleared course list
                {
                    currentCourses.add(studentList.get(studentSelect).subjects.get(a));
                }
            }
            
            String[] Ongoing = new String[currentCourses.size()];
            //DefaultListModel modelcurrent = new DefaultListModel();
            for(int n=0;n<currentCourses.size();n++)
            {
                Ongoing[n] = currentCourses.get(n).getname();
                modelcurrent.add(n, Ongoing[n]);
            }
        }
        currentList.setModel(modelcurrent);
        jScrollPane3.setViewportView(currentList);
    }
    
    //needed if a new course is added to current courses , remove course from applicable list
    private void removeApplicable(int courseselect)
    {
        //JOptionPane.showMessageDialog(null,"Course "+applicableCourses.get(courseselect).getname()
          //      +" added!");
        applicableCourses.remove(courseselect);
        index.remove(courseselect);
        DefaultListModel<String> model = new DefaultListModel<>();
        if(!applicableCourses.isEmpty())
        {
            String[] Apply = new String[applicableCourses.size()];
            for(int n=0;n<applicableCourses.size();n++)
            {
                Apply[n] = applicableCourses.get(n).getname();
                model.add(n, Apply[n]);
            }
        }
        availList.setModel(model);
        jScrollPane1.setViewportView(availList);
    }
    
    //are 2 courses same ?
    private boolean AreEqual(Course a, Course b){
        if(!(a.getname().equals(b.getname()))
            ||!(a.getcredit()==b.getcredit())
            ||!(a.getprofessor().equals(b.getprofessor())))//if one of the main parameter disagree
        {
            return false;
        }
        return true;
    }
    
    //check if a course is already cleared by the student
    private boolean canApplyFor(Student shishya,Course shiksha){
        for(int s=0;s<shishya.subjects.size();s++)
        {
            if(AreEqual(shishya.subjects.get(s),shiksha))
            {
                if(shishya.subjects.get(s).getstatus().equals("clear")
                        ||shishya.subjects.get(s).getstatus().equals("current"))
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void SelectStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectStudentButtonActionPerformed
        studentSelect = NameList.getSelectedIndex();
        if(studentSelect==-1)
        {
            JOptionPane.showMessageDialog(null,"Select a student !");
        }
        else
        {   //set available courses 
            availField.setText("Available for "+studentList.get(studentSelect).getname());//available text
            currentField.setText("Current courses for "+studentList.get(studentSelect).getname());
            applicableCourses = new ArrayList<>();
            index = new ArrayList<>();
            DefaultListModel<String> model = new DefaultListModel<>();
            if(!courseList.isEmpty())
            {
                for(int a=0;a<courseList.size();a++)
                {
                    if(canApplyFor(studentList.get(studentSelect),courseList.get(a)))
                    //course is not in particular student's cleared course list
                    {
                        applicableCourses.add(courseList.get(a));
                        index.add(a);
                    }
                }
                
                if(!applicableCourses.isEmpty())
                {
                    String[] Apply = new String[applicableCourses.size()];
                    for(int n=0;n<applicableCourses.size();n++)
                    {
                        Apply[n] = applicableCourses.get(n).getname();
                        model.add(n, Apply[n]);
                    }
                }
            }
            availList.setModel(model);
            jScrollPane1.setViewportView(availList);
           
            updateCurrentList();
        }
    }//GEN-LAST:event_SelectStudentButtonActionPerformed

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
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EnrollStudentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnrollStudentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnrollStudentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnrollStudentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnrollStudentGUI(studentList,courseList).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCourseButton;
    private javax.swing.JList<String> NameList;
    private javax.swing.JButton SelectStudentButton;
    private javax.swing.JLabel availField;
    private javax.swing.JList<String> availList;
    private javax.swing.JLabel currentField;
    private javax.swing.JList<String> currentList;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
