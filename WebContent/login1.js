function show$hide() {
    let toggle = document.getElementsByClassName("toggle")[0];
    let password = document.querySelector("#password");
  
    console.log(toggle);
  
    if (password.getAttribute("type") == "password") {
      password.setAttribute("type", "text");
    } else {
      password.setAttribute("type", "password")
    }
  } 
  