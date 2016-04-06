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
import javax.swing.JOptionPane;

/**
 *
 * @author kaustubh
 */
public class GradeStudentsGUI extends javax.swing.JFrame implements Serializable{

    /**
     * Creates new form GradeStudentsGUI
     * @param courseList
     * @param studentList
     */
    public GradeStudentsGUI(ArrayList<Course> courseList,ArrayList<Student> studentList) {
        newinitComponents(courseList,studentList);
    }

    static int courseselect = 0;
    static List<Integer> studentindex = new ArrayList<>();
    static List<Integer> courseindex = new ArrayList<>();
    static ArrayList<Student> mystudent = new ArrayList<>();
    static int grade = 5;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        GradeStudentsButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        courseName = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        gradeSlider = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grade Students");

        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Courses", "Professor"
            }
        ));
        jScrollPane1.setViewportView(courseTable);

        GradeStudentsButton.setText("Evaluate");
        GradeStudentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GradeStudentsButtonActionPerformed(evt);
            }
        });

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Roll", "Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(studentTable);

        courseName.setText("Course : ");

        submitButton.setText("Submit");
        submitButton.setToolTipText("Have you graded all the students ?");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        gradeSlider.setMajorTickSpacing(1);
        gradeSlider.setMaximum(10);
        gradeSlider.setPaintLabels(true);
        gradeSlider.setPaintTicks(true);
        gradeSlider.setSnapToTicks(true);
        gradeSlider.setValue(5);
        gradeSlider.setBorder(javax.swing.BorderFactory.createTitledBorder("Grade"));
        gradeSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(GradeStudentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gradeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(courseName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GradeStudentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(gradeSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void newinitComponents(ArrayList<Course> courseList,ArrayList<Student> studentList) {

        jScrollPane1 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        GradeStudentsButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        courseName = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        gradeSlider = new javax.swing.JSlider();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grade Students");

        Object[][] courseObject = new String[courseList.size()][2];
        for(int i = 0;i < courseList.size();i++)
        {
            courseObject[i][0] = courseList.get(i).getname();
            courseObject[i][1] = courseList.get(i).getprofessor();
        }
        
        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            courseObject,
            new String [] {
                "Courses", "Professor"
            }
        ));
        jScrollPane1.setViewportView(courseTable);

        GradeStudentsButton.setText("Evaluate");
        GradeStudentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GradeStudentsButtonActionPerformed(evt);
            }
        });

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Roll","Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false,false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(studentTable);

        courseName.setText("Course : ");

        submitButton.setText("Submit");
       // submitButton.setToolTipText("Have you graded all the students ?");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        gradeSlider.setMajorTickSpacing(1);
        gradeSlider.setMaximum(10);
        gradeSlider.setPaintLabels(true);
        gradeSlider.setPaintTicks(true);
        gradeSlider.setSnapToTicks(true);
        gradeSlider.setValue(5);
        gradeSlider.setBorder(javax.swing.BorderFactory.createTitledBorder("Grade"));
        gradeSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gradeSlider.setToolTipText("5 is the minimum for pass criteria");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(GradeStudentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gradeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(courseName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GradeStudentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(gradeSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
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
    
    private void GradeStudentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GradeStudentsButtonActionPerformed
        // TODO add your handling code here:
        courseselect = courseTable.getSelectedRow();
        if(courseselect==-1)
        {
            JOptionPane.showMessageDialog(null,"Select a course first!");
        }
        else
        {
            courseName.setText("Course : "+courseList.get(courseselect).getname());    
            updateStudentTable();
        }
    }//GEN-LAST:event_GradeStudentsButtonActionPerformed

    private void updateStudentTable()
    {
        String[] columns = {"Name","Roll","Grade"};
        mystudent = new ArrayList<>();
        studentindex = new ArrayList<>();
        courseindex = new ArrayList<>();
        for(int k = 0 ; k < studentList.size(); k++)
        {
            for(int m = 0; m < studentList.get(k).subjects.size() ; m++)
            {
                Course studying = studentList.get(k).subjects.get(m);
                if(AreEqual(studying,courseList.get(courseselect))
                        &&studentList.get(k).status.get(m).equals("current"))
               {
                    mystudent.add(studentList.get(k));
                    studentindex.add(k);
                    courseindex.add(m);
                    //^ this course is at subjects[courseindex[select]] for mystudent[studentindex[selected]]
                }
            }
        }
            
        Object[][] studObject = new String[mystudent.size()][3];
        // new String[courseList.get(courseselect).getstudentsonroll()][3];
        for(int i = 0;i < mystudent.size();i++)
        {
            //int rollID = courseList.get(courseselect).StudentsOnRoll.get(i);
            //JOptionPane.showMessageDialog(null,"Roll >"+rollID+"<");
            studObject[i][0] = mystudent.get(i).getname();//roll start from 1 not 0
            studObject[i][1] = Integer.toString(mystudent.get(i).getroll());
            studObject[i][2] = Integer.toString(mystudent.get(i).grades.get(courseindex.get(i)));
            //mystudent.get(i).subjects.get(courseindex.get(i)).getgrade());
        }
        studentTable.setModel(new javax.swing.table.DefaultTableModel(studObject,columns) {
        }
        );
        studentTable.setToolTipText("A grade of -1 indicates ungraded course");
        jScrollPane2.setViewportView(studentTable);
    }
    
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        int select = studentTable.getSelectedRow();
        if(select==-1)
        {
            JOptionPane.showMessageDialog(null,"Need to select a student first! Have you selected a course ?");
        }
        else
        {
            studentList.get(studentindex.get(select))
                    .grades.set(courseindex.get(select), gradeSlider.getValue());
            updateStudentTable();
            gradeSlider.setValue(5);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    
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
            java.util.logging.Logger.getLogger(GradeStudentsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GradeStudentsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GradeStudentsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GradeStudentsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GradeStudentsGUI(courseList,studentList).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GradeStudentsButton;
    private javax.swing.JLabel courseName;
    private javax.swing.JTable courseTable;
    private javax.swing.JSlider gradeSlider;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable studentTable;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}