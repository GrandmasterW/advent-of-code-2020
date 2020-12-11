(defproject aoc2020 "0.1.0-SNAPSHOT"
  :description "my humble aoc adventures in Clojure"
  :url "http://example.com/FIXME"
  :license {:name "GPL-3.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.gnu.org/licenses/gpl-3.0.en.html"
            }
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/math.combinatorics "0.1.6"]
                 ]
  :main ^:skip-aot aoc2020.day2
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
