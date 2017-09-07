package com.orm;

public class Tshiyanshenqing
{
	private String id;
	private String name;
	private String beizhu;
	private String fujian;
	private String fujianYuanshiming;
	private String shiyanshijian;
	
    private String shenqingshijian;
    private int stu_id;
    private String huifu;
    private String del;//yes:É¾³ý£¬shenhezhong£ºÉóºËÖÐ£¬pass£ºÉóºËÍ¨¹ý£¬nopass£ºÉóºËÎ´Í¨¹ý
    
    
	public String getBeizhu()
	{
		return beizhu;
	}
	public void setBeizhu(String beizhu)
	{
		this.beizhu = beizhu;
	}
	public String getDel()
	{
		return del;
	}
	public void setDel(String del)
	{
		this.del = del;
	}
	public String getHuifu()
	{
		return huifu;
	}
	
	public String getFujian()
	{
		return fujian;
	}
	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}
	public String getFujianYuanshiming()
	{
		return fujianYuanshiming;
	}
	public void setFujianYuanshiming(String fujianYuanshiming)
	{
		this.fujianYuanshiming = fujianYuanshiming;
	}
	public void setHuifu(String huifu)
	{
		this.huifu = huifu;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getShenqingshijian()
	{
		return shenqingshijian;
	}
	public void setShenqingshijian(String shenqingshijian)
	{
		this.shenqingshijian = shenqingshijian;
	}
	public String getShiyanshijian()
	{
		return shiyanshijian;
	}
	public void setShiyanshijian(String shiyanshijian)
	{
		this.shiyanshijian = shiyanshijian;
	}
	public int getStu_id()
	{
		return stu_id;
	}
	public void setStu_id(int stu_id)
	{
		this.stu_id = stu_id;
	}
	
    
}
