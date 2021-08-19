const automobileTableBody = document.querySelector('.automobile-table-container');
const makerSelect = document.querySelector('#maker-names-select');
const modelSelect = document.querySelector('#model-names-select');
const errorList = document.querySelector(`#error-msgs`);

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
                            document.querySelector('#autoId').value = id;
                            document.querySelector('#maker-names-select').value = auto.makerName;
                            document.querySelector('#model-names-select').value = auto.modelName;
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
        'makerName': document.querySelector('#maker-names-select').value,
        'modelName': document.querySelector('#model-names-select').value,
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
    }).then(res => {
            if (res.ok !== true) {
                throw res.json();
            }
            document.querySelector("#loadAllAutomobiles").onclick();

            document.querySelector('#ownerEmail').value = '';
            document.querySelector('#horsePower').value = '';
            document.querySelector('#colour').value = '';
            document.querySelector('#registrationNumber').value = '';
            document.querySelector('#engineCapacity').value = '';
        })
        .catch(err => {
            err.then(e => {
                errorList.innerHTML = '';
                if (e.length > 0) {
                    e.forEach(ex => {
                        const messageNewField = document.createElement('li');

                        messageNewField.innerText = ex.to + " " + ex.ex;
                        messageNewField.value = ex.to + " " + ex.ex;

                        errorList.appendChild(messageNewField);
                    });
                }
            })
    });
}

document.querySelector('#edit-btn').onclick = e => {
    e.preventDefault();

    const automobile = {
        'makerName': document.querySelector('#maker-names-select').value,
        'modelName': document.querySelector('#model-names-select').value,
        'ownerEmail': document.querySelector('#ownerEmail').value,
        'horsePower': document.querySelector('#horsePower').value,
        'colour': document.querySelector('#colour').value,
        'registrationNumber': document.querySelector('#registrationNumber').value,
        'engineCapacity': document.querySelector('#engineCapacity').value
    }
    fetch(`http://localhost:8080/automobiles/${document.querySelector('#autoId').value}`, {
        body: JSON.stringify(automobile)
        , method: 'PATCH'
        , headers: {
            "Content-type": "application/json"
        }
    }).then(res => {
        if (res.ok !== true) {
            throw res.json();
        }
        document.querySelector("#loadAllAutomobiles").onclick();
    }).catch(err => {
        console.log(err);
        err.then(e => {
            errorList.innerHTML = '';
            if (e.length > 0) {
                e.forEach(ex => {
                    const messageNewField = document.createElement('li');

                    messageNewField.innerText = ex.to + " " + ex.ex;
                    messageNewField.value = ex.to + " " + ex.ex;

                    errorList.appendChild(messageNewField);
                });
            }
        })
    });
}

fetch('http://localhost:8080/makers/names')
    .then(res => res.json())
    .then(json => {
        json.forEach(maker => {
            const op = document.createElement("option");
            op.innerText = maker;
            op.value = maker;
            makerSelect.appendChild(op);
        });
    });

fetch('http://localhost:8080/models/names')
    .then(res => res.json())
    .then(json => {
        json.forEach(model => {
            const op = document.createElement("option");
            op.innerText = model;
            op.value = model;
            modelSelect.appendChild(op);
        });
    });