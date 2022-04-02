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
    (is (= "IX" (roman 9))))
  
  (testing "10"
    (is (= "X" (roman 10))))
  
  (testing "11"
    (is (= "XI" (roman 11))))
  
  (testing "13"
    (is (= "XIII" (roman 13))))
  
  (testing "14"
    (is (= "XIV" (roman 14))))
  
  (testing "19"
    (is (= "XIX" (roman 19))))
  
  (testing "20"
    (is (= "XX" (roman 20))))
  
  (testing "30"
    (is (= "XXX" (roman 30))))
  
  (testing "40"
    (is (= "XL" (roman 40))))
  )
