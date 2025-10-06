document.getElementById("btnForm").onclick = function () {
    goForm(0);
}

goForm = function (keyValue) {
    seq.value = keyValue;
    form.action = goXdmForm;
    form.submit();
}