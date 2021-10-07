/* <div class = "peko">123</div>
$('.peko').text()
    =   123

<div name = "peko" class ="neol">321</name>
$('#peko') == $('.neol');
$('.neol').text()
    =   321
<div>111<h1>222</h1></div>
$('div').text()
    =   111
$('div h1').text()
    =   222 */


/* <div class = "peko">
    <img src="../peko/hahaha/pekopeko.png" alt="meowmeow">
</div>
$('.peko img').attr('src')
    =   "../peko/hahaha/pekopeko.png"

$('.peko img').attr('src','../neol/noooooooo/neolneol.jpg')
=>
<div class = "peko">
    <img src="../neol/noooooooo/neolneol.jpg" alt="meowmeow">
</div>
} */


const imgsrc = $('.product-img img').attr('src');
const product_name = $('.product-name h3').html();
const product_price = $('.product-price').html();
const sent = $('.cart-add');
let product_amount = $('.product-dropdown button').html();

// amount
{
$('.product-dropdown .dropdown-item1').click(()=>{
    // button 換字
    $('.product-dropdown button').html("1");
    // button 換字
    product_amount = 1;
});
$('.product-dropdown .dropdown-item2').click(()=>{
    $('.product-dropdown button').html("2");
    product_amount = 2;
});
$('.product-dropdown .dropdown-item3').click(()=>{
    $('.product-dropdown button').html("3");
    product_amount = 3;
});
$('.product-dropdown .dropdown-item4').click(()=>{
    $('.product-dropdown button').html("4");
    product_amount = 4;
});
}
// amount

 let cart = [];
//cart-add
sent.click( () => {
   
    cart.push({
        type: "product",
        image   :   imgsrc,
        item    :   product_name,
        price   :   product_price,
        amount  :   product_amount,
        timeframe : "",
        date:"",
    });
    console.log(JSON.stringify(cart));
    localStorage.setItem('cart',JSON.stringify(cart));
    alert("送出購物車\n內容為:\n"+ localStorage.getItem('cart'));
});
//cart-add
