import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.util.Random;

// simple password generator with GUI
public class PasswordGenerator extends JFrame implements ActionListener {

    // setup variables
    private JButton gen, clear, exit, copy;
    private JPanel panel = new JPanel();
    private JTextField lenfield = new JTextField(10);
    private JTextField ansfield = new JTextField(10);
    private String setField;
    private int getField;

    // main method that calls on constructor
    public static void main(String[] args) {
        new PasswordGenerator();

    }

    // constructor
    public PasswordGenerator() {
        // setup jframe
        JFrame frame = new JFrame("Password Generator");
        frame.setContentPane(panel);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // setup jlabels
        JLabel length = new JLabel("Length of Password: ");
        JLabel answer = new JLabel("Your Password: ");
        length.setBounds(65, 100, 150, 20);
        answer.setBounds(65, 140, 150, 20);

        // setup jtextfield
        lenfield.setBounds(200, 100, 150, 20);
        ansfield.setBounds(200, 140, 150, 20);
        ansfield.setEditable(false);

        // setup buttons
        gen = new JButton("GENERATE");
        clear = new JButton("CLEAR");
        exit = new JButton("EXIT");
        copy = new JButton("COPY");
        gen.addActionListener(this);
        clear.addActionListener(this);
        exit.addActionListener(this);
        copy.addActionListener(this);
        gen.setBounds(65,250,110,30);
        clear.setBounds(185,250,110,30);
        exit.setBounds(305,250,110,30);
        copy.setBounds(65,250,110,30);
        copy.setVisible(false);

        // add to panel
        panel.add(gen);
        panel.add(clear);
        panel.add(exit);
        panel.add(length);
        panel.add(answer);
        panel.add(lenfield);
        panel.add(ansfield);
        panel.add(copy);
        panel.setLayout(null);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        // check for clicks
        if(e.getSource() == gen) // what happens for generate button
        {
            getField = Integer.parseInt(lenfield.getText());
            ansfield.setText(genPass());
            gen.setVisible(false);
            copy.setVisible(true);
        }

        if(e.getSource() == clear) // what happens for clear button
        {
            lenfield.setText("");
            ansfield.setText("");
            gen.setVisible(true);
            copy.setVisible(false);
        }

        if(e.getSource() == copy) // what happens for copy button
        {
            StringSelection stringSelection = new StringSelection (ansfield.getText());
            Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
            clpbrd.setContents (stringSelection, null);
        }

        if(e.getSource() == exit) // what happens for exit button
        {
            System.exit(0);
        }


    }

    public String genPass(){
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specchar = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        String combo = uppercase+lowercase+numbers+specchar;
        char[] password = new char[getField];
        Random pass = new Random();
        for (int i=0; i<getField; i++){
            password[i]=combo.charAt(pass.nextInt(combo.length()));
        }
        setField = String.valueOf(password);

        return setField;
    }
}
