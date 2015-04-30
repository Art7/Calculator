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
    private JButton backButton;
    private JButton cButton;


    //centerBottomPanel objects
    private JPanel centerBottomPanel;
    private GridLayout centerBottomGridLayout;
    private JButton[] digitButtons;
    private JButton pointButton;

    //rightBottomPanel objects
    private JPanel rightBottomPanel;
    private GridLayout rightBottomGridLayout;

    //rightBigBottomPanel
    private JPanel rightBigBottomPanel;
    private GridLayout rightBigBottomGridLayout;
    private JButton plusButton;
    private JButton minusButton;
    private JButton divideButton;
    private JButton multButton;

    //rightSmallBottomPanel objects
    private JPanel rightSmallBottomPanel;
    private GridLayout rightSmallBottomGridLayout;
    private JButton equalButton;

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
        backButton = new JButton("BS");
        backButton.setForeground(Color.RED);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        cButton = new JButton("C");
        cButton.setForeground(Color.RED);
        cButton.setFont(new Font("Arial", Font.BOLD, 16));

        //centerBottomPanel objects creation
        centerBottomPanel = new JPanel();
        centerBottomGridLayout = new GridLayout(4,4,5,5);

        //array of digital buttons
        digitButtons = new JButton[10];

        //rightBottomPanel objects creation
        rightBottomPanel = new JPanel();
        digitButtons = new JButton[10];
        pointButton = new JButton(".");
        rightBottomGridLayout = new GridLayout(2,1,5,5);

        //rightBigBottomPanel objects creation
        rightBigBottomPanel = new JPanel();
        rightBigBottomGridLayout = new GridLayout(2,2,5,5);
        plusButton = new JButton("+");
        minusButton = new JButton("-");
        divideButton = new JButton("/");
        multButton = new JButton("*");

        //rightSmallBottomPanel objects creation
        rightSmallBottomPanel = new JPanel();
        rightSmallBottomGridLayout = new GridLayout(1,2,5,5);
        equalButton = new JButton("=");

        //*************************ACTIONS FOR BUTTONS************************

        //Action for equal button creation
        equalButton.addActionListener(new equalButtonPressed());
        equalButton.setForeground(Color.RED);
        equalButton.setFont(new Font("Arial", Font.BOLD, 16));

        //Actions for arythmetic buttons
        plusButton.addActionListener(new arithButtonPressed());
        plusButton.setForeground(Color.RED);
        plusButton.setFont(new Font("Arial", Font.BOLD, 16));
        minusButton.addActionListener(new arithButtonPressed());
        minusButton.setForeground(Color.RED);
        minusButton.setFont(new Font("Arial", Font.BOLD, 16));
        divideButton.addActionListener(new arithButtonPressed());
        divideButton.setForeground(Color.RED);
        divideButton.setFont(new Font("Arial", Font.BOLD, 16));
        multButton.addActionListener(new arithButtonPressed());
        multButton.setForeground(Color.RED);
        multButton.setFont(new Font("Arial", Font.BOLD, 16));

        //action for point button
        pointButton.addActionListener(new pointButtonPressed());
        pointButton.setForeground(Color.RED);
        pointButton.setFont(new Font("Arial", Font.BOLD, 16));

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
            digitButtons[i] = new JButton(String.valueOf(i));
            digitButtons[i].addActionListener(new digitButtonPressed());
            digitButtons[i].setForeground(Color.RED);
            digitButtons[i].setFont(new Font("Arial", Font.BOLD, 16));
            centerBottomPanel.add(digitButtons[i]);
        }
        digitButtons[0] = new JButton("0");
        digitButtons[0].setForeground(Color.RED);
        digitButtons[0].setFont(new Font("Arial", Font.BOLD, 16));
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
