const loginForm = document.getElementById("login-form");
const loginButton = document.getElementById("login-form-submit");
const loginErrorMsg = document.getElementById("login-error-msg");

loginButton.addEventListener("click", (e) => {
    e.preventDefault();
    const password = loginForm.password.value;

    if (password === "swaggyerror") {
        window.location.replace("https://komas19-new.github.io/BloodSMP/success.html");
    } else {
        loginErrorMsg.style.opacity = 1;
    }
})