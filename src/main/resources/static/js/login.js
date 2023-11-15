document.addEventListener('DOMContentLoaded', (event) => {
	const signUpButton = document.getElementById('signUp');
	const signInButton = document.getElementById('signIn');
	const container = document.getElementById('container');
  
	if (signUpButton && signInButton && container) {
	  signUpButton.addEventListener('click', () => {
		container.classList.add("right-panel-active");
	  });
  
	  signInButton.addEventListener('click', () => {
		container.classList.remove("right-panel-active");
	  });
	} else {
	  console.error('Alguno de los elementos no se encontró');
	}
  });
  