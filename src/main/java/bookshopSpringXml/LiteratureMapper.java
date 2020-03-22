package bookshopSpringXml;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LiteratureMapper implements RowMapper {

	@Override
	public LiteratureNew mapRow(ResultSet rs, int rowNum) throws SQLException {
		LiteratureNew literatureNew;
		String type=rs.getString("type");
		if(type.equals("BOOK")) {
			String author = rs.getString("author");
            String title = rs.getString("title");
            String publisher = rs.getString("publisher");
            Integer year = rs.getInt("year");
			literatureNew=new BookNew(author, title, publisher, year);
			return literatureNew;
		}
		if(type.equals("MAGAZINE")) {
			String title = rs.getString("title");
            String publisher = rs.getString("publisher");
            Integer year = rs.getInt("year");
            Integer numbers_per_year = rs.getInt("numbers_per_year");
			literatureNew=new MagazineNew(title, publisher, year, numbers_per_year);
			return literatureNew;
		}
		return null;
	}

}
