# mock-test
test kafka and mockito

https://medium.com/@danieljameskay/understanding-the-enable-auto-commit-kafka-consumer-property-12fa0ade7b65
https://stackoverflow.com/questions/48320672/what-is-the-difference-between-kafka-earliest-and-latest-offset-values
https://stackoverflow.com/questions/42004426/kafka-subscribe-commit-offset-manually


git reset --hard
git reset --soft HEAD~1
git reset --hard 123456 - usuwa wszytsko do tego komita

git commit --amend

git revert 12345

git stash save 'zmiana'
git stash pop stash@{0}
git stash list
git stash clear

git clean -f usuwa wszytskie nieśledzone
rm nowy.xml  usuwa nieśledzony plik
git clean -df - usuwa katalog

git rm nowy.xml  usuwa zakomitowane
git rm -f    usuwa śledzone pliki
git rm cached nowy.xml   usuwa slodzeony plik ale nie usuwa go fizycznie

git rebase -i HEAD~3 scala trzy comity w jeden fixup



