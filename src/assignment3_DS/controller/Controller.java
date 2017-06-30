package assignment3_DS.controller;

import assignment3_DS.graph.CSVLoader;
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
    private Model model;
    private MainWindow mainWindow;
    private OpenDialog openDialog;
    public Controller(){
        model = new Model();
        MainWindow mainWindow = new MainWindow(model);
        ActionListener loadFromFileActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadGraph(openDialog.getNodeFilePath(), openDialog.getNodeFilePath());
            }
        };
        ActionListener requestLoadGraphActionListener = e -> {
            openDialog = new OpenDialog(loadFromFileActionListener);
            openDialog.setupAndShow();
            //open a window to load a new graph on click
        };
        ActionListener outputNodesActionListener = e -> {
            //prints a list of all arcs into the mainText
            model.requestNodeList();

        };
        ActionListener outputOperationsActionListener = e -> {
            //prints a list of all operations into the mainText
            model.requestOperationList();
        };
        ActionListener removeActionListener = e -> {

            try {
                removeArcsLongerThan(Integer.parseInt(mainWindow.getRevoveTextValue()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input is not a number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        };

        mainWindow.registerClickListeners(requestLoadGraphActionListener,outputNodesActionListener,outputOperationsActionListener,removeActionListener);

    }
    public void removeArcsLongerThan(int weight) {
        //model.removeArcsLongerThan(weight);
    }
    public void loadGraph(File nodeFile, File arcFile) {
        model.setGraph(CSVLoader.loadGraph(nodeFile,arcFile));
    }


}

