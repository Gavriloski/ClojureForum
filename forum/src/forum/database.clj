(ns forum.database
  (:require [clojure.java.jdbc :as sql]))

(def connection 
  {:classname "com.mysql.jdbc.Driver"
   :subprotocol "mysql"
   :subname "//localhost/skakacco_mareask"
   :user "root"
   :password ""})

(defn posts []
   (into [] (sql/query connection ["SELECT U.UserID,Q.QuestionID,Q.Title,Q.Date,U.Nick,Q.Views,Q.Locked, COUNT(A.AnswerID) as answers FROM question AS Q INNER JOIN users AS U ON Q.AuthorID = U.UserID LEFT OUTER JOIN answer as A on Q.QuestionID = A.QuestionID GROUP BY 1,2,3,4,5,6,7 ORDER BY Date DESC"])))
;SELECT COUNT(AnswerID) FROM answer WHERE QuestionID = '{$row['QuestionID']}'
;SELECT U.UserID,Q.QuestionID,Q.Title,Q.Date,U.Nick,Q.Views,Q.Locked FROM question AS Q INNER JOIN users AS U ON Q.AuthorID = U.UserID ORDER BY Date DESC LIMIT $offset,$perpage"