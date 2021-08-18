const automobileTableBody = document.querySelector('.automobile-table-container');


$('#loadAllAutomobiles').click(() => {
    $('.automobile-table-container').empty();
    automobileTableBody.innerHTML = '';
    fetch('http://localhost:8080/automobiles')
        .then(r => r.json())
        .then(json => json.forEach(auto => {
            const tableRow = `<tr>
                <td>${auto.makerName}</td>
                <td>${auto.modelName}</td>
                <td>${auto.engineCapacity}</td>
                <td>${auto.registrationNumber}</td>
                <td>${auto.colour}</td>
                <td>${auto.horsePower}</td>
                <td>${auto.ownerFullName}</td>
                <td><button>Edit</button></td>
                <td><button>Delete</button></td>
                </tr>`
            automobileTableBody.innerHTML += tableRow;
        }));
        // .then(() => {
        //     const tableRow = `<tr>
        //         <td>Audi</td>
        //         <td>Test</td>
        //         <td>Test</td>
        //         <td>Test</td>
        //         <td>Test</td>
        //         <td>Test</td>
        //         <td>Test</td>
        //         <td><button>Edit</button></td>
        //         <td><button>Delete</button></td>
        //         </tr>`
        //     automobileTableBody.innerHTML += tableRow;
        // }); For Testing purposes
})