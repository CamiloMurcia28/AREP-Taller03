document.getElementById('citaForm').addEventListener('submit', loadPostMsg);

function loadPostMsg(event) {
    event.preventDefault();

    const doctor = document.getElementById('doctor').value;
    const fecha = document.getElementById('fecha').value;
    const tipo = document.getElementById('tipo').value
    let url = `/app/addMedAppointment?docName=${encodeURIComponent(doctor)}&schDate=${encodeURIComponent(fecha)}&type=${encodeURIComponent(tipo)}`;

    fetch(url , { method: 'POST' })
        .then(response => {
             if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            document.getElementById('message').innerText = `Cita con Dr(a).: ${data.docname} añadido correctamente`;
            fetchAppointments();
        })
        .catch(error => {
            console.error("Error al añadir cita:", error);
            document.getElementById('message').innerText = 'Error al añadir cita' + error;
        }); 
}


function fetchAppointments() {
    fetch('/app/medAppointment')
        .then(response => {
            return response.json();
        }) 
        .then(data => {
            console.log("Data received:", data);
            let appointmentItems = document.getElementById('appointmentItems');
            appointmentItems.innerHTML = '';
            data.appointments.forEach(medAppointment => {
                console.log("Si x3");
                let li = document.createElement('li');
                li.textContent = `Cita: ${medAppointment.docname}, Tipo de cita: ${medAppointment.type}`;
                appointmentItems.appendChild(li);
            });
        })
        .catch(error => {
            console.error('Error al cargar las citaaaaaaaaaaas:', error);
            document.getElementById('message').innerText = 'Error al cargar las citaas.' + error;
        });
}

window.onload = fetchAppointments();