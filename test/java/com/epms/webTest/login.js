function getData() {
    //获取输入框的文本
    var userNameLabel = document.getElementById('userName');
    var userName = userNameLabel.value;
    var passwordLabel = document.getElementById('password');
    var password = passwordLabel.value;
    var typeLabel = document.getElementsByName("type");
    var type;

    for (var i = 0; i < typeLabel.length; i++) {
        if (typeLabel[i].checked) {
            type = typeLabel[i].value;
            break;
        }
    }
    console.log(userName+":"+password+":",type)
    var data={
        userName: userName,
        password: password,
        type: type
    }
    return data;

}

function sendData() {
    var timestamp = (new Date()).valueOf();
    var token = md5("epms1" + timestamp);
    var data = getData();
    console.log(timestamp + ":", token + ":", data);
    $.ajax({
        url: "http://localhost:8080/User/Login",
        data: data,
        headers: {
            token: token,
            timestamp: timestamp
        },
        success: function (res) {
            console.log('res',res);
        },
        error: function (err) {
            console.log(err);
        }
    })
}
