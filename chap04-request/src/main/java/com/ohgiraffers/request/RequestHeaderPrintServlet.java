package com.ohgiraffers.request;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/headers")
public class RequestHeaderPrintServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * [ 헤더의 종류 ]
        * 1. General header : 요청 및 응답 모두에 적용되지만 최종적으로는 body에 전송되는 것과 관련 없는 헤더
        * 2. Request header : Fetch될 리소스나 클라이언트 자체에 대한 상세 정보를 포함하는 헤더
        * 3. Response header : 위치나 서버 자체와 같은 응답에 대한 부가적인 정보를 갖는 헤더
        * 4. Entity header : 컨텐츠 길이나 MIME 타입과 같은 엔티티 body에 대한 상세 정보를 포함하는 헤더
        *                    (요청, 응답 모두 사양되며, 메시지 바디의 컨텐츠를 나타내므로 GET 요청은 해당하지 않음)
        * */

        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            System.out.println(headerNames.nextElement());
        }

        /*
        * host : 서버의 도메인 네임과 서버가 현재 Listening 중인 TCP포트 지정
        * connection : HTTP 통신이 완료된 후 네트워크 접속을 유지할지 결정
        * sec-ch-ua : 브라우저와 관련된 각 브랜드의 이름 및 주요 버전
        * sec-ch-ua-mobile
        * sec-ch-ua-platform
        * upgrade-insecure-requests
        * user-agent : 현재 사용자가 어떤 클라이언트(OS, browser 포함)을 이용해 보낸 요청인지 명시
        * accept : 요청을 보낼 때 서버에게 요청할 응답 타입 명시
        * sec-fetch-site : 출처(origin)와 요청된 resource 사이의 관계
        * sec-fetch-mode : 요청 모드
        * sec-fetch-user : 사용자가 시작한 요청일 때만 보내짐 (항상 ?1 값 가짐)
        * sec-fetch-dest : 요청 대상
        * referer : 이 페이지 이전에 대한 주소
        * accept-encoding : 응답 시 원하는 인코딩 방식
        * accept-language : 응답 시 원하는 언어
        * cookie
        * */

        System.out.println("host : " + request.getHeader("host"));
        System.out.println("connection : " + request.getHeader("connection"));
        System.out.println("sec-ch-ua : " + request.getHeader("sec-ch-ua"));
        System.out.println("sec-ch-ua-mobile : " + request.getHeader("sec-ch-ua-mobile"));
        System.out.println("sec-ch-ua-platform : " + request.getHeader("sec-ch-ua-platform"));
        System.out.println("upgrade-insecure-requests : " + request.getHeader("upgrade-insecure-requests"));
        System.out.println("user-agent : " + request.getHeader("user-agent"));
        System.out.println("accept : " + request.getHeader("accept"));
        System.out.println("sec-fetch-site : " + request.getHeader("sec-fetch-site"));
        System.out.println("sec-fetch-mode : " + request.getHeader("sec-fetch-mode"));
        System.out.println("sec-fetch-user : " + request.getHeader("sec-fetch-user"));
        System.out.println("sec-fetch-dest : " + request.getHeader("sec-fetch-dest"));
        System.out.println("referer : " + request.getHeader("referer"));
        System.out.println("accept-encoding : " + request.getHeader("accept-encoding"));
        System.out.println("accept-language : " + request.getHeader("accept-language"));
        System.out.println("cookie : " + request.getHeader("cookie"));
    }

}
