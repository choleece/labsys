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
import com.orm.Tshiyanshimanager;
import com.orm.Ttea;

public class shiyanshimanager_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		if(type.endsWith("shiyanshimanagerMana"))
		{
			shiyanshimanagerMana(req, res);
		}
		if(type.endsWith("shiyanshimanagerAdd"))
		{
			shiyanshimanagerAdd(req, res);
		}
		if(type.endsWith("shiyanshimanagerDel"))
		{
			shiyanshimanagerDel(req, res);
		}
	}
	
	
	public void shiyanshimanagerAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String id=String.valueOf(new Date().getTime());
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		String loginname=req.getParameter("loginname");
		String loginpw=req.getParameter("loginpw");
		String del="no";
		
		
		String sql="insert into t_shiyanshimanager values(?,?,?,?,?,?)";
		Object[] params={id,name,sex,loginname,loginpw,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "shiyanshimanager?type=shiyanshimanagerMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void shiyanshimanagerDel(HttpServletRequest req,HttpServletResponse res)
	{
		String sql="update t_shiyanshimanager set del='yes' where id=?";
		Object[] params={req.getParameter("id")};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "shiyanshimanager?type=shiyanshimanagerMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void shiyanshimanagerMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List shiyanshimanagerList=new ArrayList();
		String sql="select * from t_shiyanshimanager where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tshiyanshimanager shiyanshimanager=new Tshiyanshimanager();
				shiyanshimanager.setId(rs.getString("id"));
				shiyanshimanager.setName(rs.getString("name"));
				shiyanshimanager.setSex(rs.getString("sex"));
				shiyanshimanager.setLoginname(rs.getString("loginname"));
				shiyanshimanager.setLoginpw(rs.getString("loginpw"));
				shiyanshimanagerList.add(shiyanshimanager);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("shiyanshimanagerList", shiyanshimanagerList);
		req.getRequestDispatcher("admin/shiyanshimanager/shiyanshimanagerMana.jsp").forward(req, res);
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
