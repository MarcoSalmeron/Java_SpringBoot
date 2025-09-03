document.addEventListener("click", (e) => {
  if (e.target.classList.contains("btn-eliminar")) {
    const deleteUrl = e.target.dataset.url;

    Swal.fire({
      title: "¿Eliminar Categoría?",
      html: `Estas acciones son <strong>PERMANENTES</strong> y no se pueden deshacer. <br>
      ¡¡ <u> Los productos relacionados <strong> también se eliminarán </strong> </u> !!`,
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Sí, eliminar",
      cancelButtonText: "No, cancelar"
    }).then((result) => {
      if (result.isConfirmed) {
        window.location.href = deleteUrl;
      }
    });
  }
});

function abrirSweetFiltro() {
  Swal.fire({
    title: '¿Cómo deseas filtrar?',
    html: `
      <div class="filters">
        <button class="filter-btn" data-filter="categoria">Categoría</button>
        <button class="filter-btn" data-filter="cantidad">Cantidad Productos</button>
      </div>
    `,
    showCancelButton: true,
    showConfirmButton: false,
    allowOutsideClick: false,
    didOpen: () => {
      const botones = Swal.getHtmlContainer().querySelectorAll('.filter-btn');
      botones.forEach(btn => {
        btn.addEventListener('click', () => {
          const tipo = btn.dataset.filter; // "Categoria" o "Cantidad"

          Swal.fire({
            title: `Filtrar por ${tipo}`,
            input: 'text',
            inputPlaceholder: `Ingresa ${tipo.toLowerCase()}`,
            showCancelButton: true,
            confirmButtonText: 'Aplicar',
            customClass: {
              input: 'swal2-input-custom',
              confirmButton: 'swal2-confirm-custom',
              cancelButton: 'swal2-cancel-custom'
            },
            allowOutsideClick: false
          }).then(resultado => {
            if (!resultado.isConfirmed) return;

            const valor = resultado.value?.trim();
            if (!valor) {
              return Swal.fire(
                'Necesitas un valor para filtrar',
                '',
                'error'
              );
            }

            // Decidir la URL según el filtro
            let url;
            if (tipo === 'categoria') {
              // Para cadenas, codifica espacios y caracteres especiales
              const cate = encodeURIComponent(valor);
              url = `/api/admin/categorias/filter/categoria/${cate}`;
            } else {
              // Para cantidad, valida que sea un número entero
              const num = parseInt(valor, 10);
              if (isNaN(num)) {
                return Swal.fire(
                  'Ingresa un número válido',
                  '',
                  'error'
                );
              }
              url = `/api/admin/categorias/filter/cantidad/${num}`;
            }

            // Redirigir al endpoint
            window.location.href = url;
          });
        });
      });
    }
  });
}

// Disparador del SweetAlert
document
  .getElementById('btn-filtrar')
  .addEventListener('click', abrirSweetFiltro);

function abrirSweetOrden() {
  Swal.fire({
    title: '¿Cómo deseas ordenar?',
    html: `
      <div class="order-filters">
        <button class="order-btn" data-order="categoría">Categoría</button>
        <button class="order-btn" data-order="cantidad">Cantidad de Productos</button>
      </div>
    `,
    showCancelButton: true,
    showConfirmButton: false,
    allowOutsideClick: false,
    didOpen: () => {
      const botones = Swal.getHtmlContainer().querySelectorAll('.order-btn');
      botones.forEach(btn => {
        btn.addEventListener('click', () => {
          // Recupera el criterio del data-attribute
          const criterioRaw = btn.dataset.order; // "Categoría" o "Productos"

          // Mapea al endpoint correspondiente
          let url;
          let etiqueta;
          if (criterioRaw === 'categoría') {
            url = '/api/admin/categorias/sort/categoria';
            etiqueta = 'Categoría';
          } else {
            url = '/api/admin/categorias/sort/cantidad';
            etiqueta = 'Cantidad de Productos';
          }

          // Alerta informativa con timer de 1.5s
          Swal.fire({
            icon: 'info',
            title: `Ordenando por ${etiqueta}`,
            timer: 1500,
            showConfirmButton: false,
            allowOutsideClick: false
          }).then(() => {
            // Una vez se cierra el Swal, redirige al endpoint
            window.location.href = url;
          });
        });
      });
    }
  });
}

// Conecta tu botón “Ordenar” con la función
document
  .getElementById('btn-ordenar')
  .addEventListener('click', abrirSweetOrden);

let btn_mostrar_productos = document.getElementById("btn-mostrar-productos");

btn_mostrar_productos.addEventListener("click", () => {
    window.location.href = `/api/admin/productos/all`;
});