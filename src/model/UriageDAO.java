package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UriageDAO {
	static final String URL =  "jdbc:mysql://localhost/hanbai?useSSL=false";
	static final String USER = "java";
	static final String PASS = "pass";

	public ArrayList<Uriage> findAll() {
		ArrayList<Uriage> list = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

			String sql = "SELECT * FROM uriage";
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				int uid = rs.getInt("uid");
				int sid = rs.getInt("sid");
				int kosu = rs.getInt("kosu");
				Date hi = rs.getDate("hi");

				//Uriage u = new Uriage(uid,sid,kosu,hi);
				Uriage u = new Uriage();
				u.setUid(uid);
				u.setSid(sid);
				u.setKosu(kosu);
				u.setHi(hi);

				list.add(u);
			}

			stmt.close();

		} catch (SQLException e) {
			System.out.println("findAllエラー:" + e.getMessage());
		}
		return list;
	}

	public ArrayList<Uriage> findBySid(int sid) {
		ArrayList<Uriage> list = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

			String sql = "SELECT * FROM uriage WHERE sid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, sid);

			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				int uid = rs.getInt("uid");
				int kosu = rs.getInt("kosu");
				Date hi = rs.getDate("hi");

				Uriage u = new Uriage(uid,sid,kosu,hi);
				list.add(u);
			}

			stmt.close();

		} catch (SQLException e) {
			System.out.println("findBySidエラー:" + e.getMessage());
		}
		return list;
	}

	public Uriage findByUid(int uid) {
		Uriage u = null;
		try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

			String sql = "SELECT * FROM uriage WHERE uid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, uid);

			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				int sid = rs.getInt("sid");
				int kosu = rs.getInt("kosu");
				Date hi = rs.getDate("hi");

				u = new Uriage(uid,sid,kosu,hi);
			}

			stmt.close();

		} catch (SQLException e) {
			System.out.println("findByUidエラー:" + e.getMessage());
		}
		return u;
	}

	public void insert(Uriage u) {
		try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

			String sql = "INSERT INTO uriage (sid,kosu,hi) VALUES( ? ,? ,curdate())";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, u.getSid());
			stmt.setInt(2, u.getKosu());

			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("insertエラー:" + e.getMessage());
		}
	}

	public void update(Uriage u) {
		try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

			String sql = "UPDATE uriage SET sid=?,kosu=?,hi=? WHERE uid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, u.getSid());
			stmt.setInt(2, u.getKosu());
			stmt.setDate(3, u.getHi());
			stmt.setInt(4, u.getUid());

			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("updateエラー:" + e.getMessage());
		}
	}

	public void delete(int uid) {
		try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

			String sql = "DELETE FROM uriage WHERE uid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, uid);

			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("deleteエラー:" + e.getMessage());
		}
	}

}
