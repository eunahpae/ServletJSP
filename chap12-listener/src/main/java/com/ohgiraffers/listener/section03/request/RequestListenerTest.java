package com.ohgiraffers.listener.section03.request;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class RequestListenerTest implements ServletRequestListener, ServletRequestAttributeListener {

    /*
    * 3. request (-> request 관련 이벤트)
    *   - ServletRequestListener : ServletRequest 생성/소멸에 대한 이벤트 리스너
    *   - ServletRequestAttributeListener : ServletRequest에 attribute 추가/삭제/수정에 대한 이벤트 리스너
    * */
	
    public RequestListenerTest() {
    	/* request listener 인스턴스 생성 시(서버 시작 시) 동작 */
    	System.out.println("request listener 인스턴스 생성");
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	/* request에서 attribute 삭제 시 호출 */
    	System.out.println("request attribute 삭제");
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
    	/* request 인스턴스 생성 시(서버 요청 시) 동작 */
    	System.out.println("request 생성!!!!!");
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
    	/* request 인스턴스 소멸 시(응답 완료 후 요청 해제 시) 동작 */
    	System.out.println("request 소멸!!!!!");
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae)  {
    	/* request에서 attribute 수정 시 호출 */
    	System.out.println("request attribute 수정");
    	System.out.println(srae.getName() + ", " + srae.getValue());
    }

    public void attributeAdded(ServletRequestAttributeEvent srae)  {
    	/* request에 attribute 추가 시 호출 */
    	System.out.println("request attribute 추가");
    }
	
}
