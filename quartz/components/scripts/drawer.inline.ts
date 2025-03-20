import { assignActiveClassToDrawerButton } from "./util"

const drawerele = document.querySelector(".drawer")
drawerele?.addEventListener("click", () => {
    drawerele.classList.remove("active")

    const isdrawerActive: boolean = drawerele.classList.contains("active")
    assignActiveClassToDrawerButton(isdrawerActive)
})

const toccontentele = document.querySelector(".toc")
toccontentele?.addEventListener("click", (e) => {
    e.stopPropagation();
})