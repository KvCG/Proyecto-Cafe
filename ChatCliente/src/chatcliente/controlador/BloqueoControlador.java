/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcliente.controlador;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

/**
 *
 * @author Kevin
 */
public class BloqueoControlador {

    private JFrame jframe = null;

    public BloqueoControlador(JFrame f) {
        this.jframe = f;
    }

    public JFrame getJframe() {
        return jframe;
    }

    public void setJframe(JFrame jframe) {
        this.jframe = jframe;
    }
    
    
    public void block() {
        ScheduledExecutorService shelduler = Executors.newSingleThreadScheduledExecutor();
        shelduler.scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        front();
                    }
                }, 500, 50, TimeUnit.MILLISECONDS);
    }

    public void front() {
        jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jframe.toFront();

    }
}
