import { assignActiveClassToDrawerButton } from "./util"

let drawer = document.getElementsByClassName("drawer")[0]

document.getElementsByClassName("menu-btn")[0].addEventListener("click", () => {
    drawer.classList.add("active")

    const isdrawerActive: boolean = drawer.classList.contains("active")
    assignActiveClassToDrawerButton(isdrawerActive)
})

