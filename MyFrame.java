/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tut.ac.za;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author Khomotso
 */
public class MyFrame extends JFrame implements ActionListener{

    private JLabel lname,lsurname,lgreeting;
    private JPanel greetingP,nameP,surnameP,namesurnameP,btnP,mainP,headP;
   private JButton greetButton,clearButton,ExitButton;
   private JTextArea txtArea;
   private JTextField txtname,txtsurname;
    
    public MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 700);
        this.setLocationRelativeTo(null);
        this.setTitle("Greetings UI");
        this.setLayout(new BorderLayout());
        
        lname = new JLabel("Name: ");
        lsurname = new JLabel("Surname: ");
        lgreeting = new JLabel("Greetings App");
        
        greetButton = new JButton("Greet");
        greetButton.addActionListener(this);
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        ExitButton = new JButton("Exit");
        ExitButton.addActionListener(this);
        
        txtname = new JTextField(20);
        txtsurname = new JTextField(20);
        
        headP = new JPanel();
        headP.setLayout(new FlowLayout(FlowLayout.CENTER));
        headP.setBorder(BorderFactory.createBevelBorder(0));
        headP.add(lgreeting);
        
        nameP = new JPanel(new FlowLayout(FlowLayout.LEADING));
        nameP.add(lname);
        nameP.add(txtname);
        
        surnameP = new JPanel(new FlowLayout(FlowLayout.LEADING));
        surnameP.add(lsurname);
        surnameP.add(txtsurname);
        
        namesurnameP = new JPanel(new GridLayout(2,1));
        namesurnameP.add(nameP);
        namesurnameP.add(surnameP);
        
        txtArea = new JTextArea(30,40);
        txtArea.setText("Hello[name][surname]");
        txtArea.setEditable(false);
        
        greetingP = new JPanel(new FlowLayout(FlowLayout.CENTER));
        greetingP.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.black,1),"Greetings"));
        greetingP.add(txtArea);
        
        btnP = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnP.add(greetButton);
        btnP.add(clearButton);
        btnP.add(ExitButton);
        
        mainP = new JPanel(new BorderLayout());
        mainP.add(namesurnameP,BorderLayout.NORTH);
        mainP.add(greetingP);
        
        this.add(headP,BorderLayout.NORTH);
        this.add(mainP,BorderLayout.CENTER);
        this.add(btnP,BorderLayout.SOUTH);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==greetButton){
            txtArea.append("\nHello["+txtname.getText()+"]"+"["+txtsurname.getText()+"]");
        }
        if(ae.getSource()==clearButton){
            txtname.setText("");
            txtsurname.setText("");
        }
        if(ae.getSource()==ExitButton){
            this.dispose();
        }

    }
    
    
    
}
