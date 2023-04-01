const loginForm = document.getElementById("login-form");
const loginButton = document.getElementById("login-form-submit");
const loginErrorMsg = document.getElementById("login-error-msg");

loginButton.addEventListener("click", (e) => {
    e.preventDefault();
    const password = loginForm.password.value;

    if (password === "DKAP_APDN_AOCP_APWX_1KLN") {
        window.location.replace("https://komas19-new.github.io/BloodSMP/");
    } else {
        loginErrorMsg.style.opacity = 1;
    }
})