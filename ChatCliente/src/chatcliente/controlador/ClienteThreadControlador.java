/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcliente.controlador;

//import cr.ac.una.prograIII.appProyecto.vista.PantallaBloqueo;
//import cr.ac.una.prograIII.appProyecto.vista.VentanaPc;
import chatcliente.PantallaBloqueo;
import chatcliente.VentanaPc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.ArrayList;

public class ClienteThreadControlador implements ActionListener {

    public VentanaPc ventanaPcView;
    public PantallaBloqueo pantBloq;
    public BloqueoControlador bloqControl;
    private String NombUsuario, Direccion = "localhost";
    private ArrayList<String> Usuarios = new ArrayList();
    private int puerto = 2222;
    private Boolean EnLinea = false;

    private Socket sock;
    private BufferedReader reader;
    private PrintWriter writer;

    public VentanaPc getVentanaPcView() {
        return ventanaPcView;
    }

    public void setVentanaPcView(VentanaPc ventanaPcView) {
        this.ventanaPcView = ventanaPcView;
    }

    public void ListenThread() {
        Thread IncomingReader = new Thread(new IncomingReader());
        IncomingReader.start();
    }

    public void userAdd(String data) {
        Usuarios.add(data);
    }

    public void userRemove(String data) {
        this.ventanaPcView.Chat_Cliente.append(data + " is now offline.\n");
    }

    public void writeUsers() {
        String[] tempList = new String[(Usuarios.size())];
        Usuarios.toArray(tempList);
        for (String token : tempList) {
            //users.append(token + "\n");
        }
    }

    public void sendDisconnect() {
        String bye = ("D:" + NombUsuario+ ": :Desconectado");
        try {
            writer.println(bye);
            writer.flush();
        } catch (Exception e) {
            ventanaPcView.Chat_Cliente.append("no se ha podido enviar desconectar.\n");
        }
    }

    public void Disconnect() {
        try {
            ventanaPcView.Chat_Cliente.append("\n " + ventanaPcView.txtNombreUsuario.getText() + " Te has Desconectado.\n");
            sock.close();
            reader.close();
            writer.close();
        } catch (Exception ex) {
            ventanaPcView.Chat_Cliente.append("Fallo al Desconectar. \n");
        }
        EnLinea = false;
        ventanaPcView.txtNombreUsuario.setEditable(true);

    }

    public class IncomingReader implements Runnable {

        @Override
        public void run() {
            String[] data;
            String stream, done = "Done", conectado = "Conectado", desconectado = "Desconectado", chat = "Chat";

            try {
                while ((stream = reader.readLine()) != null) {

                    if (stream.equals("1BL")) {
                        bloqControl.getJframe().setVisible(true);
                        //bloqControl.block();
                        sleep(10000);
                        stream = "";
                        bloqControl.getJframe().dispose();
                    }

                    if (stream.equals("1UL")) {
                        bloqControl.getJframe().dispose();
                        stream = "";
                    }

                    ventanaPcView.Chat_Cliente.append(stream);

                }
            } catch (Exception ex) {
            }
        }
    }

    public ClienteThreadControlador(VentanaPc ventanaPcView) {
        this.pantBloq = new PantallaBloqueo();
        this.bloqControl = new BloqueoControlador(pantBloq);
        this.ventanaPcView = ventanaPcView;
        this.ventanaPcView.btConectar.addActionListener(this);
        this.ventanaPcView.btDesconectar.addActionListener(this);
        this.ventanaPcView.btEnviar.addActionListener(this);
        this.ventanaPcView.btConectar.doClick();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventanaPcView.btConectar) {
            if (EnLinea == false) {
                bloqControl.getJframe().setVisible(false);
                //bloqControl.block();
                NombUsuario = ventanaPcView.txtNombreUsuario.getText();
                NombUsuario = "PC1";
                //Direccion=this.ventanaPcView.txtDireccionIP.getText();
                ventanaPcView.txtNombreUsuario.setEditable(false);
                try {
                    //Se crea el sokect
                    sock = new Socket(Direccion, puerto);
                    InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                    reader = new BufferedReader(streamreader);
                    //se envia un mensaje al servidor codificando que se 
                    //conecto un nuevo cliente indicando al inicio del mensaje
                    //"N:" lo que indica Nuevo usuario, despues va el nombre del usuario
                    writer = new PrintWriter(sock.getOutputStream());
                    writer.println("N:" + NombUsuario + ":te has conectado.:Conectado");
                    writer.flush();
                    ventanaPcView.Chat_Cliente.append("Bienvenido " + ventanaPcView.txtNombreUsuario.getText() + " usted se ha conectado al servidor \n");
                    EnLinea = true;
                } catch (Exception ex) {
                    ventanaPcView.Chat_Cliente.append("no se a podido conectar puebe nuevamente \n");
                    ventanaPcView.txtNombreUsuario.setEditable(true);
                }

                ListenThread();

            } else if (EnLinea == true) {
                ventanaPcView.Chat_Cliente.append("Ya esta conectado. \n");
            }

        }

        if (e.getSource() == ventanaPcView.btDesconectar) {
            sendDisconnect();
            Disconnect();
        }

        if (e.getSource() == ventanaPcView.btEnviar) {
            String nothing = "";
            if ((ventanaPcView.txtMensajeEnviar.getText()).equals(nothing)) {
                ventanaPcView.txtMensajeEnviar.setText("");
                ventanaPcView.txtMensajeEnviar.requestFocus();
            } else {
                try {
                    writer.println(NombUsuario + ":" + ventanaPcView.txtMensajeEnviar.getText() + ":" + "Chat");
                    writer.flush(); // flushes the buffer
                } catch (Exception ex) {
                    ventanaPcView.Chat_Cliente.append("No se a enviado el mensaje\n");
                }
                ventanaPcView.txtMensajeEnviar.setText("");
                ventanaPcView.txtMensajeEnviar.requestFocus();
            }

            ventanaPcView.txtMensajeEnviar.setText("");
            ventanaPcView.txtMensajeEnviar.requestFocus();
        }
    }

}
