// let baseUrl :string = "http://localhost:8080/BackEnd_war";

function bindTrEventsCar() {
    $('#CarTable>tr').click(function () {
        //get the selected rows data
        let CarId = $(this).children().eq(0).text();
        let CarRegNo = $(this).children().eq(1).text();
        let CarBrand = $(this).children().eq(2).text();
        let CarType = $(this).children().eq(3).text();
        let CarNoOfPassengers = $(this).children().eq(4).text();
        let CarColor = $(this).children().eq(5).text();
        let CarTransmission = $(this).children().eq(6).text();
        let CarFuel = $(this).children().eq(7).text();
        let CarCurrentMilage = $(this).children().eq(8).text();

        //set the selected rows data to the input fields
        $("#CarId").val(CarId);
        $("#CarRegNo").val(CarRegNo);
        $("#CarBrand").val(CarBrand);
        $("#CarType").val(CarType);
        $("#CarNoOfPassengers").val(CarNoOfPassengers);
        $("#CarColor").val(CarColor);
        $("#CarTransmission").val(CarTransmission);
        $("#CarFuel").val(CarFuel);
        $("#CarCurrentMilage").val(CarCurrentMilage);


    })
}

// car Get All
$("#CarTableBtn").click(function () {
    getAllCars();
});

//get all car funtion
function getAllCars() {
    //clear all tbody data before add
    $("#CarTable").empty();

    $.ajax({
        url: 'http://localhost:8080/BackEnd_war/car',
        dataType: "json",
        headers:{
            Auth:"user=admin,pass=admin"
        },
        success: function (response) {
            let cars = response.data;
            for (let i in cars) {
                let car = cars[i];

                let CarId = car.CarId;
                let CarRegNo = car.CarRegNo;
                let CarBrand = car.CarBrand;
                let CarType = car.CarType;
                let CarNoOfPassengers = car.CarNoOfPassengers;
                let CarColor = car.CarColor;
                let CarTransmission = car.CarTransmission;
                let CarFuel = car.CarFuel;
                let CarCurrentMilage = car.CarCurrentMilage;

                let row = `<tr><td>${CarId}</td><td>${CarRegNo}</td><td>${CarBrand}</td><td>${CarType}</td><td>${CarNoOfPassengers}</td><td>${CarColor}</td><td>${CarTransmission}</td><td>${CarFuel}</td><td>${CarCurrentMilage}</td></tr>`;
                $("#CarTable").append(row);
            }
            bindTrEventsCar();
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}


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