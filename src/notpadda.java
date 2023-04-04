import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class notpadda {
    private JTextArea textArea1;
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton saveButton;

    public notpadda() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename = "info.txt";
                BufferedReader in = null;
                try {
                    in = new BufferedReader(new FileReader(filename));
                } catch (FileNotFoundException ex) {
                    textArea1.setText("");
                    return;
                }
                String nextLine = null;
                try {
                    nextLine = in.readLine();
                    while (nextLine != null) {
                        textArea1.append(nextLine +"\n");
                        nextLine = in.readLine();
                    }
                } catch (IOException ex) {
                    textArea1.setText("");
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename = "text.txt";
                PrintWriter out = null;
                try {
                    out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null,"Failed to Save!");
                }
                out.println("Hello World");
                out.flush();
                out.close();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("notpadda");
        frame.setContentPane(new notpadda().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}


