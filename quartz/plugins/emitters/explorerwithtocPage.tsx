import { QuartzEmitterPlugin } from "../types"
import { QuartzComponentProps } from "../../components/types"
import HeaderConstructor from "../../components/Header"
import BodyConstructor from "../../components/Body"
import { pageResources, renderPage } from "../../components/renderPage"
import { QuartzPluginData, defaultProcessedContent } from "../vfile"
import { FullPageLayout } from "../../cfg"
import { FilePath, FullSlug, joinSegments, pathToRoot } from "../../util/path"
import { defaultContentPageLayout, sharedPageComponents } from "../../../quartz.layout"
import { write } from "./helpers"
import DepGraph from "../../depgraph"
import Blogs from "../../components/pages/Blogs"

export const ExplorerWithTocPage: QuartzEmitterPlugin = (userOpts) => {
  const opts: FullPageLayout = {
    ...sharedPageComponents,
    ...defaultContentPageLayout,
    pageBody: Blogs(),
  }

  const {
    head: Head,
    header,
    navbar,
    beforeBody,
    pageBody,
    afterBody,
    left,
    right,
    footer: Footer,
  } = opts
  const Header = HeaderConstructor()
  const Body = BodyConstructor()

  return {
    name: "DesignPatterns",
    getQuartzComponents() {
      return [
        Head,
        Header,
        ...navbar,
        Body,
        ...header,
        ...beforeBody,
        pageBody,
        ...afterBody,
        ...left,
        ...right,
        Footer,
      ]
    },
    async getDependencyGraph(_ctx, _content, _resources) {
      return new DepGraph<FilePath>()
    },
    async emit(ctx, _content, resources): Promise<FilePath[]> {
      const cfg = ctx.cfg.configuration
      const allFiles = _content.map((c) => c[1].data)
      const slug = joinSegments("blogs", "index") as FullSlug
      const title = "Pattern Blogs"
      const [tree, vfile] = defaultProcessedContent({
        slug,
        text: title,
        frontmatter: { title: title, tags: [] },
      })
      const externalResources = pageResources(pathToRoot(slug), vfile.data, resources)
      const componentData: QuartzComponentProps = {
        ctx,
        fileData: vfile.data,
        externalResources,
        cfg,
        children: [],
        tree,
        allFiles: allFiles,
      }

      return [
        await write({
          ctx,
          content: renderPage(cfg, slug, componentData, opts, externalResources),
          slug,
          ext: ".html",
        }),
      ]
    },
  }
}
