import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class TheGUI  {
     JPanel panel;
 JButton checkout , menu, ok;
 JLabel title, flavourLabel,scoopsLabel,toppingsLabel, image ,billLabel;
 JComboBox chooseflavours ,chooseScoops, chooseToppings;

TheGUI(){
    //The Thread
    TheThread loadingScreen = new TheThread();
    loadingScreen.start();
    try{
        loadingScreen.join();
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    JFrame frame1 = new JFrame("IceCream Order");
    frame1.setBounds(80,20,1000,700);
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel= new JPanel();
    panel.setLayout(null);

    ImageIcon icon = new ImageIcon("kindpng.png");
    image=new JLabel();
    image.setIcon(icon);

    image.setBounds(430,90,icon.getIconWidth(),icon.getIconHeight());
    title = new JLabel("Order your Ice cream");
    title.setFont(new Font("Arial", Font.BOLD,32));
    title.setBounds(155,40,360,70);
    panel.setBackground(Color.PINK);
    Font f1 = new Font("San Serif", Font.PLAIN,24);
    flavourLabel = new JLabel("Flavour");
    flavourLabel.setFont(f1);
    flavourLabel.setBounds(20,220,90,20);
    scoopsLabel = new JLabel("Scoops");
    scoopsLabel.setFont(f1);
    scoopsLabel.setBounds(20,340,90,25);
    toppingsLabel = new JLabel("Toppings");
    toppingsLabel.setFont(f1);
    toppingsLabel.setBounds(20,455,110,29);

    Font f3 = new Font("Times Roman",Font.BOLD,17);
    String [] flavours = {"Vanilla","Chocolate","Peppermint","Pineapple",
    "Strawberry","Oreo","Almond","Raspberry"};
    chooseflavours = new JComboBox(flavours);
    chooseflavours.setFont(f3);
    chooseflavours.setBounds(180,215,220,30);
    chooseflavours.setSelectedItem("Chocolate");
    String [] scoops = {"1","2","3","4"};
    chooseScoops = new JComboBox(scoops);
    chooseScoops.setFont(f3);
    chooseScoops.setBounds(180,338,220,30);
    String [] toppings = {"Chocolate Chips","Sprinkles","Caramel","Oreos"};
    chooseToppings = new JComboBox(toppings);
    chooseToppings.setFont(f3);
    chooseToppings.setBounds(180,455,220,30);


    Font f2 = new Font("Arial", Font.BOLD,24);

    menu = new JButton("Read Menu");
    menu.setFont(f2);
    menu.setBounds(155,550,170,70);

    checkout = new JButton("Checkout");
    checkout.setFont(f2);
    checkout.setBounds(410,550,150,70);

    menu.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame menuFrame = new JFrame("Menu");
            menuFrame.setSize(300,510);

            JPanel menuPanel = new JPanel(null);
            menuPanel.setBackground(Color.YELLOW);
            JLabel menuTitle = new JLabel("Menu");
            menuTitle.setFont(new Font("Arial", Font.BOLD,20));
            menuTitle.setBounds(120,40,70,20);

            JLabel flavourtitle = new JLabel("Flavours:");
            flavourtitle.setBounds(20,70,70,20);
            flavourtitle.setFont(new Font("Arial", Font.BOLD,14));
            menuPanel.add(flavourtitle);

            Font f4 = new Font("Arial",Font.PLAIN,15);
            JLabel vanillaFlavour = new JLabel("Vanilla \t Rs 70/-");
            vanillaFlavour.setBounds(20,90,200,20);
            vanillaFlavour.setFont(f4);
            menuPanel.add(vanillaFlavour);
            JLabel pepperMintFlavour = new JLabel("PepperMint \t Rs 70/-");
            pepperMintFlavour.setBounds(20,110,200,20);
            pepperMintFlavour.setFont(f4);
            menuPanel.add(pepperMintFlavour);
            JLabel chocoFlavour = new JLabel("Chocolate \t Rs 100/-");
            chocoFlavour.setBounds(20,130,200,20);
            chocoFlavour.setFont(f4);
            menuPanel.add(chocoFlavour);
            JLabel pineFlavour = new JLabel("PineApple \t Rs 100/-");
            pineFlavour.setBounds(20,150,200,20);
            pineFlavour.setFont(f4);
            menuPanel.add(pineFlavour);
            JLabel oreoFlavour = new JLabel("Oreo \t Rs 100/-");
            oreoFlavour.setBounds(20,170,200,20);
            oreoFlavour.setFont(f4);
            menuPanel.add(oreoFlavour);
            JLabel strawFlavour = new JLabel("Strawberry \t Rs 80/-");
            strawFlavour.setBounds(20,190,200,20);
            strawFlavour.setFont(f4);
            menuPanel.add(strawFlavour);
            JLabel almondFlavour = new JLabel("Almond \t Rs 80/-");
            almondFlavour.setBounds(20,210,200,20);
            almondFlavour.setFont(f4);
            menuPanel.add(almondFlavour);
            JLabel raspFlavour = new JLabel("Raspberry \t Rs 80/-");
            raspFlavour.setBounds(20,230,200,20);
            raspFlavour.setFont(f4);
            menuPanel.add(raspFlavour);

            JLabel scoopTitle = new JLabel("Scoops:");
            scoopTitle.setBounds(20,250,70,20);
            scoopTitle.setFont(new Font("Arial", Font.BOLD,14));
            menuPanel.add(scoopTitle);
            JLabel oneScoop = new JLabel("1 Scoop \t Rs 100/-");
            oneScoop.setBounds(20,270,200,20);
            oneScoop.setFont(f4);
            menuPanel.add(oneScoop);
            JLabel twoScoop = new JLabel("2 Scoops \t Rs 150/-");
            twoScoop.setBounds(20,290,200,20);
            twoScoop.setFont(f4);
            menuPanel.add(twoScoop);
            JLabel threeScoop = new JLabel("3 Scoops \t Rs 200/-");
            threeScoop.setBounds(20,310,200,20);
            threeScoop.setFont(f4);
            menuPanel.add(threeScoop);
            JLabel fourScoop = new JLabel("4 Scoops \t Rs 150/-");
            fourScoop.setBounds(20,330,200,20);
            fourScoop.setFont(f4);
            menuPanel.add(fourScoop);

            JLabel topTitle = new JLabel("Toppings:");
            topTitle.setBounds(20,350,70,20);
            topTitle.setFont(new Font("Arial", Font.BOLD,14));
            menuPanel.add(topTitle);
            JLabel chipTops = new JLabel("ChocoLate chips \t Rs 60/-");
            chipTops.setBounds(20,370,200,20);
            chipTops.setFont(f4);
            menuPanel.add(chipTops);
            JLabel sprinkTops = new JLabel("Sprinkles \t Rs 60/-");
            sprinkTops.setBounds(20,390,200,20);
            sprinkTops.setFont(f4);
            menuPanel.add(sprinkTops);
            JLabel caramelTops = new JLabel("Caramel \t Rs 50/-");
            caramelTops.setBounds(20,410,200,20);
            caramelTops.setFont(f4);
            menuPanel.add(caramelTops);
            JLabel oreoTops = new JLabel("Oreos \t Rs 80/-");
            oreoTops.setBounds(20,430,200,20);
            oreoTops.setFont(f4);
            menuPanel.add(oreoTops);

            menuPanel.add(menuTitle);
            menuFrame.add(menuPanel);
            menuFrame.setResizable(false);
            menuFrame.setLocationRelativeTo(null);
            menuFrame.setVisible(true);
            menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    });

    checkout.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          try {
              JSONObject json = new JSONObject();
              json.put("Flavour",chooseflavours.getSelectedItem());
              json.put("Scoops",chooseScoops.getSelectedItem());
              json.put("Toppings",chooseToppings.getSelectedItem());

              FileWriter file = new FileWriter("Order.json");
              file.write(json.toJSONString());
              file.close();

              JFrame frame2 = new JFrame("Your Order");
              frame2.setBounds(400,100,400,410);
              JPanel panel2 = new JPanel(null);

              Object ob = new JSONParser().parse(new FileReader("Order.json"));
              JSONObject js = (JSONObject) ob;

              String f = (String) js.get("Flavour");
              String s = (String) js.get("Scoops");
              String t = (String) js.get("Toppings");

              panel2.setBackground(Color.yellow);

              JLabel title2 = new JLabel("Your Order is");
              title2.setBounds(10,20,400,50);
              title2.setFont(new Font("Arial",Font.BOLD,30));

              flavourLabel = new JLabel("Flavour"+"  "+f);
              flavourLabel.setFont(f1);
              flavourLabel.setBounds(20,100,400,50);
              scoopsLabel = new JLabel("Scoops"+"  "+s);
              scoopsLabel.setFont(f1);
              scoopsLabel.setBounds(20,180,400,50);
              toppingsLabel = new JLabel("Toppings"+"  "+t);
              toppingsLabel.setFont(f1);
              toppingsLabel.setBounds(20,260,400,50);

              //IceCream Object
              IceCream iceCream = new IceCream();
              iceCream.setFlavour(f);
              iceCream.setScoops(s);
              iceCream.setToppings(t);
              String bill = String.valueOf(iceCream.generateBill());

              billLabel = new JLabel("Bill: "+"  "+bill);
              billLabel.setFont(new Font("Times new roman",Font.ITALIC,25));
              billLabel.setBounds(100,315,100,30);

              ok = new JButton("Ok");
              ok.setFont(new Font("Arial",Font.BOLD,19));
              ok.setBounds(280,310,80,45);
              ok.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      frame2.setVisible(false);
                        JOptionPane.showMessageDialog(frame2,"Your order is placed.");
                      frame1.setVisible(false);
                      frame1.dispose(); frame2.dispose();
                      frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                      frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  }
              });

              panel2.add(ok);
              panel2.add(title2);
              panel2.add(flavourLabel);
              panel2.add(scoopsLabel);
              panel2.add(toppingsLabel);
              panel2.add(billLabel);
              frame2.add(panel2);
              frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              frame2.setVisible(true);
              frame2.setResizable(false);

          }catch (NumberFormatException formatException){
              JOptionPane.showMessageDialog(frame1,"ERROR");
          }catch (IOException ioException){
              JOptionPane.showMessageDialog(frame1,"File not found.");
          } catch (ParseException ex) {
              JOptionPane.showMessageDialog(frame1,"File not found.");
          }
        }
    });

    panel.add(image);
    panel.add(title);
    panel.add(flavourLabel);
    panel.add(scoopsLabel);
    panel.add(toppingsLabel);
    panel.add(chooseflavours);
    panel.add(chooseScoops);
    panel.add(chooseToppings);

    panel.add(checkout);
    panel.add(menu);

    frame1.add(panel);
    frame1.add(panel);
    frame1.setResizable(false);
    frame1.setVisible(true);
}

}

