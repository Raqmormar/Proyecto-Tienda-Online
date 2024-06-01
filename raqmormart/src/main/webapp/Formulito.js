document.addEventListener('DOMContentLoaded', function() {
	let boton_enviar = document.getElementById("boton_enviar")
    boton_enviar.addEventListener('click', function (){
        crear_cliente("GestionClientes");
    })

    function crear_cliente(url) {
        let data_send = new FormData(Formulario);

        fetch(url, {method: 'POST', body: data_send})
            .then(response => {
                if (response.ok) {
                    window.history.back();
                } else {
                    throw new Error('Error al crear usuario');
                }
            })

            .catch(error => {
                console.log(error.message);
            });
        }
        });