package model;

public class searchModel_1 {

	private String selectbox;
	private String goodsName;

	public searchModel_1(String selectbox, String goodsName) {
		super();
		this.selectbox = selectbox;
		this.goodsName = goodsName;
	}

	public String getSelectbox() {
		return selectbox;
	}

	public void setSelectbox(String selectbox) {
		this.selectbox = selectbox;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
}
