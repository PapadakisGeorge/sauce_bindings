/**
 * Copyright (c) 2017-present, Facebook, Inc.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

// See https://docusaurus.io/docs/site-config for all the possible
// site configuration options.

// List of projects/orgs using your project for the users page.
const users = [
  {
    caption: "Sauce Labs",
    // You will need to prepend the image path with your baseUrl
    // if it is not "/", like: "/test-site/img/image.jpg".
    image: "/img/sauce-badge.png",
    infoLink: "https://saucelabs.com",
    pinned: true,
  },
];

const siteConfig = {
  title: "Sauce Bindings", // Title for your website.
  tagline: "Provide Convenient Way to Use Sauce Labs",
  url: "https://saucelabs.github.io/sauce_bindings", // Your website URL
  baseUrl: "/", // Base URL for your project */
  // For github.io type URLs, you would set the url and baseUrl like:
  //   url: "https://facebook.github.io",
  //   baseUrl: "/test-site/",

  // Used for publishing and more
  projectName: "sauce_bindings",
  organizationName: "Sauce Labs",
  // For top-level user or org sites, the organization is still the same.
  // e.g., for the https://JoelMarcey.github.io site, it would be set like...
  //   organizationName: "JoelMarcey"

  // For no header links in the top nav bar -> headerLinks: [],
  headerLinks: [
    { doc: "getting-started", label: "Docs" },
    { page: "help", label: "Help" },
    { href: "https://saucelabs.com/sign-up", label: "Try it free", external: true },
    { href: "https://app.saucelabs.com/login", label: "Sign in", external: true }
  ],

  // If you have users set above, you add it here:
  users,

  /* path to images for header/footer */
  headerIcon: "img/logo-saucelabs.png",
  footerIcon: "img/favicon.ico",
  favicon: "img/favicon.png",

  /* Colors for website */
  colors: {
    primaryColor: "#E12219",
    secondaryColor: "#4a282c",
    textColor: "#464b54"
  },

  /* Custom fonts for website */
  
  fonts: {
    saucelabsFont: [
      "museo-sans", 
      "HelveticaNeue",
      "Helvetica Neue",
      "Serif"
    ]
  },

  // This copyright info is used in /core/Footer.js and blog RSS/Atom feeds.
  copyright: `Copyright © 2020-${new Date().getFullYear()} Sauce Labs`,

  highlight: {
    // Highlight.js theme to use for syntax highlighting in code blocks.
    theme: "default",
  },

  // Add custom scripts here that would be placed in <script> tags.
  scripts: [
     "https://buttons.github.io/buttons.js"
  ],

  stylesheets: [
    "https://use.typekit.net/zmt8tam.css"
  ],

  // On page navigation for the current documentation page.
  onPageNav: "separate",
  // No .html extensions for paths.
  cleanUrl: true,

  // Open Graph and Twitter card images.
  ogImage: "img/undraw_online.svg",
  twitterImage: "img/undraw_tweetstorm.svg",

  // For sites with a sizable amount of content, set collapsible to true.
  // Expand/collapse the links and subcategories under categories.
  // docsSideNavCollapsible: true,

  // Show documentation's last contributor's name.
  // enableUpdateBy: true,

  // Show documentation's last update time.
  // enableUpdateTime: true,

  // You may provide arbitrary config keys to be used as needed by your
  // template. For example, if you need your repo's URL...
     repoUrl: "https://github.com/saucelabs/sauce_bindings",
};

module.exports = siteConfig;
