package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.model.Cadastro;
import br.com.exemplo.model.Disciplina;
import br.com.exemplo.util.ConnectionFactory;

public class CadastroDao { // CRUD
	private Cadastro cadastro;
	private Disciplina disciplina;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public CadastroDao() throws Exception{
		try {
			conn = ConnectionFactory.getConnection();
		}catch(Exception e) {
			throw new Exception("Erro "+ e.getMessage());
		}
	}
	
	public void salvar(Cadastro cadastro) throws Exception{
	    try {
	            String sql = "INSERT INTO aluno (rgm, nome, email, dtanascimento, cpf, cep, endereco, numero, bairro, municipio, estado, telefone, campus, curso, turno)"
	                    + "Values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	            ps = conn.prepareStatement(sql);
	            ps.setInt(1, cadastro.getRgm());
	            ps.setString(2, cadastro.getNome());
	            ps.setString(3, cadastro.getEmail());
	            ps.setString(4, cadastro.getDtaNascimento());
	            ps.setString(5, cadastro.getCpf());
	            ps.setString(6, cadastro.getCep());
	            ps.setString(7, cadastro.getEndereco());
	            ps.setString(8, cadastro.getNumero());
	            ps.setString(9, cadastro.getBairro());
	            ps.setString(10, cadastro.getMunicipio());
	            ps.setString(11, cadastro.getEstado());
	            ps.setString(12, cadastro.getTelefone());
	            ps.setString(13, cadastro.getCampus());
	            ps.setString(14, cadastro.getCurso());
	            ps.setString(15, cadastro.getTurno());
	            
	            ps.executeUpdate();
	        
	        
	        conn = ConnectionFactory.getConnection();
	    } catch(Exception e) {
	        throw new Exception("Erro ao salvar: " + e.getMessage());
	    }
	}
	

	
	
