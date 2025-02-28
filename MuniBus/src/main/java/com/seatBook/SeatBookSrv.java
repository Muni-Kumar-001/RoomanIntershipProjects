package com.seatBook;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SeatBookSrv
 */
@WebServlet("/SeatBookSrv")
public class SeatBookSrv extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SeatBookSrv() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the selected seat from the request
        String selectedSeat = request.getParameter("selectedSeat");

        // Set the content type to HTML to display a response
        response.setContentType("text/html");

        // Get the response writer to write the HTML response
        response.getWriter().append("<html><body>")
                            .append("<h2>Seat Booking Confirmation</h2>");

        // Check if a seat was selected
        if (selectedSeat != null && !selectedSeat.isEmpty()) {
            // Display the selected seat
            response.getWriter().append("<p>You have selected seat: <strong>" + selectedSeat + "</strong></p>");
        } else {
            // Handle the case where no seat was selected (if needed)
            response.getWriter().append("<p>No seat selected. Please try again.</p>");
        }

        // Close the HTML tags
        response.getWriter().append("</body></html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Since the seat selection is being sent as a POST request, 
        // we can call the doGet method to handle both GET and POST requests.
        doGet(request, response);
    }
}
