/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.controlador;

import cr.ac.una.prograIII.appProyecto.bl.ArtProvBL;
import cr.ac.una.prograIII.appProyecto.bl.ArticuloBL;
import cr.ac.una.prograIII.appProyecto.bl.ClienteBL;
import cr.ac.una.prograIII.appProyecto.bl.ProveedorBL;
import cr.ac.una.prograIII.appProyecto.domain.Reporte;
import cr.ac.una.prograIII.appProyecto.vista.FacturaView;
import cr.ac.una.prograIII.appProyecto.vista.ManteArtProv;
import cr.ac.una.prograIII.appProyecto.vista.ManteArticulo;
import cr.ac.una.prograIII.appProyecto.vista.ManteProveedor;
import cr.ac.una.prograIII.appProyecto.vista.PantallaPrincipal;
import cr.ac.una.prograIII.appProyecto.vista.ManteCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Kevin
 */
public class PantallaPrincipalControlador implements ActionListener {

    private PantallaPrincipal PantallaPrinView;

    private int ini = 0;
    private int fin = 0;

    public PantallaPrincipalControlador(PantallaPrincipal PantallaPrinView) {
        this.PantallaPrinView = PantallaPrinView;
        this.PantallaPrinView.btLimpiarPantalla.addActionListener(this);
        this.PantallaPrinView.btIniciarServidor.addActionListener(this);
        this.PantallaPrinView.btDetenerServidor.addActionListener(this);
        this.PantallaPrinView.btDesbloquear.addActionListener(this);
        this.PantallaPrinView.btBloquear.addActionListener(this);
        this.PantallaPrinView.menuManteCliente.addActionListener(this);
        this.PantallaPrinView.menuManteArticulo.addActionListener(this);
        this.PantallaPrinView.menuManteArtProv.addActionListener(this);
        this.PantallaPrinView.menuManteProveedor.addActionListener(this);
        this.PantallaPrinView.btEnviar.addActionListener(this);
        this.PantallaPrinView.btFacturar.addActionListener(this);
        this.PantallaPrinView.mReporteClientes.addActionListener(this);
        this.PantallaPrinView.mReporteArticulos.addActionListener(this);
        this.PantallaPrinView.mReporteFacturas.addActionListener(this);
        this.PantallaPrinView.mReporteProveedores.addActionListener(this);

        this.PantallaPrinView.txtMensaje.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                PantallaPrinView.txtMensaje.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                PantallaPrinView.txtMensaje.setText("Mensaje");
            }
        });
        this.PantallaPrinView.btIniciarServidor.doClick();
        this.PantallaPrinView.btIniciarServidor.setVisible(false);
        this.PantallaPrinView.btDetenerServidor.setVisible(false);
    }

    public PantallaPrincipal getPantallaPrinView() {
        return PantallaPrinView;
    }

    public void setPantallaPrinView(PantallaPrincipal PantallaPrinView) {
        this.PantallaPrinView = PantallaPrinView;
    }

    public Integer horaInicial() {
        Calendar c1 = Calendar.getInstance();
        int hora = c1.get(Calendar.HOUR_OF_DAY);
        int min = c1.get(Calendar.MINUTE);
        return ((hora * 60) + min);
    }

    public Integer horaFinal() {
        Calendar c1 = Calendar.getInstance();
        int hora = c1.get(Calendar.HOUR_OF_DAY);
        int min = c1.get(Calendar.MINUTE);
        return (hora * 60) + min;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == PantallaPrinView.mReporteClientes) {
            Reporte p = new Reporte();
            try {
                p.creaReporte("ListaClientes.jrxml");
            } catch (IOException | JRException | SQLException ex) {
                Logger.getLogger(PantallaPrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == PantallaPrinView.mReporteArticulos) {
            Reporte p = new Reporte();
            try {
                p.creaReporte("ListaArticulos.jrxml");
            } catch (IOException | JRException | SQLException ex) {
                Logger.getLogger(PantallaPrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == PantallaPrinView.mReporteProveedores) {
            Reporte p = new Reporte();
            try {
                p.creaReporte("ListaProveedores.jrxml");
            } catch (IOException | JRException | SQLException ex) {
                Logger.getLogger(PantallaPrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == PantallaPrinView.menuManteCliente) {
            ManteCliente manteClienteView = new ManteCliente();
            ClienteBL clienteBLModelo = new ClienteBL();
            ClienteControlador cC = new ClienteControlador(manteClienteView, clienteBLModelo);
            cC.getMantClienteView().setVisible(true);
        }

        if (e.getSource() == PantallaPrinView.menuManteArticulo) {
            ManteArticulo mateArticuloview = new ManteArticulo();
            ArticuloBL articuloBlModelo = new ArticuloBL();
            ArticuloControlador articuloc = new ArticuloControlador(mateArticuloview, articuloBlModelo);
            articuloc.getMantArticuloView().setVisible(true);
        }

        if (e.getSource() == PantallaPrinView.menuManteProveedor) {
            ManteProveedor manteProveedorView = new ManteProveedor();
            ProveedorBL proveedorBlModelo = new ProveedorBL();
            ProveedorControlador provControlador = new ProveedorControlador(manteProveedorView, proveedorBlModelo);
            provControlador.getMantProveedorView().setVisible(true);
        }

        if (e.getSource() == PantallaPrinView.menuManteArtProv) {
            ManteArtProv manteAp = new ManteArtProv();
            ArtProvBL apBL = new ArtProvBL();
            ArtProvControlador apc = new ArtProvControlador(manteAp, apBL);
            apc.getManteArtProvView().setVisible(true);
        }

        if (e.getSource() == PantallaPrinView.btLimpiarPantalla) {
            PantallaPrinView.Chat_Servidor.setText("");
        }

        if (e.getSource() == this.PantallaPrinView.btIniciarServidor) {
            Thread starter = new Thread(new PantallaPrincipalControlador.ServerStart());
            starter.start();
            PantallaPrinView.Chat_Servidor.append("Servidor Iniciado...\n");
        }

        if (e.getSource() == PantallaPrinView.btDetenerServidor) {
            try {
                Thread.sleep(2000);                 //2000 milliseconds is five second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            tellEveryone("Server:el servidor ha sido detenido y los usuarios se han desconectados.\n:Chat");
            PantallaPrinView.Chat_Servidor.append("Servidor Detenido... \n");
            PantallaPrinView.Chat_Servidor.setText("");
        }

        if (e.getSource() == PantallaPrinView.btDesbloquear) {

            int fila = PantallaPrinView.jTPC.getSelectedRow();
            if (fila != -1) {
                try {
                    String ipSeleccionada = PantallaPrinView.jTPC.getValueAt(fila, 1).toString();
                    String nombrePCSeleccionado = PantallaPrinView.jTPC.getValueAt(fila, 0).toString();

                    //*****************************************************
                    //se recorre la lista de clientes y se verifica a cual
                    //sokect se le quiere enviar el mensaja (el seleccionado 
                    //en la tabla)
                    //*****************************************************
                    for (PantallaPrincipalControlador.ClienteHilo cliente : listaClientes) {
                        //se optiene la IP del sokect para compararla con la seleccionada
                        String ipCliente = cliente.getSock().getInetAddress().toString();
                        if (ipCliente.equals("/" + ipSeleccionada) && cliente.getNombrePC().endsWith(nombrePCSeleccionado)) {
                            Calendar c = Calendar.getInstance();
                            cliente.setHoInicio(Integer.toString(c.get(Calendar.HOUR)) + ":" + Integer.toString(c.get(Calendar.MINUTE)));
                            cliente.setEstadoActivo(true);
                            //si el sokect es la tiene la ip seleccionada
                            //se le envia un mensaje

                            PrintWriter writer = new PrintWriter(cliente.getSock().getOutputStream());
                            writer.println("1UL");
                            ini = horaInicial();

                            writer.flush();
                        }
                    }
                } catch (Exception el) {

                }
            } else {
                JOptionPane.showMessageDialog(PantallaPrinView, "Debe seleccionar una pc para ejecutar la accion.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            llenarTabla();
        }

        if (e.getSource() == PantallaPrinView.btFacturar) {
            ArticuloBL arti = new ArticuloBL();
            FacturaView f = new FacturaView();
            ClienteBL c = new ClienteBL();
            int fila = this.PantallaPrinView.jTPC.getSelectedRow();
            if (fila != -1) {
                Integer total = (fin - ini);
                System.out.println(total);
                FacturaControlador fc = new FacturaControlador(f, arti, c);
                fc.getFactura().setVisible(true);
                fc.getFactura().txtCantidad.setText(total.toString());
                f.agrega2.doClick();

            } else {
                FacturaControlador fc = new FacturaControlador(f, arti, c);
                fc.getFactura().setVisible(true);
            }

        }

        if (e.getSource() == PantallaPrinView.btEnviar) {

            int fila = PantallaPrinView.jTPC.getSelectedRow();
            if (fila != -1) {
                try {
                    String ipSeleccionada = PantallaPrinView.jTPC.getValueAt(fila, 1).toString();
                    String nombrePCSeleccionado = PantallaPrinView.jTPC.getValueAt(fila, 0).toString();

                    //*****************************************************
                    //se recorre la lista de clientes y se verifica a cual
                    //sokect se le quiere enviar el mensaja (el seleccionado 
                    //en la tabla)
                    //*****************************************************
                    for (ClienteHilo cliente : listaClientes) {
                        //se optiene la IP del sokect para compararla con la seleccionada
                        String ipCliente = cliente.getSock().getInetAddress().toString();
                        if (ipCliente.equals("/" + ipSeleccionada) && cliente.getNombrePC().endsWith(nombrePCSeleccionado)) {
                            //si el sokect es la tiene la ip seleccionada
                            //se le envia un mensaje

                            PrintWriter writer = new PrintWriter(cliente.getSock().getOutputStream());
                            writer.println("Servidor: " + PantallaPrinView.txtMensaje.getText());
                            writer.flush();
                            PantallaPrinView.Chat_Servidor.append("\n" + PantallaPrinView.txtMensaje.getText());
                        }
                    }
                } catch (Exception el) {

                }
            } else {
                JOptionPane.showMessageDialog(PantallaPrinView, "Debe seleccionar una pc para ejecutar la accion.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (e.getSource() == PantallaPrinView.btBloquear) {

            int fila = PantallaPrinView.jTPC.getSelectedRow();
            if (fila != -1) {
                try {
                    String ipSeleccionada = PantallaPrinView.jTPC.getValueAt(fila, 1).toString();
                    String nombrePCSeleccionado = PantallaPrinView.jTPC.getValueAt(fila, 0).toString();

                    //*****************************************************
                    //se recorre la lista de clientes y se verifica a cual
                    //sokect se le quiere enviar el mensaja (el seleccionado 
                    //en la tabla)
                    //*****************************************************
                    for (PantallaPrincipalControlador.ClienteHilo cliente : listaClientes) {
                        //se optiene la IP del sokect para compararla con la seleccionada
                        String ipCliente = cliente.getSock().getInetAddress().toString();
                        if (ipCliente.equals("/" + ipSeleccionada) && cliente.getNombrePC().endsWith(nombrePCSeleccionado)) {
                            //si el sokect es la tiene la ip seleccionada
                            //se le envia un mensaje
                            Calendar c = Calendar.getInstance();
                            cliente.setHoFin(Integer.toString(c.get(Calendar.HOUR)) + ":" + Integer.toString(c.get(Calendar.MINUTE)));
                            cliente.setEstadoActivo(false);
                            PrintWriter writer = new PrintWriter(cliente.getSock().getOutputStream());
                            writer.println("1BL");
                            fin = horaFinal();
                            writer.flush();
                        }
                    }
                } catch (Exception el) {

                }
            } else {
                JOptionPane.showMessageDialog(PantallaPrinView, "Debe seleccionar una pc para ejecutar la accion.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            llenarTabla();
        }
    } //Action listener ends here

    /**
     * ***********************************************************************************************
     */
    public class ServerStart implements Runnable {

        @Override
        public void run() {
            listaClientes = new ArrayList();

            try {
                ServerSocket serverSock = new ServerSocket(2222);
                while (true) {
                    //Cada ves que se acepta una conexion por socket
                    Socket clientSock = serverSock.accept();
                    //se crea un nuevo cliente
                    PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
                    PantallaPrincipalControlador.ClienteHilo cliente = new PantallaPrincipalControlador.ClienteHilo(clientSock, writer);

                    listaClientes.add(cliente);

                    //se crea un nuevo hilo para el nuevo socket creado, 
                    //independiente en otro hilo 
                    Thread listener = new Thread(cliente);
                    listener.start();

                    //se llena la tabla con los clientes conectados
                    llenarTabla();
                    PantallaPrinView.Chat_Servidor.append("tienes una conexion \n" + clientSock.getInetAddress());
                }
            } catch (Exception ex) {
                PantallaPrinView.Chat_Servidor.append("Error al realizar la conexión. \n");
            }
        }
    }

    /**
     * ********************************************************************************************
     */
    public void tellEveryone(String message) {

        //*******************************************************
        //Se recorren todos los hilos y se le envia
        //un mensaje a cada uno
        //*******************************************************
        for (ClienteHilo cliente : listaClientes) {

            try {
                //Se toma el printWriter del sokect el cual es el que
                //permite el envio de mensajes
                PrintWriter writer = new PrintWriter(cliente.getSock().getOutputStream());
                writer.println(message);
                writer.flush();

                //Se muestra el mensaje en el texto
                PantallaPrinView.Chat_Servidor.append("enviando: " + message + "\n");
                PantallaPrinView.Chat_Servidor.setCaretPosition(PantallaPrinView.Chat_Servidor.getDocument().getLength());

            } catch (Exception ex) {
                PantallaPrinView.Chat_Servidor.append("Error al enviar mensaje a todos. \n");
            }
        }
    }

    /**
     * *************************************************************************************************
     */
    public void llenarTabla() {

        DefaultTableModel modeloTabla = new DefaultTableModel();
        PantallaPrinView.jTPC.setModel(modeloTabla);
        String fila[] = new String[5];

        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("IP");
        modeloTabla.addColumn("Estado");
        modeloTabla.addColumn("Hora Inicio");
        modeloTabla.addColumn("Hora Fin");
        TableColumnModel columnModel = PantallaPrinView.jTPC.getColumnModel();
        columnModel.getColumn(2).setPreferredWidth(80);

        try {
            //*************************************************
            //*************************************************
            //se recorre la lista de hilos para obtener la
            //información de los clientes conectados
            //*************************************************
            //*************************************************
            for (PantallaPrincipalControlador.ClienteHilo cliente : listaClientes) {

                fila[0] = cliente.getNombrePC();
                fila[1] = cliente.getSock().getInetAddress().toString().replace("/", "");
                if (cliente.getEstadoActivo()) {
                    fila[2] = "En uso";
                } else {
                    fila[2] = "Libre";
                }
                fila[3] = cliente.getHoInicio();
                fila[4] = cliente.getHoFin();

                modeloTabla.addRow(fila);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);

        }
    }

    /**
     * ************************************************************************************************
     */
    ArrayList<ClienteHilo> listaClientes;

    public class ClienteHilo implements Runnable {

        private String hoInicio;
        private String hoFin;
        private BufferedReader reader;
        private Socket sock;
        private PrintWriter printWriter;
        private Calendar calendario = Calendar.getInstance();
        private Boolean estadoActivo;
        private String nombrePC;

        public ClienteHilo(Socket clientSocket, PrintWriter printWriter) {
            this.printWriter = printWriter;
            this.estadoActivo = false;
            try {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            } catch (Exception ex) {
                PantallaPrinView.Chat_Servidor.append("inesperado error... \n");
            }

        }

        //*****************************************************
        //*****************************************************
        //Cuando el hilo de ejecuta, se inicia la comunicacion
        //por socket, ves que se lee un mensaje es donde se
        //decide que hacer
        //*****************************************************
        //*****************************************************
        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    //*****************************************************
                    //El mensaje se muestra en el Texto de mensajes
                    //aca se deberia codificar que se quiere hacer
                    //*****************************************************
                    PantallaPrinView.Chat_Servidor.append("Administrador: " + message + "\n");

                    //Se decodifica el mensaje
                    String mensajeEnPartes[] = message.split(":");
                    if (mensajeEnPartes[0].equals("N")) {//nuevo usuario
                        this.nombrePC = mensajeEnPartes[1];
                        llenarTabla();// se llena la tabla de clientes

                    }
                    if (mensajeEnPartes[0].equals("D")) {
                        this.estadoActivo = false;
                        llenarTabla();

                    }
                }
            } catch (Exception ex) {
                PantallaPrinView.Chat_Servidor.append("conexion perdida. \n");
                ex.printStackTrace();
            }
        }

        public String getHoInicio() {
            return hoInicio;
        }

        public void setHoInicio(String hoInicio) {
            this.hoInicio = hoInicio;
        }

        public String getHoFin() {
            return hoFin;
        }

        public void setHoFin(String hoFin) {
            this.hoFin = hoFin;
        }

        public BufferedReader getReader() {
            return reader;
        }

        public void setReader(BufferedReader reader) {
            this.reader = reader;
        }

        public Socket getSock() {
            return sock;
        }

        public void setSock(Socket sock) {
            this.sock = sock;
        }

        public PrintWriter getPrintWriter() {
            return printWriter;
        }

        public void setPrintWriter(PrintWriter printWriter) {
            this.printWriter = printWriter;
        }

        public Calendar getCalendario() {
            return calendario;
        }

        public void setCalendario(Calendar calendario) {
            this.calendario = calendario;
        }

        public Boolean getEstadoActivo() {
            return estadoActivo;
        }

        public void setEstadoActivo(Boolean estadoActivo) {
            this.estadoActivo = estadoActivo;
        }

        public String getNombrePC() {
            return nombrePC;
        }

        public void setNombrePC(String nombrePC) {
            this.nombrePC = nombrePC;
        }
    }
}
