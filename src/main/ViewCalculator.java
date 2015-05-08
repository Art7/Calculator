package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Artur on 28.04.2015.
 */
public class ViewCalculator {

    //mainFrame objects
    private JFrame mainFrame;

    // topPanel objects
    private JPanel topPanel;
    private JLabel mainLabel;

    //bottomPanel objects
    private JPanel bottomPanel;
    private GridLayout bottomGridLayout;

    //leftBottomPanel objects
    private JPanel leftBottomPanel;
    private GridLayout leftBottomGridLayout;
    private MyButton backButton;
    private MyButton cButton;


    //centerBottomPanel objects
    private JPanel centerBottomPanel;
    private GridLayout centerBottomGridLayout;
    private MyButton[] digitButtons;
    private MyButton pointButton;

    //rightBottomPanel objects
    private JPanel rightBottomPanel;
    private GridLayout rightBottomGridLayout;

    //rightBigBottomPanel
    private JPanel rightBigBottomPanel;
    private GridLayout rightBigBottomGridLayout;
    private MyButton plusButton;
    private MyButton minusButton;
    private MyButton divideButton;
    private MyButton multButton;

    //rightSmallBottomPanel objects
    private JPanel rightSmallBottomPanel;
    private GridLayout rightSmallBottomGridLayout;
    private MyButton equalButton;

    //Model object description
    private Model logic;

    //new entry flag and first flag
    private boolean newEntry = true;
    private boolean first = true;

    //constructor for ViewCalculator
    public ViewCalculator(Model logic){
        this.logic = logic;
    }

