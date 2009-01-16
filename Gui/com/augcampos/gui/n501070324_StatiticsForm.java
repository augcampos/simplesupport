/**
 *      Copyright 2008 Augusto Campos <b>augcampos&#64augcampos.pt></b><br>
 *      This program is free software; you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation; either version 3 of the License.
 *      <p>
 *      This program is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *      <p>
 *      You should have received a copy of the GNU General Public License
 *      along with this program; if not, write to the Free Software
 *      Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 *      MA 02110-1301, USA.
 */
package com.augcampos.gui;

import com.augcampos.core.n501070324_Intervencao;
import com.augcampos.core.n501070324_Intervencoes;
import com.augcampos.core.n501070324_PedidoAssistencia;
import com.augcampos.core.n501070324_PedidoSuporteFormacao;
import com.augcampos.core.n501070324_PedidoSuporteSistema;
import com.augcampos.core.n501070324_PedidosAssistencia;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author Augusto Campos <b>augcampos@augcampos.pt</b>
 */
public class n501070324_StatiticsForm extends javax.swing.JInternalFrame {

    private n501070324_PedidosAssistencia pedidosAssistenciaLnk;
    private n501070324_Intervencoes intervencoesLnk;
    private DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

    /** Creates new form n501070324_StatiticsForm
     * @param pa
     * @param in
     */
    public n501070324_StatiticsForm(n501070324_PedidosAssistencia pa, n501070324_Intervencoes in) {
        this.pedidosAssistenciaLnk = pa;
        this.intervencoesLnk = in;
        initComponents();
        txtAte.setText(df.format(new Date()));
        refreshData();
    }

    private String getAveragePedidoTime() {
        int tmpCount = 0;
        int tmpTime = 0;

        for (n501070324_PedidoAssistencia p : getPedidosResolvidosList()) {
            for (n501070324_Intervencao i : intervencoesLnk.getList(p.getNumero())) {
                tmpCount++;
                tmpTime += i.getDuracao();
            }
        }

        if (tmpCount < 1) {
            return "0 Horas";
        } else {
            return "" + (tmpTime / tmpCount) + " Horas";
        }
    }

    private String getAveragePedidosNumber() {
        int tmpCount = 0;

        for (n501070324_PedidoAssistencia p : getPedidosResolvidosList()) {
            tmpCount += intervencoesLnk.getList(p.getNumero()).size();
        }

        return "" + tmpCount;
    }

    private String getPedidosResolvidos() {
        return "" + getPedidosResolvidosList().size();
    }

    private String getTotalNumberPedidos() {
        int tmpCount = 0;

        for (n501070324_PedidoAssistencia p : pedidosAssistenciaLnk.getList()) {
            if (comparePA(p)) {
                tmpCount++;
            }
        }

        return "" + tmpCount;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblPedidos = new javax.swing.JLabel();
        lblPedidosResolvidos = new javax.swing.JLabel();
        lblMediaTempo = new javax.swing.JLabel();
        lblMediaPedidos = new javax.swing.JLabel();
        btRefresh = new javax.swing.JButton();
        ckSistema = new javax.swing.JCheckBox();
        ckFormacao = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        txtDe = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAte = new javax.swing.JTextField();

        setClosable(true);
        setResizable(true);
        setTitle("Estatisticas");
        setDoubleBuffered(true);
        setMinimumSize(new java.awt.Dimension(612, 236));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Nº de Pedidos :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setText("Nº Pedidos Resolvidos :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setText("Tempo Medio de Resolução :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        jLabel4.setText("Nº Medio de Intervenções por Pedido :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        lblPedidos.setText("0");
        lblPedidos.setMinimumSize(new java.awt.Dimension(100, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 0);
        getContentPane().add(lblPedidos, gridBagConstraints);

        lblPedidosResolvidos.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 0);
        getContentPane().add(lblPedidosResolvidos, gridBagConstraints);

        lblMediaTempo.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 0);
        getContentPane().add(lblMediaTempo, gridBagConstraints);

        lblMediaPedidos.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 0);
        getContentPane().add(lblMediaPedidos, gridBagConstraints);

        btRefresh.setText("Actualizar");
        btRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefreshActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(17, 0, 0, 0);
        getContentPane().add(btRefresh, gridBagConstraints);

        ckSistema.setMnemonic('P');
        ckSistema.setSelected(true);
        ckSistema.setText("Pedidos Sistema");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(ckSistema, gridBagConstraints);

        ckFormacao.setSelected(true);
        ckFormacao.setText("Pedidos Formação");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(ckFormacao, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        txtDe.setText("1900/01/01");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(txtDe, gridBagConstraints);

        jLabel5.setText("  Até  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jLabel5, gridBagConstraints);

        txtAte.setText("9999/99/99");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(txtAte, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefreshActionPerformed
        refreshData();
    }//GEN-LAST:event_btRefreshActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRefresh;
    private javax.swing.JCheckBox ckFormacao;
    private javax.swing.JCheckBox ckSistema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMediaPedidos;
    private javax.swing.JLabel lblMediaTempo;
    private javax.swing.JLabel lblPedidos;
    private javax.swing.JLabel lblPedidosResolvidos;
    private javax.swing.JTextField txtAte;
    private javax.swing.JTextField txtDe;
    // End of variables declaration//GEN-END:variables

    private void refreshData() {

        lblPedidos.setText("<Actualizar>");
        lblPedidosResolvidos.setText("<Actualizar>");
        lblMediaTempo.setText("<Actualizar>");
        lblMediaPedidos.setText("<Actualizar>");


        lblPedidos.setText(getTotalNumberPedidos());
        lblPedidosResolvidos.setText(getPedidosResolvidos());
        lblMediaTempo.setText(getAveragePedidoTime());
        lblMediaPedidos.setText(getAveragePedidosNumber());

    }

    private LinkedList<n501070324_PedidoAssistencia> getPedidosResolvidosList() {
        LinkedList<n501070324_PedidoAssistencia> openPA = new LinkedList<n501070324_PedidoAssistencia>();
        for (n501070324_PedidoAssistencia pa : pedidosAssistenciaLnk.getList()) {
            if (comparePA(pa)) {
                boolean insert = false;
                // only add if is not resolved
                for (n501070324_Intervencao i : intervencoesLnk.getList(pa.getNumero())) {
                    if (i.isResolvido()) {
                        insert = true;
                        break;
                    }
                }
                if (insert) {
                    openPA.add(pa);
                }
            }
        }
        return openPA;
    }

    private boolean compareDate(Date d) {
        Date d1 = new Date(txtDe.getText());
        Date d2 = new Date(txtAte.getText());

        return ((d1.compareTo(d) <= 0) && (d2.compareTo(d) >= 0));
    }

    private boolean comparePA(n501070324_PedidoAssistencia pa) {
        boolean tmpTipo = false;
        if (ckSistema.isSelected() && pa.getTipo() == n501070324_PedidoSuporteSistema.COD_TIPO) {
            tmpTipo = true;
        }
        if (ckFormacao.isSelected() && pa.getTipo() == n501070324_PedidoSuporteFormacao.COD_TIPO) {
            tmpTipo = true;
        }

        if (tmpTipo && compareDate(pa.getData())) {
            return true;
        } else {
            return false;
        }
    }
}
