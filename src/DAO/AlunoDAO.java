package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.Aluno;

public class AlunoDAO {

	Connection con;
	PreparedStatement pstm;
	ResultSet rs;
	List<Aluno> res = new ArrayList<>();
	Aluno aluno = new Aluno();

	public void cadastrarBD(Aluno aluno) {
		String comando = "INSERT INTO aluno (nome,idade) VALUES (?,?)";

		con = new ConexaoDAO().conectarBD();

		try {

			pstm = con.prepareStatement(comando);
			pstm.setString(1, aluno.getNome());
			pstm.setInt(2, aluno.getIdade());

			pstm.execute();
			pstm.close();
		}

		catch (SQLException e) {
			System.out.println("Erro de cadastro: " + e.getMessage());
		}
	}

	public List<Aluno> listarBD() {

		String comando = "select * from aluno";

		con = new ConexaoDAO().conectarBD();

		try {
			pstm = con.prepareStatement(comando);
			rs = pstm.executeQuery();

			while (rs.next()) {
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setIdade(rs.getInt("idade"));

				res.add(aluno);
			}

		} catch (SQLException e) {
			System.out.println("Erro de listagem: " + e.getMessage());
		}

		return res;
	}

	public void excluir(int id) {
		String comando = "delete from aluno where id = ?";

		con = new ConexaoDAO().conectarBD();

		try {
			pstm = con.prepareStatement(comando);
			pstm.setInt(1, id);

			pstm.execute();
			pstm.close();

		} catch (SQLException e) {
			System.out.println("Erro ao excluir: " + e.getMessage());
		}

	}
	
	public void alterarBD(Aluno aluno) {
		String comando = "update aluno set nome = ?, idade = ? where id = ?";
		
		con = new ConexaoDAO().conectarBD();
		
		try {
			pstm = con.prepareStatement(comando);
			pstm.setString(1, aluno.getNome());
			pstm.setInt(2, aluno.getIdade());
			pstm.setInt(3, aluno.getId());
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException e) {
			System.out.println("Erro ao alterar: " + e.getMessage());
		}
		
	}
}
