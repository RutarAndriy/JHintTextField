package com.rutar.jhinttextfield;

import java.util.*;

// ............................................................................
/// Реалізація прослуховувача подій для JavaBeans-компонента
/// @author Rutar_Andriy
/// 07.04.2026

public interface JHintTextFieldListener extends EventListener {

// ============================================================================
/// Зміна тексту в середині поля введення
/// @param evt подія типу JHintTextFieldEvent

public void textChange (JHintTextFieldEvent evt);

// ============================================================================
/// Зміна тексту підказки
/// @param evt подія типу JHintTextFieldEvent

public void hintTextChange (JHintTextFieldEvent evt);

// ============================================================================
/// Зміна кольору тексту підказки
/// @param evt подія типу JHintTextFieldEvent

public void hintColorChange (JHintTextFieldEvent evt);

// Кінець класу JHintTextFieldBeanInfo ========================================

}
