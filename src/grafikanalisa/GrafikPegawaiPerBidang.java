    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DlgSpesialis.java
 *
 * Created on May 23, 2010, 1:25:13 AM
 */

package grafikanalisa;

import fungsi.WarnaTable;
import fungsi.akses;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import java.awt.Cursor;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author dosen
 */
public class GrafikPegawaiPerBidang extends javax.swing.JDialog {
    private final Connection koneksi=koneksiDB.condb();
    private final validasi Valid=new validasi();
    private sekuel Sequel=new sekuel();
    private ResultSet rs;
    private PreparedStatement ps;
    private final DefaultTableModel tabMode;
    private double total=0,totall=0,totalp=0;
    private int i=0,jmll=0,jmlp=0;
    private String pilihan="";

    /** Creates new form DlgSpesialis
     * @param parent
     * @param modal */
    public GrafikPegawaiPerBidang(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        tabMode=new DefaultTableModel(null,new Object[]{"Bidang/Bagian Pegawai","Jumlah","Persentase(%)","Laki-Laki","Laki-Laki(%)","Perempuan","Perempuan(%)"}){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };

        tbBangsal.setModel(tabMode);
        //tampil();
        //tbJabatan.setDefaultRenderer(Object.class, new WarnaTable(Scroll.getBackground(),Color.GREEN));
        tbBangsal.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbBangsal.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 7; i++) {
            TableColumn column = tbBangsal.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(170);
            }else if(i==1){
                column.setPreferredWidth(50);
            }else if(i==2){
                column.setPreferredWidth(90);
            }else if(i==3){
                column.setPreferredWidth(60);
            }else if(i==4){
                column.setPreferredWidth(80);
            }else if(i==5){
                column.setPreferredWidth(70);
            }else if(i==6){
                column.setPreferredWidth(90);
            }
        }

        tbBangsal.setDefaultRenderer(Object.class, new WarnaTable());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalFrame1 = new widget.InternalFrame();
        panelGlass5 = new widget.panelisi();
        BtnPrint = new widget.Button();
        BtnPrint4 = new widget.Button();
        BtnPrint3 = new widget.Button();
        BtnPrint5 = new widget.Button();
        BtnKeluar3 = new widget.Button();
        Scroll = new widget.ScrollPane();
        tbBangsal = new widget.Table();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Grafik Pegawai Per Bidang/Bagian ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass5.setName("panelGlass5"); // NOI18N
        panelGlass5.setPreferredSize(new java.awt.Dimension(55, 55));
        panelGlass5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+T");
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        panelGlass5.add(BtnPrint);

        BtnPrint4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Bar Chart (copy).png"))); // NOI18N
        BtnPrint4.setMnemonic('G');
        BtnPrint4.setText("Plot");
        BtnPrint4.setToolTipText("Alt+G");
        BtnPrint4.setName("BtnPrint4"); // NOI18N
        BtnPrint4.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrint4ActionPerformed(evt);
            }
        });
        BtnPrint4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrint4KeyPressed(evt);
            }
        });
        panelGlass5.add(BtnPrint4);

        BtnPrint3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Bar Chart (copy).png"))); // NOI18N
        BtnPrint3.setMnemonic('G');
        BtnPrint3.setText("Batang");
        BtnPrint3.setToolTipText("Alt+G");
        BtnPrint3.setName("BtnPrint3"); // NOI18N
        BtnPrint3.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrint3ActionPerformed(evt);
            }
        });
        BtnPrint3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrint3KeyPressed(evt);
            }
        });
        panelGlass5.add(BtnPrint3);

        BtnPrint5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Bar Chart (copy).png"))); // NOI18N
        BtnPrint5.setMnemonic('G');
        BtnPrint5.setText("Pie");
        BtnPrint5.setToolTipText("Alt+G");
        BtnPrint5.setName("BtnPrint5"); // NOI18N
        BtnPrint5.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrint5ActionPerformed(evt);
            }
        });
        BtnPrint5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrint5KeyPressed(evt);
            }
        });
        panelGlass5.add(BtnPrint5);

        BtnKeluar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar3.setMnemonic('K');
        BtnKeluar3.setText("Keluar");
        BtnKeluar3.setToolTipText("Alt+K");
        BtnKeluar3.setName("BtnKeluar3"); // NOI18N
        BtnKeluar3.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluar3ActionPerformed(evt);
            }
        });
        BtnKeluar3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluar3KeyPressed(evt);
            }
        });
        panelGlass5.add(BtnKeluar3);

        internalFrame1.add(panelGlass5, java.awt.BorderLayout.PAGE_END);

        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        tbBangsal.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbBangsal.setName("tbBangsal"); // NOI18N
        Scroll.setViewportView(tbBangsal);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampil();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated

    private void BtnPrint3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrint3ActionPerformed
        try{
            pilihan = (String)JOptionPane.showInputDialog(null,"Silahkan pilih grafik..!","Info Grafik",JOptionPane.QUESTION_MESSAGE,null,new Object[]{"Jumlah Pegawai","Jumlah Pegawai Laki-Laki","Jumlah Pegawai Perempuan"},"Jumlah Pegawai");
            switch (pilihan) {
                case "Jumlah Pegawai":
                    DefaultCategoryDataset dcd = new DefaultCategoryDataset();
                    try {                
                        rs = koneksi.prepareStatement("select pegawai.bidang,count(pegawai.bidang) as jumlah from pegawai where pegawai.stts_aktif='AKTIF' or pegawai.stts_aktif='CUTI' group by pegawai.bidang").executeQuery();
                        while(rs.next()) {
                            dcd.setValue(rs.getDouble(2),rs.getString(1)+"("+rs.getString(2)+")",rs.getString(1));
                        }

                        if(rs!=null){
                            rs.close();
                        }
                    } catch (Exception e) {
                        System.out.println("Notifikasi : " + e);
                    }
                    JFreeChart freeChart = ChartFactory.createBarChart("Grafik Pegawai Per Bidang/Bagian","Bidang/Bagian","Jumlah Pegawai", dcd, PlotOrientation.VERTICAL,true, true,true); 
                    ChartFrame cf = new ChartFrame("Grafik Pegawai Per Bidang/Bagian",freeChart);
                    cf.setSize(Scroll.getWidth(),Scroll.getHeight());   
                    cf.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
                    cf.setLocationRelativeTo(Scroll);
                    cf.setAlwaysOnTop(true);
                    cf.setIconImage(new ImageIcon(super.getClass().getResource("/picture/addressbook-edit24.png")).getImage());
                    cf.setVisible(true);  
                    break;
                case "Jumlah Pegawai Laki-Laki":
                    DefaultCategoryDataset dcd2 = new DefaultCategoryDataset();
                    try {                
                        rs = koneksi.prepareStatement("select pegawai.bidang,count(pegawai.bidang) as jumlah from pegawai where pegawai.jk='Pria' and (pegawai.stts_aktif='AKTIF' or pegawai.stts_aktif='CUTI') group by pegawai.bidang").executeQuery();
                        while(rs.next()) {
                            dcd2.setValue(rs.getDouble(2),rs.getString(1)+"("+rs.getString(2)+")",rs.getString(1));
                        }

                        if(rs!=null){
                            rs.close();
                        }
                    } catch (Exception e) {
                        System.out.println("Notifikasi : " + e);
                    }
                    JFreeChart freeChart2 = ChartFactory.createBarChart("Grafik Pegawai Per Bidang/Bagian","Bidang/Bagian","Jumlah Pegawai", dcd2, PlotOrientation.VERTICAL,true, true,true); 
                    ChartFrame cf2 = new ChartFrame("Grafik Pegawai Per Bidang/Bagian",freeChart2);
                    cf2.setSize(Scroll.getWidth(),Scroll.getHeight());   
                    cf2.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
                    cf2.setLocationRelativeTo(Scroll);
                    cf2.setAlwaysOnTop(true);
                    cf2.setIconImage(new ImageIcon(super.getClass().getResource("/picture/addressbook-edit24.png")).getImage());
                    cf2.setVisible(true); 
                    break;
                case "Jumlah Pegawai Perempuan":
                    DefaultCategoryDataset dcd3 = new DefaultCategoryDataset();
                    try {                
                        rs = koneksi.prepareStatement("select pegawai.bidang,count(pegawai.bidang) as jumlah from pegawai where pegawai.jk='Wanita' and (pegawai.stts_aktif='AKTIF' or pegawai.stts_aktif='CUTI') group by pegawai.bidang").executeQuery();
                        while(rs.next()) {
                            dcd3.setValue(rs.getDouble(2),rs.getString(1)+"("+rs.getString(2)+")",rs.getString(1));
                        }

                        if(rs!=null){
                            rs.close();
                        }
                    } catch (Exception e) {
                        System.out.println("Notifikasi : " + e);
                    }
                    JFreeChart freeChart3 = ChartFactory.createBarChart("Grafik Pegawai Per Bidang/Bagian","Bidang/Bagian","Jumlah Pegawai", dcd3, PlotOrientation.VERTICAL,true, true,true); 
                    ChartFrame cf3 = new ChartFrame("Grafik Pegawai Per Bidang/Bagian",freeChart3);
                    cf3.setSize(Scroll.getWidth(),Scroll.getHeight());   
                    cf3.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
                    cf3.setLocationRelativeTo(Scroll);
                    cf3.setAlwaysOnTop(true);
                    cf3.setIconImage(new ImageIcon(super.getClass().getResource("/picture/addressbook-edit24.png")).getImage());
                    cf3.setVisible(true); 
                    break;
            }
        } catch (Exception e) {
        }  
    }//GEN-LAST:event_BtnPrint3ActionPerformed

    private void BtnPrint3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrint3KeyPressed
        
    }//GEN-LAST:event_BtnPrint3KeyPressed

    private void BtnKeluar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluar3ActionPerformed
        dispose();
    }//GEN-LAST:event_BtnKeluar3ActionPerformed

    private void BtnKeluar3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluar3KeyPressed
        
    }//GEN-LAST:event_BtnKeluar3KeyPressed

    private void BtnPrint4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrint4ActionPerformed
        try {
            pilihan = (String)JOptionPane.showInputDialog(null,"Silahkan pilih grafik..!","Info Grafik",JOptionPane.QUESTION_MESSAGE,null,new Object[]{"Jumlah Pegawai","Jumlah Pegawai Laki-Laki","Jumlah Pegawai Perempuan"},"Jumlah Pegawai");
            switch (pilihan) {
                case "Jumlah Pegawai":
                    grafiksql2 kas=new grafiksql2("Grafik Pegawai Per Bidang/Bagian",
                            "select pegawai.bidang,count(pegawai.bidang) as jumlah from pegawai where pegawai.stts_aktif='AKTIF' or pegawai.stts_aktif='CUTI' group by pegawai.bidang","Bidang/Bagian");
                    kas.setSize(Scroll.getWidth(),Scroll.getHeight());  
                    kas.setModal(true);
                    kas.setAlwaysOnTop(true);
                    kas.setLocationRelativeTo(Scroll);
                    kas.setVisible(true);
                    break;
                case "Jumlah Pegawai Laki-Laki":
                    grafiksql2 kas2=new grafiksql2("Grafik Pegawai Per Bidang/Bagian",
                            "select pegawai.bidang,count(pegawai.bidang) as jumlah from pegawai where pegawai.jk='Pria' and (pegawai.stts_aktif='AKTIF' or pegawai.stts_aktif='CUTI') group by pegawai.bidang","Bidang/Bagian");
                    kas2.setSize(Scroll.getWidth(),Scroll.getHeight());  
                    kas2.setModal(true);
                    kas2.setAlwaysOnTop(true);
                    kas2.setLocationRelativeTo(Scroll);
                    kas2.setVisible(true);
                    break;
                case "Jumlah Pegawai Perempuan":
                    grafiksql2 kas3=new grafiksql2("Grafik Pegawai Per Bidang/Bagian",
                            "select pegawai.bidang,count(pegawai.bidang) as jumlah from pegawai where pegawai.jk='Wanita' and (pegawai.stts_aktif='AKTIF' or pegawai.stts_aktif='CUTI') group by pegawai.bidang","Bidang/Bagian");
                    kas3.setSize(Scroll.getWidth(),Scroll.getHeight());  
                    kas3.setModal(true);
                    kas3.setAlwaysOnTop(true);
                    kas3.setLocationRelativeTo(Scroll);
                    kas3.setVisible(true);
                    break;
            }
        } catch (Exception e) {
        }       
    }//GEN-LAST:event_BtnPrint4ActionPerformed

    private void BtnPrint4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrint4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnPrint4KeyPressed

    private void BtnPrint5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrint5ActionPerformed
        try{
            pilihan = (String)JOptionPane.showInputDialog(null,"Silahkan pilih grafik..!","Info Grafik",JOptionPane.QUESTION_MESSAGE,null,new Object[]{"Jumlah Pegawai","Jumlah Pegawai Laki-Laki","Jumlah Pegawai Perempuan"},"Jumlah Pegawai");
            switch (pilihan) {
                case "Jumlah Pegawai":
                    DefaultPieDataset dpd = new DefaultPieDataset();
                    try {                
                        rs = koneksi.prepareStatement("select pegawai.bidang,count(pegawai.bidang) as jumlah from pegawai where pegawai.stts_aktif='AKTIF' or pegawai.stts_aktif='CUTI' group by pegawai.bidang").executeQuery();
                        while(rs.next()) {
                            dpd.setValue(rs.getString(1)+"("+rs.getString(2)+")",rs.getDouble(2));
                        }

                        if(rs!=null){
                            rs.close();
                        }
                    } catch (Exception e) {
                        System.out.println("Notifikasi : " + e);
                    } 

                    JFreeChart freeChart = ChartFactory.createPieChart("Grafik Pegawai Per Bidang/Bagian",dpd,true,true, false); //String title,PieDatasheet datasheet,boolean legends,boolean tooltips,boolean url 
                    ChartFrame cf = new ChartFrame("Grafik Pegawai Per Bidang/Bagian",freeChart);
                    cf.setSize(Scroll.getWidth(),Scroll.getHeight());   
                    cf.setLocationRelativeTo(Scroll);
                    cf.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
                    cf.setAlwaysOnTop(true);
                    cf.setIconImage(new ImageIcon(super.getClass().getResource("/picture/addressbook-edit24.png")).getImage());
                    cf.setVisible(true);  
                    break;
                case "Jumlah Pegawai Laki-Laki":
                    DefaultPieDataset dpd2 = new DefaultPieDataset();
                    try {                
                        rs = koneksi.prepareStatement("select pegawai.bidang,count(pegawai.bidang) as jumlah from pegawai where pegawai.jk='Pria' and (pegawai.stts_aktif='AKTIF' or pegawai.stts_aktif='CUTI') group by pegawai.bidang").executeQuery();
                        while(rs.next()) {
                            dpd2.setValue(rs.getString(1)+"("+rs.getString(2)+")",rs.getDouble(2));
                        }

                        if(rs!=null){
                            rs.close();
                        }
                    } catch (Exception e) {
                        System.out.println("Notifikasi : " + e);
                    } 

                    JFreeChart freeChart2 = ChartFactory.createPieChart("Grafik Pegawai Per Bidang/Bagian",dpd2,true,true, false); //String title,PieDatasheet datasheet,boolean legends,boolean tooltips,boolean url 
                    ChartFrame cf2 = new ChartFrame("Grafik Pegawai Per Bidang/Bagian",freeChart2);
                    cf2.setSize(Scroll.getWidth(),Scroll.getHeight());   
                    cf2.setLocationRelativeTo(Scroll);
                    cf2.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
                    cf2.setAlwaysOnTop(true);
                    cf2.setIconImage(new ImageIcon(super.getClass().getResource("/picture/addressbook-edit24.png")).getImage());
                    cf2.setVisible(true);  
                    break;
                case "Jumlah Pegawai Perempuan":
                    DefaultPieDataset dpd3 = new DefaultPieDataset();
                    try {                
                        rs = koneksi.prepareStatement("select pegawai.bidang,count(pegawai.bidang) as jumlah from pegawai where pegawai.jk='Wanita' and (pegawai.stts_aktif='AKTIF' or pegawai.stts_aktif='CUTI') group by pegawai.bidang").executeQuery();
                        while(rs.next()) {
                            dpd3.setValue(rs.getString(1)+"("+rs.getString(2)+")",rs.getDouble(2));
                        }

                        if(rs!=null){
                            rs.close();
                        }
                    } catch (Exception e) {
                        System.out.println("Notifikasi : " + e);
                    } 

                    JFreeChart freeChart3 = ChartFactory.createPieChart("Grafik Pegawai Per Bidang/Bagian",dpd3,true,true, false); //String title,PieDatasheet datasheet,boolean legends,boolean tooltips,boolean url 
                    ChartFrame cf3 = new ChartFrame("Grafik Pegawai Per Bidang/Bagian",freeChart3);
                    cf3.setSize(Scroll.getWidth(),Scroll.getHeight());   
                    cf3.setLocationRelativeTo(Scroll);
                    cf3.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
                    cf3.setAlwaysOnTop(true);
                    cf3.setIconImage(new ImageIcon(super.getClass().getResource("/picture/addressbook-edit24.png")).getImage());
                    cf3.setVisible(true); 
                    break;
            }
        } catch (Exception e) {
        }  
    }//GEN-LAST:event_BtnPrint5ActionPerformed

    private void BtnPrint5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrint5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnPrint5KeyPressed

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            //TCari.requestFocus();
        }else if(tabMode.getRowCount()!=0){

            Map<String, Object> param = new HashMap<>();
            param.put("namars",akses.getnamars());
            param.put("alamatrs",akses.getalamatrs());
            param.put("kotars",akses.getkabupatenrs());
            param.put("propinsirs",akses.getpropinsirs());
            param.put("kontakrs",akses.getkontakrs());
            param.put("emailrs",akses.getemailrs());
            param.put("logo",Sequel.cariGambar("select setting.logo from setting"));
            Sequel.queryu("delete from temporary_grafik");
            for(int r=0;r<tabMode.getRowCount();r++){
                Sequel.menyimpan("temporary_grafik","'0','"+
                    tabMode.getValueAt(r,0).toString()+"','"+
                    tabMode.getValueAt(r,1).toString()+"','"+
                    tabMode.getValueAt(r,2).toString()+"','"+
                    tabMode.getValueAt(r,3).toString()+"','"+
                    tabMode.getValueAt(r,4).toString()+"','"+
                    tabMode.getValueAt(r,5).toString()+"','"+
                    tabMode.getValueAt(r,6).toString()+"','','','','','','','','','','','','','','','','','','','','','','','','','','','','','',''","Rekap");
            }

            Valid.MyReport("rptPegawaiPerBagian.jasper","report","::[ Laporan Jumlah Pegawai Per Bidang/Bagian ]::",param);
        }
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnPrintActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            GrafikPegawaiPerBidang dialog = new GrafikPegawaiPerBidang(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnKeluar3;
    private widget.Button BtnPrint;
    private widget.Button BtnPrint3;
    private widget.Button BtnPrint4;
    private widget.Button BtnPrint5;
    private widget.ScrollPane Scroll;
    private widget.InternalFrame internalFrame1;
    private widget.panelisi panelGlass5;
    private widget.Table tbBangsal;
    // End of variables declaration//GEN-END:variables

    private void tampil() {
        Valid.tabelKosong(tabMode);
        try{
            ps=koneksi.prepareStatement(
               "select pegawai.bidang,count(pegawai.bidang) as jumlah from pegawai where pegawai.stts_aktif='AKTIF' or pegawai.stts_aktif='CUTI' group by pegawai.bidang");
            try {
                rs=ps.executeQuery();
                total=0;
                totall=0;
                totalp=0;
                while(rs.next()){
                    total=total+rs.getDouble(2);
                    jmll=Sequel.cariInteger("select count(bidang) from pegawai where pegawai.jk='Pria' and (pegawai.stts_aktif='AKTIF' or pegawai.stts_aktif='CUTI') and bidang=?",rs.getString(1));
                    jmlp=Sequel.cariInteger("select count(bidang) from pegawai where pegawai.jk='Wanita' and (pegawai.stts_aktif='AKTIF' or pegawai.stts_aktif='CUTI') and bidang=?",rs.getString(1));
                    totall=totall+jmll;
                    totalp=totalp+jmlp;
                    tabMode.addRow(new String[]{
                        rs.getString(1),rs.getString(2),"",jmll+"","",jmlp+"",""
                    });
                }
                if(tabMode.getRowCount()>0){
                    tabMode.addRow(new String[]{"Jumlah : ",total+"","100 %",totall+"","100 %",totalp+"","100 %"});
                    for(i=0;i<tbBangsal.getRowCount();i++){ 
                        tbBangsal.setValueAt(Math.round((Double.parseDouble(tbBangsal.getValueAt(i,1).toString())/total)*100)+" %",i,2);
                        tbBangsal.setValueAt(Math.round((Double.parseDouble(tbBangsal.getValueAt(i,3).toString())/totall)*100)+" %",i,4);
                        tbBangsal.setValueAt(Math.round((Double.parseDouble(tbBangsal.getValueAt(i,5).toString())/totalp)*100)+" %",i,6);
                    }
                }
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }                
        }catch(SQLException e){
            System.out.println("Notifikasi : "+e);
        }
    }
}
