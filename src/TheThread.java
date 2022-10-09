import javax.swing.*;
import java.awt.*;

class TheThread extends Thread {
    public void run() {
        JFrame frame3 = new JFrame("Loading...");
        frame3.setLayout(null);
        frame3.setUndecorated(false); //turn of title bar
        frame3.setSize(600, 450);//Setting size
        frame3.setLocationRelativeTo(null);//Setting location to the center of screen
        frame3.getContentPane().setBackground(Color.yellow);

        JLabel image = new JLabel(new ImageIcon("icecream2.png"));
        image.setSize(600, 400);
        JLabel text = new JLabel("My IceCream Shop");
        text.setFont(new Font("Times New Roman", Font.BOLD, 35));
        text.setBounds(160, 360, 600, 40);
        JProgressBar progressBar = new JProgressBar();
        progressBar.setBounds(100, 280, 400, 30);//Setting Location and size
        progressBar.setBorderPainted(true);//Setting border painted property
        progressBar.setStringPainted(true);//Setting String painted property
        progressBar.setBackground(Color.WHITE);//setting background color
        progressBar.setForeground(Color.BLACK);//setting foreground color
        progressBar.setValue(0);//setting progress bar current value
        JLabel message = new JLabel();
        message.setBounds(250, 320, 200, 40);//Setting the size and location of the label
        message.setForeground(Color.black);//Setting foreground Color
        message.setFont(new Font("arial", Font.BOLD, 15));//Setting font properties
        frame3.add(message);//adding label to the frame

            frame3.add(text);
            frame3.add(progressBar);
            frame3.add(image);
            frame3.setResizable(false);
            frame3.setVisible(true);
        //Running Progress bar
        int i = 0;//Creating an integer variable and initializing it to 0

        while (i <= 100) {
            try {
                Thread.sleep(50);//Pausing execution for 50 milliseconds
                progressBar.setValue(i);//Setting value of Progress Bar
                message.setText("LOADING " + Integer.toString(i) + "%");//Setting text of the message JLabel
                i++;
                if (i == 100) {
                    frame3.setVisible(false);
                    frame3.dispose();
                    frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}