# IntelliJ IDEA 프로젝트 설정 가이드

## 프로젝트를 처음 열 때

### 1. 프로젝트 열기
- IntelliJ IDEA를 실행합니다
- File → Open을 선택합니다
- 클론한 프로젝트의 루트 디렉토리를 선택합니다 (casino-campus가 아닌 상위 폴더)

### 2. Gradle 프로젝트 인식 문제 해결

#### 방법 A: 자동 인식이 안 될 경우
1. 프로젝트를 연 후 우측의 Gradle 탭을 클릭합니다
2. "+" 버튼을 클릭하여 "Link Gradle Project"를 선택합니다
3. `casino-campus/build.gradle` 파일을 선택합니다
4. OK를 클릭하여 Gradle 프로젝트를 추가합니다

#### 방법 B: 수동으로 Import
1. File → New → Module from Existing Sources...
2. `casino-campus` 디렉토리를 선택합니다
3. "Import module from external model" → Gradle 선택
4. Finish 클릭

### 3. JDK 설정 확인
- File → Project Structure (Ctrl+Alt+Shift+S)
- Project Settings → Project
- SDK: Java 21 (temurin-21 또는 다른 JDK 21)
- Language level: 21

### 4. Gradle 동기화
- View → Tool Windows → Gradle
- 상단의 "Reload All Gradle Projects" 버튼 클릭 (🔄 아이콘)

## 일반적인 문제 해결

### 모듈이 인식되지 않을 때
1. `.idea` 폴더 삭제 (git에서 다시 받기 위해)
2. IntelliJ 재시작
3. 프로젝트를 다시 열기
4. Gradle 재동기화

### "Cannot resolve symbol" 오류
1. File → Invalidate Caches... → Invalidate and Restart
2. 재시작 후 Gradle 동기화

### Gradle 빌드 실패
1. `./gradlew clean` 실행
2. `./gradlew build` 실행
3. IntelliJ에서 Gradle 재동기화

## 권장 IntelliJ 버전
- IntelliJ IDEA 2023.3 이상
- Community Edition 또는 Ultimate Edition 모두 가능

## 팀 협업 시 주의사항
- `.idea/workspace.xml`은 개인 설정이므로 커밋하지 않습니다
- 프로젝트 설정을 변경한 경우 팀원들과 공유합니다
- JDK 버전은 반드시 Java 21을 사용합니다