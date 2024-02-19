showAll();
function showAll() {
    axios.get("http://localhost:8080/products").then((response) => {
        let list = response.data;
        let html = '';
        for (let i = 0; i < list.length; i++) {
            html += `<h1>Name: ${list[i].name} - Price: ${list[i].price} <button onclick="remove(${list[i].id})">Xóa</button> | <button onclick="showFormEdit(${list[i].id})">Sửa</button></h1>`
        }
        document.getElementById("main").innerHTML = html;
    })
}

function remove(id) {
    let isConfirm = confirm("Bạn muốn xóa?")
    if(isConfirm) {
        axios.delete("http://localhost:8080/products/" + id).then(() => {
            showAll();
        })
    }
}