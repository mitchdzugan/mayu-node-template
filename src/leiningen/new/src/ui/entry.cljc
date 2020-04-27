(ns ui.entry
  (:require [mayu.macros :refer [defui ui]]
            [mayu.frp.event :as e]
            [mayu.frp.signal :as s]
            [mayu.dom :as dom]
            [router :as r]))

(defui page []
  {:keys [id]} <- (dom/envs ::r/route)
  <[h2 (str "Page " id)]
  <[a {:href (r/url ::r/home)} "Home"])

(defui home []
  <[div $=
    <[h1 "Home"]
    <[ul $=
      <[li $=
        <[a {:href (r/url ::r/page {:id 1})} "Page 1"]
        <[a {:href (r/url ::r/page {:id 2})} "Page 2"]
        <[a {:href (r/url ::r/page {:id 3})} "Page 3"]]]])

(defui root []
  s-route <- (dom/envs ::r/s-route)
  <[dom/bind s-route $[route]=
    <[dom/assoc-env ::r/route route $=
      let [name (get-in route [:data :name])]
      <[case name
        <[::r/home <[home]]
        <[::r/page <[page]]]]])
