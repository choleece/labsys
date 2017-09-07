package com.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DB;
import com.orm.TAdmin;
import com.orm.Tshiyanshenqing;
import com.orm.Ttea;

public class shiyanshenqing_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		
		if(type.endsWith("shiyanshenqingAdd_stu"))
		{
			shiyanshenqingAdd_stu(req, res);
		}
		if(type.endsWith("shiyanshenqingMana_stu"))
		{
			shiyanshenqingMana_stu(req, res);
		}
		if(type.endsWith("shiyanshenqingMana_shiyanshiManager"))
		{
			shiyanshenqingMana_shiyanshiManager(req, res);
		}
		if(type.endsWith("shiyanshenqingDel"))
		{
			shiyanshenqingDel(req, res);
		}
		if(type.endsWith("shiyanshenqingShenhe"))
		{
			shiyanshenqingShenhe(req, res);
		}
		
		if(type.endsWith("shiyanshenqingMana_admin"))
		{
			shiyanshenqingMana_admin(req, res);
		}
	}
	
	
	public void shiyanshenqingAdd_stu(HttpServletRequest req,HttpServletResponse res)
	{
		String id=String.valueOf(new Date().getTime());
		String name=req.getParameter("name");
		String beizhu=req.getParameter("beizhu");
		String fujian=req.getParameter("fujian");
		
		String fujianYuanshiming=req.getParameter("fujianYuanshiming");
		String shiyanshijian=req.getParameter("shiyanshijian");
		String shenqingshijian=req.getParameter("shenqingshijian");
		int stu_id=Integer.parseInt(req.getParameter("stu_id"));
		
		String huifu="";
		String del="shenhezhong";
		
		
		String sql="insert into t_shiyanshenqing values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params={id,name,beizhu,fujian,fujianYuanshiming,shiyanshijian,shenqingshijian,stu_id,huifu,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "申请完毕。等待管理员审核");
        String targetURL = "/common/add_success.jsp";
		dispatch(targetURL, req, res);
	}
	

	public void shiyanshenqingMana_stu(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List shiyanshenqingList=new ArrayList();
		String sql="select * from t_shiyanshenqing where del !='yes' and stu_id=?";
		Object[] params={Integer.parseInt(req.getParameter("stu_id"))};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tshiyanshenqing shiyanshenqing=new Tshiyanshenqing();
				
				shiyanshenqing.setId(rs.getString("id"));
				shiyanshenqing.setName(rs.getString("name"));
				shiyanshenqing.setBeizhu(rs.getString("beizhu"));
				shiyanshenqing.setFujian(rs.getString("fujian"));
				
				shiyanshenqing.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				shiyanshenqing.setShiyanshijian(rs.getString("shiyanshijian"));
				shiyanshenqing.setShenqingshijian(rs.getString("shenqingshijian"));
				shiyanshenqing.setStu_id(rs.getInt("stu_id"));
				
				shiyanshenqing.setHuifu(rs.getString("huifu"));
				shiyanshenqing.setDel(rs.getString("del"));
				
				shiyanshenqingList.add(shiyanshenqing);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		System.out.println(shiyanshenqingList.size());
		req.setAttribute("shiyanshenqingList", shiyanshenqingList);
		req.getRequestDispatcher("admin/1stucaozuo/shiyanshenqing/shiyanshenqingMana_stu.jsp").forward(req, res);
	}
	
	
	public void shiyanshenqingMana_shiyanshiManager(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List shiyanshenqingList=new ArrayList();
		String sql="select * from t_shiyanshenqing where del !='yes'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tshiyanshenqing shiyanshenqing=new Tshiyanshenqing();
				
				shiyanshenqing.setId(rs.getString("id"));
				shiyanshenqing.setName(rs.getString("name"));
				shiyanshenqing.setBeizhu(rs.getString("beizhu"));
				shiyanshenqing.setFujian(rs.getString("fujian"));
				
				shiyanshenqing.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				shiyanshenqing.setShiyanshijian(rs.getString("shiyanshijian"));
				shiyanshenqing.setShenqingshijian(rs.getString("shenqingshijian"));
				shiyanshenqing.setStu_id(rs.getInt("stu_id"));
				
				shiyanshenqing.setHuifu(rs.getString("huifu"));
				shiyanshenqing.setDel(rs.getString("del"));
				
				shiyanshenqingList.add(shiyanshenqing);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		System.out.println(shiyanshenqingList.size());
		req.setAttribute("shiyanshenqingList", shiyanshenqingList);
		req.getRequestDispatcher("admin/1shiyanshimanager/shiyanshenqing/shiyanshenqingMana_shiyanshiManager.jsp").forward(req, res);
	}
	
	
	public void shiyanshenqingMana_admin(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List shiyanshenqingList=new ArrayList();
		String sql="select * from t_shiyanshenqing where del !='yes'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tshiyanshenqing shiyanshenqing=new Tshiyanshenqing();
				
				shiyanshenqing.setId(rs.getString("id"));
				shiyanshenqing.setName(rs.getString("name"));
				shiyanshenqing.setBeizhu(rs.getString("beizhu"));
				shiyanshenqing.setFujian(rs.getString("fujian"));
				
				shiyanshenqing.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				shiyanshenqing.setShiyanshijian(rs.getString("shiyanshijian"));
				shiyanshenqing.setShenqingshijian(rs.getString("shenqingshijian"));
				shiyanshenqing.setStu_id(rs.getInt("stu_id"));
				
				shiyanshenqing.setHuifu(rs.getString("huifu"));
				shiyanshenqing.setDel(rs.getString("del"));
				
				shiyanshenqingList.add(shiyanshenqing);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		System.out.println(shiyanshenqingList.size());
		req.setAttribute("shiyanshenqingList", shiyanshenqingList);
		req.getRequestDispatcher("admin/shiyanshenqing/shiyanshenqingMana_admin.jsp").forward(req, res);
	}
	
	
	public void shiyanshenqingDel(HttpServletRequest req,HttpServletResponse res)
	{
		String sql="update t_shiyanshenqing set del='yes' where id=?";
		Object[] params={req.getParameter("id")};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
        String targetURL = "/common/add_success.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	public void shiyanshenqingShenhe(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		String del=req.getParameter("del");
		String huifu=req.getParameter("huifu");
		
		String sql="update t_shiyanshenqing set del=?,huifu=? where id=?";
		Object[] params={del,huifu,id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
        String targetURL = "/common/add_success.jsp";
		dispatch(targetURL, req, res);
	}
	public void dispatch(String targetURI,HttpServletRequest request,HttpServletResponse response) 
	{
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(targetURI);
		try 
		{
		    dispatch.forward(request, response);
		    return;
		} 
		catch (ServletException e) 
		{
                    e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
		    e.printStackTrace();
		}
	}
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}
	
	public void destroy() 
	{
		
	}
}
