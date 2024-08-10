package api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class apiController {

    public static void main(String args[]){

    }

    @RequestMapping(value = "test", method = {RequestMethod.GET, RequestMethod.POST})
    public void test(@RequestBody String request, HttpServletResponse response){

        try {
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            writer.println(request);
            writer.close();
        }catch (IOException e1){

        }

        System.out.println(request);

    }


}
