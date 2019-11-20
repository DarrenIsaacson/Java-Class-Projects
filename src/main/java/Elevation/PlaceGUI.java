package Elevation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PlaceGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField placeNameText;
    private JTextField elevationText;
    private JButton addButton;
    private JButton deleteButton;
    private JLabel placeNameLabel;
    private JLabel elevationLabel;
    private JList placeList;

    private Controller controller;

    private DefaultListModel<Place> allPlaceListModel;

    PlaceGUI(Controller controller){
        this.controller = controller;

        allPlaceListModel = new DefaultListModel<>();
        placeList.setModel(allPlaceListModel);

        addListeners();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setVisible(true);
    }

    public void addListeners(){

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String place = placeNameText.getText();

                if(place.isEmpty()){
                    errorDialog("Enter a place name");
                    return;
                }

                double elev = 0;

                try{
                    elev = Double.parseDouble(elevationText.getText());
                } catch (NumberFormatException nfe){
                    errorDialog("Enter a number for elevation");
                    return;
                }

                Place placeRecord = new Place(place, elev);
                String results = controller.addPlaceToDatabase(placeRecord);

                if(results.equals(PlaceDB.OK)){
                    placeNameText.setText("");
                    elevationText.setText("");

                    List<Place> allData = controller.getAllData();
                    setListData(allData);
                }else{
                    errorDialog(results);
                }
            }
        });

    }

    void setListData (List<Place> data){
        allPlaceListModel.clear();

        if(data != null ) {
            for(Place place : data){
                allPlaceListModel.addElement(place);
            }
        }
    }

    private void errorDialog(String msg){
        JOptionPane.showConfirmDialog(PlaceGUI.this, msg, "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
