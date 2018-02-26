package servlets;

public class Product{
	
	public int ProdID, ProdQuantity, ProdRating, ProdType;
	public  String ProdName, ProdDesc, ProdBrand;
	public double ProdPrice; 

	public Product(int pId, String name, double price, int quantity, String desc, int rating, String brand, int type)
	{
		ProdID = pId;
		ProdName = name;
		ProdPrice = price;
		ProdQuantity = quantity;
		ProdDesc = desc;
		ProdRating = rating;
		ProdBrand = brand;
		ProdType = type;
	}


}