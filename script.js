console.log(angkaToRp(2000))
console.log(angkaToRp(90))

function angkaToRp(angka) {
    var rupiah = '';
    var angkarev = angka.toFixed(2).toString();
    console.log(angkarev);
    return 'INR '+angkarev;
}

// function angkaToRp(angka) {
//     var rupiah = '';    
//     var angkarev = angka.toString().split('').reverse().join('');
//     for(var i = 0; i < angkarev.length; i++) if(i%3 == 0) rupiah += angkarev.substr(i,3)+'.';
//               return 'INR '+rupiah.split('',rupiah.length-1).reverse().join('');
//     };