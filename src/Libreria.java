import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Libreria extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JComboBox cboMarca;
	private JTextField txtCantidad;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Libreria frame = new Libreria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Libreria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(345, 0, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(345, 23, 89, 23);
		contentPane.add(btnBorrar);
		
		cboMarca = new JComboBox();
		cboMarca.setModel(new DefaultComboBoxModel(new String[] {"Standford", "Alpha", "Justus", "Loro"}));
		cboMarca.setBounds(157, 0, 116, 22);
		contentPane.add(cboMarca);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(157, 24, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		lblNewLabel = new JLabel("Marca");
		lblNewLabel.setBounds(0, 4, 107, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setBounds(0, 27, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtS = new JTextArea();
		txtS.setBounds(0, 52, 424, 198);
		contentPane.add(txtS);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		cboMarca.setSelectedIndex(0);
		txtCantidad.setText("");
		txtS.setText("");
		txtCantidad.requestFocus();
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//Declaracion de variables
		//Entrada de datos
		leer
		//Proceso de cálculo
		//Salida de resultados
		imprimir
	}
	double calculoImporteCompra(int cantidad) {
		int marca=cboMarca.getSelectedIndex();
		double precio;
		switch(marca) {
		case 0: precio=4.85; break;
		case 1: precio=4.35; break;
		case 2: precio=3.5; break;
		default: precio=4.55;
		}
		return precio*cantidad;
	}
}
