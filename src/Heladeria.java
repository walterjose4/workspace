import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Heladeria extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JComboBox cboHelado;
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
					Heladeria frame = new Heladeria();
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
	public Heladeria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(290, 0, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(290, 27, 89, 23);
		contentPane.add(btnBorrar);
		
		cboHelado = new JComboBox();
		cboHelado.setModel(new DefaultComboBoxModel(new String[] {"Sol", "Fresa", "Mar", "Rico"}));
		cboHelado.setBounds(109, 0, 109, 22);
		contentPane.add(cboHelado);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(109, 28, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		lblNewLabel = new JLabel("Helado");
		lblNewLabel.setBounds(10, 4, 89, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setBounds(10, 31, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		txtS = new JTextArea();
		txtS.setBounds(20, 64, 389, 164);
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
		txtCantidad.setText("");
		txtS.setText("");
		cboHelado.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//Declaracion de variables
		int helado,cantidad,caramelos;
		double importeCompra,importeDescuento,importePagar;
		//Entrada de datos
		helado=calculoHelado();
		cantidad=calculoCantidad();
		//Proceso de cálculo
		importeCompra=calculoImporteCompra(helado,cantidad);
		importeDescuento=calculoImporteDescuento(cantidad,importeCompra);
		importePagar=calculoImportePagar(importeCompra,importeDescuento);
		caramelos=calculoCaramelos(helado,cantidad);
		//Salida de resultados
		imprimir(importeCompra,importeDescuento,importePagar,caramelos);
	}
		int calculoHelado() {
			return cboHelado.getSelectedIndex();
		}
		int calculoCantidad() {
			return Integer.parseInt(txtCantidad.getText());
		}
		double calculoImporteCompra(int helado,int cantidad) {
		double precio;
		switch(helado) {
		case 0: precio=2.5; break;
		case 1: precio=1.3; break;
		case 2: precio=2; break;
		default: precio=1.7;
		}
		return precio*cantidad;
	}
		double calculoImporteDescuento(int cantidad, double importeCompra) {
			double descuento;
			if(cantidad<10) descuento=0.05;
			else if(cantidad<20) descuento=0.07;
			else if(cantidad<30) descuento=0.09;
			else descuento=0.11;
			return importeCompra*descuento;
		}
		double calculoImportePagar(double importeCompra,double importeDescuento) {
			double pagar;
			pagar=importeCompra-importeDescuento;
			return pagar;
		}
		int calculoCaramelos(int helado, int cantidad) {
			int caramelos;
			switch(helado) {
			case 0: caramelos=1*cantidad; break;
			case 2: caramelos=2*cantidad; break;
			default: caramelos=6;
			}
			return caramelos;
		}
		void imprimir(double importeCompra, double importeDescuento, double importePagar, int caramelos) {
			txtS.setText("Importe de la compra: "+importeCompra);
			txtS.append("\nImporte del descuento: "+importeDescuento);
			txtS.append("\nImporte a pagar: "+importePagar);
			txtS.append("\nCaramelos de obsequi: "+caramelos);
		}
}
