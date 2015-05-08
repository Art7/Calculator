package main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Artur on 05.05.2015.
 */
public class MyButton extends JButton {
    public MyButton(String title){
        super(title);
        setForeground(Color.RED);
        setFont(new Font("Arial", Font.ITALIC, 16));
    }
}
