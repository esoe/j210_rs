package com.example.dev_j200_2;

import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "ServletViewList", value = "/ServletViewList")
public class ServletViewList extends HttpServlet {

    @EJB
    private PersonService personService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sendResponse(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sendResponse(request, response);
    }

    private void sendResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filterParam = request.getParameter("filter");
        Map<Person, Set<Passport>> personMap = filter(personService.getAllPerson(), filterParam);
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Все персоны</h1>");
        out.println("<form action=\"ServletViewList\" method=\"get\" align=\"center\">\n" +
                "    <input type=\"text\" name=\"filter\">\n" +
                "    <input type=\"submit\" value=\"Filter\">\n" +
                "</form><br><br>");
        out.println("<table align=\"center\" cellpadding=\"5\" border=\"1\" cellspacing=\"0\">");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>NAME</th>");
        out.println("<th>SERIAL</th>");
        out.println("<th>NUMBER</th>");
        out.println("</tr>");
        for(Person person : personMap.keySet()){
            if(person.getPassports().size()>0) {
                for(Passport passport : personMap.get(person)) {
                    out.println("<tr>");
                    out.println("<td>" + person.getId() + "</td>");
                    out.println("<td>" + person.getName() + "</td>");
                    out.println("<td>" + passport.getSerial() + "</td>");
                    out.println("<td>" + passport.getNumber() + "</td>");
                    out.println("</tr>");
                }
            }else {
                out.println("<tr>");
                out.println("<td>" + person.getId() + "</td>");
                out.println("<td>" + person.getName() + "</td>");
                out.println("<td></td>");
                out.println("<td></td>");
                out.println("</tr>");
            }
        }
        out.println("</table>");
        out.println("</body></html>");
    }

    private Map<Person, Set<Passport>> filter(Set<Person> persons, String filterparam){
        Map<Person, Set<Passport>> personMap = new HashMap<>();
        for (Person person : persons) {
            personMap.put(person, person.getPassports());
        }
        if(filterparam!=null && !filterparam.isEmpty()) {
            Iterator<Person> personIter = personMap.keySet().iterator();
            while (personIter.hasNext()){
                Person person = personIter.next();
                if(!person.getName().toLowerCase().contains(filterparam.toLowerCase())){
                    Iterator<Passport> passportIter = personMap.get(person).iterator();
                    while (passportIter.hasNext()){
                        Passport passport = passportIter.next();
                        if(!(passport.getSerial() + "" + passport.getNumber()).contains(filterparam)){
                            passportIter.remove();
                        }
                    }
                    if(personMap.get(person).size()==0) personIter.remove();
                }
            }
        }
        return personMap;
    }
}
