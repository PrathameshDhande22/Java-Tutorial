import { PageLayout, SharedLayout } from "./quartz/cfg"
import * as Component from "./quartz/components"

// components shared across all pages
export const sharedPageComponents: SharedLayout = {
  navbar: [
    Component.PageTitle(),
    Component.NavbarWrapper({
      components: [
        Component.MobileOnly(Component.Spacer()),
        Component.NavigationLinks({
          links: {
            Blogs: "./blogs",
            Github: "https://github.com/PrathameshDhande22/Java-Tutorial",
            "About Me": "https://github.com/PrathameshDhande22"
          }
        }),
        Component.Search(),
        Component.Darkmode()
      ]
    })
  ],
  head: Component.Head(),
  header: [Component.MobileOnly(
    Component.Drawer({
      links: {
        Blogs: "./blogs",
        Github: "https://github.com/PrathameshDhande22/Java-Tutorial",
        "About Me": "https://github.com/PrathameshDhande22"
      }
    })
  )],
  afterBody: [],
  footer: Component.Footer({
    links: {
      GitHub: "https://prathameshdhande22.github.io/Java-Tutorial/",
      LinkedIn: "https://www.linkedin.com/in/prathamesh-dhande-3a039721a/"
    },
  }),
}

// components for pages that display a single page (e.g. a single note)
export const defaultContentPageLayout: PageLayout = {
  beforeBody: [
    Component.Breadcrumbs(),
    Component.ArticleTitle(),
    Component.ContentMeta(),
    Component.TagList(),
  ],
  left: [
    Component.DesktopOnly(
      Component.Explorer({
        title: "Patterns",
        folderDefaultState: "open",
        sortFn: (a, b) => {
          return b.file?.dates?.created.valueOf()! - a.file?.dates?.created.valueOf()!
        }
      })
    )
  ],
  right: [
    Component.TableOfContents(),
    Component.Backlinks(),
    Component.DesktopOnly(Component.RecentNotes({
      limit: 2,
      title: "Recent Blogs"
    }))
  ]
}

// components for pages that display lists of pages  (e.g. tags or folders)
export const defaultListPageLayout: PageLayout = {
  beforeBody: [Component.Breadcrumbs(), Component.ArticleTitle(), Component.ContentMeta()],
  left: [
  ],
  right: [],
}
