const tocbutton = document.querySelectorAll(".toc-button")

function closeAllToc(exclude: Element) {
    tocbutton.forEach((value) => {
        if (value !== exclude && !value.classList.contains("collapsed")) {
            toggleToc(value)
        }
    })
}

function toggleToc(value: Element) {
    console.log("triggerd")
    value.classList.toggle("collapsed")
    value.nextElementSibling?.classList.toggle("collapsed")
}

tocbutton.forEach((value) => {
    value.addEventListener("click", () => {
        closeAllToc(value)

        toggleToc(value)
    })
})
