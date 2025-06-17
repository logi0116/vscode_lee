@startuml
skinparam handwritten true

actor User
participant "MagicGallery" as MG
participant "thumbnailPanel" as TP
participant "imageLabel" as IL

User -> TP : 썸네일 클릭
TP -> MG : 썸네일 클릭 이벤트 전달 (index)
MG -> MG : showImage(index) 호출
MG -> IL : 이미지 변경 (setIcon)
MG -> IL : 제목 변경 (setText)

@enduml