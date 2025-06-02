
export default {
  bootstrap: () => import('./main.server.mjs').then(m => m.default),
  inlineCriticalCss: true,
  baseHref: '/',
  locale: undefined,
  routes: [
  {
    "renderMode": 2,
    "route": "/"
  }
],
  entryPointToBrowserMapping: undefined,
  assets: {
    'index.csr.html': {size: 730, hash: 'f1f252cb6569ca977d9a71b035d840cee6093a5ed1aff258977b4f812d6306b8', text: () => import('./assets-chunks/index_csr_html.mjs').then(m => m.default)},
    'index.server.html': {size: 1016, hash: 'f284e7eb67bb7af04438e5516e8c503972e091057cc94fe3acd354cbbec5b877', text: () => import('./assets-chunks/index_server_html.mjs').then(m => m.default)},
    'index.html': {size: 1650, hash: '8f6ff5cf54b45c39d6e4152c1bca1ed4800214d9681aa9368d1f3859457c16f4', text: () => import('./assets-chunks/index_html.mjs').then(m => m.default)},
    'styles-P73U5RG2.css': {size: 270, hash: '1dkGEv2K6AU', text: () => import('./assets-chunks/styles-P73U5RG2_css.mjs').then(m => m.default)}
  },
};
