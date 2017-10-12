package com.icss.teacher;

public class WindowsFactory implements JFactory {

	@Override
	public JButton getButton() {
		return new WindowsButton();
	}

	@Override
	public JText getText() {
		return new WindowsText();
	}

}
