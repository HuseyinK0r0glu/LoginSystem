import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginBtn = new JButton("Login");
    JButton resetBtn = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID:");
    JLabel userPasswordLabel = new JLabel("password:");
    JLabel messageLabel = new JLabel();

    HashMap<String,String> loginInfo = new HashMap<String,String>();
    LoginPage(HashMap<String,String> loginInfoOriginal) {
        loginInfo = loginInfoOriginal;

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        loginBtn.setBounds(125,200,100,25);
        loginBtn.addActionListener(this);
        loginBtn.setFocusable(false);

        resetBtn.setBounds(225,200,100,25);
        resetBtn.addActionListener(this);
        resetBtn.setFocusable(false);


        frame.add(loginBtn);
        frame.add(resetBtn);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(messageLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==resetBtn){
            userIDField.setText("");
            userPasswordField.setText("");
        }

        if(e.getSource()==loginBtn){
            String UserID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            if(loginInfo.containsKey(UserID)){
                if(loginInfo.get(UserID).equals(password)){
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Login Successful");
                    WelcomePage welcomePage = new WelcomePage(UserID);
                    frame.dispose();
                }
                else {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Wrong Password");
                }
            }
            else {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Username not found");
            }
        }
    }
}
