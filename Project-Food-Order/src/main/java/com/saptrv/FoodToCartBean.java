package com.saptrv;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class FoodToCartBean {
	Blob image;
	float pay;
	String filename,name,type;
	boolean b=false;
	

	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public float getPay() {
		return pay;
	}
	public void setPay(float pay) {
		this.pay = pay;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void valid() throws Exception
	{
		Connection cn=DBManager.getConnection();
		PreparedStatement ps=cn.prepareStatement("insert into TEMPCART values (?,?,?,?)");
		ps.setString(1, name);
		ps.setString(2, type);
		ps.setBlob(3, image);
		ps.setFloat(4, pay);
		int i=ps.executeUpdate();
		if(i!=0)
		{
			System.out.println("Added To Cart");
		}else {
			System.out.println("Not Added :-(");
		}
		ps.close();
		cn.close();
		
	}
}
