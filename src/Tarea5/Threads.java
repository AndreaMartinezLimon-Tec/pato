package Tarea5;

import java.awt.Color;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class Threads extends Thread 
{
	private  Color customColor = new Color(51,5,137);
	private JProgressBar component;
	private Random porcentajeAleatorio;
	private volatile boolean haFinalizado = false;
	
	private Random getRand() {
		return porcentajeAleatorio;
	}
	
	public Threads(JProgressBar component, String nombre) 
	{
		this.component = component;
		porcentajeAleatorio = new Random();
		this.component.setName(nombre);
		this.component.setMaximum(100);
	}
	
	public synchronized boolean isCompleted() 
	{
		return haFinalizado;
	}
	
	@Override
	public void run() 
	{
		component.setStringPainted(true);
		component.setForeground(customColor);
		int intPorciento = 0;
		while(!haFinalizado) 
		{
			if(component.getValue() >= 100) 
			{
				haFinalizado = true;
			}
			component.setValue(intPorciento); 
			intPorciento += getRand().nextInt(4);
			try 
			{
				Thread.sleep(25);
			} catch (InterruptedException ex) 
			{
				ex.printStackTrace();
			}
		}
		component.setValue(0);
		JOptionPane.showMessageDialog(component, component.getName() + " ha finalizado");
	}
}
