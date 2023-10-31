// let baseUrl :string = "http://localhost:8080/BackEnd_war";

$("#Register").click(function () {
    var formData = new FormData($("#RegistrationForm")[0]);
    console.log(formData)

    $.ajax({
        url: "http://localhost:8080/BackEnd_war/customer",
        method: "post",
        data: formData,
        async: true,
        contentType: false,
        processData: false,
        type: 'POST',
        success: function (resp) {
            alert(resp.message);
        },
        error: function (err) {
            // let errMessage = JSON.parse(err.responseText);
            // alert(errMessage.message);
            // console.log(errMessage.message);
            alert(err.message)
        }
    });
});