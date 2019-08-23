package model;

import java.sql.SQLException;

import dao.SearchDAO_1;

public class SearchLogic_1 {

	//商品名で単一検索した場合のメソッド
	public goodsModel_1 execute(searchModel_1 search) throws IllegalStateException, SQLException {
		SearchDAO_1 dao = new SearchDAO_1();
		goodsModel_1 goods = dao.selectGoods(search);
		return goods;
	}

}
