package Tarea5;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Hilos extends JFrame implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblBarraUno;
	private JLabel lblBarraDos;
	private JProgressBar progressBarUno;
	private JProgressBar progressBarDos;
	private JButton btnIniciar;
	private Threads barraProgresoUno, barraProgresoDos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Hilos frame = new Hilos();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Hilos() 
	{
		setTitle("Hilos y barras de progreso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblBarraUno = new JLabel("Barra uno");
			lblBarraUno.setBounds(33, 50, 67, 14);
			contentPane.add(lblBarraUno);
		}
		{
			lblBarraDos = new JLabel("Barra dos");
			lblBarraDos.setBounds(33, 98, 67, 14);
			contentPane.add(lblBarraDos);
		}
		{
			progressBarUno = new JProgressBar();
			progressBarUno.setBounds(135, 50, 179, 24);
			contentPane.add(progressBarUno);
		}
		{
			progressBarDos = new JProgressBar();
			progressBarDos.setBounds(135, 98, 179, 24);
			contentPane.add(progressBarDos);
		}
		{
			btnIniciar = new JButton("Iniciar");
			btnIniciar.addActionListener(this);
			btnIniciar.setBounds(155, 186, 146, 46);
			contentPane.add(btnIniciar);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnIniciar) 
		{
						
			barraProgresoUno = new Threads(progressBarUno,"Uno");
			barraProgresoDos = new Threads(progressBarDos, "Dos");			
			barraProgresoUno.start();
			barraProgresoDos.start();
		}
	}
}
