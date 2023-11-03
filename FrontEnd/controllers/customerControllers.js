// let baseUrl :string = "http://localhost:8080/BackEnd_war";

// customer Get All
$("#CustomerGetAll").click(function () {
    getAllCustomers();
});

//get all customer funtion
function getAllCustomers() {

    $("#CustomerTable").empty();

    $.ajax({
        url: 'http://localhost:8080/BackEnd_war/customer',
        dataType: "json",
        headers:{
            Auth:"user=admin,pass=admin"
        },
        success: function (response) {
            let customers = response.data;
            for (let i in customers) {
                let cus = customers[i];

                let customerId = cus.customerId;
                let name = cus.name;
                let address = cus.address;
                let contactNo = cus.contactNo;
                let email = cus.email;
                let nicNo = cus.nicNo;
                let licenNo = cus.licenNo;

                let row = `<tr><td>${customerId}</td><td>${name}</td><td>${address}</td><td>${contactNo}</td><td>${email}</td><td>${nicNo}</td><td>${licenNo}</td></tr>`;
                $("#CustomerTable").append(row);
            }
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}


// customer Save
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



// Customer Delet
let id = $("#customerId").val();

let consent = confirm("Do you want to delete.?");
if (consent) {
    let response = deleteCustomer(id);
    if (response) {
        alert("Customer Deleted");
        clearCustomerInputFields();
        getAllCustomers();
    } else {
        alert("Customer Not Removed..!");
    }
}






function deleteCustomer(id) {
    $.ajax({
        url:'customer?customerId=' + id,
        method: 'delete',
        headers:{
            Auth:"user=admin,pass=admin"
        },
        success: function (resp) {
            alert(resp.message);
            getAllCustomers();
            clearCustomerInputFields()
            return true;
        },
        error: function (error) {
            alert(error.responseJSON.message);
            return false;
        }
    });
}