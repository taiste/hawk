(defproject hawk "0.2.13-SNAPSHOT"
  :description "Watch files with clojure (in the manner of a hawk)"
  :test-paths ["src/test/clojure"]
  :source-paths ["src/main/clojure"]
  :java-source-paths ["src/main/java"]
  :aot [hawk.watcher]
  :dependencies [[org.clojure/clojure "1.11.1"]]
  :plugins [[lein-modules "0.3.10"]]
  :profiles {:dev
             {:dependencies [[org.clojure/core.async "1.6.673"]]}}
  :modules {:subprocess false
            :inherited {:url "https://github.com/wkf/hawk"
                        :scm {:name "git"
                              :url "https://github.com/wkf/hawk"}
                        :license {:name "Eclipse Public License"
                                  :url "http://www.eclipse.org/legal/epl-v10.html"}}}
  :release-tasks [["vcs" "assert-committed"]
                  ["test"]
                  ["modules" "change" "version" "leiningen.release/bump-version" "release"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["modules" "export"]
                  ["vcs" "commit"]
                  ["vcs" "tag"]
                  ["modules" "ship"]
                  ["deploy" "clojars"]
                  ["modules" "change" "version" "leiningen.release/bump-version"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]])
