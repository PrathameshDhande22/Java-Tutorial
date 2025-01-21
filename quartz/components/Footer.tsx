import { QuartzComponent, QuartzComponentConstructor, QuartzComponentProps } from "./types"
import style from "./styles/footer.scss"
import { version } from "../../package.json"
import { i18n } from "../i18n"

interface Options {
  links: Record<string, string>
}

export default ((opts?: Options) => {
  const Footer: QuartzComponent = ({ displayClass, cfg }: QuartzComponentProps) => {
    const links = opts?.links ?? []
    return (
      <footer class={`${displayClass ?? ""}`}>
        <p style={{ textAlign: "center" }}>Created with ❤️ by Prathamesh Dhande</p>
        <ul style="text-align:center;">
          {Object.entries(links).map(([text, link]) => (
            <li>
              <a href={link}>{text}</a>
            </li>
          ))}
        </ul>
        <div style="text-align: center; padding: 20px; font-family: Arial, sans-serif;">
          <p style="color: #007acc; font-size: 16px; margin: 5px;">
            Written on{" "}
            <a
              href="https://obsidian.md"
              target="_blank"
              style="color: #00bfff; text-decoration: none;"
            >
              Obsidian
            </a>
          </p>
          <p style="color: #ff9800; font-size: 16px; margin: 5px;">
            Powered by{" "}
            <a
              href="https://github.com/jackyzha0/quartz"
              target="_blank"
              style="color: #ffcc33; text-decoration: none;"
            >
              Quartz
            </a>
          </p>
          <p style="color: #4caf50; font-size: 16px; margin: 5px;">
            Hosted on{" "}
            <a
              href="https://pages.github.com/"
              target="_blank"
              style="color: #66bb6a; text-decoration: none;"
            >
              GitHub Pages
            </a>
          </p>
        </div>
      </footer>
    )
  }

  Footer.css = style
  return Footer
}) satisfies QuartzComponentConstructor
