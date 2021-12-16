function view_PhotoCard(filename) {
  let photoNum = parseInt(filename.substring(6,7));
  location.href = "/photoCard/" + photoNum;
}

function popup_DeleteBox(id) {
  let popupWrap = document.getElementById("popup_wrap");
  let deleteId = document.getElementById("deleteId");
  deleteId.setAttribute("value", id);

  popupWrap.style.display = "flex";
}

function delete_Msg() {
  let id = document.getElementById("deleteId").getAttribute("value");
  let pwd = document.getElementById("deletePwd").value;

  location.href = "/msgDelete/" + id + "/" + pwd;
}

function close_Popup() {
  document.getElementById("popup_wrap").style.display = "none";
  document.getElementById("deleteId").setAttribute("value", "");
  document.getElementById("deletePwd").value = "";
  document.getElementById("alertPwd").style.color = "whitesmoke";
}

function check_Pwd() {
  let id = document.getElementById("deleteId").getAttribute("value");
  let pwd = document.getElementById("deletePwd").value;
  let pwd_alert = document.getElementById("alertPwd");

  if(pwd === "") {
    pwd_alert.innerText = "패스워드를 입력하세요.";
    pwd_alert.style.color = "red";
    return;
  }

  $.ajax({
    url:"/pwdCheck/" + id,
    type:"POST",
    data:JSON.stringify(pwd),
    contentType: "application/json",
    success: function(result) {
      if (result) {
        delete_Msg();
      }
      else {
        pwd_alert.innerText = "패스워드가 틀렸습니다.";
        pwd_alert.style.color = "red";
      }
    }, error: function() { alert("에러 발생"); }
  });
}

