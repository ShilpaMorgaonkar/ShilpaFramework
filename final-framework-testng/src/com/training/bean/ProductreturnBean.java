package com.training.bean;

public class ProductreturnBean {
	

		private String prodquan;
		private String reason;
		private String seloption;
		
		public ProductreturnBean() {
		}

		public ProductreturnBean(String prodquan, String reason,String seloption) {
			super();
			this.setProdquan(prodquan);
			this.setReason(reason);
			this.setSeloption(seloption);
			
		}

		public String getProdquan() {
			return prodquan;
		}

		public void setProdquan(String prodquan) {
			this.prodquan = prodquan;
		}

		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
		}

		public String getSeloption() {
			return seloption;
		}

		public void setSeloption(String seloption) {
			this.seloption = seloption;
		}
		
		@Override
		public String toString() {
			//return "AddproductBean [prodname=" + prodname + ", prodtitle=" + prodtitle + ", prodmodel=" + prodmodel + ", prodprice=" + prodprice + ",prodquan=" + prodquan + ", discquan=" + discquan + ", discprice=" + discprice + ", points=" + points + "]";
			return "AddproductBean [prodquan=" + prodquan + ", reason=" + reason + ", seloption=" + seloption + "]";
		}

}
