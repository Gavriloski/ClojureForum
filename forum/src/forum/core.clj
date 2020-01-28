(ns forum.core
  (:use compojure.core
        ring.util.json-response 
        ring.adapter.jetty)
  (:require [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :as ring] 
            [compojure.route :as route]
            [compojure.core :refer [defroutes GET POST]]
            [forum.templates :as template]))

(defn foo
  "Proba prva"
  [x]
  (println x "Hello, World!"))

(defn index []
   (template/header )
  )
(defroutes f_routes
  (GET "/" [] (index))
  (route/resources "/"))