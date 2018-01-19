package basico;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insertar
 */
@WebServlet("/Insertar")
public class Insertar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insertar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String mail = request.getParameter("mail");
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		String titulo = request.getParameter("titulo");
		String contenido = request.getParameter("contenido");
		
		response.setContentType("text/html");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/periodico", "root", "");
			
			PreparedStatement st = conn.prepareStatement("insert into noticias(mail, id_categoria, titulo, contenido) values (?, ?, ?, ?)");
			
			st.setString(1, mail);
			st.setInt(2, categoria);
			st.setString(3, titulo);
			st.setString(4, contenido);
			
			st.executeUpdate();
			
			PrintWriter out = response.getWriter();
			
			out.println("<p>Fila insertada</p>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
