let customerData = {
  "customers": [{
    "id": 1,
    "firstname": "Bill",
    "lastname": "Clark",
    "email": "bill.clark@gmail.com"
  },
    {
      "id": 2,
      "firstname": "Claire",
      "lastname": "Reader",
      "email": "clareader@gmail.com"
    }]
};

function addDataToTable(tableId, data){
  let tableRef = document.getElementById(tableId);
  for (c in data.customers){
    let newRow = tableRef.insertRow(-1);
    let idCell = newRow.insertCell(0);
    let fnameCell = newRow.insertCell(1);
    let lnameCell = newRow.insertCell(2);
    let emailCell = newRow.insertCell(3);
    let idText = document.createTextNode(data.customers[c].id);
    let fnameText = document.createTextNode(data.customers[c].firstname);
    let lnameText = document.createTextNode(data.customers[c].lastname);
    let emailText = document.createTextNode(data.customers[c].email);
    idCell.appendChild(idText);
    fnameCell.appendChild(fnameText);
    lnameCell.appendChild(lnameText);
    emailCell.appendChild(emailText);
  }
}
let apiCallURL = "http://localhost:8080/demoCustomer-1.0-SNAPSHOT/api/customers";

/**
 * Function makes a HTTP request to an API
 * **/
function requestData(callURL){
  fetch(callURL, {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
    },
  })
    .then(response => response.json())
    .then(response => addDataToTable("customers", response));
}

(function () {
  // your page initialization code here
  // the DOM will be available here
  // console.log(customerData);
  // addDataToTable("customers");
  requestData(apiCallURL);

})();


