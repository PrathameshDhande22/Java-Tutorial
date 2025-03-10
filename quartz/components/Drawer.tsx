import { QuartzComponent, QuartzComponentConstructor, QuartzComponentProps } from "./types"
import style from "./styles/drawer.scss"
// @ts-ignore

interface Options {
  links?: Record<string, string>
}

export default ((opts?: Options) => {
  const Drawer: QuartzComponent = (props: QuartzComponentProps) => {
    const links = opts?.links ?? []
    return <div class="drawer">Drawer</div>
  }

  Drawer.css = style

  return Drawer
}) satisfies QuartzComponentConstructor
