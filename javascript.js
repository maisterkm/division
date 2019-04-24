function mouseOver(x) {
	  elements = document.getElementsByClassName(x);
	  for(var i=0; i < elements.length; i++){
		elements[i].style.color = "red";
	  }
	}

function mouseOut(x) {
	for(var i=0; i < elements.length; i++){
		elements[i].style.color = "black";
	  }
	}
