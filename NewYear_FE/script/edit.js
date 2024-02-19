function showFormEdit(id) {
    axios.get("http://localhost:8080/products/" + id).then((response) => {
        let productDetail = response.data;
        let html = `
            <div>
                <input type="text" id="name" placeholder="Name" value="${productDetail.name}">
                <input type="text" id="price" placeholder="Price" value="${productDetail.price}">
                <input type="text" id="quantity" placeholder="Quantity" value="${productDetail.quantity}">
                <input type="text" id="idCategory" placeholder="IdCategory" value="${productDetail.category.id}">
                <button onclick="edit(${id})">Sua</button>
            </div>
            `
        document.getElementById("main").innerHTML = html;
    })
}

function edit(id) {
    let name = document.getElementById("name").value;
    let price = document.getElementById("price").value;
    let quantity = document.getElementById("quantity").value;
    let idCategory = document.getElementById("idCategory").value;

    let productEdit = {
        name: name,
        price: price,
        quantity: quantity,
        category: {
            id: idCategory
        }
    }

    axios.put("http://localhost:8080/products/" + id, productEdit).then(() => {
        showAll();
    })
}