/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.controlador;

import cr.ac.una.prograIII.appProyecto.vista.PantallaServidor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Anthony Carrillo
 */

public class ServidorControlador implements ActionListener{
    public PantallaServidor pantallaServidorView;

   

    public PantallaServidor getPantallaServidorView() {
        return pantallaServidorView;
    }

    public void setPantallaServidorView(PantallaServidor pantallaServidorView) {
        this.pantallaServidorView = pantallaServidorView;
    }
     public ServidorControlador(PantallaServidor pantallaServidorView) {
        this.pantallaServidorView = pantallaServidorView;
        this.pantallaServidorView.btLimpiarPantalla.addActionListener(this);
        this.pantallaServidorView.btUsuariosEnLinea.addActionListener(this);
        this.pantallaServidorView.btIniciarServidor.addActionListener(this);
        this.pantallaServidorView.btDetenerServidor.addActionListener(this);
        this.pantallaServidorView.btDesbloquear.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==pantallaServidorView.btLimpiarPantalla){
            pantallaServidorView.Chat_Servidor.setText("");    
        }
        if(e.getSource()==pantallaServidorView.btUsuariosEnLinea){
            for (ClienteHilo cliente : listaClientes) {
                if (cliente.getEstadoActivo()) {
                    System.out.println("Cliente PC nombre:" + cliente.getNombrePC());
                }
            }
        }
        if(e.getSource()==this.pantallaServidorView.btIniciarServidor){
            Thread starter = new Thread(new ServerStart());
            starter.start();
            pantallaServidorView.Chat_Servidor.append("Servidor Iniciado...\n");
        }
        if(e.getSource()==pantallaServidorView.btDetenerServidor){
            try {
            Thread.sleep(2000);                 //2000 milliseconds is five second.
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        tellEveryone("Server:el servidor ha sido detenido y los usuarios se han desconectados.\n:Chat");
        pantallaServidorView.Chat_Servidor.append("Servidor Detenido... \n");
        pantallaServidorView.Chat_Servidor.setText("");
        }
        
        if(e.getSource()==pantallaServidorView.btDesbloquear){
             try {
            int fila = pantallaServidorView.jTPC.getSelectedRow();
            String ipSeleccionada = pantallaServidorView.jTPC.getValueAt(fila, 1).toString();
            String nombrePCSeleccionado = pantallaServidorView.jTPC.getValueAt(fila, 0).toString();
            
            //*****************************************************
            //se recorre la lista de clientes y se verifica a cual
            //sokect se le quiere enviar el mensaja (el seleccionado 
            //en la tabla)
            //*****************************************************
            for (ClienteHilo cliente : listaClientes) {
                //se optiene la IP del sokect para compararla con la seleccionada
                String ipCliente = cliente.getSock().getInetAddress().toString();
                if (ipCliente.equals(ipSeleccionada) && cliente.getNombrePC().endsWith(nombrePCSeleccionado)) {
                    //si el sokect es la tiene la ip seleccionada
                    //se le envia un mensaje
                    PrintWriter writer = new PrintWriter(cliente.getSock().getOutputStream());
                    writer.println("Desbloqueese");
                    writer.flush();
                }
            }
        } catch (Exception el) {

        }
            
        }
        
        
    }
    
   /**************************************************************************************************/
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
                    ClienteHilo cliente = new ClienteHilo(clientSock, writer);
                    listaClientes.add(cliente);
                    
                    //se crea un nuevo hilo para el nuevo socket creado, 
                    //independiente en otro hilo 
                    Thread listener = new Thread(cliente);
                    listener.start();
                    
                    //se llena la tabla con los clientes conectados
                    llenarTabla();
                    pantallaServidorView.Chat_Servidor.append("tienes una conexion \n" + clientSock.getInetAddress());
                }
            } catch (Exception ex) {
                pantallaServidorView.Chat_Servidor.append("Error al realizar la conexión. \n");
            }
        }
    }
    
    /***********************************************************************************************/
    
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
                pantallaServidorView.Chat_Servidor.append("enviando: " + message + "\n");
                pantallaServidorView.Chat_Servidor.setCaretPosition(pantallaServidorView.Chat_Servidor.getDocument().getLength());

            } catch (Exception ex) {
                pantallaServidorView.Chat_Servidor.append("Error al enviar mensaje a todos. \n");
            }
        }
    }
    
    /****************************************************************************************************/
    
     public void llenarTabla() {

        DefaultTableModel modeloTabla = new DefaultTableModel();
        pantallaServidorView.jTPC.setModel(modeloTabla);
        String fila[] = new String[5];

        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("IP");
        modeloTabla.addColumn("Estado");
        modeloTabla.addColumn("Hora Inicio");
        modeloTabla.addColumn("Hora Fin");
        TableColumnModel columnModel = pantallaServidorView.jTPC.getColumnModel();
        columnModel.getColumn(2).setPreferredWidth(80);
        
        try {
            //*************************************************
            //*************************************************
            //se recorre la lista de hilos para obtener la
            //información de los clientes conectados
            //*************************************************
            //*************************************************
            for (ClienteHilo cliente : listaClientes) {

                fila[0] = cliente.getNombrePC();
                fila[1] = cliente.getSock().getInetAddress().toString();
                fila[4] = cliente.getEstadoActivo().toString();

                modeloTabla.addRow(fila);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    /***************************************************************************************************/
    
   ArrayList<ClienteHilo> listaClientes;

    public class ClienteHilo implements Runnable {

        private BufferedReader reader;
        private Socket sock;
        private PrintWriter printWriter;
        private String hoInicio = "";
        private String hoFin = "";
        private Calendar calendario = Calendar.getInstance();
        private Boolean estadoActivo;
        private String nombrePC;

        public ClienteHilo(Socket clientSocket, PrintWriter printWriter) {
            this.printWriter = printWriter;
            this.estadoActivo = true;
            try {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            } catch (Exception ex) {
                pantallaServidorView.Chat_Servidor.append("inesperado error... \n");
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
                    pantallaServidorView.Chat_Servidor.append("Recibido: " + message + "\n");
                    
                    //Se decodifica el mensaje
                    String mensajeEnPartes[] = message.split(":");
                    if (mensajeEnPartes[0].equals("N")) {//nuevo usuario
                        this.nombrePC = mensajeEnPartes[1];
                        llenarTabla();// se llena la tabla de clientes
                    }
                }
            } catch (Exception ex) {
                pantallaServidorView.Chat_Servidor.append("conexion perdida. \n");
                ex.printStackTrace();
            }
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
