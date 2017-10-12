package com.icss.teacher;

public class UnixFactory implements JFactory {

	@Override
	public JButton getButton() {
		return new UnixButton();
	}

	@Override
	public JText getText() {
		return new UnixText();
	}

}
