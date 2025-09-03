document.addEventListener("click", (e) => {
  if (e.target.classList.contains("btn-eliminar")) {
    const deleteUrl = e.target.dataset.url;

    Swal.fire({
      title: "¿Eliminar Producto?",
      html: `Estas acciones son <strong>PERMANENTES</strong> y no se pueden deshacer.`,
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

// Función que lanza el SweetAlert de filtros
document
  .getElementById('btn-filtrar')
  .addEventListener('click', abrirSweetFiltro);

function abrirSweetFiltro() {
  Swal.fire({
    title: '¿Cómo deseas filtrar?',
    html: `
      <div class="filters">
        <button class="filter-btn" data-filter="categoria">Categoría</button>
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
            const tipo  = btn.dataset.filter;           // "categoria", "marca" o "precio"
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
              const url = `/api/admin/productos/filter/${tipo}/${encodeURIComponent(valor)}`;
              // Debug antes de redirigir:
              console.log('Redirigiendo a →', url);

              window.location.href = url;
            });
          });
        });
    }
  });
}


  document
    .getElementById('btn-ordenar')
    .addEventListener('click', abrirSweetOrden);

  function abrirSweetOrden() {
    Swal.fire({
      title: '¿Cómo deseas ordenar?',
      html: `
        <div class="filters">
          <button class="filter-btn" data-sort="categoria">Categoría</button>
          <button class="filter-btn" data-sort="marca">Marca</button>
          <button class="filter-btn" data-sort="precio">Precio</button>

        </div>
      `,
      showCancelButton: true,
      showConfirmButton: false,
      allowOutsideClick: false,
      didOpen: () => {
        const botones = Swal.getHtmlContainer().querySelectorAll('.filter-btn');
        botones.forEach(btn =>
          btn.addEventListener('click', () => {
            const tipo = btn.dataset.sort; // "marca" o "precio"
            // Redirige al endpoint correspondiente
            window.location.href = `/api/admin/productos/sort/${tipo}`;
          })
        );
      }
    });
  }

  let btn_categorias = document.getElementById("btn-mostrar-categorias");

  btn_categorias.addEventListener("click", () => {
    window.location.href = `/api/admin/categorias/all`;
  });
