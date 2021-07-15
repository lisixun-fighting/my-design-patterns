package org.example.delegate;

import lombok.Getter;
import lombok.Setter;
import org.example.delegate.mvc.controllers.MemberController;
import org.example.delegate.mvc.controllers.OrderController;
import org.example.delegate.mvc.controllers.SystemController;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "dispatchServlet", value = "/*")
public class DispatcherServlet extends HttpServlet {

    private List<Handler> handlerMapping = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        try {
            Class<MemberController> memberControllerClass = MemberController.class;
            handlerMapping.add(new Handler()
                    .setController(memberControllerClass.getConstructor().newInstance())
                    .setMethod(memberControllerClass.getMethod("getMemberById", String.class))
                    .setUrl("/delegate/getMemberById.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = request.getRequestURI();
        Handler handler = null;
        for (Handler h : handlerMapping) {
            if (uri.equals(h.getUrl())) {
                handler = h;
                break;
            }
        }
        if (handler == null) {
            response.getWriter().write("404, Not Exists!!");
            return;
        }
        Object obj = null;
        try {
            obj = handler.getMethod().invoke(handler.getController(), request.getParameter("id"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws ServletException, InvocationTargetException, IllegalAccessException {
        init();
        Handler handler = handlerMapping.get(0);
        System.out.println(handler.getController());
        System.out.println(handler.getMethod());
        System.out.println(handler.getUrl());
        handler.getMethod().invoke(handler.getController(), handler.getUrl());
    }
}

@Getter
class Handler {
    private Object controller;
    private Method method;
    private String url;

    public Handler setController(Object controller) {
        this.controller = controller;
        return this;
    }

    public Handler setMethod(Method method) {
        this.method = method;
        return this;
    }

    public Handler setUrl(String url) {
        this.url = url;
        return this;
    }

}
