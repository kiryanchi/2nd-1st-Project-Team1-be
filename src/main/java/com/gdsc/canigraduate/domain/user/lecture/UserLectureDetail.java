package com.gdsc.canigraduate.domain.user.lecture;

import com.gdsc.canigraduate.domain.user.User;
import com.gdsc.canigraduate.dto.userLecture.UserLectureDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserLectureDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DETAIL_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LECTURE_ID")
    private UserLecture userLecture;

    @Enumerated(EnumType.STRING)
    private UserLectureType userLectureType;

    private Integer year; // 연도
    private String semester; // 학기
    private String major; // 교과목 구분
    private String code; // 교과목코드
    private String lectureName; //교과목명
    private Integer credit; // 학점
    private String grade; //성적등급
    private Double score; //점수

    @Builder
    public UserLectureDetail(Integer year, String semester, String major, String code, String lectureName,Integer credit, String grade, Double score){
        this.year = year;
        this.semester = semester;
        this.major = major;
        this.code = code;
        this.lectureName = lectureName;
        this.credit = credit;
        this.grade = grade;
        this.score = score;
    }

    public void setType(String major){
        if(major.equals("전공") || major.equals("전공필수"))
            this.userLectureType = UserLectureType.전공;
        else if(major.equals("교양"))
            this.userLectureType = UserLectureType.교양;
        else
            this.userLectureType = UserLectureType.일반선택;
    }

}