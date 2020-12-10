(ns aoc2020.day1-test
  (:require [clojure.test :refer :all]
            [aoc2020.day1 :as d1]))


(def t1
"1721
979
366
299
675
1456")

(def r1 514579)

(deftest a-test
  (testing "test values t1 -> r1"
    (is (= r1 (first (d1/day1-string 2 d1/extr2 t1))))))
           
