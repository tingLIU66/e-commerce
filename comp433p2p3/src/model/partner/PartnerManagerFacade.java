package model.partner;

import java.sql.SQLException;

import dal.Databaseoperation;
import dal.PartnerDAO;
import model.customer.Customer;
import model.product.Product;

public class PartnerManagerFacade{
	
	PartnerDAO ptdao = new PartnerDAO();
	
	public Partner getPartner(int partnerID) throws SQLException{

		return ptdao.getPartner(partnerID);
	}
	
	public Partner addPartner(int partnerID, String partnerusername, String partnerpassword, String partnertype, 
			String partnername, String partneraddress, String partnerphonenumber) throws SQLException{
		
		return ptdao.addPartner(partnerID, partnerusername, partnerpassword, partnertype,
				partnername, partneraddress, partnerphonenumber);
		
	}

	public void deletePartner(int partnerID, String partnerpassword) throws SQLException{
		ptdao.deletePartner(partnerID, partnerpassword);
	}
	
	public Boolean verifyPartner(int partnerusername, String partnerpassword) throws SQLException{
		return ptdao.verifyPartner(partnerusername, partnerpassword);
	}
	
	public void notifyPartnersofsale(){
		ptdao.notifyPartnersofsale();
	}
	
	public void addPartnerProducts(){
         ptdao.addPartnerProducts();
	}
	
	public void settleAccount(){
		ptdao.settleAccount();
	}
	
	public void generateReport(){
		ptdao.generateReport();
	}
}
