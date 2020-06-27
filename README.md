# BookSearcher

1. 앱 구조 MVVM 형태.

2. 네트워크 라이브러리 : Retrofit (https://github.com/square/retrofit)
    - Api 호출을 간편히 하기 위해 retrofit 을 사용한다.
    
3. 이미지 라이브러리 : Glide (https://github.com/bumptech/glide)
    - 썸네일 이미지 로드를 위해 Glide를 사용한다.
    
4. 페이징 : https://developer.android.com/topic/libraries/architecture/paging?hl=ko
    - 아이템 페이징 처리를 위해 안드로이드 jetPack 의 페이징 라이브러리를 사용한다.

5. 두 개의 Fragment (Search, Detail)
    - SearchFragment : 검색어를 입력 받아 검색하여 리스트를 보여준다.
    - DetailFragment : 웹류를 사용하여 상세 URI 를 보여준다.

5. ViewModel - Repository - DataSource - ApiManager 형태.
6. 시퀀스 : SearchFragment (검색어 입력) -> ViewModel (search) -> Repository (getBooks) -> DataSource (load) -> Adapter
