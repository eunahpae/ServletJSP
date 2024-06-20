package com.ohgiraffers.listener.section01.context;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListenerTest implements ServletContextListener, ServletContextAttributeListener {

    /*
    * 1. context (-> 톰캣 컨테이너 자체에 리스너 연결)
    *   - ServletContextListener : 웹 애플리케이션의 시작/종료에 대한 이벤트 리스너
    *   - ServletContextAttributeListener : context에 attribute 추가/수정/삭제에 대한 이벤트 리스너
    * */
	
    public ContextListenerTest() {
    	/* context listener 인스턴스 생성 시 동작 (contextInitialized()와 함께 동작) */
    	System.out.println("context listener 인스턴스 생성");
    }

    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	/* context에 attribute 수정 시 호출 */
    	System.out.println("context attribute 수정");
    }

    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	/* context에서 attribute 제거 시 호출 */
    	System.out.println("context attribute 삭제");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	/* context 최초 생성 시 호출 (기본생성자 호출 이후 동작) */
    	System.out.println("context init!!!!!");
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	/* context 소멸 시(= 애플리케이션 종료 시) 호출 */
    	System.out.println("context destroy!!!");
    }

    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	/* context에 attribute 추가 시 호출 */
    	System.out.println("context attribute 추가");
    }
	
}
