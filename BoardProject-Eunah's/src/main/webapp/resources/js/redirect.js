
//클릭한 버튼의 의도에 따라 location.href 속성을 변경해서 서블릿을 요청하는 함수
function moveLocation(intent) {
	
	var movePath = "/jsp";
	
	switch(intent){
		case "/" : movePath += "/"; break;
		case "insertMember" : movePath += "/member/insert"; break;
		case "updateMember" : movePath += "/member/update"; break;
		case "deleteMember" : movePath += "/member/delete"; break;
		case "logout" : movePath += "/member/logout"; break;
	}
	
	location.href = movePath;
}


//클릭한 버튼의 의도에 따라 location.href 속성값을 변경하여 서블릿을 호출하는 함수
//function request(intent) {
//	
//	var requestPath = "/jsp/";
//	
//	switch(intent) {
//		case "logout" : requestPath += "logout.me"; break;
//	}
//	
//	location.href = requestPath;
//}
