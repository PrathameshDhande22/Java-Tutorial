let drawer = document.getElementsByClassName("drawer")[0]

document.getElementsByClassName("menu-btn")[0].addEventListener("click", () => {
    drawer.classList.toggle("active")

    const isdrawerActive: boolean = drawer.classList.contains("active")
    assignActiveClassToDrawerButton(isdrawerActive)
})

function assignActiveClassToDrawerButton(isactive: boolean) {
    const hamburgersvg = document.querySelector(".hamburger")

    const cross = document.querySelector(".cross")

    if (isactive) {
        cross?.classList.add("active")
        hamburgersvg?.classList.remove("active")

    } else {
        cross?.classList.remove("active")
        hamburgersvg?.classList.add("active")

    }
}