(ns roman-numerals.core
  (:require [clojure.string :as string]
            [clojure.test :refer [is]]))

(defn arabic->roman-1-9
  [x [one five ten]]
  (cond
    (= x 4) (str one five)
    (= x 9) (str one ten)
    (< x 4) (apply str (repeat x one))
    (> x 4) (str five (apply str (repeat (- x 5) one)))))

(defn arabic->roman
  [x]
  (if (< x 4000)
    (apply str (map (fn [[n & digits]] (arabic->roman-1-9 (quot (rem x (* n 10)) n) digits))
                    [[1000 "M" nil nil]
                     [100 "C" "D" "M"]
                     [10 "X" "L" "C"]
                     [1 "I" "V" "X"]]))
    nil))


(def map-d {"I" 1
            "IV" 4
            "V" 5
            "IX" 9
            "X" 10
            "XL" 40
            "L" 50
            "XC" 90
            "C" 100
            "CD" 400
            "D" 500
            "CM" 900
            "M" 1000})

(defn parse-roman
  [x]
  (if (empty? x) x
      (let [[x y & rest] (into [] x)
            n (if (nil? y) nil (get map-d (str x y)))]
        (if (nil? n)
          (concat [(get map-d (str x))]
                  (parse-roman (string/join "" (concat [y] rest))))
          (concat [n] (parse-roman (string/join "" rest)))))))

(defn roman->arabic
  [x]
  (apply + (parse-roman x)))

(every? (fn [n]  (= (roman->arabic (arabic->roman n)) n)) (range 3999))
