function cancelForm() {
    window.location = "[[@{/student}]]";
}

$('#student-form').submit(function (e) {
    if (!validateFormStudent()) {
        e.preventDefault();
    } else {
        this.submit();
    }
});

function validateFormStudent() {
    var phone = $('#phone');
    var email = $('#email');
    // Kiểm tra số điện thoại
    if (phone.val() == '') {
        alert("Vui lòng nhập số điện thoại!");
        phone.focus();
        return false;
    } else if (!phone.val().match(/^\d{3}\d{3}\d{4}$/)) {
        alert('Số điện thoại không hợp lệ. Vui lòng nhập theo định dạng 0987654321');
        phone.focus();
        return false;
    }
    // Kiểm tra email
    if (email.val() == '') {
        alert("Vui lòng nhập địa chỉ email!");
        email.focus();
        return false;
    } else if (!email.val().match(/^\S+@\S+\.\S+$/)) {
        alert("Địa chỉ email không hợp lệ!");
        email.focus();
        return false;
    }
}