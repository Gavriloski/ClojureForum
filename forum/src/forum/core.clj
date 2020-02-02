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
            [forum.database :as db]
            [clojure.string :as str]))

(defn index []
   (template/main (page/index (db/posts) (db/stats) ""))
  )

(defn post [id del uspesno]
  (db/updateview id)
   (template/main (page/postpage (db/getpost id) (db/getanswers id) del uspesno))
  )
(defn profile [id]
   (template/main (page/profile (db/getuser id)))
  )
(defn newpost [greska]
   (template/main (page/newpost  (db/getusers) greska))
  )
(defn searchpost [filter]
  (template/main (page/index (db/postsfilter filter) (db/stats) filter))
  )

(defn addpost [title text user id]
  (if-not (and (str/blank? user) (str/blank? id))  
    (do 
      (if (= id user) 
        (do
        (db/addpost title text user)
        (ring/redirect "/"))
         (newpost "Error - Check your verification code.")
   ))
    (newpost "Error - Check your verification code.")
       )
    )
(defn gallery []
  (template/main (page/gallery (db/getavatars ))
  ))

(defn deletequestion [qid userid id]
  (if (= id userid) 
        (do
        (db/deletequ qid)
        (ring/redirect "/"))
     (post qid "1" "0")
   )
)

(defn contact []
  (template/main (page/contact )
  ))

(defroutes f_routes
(GET "/" [] (index))
(GET "/post/:id/:del" [id del] (post id del "1"))
(GET "/profile/:id" [id] (profile id) )
(GET "/newpost" [] (newpost "") )
(POST "/" [filter] (searchpost filter) )
(POST "/addpost" [title text user id] (addpost title text user id) )
(GET "/gallery" [] (gallery) )
(POST "/delete" [qid uid id] (deletequestion qid uid id))
(GET "/contact" [] (contact) )
(route/resources "/"))