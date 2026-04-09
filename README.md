# JHintTextField

[![License](https://img.shields.io/github/license/RutarAndriy/JHintTextField?label=%D0%9B%D1%96%D1%86%D0%B5%D0%BD%D0%B7%D1%96%D1%8F&color=%23FF5555)](/LICENSE)
[![JitPack](https://jitpack.io/v/RutarAndriy/JHintTextField.svg)](https://jitpack.io/#RutarAndriy/JHintTextField)

Покращений компонент [JTextField](https://docs.oracle.com/javase/7/docs/api/javax/swing/JTextField.html). Відображає підказку, якщо поле не містить введеного тексту.

## Додавання компонента в NetBeans GUI Builder

- Додаємо [залежність](https://jitpack.io/#RutarAndriy/JHintTextField) у свій проект
- Створюємо нову форму/діалогове вікно \
`New` > `Other` > `Swing GUI Forms` > `JFrame/JDialog`
- Додаємо JavaBeans-компонент \
`Pallete` > `Beans` > `Choose Bean`
- У полі 'Class Name' вводимо назву класу: \
`com.rutar.jdroppablepanel.JDroppablePanel`
- Перетягуємо компонент на форму/діалогове вікно
- Налаштовуємо властивості компонента через меню 'Properties'
</details>

## Використання

```java
// Створення нового поля з підказкою
var field = new JHintTextField();

// Задання тексту підказки
field.setHintText("Текст підказки");
// Задання кольору тексту підказки
field.setHintColor(Color.RED);

// Додавання прослуховувача подій
field.addJHintTextFieldListener(new JHintTextFieldAdapter() {
    // Зміна тексту
    public void textChange(JHintTextFieldEvent evt) {
        // ...
    }
    // Зміна тексту підказки
    public void hintTextChange(JHintTextFieldEvent evt) {
        // ...
    }
    // Зміна кольору тексту підказки
    public void hintColorChange(JHintTextFieldEvent evt) {
        // ...
    }
});
```

<details name="screenshots">
  <summary>Скріншоти</summary>
  <p align="center">
    <img title="Скріншот №1" src="/img/scr_01.png"><br>
    <img title="Скріншот №2" src="/img/scr_02.png">
    <img title="Скріншот №3" src="/img/scr_03.png">
  </p>
</details>

