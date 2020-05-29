package jpabook.jpashop_v2.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="team_id")
    private Long teamId;

    @Column(name="team_name")
    private String name;

    @OneToMany(mappedBy = "team")//Member class 에서 ==> private Team team; 과 관련이 있음.//(사실상 ReadOnly)
    private List<Member> members = new ArrayList<>();

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
    // OBJ setting 은 한쪽에서 하자. 상황봐가면서
//    public void addMember(Member member)
//    {
//        member.setTeam(this);
//        members.add(member);
//    }
}
