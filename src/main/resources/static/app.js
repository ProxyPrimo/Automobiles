const automobileTableBody = document.querySelector('.automobile-table-container');

document.querySelector('#loadAllAutomobiles').onclick = () => {
    document.querySelector('.automobile-table-container').innerHTML = '';
    automobileTableBody.innerHTML = '';
    fetch('http://localhost:8080/automobiles')
        // .then(r => r.json())
        // .then(json => json.forEach(auto => {
        //     const tableRow = `<tr>
        //         <td>${auto.makerName}</td>
        //         <td>${auto.modelName}</td>
        //         <td>${auto.engineCapacity}</td>
        //         <td>${auto.registrationNumber}</td>
        //         <td>${auto.colour}</td>
        //         <td>${auto.horsePower}</td>
        //         <td>${auto.ownerFullName}</td>
        //         <td><button data-id="${auto.id}">Edit</button></td>
        //         <td><button data-id="${auto.id}">Delete</button></td>
        //         </tr>`
        //     automobileTableBody.innerHTML += tableRow;
        // }));
    //  For Testing purposes
        .then(() => {
            const tableRow = `<tr>
                <td>Audi</td>
                <td>Test</td>
                <td>Test</td>
                <td>Test</td>
                <td>Test</td>
                <td>Test</td>
                <td>Test</td>
                <td><button data-id="1">Edit</button></td>
                <td><button data-id="1">Delete</button></td>
                </tr>`
            automobileTableBody.innerHTML += tableRow;
        });
}

document.querySelector('#create-btn').onclick = e => {
    e.preventDefault();

    const automobile = {
        'maker': document.querySelector('#maker').value,
        'model': document.querySelector('#model').value,
        'ownerFirstName': document.querySelector('#ownerFirstName').value,
        'ownerMiddleName': document.querySelector('#ownerMiddleName').value,
        'ownerLastName': document.querySelector('#ownerLastName').value,
        'horsePower': document.querySelector('#horsePower').value,
        'colour': document.querySelector('#colour').value,
        'registrationNumber': document.querySelector('#registrationNumber').value,
        'engineCapacity': document.querySelector('#engineCapacity').value
    }
    console.log(automobile);
    fetch("/automobiles", {
        body: JSON.stringify(automobile),
        method: 'POST',
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => res.json())
        .then(() => {
            document.querySelector("#loadAllAutomobiles").onclick();
        })
}