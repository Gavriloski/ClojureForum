(ns forum.pages
   (:use hiccup.page hiccup.element
        )
  (:require  
    [hiccup.core :refer [h]]
    [forum.templates :as template]
     [hiccup.form :as form]
     [ring.util.anti-forgery :as anti-forgery]))

(defn index [posts, stats]
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
			"views"
		]

		[:div {:class "answers"}
		[:div {:class "number"}
         (:answers post)   
			]
			"answers"
	]
]

[:div {:class "title"}
		[:h2 [:a {:href (str "/post/" (h (:questionid post)))} (:title post) ]  ]]
[:div {:class "postby"}
		"posted by " [:a {:href (str "/profile/" (h (:userid post)))} (:nick post)] " on "(:date post)]
 ]
) posts)
	[:div {:id "pag"}
 [:ul {:class "pagination pagination-lg"}  
  ]]
			]

			[:div {:class "col-lg-3" :id "side"}
    (map 
 (fn [stat]  
    [:div {:id "stats"}
	[:span {:class "sidespan"}"Stats"]
	[:div {:class "well"}
		[:span {:class "stat"} [:strong (:user stat)  ] " Members"]
		[:span {:class "stat"} [:strong (:question stat)] " Posts"] 
		[:span {:class "stat last"} [:strong (:answer stat)] " Answers"] 
	]]
    ) stats)

			]
   ]
   ]
)

(defn postpage [post answers]
  (def x 0)
(map 
 (fn [post]
[:div {:class "container" :id "test"}
 
	[:h1 {:class "page-header"} (:title post) ]
	[:div {:class "row"}
		[:div {:class "col-lg-12"}
			[:div {:class "panel panel-primary singlepost"}
				[:div {:class "panel-heading" :style "padding:5px;"}
					[:div {:class "text-right"}
  								"#"(inc x)]
				]
				[:div {:class "panel-body"}
					[:div {:class "row"}
						[:div {:class "col-lg-3"}
							[:div {:class "profile-info text-center"}
								[:img {:src (:avatar post) :alt "avatar" :class "img-circle img-responsive" :width "120px" :height "120px"}]

								[:div {:class "nick"}
								 	[:a {:href (str "/profile/" (h (:userid post)))} (:nick post)]
								]

								[:div 
								  "Date Joined : " (:joindate post) 
								]
								[:div
								  "Posted on : " (:qdate post) 
								]]]
						[:div {:class "col-lg-9"}
							[:div {:class "post-msg"} (:description post)
							]
						] 
					]
				
			]
		]
	]
]
				 ( if (not-empty answers) 
      (do 
        (map 
 (fn [answer]
		[:div {:clas "row"}
		[:div {:class "col-lg-12"}
			[:div {:class "panel panel-primary singlepost"}
			[:div {:class "panel-heading" :style "padding:5px;"}]
				[:div {:class "panel-body"}
					[:div {:class "row"}
						[:div {:class "col-lg-3"}
							[:div {:class "profile-info text-center"}
							[:img {:src (:avatar answer) :alt "avatar" :class "img-circle img-responsive" :width "120px" :height "120px"}]

								[:div {:class "nick"}
							 	[:a {:href (str "/profile/" (h (:userid answer)))} (:nick answer)]
							]

								[:div
								  "Date Joined : "(:joindate answer) 
								]
								[:div
								  "Posted on : "(:date answer)
								]
						]
						]
						[:div {:class "col-lg-9"}
						[:div {:class "post-msg"}
							(:text answer)
							]
						] 
					]
					]
		]
	]
]
 )answers)
))

]		) post)
  )

