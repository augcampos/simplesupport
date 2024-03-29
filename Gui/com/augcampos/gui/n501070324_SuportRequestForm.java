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
import com.augcampos.core.n501070324_Pessoas;
import com.augcampos.core.n501070324_PostoTrabalho;
import com.augcampos.core.n501070324_PostosTrabalho;
import com.augcampos.core.n501070324_Utilizador;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 ** @author Augusto Campos <b>augcampos@augcampos.pt</b>
 */
public class n501070324_SuportRequestForm extends javax.swing.JInternalFrame {

    private n501070324_Pessoas pesoasLnk;
    private n501070324_PedidosAssistencia pedidosAssistenciaLnk;
    private n501070324_PostosTrabalho postosTrabalhoLnk;
    private n501070324_Intervencoes intervencoesLnk;

    /** Creates new form n501070324_UserForm
     * @param pa
     * @param ps
     * @param in
     * @param pt
     */
    public n501070324_SuportRequestForm(n501070324_PedidosAssistencia pa, n501070324_Pessoas ps, n501070324_PostosTrabalho pt, n501070324_Intervencoes in) {
        this.pedidosAssistenciaLnk = pa;
        this.pesoasLnk = ps;
        this.postosTrabalhoLnk = pt;
        this.intervencoesLnk = in;

        initComponents();


        tblList.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    editData();
                }
            }
        });

        tblList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                refreshDetails(getSelect());
            }
        });

        refreshData();
        refreshDetails(getSelect());
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

        tbActions = new javax.swing.JToolBar();
        btAdd = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btDelete = new javax.swing.JButton();
        tabsMain = new javax.swing.JTabbedPane();
        pnList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
        pnDetails = new javax.swing.JPanel();
        pnMain = new javax.swing.JPanel();
        pnPA = new javax.swing.JPanel();
        lblNumero = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        frfDate = new javax.swing.JFormattedTextField();
        cbUsers = new javax.swing.JComboBox();
        cbType = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnF = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTema = new javax.swing.JTextArea();
        pnS = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtProblema = new javax.swing.JTextArea();
        cbPT = new javax.swing.JComboBox();
        lblCPU = new javax.swing.JLabel();
        lblRAM = new javax.swing.JLabel();
        lblDisk = new javax.swing.JLabel();
        lblSO = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pmInterv = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblIntervencoes = new javax.swing.JTable();
        pnBts = new javax.swing.JPanel();
        btSave = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setClosable(true);
        setTitle("Pedidos Suporte");
        setMaximumSize(new java.awt.Dimension(404, 171));
        setMinimumSize(new java.awt.Dimension(404, 100));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        tbActions.setFloatable(false);
        tbActions.setRollover(true);
        tbActions.setFocusable(false);
        tbActions.setMaximumSize(new java.awt.Dimension(50, 50));
        tbActions.setMinimumSize(new java.awt.Dimension(50, 50));
        tbActions.setPreferredSize(new java.awt.Dimension(50, 50));

        btAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/augcampos/gui/webdev-add-48x48.png"))); // NOI18N
        btAdd.setText("Adicionar");
        btAdd.setToolTipText("");
        btAdd.setFocusable(false);
        btAdd.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });
        tbActions.add(btAdd);

        btEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/augcampos/gui/webdev-config-48x48.png"))); // NOI18N
        btEdit.setText("Editar");
        btEdit.setToolTipText("");
        btEdit.setFocusable(false);
        btEdit.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });
        tbActions.add(btEdit);
        tbActions.add(jSeparator1);

        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/augcampos/gui/webdev-remove-48x48.png"))); // NOI18N
        btDelete.setText("Apagar");
        btDelete.setToolTipText("");
        btDelete.setFocusable(false);
        btDelete.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        tbActions.add(btDelete);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 100.0;
        getContentPane().add(tbActions, gridBagConstraints);

        tabsMain.setPreferredSize(new java.awt.Dimension(732, 400));

        pnList.setLayout(new java.awt.GridBagLayout());

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nr", "Data", "Utilizador", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblList.setColumnSelectionAllowed(true);
        tblList.setDoubleBuffered(true);
        tblList.setOpaque(false);
        tblList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblList);
        tblList.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblList.getColumnModel().getColumn(0).setResizable(false);
        tblList.getColumnModel().getColumn(0).setPreferredWidth(10);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        pnList.add(jScrollPane1, gridBagConstraints);

        tabsMain.addTab("Listagem", pnList);

        pnDetails.setLayout(new java.awt.GridBagLayout());

        pnMain.setLayout(new java.awt.GridBagLayout());

        pnPA.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedido Suporte"));

        lblNumero.setText("0");

        jLabel1.setText("Numero :");

        frfDate.setText("9999/99/99");
        frfDate.setPreferredSize(new java.awt.Dimension(100, 24));

        cbUsers.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Formação", "Sistema" }));
        cbType.setEnabled(false);
        cbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTypeActionPerformed(evt);
            }
        });

        jLabel4.setText("Data :");

        jLabel5.setText("Tipo :");

        jLabel6.setText("Utiizador :");

        javax.swing.GroupLayout pnPALayout = new javax.swing.GroupLayout(pnPA);
        pnPA.setLayout(pnPALayout);
        pnPALayout.setHorizontalGroup(
            pnPALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnPALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addGroup(pnPALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(pnPALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(frfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnPALayout.setVerticalGroup(
            pnPALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPALayout.createSequentialGroup()
                .addGroup(pnPALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNumero)
                    .addComponent(frfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnMain.add(pnPA, gridBagConstraints);

        pnF.setBorder(javax.swing.BorderFactory.createTitledBorder("Formação"));
        pnF.setMinimumSize(new java.awt.Dimension(37, 100));
        pnF.setLayout(new java.awt.GridBagLayout());

        jLabel2.setLabelFor(txtTema);
        jLabel2.setText("Tema :  ");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        pnF.add(jLabel2, gridBagConstraints);

        txtTema.setColumns(20);
        txtTema.setRows(3);
        txtTema.setMargin(new java.awt.Insets(5, 5, 5, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        pnF.add(txtTema, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnMain.add(pnF, gridBagConstraints);

        pnS.setBorder(javax.swing.BorderFactory.createTitledBorder("Sistema"));
        pnS.setPreferredSize(new java.awt.Dimension(515, 100));
        pnS.setLayout(new java.awt.GridBagLayout());

        jLabel3.setLabelFor(txtProblema);
        jLabel3.setText("Problema :  ");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnS.add(jLabel3, gridBagConstraints);

        txtProblema.setColumns(20);
        txtProblema.setRows(3);
        txtProblema.setMargin(new java.awt.Insets(5, 5, 5, 10));
        txtProblema.setMinimumSize(new java.awt.Dimension(15, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 100.0;
        pnS.add(txtProblema, gridBagConstraints);

        cbPT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPTActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnS.add(cbPT, gridBagConstraints);

        lblCPU.setText(" ");
        lblCPU.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        pnS.add(lblCPU, gridBagConstraints);

        lblRAM.setText(" ");
        lblRAM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        pnS.add(lblRAM, gridBagConstraints);

        lblDisk.setText(" ");
        lblDisk.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        pnS.add(lblDisk, gridBagConstraints);

        lblSO.setText(" ");
        lblSO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        pnS.add(lblSO, gridBagConstraints);

        jLabel8.setText("Posto de Trabalho:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnS.add(jLabel8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnMain.add(pnS, gridBagConstraints);

        pmInterv.setBorder(javax.swing.BorderFactory.createTitledBorder("Intervenções"));
        pmInterv.setPreferredSize(new java.awt.Dimension(515, 100));
        pmInterv.setLayout(new javax.swing.BoxLayout(pmInterv, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(456, 50));

        tblIntervencoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nr", "Data", "Tecnico", "Descrição", "Duração", "Resolvido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblIntervencoes.setColumnSelectionAllowed(true);
        tblIntervencoes.setPreferredSize(new java.awt.Dimension(100, 72));
        jScrollPane2.setViewportView(tblIntervencoes);
        tblIntervencoes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        pmInterv.add(jScrollPane2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnMain.add(pmInterv, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        pnDetails.add(pnMain, gridBagConstraints);

        pnBts.setPreferredSize(new java.awt.Dimension(100, 70));

        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/augcampos/gui/webdev-ok-48x48.png"))); // NOI18N
        btSave.setText("Gravar");
        btSave.setMaximumSize(new java.awt.Dimension(100, 50));
        btSave.setMinimumSize(new java.awt.Dimension(100, 50));
        btSave.setPreferredSize(new java.awt.Dimension(150, 50));
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/augcampos/gui/webdev-cancel-48x48.png"))); // NOI18N
        btCancel.setText("Cancelar");
        btCancel.setMaximumSize(new java.awt.Dimension(100, 26));
        btCancel.setMinimumSize(new java.awt.Dimension(100, 26));
        btCancel.setPreferredSize(new java.awt.Dimension(150, 50));
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBtsLayout = new javax.swing.GroupLayout(pnBts);
        pnBts.setLayout(pnBtsLayout);
        pnBtsLayout.setHorizontalGroup(
            pnBtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
            .addGroup(pnBtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnBtsLayout.createSequentialGroup()
                    .addGap(0, 79, Short.MAX_VALUE)
                    .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 79, Short.MAX_VALUE)))
        );
        pnBtsLayout.setVerticalGroup(
            pnBtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(pnBtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnBtsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(pnBtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        pnDetails.add(pnBts, gridBagConstraints);

        tabsMain.addTab("Detalhes", pnDetails);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        getContentPane().add(tabsMain, gridBagConstraints);
        tabsMain.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        addData();
    }//GEN-LAST:event_btAddActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        editData();
    }//GEN-LAST:event_btEditActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        saveData();
}//GEN-LAST:event_btSaveActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        deleteData();
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        cancelData();
    }//GEN-LAST:event_btCancelActionPerformed

    private void cbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTypeActionPerformed

        pnF.setVisible((cbType.getSelectedIndex() == 0));
        pnS.setVisible(!pnF.isVisible());


}//GEN-LAST:event_cbTypeActionPerformed

    private void cbPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPTActionPerformed
        n501070324_PostoTrabalho pt = (n501070324_PostoTrabalho) cbPT.getSelectedItem();
        if (pt != null) {
            lblCPU.setText(pt.getCpu());
            lblRAM.setText(pt.getRam());
            lblDisk.setText(pt.getDisco());
            lblSO.setText(pt.getSo());
        } else {
            lblCPU.setText("<Not Found!>");
            lblRAM.setText("");
            lblDisk.setText("");
            lblSO.setText("");
        }

    }//GEN-LAST:event_cbPTActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btAdd;
    protected javax.swing.JButton btCancel;
    protected javax.swing.JButton btDelete;
    protected javax.swing.JButton btEdit;
    protected javax.swing.JButton btSave;
    protected javax.swing.JComboBox cbPT;
    protected javax.swing.JComboBox cbType;
    protected javax.swing.JComboBox cbUsers;
    protected javax.swing.JFormattedTextField frfDate;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    protected javax.swing.JLabel jLabel3;
    protected javax.swing.JLabel jLabel4;
    protected javax.swing.JLabel jLabel5;
    protected javax.swing.JLabel jLabel6;
    protected javax.swing.JLabel jLabel8;
    protected javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JScrollPane jScrollPane2;
    protected javax.swing.JToolBar.Separator jSeparator1;
    protected javax.swing.JLabel lblCPU;
    protected javax.swing.JLabel lblDisk;
    protected javax.swing.JLabel lblNumero;
    protected javax.swing.JLabel lblRAM;
    protected javax.swing.JLabel lblSO;
    protected javax.swing.JPanel pmInterv;
    protected javax.swing.JPanel pnBts;
    protected javax.swing.JPanel pnDetails;
    protected javax.swing.JPanel pnF;
    protected javax.swing.JPanel pnList;
    protected javax.swing.JPanel pnMain;
    protected javax.swing.JPanel pnPA;
    protected javax.swing.JPanel pnS;
    protected javax.swing.JTabbedPane tabsMain;
    protected javax.swing.JToolBar tbActions;
    protected javax.swing.JTable tblIntervencoes;
    protected javax.swing.JTable tblList;
    protected javax.swing.JTextArea txtProblema;
    protected javax.swing.JTextArea txtTema;
    // End of variables declaration//GEN-END:variables

    private void refreshData() {
        javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel) tblList.getModel();

        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        for (n501070324_PedidoAssistencia pa : pedidosAssistenciaLnk.getList()) {

            boolean insert = true;
            // only add if is not resolved
            for (n501070324_Intervencao i : intervencoesLnk.getList(pa.getNumero())) {
                if (i.isResolvido()) {
                    insert = false;
                    break;
                }
            }
            if (insert) {
                dtm.addRow(new Object[]{pa.getNumero(), pa.getDataStr(), pa.getUtilizador(), pa.getTipo()});
            }
        }

        cbUsers.removeAllItems();
        for (n501070324_Utilizador u : pesoasLnk.getUsers()) {
            cbUsers.addItem(u);
        }

        cbPT.removeAllItems();
        for (n501070324_PostoTrabalho pt : postosTrabalhoLnk.getList()) {
            cbPT.addItem(pt);
        }



    }

    private void addData() {
        if (tabsMain.getSelectedIndex() == 0) {
            tabsMain.setSelectedIndex(1);
        }

        lblNumero.setText("<Novo>");
        frfDate.setText("");
        cbUsers.setSelectedIndex(-1);
        cbType.setEnabled(true);
        cbType.setSelectedIndex(0);

        txtTema.setText("");
        txtProblema.setText("");
        cbPT.setSelectedIndex(-1);

        DefaultTableModel dtm = (DefaultTableModel) tblIntervencoes.getModel();
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }

        frfDate.requestFocus();
    }

    private void editData() {
        if (tabsMain.getSelectedIndex() == 0) {
            tabsMain.setSelectedIndex(1);
        }
        refreshDetails(getSelect());
        frfDate.requestFocus();

    }

    private void deleteData() {
        pedidosAssistenciaLnk.remove(getSelect());
        refreshData();
    }

    @SuppressWarnings("deprecation")
    private void saveData() {

        n501070324_PedidoAssistencia pa;
        if (lblNumero.getText().equalsIgnoreCase("<Novo>")) {
            if (cbType.getSelectedIndex() == 0) {
                pa = new n501070324_PedidoSuporteFormacao();
            } else {
                pa = new n501070324_PedidoSuporteSistema();
            }
            pedidosAssistenciaLnk.add(pa);
        } else {
            pa = getSelect();
        }

        //Common filed
        pa.setData(new Date(frfDate.getText()));
        pa.setUtilizador(((n501070324_Utilizador) cbUsers.getSelectedItem()).getNumero());

        if (pa.getTipo() == n501070324_PedidoSuporteFormacao.COD_TIPO) {
            n501070324_PedidoSuporteFormacao psf = (n501070324_PedidoSuporteFormacao) pa;
            psf.setTema(txtTema.getText());
        } else {
            n501070324_PedidoSuporteSistema pss = (n501070324_PedidoSuporteSistema) pa;
            pss.setDescricao(txtProblema.getText());
            pss.setPostoTrabalho(((n501070324_PostoTrabalho) cbPT.getSelectedItem()).getNumero());
        }


        refreshData();
        refreshDetails(pa);
        cbType.setEnabled(false);
    }

    private void cancelData() {
        refreshDetails(getSelect());
        cbType.setEnabled(false);
    }

    private void refreshDetails(n501070324_PedidoAssistencia pa) {


        if (pa != null) {
            lblNumero.setText("" + pa.getNumero());
            frfDate.setText(pa.getDataStr());
            cbUsers.setSelectedItem(pesoasLnk.getUser(pa.getUtilizador()));
            cbType.setSelectedIndex((pa.getTipo() == n501070324_PedidoSuporteFormacao.COD_TIPO) ? 0 : 1);

            if (pa.getTipo() == n501070324_PedidoSuporteFormacao.COD_TIPO) {
                n501070324_PedidoSuporteFormacao psf = (n501070324_PedidoSuporteFormacao) pa;
                txtTema.setText(psf.getTema());
            } else {
                n501070324_PedidoSuporteSistema pss = (n501070324_PedidoSuporteSistema) pa;
                txtProblema.setText(pss.getDescricao());
                cbPT.setSelectedItem(postosTrabalhoLnk.getPostoTrabalho(pss.getPostoTrabalho()));
            }

            DefaultTableModel dtm = (DefaultTableModel) tblIntervencoes.getModel();
            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }
            for (n501070324_Intervencao ii : intervencoesLnk.getList(pa.getNumero())) {
                dtm.addRow(new Object[]{ii.getNumero(), ii.getDataStr(), ii.getTecnico(), ii.getDescricao(), ii.getDuracao(), ii.isResolvido()});
            }

        }
    }

    private n501070324_PedidoAssistencia getSelect() {
        if (tblList.getRowCount() < 1) {
            return null;
        }
        if (tblList.getSelectedRow() == -1) {
            tblList.setRowSelectionInterval(0, 0);
        }
        int id = Integer.valueOf(tblList.getModel().getValueAt(tblList.getSelectedRow(), 0).toString());

        return pedidosAssistenciaLnk.getPedido(id);
    }
}
