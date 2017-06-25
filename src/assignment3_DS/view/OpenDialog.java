package assignment3_DS.view;

import assignment3_DS.controller.Controller;

import javax.swing.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

public class OpenDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel chosenNodeFile;
    private JLabel chosenArcFile;
    private JButton chooseNode;
    private JButton chooseArc;
    private File arcFilePath;
    private File nodeFilePath;

    public OpenDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);



        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);



        chooseNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                final JFileChooser chooser = new JFileChooser("Choose Directory");
                chooser.setDialogType(JFileChooser.OPEN_DIALOG);
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                final File file = new File(System.getProperty("user.home"));

                chooser.setCurrentDirectory(file);

                chooser.addPropertyChangeListener(new PropertyChangeListener() {
                    public void propertyChange(PropertyChangeEvent e) {
                        if (e.getPropertyName().equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
                                || e.getPropertyName().equals(JFileChooser.DIRECTORY_CHANGED_PROPERTY)) {
                            final File f = (File) e.getNewValue();
                        }
                    }
                });

                chooser.setVisible(true);
                final int result = chooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File inputDirectoryFile = chooser.getSelectedFile();
                      nodeFilePath = inputDirectoryFile;


                }
                chooser.setVisible(false);
            }
        });


        chooseArc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser chooser = new JFileChooser("Choose Directory");
                chooser.setDialogType(JFileChooser.OPEN_DIALOG);
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                final File file = new File(System.getProperty("user.home"));

                chooser.setCurrentDirectory(file);

                chooser.addPropertyChangeListener(new PropertyChangeListener() {
                    public void propertyChange(PropertyChangeEvent e) {
                        if (e.getPropertyName().equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
                                || e.getPropertyName().equals(JFileChooser.DIRECTORY_CHANGED_PROPERTY)) {
                            final File f = (File) e.getNewValue();
                        }
                    }
                });

                chooser.setVisible(true);
                final int result = chooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File inputDirectoryFile = chooser.getSelectedFile();
                    arcFilePath = inputDirectoryFile;

                }
                chooser.setVisible(false);
            }
        });
    }

    private void onOK() {
        Controller.loadGraph(nodeFilePath, arcFilePath);
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        OpenDialog dialog = new OpenDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
