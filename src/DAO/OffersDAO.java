package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDAO")
public class OffersDAO {
	
	// Some template thing fed with a DataSource object from beans which refers to a class imported used for SQL connections???
	// JDBC template "wraps" DataSource
	private NamedParameterJdbcTemplate jdbc;
	
	public List<Offer> getOffers(){	
		
		MapSqlParameterSource input = new MapSqlParameterSource();
		
		return jdbc.query("SELECT * FROM Offers", input, new RowMapper<Offer>(){

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				
				offer.setID(rs.getInt("IDOffers"));
				offer.setName(rs.getString("Name"));
				offer.setEmail(rs.getString("Email"));
				offer.setDescription(rs.getString("Description"));
				return offer;
			}
			
		});
	}
	
	public Offer getOffer(int id){	
		
		MapSqlParameterSource input = new MapSqlParameterSource();
		input.addValue("id", id);

		return jdbc.queryForObject("SELECT * FROM Offers WHERE IDOffers = :id", input, new RowMapper<Offer>(){

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				
				offer.setID(rs.getInt("IDOffers"));
				offer.setName(rs.getString("Name"));
				offer.setEmail(rs.getString("Email"));
				offer.setDescription(rs.getString("Description"));
				return offer;
			}
		});
	}
	
	public int delete(int id){
		MapSqlParameterSource input = new MapSqlParameterSource();
		input.addValue("id", id);
		return jdbc.update("DELETE FROM Offers WHERE IDOffers = :id", input);
	}
	
	public boolean create(Offer offer){
		BeanPropertySqlParameterSource input = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.update("INSERT INTO Offers (Name, Email, Description) VALUES (:name, :email, :description)", input) == 1;
	}
	

	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@Transactional
	public int[] create(List<Offer> offers){
		SqlParameterSource[] batchValues = SqlParameterSourceUtils.createBatch(offers.toArray());
		
		return jdbc.batchUpdate("INSERT INTO Offers (Name, Email, Description) VALUES (:name, :email, :description)", batchValues);
	}
}
