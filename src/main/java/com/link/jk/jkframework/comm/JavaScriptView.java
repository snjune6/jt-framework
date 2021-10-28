package com.link.jk.jkframework.comm;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;


public class JavaScriptView extends AbstractView {

	private JavaScript javascript;


	public JavaScriptView(JavaScript javascript) {
		this.javascript = javascript;
	}


	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "text/html");

		PrintWriter out = response.getWriter();

		JavaScript script = null;
		script = this.javascript;

		out.println("<script>");
		out.println("alert('" + script.getMessage() + "');");
		out.println("location.href = '" + script.getLocation() + "';");
		out.println("</script>");


		out.flush();
		out.close();
		this.javascript = null;
	}
}
