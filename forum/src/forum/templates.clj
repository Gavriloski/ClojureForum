(ns forum.templates
  (:use [hiccup.element :only (link-to)])
  (:require [hiccup.page :as h]
            [hiccup.page :refer [html5 include-css]]))

(defn main [body]
  (h/html5
    [:head
     [:title "Ask"]
     (include-css "/css/main.css" "/css/lightbox.min.css" "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" "https://fonts.googleapis.com/css?family=Open+Sans:400i,700")
     ]
[:nav {:class "navbar navbar-default text-center" }
	[:div {:class "container"}
  [:ul {:class "nav navbar-nav"}

			[:li [:a {:href "index.php"} "Home"]]
			[:li [:a {:href ""} "Members Gallery"]]
			[:li [:a {:href ""} "Contact"]]
   ]
		[:div {:id "login" :class "right"}
  ]
  ]]
body
   ))