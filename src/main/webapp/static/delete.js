function deleteDept (no) {
    if (comfirm("确定要删除吗？")) {
        var httpRequest = new XMLHttpRequest();
        if (httpRequest) {
            httpRequest.open("get", 'delDept?no=' + no, true);
            httpRequest.onreadystatechange = function() {
                if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                    if (httpRequest.responseText.indexOf("success") >= 0) {
                        var tr = document.getElementById("tr" + no);
                        tr.parentNode.removeChild(tr);
                    }
                }
            };
            httpRequest.send();
        } else {
            alert("你可能使用了垃圾浏览器");
        }
    }
}
