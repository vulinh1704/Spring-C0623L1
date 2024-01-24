function showHome() {
    axios.get('http://localhost:8080/cityBoys').then(function (response) {
        let cityBoys = response.data;
        let html = `
        <table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Age</td>
        <td>Email</td>
        <td>City</td>
        <td colspan="2">Action</td>
    </tr>
        `;
        for (let i = 0; i < cityBoys.length; i++) {
            html += `
            <tr>
                <td>${cityBoys[i].id}</td>
                <td>${cityBoys[i].name}</td>
                <td>${cityBoys[i].age}</td>
                <td>${cityBoys[i].email}</td>
                <td>${cityBoys[i].city.name}</td>
                <td>Sửa</td>
                <td><button onclick="remove(${cityBoys[i].id})">Xóa</button></td>
            </tr>
            `
        }
        html += '</table>'
        document.getElementById("main").innerHTML = html;
    })
}

showHome();

function remove(id) {
    let isConfirm = confirm("Chắc chắn chứ?")
    if(isConfirm) {
        axios.delete(`http://localhost:8080/cityBoys/${id}`).then((response) => {
            alert("Xóa thành công");
            showHome();
        })
    } else {
        alert("Rảnh à")
    }
}


