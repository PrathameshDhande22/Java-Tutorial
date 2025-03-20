import { QuartzComponent, QuartzComponentConstructor, QuartzComponentProps } from "./types"
import style from "./styles/drawer.scss"
// @ts-ignore
import script from "./scripts/drawer.inline"
import TableOfContents from "./TableOfContents"
import { classNames } from "../util/lang"
import { FileNode } from "./ExplorerNode"
import { resolveRelative } from "../util/path"

interface Options {
  links?: Record<string, string>
}

export default ((opts?: Options) => {
  const Drawer: QuartzComponent = ({ displayClass, fileData, allFiles }: QuartzComponentProps) => {
    const links = opts?.links ?? []
    const fileTree = new FileNode("")
    allFiles.forEach((file) => fileTree.add(file))

    return (
      <div class="drawer">
        <div class="drawer-wrapper">
          <h3 class="drawer-title">MENU</h3>
          <ul class="links">
            {Object.entries(links).map(([text, link]) => (
              <li>
                <a href={link}>{text}</a>
              </li>
            ))}
          </ul>
          <div class={classNames(displayClass, "toc")}>
            <button
              type="button"
              id="toc"
              class={fileData.collapseToc ? "collapsed" : ""}
              aria-controls="toc-content"
              aria-expanded={!fileData.collapseToc}
            >
              <h3>Patterns</h3>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
                class="fold"
              >
                <polyline points="6 9 12 15 18 9"></polyline>
              </svg>
            </button>
            <div id="toc-content" class={fileData.collapseToc ? "collapsed" : ""}>
              <ul class="overflow">
                {allFiles.map((value) => {
                  return (
                    <li key={value.slug}>
                      <a href={resolveRelative(value.slug!, value.slug!)} data-for={value.slug}>{value.frontmatter?.title}</a>
                    </li>
                  )
                })}
              </ul>
            </div>
          </div>
        </div>
      </div>
    )
  }

  Drawer.css = style
  Drawer.afterDOMLoaded = script

  return Drawer
}) satisfies QuartzComponentConstructor
