package view;

import controller.Main;
import controller.Pair;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CreatePage {
    private JTextField firstCreateIn;
    private JTextField secondCreateIn;
    private JTextField weightCreateIn;
    private JLabel titleCreateText;
    private JLabel firstCreateText;
    private JLabel secondCreateText;
    private JLabel weightCreateText;
    private JButton prontoCreateButton;
    private JLabel infoCreateText;
    private JPanel createPagePanel;
    private JButton proximoCreateButton;

    CreatePage(){
        JFrame createPage = new JFrame("Criar grafo");
        if(createPage!=null) {
            createPage.setContentPane(createPagePanel);
            createPage.setLocation(450, 250);
        }
        infoCreateText.setText("<html><body>Peso com valor menor ou igual a zero ou caso a caixa de texto correspondente ao peso esteja em branco, o mesmo será definido igual a 1.</body></html>");
        proximoCreateButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    int first = Integer.valueOf(firstCreateIn.getText());
                    int second = Integer.valueOf(secondCreateIn.getText());
                    int weight = 0;
                    String weightData = weightCreateIn.getText().trim();
                    boolean hasNewLine = weightData.contains(System.getProperty("line.separator"));
                    if((!(weightData.length() > 0) && !hasNewLine) || Integer.valueOf(weightData) <= 0){
                        weight = 1;
                    }
                    else{
                        weight = Integer.valueOf(weightData);
                    }
                    Main.grafo.get(first).add(new Pair(second, weight));
                    createPage.dispose();
                    new CreatePage();
                }catch (Exception error){
                    createPage.dispose();
                    new CreatePage();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        prontoCreateButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                createPage.dispose();
                new MainPage();
                controller.ViewGraph v = new controller.ViewGraph();
                v.createAndShowGUI(Main.grafo);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        createPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createPage.pack();
        createPage.setVisible(true);
    }
}
