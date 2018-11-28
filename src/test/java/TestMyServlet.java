import app.entities.User;
import app.servlets.AddServlet;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestMyServlet extends Mockito {

    private static final String path = "views/add.jsp";

    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

        when(request.getParameter("name")).thenReturn("Max");
        when(request.getParameter("pass")).thenReturn("123456");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        new AddServlet().doPost(request, response);

        verify(request, times(1)).getParameter("name");
        verify(request, times(1)).getParameter("pass");
        verify(request, times(1)).getRequestDispatcher(path);
        verify(requestDispatcher, times(1)).forward(request, response);
        verify(request, times(1)).setAttribute("userName", "Max");
    //    Assert.assertEquals("Max",(User)request.getAttribute("userName"));
    }
}