import { concatenateResources } from "../util/resources"
import { QuartzComponent, QuartzComponentConstructor, QuartzComponentProps } from "./types"
import style from "./styles/navbarwrapper.scss"
interface Options {
  components: QuartzComponent[]
}

export default ((opts: Options) => {
  const NavbarWrapper: QuartzComponent = (props: QuartzComponentProps) => {
    return (
      <div class="navbar-wrapper">
        {opts?.components.map((Component) => {
          return <Component {...props}></Component>
        })}
      </div>
    )
  }
  NavbarWrapper.afterDOMLoaded = concatenateResources(
    ...opts.components.map((c) => c.afterDOMLoaded),
  )
  NavbarWrapper.beforeDOMLoaded = concatenateResources(
    ...opts.components.map((c) => c.beforeDOMLoaded),
  )
  NavbarWrapper.css = concatenateResources(...opts.components.map((c) => c.css), style)
  return NavbarWrapper
}) satisfies QuartzComponentConstructor<Options>
