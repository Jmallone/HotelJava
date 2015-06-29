package br.michel.pacote1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class teste {

  public static void main(String[] a) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ActionListener actionListener = new PopupActionListener();
    PopupMenuListener popupMenuListener = new MyPopupMenuListener();

    JPopupMenu popupMenu = new JPopupMenu("Title");
    popupMenu.addPopupMenuListener(popupMenuListener);


    JMenuItem cutMenuItem = new JMenuItem("Cut");
    cutMenuItem.addActionListener(actionListener);
    popupMenu.add(cutMenuItem);


    JMenuItem copyMenuItem = new JMenuItem("Copy");
    copyMenuItem.addActionListener(actionListener);
    popupMenu.add(copyMenuItem);

    JMenuItem pasteMenuItem = new JMenuItem("Paste");
    pasteMenuItem.addActionListener(actionListener);
    pasteMenuItem.setEnabled(false);
    popupMenu.add(pasteMenuItem);


    popupMenu.addSeparator();


    JMenuItem findMenuItem = new JMenuItem("Find");
    findMenuItem.addActionListener(actionListener);
    popupMenu.add(findMenuItem);
    JButton label = new JButton();
    frame.add(label);
    label.setComponentPopupMenu(popupMenu);

    frame.setSize(350, 250);
    frame.setVisible(true);
  }
}

class PopupActionListener implements ActionListener {
  public void actionPerformed(ActionEvent actionEvent) {
    System.out.println("Selected: " + actionEvent.getActionCommand());
  }
}

class MyPopupMenuListener implements PopupMenuListener {
  public void popupMenuCanceled(PopupMenuEvent popupMenuEvent) {
    System.out.println("Canceled");
  }

  public void popupMenuWillBecomeInvisible(PopupMenuEvent popupMenuEvent) {
    System.out.println("Becoming Invisible");
  }

  public void popupMenuWillBecomeVisible(PopupMenuEvent popupMenuEvent) {
    System.out.println("Becoming Visible");
  }
}

