package com.training.bean;

public class DBAddproductBean {
	private String prodname;
	private String prodtitle;
	private String prodmodel;
	private int prodprice;
	private int prodquan;
	private String prodcategory;
	
	
	public DBAddproductBean() {
	}

	public DBAddproductBean(String prodname, String prodtitle,String prodmodel, int prodprice, int prodquan, String prodcategory ) {
		super();
		this.setProdname(prodname);
		this.setProdtitle(prodtitle);
		this.setProdmodel(prodmodel);
		this.setProdprice(prodprice);
		this.setProdquan(prodquan);
		this.setProdmodel(prodcategory);
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public String getProdtitle() {
		return prodtitle;
	}

	public void setProdtitle(String prodtitle) {
		this.prodtitle = prodtitle;
	}

	public String getProdmodel() {
		return prodmodel;
	}

	public void setProdmodel(String prodmodel) {
		this.prodmodel = prodmodel;
	}

	public int getProdprice() {
		return prodprice;
	}

	public void setProdprice(int prodprice) {
		this.prodprice = prodprice;
	}

	public int getProdquan() {
		return prodquan;
	}

	public void setProdquan(int prodquan) {
		this.prodquan = prodquan;
	}

	public String getProdcategory() {
		return prodcategory;
	}

	public void setProdcategory(String prodcategory) {
		this.prodcategory = prodcategory;
	}
	@Override
	public String toString() {
		//return "AddproductBean [prodname=" + prodname + ", prodtitle=" + prodtitle + ", prodmodel=" + prodmodel + ", prodprice=" + prodprice + ",prodquan=" + prodquan + ", discquan=" + discquan + ", discprice=" + discprice + ", points=" + points + "]";
		return "DBAddproductBean [prodname=" + prodname + ", prodtitle=" + prodtitle + ", prodmodel=" + prodmodel + ", prodprice=" + prodprice + ",prodquan=" + prodquan + ", prodcategory=" + prodcategory + "]";
	}

}
