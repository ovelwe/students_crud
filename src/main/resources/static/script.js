const apiUrl = 'http://localhost:8080/api/v1/students';

async function loadStudents() {
    const response = await fetch(apiUrl);
    const students = await response.json();

    const studentsList = document.getElementById('students-list');
    studentsList.innerHTML = '';

    students.forEach(student => {
        const li = document.createElement('li');
        li.innerHTML = `
            <span>${student.firstName}</span>
            <span>${student.lastName} </span>
            <span>email: ${student.email} </span>
            <span>возраст: ${student.age}</span>
            <div>
            <button onclick="editStudent('${student.email}')">редактировать</button>
            <button onclick="deleteStudent('${student.email}')">удалить</button>
            </div>
        `;
        studentsList.appendChild(li);
    });
}

async function addStudent() {
    const firstName = prompt('Введите имя студента:');
    const lastName = prompt('Введите фамилию студента:');
    const email = prompt('Введите email студента:');
    const birthDate = prompt('Введите дату рождения студента (формат: yyyy-mm-dd):');

    if (!firstName || !lastName || !email || !birthDate) return;

    await fetch(`${apiUrl}/create_student`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ firstName, lastName, email, birthDate })
    });

    loadStudents();
}

async function editStudent(id) {
    const response = await fetch(`${apiUrl}/${id}`);
    const student = await response.json();

    const firstName = prompt('Введите новое имя студента:', student.firstName);
    const lastName = prompt('Введите новую фамилию студента:', student.lastName);
    const email = prompt('Введите новый email студента:', student.email);
    const birthDate = prompt('Введите новую дату рождения студента (формат: yyyy-MM-dd):', student.birthDate);

    if (!firstName || !lastName || !email || !birthDate || !age) return;

    const updatedStudent = {
        id: student.id,
        firstName,
        lastName,
        email,
        birthDate,
        age
    };

    const updateResponse = await fetch(`${apiUrl}/update_student`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(updatedStudent)
    });

    if (updateResponse.ok) {
        loadStudents();
    } else {
        alert('Ошибка при обновлении студента');
    }
}


async function deleteStudent(email) {
    if (!confirm('Вы уверены, что хотите удалить студента?')) return;

    await fetch(`${apiUrl}/delete_student/${email}`, { method: 'DELETE' });

    loadStudents();
}

loadStudents();