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

(defn stats [] 
  (into [] (sql/query connection ["SELECT COUNT(users.UserID) as user, (SELECT COUNT(QuestionID) FROM question) as question, (SELECT COUNT(AnswerID) FROM answer) as answer FROM users WHERE users.Active = 1"])))

(defn getpost [postid]
  (into [] (sql/query connection ["SELECT U.Avatar,U.Nick,U.UserID,U.JoinDate,Q.Date AS QDate, Q.Locked,Q.Description, Q.Title FROM users AS U INNER JOIN question as Q ON Q.AuthorID = U.UserID WHERE Q.QuestionID =?" postid]))
  )
(defn getanswers [postid]
  (into [] (sql/query connection ["SELECT U.Avatar,U.Nick,U.UserID,U.JoinDate,A.Date, A.Text FROM users AS U INNER JOIN answer as A ON A.UserID = U.UserID WHERE A.QuestionID =?" postid])))