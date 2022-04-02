(ns roman-numerals.core-test
  (:require [clojure.test :refer [deftest testing is]]
            [roman-numerals.core :refer [roman]]))

(deftest a-test
  (testing "1"
    (is (= "I" (roman 1))))

  (testing "2"
    (is (= "II" (roman 2))))

  (testing "3"
    (is (= "III" (roman 3))))

  (testing "4"
    (is (= "IV" (roman 4))))

  (testing "5"
    (is (= "V" (roman 5))))
  
  (testing "6"
    (is (= "VI" (roman 6))))
  
  (testing "8"
    (is (= "VIII" (roman 8))))
  
  (testing "9"
    (is (= "IX" (roman 9)))))
