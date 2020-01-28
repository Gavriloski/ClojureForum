(ns forum.core
  (:use compojure.core
        ring.util.json-response 
        ring.adapter.jetty)
  (:require [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :as ring] 
            [compojure.route :as route]
            [compojure.core :refer [defroutes GET POST]]
            [forum.templates :as template]
            [forum.pages :as page]
            [forum.database :as db]))

(defn index []
   (template/main (page/index (db/posts)))
  )


(defroutes f_routes
  (GET "/" [] (index))
  (route/resources "/"))