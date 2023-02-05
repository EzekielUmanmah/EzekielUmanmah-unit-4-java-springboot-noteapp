const registerForm = document.getElementById('register-form');
const username = document.getElementById('register-username');
const password = document.getElementById('register-password');

const headers = {
  'Content-Type': 'application/json'
};

const baseURL = 'http://localhost:4000/api/v1/users';

const handleSubmit = async (e) => {
  e.preventDefault();

  const userData = {
    username: username.value,
    password: password.value,
  };

  const res = await fetch(`${baseURL}/register`, {
    method: "POST",
    body: JSON.stringify(userData),
    headers: headers
  }).catch((err) => console.log('Registration error: ', err.message));

  const resArr = await res.json();

  if (res.status === 200) {
    window.location.replace(resArr[0]);
  }
};

registerForm.addEventListener('submit', handleSubmit);
