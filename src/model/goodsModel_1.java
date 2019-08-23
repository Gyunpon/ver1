package model;

public class goodsModel_1 {

	private String itemCode;
	private String category;
	private String itemName;
	private int itemPrice;
	private String itemImg;
	private String itemStatus;

	public goodsModel_1(String itemCode, String category, String itemName, int itemPrice, String itemImg,
			String itemStatus) {
		super();
		this.itemCode = itemCode;
		this.category = category;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemImg = itemImg;
		this.itemStatus = itemStatus;
	}


	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemImg() {
		return itemImg;
	}

	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

}
