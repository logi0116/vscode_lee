```mermaid
erDiagram
USER {
int user_id PK
varchar username
varchar email
varchar password
datetime created_at
}
PROFILE {
int profile_id PK
int user_id FK
varchar nickname
varchar bio
varchar avatar_url
}
POST {
int post_id PK
int user_id FK
varchar title
text content
datetime created_at
}
COMMENT {
int comment_id PK
int post_id FK
int user_id FK
text content
datetime created_at
}
TAG {
int tag_id PK
varchar name
}
POSTTAG {
int post_id FK
int tag_id FK
}
FRIENDSHIP {
int user_id FK
int friend_id FK
varchar status
datetime created_at
}

    USER ||--o| PROFILE : has
    USER ||--o| POST : writes
    USER ||--o| COMMENT : writes
    POST ||--o| COMMENT : has
    POST ||--o| POSTTAG : tagged
    TAG ||--o| POSTTAG : tagged
    USER ||--o| FRIENDSHIP : friends
    USER ||--o| FRIENDSHIP

```
