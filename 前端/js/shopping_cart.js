storage = localStorage;
function doFirst(){
    tbody = document.getElementsByTagName('tbody')[0];
    jsonData = JSON.parse(storage.getItem('cart'));
    // console.log(jsonData.length);
    total = 0;
    for(let i = 0; i < jsonData.length; i++){
        createCartList(i);
        let itemPrice = parseInt(jsonData[i].price);
        total += itemPrice;
    }
    document.getElementById('total').innerText = total;
}
function createCartList(i){
    let itemTr = document.createElement('tr');
    tbody.appendChild(itemTr);

    let imgTd = document.createElement('td');
    let image = document.createElement('img');
    image.src = jsonData[i].image;
    image.style.width = 100;
    imgTd.appendChild(image);
    itemTr.appendChild(imgTd);

    let nameTd = document.createElement('td');
    let nameSpan = document.createElement('span');
    nameSpan.id = i;
    nameSpan.innerText = jsonData[i].item;
    nameTd.appendChild(nameSpan);
    itemTr.appendChild(nameTd);

    let dateTd = document.createElement('td');
    let dateSpan = document.createElement('span');
    dateSpan.innerText = jsonData[i].date;
    dateTd.appendChild(dateSpan);
    itemTr.appendChild(dateTd); 

    let timeTd = document.createElement('td');
    let timeSpan = document.createElement('span');
    timeSpan.innerText = jsonData[i].timeframe;
    timeTd.appendChild(timeSpan);
    itemTr.appendChild(timeTd); 

    let numTd = document.createElement('td');
    let numInput = document.createElement('input');
    numInput.type = 'number';
    numInput.value = 1;
    numInput.min = 1;
    numInput.addEventListener('input',changItemCount);
    numTd.appendChild(numInput);
    itemTr.appendChild(numTd); 

    let priceTd = document.createElement('td');
    let priceSpan = document.createElement('span');
    priceSpan.innerText = jsonData[i].price;
    priceTd.appendChild(priceSpan);
    itemTr.appendChild(priceTd);

    let delTd = document.createElement('td');
    let delBtn = document.createElement('button');
    delBtn.className = 'btn btn-primary btn-sm text-light btn_delete';
    delBtn.innerText = '刪除';
    delBtn.addEventListener('click',deleteItem);
    delTd.appendChild(delBtn);
    itemTr.appendChild(delTd);
}
function changItemCount() {
    let itemOldPrice = this.parentNode.nextSibling.firstChild.innerText;
    // console.log(itemOldPrice);
    let newNum = this.value;
    // console.log(newNum);
    let index = this.parentNode.previousSibling.previousSibling.previousSibling.firstChild.id;
    let itemPrice = parseInt(jsonData[index].price);
    // console.log(itemPrice);

    let subtotal = this.value * itemPrice;
    // console.log(subtotal);
    this.parentNode.nextSibling.firstChild.innerText = subtotal;
    total = total - itemOldPrice + subtotal;
    // console.log(total);
    document.getElementById('total').innerText = total;
}
function deleteItem(){
    let index = this.parentNode.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.firstChild.id;
    // console.log(index);
    let delCount =  this.parentNode.previousSibling.firstChild.innerText;
    // console.log(delCount);
    total -= delCount;
    document.getElementById('total').innerText = total;
    jsonData.splice(index, 1);
    // console.log(jsonData);
    storage.setItem('cart', JSON.stringify(jsonData));
    tbody.removeChild(this.parentNode.parentNode);
    location.reload();
  
}
window.addEventListener('load',doFirst);