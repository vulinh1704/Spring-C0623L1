function showFormCreate() {
    document.getElementById('main').innerHTML = `
    <div>
    <input type="text" id="name" placeholder="Name">
    <input type="text" id="age" placeholder="Age">
    <input type="text" id="email" placeholder="Email">
    <input type="text" id="cityID" placeholder="City Id">
    <button onclick="create()">Thêm mới</button>
</div>
    `
}

function create() {
    let name = document.getElementById('name').value;
    let age = document.getElementById('age').value;
    let email = document.getElementById('email').value;
    let cityID = document.getElementById('cityID').value;

    let newCityBoy = {
        name: name,
        age: age,
        email: email,
        city: {
            id: cityID
        }
    }

    axios.post('http://localhost:8080/cityBoys', newCityBoy).then(function (response) {
        showHome();
    })
}