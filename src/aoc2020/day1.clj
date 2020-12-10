(ns aoc2020.day1
  (:require [clojure.string :as s]
            [clojure.math.combinatorics :as c]))


(def the-file "src/aoc2020/day1-input.txt")

(defn comb
  "wrapping the combinations function to use it in ->> makro: list is second here. Combination of places"
   [places l]
  (c/combinations l places))

(def extr2 (juxt first second))
(def extr3 (juxt first second #(nth %1 2)))

(defn day1-string
  "computes the result for a string containing multiple lines, using combi and tupel-extractor internally"
  [places tupel-extractor str]
  (->> str
       (s/split-lines)
       (map #(Integer/parseInt %1))
       (comb places)
       (filter #(= 2020 (apply + (tupel-extractor %1))))
       (map #(apply * (tupel-extractor %1)))))

(defn day1a [filename]
  (->> filename
       (slurp)
       (day1-string 2 extr2)))

(defn day1b [filename]
  (->> filename
       (slurp)
       (day1-string 3 extr3)))


(defn -main
  "run day1 and day1b with input file"
  [& args]
  (let [
        result1 (day1a the-file)
        result2 (day1b the-file)]
    (println result1)
    (println "----------------------------------------------------------------------")
    (println result2))
  '(result1 result2))
    
