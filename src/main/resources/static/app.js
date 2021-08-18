const automobileTableBody = document.querySelector('.automobile-table-container');

document.querySelector('#loadAllAutomobiles').onclick = () => {
    document.querySelector('.automobile-table-container').innerHTML = '';
    automobileTableBody.innerHTML = '';
    fetch('http://localhost:8080/automobiles')
        .then(res => res.json())
        .then(json => {
            json.forEach(auto => {
                const tableRow = `<tr>
                <td>${auto.makerName}</td>
                <td>${auto.modelName}</td>
                <td>${auto.engineCapacity}</td>
                <td>${auto.registrationNumber}</td>
                <td>${auto.colour}</td>
                <td>${auto.horsePower}</td>
                <td>${auto.ownerFullName}</td>
                <td><button class="edit-btn" data-id="${auto.id}">Edit</button></td>
                <td><button class="delete-btn" data-id="${auto.id}">Delete</button></td>
                </tr>`
                automobileTableBody.innerHTML += tableRow;
            });

                [...document.querySelectorAll(".delete-btn")].forEach(btn => {
                btn.onclick = e => {
                    e.preventDefault();

                    const id = e.target.getAttribute("data-id");
                    fetch(`http://localhost:8080/automobiles/${id}`, {
                        method: "DELETE"
                    }).then(x => {
                        document.querySelector("#loadAllAutomobiles").onclick();
                    })
                }
            });

            [...document.querySelectorAll(".edit-btn")].forEach(btn => {
                btn.onclick = e => {
                    e.preventDefault();
                    const id = e.target.getAttribute("data-id");

                    fetch(`http://localhost:8080/automobiles/${id}`)
                        .then(res => res.json())
                        .then(auto => {
                            document.querySelector('#maker').value = auto.makerName;
                            document.querySelector('#model').value = auto.modelName;
                            document.querySelector('#ownerEmail').value = auto.ownerEmail;
                            document.querySelector('#horsePower').value = auto.horsePower;
                            document.querySelector('#colour').value = auto.colour;
                            document.querySelector('#registrationNumber').value = auto.registrationNumber;
                            document.querySelector('#engineCapacity').value = auto.engineCapacity;

                            document.querySelector("#edit-btn").style = "display: block";
                            document.querySelector("#create-btn").style = "display: none";
                        })
                }
            });
        });
}

document.querySelector('#create-btn').onclick = e => {
    e.preventDefault();

    const automobile = {
        'makerName': document.querySelector('#maker').value,
        'modelName': document.querySelector('#model').value,
        'ownerEmail': document.querySelector('#ownerEmail').value,
        'horsePower': document.querySelector('#horsePower').value,
        'colour': document.querySelector('#colour').value,
        'registrationNumber': document.querySelector('#registrationNumber').value,
        'engineCapacity': document.querySelector('#engineCapacity').value
    }

    fetch("http://localhost:8080/automobiles", {
        body: JSON.stringify(automobile),
        method: 'POST',
        headers: {
            "Content-Type": "application/json"
        }
    }).then(() => {
            document.querySelector("#loadAllAutomobiles").onclick();
        })
        .then(() => {
            document.querySelector('#maker').value = '';
            document.querySelector('#model').value = '';
            document.querySelector('#ownerEmail').value = '';
            document.querySelector('#horsePower').value = '';
            document.querySelector('#colour').value = '';
            document.querySelector('#registrationNumber').value = '';
            document.querySelector('#engineCapacity').value = '';
        });
}

document.querySelector('#edit-btn').onclick = e => {
    e.preventDefault();

    const automobile = {
        'makerName': document.querySelector('#maker').value,
        'modelName': document.querySelector('#model').value,
        'ownerEmail': document.querySelector('#ownerEmail').value,
        'horsePower': document.querySelector('#horsePower').value,
        'colour': document.querySelector('#colour').value,
        'registrationNumber': document.querySelector('#registrationNumber').value,
        'engineCapacity': document.querySelector('#engineCapacity').value
    }

    fetch(`http://localhost:8080/automobiles/${id}`, {
        body: JSON.stringify(automobile)
        , method: 'PATCH'
        , headers: {
            "Content-type": "application/json"
        }
    }).then(() => {
        document.querySelector("#loadAllAutomobiles").onclick();
    })
}
