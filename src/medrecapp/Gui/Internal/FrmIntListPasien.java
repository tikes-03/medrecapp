/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmIntListPasien.java
 *
 * Created on Dec 23, 2013, 12:25:52 AM
 */
package medrecapp.Gui.Internal;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import medrecapp.Dao.PasienDao;
import medrecapp.Gui.Dialog.FrmDlgPasien;
import medrecapp.Gui.Dialog.FrmDlgRekMedByNoRm;
import medrecapp.Services.PasienService;
import medrecapp.TabelModel.TabelModelPasien;

/**
 *
 * @author Fachrul Pralienka BM
 */
public class FrmIntListPasien extends javax.swing.JInternalFrame {

    PasienService ps = new PasienService();
    TabelModelPasien tabelModelPasien = new TabelModelPasien();    
    public static String judul;
    public static String ID, nama, jk, tglLahir, agama, alamat;

    /** Creates new form FrmIntListPasien */
    public FrmIntListPasien() {
        initComponents();
        tabelPasien.setModel(tabelModelPasien);
        tabelModelPasien.setData(ps.serviceGetAllPasien());
        if(!PasienDao.hasilGetAll.equals("ok")){
            JOptionPane.showMessageDialog(null, PasienDao.hasilGetAll,"Get All Pasien Gagal!", JOptionPane.ERROR_MESSAGE);
        }
        sesuaikan();

        btnTambah.setEnabled(true);
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);
        btnRekamMedis.setEnabled(false);

        tabelPasien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int row = tabelPasien.getSelectedRow();
                if (row != -1) {
                    ID = tabelPasien.getValueAt(row, 0).toString();
                    nama = tabelPasien.getValueAt(row, 1).toString();
                    jk = tabelPasien.getValueAt(row, 2).toString();
                    tglLahir = tabelPasien.getValueAt(row, 3).toString();
                    agama = tabelPasien.getValueAt(row, 4).toString();
                    alamat = tabelPasien.getValueAt(row, 5).toString();
                }
                btnTambah.setEnabled(false);
                btnUbah.setEnabled(true);
                btnHapus.setEnabled(true);
                btnRekamMedis.setEnabled(true);
            }
        });

    }

    public final void sesuaikan() {
        TableColumnModel tcm = tabelPasien.getColumnModel();
        for (int kolom = 0; kolom < tcm.getColumnCount(); kolom++) {
            int lebarKolomMax = 0;
            for (int baris = 0; baris < tabelPasien.getRowCount(); baris++) {
                TableCellRenderer tcr = tabelPasien.getCellRenderer(baris, kolom);
                Object nilaiTable = tabelPasien.getValueAt(baris, kolom);
                Component comp = tcr.getTableCellRendererComponent(tabelPasien, nilaiTable,
                        false, false, baris, kolom);
                lebarKolomMax = Math.max(comp.getPreferredSize().width, lebarKolomMax);
            }
            TableColumn tc = tcm.getColumn(kolom);
            tc.setPreferredWidth(lebarKolomMax);
        }
    }

    public void refresh(){
        tabelModelPasien.setData(ps.serviceGetAllPasien());
        btnTambah.setEnabled(true);
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);
        btnRekamMedis.setEnabled(false);
        txtCari.setText("");
        txtCari.requestFocus();
        sesuaikan();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPasien = new javax.swing.JTable();
        btnRekamMedis = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("Masukkan No RM / Nama");

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        tabelPasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelPasien);

        btnRekamMedis.setText("LIHAT REKAM MEDIS");
        btnRekamMedis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRekamMedisActionPerformed(evt);
            }
        });

        jLabel2.setText(":");

        btnTambah.setText("TAMBAH");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setText("UBAH");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnRefresh.setText("REFRESH");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRekamMedis, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(420, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 363, Short.MAX_VALUE)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRekamMedis, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRekamMedisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRekamMedisActionPerformed
        // TODO add your handling code here:
        FrmDlgRekMedByNoRm fDB = new FrmDlgRekMedByNoRm(null, true);
        fDB.setVisible(true);
    }//GEN-LAST:event_btnRekamMedisActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        judul = "Tambah Pasien";
        FrmDlgPasien fDB = new FrmDlgPasien(null, true);
        fDB.setVisible(true);        
        refresh();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        judul = "Ubah Pasien";
        FrmDlgPasien fDB = new FrmDlgPasien(null, true);
        fDB.setVisible(true);
        refresh();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int row = tabelPasien.getSelectedRow();
        if (row == -1) {
            return;
        }

        int pilih = JOptionPane.showConfirmDialog(rootPane,
                "Yakin ingin mengahapus data yang dipilih?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (pilih == JOptionPane.OK_OPTION) {

            ps.serviceDeletePasien(tabelPasien.getValueAt(row, 0).toString());

            if (PasienDao.hasilDelete.equals("ok")) {
                JOptionPane.showMessageDialog(null, "Data pasien berhasil dihapus!","Delete Pasien",JOptionPane.INFORMATION_MESSAGE);
                refresh();
            } else {
                JOptionPane.showMessageDialog(null, PasienDao.hasilDelete,"Delete Pasien Gagal!",JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
        tabelModelPasien.setData(ps.serviceGetAllPasienByNoRm(txtCari.getText()));
        if (tabelModelPasien.getRowCount() == 0) {
            tabelModelPasien.setData(ps.serviceGetAllPasienByNama(txtCari.getText()));
        }
        btnTambah.setEnabled(true);
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);
        btnRekamMedis.setEnabled(false);
    }//GEN-LAST:event_txtCariKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRekamMedis;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelPasien;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
