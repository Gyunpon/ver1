package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SearchLogic_1;
import model.goodsModel_1;
import model.searchModel_1;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet4")
public class SearchDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータを受け取る
		request.setCharacterEncoding("UTF-8");
		String selectbox = request.getParameter("selectbox");
		String goodsName = request.getParameter("goodsName");

		searchModel_1 search = new searchModel_1(selectbox, goodsName);

		SearchLogic_1 searchLogic= new SearchLogic_1();
		goodsModel_1 goods;

		//HttpSessionのインスタンス取得
		HttpSession session =  request.getSession();

		try {
			goods = searchLogic.execute(search);

			//セッションスコープにインスタンスを保存
			session.setAttribute("goods", goods);

		} catch (IllegalStateException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//結果を出力(フォワード)
		request.getRequestDispatcher("ec002_searchresult4.jsp").forward(request, response);
	}

}
