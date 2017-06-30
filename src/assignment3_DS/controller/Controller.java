package assignment3_DS.controller;

import assignment3_DS.graph.CSVLoader;
import assignment3_DS.model.Model;
import assignment3_DS.view.MainWindow;
import assignment3_DS.view.OpenDialog;

import javax.swing.*;
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
        ActionListener loadFromFileActionListener = e -> loadGraph(openDialog.getNodeFilePath(), openDialog.getArcFilePath());
        ActionListener requestLoadGraphActionListener = e -> {
            openDialog = new OpenDialog(loadFromFileActionListener);
            openDialog.setupAndShow();
            //open a window to load a new graph on click
        };

        ActionListener outputNodesActionListener = e -> model.requestNodeList();

        ActionListener outputOperationsActionListener = e -> model.requestOperationList();

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
        new Thread(() -> model.removeArcsLongerThan(weight)).start();
    }
    public void loadGraph(File nodeFile, File arcFile) {
        new Thread(() -> model.setGraph(CSVLoader.loadGraph(nodeFile,arcFile))).start();
    }


}

