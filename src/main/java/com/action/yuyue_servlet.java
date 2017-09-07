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
import com.orm.Tyuyue;
import com.service.liuService;

public class yuyue_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		
		if(type.endsWith("yuyueAdd_stu"))
		{
			yuyueAdd_stu(req, res);
		}
		if(type.endsWith("yuyueMana_stu"))
		{
			yuyueMana_stu(req, res);
		}
		if(type.endsWith("yuyueMana_tea"))
		{
			yuyueMana_tea(req, res);
		}
		if(type.endsWith("yuyueHuifu_tea"))
		{
			yuyueHuifu_tea(req, res);
		}
		
	}
	
	
	public void yuyueAdd_stu(HttpServletRequest req,HttpServletResponse res)
	{
		String id=String.valueOf(new Date().getTime());
		int tea_id=Integer.parseInt(req.getParameter("tea_id"));
		String yuyueshijian=req.getParameter("yuyueshijian");
		String beizhu=req.getParameter("beizhu");
		
		String shijian=req.getParameter("shijian");
		int stu_id=Integer.parseInt(req.getParameter("stu_id"));
		String huifu="";
		String del="no";
		
		String sql="insert into t_yuyue values(?,?,?,?,?,?,?,?)";
		Object[] params={id,tea_id,yuyueshijian,beizhu,shijian,stu_id,huifu,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
        String targetURL = "/common/add_success.jsp";
		dispatch(targetURL, req, res);
	}
	

	public void yuyueMana_stu(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List yuyueList=new ArrayList();
		String sql="select * from t_yuyue where del='no' and stu_id=?";
		Object[] params={Integer.parseInt(req.getParameter("stu_id"))};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tyuyue yuyue=new Tyuyue();
				
				yuyue.setId(rs.getString("id"));
				yuyue.setTea_id(rs.getInt("tea_id"));
				yuyue.setYuyueshijian(rs.getString("yuyueshijian"));
                yuyue.setBeizhu(rs.getString("beizhu"));
                
                yuyue.setShijian(rs.getString("shijian"));
                yuyue.setStu_id(rs.getInt("stu_id"));
				yuyue.setHuifu(rs.getString("huifu"));
				yuyue.setDel(rs.getString("del"));
				
				yuyue.setTea_name(liuService.getTeaName(rs.getInt("tea_id")));
				
				yuyueList.add(yuyue);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		System.out.println(yuyueList.size());
		req.setAttribute("yuyueList", yuyueList);
		req.getRequestDispatcher("admin/1stucaozuo/yuyue/yuyueMana_stu.jsp").forward(req, res);
	}
	
	public void yuyueMana_tea(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List yuyueList=new ArrayList();
		String sql="select * from t_yuyue where del='no' and tea_id=?";
		Object[] params={Integer.parseInt(req.getParameter("tea_id"))};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tyuyue yuyue=new Tyuyue();
				
				yuyue.setId(rs.getString("id"));
				yuyue.setTea_id(rs.getInt("tea_id"));
				yuyue.setYuyueshijian(rs.getString("yuyueshijian"));
                yuyue.setBeizhu(rs.getString("beizhu"));
                
                yuyue.setShijian(rs.getString("shijian"));
                yuyue.setStu_id(rs.getInt("stu_id"));
				yuyue.setHuifu(rs.getString("huifu"));
				yuyue.setDel(rs.getString("del"));
				
				yuyue.setStu_name(liuService.getStuName(rs.getInt("stu_id")));
				
				yuyueList.add(yuyue);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		System.out.println(yuyueList.size());
		req.setAttribute("yuyueList", yuyueList);
		req.getRequestDispatcher("admin/1teacaozuo/yuyue/yuyueMana_tea.jsp").forward(req, res);
	}
	
	public void yuyueHuifu_tea(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		String huifu=req.getParameter("huifu");
		
		String sql="update t_yuyue set huifu=? where id=?";
		Object[] params={huifu,id};
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
