(ns pallet.action-impl-test
  (:require
   [clojure.test :refer :all]
   [pallet.action-impl :refer :all]))

(deftest make-action-test
  (testing "arguments"
    (let [action (make-action 'a0 :in-sequence {:always-before :a})]
      (is (= :in-sequence (action-execution action)))
      (is (= 'a0 (action-symbol action)))
      (is (= {:always-before :a} (action-precedence action)))
      (is (map? @(:impls action)))
      (is (empty? @(:impls action))))))
