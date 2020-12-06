function registerUser() {
    var password        = document.getElementById("customerPassword").value;
    var passwordConfirm = document.getElementById("customerPasswordConfirm").value;

    if (password !== passwordConfirm) {
        alert("Passwords must match!");
        return false;
    }
    return true;
}