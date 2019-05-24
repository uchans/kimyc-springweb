package org.kyc.chap11;

import java.util.List;


public interface MemberDao {

	/**
	 * 이메일로 회원 정보 가져옴
	 */
	Member selectByEmail(String email);

	/**
	 * 회원정보 저장
	 */
	void insert(Member member);

	/**
	 * 회원정보 수정
	 */
	void update(Member member);

	/**
	 * 회원 목록
	 */
	List<Member> selectAll(int offset, int count);
	
	int changePassword(String memberId, String currentPassword,
			String newPassword);
	/**
	 * 회원 수
	 */
	int countAll();
	
	Member selectByLogin(String email, String password);
}
