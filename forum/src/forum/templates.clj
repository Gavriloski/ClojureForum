(ns forum.templates
  (:use [hiccup.element :only (link-to)])
  (:require [hiccup.page :as h]
            [hiccup.page :refer [html5 include-css]]))

(defn header []
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
  ]]]

[:div {:class "container" :id "search-post"}
		[:div {:class "row"}
			[:div {:class "col-lg-9"}
				[:div {:class "input-group"}
	    			[:input {:type "text" :class "form-control" :placeholder "Search by title" :id "search"}]
	    		[:div {:class "input-group-btn"}
		      		[:button {:class "btn btn-default" :type "submit" :id "glyph"}
		        		[:i {:class "glyphicon glyphicon-search" :id "glyphicon-search"}]
	      			]
	      		]
			]]
			[:div {:class "col-lg-3"}
				[:a { :class "btn btn-primary" :id "ask-btn"} "Ask" ]
]]]

	[:div {:class "container" :id "middle"}
		[:div {:class "page-header"}
			[:h1 "Posts"]]

		[:div {:class "row"}		
			[:div {:class "col-lg-9" :id "allpost"}
			]

			[:div {:class "col-lg-3" :id "side"}
			]
   ]
   ]
   ))