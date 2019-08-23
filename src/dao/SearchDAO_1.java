package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.goodsModel_1;
import model.searchModel_1;

public class SearchDAO_1 {

	private String url = "jdbc:postgresql://localhost:5432/postgres";
	private String user = "postgres";
	private String pw = "";

	/**
	 * JDBCドライバのロード
	 * @throws IllegalStateException
	 */
	private void loadDriver() throws IllegalStateException{
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバが見つかりません");
		}
	}

	/**
	 * 商品(商品名)の単一検索
	 * @throws IllegalStateException -  JDBCドライバのロードに失敗
	 * @throws SQLException - データベースアクセスエラー
	 */

	public goodsModel_1 selectGoods(searchModel_1 search) throws IllegalStateException, SQLException {
			loadDriver();  // ドライバのロード
			goodsModel_1 goods = null;
		 try (Connection con = DriverManager.getConnection(url, user, pw)) {
			PreparedStatement pstmt = con.prepareStatement("SELECT 商品コード,カテゴリー,商品名,単価,ファイルID,商品ステータス FROM goods WHERE 商品名 = ?");
			pstmt.setString(1, search.getGoodsName());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String itemCode = rs.getString("商品コード");
				String selectbox = rs.getString("カテゴリー");
				String itemName = rs.getString("商品名");
				int itemPrice = rs.getInt("単価");
				String itemImg = rs.getString("ファイルID");
				String itemStatus = rs.getString("商品ステータス");
				goods = new goodsModel_1(itemCode, selectbox, itemName, itemPrice, itemImg, itemStatus);
			}


		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("エラーが起きています");
			return null;
		}

		return goods;
	}

	/**
	 * 商品(商品カテゴリー)の単一検索
	 * @return - 商品のリスト
	 * @throws IllegalStateException -  JDBCドライバのロードに失敗
	 * @throws SQLException - データベースアクセスエラー
	 */

	/*public List<goodsModel> selectCategory(searchModel search) throws IllegalStateException, SQLException {
		loadDriver();  // ドライバのロード
		List<goodsModel> goodsList = new ArrayList<goodsModel>();

		try (Connection con = DriverManager.getConnection(url, user, pw)) {
			PreparedStatement pstmt = con.prepareStatement("SELECT itemCode, category, itemName, itemPrice, itemImg, itemStatus FROM TB_Goods WHERE itemName = ?");
			pstmt.setString(1, search.getSelectbox());
			pstmt.setString(2, search.getGoodsName());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int itemCode = rs.getInt("itemCode");
				String selectbox = rs.getString("category");
				String itemName = rs.getString("itemName");
				int itemPrice = rs.getInt("itemPrice");
				String itemImg = rs.getString("itemImg");
				String itemStatus = rs.getString("itemStatus");
				goodsModel goods = new goodsModel(itemCode, selectbox, itemName, itemPrice, itemImg, itemStatus);
				goodsList.add(goods);
			}

		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("エラーが起きています");
			return null;
		}
		return goodsList;
	}
	*/

	/**
	 * 商品(カテゴリー+商品名)の複合検索
	 * @return - 商品のリスト
	 * @throws IllegalStateException -  JDBCドライバのロードに失敗
	 * @throws SQLException - データベースアクセスエラー
	 */

}
