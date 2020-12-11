(ns aoc2020.day2-test
  (:require [aoc2020.day2 :as d]
            [clojure.test :refer :all]))

(def i1
"1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc")

(def s1 2)
  ;;'(true false true))

(def i2
"6-13 a: aaaaaaabbb
12-14 c: cccccccccccccc
13-14 r: rrrrrxxxxxxxxxx"
 )

(def s2 2)
  ;;'(true true false))


(deftest a-test
  (testing "test values i1 -> s1"
    (is (= s1 (d/day2a i1))))
    (testing "test values i2 -> s2"
    (is (= s2 (d/day2a i2)))))
           
(deftest a-file-test
  (testing "reading test file, result 439"
    (is (= 439 (d/day2a-file "src/aoc2020/day2-input.txt")))))

;; ----------------------------------------------------------------------
;; Part B
;; ----------------------------------------------------------------------

;; using i1 as input
(def s3 1 ;; true false false
  )

(def i4
"5-6 g: ggggbxggggrggggg
4-6 m: mmmsmdmpmmmm
5-9 d: ddddddqdgddd
2-19 d: dxdddddddddddddddddd
8-9 z: zzzzztzpzqzzdh
")
;;f f t t t
(def s4 3)

(deftest b-test
  (testing "test values i1 -> s3"
    (is (= s3 (d/day2b i1))))
  (testing "various examples s4"
    (is (= s4 (d/day2b i4)))))

(deftest b-file-test
  (testing "reading test file, result 584"
    (is (= 584 (d/day2b-file "src/aoc2020/day2-input.txt")))))
