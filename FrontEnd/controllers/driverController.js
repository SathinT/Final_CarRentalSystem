// let baseUrl :string = "http://localhost:8080/BackEnd_war";

// Driver Get All
$("#DriverRefreshTable").click(function () {
    getAllDrivers();
});

//get all customer funtion
function getAllDrivers() {
    //clear all tbody data before add
    $("#CustomerTable").empty();

    $.ajax({
        url: 'http://localhost:8080/BackEnd_war/driver',
        dataType: "json",
        headers:{
            Auth:"user=admin,pass=admin"
        },
        success: function (response) {
            let drivers = response.data;
            for (let i in drivers) {
                let dri = drivers[i];

                let driverId = dri.driverId;
                let licenNo = dri.licenNo;
                let contactNo = dri.contactNo;
                let name = dri.name;
                let email = dri.email;

                let row = `<tr><td>${driverId}</td><td>${licenNo}</td><td>${contactNo}</td><td>${name}</td><td>${email}</td></tr>`;
                $("#CustomerTable").append(row);
            }
            // bindTrEvents();
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}



$("#DriversaveBtn").click(function () {
    var formData = new FormData($("#DriverRegistrationForm")[0]);
    console.log(formData)

    $.ajax({
        url: "http://localhost:8080/BackEnd_war/driver",
        method: "post",
        data: formData,
        async: true,
        contentType: false,
        processData: false,
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