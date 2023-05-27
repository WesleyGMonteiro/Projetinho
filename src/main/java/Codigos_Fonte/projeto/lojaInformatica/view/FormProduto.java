/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Codigos_Fonte.projeto.lojaInformatica.view;

import Codigos_Fonte.projeto.lojaInformatica.dao.FornecedorDAO;
import Codigos_Fonte.projeto.lojaInformatica.dao.ProdutoDAO;
import Codigos_Fonte.projeto.lojaInformatica.model.Fornecedor;
import Codigos_Fonte.projeto.lojaInformatica.model.Produto;
import Codigos_Fonte.projeto.lojaInformatica.model.Utilitario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wesleygomesmonteiro
 */
public class FormProduto extends javax.swing.JFrame {

    //Método listar na tabela
    public void listar() throws SQLException, ClassNotFoundException{
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> lista = dao.listarProdutos();
        DefaultTableModel dados = (DefaultTableModel) tabelaProdutos.getModel();
        dados.setNumRows(0);
        for(Produto c:lista){
            dados.addRow(new Object[]{
               c.getId(),
                c.getDescricao(),
                c.getPreco(),
                c.getQtd_estoque(),
                c.getFornecedor().getNome()
            });
        }
    }
    /**
     * Creates new form FormCliente
     */