    public void buildGUI(){

        //***********OBJECTS CREATION************************************

        //mainFrame objects creation
        mainFrame = new JFrame("Calculator");

        //centralTopPanel objects creation
        topPanel = new JPanel();
        mainLabel = new JLabel("0", SwingConstants.RIGHT);

        //bottomPanel objects creation
        bottomPanel = new JPanel();
        bottomGridLayout = new GridLayout(1,3,5,5);

        //leftBottomPanel objects creation
        leftBottomPanel = new JPanel();
        leftBottomGridLayout = new GridLayout(2,1,5,5);

        //leftBottomPanel buttons creation
        backButton = new MyButton("BS");
        cButton = new MyButton("C");

        //centerBottomPanel objects creation
        centerBottomPanel = new JPanel();
        centerBottomGridLayout = new GridLayout(4,4,5,5);

        //array of digital buttons
        digitButtons = new MyButton[10];

        //rightBottomPanel objects creation
        rightBottomPanel = new JPanel();
        digitButtons = new MyButton[10];
        pointButton = new MyButton(".");
        rightBottomGridLayout = new GridLayout(2,1,5,5);

        //rightBigBottomPanel objects creation
        rightBigBottomPanel = new JPanel();
        rightBigBottomGridLayout = new GridLayout(2,2,5,5);
        plusButton = new MyButton("+");
        minusButton = new MyButton("-");
        divideButton = new MyButton("/");
        multButton = new MyButton("*");

        //rightSmallBottomPanel objects creation
        rightSmallBottomPanel = new JPanel();
        rightSmallBottomGridLayout = new GridLayout(1,2,5,5);
        equalButton = new MyButton("=");

        //*************************ACTIONS FOR BUTTONS************************

        //Action for equal button creation
        equalButton.addActionListener(new equalButtonPressed());

        //Actions for arythmetic buttons
        plusButton.addActionListener(new arithButtonPressed());
        minusButton.addActionListener(new arithButtonPressed());
        divideButton.addActionListener(new arithButtonPressed());
        multButton.addActionListener(new arithButtonPressed());

        //action for point button
        pointButton.addActionListener(new pointButtonPressed());

        //action for CE and backspace buttons
        cButton.addActionListener(new clearButtonPressed());
        backButton.addActionListener(new backButtonPressed());

        //**********************FRAME CONSTRUCTION*********************************

        //mainFrame construction
        mainFrame.setBounds(100, 100,480, 310);
        mainFrame.add(BorderLayout.NORTH, topPanel);
        mainFrame.add(BorderLayout.CENTER, bottomPanel);

        //topPanel construction
        topPanel.setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
        topPanel.setLayout(new GridLayout(1, 1, 0, 0));
        topPanel.add(mainLabel);
        mainLabel.setFont(new Font("Arial", Font.BOLD, 20));
        mainLabel.setOpaque(true);
        mainLabel.setBackground(Color.DARK_GRAY);
        mainLabel.setForeground(Color.GREEN);

        //bottomPanel construction
        bottomPanel.setLayout(bottomGridLayout);
        bottomPanel.setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
        bottomPanel.add(leftBottomPanel);
        bottomPanel.add(centerBottomPanel);
        bottomPanel.add(rightBottomPanel);

        //leftBottomPanel construction
        leftBottomPanel.setLayout(leftBottomGridLayout);
        leftBottomPanel.add(backButton);
        leftBottomPanel.add(cButton);

        //centerBottomPanel construction
        centerBottomPanel.setLayout(centerBottomGridLayout);
        for(int i = 1; i < 10; i++)  {
            digitButtons[i] = new MyButton(String.valueOf(i));
            digitButtons[i].addActionListener(new digitButtonPressed());
            centerBottomPanel.add(digitButtons[i]);
        }
        digitButtons[0] = new MyButton("0");
        digitButtons[0].addActionListener(new digitButtonPressed());
        centerBottomPanel.add(digitButtons[0]);
        centerBottomPanel.add(pointButton);

        //rightBottomPanel construction
        rightBottomPanel.setLayout(rightBottomGridLayout);
        rightBottomPanel.add(rightBigBottomPanel);
        rightBottomPanel.add(rightSmallBottomPanel);

        //rightBigBottomPanel construction
        rightBigBottomPanel.setLayout(rightBigBottomGridLayout);
        rightBigBottomPanel.add(plusButton);
        rightBigBottomPanel.add(minusButton);
        rightBigBottomPanel.add(divideButton);
        rightBigBottomPanel.add(multButton);

        //rightSmallBottomPanel construction
        rightSmallBottomPanel.setLayout(rightSmallBottomGridLayout);
        rightSmallBottomPanel.add(equalButton);

        //show mainFrame
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    //pressing on digital buttons
    private class digitButtonPressed implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(newEntry) {
                mainLabel.setText(((JButton)e.getSource()).getText());
                newEntry = false;
            }
            else mainLabel.setText(mainLabel.getText()+((JButton)e.getSource()).getText());
        }
    }

    //pressing arithmetic buttons
    private class arithButtonPressed implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double temp;
            temp = logic.action(mainLabel.getText(), ((JButton) e.getSource()).getText().toCharArray()[0], first);
            mainLabel.setText(String.valueOf(temp));
            newEntry = true;
            first = false;
        }
    }

    //pressing equal buttons
    private class equalButtonPressed implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!first){
                double result = logic.calculate(mainLabel.getText());
                mainLabel.setText(Double.toString(result));
                newEntry = true;
                first = true;
            }
        }
    }

    //pressing point buttons
    private class pointButtonPressed implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(newEntry){
                newEntry = false;
                mainLabel.setText("0.");
            } else if (!(mainLabel.getText().contains("."))) mainLabel.setText(mainLabel.getText() + ".");
        }
    }

    //pressing clear button
    private class clearButtonPressed implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainLabel.setText("0");
            first = true;
            newEntry = true;
            logic.clear();
        }
    }

    //pressing backspace button
    private class backButtonPressed implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           if(!newEntry){
               if(mainLabel.getText().length() == 1 || mainLabel.getText().equals("0.")) {
                   mainLabel.setText("0");
                   newEntry = true;
               }
               else mainLabel.setText(mainLabel.getText().substring(0,mainLabel.getText().length()-1));
           }
        }
    }

}
//Как использовать один font для всех кнопок
// создать свой класс MyButton - наследник JButton
//public class MyButton extends JButton {
//public MyButton(String title){
//super(title);   - вызывает конструктор родителя, это нужно делать в самом начале
//setFont(new Font("Arial",0,25));
//}
//}
//MyButton dotButton = new MyButton(".");