let baseUrl = "http://localhost:8080/BackEnd_war";

$("#Register").click(function () {
    let formData = new FormData($("#RegistrationForm")[0]);
    console.log(formData)

    $.ajax({
        url: baseUrl + "/customer",
        method: "post",
        data: formData,
        async: true,
        contentType: false,
        processData: false,
        success: function (resp) {
            alert(resp.message);
        },
        error: function (err) {
            let errMessage = JSON.parse(err.responseText);
            alert(errMessage.message);
            console.log(errMessage.message);
        }
    });
});