    public FormProduto(){
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        painelCadastroProdutos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtQtdEstoque = new javax.swing.JTextField();
        cmbFornecedores = new javax.swing.JComboBox();
        painelConsultaProdutos = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        btnPesquisa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mniNovoCliente = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mniNovoFornecedor = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Produtos");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/produtos.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel15)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        painelCadastroProdutos.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Código:");

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(51, 51, 51));
        txtCodigo.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Descrição");

        txtDescricao.setBackground(new java.awt.Color(204, 204, 204));
        txtDescricao.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtDescricao.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Preço:");

        txtPreco.setBackground(new java.awt.Color(204, 204, 204));
        txtPreco.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtPreco.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Qtd.Estoque:");

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Fornecedor:");

        txtQtdEstoque.setBackground(new java.awt.Color(204, 204, 204));
        txtQtdEstoque.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtQtdEstoque.setForeground(new java.awt.Color(0, 0, 0));

        cmbFornecedores.setBackground(new java.awt.Color(204, 204, 204));
        cmbFornecedores.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        cmbFornecedores.setForeground(new java.awt.Color(0, 0, 0));
        cmbFornecedores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbFornecedores.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cmbFornecedoresAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout painelCadastroProdutosLayout = new javax.swing.GroupLayout(painelCadastroProdutos);
        painelCadastroProdutos.setLayout(painelCadastroProdutosLayout);
        painelCadastroProdutosLayout.setHorizontalGroup(
            painelCadastroProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroProdutosLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(painelCadastroProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastroProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCadastroProdutosLayout.createSequentialGroup()
                        .addGroup(painelCadastroProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelCadastroProdutosLayout.createSequentialGroup()
                                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelCadastroProdutosLayout.createSequentialGroup()
                                .addGroup(painelCadastroProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 1, Short.MAX_VALUE)))
                        .addContainerGap(612, Short.MAX_VALUE))
                    .addGroup(painelCadastroProdutosLayout.createSequentialGroup()
                        .addComponent(cmbFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        painelCadastroProdutosLayout.setVerticalGroup(
            painelCadastroProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCadastroProdutosLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(painelCadastroProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelCadastroProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelCadastroProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelCadastroProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(cmbFornecedores))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        painelCadastroProdutosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCodigo, txtDescricao, txtPreco});

        jTabbedPane1.addTab("Dados do Produtos", painelCadastroProdutos);

        painelConsultaProdutos.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Descrição:");

        txtPesquisa.setBackground(new java.awt.Color(204, 204, 204));
        txtPesquisa.setForeground(new java.awt.Color(0, 0, 0));

        btnPesquisa.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnPesquisa.setIcon(new javax.swing.ImageIcon("/Users/wesleygomesmonteiro/Documents/workspace/Projeto_PI_Loja_Informatica/src/main/resources/lupa.png")); // NOI18N
        btnPesquisa.setText("Pesquisar");
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });

        tabelaProdutos.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Preço", "Qtd.Estoque", "Fornecedor"
            }
        ));
        tabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProdutos);

        javax.swing.GroupLayout painelConsultaProdutosLayout = new javax.swing.GroupLayout(painelConsultaProdutos);
        painelConsultaProdutos.setLayout(painelConsultaProdutosLayout);
        painelConsultaProdutosLayout.setHorizontalGroup(
            painelConsultaProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaProdutosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelConsultaProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelConsultaProdutosLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisa)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelConsultaProdutosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnPesquisa, txtPesquisa});

        painelConsultaProdutosLayout.setVerticalGroup(
            painelConsultaProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaProdutosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(painelConsultaProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelConsultaProdutosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnPesquisa, txtPesquisa});

        jTabbedPane1.addTab("Consulta de Produtos", painelConsultaProdutos);

        btnNovo.setIcon(new javax.swing.ImageIcon("/Users/wesleygomesmonteiro/Documents/workspace/Projeto_PI_Loja_Informatica/src/main/resources/adicionar (1).png")); // NOI18N
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon("/Users/wesleygomesmonteiro/Documents/workspace/Projeto_PI_Loja_Informatica/src/main/resources/verificar.png")); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon("/Users/wesleygomesmonteiro/Documents/workspace/Projeto_PI_Loja_Informatica/src/main/resources/editar.png")); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon("/Users/wesleygomesmonteiro/Documents/workspace/Projeto_PI_Loja_Informatica/src/main/resources/excluir.png")); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clientes.png"))); // NOI18N
        jMenu1.setText("Clientes");

        mniNovoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adicionar (1).png"))); // NOI18N
        mniNovoCliente.setText("Novo Cliente");
        mniNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNovoClienteActionPerformed(evt);
            }
        });
        jMenu1.add(mniNovoCliente);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carteira-de-identidade 32.png"))); // NOI18N
        jMenuItem7.setText("Controle de Clientes");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fornecedores.png"))); // NOI18N
        jMenu2.setText("Fornecedores");

        mniNovoFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adicionar (1).png"))); // NOI18N
        mniNovoFornecedor.setText("Novo Fornecedor");
        mniNovoFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNovoFornecedorActionPerformed(evt);
            }
        });
        jMenu2.add(mniNovoFornecedor);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fornecedor (2).png"))); // NOI18N
        jMenuItem3.setText("Controle de Fornecedores");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/produtos.png"))); // NOI18N
        jMenu6.setText("Produtos");

        jMenuItem2.setText("Controle de Estoque");
        jMenu6.add(jMenuItem2);

        jMenuItem5.setText("Consulta de Produtos");
        jMenu6.add(jMenuItem5);

        jMenuBar1.add(jMenu6);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendas.png"))); // NOI18N
        jMenu4.setText("Vendas");

        jMenuItem6.setText("Abrir Ponto de Vendas");
        jMenu4.add(jMenuItem6);

        jMenuItem4.setText("Relatório de Vendas");
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/configuracoes.png"))); // NOI18N
        jMenu5.setText("Configurações");
        jMenuBar1.add(jMenu5);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sair.png"))); // NOI18N
        jMenu7.setText("Sair");
        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEditar, btnExcluir, btnNovo, btnSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnEditar, btnExcluir, btnNovo, btnSalvar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // Botão Salvar
        
            Produto obj = new Produto();
            obj.setDescricao(txtDescricao.getText());
            obj.setPreco(Double.parseDouble(txtPreco.getText()));
            obj.setQtd_estoque(Integer.parseInt(txtQtdEstoque.getText()));
            
            
            //Criar objeto de Fornecedor
            Fornecedor f = new Fornecedor();
            f = (Fornecedor) cmbFornecedores.getSelectedItem();
            obj.setFornecedor(f);
            
            ProdutoDAO dao = new ProdutoDAO();
            dao.cadastrar(obj);
            
        new Utilitario().limpaTela(painelCadastroProdutos);
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        //Clicar aqui abrir para cadastrar um cliente novo
        
        new Utilitario().limpaTela(painelCadastroProdutos);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
        try {
            //Carrega a lista
            listar();
        } catch (SQLException ex) {
            Logger.getLogger(FormProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowActivated

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Botão Editar
        
           Produto obj = new Produto();
           obj.setId(Integer.parseInt(txtCodigo.getText()));
           obj.setDescricao(txtDescricao.getText());
           obj.setPreco(Double.parseDouble(txtPreco.getText()));
           obj.setQtd_estoque(Integer.parseInt(txtQtdEstoque.getText()));
           
            
            
            Fornecedor f = new Fornecedor();
            f = (Fornecedor)cmbFornecedores.getSelectedItem();
            
            obj.setFornecedor(f);
            
            ProdutoDAO daop = new ProdutoDAO();
            daop.alterar(obj);
        
        
        new Utilitario().limpaTela(painelCadastroProdutos);
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        
        
            Produto obj = new Produto();

            obj.setId(Integer.parseInt(txtCodigo.getText()));
            
            ProdutoDAO dao = new ProdutoDAO();
            dao.excluir(obj);
        
        
        new Utilitario().limpaTela(painelCadastroProdutos);
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    
    private void tabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosMouseClicked
        //Pega os dados
        jTabbedPane1.setSelectedIndex(0);

        txtCodigo.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0).toString());
        txtDescricao.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 1).toString());
        txtPreco.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 2).toString());
        txtQtdEstoque.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 3).toString());
        
        Fornecedor f = new Fornecedor();
        FornecedorDAO daof = new FornecedorDAO();
        f = daof.consultaPorCnpj(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 4).toString());
        
        cmbFornecedores.removeAllItems();
        cmbFornecedores.getModel().setSelectedItem(f);

    }//GEN-LAST:event_tabelaProdutosMouseClicked

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        //Botão para pesquisar
        String nome = "%" + txtPesquisa.getText() + "%";

        ProdutoDAO dao = new ProdutoDAO();

        List<Produto> lista = dao.buscaProdutosPorNome(nome);
        DefaultTableModel dados = (DefaultTableModel) tabelaProdutos.getModel();
        dados.setNumRows(0);
        for(Produto c:lista){
            dados.addRow(new Object[]{
                c.getId(),
                c.getDescricao(),
                c.getPreco(),
                c.getQtd_estoque(),
                c.getFornecedor().getNome()
            });
        }
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void cmbFornecedoresAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cmbFornecedoresAncestorAdded
        FornecedorDAO daof = new FornecedorDAO();
        List<Fornecedor> lista = daof.ListarFornecedores();
        cmbFornecedores.removeAllItems();
        
        for (Fornecedor f : lista) {
            cmbFornecedores.addItem(f);
        }
    }//GEN-LAST:event_cmbFornecedoresAncestorAdded

    private void mniNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNovoClienteActionPerformed
        new FormCliente().setVisible(true);
    }//GEN-LAST:event_mniNovoClienteActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new FormCliente().setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void mniNovoFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNovoFornecedorActionPerformed
        new FormFornecedor().setVisible(true);
    }//GEN-LAST:event_mniNovoFornecedorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormProduto().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cmbFornecedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem mniNovoCliente;
    private javax.swing.JMenuItem mniNovoFornecedor;
    private javax.swing.JPanel painelCadastroProdutos;
    private javax.swing.JPanel painelConsultaProdutos;
    private javax.swing.JTable tabelaProdutos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQtdEstoque;
    // End of variables declaration//GEN-END:variables
}
