import { QuartzComponent, QuartzComponentConstructor, QuartzComponentProps } from "./types"
import style from "./styles/drawer.scss"
// @ts-ignore

interface Options {
  links?: Record<string, string>
}

export default ((opts?: Options) => {
  const Drawer: QuartzComponent = (props: QuartzComponentProps) => {
    const links = opts?.links ?? []
    return (
      <div class="drawer">
        <div class="drawer-wrapper">
          <ul class="links">
            {Object.entries(links).map(([text, link]) => (
              <li>
                <a href={link}>{text}</a>
              </li>
            ))}
          </ul>
        </div>
      </div>
    )
  }

  Drawer.css = style

  return Drawer
}) satisfies QuartzComponentConstructor
