package locadora.model.dao;

import java.sql.Connection;

import locadora.conexao.factory.jdbc.ConexaoException;
import locadora.conexao.factory.jdbc.FabricaConexao;

public class FuncionarioDao {

	
	private Connection conexao;

	public FuncionarioDao() throws ConexaoException {

		this.conexao = FabricaConexao.getConexao();

	}
	
	
	
	
	
	
	
	public void fecharConexao() throws ConexaoException {
		FabricaConexao.fecharConexao(conexao);
	}/*fecharConexao*/
	
	
}
