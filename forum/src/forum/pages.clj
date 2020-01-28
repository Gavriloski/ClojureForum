(ns forum.pages
   (:use hiccup.page hiccup.element
        )
  (:require  
    [hiccup.core :refer [h]]
    [forum.templates :as template]
     [hiccup.form :as form]
     [ring.util.anti-forgery :as anti-forgery]))

(defn index [posts]
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
  (map 
 (fn [post]  
    [:div {:class "post"}

                              
	[:div {:class "poststats left"}
		[:div {:class "views"}
			[:div {:class "number"}
				(:views post)
			]
			" views"
		]

		[:div {:class "answers"}
		[:div {:class "number"}
         (:answers post)   
			]
			"answers"
	]


]

[:div {:class "title"}
		[:h2 [:a {:href ""} (:title post) ]  ]
]
[:div {:class "postby"}
		"posted by " [:a {:href ""} (:nick post)] " on "(:date post)
]
 
]
) posts)
	[:div {:id "pag"}
 [:ul {:class "pagination pagination-lg"}
   
  ]]
			]

			[:div {:class "col-lg-3" :id "side"}
			]
   ]
   ]
       )

