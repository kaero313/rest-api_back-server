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

        try {
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();

            if(selectMember != null){
                writer.println("로그인 완료\n계정 이름은 " + selectMember.getName() + " 입니다");
            }else{
                writer.println("아이디 또는 비밀번호를 확인해주세요");
            }

            writer.close();
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

            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();

            if(apiService.selectMemberIdCheck(id)){
                writer.println("해당 아이디가 이미 존재합니다");
            }else{
                if(apiService.insertMember(member)){
                    writer.println("회원가입 완료");
                }else{
                    writer.println("회원가입 실패\n다시 시도해주세요");
                }
            }

            writer.close();

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

            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();

            if(apiService.updateMember(member)){
                writer.println("회원정보 변경 완료");
            }else{
                writer.println("회원정보 변경 실패\n다시 시도해주세요");
            }

            writer.close();

        }catch (IOException e1){

        }

    }

    @RequestMapping(value = "member", method = {RequestMethod.DELETE})
    public void deleteMember(@RequestBody String request1, HttpServletRequest request2, HttpServletResponse response, member member){

        try {

            JSONObject jsonobj = new JSONObject(request1);
            String id = jsonobj.getString("id");
            String pw = jsonobj.getString("pw");
            String name = jsonobj.getString("name");

            member.setId(id);
            member.setPw(pw);
            member.setName(name);

            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();

            if(apiService.deleteMember(member)){
                writer.println("회원 삭제 완료");
            }else{
                writer.println("회원 삭제 실패\n다시 시도해주세요");
            }

            writer.close();

        }catch (IOException e1){

        }

    }

}
