package com.icss.teacher;
public class LinuxFactory implements JFactory {

	@Override
	public JButton getButton() {
		return new LinuxButton();
	}

	@Override
	public JText getText() {
		return new LinuxText();
	}

}
