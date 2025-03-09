import { QuartzComponent, QuartzComponentConstructor, QuartzComponentProps } from "../types"
import style from "./styles/navigationheader.scss"

interface Options {
  links: Record<string, string>
  components: QuartzComponent[]
}

export default ((opts?: Options) => {
  const Blogs: QuartzComponent = (props: QuartzComponentProps) => {
    return <div>Blogs Page</div>
  }

  return Blogs
}) satisfies QuartzComponentConstructor
