import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Generator {
    private JButton btnStart;
    private JPanel panelMain;
    private JTextField tfHely;
    private JButton btnOpen;
    private JButton btnDel;
    private File path;
    private boolean notEmpty;

    public Generator() {
        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int option = fileChooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    tfHely.setText(file.getPath());
                    path = file;
                    notEmpty = true;
                } else {
                    tfHely.setText("No folder selected!");
                }
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notEmpty) {
                    JOptionPane.showMessageDialog(null, "Created successfully!");
                    First.first(path);
                } else {
                    JOptionPane.showMessageDialog(null, "Please choose a folder!");
                }
            }
        });

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delete.del(path, 0);
                JOptionPane.showMessageDialog(null, "Webpages have been deleted!");
            }
        });
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch(Exception ignored){}
        createWindow();
    }

    public static void createWindow() {
        JFrame frame = new JFrame("Generator by Nowai");
        frame.setContentPane(new Generator().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
