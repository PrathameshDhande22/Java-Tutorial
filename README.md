# Design Patterns blog Obsidian Page.

This repository is cloned from the [Quartz repository](https://github.com/jackyzha0/quartz) and has been modified according to our needs.

## Running Locally

To run the website locally, use:

```bash
npm run dev
```

## Things To Keep in Mind While Writing the Blog

1. Always use the Obsidian format. If you have installed any plugins that support Obsidian, it may break.

> [!WARNING]
> Do not install any plugins in the Obsidian Vault.

2. When writing a code block, make sure to include the title and language in the following format:

```
csharp title="Welcome.cs"
```

3. Always include the following frontmatter at the top of every blog:

```yaml
---
title: title of the blog
tags:
  - tags
created: 2025-02-18 // creating date
---
```

4. If you paste any images into Obsidian, make sure to move the image into the `images` folder located in the `content` folder.