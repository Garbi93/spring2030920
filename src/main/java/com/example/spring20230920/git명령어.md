pwd
-> 현재 디렉토리 출력

ls
-> 현재 폴더의 파일 목록

ls -l
-> 파일 목록 더 자세하게 보기

ls -A
-> 숨긴 파일까지 보기

ls -a
-> 현재폴더와 이전폴더를 보여주며 숨긴파일 까지 보기

ls -Al
-> 숨긴파일까지 보고 자세하게 보기

ctrl+l
-> 화면 정리

cd
-> 폴더 변경

cd ..
-> 상위 폴더로 이동

mkdir
-> 폴더만들기

touch
-> 새파일 만들기
(파일의 마지막 변경시간을 변경)

echo
-> 콘솔에 출력


-> 왼쪽의 출력을 오른쪽의 인풋으로
기존에 있던것을 지운다.

cat (more, less)
-> 파일 내용 보기


-> 왼쪽의 출력을 오른쪽에 인풋하고 기존에 있던 데이터에 추가로 입력

ctrl + c
-> 실행 취소

cd -
-> 이동전 폴더로 다시 이동

git init
-> 현재폴더를 git이 관리하게 할 것이다
init 을 잘못했다면 그 해당 디렉토리에 가서 .git폴더를 지우자

git status
-> 현재 리포의 상태보기

git add -A
->

git add
-> 변경된 파일을 스테이지로

git commit
-> 변경사항 생성

git log
-> 변경사항 히스토리 보기

q
-> 로그내용 보다 나가기

git log --oneline
-> 변경사항 한줄로 보기

git checkout
-> 변경사항 옮기기

git log --all
-> 모든 커밋보기

git log --all --oneline
-> 모든 커밋 한줄보기

branch
-> 커밋의 별칭

git branch <브랜치명> <커밋번호>
-> 커밋번호에 브랜치명 별칭을 생성

git branch -d <삭제할 브렌치명>
-> 별칭삭제

git switch <이동할 브렌치명>
-> checkout과 같은 브렌치 이동 명령어


git commit -m "커밋 메세지명"
-> 바로 커밋 하면서 커밋 명 넣기

git add -A
->변경한 모든 파일을 올리겠다.

git add
-> 변경사항을 stage에 올리기

git add .
-> 현재폴더와 하위폴더를 staged하기

git restore --staged <file이름>
-> staged된 것을 취소 시키는것

git restore <file이름>
->파일에 commit 된 것을 이전 commit 상태로 되돌리는것

.gitignore
-> git이 track하지 못하게 할고 싶을때

git commit -am
-> tracked파일 add,commit함께

git log --all --oneline --graph
-> 브랜치 를 그래프로 보여준다.

git merge <브렌치명>
->브렌치명의 변경사항을 현재 브렌치에 반영

git switch -c <브렌치 명>
-> 브렌치를 만들고 이동 