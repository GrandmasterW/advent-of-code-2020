(ns aoc2020.day2
  (:require [clojure.string :as cs]))

(defn cleaner
  "returns a vec of int, int, char, str"
  [[_ a-str b-str c-str str]]
  {:pre [(= 1 (count c-str))]}
  [(Integer/parseInt a-str)
   (Integer/parseInt b-str)
   (first c-str)
   str
   ])

(defn day2-run
  [str valid?]
  (let [
        inp-seq (mapv
                 #(re-seq #"(\d+)-(\d+) ([a-zA-Z]): ([a-zA-Z]+)" %1)
                 (cs/split-lines str))
        clean-inp (map (comp cleaner first) inp-seq)
        ]
    (count (filter true? (map valid? clean-inp)))))


;; ----------------------------------------------------------------------


(defn valid-pw-a?
  [[from to c str]]
  (let [
        freq-str (frequencies str)
        c-freq (get freq-str c 0)
        ]
    (and (<= from c-freq)
         (>= to c-freq))))

  
(defn day2a
  [str]
  (day2-run str valid-pw-a?))

;; ----------------------------------------------------------------------


(defn valid-pw-b?
  [[pos1 pos2 c str]]
  (let [
        c1 (get str (dec pos1))
        c2 (get str (dec pos2))
        ]
    (or (and (= c c1) (not= c c2))
        (and (not= c c1)(= c c2)))))
      
(defn day2b
  [str]
  (day2-run str valid-pw-b?))
  

;; ----------------------------------------------------------------------


(defn day2-file [filename func]
  (->> filename
       (slurp)
       (func)))
         
(defn day2a-file [filename]
  (day2-file filename day2a))

(defn day2b-file [filename]
  (day2-file filename day2b))

;; ----------------------------------------------------------------------
