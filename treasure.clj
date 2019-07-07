(ns clojure.assignment2.map
   (:gen-class))
   (require '[clojure.string :as str])

   (def rowsize 0)    ;;Row size initialization
   (def colsize 0)		;;Col size initialization
   (def startx  0)
   (def starty 0)
   (def found false)
   (def finishcheck false)
	(def pathcheck  0)
  

 
;;To print the map if the ending point is found.
(defn printdata [array2d]
(println "Woo hoo, I found the treasure :-)")
(run! #(println (str/join "" %)) array2d)

)
;;To print the data if not able to find ending point.
(defn nopath [array2d]
(println "Uh oh, I could not find the treasure :-(")
(run! #(println (str/join "" %)) array2d)

)
;; Fuction to solve the puzzle.
(defn find_path [array2d startx starty]

(def x  [ -1 0 0 1 ] )
(def y  [ 0 -1 1 0 ])
(aset array2d startx starty "+")
 (dotimes [n 4]
 (def flag  0)
 (def f  0)
 (def afterx  (+ (get x n) startx))
 (def aftery (+ (get y n) starty))

(if (> afterx rowsize) 
  (do  (def f (+ flag 1))
 ) )
 (if (< afterx 0) 
   (do
   
    (def f (+ flag 1))
 ) )
 (if (> aftery colsize) 
    (do  (def f (+ flag 1))
 ) )
 (if (< aftery 0) 
   (do  (def f (+ flag 1))
 ) )
 ;;(println f)
 (if (= f 1)
    (do false)  
     (do 
      (def forchecking (aget array2d afterx aftery))
      (if (= forchecking "@")
       (do 
	   (def pathcheck  1)
	   (def found true) 
       
  )  )
)
 )
 )

 (dotimes [n 4]
 (def flag1  0)
 (def f1  0)
 (def pathcheck  0)
(def afterx1  (+ (get x n) startx))
 (def aftery1 (+ (get y n) starty))
 (if (true? found )
  (do
    
    (printdata array2d)
    (System/exit 0)
   
   ))
  (if (> afterx1 rowsize) 
  (do  (def f1 (+ flag1 1))
 ) )
 (if (< afterx1 0) 
   (do
    (def f1 (+ flag1 1))
 ) )
 (if (> aftery1 colsize) 
    (do  (def f1 (+ flag1 1))
 ) )
 (if (< aftery1 0) 
   (do  (def f1 (+ flag1 1))
 ) ) 
 (if (= f1 1)
    (do false) 
    (do
  
      (def forchecking1 (aget array2d afterx1 aftery1))
     (if (= forchecking1 "-")
        (do 
        (def pathcheck  1)
        (find_path array2d afterx1 aftery1)
  (if (not= found true)
  (do
   (aset array2d afterx1 aftery1 "!")
  ))
  ;; (if (= pathcheck 0)
  ;;(do
  ;;(if (= n 3)
  ;;(do (nopath array2d)
  ;;)))
  ;;)
   
   )))))



   ) 


  
;;This is for printing map.
(defn readFile [file]
  (slurp "map.txt")
  
)
;;For creating 2d vectors.
(defn readvecofstrings [filename]
  (let [contents (slurp filename)   
        lines    (clojure.string/split contents #"\n") 
        vectors  (mapv #(mapv str %) lines)] 
    vectors))



;;For getting row and col size.
(defn forcounting [file]
  (with-open [rdr (clojure.java.io/reader file)]
     (reduce conj [] (line-seq rdr))))
 
 (defn counting [data1]
 (doseq [row data1]
      (def colsize (count row))
      (def rowsize (+ rowsize 1))
      )
      (def colsize (- colsize 1))
      (def rowsize (- rowsize 1))
     
 )
      
   
(def display (readFile "map.txt"))
(def data (readvecofstrings "map.txt"))
(println "This is my challenge:")
(println display )
(def data1 (forcounting "map.txt"))
(def array2d (to-array-2d data)) ;;Converting to 2d array.
(counting data1)
(find_path array2d startx starty) ;; Calling function.
;;(run! #(println (str/join "" %)) array2d)
(if (= pathcheck 0)
  (do (nopath array2d) ;; if end point not found.
  ))
