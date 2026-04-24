package com.rutar.jhinttextfield;

import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.event.*;
import java.awt.image.*;

// ............................................................................
/// Демонстація основних можливостей JavaBeans-компонента
/// @author Rutar_Andriy
/// 07.04.2026

public class JHintTextFieldDemo extends JFrame {

// ============================================================================
/// Конструктор за замовчуванням

public JHintTextFieldDemo()
  { initComponents();
    initAppIcons();
    btn_reset.requestFocus(); }

// ============================================================================
/// Головний метод програми
/// @param args масив параметрів запуску програми

public static void main (String args[])
  { SwingUtilities.invokeLater(() ->
      { new JHintTextFieldDemo().setVisible(true); }); }

// ============================================================================
/// Відновлення стандартних налаштувань компонента

private void resetSettings()
  { var tmp = new JHintTextField();
    hfld_text.setText(null);
    hfld_text.setHintText(tmp.getHintText());
    hfld_text.setHintColor(tmp.getHintColor()); }

// ============================================================================
/// Генерування випадкового кольору

private Color getRandomColor()
  { return new Color((int)(Math.random()*255),
                     (int)(Math.random()*255),
                     (int)(Math.random()*255)); }

// ============================================================================
/// Повернення нового тексту підказки

private String getNewHintText()
  { var tmp = hfld_text.getText();
    if (tmp.isBlank()) { tmp = "Новий текст підказки"; }
    return tmp; }

// ============================================================================
/// Встановлення іконок для головного вікна

private void initAppIcons() {

    BufferedImage icon;
    ArrayList<Image> appIcons = new ArrayList<>();

    try {
        
    for (String resource : new String[] { "icon_16.png",
                                          "icon_32.png" }) {
        resource = "icons/" + resource;
        icon = ImageIO.read(getClass().getResourceAsStream(resource));
        appIcons.add(icon); }
    
    setIconImages(appIcons); }
    
    catch (IOException _) { }
}

// ============================================================================
/// Цей метод викликається з конструктора для ініціалізації форми.
/// УВАГА: НЕ змінюйте цей код. Вміст цього методу завжди 
/// перезапишеться редактором форм

    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    hfld_text = new JHintTextField();
    btn_hintColor = new JButton();
    btn_hintText = new JButton();
    btn_reset = new JButton();

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setTitle("JHintTextField Demo");
    setResizable(false);

    hfld_text.setHorizontalAlignment(JTextField.CENTER);
    hfld_text.addJHintTextFieldListener(new JHintTextFieldListener() {
      public void textChange(JHintTextFieldEvent evt) {
        onParamsChange(evt);
      }
      public void hintTextChange(JHintTextFieldEvent evt) {
        onParamsChange(evt);
      }
      public void hintColorChange(JHintTextFieldEvent evt) {
        onParamsChange(evt);
      }
    });

    btn_hintColor.setText("Змінити колір підказки");
    btn_hintColor.setActionCommand("hintColor");
    btn_hintColor.addActionListener(this::onButtonClick);

    btn_hintText.setText("Змінити текст підказки");
    btn_hintText.setActionCommand("hintText");
    btn_hintText.addActionListener(this::onButtonClick);

    btn_reset.setText("Відновити стандартні налаштування");
    btn_reset.setActionCommand("reset");
    btn_reset.addActionListener(this::onButtonClick);

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(5, 5, 5)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
          .addComponent(btn_reset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(btn_hintText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(btn_hintColor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(hfld_text, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(5, 5, 5))
    );
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(5, 5, 5)
        .addComponent(hfld_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addGap(5, 5, 5)
        .addComponent(btn_hintColor)
        .addGap(5, 5, 5)
        .addComponent(btn_hintText)
        .addGap(5, 5, 5)
        .addComponent(btn_reset)
        .addGap(5, 5, 5))
    );

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void onButtonClick(ActionEvent evt) {//GEN-FIRST:event_onButtonClick
    switch (evt.getActionCommand()) {
      // Зміна кольору підказки
      case "hintColor" -> hfld_text.setHintColor(getRandomColor());
      // Зміна тексту підказки
      case "hintText"  -> { hfld_text.setHintText(getNewHintText());
                            hfld_text.setText(null); }
      // Відновлення стандартних налаштувань
      case "reset"     -> resetSettings();
    }
  }//GEN-LAST:event_onButtonClick

  private void onParamsChange(JHintTextFieldEvent evt) {//GEN-FIRST:event_onParamsChange
    IO.println(evt);
  }//GEN-LAST:event_onParamsChange

  // Variables declaration - do not modify//GEN-BEGIN:variables
  JButton btn_hintColor;
  JButton btn_hintText;
  JButton btn_reset;
  JHintTextField hfld_text;
  // End of variables declaration//GEN-END:variables

// Кінець класу JHintTextFieldDemo ============================================

}
