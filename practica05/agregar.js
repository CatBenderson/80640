function leer() {
    return document.getElementById("todo").value
}

function agregar() {     
    if (buscar()==0){
    nodo = document.createElement("li")
    texto=document.createTextNode(leer())
    nodo.appendChild(texto)
    document.getElementById("lista").appendChild(nodo)
    }
}

function buscar() {
    var a =0;
    let listaTodo= document.getElementsByTagName("li")
    for (let index = 0; index < listaTodo.length; index++) {
        if(leer()==listaTodo[index].textContent){
            console.log(leer()+ " ya existe")
            a=1;
        }
    }
    if (a==0){
        console.log(leer()+ " no está en la lista")
    }  
    return a
} 