package com.rutar.jhinttextfield;

import java.util.*;

// ............................................................................
/// Реалізація прослуховувача подій для JavaBeans-компонента
/// @author Rutar_Andriy
/// 07.04.2026

public interface JHintTextFieldListener extends EventListener {

// ============================================================================
/// Зміна типу усмішки
/// @param evt подія типу JHintTextFieldEvent

public void smileTypeChange (JHintTextFieldEvent evt);

// ============================================================================
/// Зміна ширини усмішки (в градусах)
/// @param evt подія типу JHintTextFieldEvent

public void smileWidthChange (JHintTextFieldEvent evt);

// ============================================================================
/// Зміна товщини ліній
/// @param evt подія типу JHintTextFieldEvent

public void lineWidthChange (JHintTextFieldEvent evt);

// Кінець класу JHintTextFieldBeanInfo ========================================

}
