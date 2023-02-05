const loginForm = document.getElementById('login-form');
const username = document.getElementById('login-username');
const password = document.getElementById('login-password');

const headers = {
  'Content-Type': 'application/json',
};

const baseURL = 'http://localhost:4000/api/v1/users';

const handleSubmit = async (e) => {
  e.preventDefault();

  const userData = {
    username: username.value,
    password: password.value,
  };

  const res = await fetch(`${baseURL}/login`, {
    method: 'POST',
    body: JSON.stringify(userData),
    headers: headers,
  }).catch((err) => console.log('Login error: ', err.message));

  const resArr = await res.json();

  if (res.status === 200) {
    document.cookie = `userId=${resArr[1]}`;
    window.location.replace(resArr[0]);
  }
};

loginForm.addEventListener('submit', handleSubmit);
