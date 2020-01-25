(ns forum.controller
  (:use ring.middleware.json
        ring.adapter.jetty)
  (:require [compojure.core :refer [defroutes ANY]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [compojure.route :as route]
            [forum.core :as core]))
            
(defroutes routes
 core/f_routes
 (route/resources "/" )
)

(def run
  (wrap-defaults routes site-defaults))