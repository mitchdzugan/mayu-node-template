(ns leiningen.new.mayu-node
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "mayu-node"))

(defn mayu-node
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' mayu-node project.")
    (->files data
             [".gitignore" (render ".gitignore" data)]
             ["README.md" (render "README.md" data)]
             ["package.json" (render "package.json" data)]
             ["project.clj" (render "project.clj" data)]
             ["shadow-cljs.edn" (render "shadow-cljs.edn" data)]
             ["yarn.lock" (render "yarn.lock" data)]
             ["cli/build/main.clj" (render "cli/build/main.clj" data)]
             ["scss/site.scss" (render "scss/site.scss" data)]
             ["src/_test/core.cljc" (render "src/_test/core.cljc" data)]
             ["src/frontends/browser.cljc" (render "src/frontends/browser.cljc" data)]
             ["src/ui/entry.cljc" (render "src/ui/entry.cljc" data)]
             ["src/router.cljc" (render "src/router.cljc" data)]
             ["src/server.cljc" (render "src/server.cljc" data)])))
