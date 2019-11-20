package guiPractice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TShirtGUI extends JFrame{
    private JPanel mainPanel;
    private JComboBox sizeComboBox;
    private JLabel sizeSelectedLabel;
    private JComboBox colorComboBox;
    private JLabel colorSelectedLabel;


    TShirtGUI(){

        sizeComboBox.addItem("Small");
        sizeComboBox.addItem("Medium");
        sizeComboBox.addItem("Large");

        String[] colors = {"Red", "Blue", "Green"};

        DefaultComboBoxModel<String> colorModel = new DefaultComboBoxModel<>(colors);
        colorComboBox.setModel(colorModel);

        setContentPane(mainPanel);
        setPreferredSize(new Dimension(300,150));
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        sizeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sizeSelectedLabel.setText("You have selected  " + sizeComboBox.getSelectedItem());
            }
        });

        colorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelectedLabel.setText("You have selected " + colorComboBox.getSelectedItem());
            }
        });
    }

}

