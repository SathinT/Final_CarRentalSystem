// let baseUrl :string = "http://localhost:8080/BackEnd_war";

//bind tr events for getting back data of the rows to text fields
function bindTrEventsDriver() {
    $('#DriverTable>tr').click(function () {
        //get the selected rows data
        let driverId = $(this).children().eq(0).text();
        let driverLicenNo = $(this).children().eq(1).text();
        let driverName = $(this).children().eq(2).text();
        let driverEmail = $(this).children().eq(3).text();
        let driverContactNo = $(this).children().eq(4).text();

        //set the selected rows data to the input fields
        $("#driverId").val(driverId);
        $("#driverLicenNo").val(driverLicenNo);
        $("#driverName").val(driverName);
        $("#driverEmail").val(driverEmail);
        $("#driverContactNo").val(driverContactNo);


    })
}


// Driver Get All
$("#DriverGetAll").click(function () {
    getAllDrivers();
});

//get all customer funtion
function getAllDrivers() {

    $("#DriverTable").empty();

    $.ajax({
        url: 'http://localhost:8080/BackEnd_war/driver',
        dataType: "json",
        headers:{
            Auth:"user=admin,pass=admin"
        },
        success: function (response) {
            let drivers = response.data;
            for (let i in drivers) {
                let driver = drivers[i];

                let driverId = driver.driverId;
                let driverLicenNo = driver.driverLicenNo;
                let driverName = driver.driverName;
                let driverEmail = driver.driverEmail;
                let driverContactNo = driver.driverContactNo;

                let row = `<tr><td>${driverId}</td><td>${driverLicenNo}</td><td>${driverName}</td><td>${driverEmail}</td><td>${driverContactNo}</td></tr>`;
                $("#DriverTable").append(row);
            }
            bindTrEventsDriver();
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}



$("#DriversaveBtn").click(function () {
    var formData = new FormData($("#DriverRegistrationForm")[0]);


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