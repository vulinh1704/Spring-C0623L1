function showFormCreate() {
    let html = `
    <div>
        <input type="text" id="name" placeholder="Name">
        <input type="text" id="price" placeholder="Price">
        <input type="text" id="quantity" placeholder="Quantity">
        <input type="text" id="idCategory" placeholder="IdCategory">
        <button onclick="add()">Thêm</button>
    </div>
    `
    document.getElementById("main").innerHTML = html;
}

function add() {
    let name = document.getElementById("name").value;
    let price = document.getElementById("price").value;
    let quantity = document.getElementById("quantity").value;
    let idCategory = document.getElementById("idCategory").value;

    let newProduct = {
        name: name,
        price: price,
        quantity: quantity,
        category: {
            id: idCategory
        }
    }

    axios.post("http://localhost:8080/products", newProduct).then(() => {
        showAll();
    })
}