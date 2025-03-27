import { classNames } from "../../util/lang"
import { QuartzComponent, QuartzComponentConstructor, QuartzComponentProps } from "../types"
import styles from "../styles/blogs.scss"
// @ts-ignore
import script from "../scripts/blogpatterns.inline"

export default (() => {
  const Blogs: QuartzComponent = (props: QuartzComponentProps) => {
    /**
     * Sorts all files in descending order based on their creation date.
     *
     * @param props - The component props containing the allFiles array.
     * @returns An array of sorted files with the most recently created files first.
     */
    const allFiles = props.allFiles.sort((a, b) => {
      return b.dates?.created.valueOf()! - a.dates?.created.valueOf()!
    })
    return (
      <div class="toc-elements">
        {allFiles.map((data, index) => {
          return (
            <div class={classNames(props.displayClass, "toc")}>
              <button
                type="button"
                id="toc"
                class={classNames(
                  props.displayClass,
                  !data.collapseToc ? "collapsed" : "",
                  "toc-button",
                )}
                aria-controls="toc-content"
                aria-expanded={!data.collapseToc}
              >
                <h3>{data.frontmatter?.title}</h3>
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
              <div id="toc-content" class={!props.fileData.collapseToc ? "collapsed" : ""}>
                <ul class="overflow">
                  {/* TODO: Handling of Folder based Pattern Files is Remaining for Rendering the Links. */}
                  {data.toc?.map((tocEntry) => (
                    <li key={tocEntry.slug} class={`depth-${tocEntry.depth}`}>
                      <a href={`./${data.slug}#${tocEntry.slug}`} data-for={tocEntry.slug}>
                        {tocEntry.text}
                      </a>
                    </li>
                  ))}
                </ul>
              </div>
            </div>
          )
        })}
      </div>
    )
  }

  Blogs.css = styles
  Blogs.afterDOMLoaded = script
  return Blogs
}) satisfies QuartzComponentConstructor
