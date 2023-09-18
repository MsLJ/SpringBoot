function getverifyMailEvent() {

	$("#mail-Check-btn").click(function() {
		var name = document.querySelector('#username').value;
		var freeFix = document.querySelector('#freefix').value;
		var email = name + freeFix;
		var user = {
			username: email
		};


		$.ajax({
			url: "/api/mailcheck",
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(user),
			success: function(authNum) {
				if (authNum !== null) {
					alert("이메일이 전송됐습니다.");
					console.log(authNum);
					sessionStorage.setItem("au",authNum);
					
					$('.mail-check-input').removeAttr('disabled');
				} else {
					alert("이메일 인증코드 전송 실패");
				}
			},
			error: function() {
				alert("이메일 전송 실패");
			}
		});
	});


}




$(function() {
	getverifyMailEvent();
});