package basico;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

/**
 * Servlet implementation class Consultar
 */
@WebServlet("/Consultar")
public class Consultar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consultar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//redirigir otra vez a leer.jsp
		//getServletConfig().getServletContext().getRequestDispatcher("/leer.jsp").forward(request, response);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/periodico", "root", "");
			
			Statement st = conn.createStatement();
			
			ResultSet rs =  st.executeQuery("select * from noticias");
			
			//PrintWriter out = response.getWriter();
			
			String resultado = "";
			
			resultado += "<table class='bordered striped'>";
			resultado += "<tr>";
			resultado += "<th>Id<th/>";
			resultado += "<th>mail<th/>";
			resultado += "<th>categoria<th/>";
			resultado += "<th>titulo<th/>";
			resultado += "<th>contenido<th/>";
			resultado += "<th>fecha<th/>";
			resultado += "<tr/>";
			while(rs.next()) {
				//out.println(rs.getString(4));
				resultado += "<tr>";
				resultado += "<td>" + rs.getInt(1) + "<td/>";
				resultado += "<td>" + rs.getString(2) + "<td/>";
				resultado += "<td>" + rs.getInt(3) + "<td/>";
				resultado += "<td>" + rs.getString(4) + "<td/>";
				resultado += "<td>" + rs.getString(5) + "<td/>";
				resultado += "<td>" + rs.getDate(6) + "<td/>";
				resultado += "<tr/>";
			}
			resultado += "<table/>";
			
			request.getSession().setAttribute("resultado", resultado);
			//redirigir otra vez a leer.jsp
			response.sendRedirect("leer.jsp");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
