package model;

public class Gengou {
	private int gengou;
	private int nen;

	public Gengou(int gengou, int nen) {
		this.gengou = gengou;
		this.nen = nen;
	}

	public int getGengou() {
		return gengou;
	}
	public void setGengou(int gengou) {
		this.gengou = gengou;
	}
	public int getNen() {
		return nen;
	}
	public void setNen(int nen) {
		this.nen = nen;
	}
	public int getSeireki() {
		if( gengou == 3) {
			return 2018+nen;
		}
		if( gengou == 2) {
			return 1988+nen;
		}
		if( gengou == 1) {
			return 1925+nen;
		}
		return 0;
	}
	public String getName() {
		String[] names = {"昭和","平成","令和"};
		return names[gengou-1];
	}

}
