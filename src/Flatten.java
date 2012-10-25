import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class Flatten extends JDialog {
    /* yes I know! Its Sharing state. */
    private JPanel contentPane;
    public JButton buttonOK;
    private JButton buttonCancel;
    public JTextField textField1;
    private JButton button1;
    public JTextField textField2;
    private JButton button2;
    public JProgressBar progressBar1;
    public JProgressBar progressBar2;
    private JCheckBox verifyFilesSlowerCheckBox;
    private JCheckBox multithreadCheckBox;
    private JCheckBox smallFilePriorityFilesCheckBox;
    private JButton aboutButton;
    public JTextPane textPane1;

    public Flatten() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser("");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnVal = fileChooser.showDialog(null, "Select");
                //Process the results.
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    textField1.setText(file.getPath());
                } else {
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser("");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnVal = fileChooser.showDialog(null, "Select");
                //Process the results.
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    textField2.setText(file.getPath());
                } else {
                }
            }
        });
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

}
