document.getElementById("changeAddressBtn").addEventListener("click", function (e) {
    e.preventDefault();

    const postNumber = document.getElementById("urPostNumber");
    const address = document.getElementById("urAddress");
    const detailAddress = document.getElementById("urDetailAddress");

    const postNumberError = document.getElementById("urPostNumberError");
    const addressError = document.getElementById("urAddressError");

    // 초기화: 오류 메시지 숨김 + 테두리 제거
    [postNumber, address, detailAddress].forEach(input => {
        input.classList.remove("is-invalid");
    });

    [postNumberError, addressError].forEach(error => {
        error.style.display = "none";
    });

    let isValid = true;

    // 우편번호: 공백이면 오류 메시지 표시
    if (!postNumber.value.trim()) {
        postNumber.classList.add("is-invalid");
        postNumberError.innerText = "우편번호를 입력해주세요.";
        postNumberError.style.display = "block";
        isValid = false;
    }

    // 주소: 공백이면 오류 메시지 표시
    if (!address.value.trim()) {
        address.classList.add("is-invalid");
        addressError.innerText = "주소를 입력해주세요.";
        addressError.style.display = "block";
        isValid = false;
    }

    // 상세주소는 공백일 경우 전송하지 않음
    const detailAddressValue = detailAddress.value.trim() ? detailAddress.value.trim() : undefined;

    if (!isValid) return;

    // AJAX 요청
    $.ajax({
        url: '/hof/hofUsrChangeAddressProc',
        type: 'POST',
        data: {
            urPostNumber: postNumber.value.trim(),
            urAddress: address.value.trim(),
            urDetailAddress: detailAddressValue // 공백이면 값이 넘어가지 않도록 처리
        },
        success: function (res) {
            if (res.rt === 'success') {
                $('#urAddChSuccessModal').modal('show');

                // 5초 후 자동 이동
                setTimeout(function () {
                    location.href = '/hof/hofUsrProfile';
                }, 5000);

                // 확인 버튼 클릭 시 즉시 이동
                document.getElementById("urPwChSuccessBtn").addEventListener("click", function () {
                    location.href = '/hof/hofUsrProfile';
                });
            } else {
                alert('알 수 없는 오류가 발생했습니다.');
            }
        },
        error: function () {
            alert('서버와 통신 중 오류가 발생했습니다.');
        }
    });
});
