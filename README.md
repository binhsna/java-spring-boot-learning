# java-spring-boot-learning
 Đề tài: Xây dựng hệ thống quản lý lớp học, học sinh, giáo viên, môn học:
 --> Mối liên hệ giữa các thực thể:
-	Lớp Học (Class):
+ Lớp Học có thể có nhiều Học Sinh (OneToMany relationship).
+ Lớp Học có thể có nhiều Môn Học (ManyToMany relationship).

-	Học Sinh (Student):
+ Học Sinh chỉ thuộc về một Lớp Học cụ thể (ManyToOne relationship).

-	Giáo Viên (Teacher):
+ Giáo Viên có thể dạy nhiều Môn Học (ManyToMany relationship).
-	Môn Học (Subject):
+ Môn Học có thể được dạy bởi nhiều Giáo Viên (ManyToMany relationship).
+ Môn Học có thể thuộc về nhiều Lớp Học (ManyToMany relationship).


