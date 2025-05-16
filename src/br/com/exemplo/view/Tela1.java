package br.com.exemplo.view;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.exemplo.dao.CadastroDao;
import br.com.exemplo.model.Cadastro;
import br.com.exemplo.model.Disciplina;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextArea;

public class Tela1 extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem mntmNewMenuItem_8;
	private JSeparator separator;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textRgm;
	private JLabel lblNomeDoAluno;
	private JTextField textNome;
	private JLabel lblDataDeNascimento;
	private JLabel lblEmail;
	private JTextField textEmail;
	private JLabel lblEndereo;
	private JTextField textCep;
	private JLabel lblEndereo_2;
	private JTextField textEndereco;
	private JLabel lblEndereo_1;
	private JTextField textBairro;
	private JLabel lblEndereo_3;
	private JTextField textMunicipio;
	private JPanel panel_1;
	private JFormattedTextField textCpf;
	private JFormattedTextField textData;
	private JComboBox textEstado;
	private JLabel lblEstado;
	private JComboBox cmbCampus;
	private JLabel lblCurso;
	private JLabel lblCampus;
	private JComboBox cmbCurso;
	private JLabel lblPerodo;
	private JRadioButton rdbMatutino;
	private JRadioButton rdbVespertino;
	private JRadioButton rdbNoturno;
	private final ButtonGroup Turnos = new ButtonGroup();
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblCpf;
	private Cadastro cadastro;
	private CadastroDao dao;
	private JLabel lblMensagem;
	private JTextField textNumero;
	private JLabel lblEndereo_4;
	private JLabel lblEndereo_5;
	private JTextField textCelular;
	private JButton btnSalvar_1;
	private JButton btnLimpar_1;
	private JButton btnAlterar_1;
	private JButton btnExcluir_1;
	private JButton btnConsultar_1;
	private JLabel imagemUnicid;
	private JLabel lblNewLabel_1;
	private JTextField textRgmAluno;
	private JTextField textNomeAluno;
	private JTextField exibirCurso;
	private JLabel lblNewLabel_2;
	private JComboBox cmbDisciplina;
	private JLabel lblNewLabel_3;
	private JComboBox cmbSemestre;
	private JLabel lblNewLabel_4;
	private JComboBox cmbNotas;
	private JLabel lblNewLabel_5;
	private JTextField textFaltas;
	private JButton btnLimpar;
	private JButton btnSalvar;
	private JButton btnConsultar;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField boletimNome;
	private JTextField boletimRgm;
	private JLabel lblNewLabel_9;
	private JTextField boletimCurso;
	private JTextArea textArea;
	private JSeparator separator_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela1 frame = new Tela1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela1() throws Exception{
		setTitle("Sistema de Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 477);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Aluno");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Salvar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent args0) {
				    try {
				        Cadastro cadastro = new Cadastro();
				        cadastro.setRgm(Integer.parseInt(textRgm.getText()));
				        cadastro.setNome(textNome.getText());
				        cadastro.setEmail(textEmail.getText());
				        cadastro.setCpf(textCpf.getText());
				        cadastro.setDtaNascimento(textData.getText());
				        cadastro.setCep(textCep.getText());
				        cadastro.setEndereco(textEndereco.getText());
				        cadastro.setNumero(textNumero.getText());
				        cadastro.setBairro(textBairro.getText());
				        cadastro.setMunicipio(textMunicipio.getText());
				        cadastro.setEstado((String) textEstado.getSelectedItem());
				        cadastro.setTelefone(textCelular.getText());
				        cadastro.setCampus((String) cmbCampus.getSelectedItem());
				        cadastro.setCurso((String) cmbCurso.getSelectedItem());
				        if (!rdbMatutino.isSelected() && !rdbVespertino.isSelected() && !rdbNoturno.isSelected()) {
				            JOptionPane.showMessageDialog(null, "Por favor, selecione um turno.");
				            return;
				        }
				        
				     // Atribuir o valor do turno à instância do objeto Cadastro
				        String turno ="";
				        if(rdbMatutino.isSelected()) {
				            turno = "Matutino";
				        }
				        else if(rdbVespertino.isSelected()) {
				            turno = "Vespertino";
				        }
				        else if(rdbNoturno.isSelected()) {
				            turno = "Noturno";
				        }
				        cadastro.setTurno(turno);

				        // Abrir conexão
				        dao = new CadastroDao();

				        // Verificar se o usuário já existe
				        if (dao.verificarExistencia(cadastro.getRgm())) {
				            lblMensagem.setText("Erro: RGM já existe.");
				            return;
				        }

				        // Salvar
				        dao.salvar(cadastro);
				        lblMensagem.setText("Parabéns: Dados cadastrado com Sucesso!");
				    } catch(Exception e) {
				        lblMensagem.setText("Ops... Erro ao Gravar Dados.");
				    }

				
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Alterar");
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				// Botão de Alterar
								// Alterar ================================================== Inicío
								try {
								Cadastro cadastro = new Cadastro();	
								cadastro.setNome(textNome.getText());
								cadastro.setEmail(textEmail.getText());
								cadastro.setDtaNascimento(textData.getText());
								cadastro.setCpf(textCpf.getText());
								cadastro.setCep(textCep.getText());
								cadastro.setEndereco(textEndereco.getText());
								cadastro.setNumero(textNumero.getText());
								cadastro.setBairro(textBairro.getText());
								cadastro.setMunicipio(textMunicipio.getText());
								cadastro.setEstado((String) textEstado.getSelectedItem());
								cadastro.setTelefone(textCelular.getText());
								cadastro.setCampus((String) cmbCampus.getSelectedItem());
								cadastro.setCurso((String) cmbCurso.getSelectedItem());
								// Obtém o valor selecionado pelo usuário
								String turnoSelecionado = "";
								if (rdbMatutino.isSelected()) {
								    turnoSelecionado = "Matutino";
								} else if (rdbVespertino.isSelected()) {
								    turnoSelecionado = "Vespertino";
								} else if (rdbNoturno.isSelected()) {
								    turnoSelecionado = "Noturno";
								}

								// Configura o objeto cadastro com o valor selecionado
								cadastro.setTurno(turnoSelecionado);
								cadastro.setRgm(Integer.parseInt(textRgm.getText()));
								

								//Abrir conexão
								dao = new CadastroDao();
								// Alterar
								dao.alterar(cadastro);
								    lblMensagem.setText("Parabéns: Dados alterado com Sucesso!");
								}catch(Exception e) {
									lblMensagem.setText("Erro ao Alterar os Dados.");
								}
								// Alterar ================================================== FIM
							
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Consultar");
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				// Consultar
				try {
				    int rgm = Integer.parseInt(textRgm.getText());
				    // Abrir Banco de dados
				    CadastroDao dao = new CadastroDao();
					Cadastro a = dao.procurar(rgm);
					// populando dos campos da tela
					textNome.setText(a.getNome());
					textEmail.setText(a.getEmail());
					textData.setText(a.getDtaNascimento());
					textCpf.setText(a.getCpf());
					textCep.setText(a.getCep());
					textEndereco.setText(a.getEndereco());
					textNumero.setText(String.valueOf(a.getNumero()));
					textBairro.setText(a.getBairro());
					textMunicipio.setText(a.getMunicipio());
				    // Exibir o estado selecionado
				    String estadoSelecionado = a.getEstado();
				    textEstado.setSelectedItem(estadoSelecionado);
				    textCelular.setText(a.getTelefone());
				    // Exibir o Campus selecionado
				    String CampusSelecionado = a.getCampus();
				    cmbCampus.setSelectedItem(CampusSelecionado);
				    // Exibir o Curso selecionado
				    String CursoSelecionado = a.getCurso();
				    cmbCurso.setSelectedItem(CursoSelecionado);
				    // Exibir o Botão do Turno Selecionado
				    String turnoSelecionado = a.getTurno();
				    if (turnoSelecionado.equals("Matutino")) {
				        rdbMatutino.setSelected(true);
				    } else if (turnoSelecionado.equals("Vespertino")) {
				        rdbVespertino.setSelected(true);
				    } else if (turnoSelecionado.equals("Noturno")) {
				        rdbNoturno.setSelected(true);
				    }

				    
				    
				  //Abrir conexão
					dao = new CadastroDao();
					// Consultar
					dao.procurar(rgm);
					    lblMensagem.setText("Parabéns: Consulta realizada com sucesso!");
					}catch(Exception e) {
						lblMensagem.setText("Atenção: Aluno não encontrado.");
					}
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		separator = new JSeparator();
		mnNewMenu.add(separator);
		
		mntmNewMenuItem_3 = new JMenuItem("Excluir");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
		//////// Botão de Excluir 
										//  Excluir ================================================== Inicío
										try {
										//Abrir conexão
										dao = new CadastroDao();
										// Alterar
										int codigo = Integer.parseInt(textRgm.getText());
										dao.excluir(codigo);
										    lblMensagem.setText("Atenção: Aluno excluído com sucesso!!");
										}catch(Exception e) {
											lblMensagem.setText("Erro ao Excluir.");
										}
										// Excluir ================================================== FIM
			}
		});
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		mnNewMenu_1 = new JMenu("Notas e Faltas");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_4 = new JMenuItem("Cadastrar");
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				try {
			        Disciplina disciplina = new Disciplina();
			        disciplina.setDisciplina((String) cmbDisciplina.getSelectedItem());
			        disciplina.setSemestre((String) cmbSemestre.getSelectedItem());
			        disciplina.setNotas((String) cmbNotas.getSelectedItem());
			        disciplina.setFaltas(Integer.parseInt(textFaltas.getText()));
			        disciplina.setRgm(Integer.parseInt(textRgmAluno.getText()));

			        // Imprimir valores das variáveis
			        System.out.println("RGM: " + disciplina.getRgm());
			        System.out.println("Disciplina: " + disciplina.getDisciplina());
			        System.out.println("Semestre: " + disciplina.getSemestre());
			        System.out.println("Notas: " + disciplina.getNotas());
			        System.out.println("Faltas: " + disciplina.getFaltas());

			        // Abrir conexão
			        dao = new CadastroDao();

			        // Recuperar nome do aluno da tabela de alunos usando o RGM
			        CadastroDao cadastroDao = new CadastroDao();
			        Cadastro cadastro = cadastroDao.procurar(disciplina.getRgm());

			        // Verificar se o aluno foi encontrado
			        if (cadastro != null) {
			            String nome = cadastro.getNome();
			            String curso = cadastro.getCurso();
			            textNomeAluno.setText("" + nome + "");
			            exibirCurso.setText("" + curso + "");
			            lblMensagem.setText("Disciplina registrada com sucesso!");
			        } 

			        // Salvar disciplina
			        dao.adicionardisciplina(disciplina);
			    } catch(Exception e) {
			        lblMensagem.setText("Erro ao realizar registro ou aluno não encontrado.");
			    }
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		mntmNewMenuItem_5 = new JMenuItem("Boletim");
		mntmNewMenuItem_5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				// Consultar
				try {
				    int rgm = Integer.parseInt(textRgmAluno.getText());
				    // Abrir Banco de dados
				    CadastroDao dao = new CadastroDao();
				    List<Disciplina> disciplinas = dao.listarDisciplinas(rgm);

				    if (!disciplinas.isEmpty()) {
				        StringBuilder sb = new StringBuilder();
				        for (Disciplina disciplina : disciplinas) {
				            // Recuperar nome do aluno da tabela de alunos usando o RGM
				            CadastroDao cadastroDao = new CadastroDao();
				            Cadastro cadastro = cadastroDao.procurar(disciplina.getRgm());

				            // Verificar se o aluno foi encontrado
				            if (cadastro != null) {
				                String nome = cadastro.getNome();
				                String curso = cadastro.getCurso();
				                
				                // Exibir o nome do aluno no TextField
				                boletimNome.setText(nome);
				                
				                // Exibir o RGM do aluno no TextField
				                boletimRgm.setText(String.valueOf(disciplina.getRgm()));
				                
				                // Exibir o curso do aluno no TextField
				                boletimCurso.setText(cadastro.getCurso());
				            }

				            sb.append("Disciplina: ").append(disciplina.getDisciplina()).append("\n");
				            sb.append("Semestre: ").append(disciplina.getSemestre()).append("\n");
				            sb.append("Notas: ").append(disciplina.getNotas()).append("\n");
				            sb.append("Faltas: ").append(disciplina.getFaltas()).append("\n");
				            sb.append("----------------------------------\n");
				        }

				        // Exibir as informações na área de texto
				        textArea.setText(sb.toString());

				        lblMensagem.setText("Parabéns: Consulta realizada com sucesso!");
				    } else {
				        lblMensagem.setText("Atenção: Não foram encontradas disciplinas para o RGM fornecido.");
				    }
				} catch (Exception e) {
				    lblMensagem.setText("Atenção: Ocorreu um erro ao consultar as disciplinas.");
				}
			
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		separator_1 = new JSeparator();
		mnNewMenu_1.add(separator_1);
		
		mntmNewMenuItem_7 = new JMenuItem("Limpar");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textRgmAluno.setText(null);
				textNomeAluno.setText(null);
				exibirCurso.setText(null);
				cmbDisciplina.setSelectedIndex(0);
				cmbSemestre.setSelectedIndex(0);
				cmbNotas.setSelectedIndex(0);
				textFaltas.setText(null);
			}
		});
		mntmNewMenuItem_7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		mnNewMenu_2 = new JMenu("Ajuda");
		mnNewMenu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem_8 = new JMenuItem("Sobre");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ===== Opção de Ajuda =====
				JOptionPane.showMessageDialog(null, "Informações do Menu");
		
				// FIM
			}
		});
		mntmNewMenuItem_8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.SHIFT_DOWN_MASK));
		mnNewMenu_2.add(mntmNewMenuItem_8);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 24, 756, 304);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, panel, null);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("RGM");
		lblNewLabel.setBounds(10, 21, 36, 31);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		
		textRgm = new JTextField();
		textRgm.setBounds(59, 21, 126, 31);
		textRgm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textRgm.setBackground(new Color(255, 255, 255));
		panel.add(textRgm);
		textRgm.setColumns(10);
		
		lblNomeDoAluno = new JLabel("Nome");
		lblNomeDoAluno.setBounds(195, 21, 47, 31);
		lblNomeDoAluno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNomeDoAluno);
		
		textNome = new JTextField();
		textNome.setBounds(252, 21, 294, 31);
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(textNome);
		textNome.setColumns(10);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(10, 60, 141, 32);
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblDataDeNascimento);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(275, 63, 47, 29);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(326, 63, 404, 29);
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textEmail.setColumns(10);
		panel.add(textEmail);
		
		lblEndereo = new JLabel("CEP");
		lblEndereo.setBounds(10, 103, 36, 29);
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblEndereo);
		
		textCep = new JFormattedTextField(new MaskFormatter(" ###.##-###"));
		textCep.setBounds(83, 103, 126, 28);
		textCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
			
			
		});
		textCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCep.setColumns(10);
		panel.add(textCep);
		
		lblEndereo_2 = new JLabel("Endereço");
		lblEndereo_2.setBounds(10, 134, 64, 21);
		lblEndereo_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblEndereo_2);
		
		textEndereco = new JTextField();
		textEndereco.setBounds(83, 135, 322, 27);
		textEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textEndereco.setColumns(10);
		panel.add(textEndereco);
		
		lblEndereo_1 = new JLabel("Bairro");
		lblEndereo_1.setBounds(10, 171, 64, 19);
		lblEndereo_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblEndereo_1);
		
		textBairro = new JTextField();
		textBairro.setBounds(83, 169, 206, 27);
		textBairro.setColumns(10);
		panel.add(textBairro);
		
		lblEndereo_3 = new JLabel("Municipío");
		lblEndereo_3.setBounds(10, 201, 72, 26);
		lblEndereo_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblEndereo_3);
		
		textMunicipio = new JTextField();
		textMunicipio.setBounds(83, 203, 175, 26);
		textMunicipio.setColumns(10);
		panel.add(textMunicipio);
		
		textCpf = new JFormattedTextField(new MaskFormatter(" ###.###.###-##"));
		textCpf.setBounds(589, 21, 141, 31);
		textCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(textCpf);
		
		textData = new JFormattedTextField(new MaskFormatter(" ##/##/####"));
		textData.setBounds(163, 63, 102, 29);
		textData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(textData);
		
		textEstado = new JComboBox();
		textEstado.setBounds(326, 201, 47, 26);
		textEstado.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		textEstado.setToolTipText("");
		panel.add(textEstado);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(268, 203, 47, 26);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblEstado);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(556, 18, 27, 32);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblCpf);
		
		textNumero = new JTextField();
		textNumero.setBounds(439, 134, 64, 28);
		textNumero.setColumns(10);
		panel.add(textNumero);
		
		lblEndereo_4 = new JLabel("N*");
		lblEndereo_4.setBounds(415, 134, 64, 28);
		lblEndereo_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblEndereo_4);
		
		lblEndereo_5 = new JLabel("Celular");
		lblEndereo_5.setBounds(10, 236, 64, 26);
		lblEndereo_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblEndereo_5);
		
		textCelular = new JFormattedTextField(new MaskFormatter(" (##) #####-####"));
		textCelular.setBounds(83, 236, 175, 26);
		textCelular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textCelular.setColumns(10);
		panel.add(textCelular);
		
		panel_1 = new JPanel();
		panel_1.setToolTipText("");
		tabbedPane.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);
		
		cmbCampus = new JComboBox();
		cmbCampus.setMaximumRowCount(2);
		cmbCampus.setToolTipText("");
		cmbCampus.setBounds(101, 11, 621, 30);
		cmbCampus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbCampus.setModel(new DefaultComboBoxModel(new String[] {"Polo - Tatuapé", "Polo - Pinheiros"}));
		panel_1.add(cmbCampus);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setBounds(23, 51, 63, 27);
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblCurso);
		
		lblCampus = new JLabel("Campus");
		lblCampus.setBounds(23, 11, 63, 30);
		lblCampus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblCampus);
		
		cmbCurso = new JComboBox();
		cmbCurso.setBounds(101, 52, 620, 30);
		cmbCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbCurso.setModel(new DefaultComboBoxModel(new String[] {"Análise e Desenvolvimento de Sistemas", "Ciência da Computação"}));
		cmbCurso.setToolTipText("Selecione uma opção");
		panel_1.add(cmbCurso);
		
		lblPerodo = new JLabel("Período");
		lblPerodo.setBounds(23, 89, 63, 27);
		lblPerodo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblPerodo);
		
		rdbMatutino = new JRadioButton("Matutino");
		rdbMatutino.setBounds(101, 91, 98, 23);
		Turnos.add(rdbMatutino);
		rdbMatutino.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.add(rdbMatutino);
		
		rdbVespertino = new JRadioButton("Vespertino");
		rdbVespertino.setBounds(197, 91, 111, 23);
		Turnos.add(rdbVespertino);
		rdbVespertino.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.add(rdbVespertino);
		
		rdbNoturno = new JRadioButton("Noturno");
		rdbNoturno.setBounds(310, 91, 98, 23);
		Turnos.add(rdbNoturno);
		rdbNoturno.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.add(rdbNoturno);
		
		btnSalvar_1 = new JButton("");
		btnSalvar_1.setBounds(136, 224, 121, 41);
		btnSalvar_1.setIcon(new ImageIcon(Tela1.class.getResource("/imagensdotrabalho/cadastrar.PNG")));
		btnSalvar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
			    try {
			        Cadastro cadastro = new Cadastro();
			        cadastro.setRgm(Integer.parseInt(textRgm.getText()));
			        cadastro.setNome(textNome.getText());
			        cadastro.setEmail(textEmail.getText());
			        cadastro.setCpf(textCpf.getText());
			        cadastro.setDtaNascimento(textData.getText());
			        cadastro.setCep(textCep.getText());
			        cadastro.setEndereco(textEndereco.getText());
			        cadastro.setNumero(textNumero.getText());
			        cadastro.setBairro(textBairro.getText());
			        cadastro.setMunicipio(textMunicipio.getText());
			        cadastro.setEstado((String) textEstado.getSelectedItem());
			        cadastro.setTelefone(textCelular.getText());
			        cadastro.setCampus((String) cmbCampus.getSelectedItem());
			        cadastro.setCurso((String) cmbCurso.getSelectedItem());
			        if (!rdbMatutino.isSelected() && !rdbVespertino.isSelected() && !rdbNoturno.isSelected()) {
			            JOptionPane.showMessageDialog(null, "Por favor, selecione um turno.");
			            return;
			        }
			        
			     // Atribuir o valor do turno à instância do objeto Cadastro
			        String turno ="";
			        if(rdbMatutino.isSelected()) {
			            turno = "Matutino";
			        }
			        else if(rdbVespertino.isSelected()) {
			            turno = "Vespertino";
			        }
			        else if(rdbNoturno.isSelected()) {
			            turno = "Noturno";
			        }
			        cadastro.setTurno(turno);

			        // Abrir conexão
			        dao = new CadastroDao();

			        // Verificar se o usuário já existe
			        if (dao.verificarExistencia(cadastro.getRgm())) {
			            lblMensagem.setText("Erro: RGM já existe.");
			            return;
			        }

			        // Salvar
			        dao.salvar(cadastro);
			        lblMensagem.setText("Parabéns: Dados cadastrado com Sucesso!");
			    } catch(Exception e) {
			        lblMensagem.setText("Ops... Erro ao Gravar Dados.");
			    }
			}

		});
		panel_1.add(btnSalvar_1);
		
		btnLimpar_1 = new JButton("");
		btnLimpar_1.addActionListener(new ActionListener() {
			// Botão de Limpar //
			public void actionPerformed(ActionEvent e) {
							textRgm.setText(null);
							textNome.setText(null);
							textCpf.setText(null);
							textData.setText(null);
							textEmail.setText(null);
							textCep.setText(null);
							textEndereco.setText(null);
							textNumero.setText(null);
							textBairro.setText(null);
							textMunicipio.setText(null);
							textEstado.setSelectedIndex(0);
							textCelular.setText(null);
							cmbCampus.setSelectedIndex(0);
							cmbCurso.setSelectedIndex(0);
							Turnos.clearSelection();
							
						}
		});
		btnLimpar_1.setBounds(10, 224, 121, 41);
		btnLimpar_1.setIcon(new ImageIcon(Tela1.class.getResource("/imagensdotrabalho/limpar.PNG")));
		panel_1.add(btnLimpar_1);
		
		btnAlterar_1 = new JButton("");
		btnAlterar_1.addActionListener(new ActionListener() {
			// Botão de Alterar
			public void actionPerformed(ActionEvent args0) {
							// Alterar ================================================== Inicío
							try {
							Cadastro cadastro = new Cadastro();	
							cadastro.setNome(textNome.getText());
							cadastro.setEmail(textEmail.getText());
							cadastro.setDtaNascimento(textData.getText());
							cadastro.setCpf(textCpf.getText());
							cadastro.setCep(textCep.getText());
							cadastro.setEndereco(textEndereco.getText());
							cadastro.setNumero(textNumero.getText());
							cadastro.setBairro(textBairro.getText());
							cadastro.setMunicipio(textMunicipio.getText());
							cadastro.setEstado((String) textEstado.getSelectedItem());
							cadastro.setTelefone(textCelular.getText());
							cadastro.setCampus((String) cmbCampus.getSelectedItem());
							cadastro.setCurso((String) cmbCurso.getSelectedItem());
							// Obtém o valor selecionado pelo usuário
							String turnoSelecionado = "";
							if (rdbMatutino.isSelected()) {
							    turnoSelecionado = "Matutino";
							} else if (rdbVespertino.isSelected()) {
							    turnoSelecionado = "Vespertino";
							} else if (rdbNoturno.isSelected()) {
							    turnoSelecionado = "Noturno";
							}

							// Configura o objeto cadastro com o valor selecionado
							cadastro.setTurno(turnoSelecionado);
							cadastro.setRgm(Integer.parseInt(textRgm.getText()));
							

							//Abrir conexão
							dao = new CadastroDao();
							// Alterar
							dao.alterar(cadastro);
							    lblMensagem.setText("Parabéns: Dados alterado com Sucesso!");
							}catch(Exception e) {
								lblMensagem.setText("Erro ao Alterar os Dados.");
							}
							// Alterar ================================================== FIM
						}
		});
		btnAlterar_1.setBounds(261, 224, 121, 41);
		btnAlterar_1.setIcon(new ImageIcon(Tela1.class.getResource("/imagensdotrabalho/alterar.PNG")));
		panel_1.add(btnAlterar_1);
		
		btnExcluir_1 = new JButton("");
		btnExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
		//////// Botão de Excluir 
								//  Excluir ================================================== Inicío
								try {
								//Abrir conexão
								dao = new CadastroDao();
								// Alterar
								int codigo = Integer.parseInt(textRgm.getText());
								dao.excluir(codigo);
								    lblMensagem.setText("Atenção: Aluno excluído com sucesso!!");
								}catch(Exception e) {
									lblMensagem.setText("Erro ao Excluir.");
								}
								// Excluir ================================================== FIM
			}
		});
		btnExcluir_1.setBounds(387, 224, 121, 41);
		btnExcluir_1.setIcon(new ImageIcon(Tela1.class.getResource("/imagensdotrabalho/excluir.PNG")));
		panel_1.add(btnExcluir_1);
		
		btnConsultar_1 = new JButton("");
		btnConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				// Consultar
				try {
				    int rgm = Integer.parseInt(textRgm.getText());
				    // Abrir Banco de dados
				    CadastroDao dao = new CadastroDao();
					Cadastro a = dao.procurar(rgm);
					// populando dos campos da tela
					textNome.setText(a.getNome());
					textEmail.setText(a.getEmail());
					textData.setText(a.getDtaNascimento());
					textCpf.setText(a.getCpf());
					textCep.setText(a.getCep());
					textEndereco.setText(a.getEndereco());
					textNumero.setText(String.valueOf(a.getNumero()));
					textBairro.setText(a.getBairro());
					textMunicipio.setText(a.getMunicipio());
				    // Exibir o estado selecionado
				    String estadoSelecionado = a.getEstado();
				    textEstado.setSelectedItem(estadoSelecionado);
				    textCelular.setText(a.getTelefone());
				    // Exibir o Campus selecionado
				    String CampusSelecionado = a.getCampus();
				    cmbCampus.setSelectedItem(CampusSelecionado);
				    // Exibir o Curso selecionado
				    String CursoSelecionado = a.getCurso();
				    cmbCurso.setSelectedItem(CursoSelecionado);
				    // Exibir o Botão do Turno Selecionado
				    String turnoSelecionado = a.getTurno();
				    if (turnoSelecionado.equals("Matutino")) {
				        rdbMatutino.setSelected(true);
				    } else if (turnoSelecionado.equals("Vespertino")) {
				        rdbVespertino.setSelected(true);
				    } else if (turnoSelecionado.equals("Noturno")) {
				        rdbNoturno.setSelected(true);
				    }

				    
				    
				  //Abrir conexão
					dao = new CadastroDao();
					// Consultar
					dao.procurar(rgm);
					    lblMensagem.setText("Parabéns: Consulta realizada com sucesso!");
					}catch(Exception e) {
						lblMensagem.setText("Atenção: Aluno não encontrado.");
					}
				
			}
		});
		btnConsultar_1.setBounds(512, 224, 121, 41);
		btnConsultar_1.setIcon(new ImageIcon(Tela1.class.getResource("/imagensdotrabalho/consultar.PNG")));
		panel_1.add(btnConsultar_1);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, panel_2, null);
		panel_2.setLayout(null);
		
		lblNewLabel_1 = new JLabel("RGM");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 11, 36, 31);
		panel_2.add(lblNewLabel_1);
		
		textRgmAluno = new JTextField();
		textRgmAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textRgmAluno.setColumns(10);
		textRgmAluno.setBackground(new Color(255, 255, 255));
		textRgmAluno.setBounds(56, 11, 143, 31);
		panel_2.add(textRgmAluno);
		
		textNomeAluno = new JTextField();
		textNomeAluno.setEditable(false);
		textNomeAluno.setBackground(SystemColor.control);
		textNomeAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNomeAluno.setColumns(10);
		textNomeAluno.setBounds(209, 11, 532, 31);
		panel_2.add(textNomeAluno);
		
		exibirCurso = new JTextField();
		exibirCurso.setEditable(false);
		exibirCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		exibirCurso.setColumns(10);
		exibirCurso.setBackground(SystemColor.menu);
		exibirCurso.setBounds(10, 53, 731, 31);
		panel_2.add(exibirCurso);
		
		lblNewLabel_2 = new JLabel("Disciplina");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 101, 67, 31);
		panel_2.add(lblNewLabel_2);
		
		cmbDisciplina = new JComboBox();
		cmbDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbDisciplina.setModel(new DefaultComboBoxModel(new String[] {"Programação Orientada a Objetos", "Análise e Projeto de Sistemas", "Banco de Dados", "Engenharia de Software"}));
		cmbDisciplina.setBounds(87, 101, 654, 31);
		panel_2.add(cmbDisciplina);
		
		lblNewLabel_3 = new JLabel("Semestre");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 143, 67, 31);
		panel_2.add(lblNewLabel_3);
		
		cmbSemestre = new JComboBox();
		cmbSemestre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbSemestre.setModel(new DefaultComboBoxModel(new String[] {"2023-1", "2023-2", "2024-3", "2024-4"}));
		cmbSemestre.setBounds(87, 143, 176, 31);
		panel_2.add(cmbSemestre);
		
		lblNewLabel_4 = new JLabel("Nota");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(273, 143, 36, 31);
		panel_2.add(lblNewLabel_4);
		
		cmbNotas = new JComboBox();
		cmbNotas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbNotas.setModel(new DefaultComboBoxModel(new String[] {"0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1.0", "1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "1.9", "2.0", "2.1", "2.2", "2.3", "2.4", "2.5", "2.6", "2.7", "2.8", "2.9", "3.0", "3.1", "3.2", "3.3", "3.4", "3.5", "3.6", "3.7", "3.8", "3.9", "4.0", "4.1", "4.2", "4.3", "4.4", "4.5", "4.6", "4.7", "4.8", "4.9", "5.0", "5.1", "5.2", "5.3", "5.4", "5.5", "5.6", "5.7", "5.8", "5.9", "6.0"}));
		cmbNotas.setBounds(312, 143, 194, 31);
		panel_2.add(cmbNotas);
		
		lblNewLabel_5 = new JLabel("Faltas");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(516, 143, 45, 31);
		panel_2.add(lblNewLabel_5);
		
		textFaltas = new JTextField();
		textFaltas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFaltas.setColumns(10);
		textFaltas.setBackground(Color.WHITE);
		textFaltas.setBounds(571, 143, 170, 31);
		panel_2.add(textFaltas);
		
		btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textRgmAluno.setText(null);
				textNomeAluno.setText(null);
				exibirCurso.setText(null);
				cmbDisciplina.setSelectedIndex(0);
				cmbSemestre.setSelectedIndex(0);
				cmbNotas.setSelectedIndex(0);
				textFaltas.setText(null);
			}
		});
		btnLimpar.setIcon(new ImageIcon(Tela1.class.getResource("/imagensdotrabalho/limpar.PNG")));
		btnLimpar.setBounds(10, 224, 121, 41);
		panel_2.add(btnLimpar);
		
		btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
			    try {
			        Disciplina disciplina = new Disciplina();
			        disciplina.setDisciplina((String) cmbDisciplina.getSelectedItem());
			        disciplina.setSemestre((String) cmbSemestre.getSelectedItem());
			        disciplina.setNotas((String) cmbNotas.getSelectedItem());
			        disciplina.setFaltas(Integer.parseInt(textFaltas.getText()));
			        disciplina.setRgm(Integer.parseInt(textRgmAluno.getText()));

			        // Imprimir valores das variáveis
			        System.out.println("RGM: " + disciplina.getRgm());
			        System.out.println("Disciplina: " + disciplina.getDisciplina());
			        System.out.println("Semestre: " + disciplina.getSemestre());
			        System.out.println("Notas: " + disciplina.getNotas());
			        System.out.println("Faltas: " + disciplina.getFaltas());

			        // Abrir conexão
			        dao = new CadastroDao();

			        // Recuperar nome do aluno da tabela de alunos usando o RGM
			        CadastroDao cadastroDao = new CadastroDao();
			        Cadastro cadastro = cadastroDao.procurar(disciplina.getRgm());

			        // Verificar se o aluno foi encontrado
			        if (cadastro != null) {
			            String nome = cadastro.getNome();
			            String curso = cadastro.getCurso();
			            textNomeAluno.setText("" + nome + "");
			            exibirCurso.setText("" + curso + "");
			            lblMensagem.setText("Disciplina registrada com sucesso!");
			        } 

			        // Salvar disciplina
			        dao.adicionardisciplina(disciplina);
			    } catch(Exception e) {
			        lblMensagem.setText("Erro ao realizar registro ou aluno não encontrado.");
			    }
			}

				
		});
		btnSalvar.setIcon(new ImageIcon(Tela1.class.getResource("/imagensdotrabalho/cadastrar.PNG")));
		btnSalvar.setBounds(141, 224, 121, 41);
		panel_2.add(btnSalvar);
		
		btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
					// Consultar
				try {
				    int rgm = Integer.parseInt(textRgmAluno.getText());
				    // Abrir Banco de dados
				    CadastroDao dao = new CadastroDao();
				    List<Disciplina> disciplinas = dao.listarDisciplinas(rgm);

				    if (!disciplinas.isEmpty()) {
				        StringBuilder sb = new StringBuilder();
				        for (Disciplina disciplina : disciplinas) {
				            // Recuperar nome do aluno da tabela de alunos usando o RGM
				            CadastroDao cadastroDao = new CadastroDao();
				            Cadastro cadastro = cadastroDao.procurar(disciplina.getRgm());

				            // Verificar se o aluno foi encontrado
				            if (cadastro != null) {
				                String nome = cadastro.getNome();
				                String curso = cadastro.getCurso();
				                
				                // Exibir o nome do aluno no TextField
				                boletimNome.setText(nome);
				                
				                // Exibir o RGM do aluno no TextField
				                boletimRgm.setText(String.valueOf(disciplina.getRgm()));
				                
				                // Exibir o curso do aluno no TextField
				                boletimCurso.setText(cadastro.getCurso());
				            }

				            sb.append("Disciplina: ").append(disciplina.getDisciplina()).append("\n");
				            sb.append("Semestre: ").append(disciplina.getSemestre()).append("\n");
				            sb.append("Notas: ").append(disciplina.getNotas()).append("\n");
				            sb.append("Faltas: ").append(disciplina.getFaltas()).append("\n");
				            sb.append("----------------------------------\n");
				        }

				        // Exibir as informações na área de texto
				        textArea.setText(sb.toString());

				        lblMensagem.setText("Parabéns: Consulta realizada com sucesso!");
				    } else {
				        lblMensagem.setText("Atenção: Não foram encontradas disciplinas para o RGM fornecido.");
				    }
				} catch (Exception e) {
				    lblMensagem.setText("Atenção: Ocorreu um erro ao consultar as disciplinas.");
				}
			}
			
		});
		btnConsultar.setIcon(new ImageIcon(Tela1.class.getResource("/imagensdotrabalho/boletim_resized.PNG")));
		btnConsultar.setBounds(275, 224, 121, 41);
		panel_2.add(btnConsultar);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("Boletim", null, panel_3, null);
		panel_3.setLayout(null);
		
		lblNewLabel_6 = new JLabel("RGM");
		lblNewLabel_6.setBounds(10, 56, 33, 33);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Nome");
		lblNewLabel_7.setBounds(10, 13, 46, 31);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(lblNewLabel_7);
		
		boletimNome = new JTextField();
		boletimNome.setEditable(false);
		boletimNome.setBounds(81, 13, 532, 31);
		boletimNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boletimNome.setColumns(10);
		boletimNome.setBackground(SystemColor.menu);
		panel_3.add(boletimNome);
		
		boletimRgm = new JTextField();
		boletimRgm.setEditable(false);
		boletimRgm.setBounds(81, 57, 114, 31);
		boletimRgm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boletimRgm.setColumns(10);
		boletimRgm.setBackground(SystemColor.menu);
		panel_3.add(boletimRgm);
		
		lblNewLabel_9 = new JLabel("Curso");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(205, 56, 46, 33);
		panel_3.add(lblNewLabel_9);
		
		boletimCurso = new JTextField();
		boletimCurso.setEditable(false);
		boletimCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boletimCurso.setColumns(10);
		boletimCurso.setBackground(SystemColor.menu);
		boletimCurso.setBounds(254, 56, 359, 33);
		panel_3.add(boletimCurso);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(192, 192, 192));
		textArea.setFont(new Font("Monospaced", Font.BOLD, 12));
		textArea.setEditable(false);
		textArea.setBounds(10, 100, 731, 165);
		panel_3.add(textArea);
		
		lblMensagem = new JLabel("");
		lblMensagem.setBounds(20, 339, 733, 19);
		lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblMensagem);
		
		imagemUnicid = new JLabel("");
		imagemUnicid.setIcon(new ImageIcon(Tela1.class.getResource("/imagensdotrabalho/unicid_pref_pos_resized.png")));
		imagemUnicid.setBounds(561, 322, 205, 94);
		contentPane.add(imagemUnicid);
	}
}
