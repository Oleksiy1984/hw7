package com.orlovskiy.controller;
import com.orlovskiy.dao.StudentDAO;
import com.orlovskiy.dao.StudentDAOImpl;
import com.orlovskiy.model.Students;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;




@WebServlet( description = "Servlet",  urlPatterns = { "/StudentController" })
public class StudentController extends HttpServlet {

    private StudentDAO dao;

    public StudentController() {
        this.dao = new StudentDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Students student = null;
        try {
            student = Students.builder().name(request.getParameter("name"))
                    .surname(request.getParameter("surname"))
                    .birthday(new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("birthday")))
                    .phone(Integer.parseInt(request.getParameter("phone")))
                    .email(request.getParameter("email")).build();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String studentid = request.getParameter("id");
        if(studentid == null || studentid.isEmpty())
        {
            dao.addStudent(student);
        }
        else
        {
            student.setId(Long.parseLong(studentid));
            dao.updateStudent(student);
        }
        RequestDispatcher view = request.getRequestDispatcher("/showAll.jsp");
        request.setAttribute("student", dao.getAllStudents());
        view.forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        switch (action) {
            case "showAll":
                forward = "/showAll.jsp";
                request.setAttribute("student", dao.getAllStudents());
                break;
            case "delete":
                forward = "/showAll.jsp";
                Long studentId = Long.parseLong(request.getParameter("id"));
                dao.deleteStudent(studentId);
                request.setAttribute("student", dao.getAllStudents());
                break;
            case "edit":
                forward = "/insert.jsp";
                Long sId = Long.parseLong(request.getParameter("id"));
                Students student = dao.getStudentById(sId);
                request.setAttribute("student", student);
                break;
            default:
                forward = "/insert.jsp";
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}
