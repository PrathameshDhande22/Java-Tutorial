let drawer = document.getElementsByClassName("drawer")[0]

document.getElementsByClassName("menu-btn")[0].addEventListener("click", () => {
    drawer.classList.toggle("active")
})