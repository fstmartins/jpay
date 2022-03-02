import * as grid from "https://unpkg.com/ag-grid-community/dist/ag-grid-community.min.noStyle.js";

const url = 'http://localhost:8080/client-api/phone-numbers';

const request = new XMLHttpRequest();
request.open('GET', url, true);

request.onload = function() {
  if (request.status === 200) {
    const phones = JSON.parse(request.responseText);
    renderDataInTable(phones);
   } else {
    // Reached the server, but it returned an error
  }   
}

const columnDefs = [
  { field: 'id' },
  { field: 'name' },
  { field: 'number' },
];

const gridOptions = {
  columnDefs: columnDefs,
  onGridReady: (event) =>{renderDataInTheTable(event.api)}
};

const eGridDiv = document.getElementById('data-table');
        new grid.agGrid.Grid(eGridDiv, gridOptions);


function renderDataInTable(phones) {
  fetch(url)
    .then(function (response) {
      return response.json();
    }).then(function (data) {
      api.setRowData(data);
      api.sizeColumnsToFit();
    });
}

request.onerror = function() {
  console.error('An error occurred fetching the JSON from ' + url);
};

request.send();

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
  //do nothing
 
}

