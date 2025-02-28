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

    // Array to track the status of seats (false = available, true = booked)
    private boolean seats[];

    public SeatBookSrv() {
        // Initialize an array of 20 seats (all available initially)
        seats = new boolean[20]; // false means unreserved, true means reserved
    }

    /**
     * Handles GET requests, displaying the seat booking interface
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Generate HTML output for displaying seats and booking form
        StringBuilder temp = new StringBuilder();
        temp.append("<!DOCTYPE html>\r\n")
            .append("<html>\r\n")
            .append("<head>\r\n")
            .append("<meta charset=\"UTF-8\">\r\n")
            .append("<title>Bus Seat Booking</title>\r\n")
            .append("<link rel=\"stylesheet\" href=\"Display.css\">\r\n")
            .append("<script>\r\n")
            .append("    // JavaScript function to set the selected seat value\r\n")
            .append("    function selectSeat(value) {\r\n")
            .append("        // Set the value of the hidden input field to the selected seat number\r\n")
            .append("        document.getElementById(\"selectedSeat\").value = value;\r\n")
            .append("    }\r\n")
            .append("</script>\r\n")
            .append("</head>\r\n")
            .append("<body>\r\n")
            .append("    <form action=\"SeatBookSrv\" method=\"POST\">\r\n")
            .append("        <table>\r\n")
            .append("            <tr>\r\n")
            .append("                <td colspan=\"3\"><h2>Muni Bus Seat Booking</h2></td>\r\n")
            .append("            </tr>\r\n");

        // Add the seat buttons dynamically (same as in doGet)
        for (int i = 0; i < 20; i++) {
            char seatLabel = (char) ('A' + i); // Seat labels: A, B, C, ..., T
            String color = seats[i] ? "red" : "green"; // Red for reserved, green for available

            // Start a new row every 3 seats
            if (i % 3 == 0) {
                temp.append("            <tr>\r\n");
            }

            // Add a button for the current seat
            temp.append("                <td><input type=\"button\" value=\"" + seatLabel + "\" onclick=\"selectSeat('" + seatLabel + "')\" style=\"background-color: " + color + ";\"></td>\r\n");

            // Close the row after every 3 seats
            if (i % 3 == 2 || i == 19) { // Close row after 3 seats or after the last seat
                temp.append("            </tr>\r\n");
            }
        }

        // Add a hidden input field for the selected seat
        temp.append("        </table>\r\n")
            .append("        <input type=\"hidden\" id=\"selectedSeat\" name=\"selectedSeat\">\r\n")
            .append("        <input type=\"submit\" value=\"Book My Seat\"/>\r\n");

        // If a seat was booked (after form submission), show success/error message
        String selectedSeat = request.getParameter("selectedSeat");
        if (selectedSeat != null && !selectedSeat.isEmpty()) {
            int seatIndex = selectedSeat.charAt(0) - 'A';
            if (!seats[seatIndex]) {
                // Seat booking successful
                seats[seatIndex] = true;
                temp.append("<p style='color:green;'>Seat " + selectedSeat + " has been successfully booked!</p>");
            } else {
                // Seat already booked
                temp.append("<p style='color:red;'>Sorry, seat " + selectedSeat + " is already taken. Please select another seat.</p>");
            }
        }

        // Close HTML tags
        temp.append("    </form>\r\n")
            .append("</body>\r\n")
            .append("</html>\r\n");

        // Send the HTML as the response
        response.getWriter().append(temp.toString());
    }

    /**
     * Handles POST requests, performing the seat booking logic
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to doGet to render the updated seat booking interface
        doGet(request, response);
    }
}