	public void alterar(Cadastro cadastro) throws Exception {
		if (cadastro == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE aluno SET nome=?, email=?, dtanascimento=?, cpf=?, cep=?, endereco=?, numero=?, bairro=?, municipio=?, estado=?, telefone=?, campus=?, curso=?, turno=?"
					+ " WHERE rgm=?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, cadastro.getNome());
			ps.setString(2, cadastro.getEmail());
			ps.setString(3, cadastro.getDtaNascimento());
			ps.setString(4, cadastro.getCpf());
			ps.setString(5, cadastro.getCep());
			ps.setString(6, cadastro.getEndereco());
			ps.setString(7, cadastro.getNumero());
			ps.setString(8, cadastro.getBairro());
			ps.setString(9, cadastro.getMunicipio());
			ps.setString(10, cadastro.getEstado());
			ps.setString(11, cadastro.getTelefone());
			ps.setString(12, cadastro.getCampus());
			ps.setString(13, cadastro.getCurso());
			ps.setString(14, cadastro.getTurno());
			ps.setInt(15, cadastro.getRgm());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	
	public void excluir(int Rgm) throws Exception{
		try {
			String SQL = "DELETE FROM aluno"
					+ " WHERE rgm = ?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, Rgm);
			ps.executeUpdate();
		}catch(Exception e) {
			throw new Exception("Erro ao excluir"+ e.getMessage());
		}
	}
	


//Procurar Aluno

		public Cadastro procurar(int rgm) throws Exception {

			try {
				String SQL = "SELECT  * FROM aluno WHERE rgm=?";
				conn = this.conn;
				ps = conn.prepareStatement(SQL);
				ps.setInt(1, rgm);			
				rs = ps.executeQuery();
				if (rs.next()) {
					int ca = rs.getInt(1);
					String nome = rs.getString(2);
					String email = rs.getString(3);
					String nascimento = rs.getString(4);
					String cpf = rs.getString(5);
					String cep = rs.getString(6);
					String endereco = rs.getString(7);
					String numero = rs.getString(8);
					String bairro = rs.getString(9);
					String municipio = rs.getString(10);
					String estado = rs.getString(11);
					String telefone = rs.getString(12);
					String campus = rs.getString(13);
					String curso = rs.getString(14);
					String turno = rs.getString(15);
					cadastro = new Cadastro(ca, nome, email, nascimento, cpf, cep, endereco, numero, bairro, municipio, estado, telefone, campus, curso, turno);
				}
				return cadastro;
			} catch (SQLException sqle) {
				throw new Exception(sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
	


		
         // Verificação do aluno
		public boolean verificarExistencia(int rgm) throws Exception {
		    try {
		        String sql = "SELECT COUNT(*) FROM aluno WHERE rgm = ?";
		        ps = conn.prepareStatement(sql);
		        ps.setInt(1, rgm);
		        ResultSet rs = ps.executeQuery();
		        rs.next();
		        return rs.getInt(1) > 0;
		    } catch(Exception e) {
		        throw new Exception("Erro ao verificar aluno: " + e.getMessage());
		    }
		}
		
		//Inserir Disciplina
				public void adicionardisciplina(Disciplina disciplina) throws Exception{
				    try {
				            String sql = "INSERT INTO notasfaltas (disciplina, semestre, notas, faltas, rgm)"
				                    + "Values (?,?,?,?,?)";
				            ps = conn.prepareStatement(sql);
				            ps.setString(1, disciplina.getDisciplina());
				            ps.setString(2, disciplina.getSemestre());
				            ps.setString(3, disciplina.getNotas());
				            ps.setInt(4, disciplina.getFaltas());
				            ps.setInt(5, disciplina.getRgm());
				            
				            ps.executeUpdate();
				        
				        
				        conn = ConnectionFactory.getConnection();
				    } catch(Exception e) {
				        throw new Exception("Erro ao salvar: " + e.getMessage());
				    }
				}
				
				// Procurar Disciplina
				public Disciplina procurarDisciplina(int rgm) throws Exception {
				    try {
				        String sql = "SELECT * FROM notasfaltas WHERE rgm=?";
				        ps = conn.prepareStatement(sql);
				        ps.setInt(1, rgm);
				        rs = ps.executeQuery();
				        if (rs.next()) {
				            String disciplina = rs.getString(1);
				            String semestre = rs.getString(2);
				            String notas = rs.getString(3);
				            int faltas = rs.getInt(4);
				            int rgmDisciplina = rs.getInt(5);

				            return new Disciplina(notas, disciplina, semestre, rgm, faltas);
				        }
				    } catch (SQLException sqle) {
				        throw new Exception("Erro ao procurar disciplina: " + sqle.getMessage());
				    } finally {
				        ConnectionFactory.closeConnection(conn, ps, rs);
				    }

				    return null; // Retorna null se a disciplina não for encontrada
				}
				
				public List<Disciplina> listarDisciplinas(int rgm) throws Exception {
				    List<Disciplina> disciplinas = new ArrayList<>();

				    try {
				        String sql = "SELECT * FROM notasfaltas WHERE rgm=?";
				        ps = conn.prepareStatement(sql);
				        ps.setInt(1, rgm);
				        rs = ps.executeQuery();

				        while (rs.next()) {
				            String disciplina = rs.getString("disciplina");
				            String semestre = rs.getString("semestre");
				            String notas = rs.getString("notas");
				            int faltas = rs.getInt("faltas");
				            int rgmDisciplina = rs.getInt("rgm");

				            Disciplina d = new Disciplina(disciplina, semestre, notas, faltas, rgmDisciplina);
				            disciplinas.add(d);
				        }
				    } catch (SQLException sqle) {
				        throw new Exception("Erro ao listar disciplinas: " + sqle.getMessage());
				    } finally {
				        ConnectionFactory.closeConnection(conn, ps, rs);
				    }

				    return disciplinas;
				}


				
				
			}

				


