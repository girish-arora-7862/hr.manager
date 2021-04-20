let form = document.getElementById("form");
let usernameInput = document.getElementById("username");
let usernameError = document.getElementById("usernameError");
let passwordInput = document.getElementById("password");
let passwordError = document.getElementById("passwordError");


form.addEventListener("submit", (event) => {
	if (!validateForm()) {
		event.preventDefault();
	}
})

usernameInput.addEventListener("blur", (event) => {
	validateUsername();
})

passwordInput.addEventListener("blur", (event) => {
	validatePassword();
})

function validateForm() {    
    let res = true;
    let condition1 = validateUsername();
    let condition2 = validatePassword();
    if(!(condition1 && condition2)){
        res = false;
    }
    return res;
}

function validateUsername(){
    let res = true;
	usernameError.style.display = "none";
	if(!usernameInput.value){
        usernameError.style.display = "inherit";
        usernameError.innerHTML = "Please provide username";
        res = false;
    } else if(usernameInput.value.length < 5){
        usernameError.style.display = "inherit";
        usernameError.innerHTML = "Minimum Length of username is 5";
        res = false;
    } else if(usernameInput.value.length > 50){
        usernameError.style.display = "inherit";
        usernameError.innerHTML = "Maximum Length of username is 50";
        res = false;
    }
    return res;
}

function validatePassword(){
    let res = true;
    passwordError.style.display = "none";
	if(!passwordInput.value){
        passwordError.style.display = "inherit";
        passwordError.innerHTML = "Please provide password";
        res = false;
    } else if(passwordInput.value.length < 5){
        passwordError.style.display = "inherit";
        passwordError.innerHTML = "Minimum Length of password is 5";
        res = false;
    } else if(passwordInput.value.length > 50){
        passwordError.style.display = "inherit";
        passwordError.innerHTML = "Maximum Length of password is 50";
        res = false;
    }
    return res;
}

