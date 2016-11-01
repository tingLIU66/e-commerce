package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import service.representation.review.ReviewRepresentation;

import com.mysql.jdbc.PreparedStatement;

import model.review.Review;

public class ReviewDAO extends Databaseoperation {

	public ReviewDAO() {
		super();
	}

	Set<Review> reviews = new HashSet<Review>();

	public void writeReview(String reviewcontent, int productID, String customerusername, int rate) {

		String witereviewquery = "insert into productreview (`ProductReviewContent`,`Rating`,`Product_ProductID`,`Customer_Username`)  VALUES(?,?,?,?);";

		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();

			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(witereviewquery);
			preStatement.setString(1, "reviewcontent");
			preStatement.setInt(2, rate);
			preStatement.setInt(3, productID);
			preStatement.setString(4, "customerusername");

			preStatement.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);
	}
	
	public Review getReview(int reviewID) {
		Review review = new Review();
		String getquery = "SELECT ProductReviewID, `ProductReviewContent`, `Rating`, `ProductReviewDate`, `Product_ProductID`, `Customer_Username` FROM ProductReview WHERE ProductReviewID = ?;";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(getquery);
			preStatement.setInt(1, reviewID);
			ResultSet rs = preStatement.executeQuery();

			review.setProductreviewID(reviewID);
			review.setProductreviewcontent(rs.getString(2));
			review.setRating(rs.getInt(3));
			review.setProductreviewDate(rs.getDate(4));
			review.setCustomerusername(rs.getString(5));
			review.setProductproductID(rs.getInt(6));
		
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);

		return review;
	}

	public Set<Review> getRelatedReviews(int productID) {

		Review review = new Review();
		String dispalyreviewquery = "Select * from ProductReview where Product_ProductID = ?";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(dispalyreviewquery);
			preStatement.setInt(1, productID);
			ResultSet rs = preStatement.executeQuery();

			while (rs.next()) {

				review.setProductreviewID(rs.getInt(1));
				review.setProductreviewcontent(rs.getString(2));
				review.setRating(rs.getInt(3));
				review.setProductreviewDate(rs.getDate(4));
				review.setProductproductID(rs.getInt(5));
				review.setCustomerusername(rs.getString(6));

				reviews.add(review);
			}

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		super.closeConnection(connection);

		return reviews;

	}

}
