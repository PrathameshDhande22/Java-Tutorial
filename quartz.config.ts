import { QuartzConfig } from "./quartz/cfg"
import * as Plugin from "./quartz/plugins"

/**
 * Quartz 4.0 Configuration
 *
 * See https://quartz.jzhao.xyz/configuration for more information.
 */
const config: QuartzConfig = {
  configuration: {
    pageTitle: "🛠️ Design Patterns",
    pageTitleSuffix: "",
    enableSPA: false,
    enablePopovers: false,
    analytics: {
      provider: "plausible",
    },
    locale: "en-US",
    baseUrl: "https://prathameshdhande22.github.io/Java-Tutorial/",
    ignorePatterns: ["private", "templates", ".obsidian"],
    defaultDateType: "created",
    generateSocialImages: true,
    theme: {
      fontOrigin: "googleFonts",
      cdnCaching: true,
      typography: {
        header: "Schibsted Grotesk",
        body: "Source Sans Pro",
        code: "IBM Plex Mono",
      },
      colors: {
        "lightMode": {
          "light": "#fcfcfc",
          "lightgray": "#eaeaea",
          "gray": "#b0b0b0",
          "darkgray": "#565656",
          "dark": "#232323",
          "secondary": "#2d5d7b",
          "tertiary": "#6ba396",
          "highlight": "rgba(143, 159, 169, 0.18)",
          "textHighlight": "#f5d76e88"
        },
        "darkMode": {
          "light": "#121214",
          "lightgray": "#2a2a2c",
          "gray": "#5a5a5c",
          "darkgray": "#e0e0e2",
          "dark": "#f8f8fa",
          "secondary": "#7ba6c2",
          "tertiary": "#7db9aa",
          "highlight": "rgba(143, 159, 169, 0.18)",
          "textHighlight": "#b3aa0299",
        }
      },
    },
  },
  plugins: {
    transformers: [
      Plugin.FrontMatter(),
      Plugin.CreatedModifiedDate({
        priority: ["frontmatter", "filesystem"],
      }),
      Plugin.SyntaxHighlighting({
        theme: {
          light: "github-light",
          dark: "github-dark",
        },
        keepBackground: false,
      }),
      Plugin.ObsidianFlavoredMarkdown({ enableInHtmlEmbed: false, mermaid: true }),
      Plugin.GitHubFlavoredMarkdown(),
      Plugin.TableOfContents({}),
      Plugin.CrawlLinks({ markdownLinkResolution: "shortest" }),
      Plugin.Description(),
      Plugin.Latex({ renderEngine: "katex" }),
    ],
    filters: [Plugin.RemoveDrafts()],
    emitters: [
      Plugin.AliasRedirects(),
      Plugin.ComponentResources(),
      Plugin.ContentPage(),
      Plugin.FolderPage(),
      Plugin.TagPage(),
      Plugin.ContentIndex({
        enableSiteMap: true,
        enableRSS: true,
      }),
      Plugin.Assets(),
      Plugin.Static(),
      Plugin.NotFoundPage(),
      Plugin.ExplorerWithTocPage(),
    ],
  },
}

export default config
