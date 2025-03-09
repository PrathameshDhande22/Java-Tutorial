import { QuartzComponent, QuartzComponentConstructor, QuartzComponentProps } from "./types"
import style from "./styles/navigationlinks.scss"

// @ts-ignore
import script from "./scripts/navigationlinks.inline"

interface Options {
  links: Record<string, string>
}

export default ((opts?: Options) => {
  const NavigationLinks: QuartzComponent = (props: QuartzComponentProps) => {
    const links = opts?.links ?? []
    return (
      <nav class="nav-links">
        <button className="menu-btn">Menu</button>
        <ul class="links">
          {Object.entries(links).map(([text, link]) => (
            <li>
              <a href={link}>{text}</a>
            </li>
          ))}
        </ul>
      </nav>
    )
  }

  NavigationLinks.css = style
  NavigationLinks.afterDOMLoaded = script

  return NavigationLinks
}) satisfies QuartzComponentConstructor
