let btn_opciones = document.getElementById("btn-opciones");
btn_opciones.addEventListener("click", () => {
    Swal.fire({
        title: 'Filtrar por',
        icon: 'info',
        html: `
    <div style="display: flex; flex-direction: column; align-items: center; gap: 10px; margin-top: 10px;">
      <a href="./filtrar-categoria.html" style="
        background-color: #17a2b8;
        color: white;
        padding: 8px 16px;
        border-radius: 5px;
        text-decoration: none;
        width: 150px;
        text-align: center;
      ">Categoría</a>
      <a href="./filtrar-marca.html" style="
        background-color: #28a745;
        color: white;
        padding: 8px 16px;
        border-radius: 5px;
        text-decoration: none;
        width: 150px;
        text-align: center;
      ">Marca</a>
      <a href="./filtrar-precio.html" style="
        background-color: #ffc107;
        color: black;
        padding: 8px 16px;
        border-radius: 5px;
        text-decoration: none;
        width: 150px;
        text-align: center;
      ">Precio</a>
    </div>
  `,
        showClass: {
            popup: `
      animate__animated
      animate__backInDown
      animate__faster
    `
        },
        hideClass: {
            popup: `
      animate__animated
      animate__fadeOutDown
      animate__faster
    `
        },
        showConfirmButton: false
    });
});

function pedirLogin() {
    Swal.fire({
        icon: "warning",
        title: "¡Atención!",
        html: `
          <p>Necesitas iniciar sesión para agregar productos al Carrito / Favoritos.</p>
          <div style="margin-top: 15px;">
            <button id="btn-registrarse" style="
              background-color: #28a745;
              color: white;
              padding: 8px 12px;
              border: none;
              border-radius: 5px;
              margin-right: 10px;
              cursor: pointer;
            ">
              Registrarse
            </button>
            <button id="btn-login" style="
              background-color: #007bff;
              color: white;
              padding: 8px 12px;
              border: none;
              border-radius: 5px;
              cursor: pointer;
            ">
              Ya tengo cuenta
            </button>
          </div>
        `,
        showClass: {
            popup: `
              animate__animated
              animate__backInDown
              animate__faster
            `
        },
        hideClass: {
            popup: `
              animate__animated
              animate__fadeOutDown
              animate__faster
            `
        },
        showConfirmButton: false
    });

    // Redirección al hacer clic en los botones
    document.addEventListener("click", function (e) {
        if (e.target.id === "btn-registrarse") {
            window.location.href = "./login.html";
        }
        if (e.target.id === "btn-login") {
            window.location.href = "./carrito.html";
        }
    });
}
let btn_agregar_favoritos = document.getElementById("btn-agregar-favoritos");
let btn_agregar_carrito = document.getElementById("modal-btn-carrito");
btn_agregar_favoritos.addEventListener("click", pedirLogin);
btn_agregar_carrito.addEventListener("click", pedirLogin);