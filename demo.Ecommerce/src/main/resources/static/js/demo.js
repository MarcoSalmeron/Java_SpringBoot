// Pedir login al agregar productos a favoritos o carrito de compras
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
            <button id="btn-cerrar-alerta" style="
              background-color: #6c757d;
              color: white;
              padding: 8px 12px;
              border: none;
              border-radius: 5px;
              cursor: pointer;
            ">
              Cerrar
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
            window.location.href = "/api/demo/productos/login";
        }
        if (e.target.id === "btn-cerrar-alerta") {
            Swal.close();
        }
    });
}
let btn_agregar_favoritos = document.querySelectorAll(".btn-agregar-favoritos");

if (btn_agregar_favoritos.length > 0) {
    btn_agregar_favoritos.forEach(function(btn) {
        btn.addEventListener("click", pedirLogin);
    });
}

let btn_agregar_carrito = document.querySelectorAll(".modalProductoJSAgregarCarrito");

btn_agregar_carrito.forEach(function(btn) {
    btn.addEventListener("click", pedirLogin);
});


// Alerta con Filtro Sweet Alert
document
  .getElementById("btn-filtrar")
  .addEventListener("click", abrirSweetFiltro);

function abrirSweetFiltro() {
  Swal.fire({
    title: '¿Cómo deseas filtrar?',
    html: `
      <div class="filters">
        <button class="filter-btn" data-filter="marca">Marca</button>
        <button class="filter-btn" data-filter="precio">Precio</button>
      </div>
    `,
    showCancelButton: true,
    showConfirmButton: false,
    allowOutsideClick: false,
    didOpen: () => {
      Swal.getHtmlContainer()
        .querySelectorAll('.filter-btn')
        .forEach(btn => {
          btn.addEventListener('click', () => {
            const tipo  = btn.dataset.filter;           // "marca" o "precio"
            const label = btn.textContent.toLowerCase(); // sólo para placeholder

            Swal.fire({
              title: `Filtrar por ${btn.textContent}`,
              input: 'text',
              inputPlaceholder: `Ingresa ${label}`,
              showCancelButton: true,
              confirmButtonText: 'Aplicar',
              allowOutsideClick: false
            }).then(resultado => {
              if (!resultado.isConfirmed) return;

              const valor = resultado.value?.trim();
              if (!valor) {
                return Swal.fire(
                  'Debes ingresar un valor para filtrar',
                  '',
                  'error'
                );
              }

              // Construye la URL CORRECTA: /api/admin/productos/filter/{tipo}/{valor}
              const url = `/api/demo/productos/filter/${tipo}/${encodeURIComponent(valor)}`;
              // Debug antes de redirigir:
              console.log('Redirigiendo a →', url);

              window.location.href = url;
            });
          });
        });
    }
  });
}

// Alerta con Ordenamiento Sweet Alert
  document
    .getElementById('btn-ordenar')
    .addEventListener('click', abrirSweetOrden);

  function abrirSweetOrden() {
    Swal.fire({
      title: '¿Cómo deseas ordenar?',
      html: `
        <div class="order-filters">
          <button class="order-btn" data-sort="categoria">Categoría</button>
          <button class="order-btn" data-sort="marca">Marca</button>
          <button class="order-btn" data-sort="precio">Precio</button>
          <button class="order-btn" data-sort="descuento">Descuento</button>
        </div>
      `,
      showCancelButton: true,
      showConfirmButton: false,
      allowOutsideClick: false,
      didOpen: () => {
        const botones = Swal.getHtmlContainer().querySelectorAll('.order-btn');
        botones.forEach(btn =>
          btn.addEventListener('click', () => {
            const tipo = btn.dataset.sort; // "marca" o "precio"
            // Redirige al endpoint correspondiente
            window.location.href = `/api/demo/productos/sort/${tipo}`;
          })
        );
      }
    });
  }

// Barra de Busqueda
    document.getElementById("barra-busqueda").addEventListener("keypress", function(event) {
      if (event.key === "Enter") {
        event.preventDefault(); // Evita el comportamiento por defecto
        const nombre = this.value.trim(); // Obtiene el valor ingresado
        if (nombre !== "") {
          const url = `/api/demo/productos/findBy/nombre/${encodeURIComponent(nombre)}`;
          window.location.href = url; // Redirige a la URL
        }
      }
    });
