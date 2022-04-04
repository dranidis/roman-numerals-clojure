(ns roman-numerals.core-test
  (:require [clojure.test :refer [deftest testing is]]
            [roman-numerals.core :refer [arabic->roman roman->arabic]]))

(deftest arabic->roman-test
  (testing "1"
    (is (= "I" (arabic->roman 1))))

  (testing "2"
    (is (= "II" (arabic->roman 2))))

  (testing "3"
    (is (= "III" (arabic->roman 3))))

  (testing "4"
    (is (= "IV" (arabic->roman 4))))

  (testing "5"
    (is (= "V" (arabic->roman 5))))

  (testing "6"
    (is (= "VI" (arabic->roman 6))))

  (testing "8"
    (is (= "VIII" (arabic->roman 8))))

  (testing "9"
    (is (= "IX" (arabic->roman 9))))

  (testing "10"
    (is (= "X" (arabic->roman 10))))

  (testing "11"
    (is (= "XI" (arabic->roman 11))))

  (testing "13"
    (is (= "XIII" (arabic->roman 13))))

  (testing "14"
    (is (= "XIV" (arabic->roman 14))))

  (testing "19"
    (is (= "XIX" (arabic->roman 19))))

  (testing "20"
    (is (= "XX" (arabic->roman 20))))

  (testing "30"
    (is (= "XXX" (arabic->roman 30))))

  (testing "40"
    (is (= "XL" (arabic->roman 40))))

  (testing "789"
    (is (= "DCCLXXXIX" (arabic->roman 789))))

  (testing "1066"
    (is (= "MLXVI" (arabic->roman 1066))))

  (testing "1009"
    (is (= "MIX" (arabic->roman 1009))))

  (testing "3999"
    (is (= "MMMCMXCIX" (arabic->roman 3999)))))

(deftest roman->arabic-test
  (testing "1"
    (is (= 1 (roman->arabic "I"))))
  (testing "3"
    (is (= 3 (roman->arabic "III"))))
  (testing "4"
    (is (= 4 (roman->arabic "IV")))))

(deftest round-trip
  (testing "1-3999"
    (is (every? (fn [n]  (= (roman->arabic (arabic->roman n)) n))
                (range 3999)))))