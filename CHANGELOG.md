# Changelog

## [09-03-2025]
### File: `quartz.config.ts` (Experimental)
- `generateSocialImages` property in `config` set to `true` to check if it can generate the Cover Image for the pattern blogs. 

### File: `quartz.layout.ts`
- New Layout `navbar` added to show the sticky navbar on the top and moved `PageTile`, `DarkMode` components from `afterBody` components to it. 
- In `navbar` layout `NavigationLinks` component added contains some links to show in the navbar. 

### File: `quartz/cfg.ts`
- New Layout `navbar` reference in typescript added with type annotation as `QuartzComponent[]`.

### File: `quartz/components/index.ts`
- `NavigationLinks` component reference added.

### File: `quartz/components/NavigationLinks.ts` (NEW)
- New Component `NavigationLinks` it contains the navigation links and responsive. 

### File: `quartz/components/renderPage.tsx`
- `navbar` layout support added.
- `NavbarComponent` added where components from `navbar` are rendered in these Component. 

### File: `quartz/components/pages/Blogs.tsx` (NEW)
- New Page for showing all the Pattern blog just similar to Explorer view in **quartz**. 

### File: `quart/components/scripts/navigationlinks.inline.ts` (NEW)
- Script file associated with `NavigationLinks` components. Menu button logic Contains. 

### File: `quartz/components/styles/footer.css`
- Footer Links centered with css property. 

### File: `quartz/components/styles/navbar.scss` (NEW)
- Navbar related Styles which are begin used in the navigation for the `NavbarComponent` present in `renderPage.tsx`. 

### File: `quartz/components/styles/navigationlinks.scss` (NEW)
- `NavigationLinks` Component Stylesheet. 

### File: `quartz/plugins/emitters/contentPage.tsx`
- `navbar` support added to be rendered in the content page. 

### File: `quartz/styles/custom.scss`
- Custom CSS added and `navbar` related styles are imported. 