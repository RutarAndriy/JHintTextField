package com.rutar.jhinttextfield;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.text.Document;

// ............................................................................
/// Реалізація текстового поля введення з підказкою
/// @author Rutar_Andriy
/// 07.04.2026

public class JHintTextField extends JTextField {

private String text = "";                                // текст поля введення
private String hintText = "Заповніть поле";                   // текст підказки
private Color hintColor = new Color(153, 153, 153);    // колір тексту підказки

// Масив прослуховувачів подій компонента
private static ArrayList <JHintTextFieldListener> listeners = null;

// ============================================================================
/// Допоміжний конструктор

public JHintTextField()
  { this(null, null, 0); }

// ============================================================================
/// Допоміжний конструктор
/// @param text початковий текст

public JHintTextField (String text)
  { this(null, text, 0); }

// ============================================================================
/// Допоміжний конструктор
/// @param columns кількість стовбців

public JHintTextField (int columns)
  { this(null, null, columns); }

// ============================================================================
/// Допоміжний конструктор
/// @param text початковий текст
/// @param columns кількість стовбців

public JHintTextField (String text, int columns)
  { this(null, text, columns); }

// ============================================================================
/// Головний конструктор
/// @param doc об'єкт класу Document
/// @param text початковий текст
/// @param columns кількість стовбців

public JHintTextField (Document doc, String text, int columns)
  { super(doc, text, columns);
    addFocusListener(focusListener);
    getDocument().addDocumentListener(docListener); }

// ============================================================================
/// Промальовування компонента

@Override
protected void paintComponent (Graphics g) {

    super.paintComponent(g);

    if (hintText.isBlank() ||
       !getText().isEmpty() || isFocusOwner()) { return; }

    var g2 = (Graphics2D) g.create();
    setSystemFontParams(g2);

    int textX, textY;
    var insets = getInsets();
    var hintWidth = g2.getFontMetrics().stringWidth(hintText);

    switch (getHorizontalAlignment())
      { case LEFT  -> textX = insets.left;
        case RIGHT -> textX = getWidth() - hintWidth - insets.right;
        default    -> textX = (getWidth() - hintWidth)/2 - 1; }

    textY = getBaseline(getWidth(), getHeight());

    g2.setFont(getFont());
    g2.setColor(hintColor);
    g2.drawString(hintText, textX, textY);
    g2.dispose();
}

// ============================================================================
/// Задання системних параметрів шрифтів для тексту підказки

private void setSystemFontParams (Graphics2D g)
  { var deshtopHints = Toolkit.getDefaultToolkit()
                              .getDesktopProperty("awt.font.desktophints");
    if (deshtopHints instanceof Map<?, ?> hints)
      { g.addRenderingHints(hints); } }

// ============================================================================
/// Повернення тексту поля введення
/// @return текст поля введення

@Override
public String getText() { return text; }

// ============================================================================
/// Задання тексту поля введення
/// @param newText новий текст поля введення

@Override
public void setText (String newText)
  { if (newText == null) { newText = ""; }
    var oldValue = this.text;
    this.text = newText;  
    super.setText(newText);
    repaint();
    fireAll("text", oldValue, newText); }

// ============================================================================
/// Повернення тексту підказки
/// @return текст підказки

public String getHintText() { return hintText;  }

// ============================================================================
/// Задання тексту підказки
/// @param hintText новий текст підказки

public void setHintText (String hintText)
  { if (hintText == null) { hintText = ""; }
    var oldValue = this.hintText;
    this.hintText = hintText;
    repaint();
    fireAll("hintText", oldValue, hintText); }

// ============================================================================
/// Повернення кольору тексту підказки
/// @return колір тексту підказки

public Color getHintColor() { return hintColor; }

// ============================================================================
/// Задання кольору тексту підказки
/// @param hintColor новий колір тексту підказки

public void setHintColor (Color hintColor)
  { if (hintColor == null) { hintColor = new Color(153, 153, 153); }
    var oldValue = this.hintColor;
    this.hintColor = hintColor;
    repaint();
    fireAll("hintColor", oldValue, hintColor); }

// ============================================================================
/// Додавання нового прослуховувача подій компонента
/// @param listener новий прослуховувач подій для додавання

public void addJHintTextFieldListener (JHintTextFieldListener listener)
  { getListeners().add(listener); }

// ============================================================================
/// Видалення існуючого прослуховувача подій компонента
/// @param listener існуючий прослуховувач подій для видалення

public void removeJHintTextFieldListener (JHintTextFieldListener listener)
  { getListeners().remove(listener); }

// ============================================================================
/// Повернення списку активних прослуховувачів

private ArrayList <JHintTextFieldListener> getListeners()
  { if (listeners == null) { listeners = new ArrayList<>(); }
    return listeners; }

// ============================================================================
/// Інформування прослуховувачів про зміну властивостей компонента

private void fireAll (String name, Object oldValue, Object newValue)
  { if (oldValue.equals(newValue)) { return; }
    fireEvent          (name, oldValue, newValue);
    firePropertyChange (name, oldValue, newValue); }

// ============================================================================
/// Інформування прослуховувачів про зміну конкретної властивості компонента

private void fireEvent (String name, Object oldValue, Object newValue) {

var event = new JHintTextFieldEvent(this, oldValue, newValue);

for (var lst : getListeners())
    { switch (name)
          { case "text"      -> lst.textChange(event);
            case "hintText"  -> lst.hintTextChange(event);
            case "hintColor" -> lst.hintColorChange(event); } } }

// ============================================================================
/// Прослуховувач фокусу компонента

private final FocusListener focusListener = new FocusListener() {

    @Override   // Одержання фокусу
    public void focusGained (FocusEvent e) { repaint(); }

    @Override   // Втрата фокусу
    public void focusLost (FocusEvent e) { repaint(); }
};

// ============================================================================
/// Прослуховувач вмісту поля введення

private final DocumentListener docListener = new DocumentListener() {

    @Override   // Додавання даних
    public void insertUpdate (DocumentEvent e)
      { var oldValue = text;
        text = JHintTextField.super.getText();
        fireAll("text", oldValue, text); }

    @Override   // Видалення даних
    public void removeUpdate (DocumentEvent e)
      { var oldValue = text;
        text = JHintTextField.super.getText();
        fireAll("text", oldValue, text); }

    @Override   // Оновлення форматування (не використовується)
    public void changedUpdate (DocumentEvent e) {}
};

// Кінець класу JHintTextField ================================================

}
