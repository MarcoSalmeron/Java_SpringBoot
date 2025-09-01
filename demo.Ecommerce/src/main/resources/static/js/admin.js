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