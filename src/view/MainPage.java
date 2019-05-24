package view;

import controller.Main;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static controller.Main.RandomGraphGenerate;
import static controller.Main.grafo;

public class MainPage {

    private JButton createMainButton;
    private JButton bfsMainButton;
    private JButton dfsMainButton;
    private JButton djiMainButton;
    private JButton generateMainButton;
    private JLabel generateMainText;
    private JPanel MainPagePanel;
    private JLabel sizeMainText;

    public MainPage(){
        JFrame mainPage = new JFrame("Grafo Debugger");
        if(mainPage!=null) {
            mainPage.setContentPane(MainPagePanel);
            mainPage.setLocation(450, 250);
        }
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.pack();
        mainPage.setVisible(true);
        createMainButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainPage.dispose();
                new QuantityPage();
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {
                generateMainText.setText("Abre uma janela para que seja criado um grafo.");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                generateMainText.setText("");
            }
        });
        generateMainButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RandomGraphGenerate();
                mainPage.dispose();
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
                generateMainText.setText("Gera um grafo com tamanhos e nós aleatórios.");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                generateMainText.setText(" ");
            }
        });

        if(grafo.isEmpty()) {
            dfsMainButton.setVisible(false);
            bfsMainButton.setVisible(false);
            djiMainButton.setVisible(false);
        }
        else{
            dfsMainButton.setVisible(true);
            bfsMainButton.setVisible(true);
            djiMainButton.setVisible(true);
        }

        bfsMainButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new GetBeginEndPage(0);
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
        dfsMainButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new GetBeginEndPage(1);
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
        djiMainButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new GetBeginEndPage(2);
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
        sizeMainText.setText("Size: "+grafo.size());
    }
}