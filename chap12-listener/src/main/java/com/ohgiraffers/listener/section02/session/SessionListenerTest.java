package com.ohgiraffers.listener.section02.session;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListenerTest implements HttpSessionListener, HttpSessionAttributeListener {

    /*
    * 2. session (-> session에서 발생 가능한 이벤트)
    *   - HttpSessionListener : Http Session의 시작/종료에 대한 이벤트 리스너
    *   - HttpSessionAttributeListener : Http Session에 attribute 추가/수정/삭제에 대한 이벤트 리스너
    * */
	
    public SessionListenerTest() {
    	/* session listener 인스턴스 생성 시(서버 시작 시) 동작 */
    	System.out.println("session listener 인스턴스 생성");
    }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	/* session에 attribute 수정 시 호출 */
    	System.out.println("session attribute 수정");
    	System.out.println("session에서 수정된 attr: " + se.getName() + ", " + se.getValue());
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	/* session 인스턴스 생성 시 동작 */
    	System.out.println("session 생성!!!");
    	System.out.println("생성된 session: " + se.getSession().getId());
    } 

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	/* session 만료 시 동작 */
    	System.out.println("session 소멸!!!");
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	/* session에서 attribute 제거 시 호출 */
    	System.out.println("session attribute 삭제");
    }

    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	/* session에 attribute 추가 시 호출 */
    	System.out.println("session attribute 추가");
    }
	
}
