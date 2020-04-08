package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.model.Parola;


public class AnagrammaDAO {

	public boolean isCorrect(String anagramma) {
		
		String sql= "SELECT nome FROM parola WHERE nome = ?";
		
		List<Parola> parole= new LinkedList<Parola>();
		
		String nome="";
		try {
			Connection conn= ConnectDB.getConnection();	
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();
		
			while(rs.next()) {
				nome= rs.getString("nome");
				
				Parola p= new Parola(nome, true);
				parole.add(p);
			}
			
			if(nome.compareTo(anagramma)==0) {
				conn.close();
				return true;
			}else {
				conn.close();
				return false;
			}
		
			
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
		
}
