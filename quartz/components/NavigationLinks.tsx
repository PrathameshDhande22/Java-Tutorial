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
        <button className="menu-btn">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            viewBox="0 0 24 24"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
            class="hamburger active"
          >
            <line x1="4" x2="20" y1="12" y2="12" />
            <line x1="4" x2="20" y1="6" y2="6" />
            <line x1="4" x2="20" y1="18" y2="18" />
          </svg>
          <svg width="24" height="24" class="cross">
            <line x1="5" y1="5" x2="19" y2="19" stroke-width="2" />
            <line x1="19" y1="5" x2="5" y2="19" stroke-width="2" />
          </svg>
        </button>
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
