function searchName() {
    let name = document.getElementById("searchName").value;
    axios.get("http://localhost:8080/products/findByName?name=" + name).then((response) => {
        let list = response.data;
        let html = '';
        for (let i = 0; i < list.length; i++) {
            html += `<h1>Name: ${list[i].name} - Price: ${list[i].price} <button onclick="remove(${list[i].id})">Xóa</button> | <button onclick="showFormEdit(${list[i].id})">Sửa</button></h1>`
        }
        document.getElementById("main").innerHTML = html;
    })
}