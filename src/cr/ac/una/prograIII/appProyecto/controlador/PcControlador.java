
package cr.ac.una.prograIII.appProyecto.controlador;

import cr.ac.una.prograIII.appProyecto.domain.Pc;
import cr.ac.una.prograIII.appProyecto.vista.MantePc;
import cr.ac.una.prograIII.appProyecto.vista.PantallaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class PcControlador implements ActionListener {
    private MantePc mantPc;
    private ArrayList<Pc> listaPc ;
    PantallaPrincipal p ;
    private int c;

    public PcControlador() {
        mantPc=new MantePc();
        
        
        
    }

    public PcControlador(MantePc mantPc, ArrayList<Pc> listaPc, int c,PantallaPrincipal p) {
        this.mantPc = mantPc;
        this.listaPc = listaPc;
        this.c = c;
        this.p=p;
        this.mantPc.btInsertar.addActionListener(this);
        cargarTabla(mantPc.jTablePc);
        

    }

    

    public MantePc getMantPc() {
        return mantPc;
    }

    public void setMantPc(MantePc mantPc) {
        this.mantPc = mantPc;
    }

    public ArrayList<Pc> getListaPc() {
        return listaPc;
    }

    public void setListaPc(ArrayList<Pc> listaPc) {
        this.listaPc = listaPc;
    }

    public void cargarTabla(JTable tablaPc){
        tablaPc.setVisible(true);
         DefaultTableModel modelo= new DefaultTableModel();
         String datos[]=new String[1];
         modelo.addColumn("Numero Pc");
         for(Pc v:listaPc){
             datos[0]=v.getText();
             modelo.addRow(datos);
         
         
         }
         tablaPc.setModel(modelo);
    
    
    }
   
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.mantPc.btInsertar){
            Pc aux= new Pc(c);
            aux.setText("Pc "+ c);
            listaPc.add(aux);
            
            
            cargarTabla(this.mantPc.jTablePc);
            JOptionPane.showMessageDialog(null, "Pc agregada");
            c++;
            
        }
        
        p.cargaPc.doClick();
    }
    
}
