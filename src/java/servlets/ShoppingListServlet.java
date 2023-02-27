
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Densa
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        if (action != null && action.equals("logout")) {
            session.invalidate();
            response.sendRedirect("shoppingList");
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);  
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatch1 = getServletContext().getRequestDispatcher("/WEB-INF/register.jsp");
        RequestDispatcher dispatch2 = getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp");
        
       // variables
        HttpSession session = request.getSession();
        ArrayList<String> items = new ArrayList<>();
        String username = request.getParameter("username");
        String action = request.getParameter("action");
        String item = request.getParameter("item");
        String deleteItem = request.getParameter("itemRadio");
        
        switch (action) {
            case "register":
                if (username == null || username.equals("") ) {
                    request.setAttribute("message", "Please enter username");
                    dispatch1.forward(request, response);
                } else {
                    session.setAttribute("username", username);
                }
                break;
            case "add":
                if (item == null || item.equals("")) {
                    request.setAttribute("message2", "please enter item");
                } else {
                    request.setAttribute("message2", "");
                    items = (ArrayList<String>) session.getAttribute("items");
                    items.add(item);
                }
                break;
            case "delete":
                if (deleteItem == null || deleteItem.equals("")) {
                    request.setAttribute("message2", "Please select items to remove");
                } else {
                    request.setAttribute("message2", "");
                    items = (ArrayList<String>) session.getAttribute("items");
                    items.remove(deleteItem);
                }
                break;
                
        }
        session.setAttribute("items", items);
        dispatch2.forward(request, response);
    }
}
