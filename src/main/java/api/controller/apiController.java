package api.controller;

import api.dto.member;
import api.service.apiService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/api")
public class apiController {

    @Autowired
    private apiService apiService;

    public static void main(String args[]){

    }

    @RequestMapping(value = "member", method = {RequestMethod.GET})
    public void selectMember(@RequestBody String request1, HttpServletRequest request2, HttpServletResponse response, member member){

        member.setId(request2.getParameter("id"));
        member.setPw(request2.getParameter("pw"));

        member selectMember = apiService.selectMember(member);

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        try {
            if(selectMember != null){
                response.setStatus(HttpServletResponse.SC_OK);

                PrintWriter writer = response.getWriter();

                JSONObject jsonobj = new JSONObject(selectMember);
                writer.println(jsonobj);
                writer.close();
            }else{
                response.setStatus(HttpServletResponse.SC_OK);

                PrintWriter writer = response.getWriter();
                writer.println("회원 조회 실패\n아이디 또는 비밀번호를 확인해주세요");
                writer.close();
            }

        }catch (IOException e1){
            e1.printStackTrace();
        }

    }

    @RequestMapping(value = "member", method = {RequestMethod.POST})
    public void insertMember(@RequestBody String request1, HttpServletRequest request2, HttpServletResponse response, member member){

        try {

            JSONObject jsonobj = new JSONObject(request1);
            String id = jsonobj.getString("id");
            String pw = jsonobj.getString("pw");
            String name = jsonobj.getString("name");

            member.setId(id);
            member.setPw(pw);
            member.setName(name);

            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");

            if(apiService.selectMemberIdCheck(id)){
                response.setStatus(HttpServletResponse.SC_OK);

                PrintWriter writer = response.getWriter();
                writer.println("해당 아이디가 이미 존재합니다");
                writer.close();
            }else{
                if(apiService.insertMember(member)){
                    response.setStatus(HttpServletResponse.SC_CREATED);

                    PrintWriter writer = response.getWriter();
                    writer.println("회원가입 완료");
                    writer.close();
                }else{
                    response.setStatus(HttpServletResponse.SC_OK);

                    PrintWriter writer = response.getWriter();
                    writer.println("회원가입 실패\n다시 시도해주세요");
                    writer.close();
                }
            }


        }catch (IOException e1){

        }

    }

    @RequestMapping(value = "member", method = {RequestMethod.PUT})
    public void updateMember(@RequestBody String request1, HttpServletRequest request2, HttpServletResponse response, member member){

        try {

            JSONObject jsonobj = new JSONObject(request1);
            String id = jsonobj.getString("id");
            String pw = jsonobj.getString("pw");
            String name = jsonobj.getString("name");

            member.setId(id);
            member.setPw(pw);
            member.setName(name);

            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");

            if(apiService.updateMember(member)){
                response.setStatus(HttpServletResponse.SC_OK);

                PrintWriter writer = response.getWriter();
                writer.println("회원정보 변경 완료");
                writer.close();
            }else{
                response.setStatus(HttpServletResponse.SC_OK);

                PrintWriter writer = response.getWriter();
                writer.println("회원정보 변경 실패\n회원 정보를 확인 후에 다시 시도해주세요");
                writer.close();
            }


        }catch (IOException e1){

        }

    }

    @RequestMapping(value = "member", method = {RequestMethod.DELETE})
    public void deleteMember(@RequestBody String request1, HttpServletRequest request2, HttpServletResponse response, member member){

        try {

            JSONObject jsonobj = new JSONObject(request1);
            String id = jsonobj.getString("id");
            String pw = jsonobj.getString("pw");

            member.setId(id);
            member.setPw(pw);

            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");

            if(apiService.deleteMember(member)){
                response.setStatus(HttpServletResponse.SC_OK);

                PrintWriter writer = response.getWriter();
                writer.println("회원 삭제 완료");
                writer.close();
            }else{
                response.setStatus(HttpServletResponse.SC_OK);

                PrintWriter writer = response.getWriter();
                writer.println("회원 삭제 실패\n회원 정보를 확인 후에 다시 시도해주세요");
                writer.close();
            }


        }catch (IOException e1){

        }

    }

}
