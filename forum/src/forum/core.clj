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
   (template/main (page/index (db/posts) (db/stats)))
  )

(defn post [id]
   (template/main (page/postpage (db/getpost id) (db/getanswers id)))
  )
(defn profile [id]
   (template/main (page/profile (db/getuser id)))
  )
(defn newpost []
   (template/main (page/newpost))
  )
(defn searchpost [filter]
  
  )
(defroutes f_routes
  (GET "/" [] (index))
  (GET "/post/:id" [id] (post id))
  (GET "/profile/:id" [id] (profile id) )
  (GET "/newpost" [] (newpost) )
  (POST "/" [filter] (searchpost filter) )
  (route/resources "/"))