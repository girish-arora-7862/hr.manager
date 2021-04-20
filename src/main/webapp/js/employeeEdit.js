let form = document.getElementById("form");
let nameInput = document.getElementById("name");
let nameError = document.getElementById("nameError");
let locationInput = document.getElementById("location");
let locationError = document.getElementById("locationError");
let emailInput = document.getElementById("email");
let emailError = document.getElementById("emailError");
let dateInput = document.getElementById("date");
let dateError = document.getElementById("dateError");


form.addEventListener("submit", (event) => {
	if (!validateForm()) {
		event.preventDefault();
	}
})

nameInput.addEventListener("blur", (event) => {
    validateName();
})

locationInput.addEventListener("blur", (event) => {
    validateLocation();
})

emailInput.addEventListener("blur", (event) => {
    validateEmail();
})

dateInput.addEventListener("blur", (event) => {
    validateDate();
})

function validateForm() {    
    let res = true;
    let condition1 = validateUsername();
    let condition2 = validateLocation();
    let condition3 = validateEmail();
    let condition4 = validateDate();
    if(!(condition1 && condition2 && condition3 && condition4)){
        res = false;
    }
    return res;
}

function validateName(){
    let res = true;
	nameError.style.display = "none";
	if(!nameInput.value){
        nameError.style.display = "inherit";
        nameError.innerHTML = "Please provide name";
        res = false;
    } else if(nameInput.value.length > 100){
        nameError.style.display = "inherit";
        nameError.innerHTML = "Maximum Length of name is 100";
        res = false;
    }
    return res;
}

function validateLocation(){
    let res = true;
    locationError.style.display = "none";
	if(!locationInput.value){
        locationError.style.display = "inherit";
        locationError.innerHTML = "Please provide location";
        res = false;
    } else if(locationInput.value.length > 500){
        locationError.style.display = "inherit";
        locationError.innerHTML = "Maximum Length of location is 500";
        res = false;
    }
    return res;
}


function validateEmail(){
    let res = true;
    emailError.style.display = "none";
	if(!emailInput.value){
        emailError.style.display = "inherit";
        emailError.innerHTML = "Please provide email";
        res = false;
    } else if(emailInput.value.length > 100){
        emailError.style.display = "inherit";
        emailError.innerHTML = "Maximum Length of email is 100";
        res = false;
    } else if(!isValidEmail(emailInput.value)){
        emailError.style.display = "inherit";
        emailError.innerHTML = "Invalid Email";
        res = false;
    }
    return res;
}

function validateDate(){
    let res = true;
    dateError.style.display = "none";
	if(!dateInput.value){
        dateError.style.display = "inherit";
        dateError.innerHTML = "Please provide date";
        res = false;
    } 
    return res;
}


function isValidEmail(email) {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

