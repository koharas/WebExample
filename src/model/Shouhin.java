package model;
/**
 * 商品クラス。
 * @author edu00
 *
 */
public class Shouhin {
	/**
	 * 商品ID
	 */
	private int sid;
	private String sname;
	private int tanka;

	public Shouhin() {

	}

	/**
	 * コンストラクタ
	 * @param sid 商品id
	 * @param sname 商品名
	 * @param tanka 単価
	 */
	public Shouhin(int sid, String sname, int tanka) {
		this.sid = sid;
		this.sname = sname;
		this.tanka = tanka;
	}

	/**
	 * 商品IDを取得
	 * @return 商品ID
	 */
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getTanka() {
		return tanka;
	}

	public void setTanka(int tanka) {
		this.tanka = tanka;
	}


}
