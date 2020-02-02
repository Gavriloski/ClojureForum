(ns forum.pages
   (:use hiccup.page hiccup.element
        )
  (:require  
    [hiccup.core :refer [h]]
    [forum.templates :as template]
     [hiccup.form :as form]
     [ring.util.anti-forgery :as anti-forgery]))

(defn index [posts stats]
  [:div
    (form/form-to [:post "/"]
    (anti-forgery/anti-forgery-field)
    [:div {:class "container" :id "search-post" :style "background:#FFF"}
	[:div {:class "row"}
		[:div {:class "col-lg-9"}
			[:div {:class "input-group"}
	   			[:input {:type "text" :name "filter" :class "form-control" :placeholder "Search by title" :id "search" }]
	   		[:div {:class "input-group-btn"}
	     		[:button {:class "btn btn-default" :type "submit" :id "glyph"}
	       		[:i {:class "glyphicon glyphicon-search" :id "glyphicon-search"}]
	      		]
	      ]
			]]
		[:div {:class "col-lg-3"}
				[:a {:href "/newpost" :class "btn btn-primary" :id "ask-btn"} "Ask" ]
    ]
    ]
      ])
   
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
(defn profile [user]
  (map 
    (fn [user]
  [:div {:class "container"}
[:div {:class "page-header"}
            [:h1 "Profile"]]
      [:div {:class "row"}
        [:div {:class "col-lg-12 toppad"}
          [:div {:class "panel panel-info"}
            [:div {:class "panel-heading"}
              [:h2 {:class "panel-title"} (:nick user)]
            ]
            [:div {:class "panel-body"}
              [:div {:class "row"}
                [:div {:class "col-lg-3 col-lg-offset-1 " :align "center"}
                 [:img {:alt "User Pic" :src (:avatar user) :class "img-circle img-responsive" :width "200px" :height "200px"} 
                ]
              
                [:div {:class "col-lg-7 col-lg-offset-1 "} 
                  [:table {:class "table table-user-information"}
                    [:tbody
                      [:tr
                        [:td "E-mail adress:"]
                        [:td (:mail user) ]
                      ]
                      [:tr
                        [:td "Date Joined"]
                        [:td (:joindate user)]
                      ]
                      [:tr
                        [:td "Country:"]
                        [:td (:countryname user)]
                      ]
                         [:tr
                             [:tr
                        [:td "Gender:"]
                        [:td (:gender user)]
                      ]
                       [:tr
                        [:td "Role:"]
                        [:td (:rolename user)]
                      ]
                      [:tr
                        [:td "Answers:"]
                        [:td  (:answers user) ]
                      ]
                      [:tr
                        [:td "Posts:"]
                        [:td (:posts user)]
                      ]   
                      ]
                    ]]
                ]]
            ]]]]]
]) user)
  ) 
(defn newpost [] 
 [:div {:class "container"}
	[:h1 {:class "page-header"} "Post new questions"]
	[:div {:class "well"}
    "Please be specific about your question"]
	]
		[:div {:class "container"}
   [:div {:class "form-horizontal"}
    (form/form-to [:post "/addpost"]
      (anti-forgery/anti-forgery-field)
				[:div {:class "form-group"}
					[:label {:class "col-lg-2 col-lg-offset-1"} "Title:"]

				[:div {:class "col-lg-9"}
					[:input {:type "text" :class "form-control" :placeholder "What's your question about?" :autofocus "true" :required "true" :name "title" :title "Title can only have numbers and charachters"}]
				]]
    [:div {:class "form-group"}
     [:label {:class "col-lg-2 col-lg-offset-1"} "Question:"]
     [:div {:class "col-lg-9"}
					[:textarea {:class "form-control" :rows "20" :name="text" :required "true"}]
				]]

				 [:div {:class "form-group"}
					[:div {:class "col-lg-9 col-lg-offset-3"}
            [:input {:type "submit" :class "btn btn-primary half" :value "Post" :name "btnSubmitPost"}]
            [:input {:type "reset" :class "btn btn-primary half" :value "Reset"}]
                ]
				])]
		])