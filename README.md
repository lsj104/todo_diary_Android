## Todo Diary 📔

#### 로그인 화면 🔑
- 로그인
- 회원가입
- 카카오 로그인

<img width="30%" alt="스크린샷 2022-09-27 오전 1 25 24" src="https://user-images.githubusercontent.com/75536654/192441666-8d3442ae-d907-46fc-b0fe-062cf4c05970.png">

#### 회원가입 🔐
- id와 pw를 입력받아 sharedPreference를 이용해 id, pw를 저장
- 비밀번호를 입력할 때는 비밀번호가 보이지 않게 설정
- 회원가입이 완료되면 로그인 화면으로 돌아가서 가입한 id, pw를 입력한 후 이용

<img width="30%" alt="스크린샷 2022-09-27 오전 1 25 58" src="https://user-images.githubusercontent.com/75536654/192442998-f460d86b-40b0-4449-99e8-035bb179ec82.png">

#### 카카오로그인 🗝
- 카카오 로그인 API를 이용해 카카오 로그인 구현
- 로그인이 완료되면 바로 메인 페이지로 이동

<img width="30%" alt="스크린샷 2022-09-27 오전 1 30 52" src="https://user-images.githubusercontent.com/75536654/192443190-a26fe907-4b73-4d3b-b58e-8d4d2baeabfa.png">

#### 메인 페이지 📚
- bottomnavigation
1. ToDo Diary, 현재 날씨 확인
2. 가장 인기 있는 영화 조회
3. 환경 설정

<img width="30%" alt="스크린샷 2022-09-27 오전 1 26 17" src="https://user-images.githubusercontent.com/75536654/192443440-1b15575c-7c25-41d1-8246-707f74d45e6b.png">

#### 1-1. ToDo Diary ✏️
- 맨 위 작성하기칸에 글을 작성하고 저장 버튼을 누르면 recyclerview를 이용해 목록에 보여주고 
Sqlite를 이용해 저장
- 저장된 메모 오른쪽에 삭제하기 버튼과 작성된 날짜, 시간을 표시
- 삭제 버튼을 누르면 Sqlite를 이용해 데이터 삭제

<img width="30%" alt="스크린샷 2022-09-27 오전 1 28 27" src="https://user-images.githubusercontent.com/75536654/192445137-ddcf132b-68b7-4d5f-b016-ab4f245e6be0.png">

#### 1-2. 현재 날씨 ☁️
- 날씨 API를 이용해 도시 이름을 입력하면 현재 온도를 알려줌

<img width="30%" alt="스크린샷 2022-09-27 오전 1 29 57" src="https://user-images.githubusercontent.com/75536654/192445527-5aafa297-9af5-4afa-ba4e-b4cc6cde619d.png">

#### 2. 가장 인기 있는 영화
- TMDB API를 이용해 가장 인기 있는 영화를 조회
- recyclerview를 이용해 영화 포스터와 제목을 보여줌

<img width="30%" alt="스크린샷 2022-09-27 오전 1 30 05" src="https://user-images.githubusercontent.com/75536654/192445870-d4f97295-6d60-4d53-bf2d-12d4f39bd76b.png">

#### 3. 환경 설정
<img width="30%" alt="스크린샷 2022-09-27 오전 1 30 11" src="https://user-images.githubusercontent.com/75536654/192445956-de00e599-bd61-4d7f-bb09-3c6655bd83de.png">





