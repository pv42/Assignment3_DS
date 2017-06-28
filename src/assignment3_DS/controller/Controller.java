package assignment3_DS.controller;

import assignment3_DS.model.Model;
import assignment3_DS.view.MainWindow;
import assignment3_DS.view.OpenDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created on 23.06.2017.
 */
public class Controller {
    public Controller(){
        Model model = new Model();
        MainWindow mainWindow = new MainWindow(model);
        ActionListener loadGraphActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OpenDialog.createGUI();
                //open a window to load a new graph on click
            }
        };
        ActionListener outputNodesActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //prints a list of all arcs into the mainText
                Model.requestNodeList();

            }
        };
        ActionListener outputOperationsActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //prints a list of all operations into the mainText
                Model.requestOperationList();

            }
        };
        ActionListener removeActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // i need to find a solution !
                try {
                    Controller.removeArcsLongerThan(Integer.parseInt(mainWindow.getRevoveTextValue()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input is not a number", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        };
        mainWindow.registerClickListeners(loadGraphActionListener,outputNodesActionListener,outputOperationsActionListener,removeActionListener);
    }
    static public void removeArcsLongerThan(int weight) {
        // todo
    }
    public static void loadGraph(File nodeFile, File arcFile) {
        //todo
    }


}

