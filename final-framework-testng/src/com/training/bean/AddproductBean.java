package com.training.bean;

public class AddproductBean {

	private String prodname;
	private String prodtitle;
	private String prodmodel;
	private String prodprice;
	private String prodquan;
	private String discquan;
	private String discprice;
	private String points;
	
	public AddproductBean() {
	}

	public AddproductBean(String prodname, String prodtitle,String prodmodel, String prodprice ) {
		super();
		this.prodname = prodname;
		this.prodtitle = prodtitle;
		this.prodmodel = prodmodel;
		this.prodprice = prodprice;
	}

	public String getprodname() {
		return prodname;
	}

	public void setprodname(String prodname) {
		this.prodname = prodname;
	}

	public String getprodtitle() {
		return prodtitle;
	}

	public void setprodtitle(String prodtitle) {
		this.prodtitle = prodtitle;
	}
	
	public String getprodmodel() {
		return prodmodel;
	}

	public void setprodmodel(String prodmodel) {
		this.prodmodel = prodmodel;
	}
	
	public String getprodprice() {
		return prodprice;
	}

	public void setprodprice(String prodprice) {
		this.prodprice = prodprice;
	}

	
	public String getProdquan() {
		return prodquan;
	}

	public void setProdquan(String prodquan) {
		this.prodquan = prodquan;
	}

	public String getDiscprice() {
		return discprice;
	}

	public void setDiscprice(String discprice) {
		this.discprice = discprice;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getDiscquan() {
		return discquan;
	}

	public void setDiscquan(String discquan) {
		this.discquan = discquan;
	}

	@Override
	public String toString() {
		//return "AddproductBean [prodname=" + prodname + ", prodtitle=" + prodtitle + ", prodmodel=" + prodmodel + ", prodprice=" + prodprice + ",prodquan=" + prodquan + ", discquan=" + discquan + ", discprice=" + discprice + ", points=" + points + "]";
		return "AddproductBean [prodname=" + prodname + ", prodtitle=" + prodtitle + ", prodmodel=" + prodmodel + ", prodprice=" + prodprice + ",prodquan=" + prodquan + ", discquan=" + discquan + ", discprice=" + discprice + ", points=" + points + "]";
	}

}
