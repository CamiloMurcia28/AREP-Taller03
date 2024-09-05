function fetchSuggestedApps() {
    fetch('/show/list')
        .then(response => response.json()) 
        .then(data => {
            const appointments = data.appointments;
            const tableBody = document.querySelector('#appTable tbody');
            tableBody.innerHTML = '';
            
            appointments.forEach(medAppointment => {
                const row = document.createElement('tr');
                const nameCell = document.createElement('td');
                nameCell.textContent = medAppointment.name;
                row.appendChild(nameCell);
                const tipoCell = document.createElement('td');
                tipoCell.textContent = medAppointment.type;
                row.appendChild(tipoCell);
                tableBody.appendChild(row);
                
            });
        })
        .catch(error => {
            console.error('Error al cargar las citaaaaaaaaaaas:', error);
        });
}

window.onload = fetchSuggestedApps();