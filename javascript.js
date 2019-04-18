function changeColor(x) {
	elements = document.getElementsByClassName(x);
	var all = document.getElementsByTagName("*");
	for (var i = 0; i < all.length; i++) {
		for (var j = 0; j < elements.length; j++) {
			if (all[i].className != elements[j].className) {
				all[i].style.color = "black";
			}
			if (all[i].className == elements[j].className) {
				all[i].style.color = "red";
			}
		}
	}
}
