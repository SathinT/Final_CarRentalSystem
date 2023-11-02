// let baseUrl :string = "http://localhost:8080/BackEnd_war";

$("#CarsaveBtn").click(function () {
    var formData = new FormData($("#CarRegistrationForm")[0]);
    console.log(formData)

    $.ajax({
        url: "http://localhost:8080/BackEnd_war/car",
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
            alert(err.message)
        }
    });
});