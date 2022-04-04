package it.polito.tdp.librettovoti.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.librettovoti.model.Voto;

public class LibrettoDAO {

	public boolean creaVoto(Voto v) {
		try {
			Connection conn = DBConnect.getConnection();

			String sql = "INSERT INTO voti (nome, punti, data) VALUES (?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, v.getNome());
			st.setInt(2, v.getPunti());
			st.setDate(3, Date.valueOf(v.getData()));

			int res = st.executeUpdate();
			st.close();

			conn.close();
			
			return (res==1) ;
			
		} catch (SQLException e) {
			System.out.print(e);
			e.printStackTrace();
			return false ;
		}
	}

	public List<Voto> readAllVoto() {
		try {
			Connection conn = DBConnect.getConnection() ;
			String sql = "SELECT * FROM voti";
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet res = st.executeQuery();

			List<Voto> result = new ArrayList<>();
			while (res.next()) {
				String nome = res.getString("nome");
				int punti = res.getInt("punti");
				LocalDate dataEsame = res.getDate("data").toLocalDate();
				result.add(new Voto(nome, punti, dataEsame));
			}
			st.close();
			conn.close();
			return result ;
		} catch(SQLException e) {
			System.out.print(e);
			e.printStackTrace();
			return null ;
		}

	}

//	public Voto readVotoByNome(String nome) {
//
//	}
}
