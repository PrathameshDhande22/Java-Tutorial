let links = document.getElementsByClassName("links")[0]

document.getElementsByClassName("menu-btn")[0].addEventListener("click", () => {
    links.classList.toggle("active")
})