package com.utmost.module.codegroup;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.utmost.module.codegroup.CodeGroupVo;

@Repository
public interface CodeGroupDao {

	public List<CodeGroupDto> selectList(CodeGroupVo vo);
	public CodeGroupDto selectOne(CodeGroupDto dto);
	public int insert(CodeGroupDto dto);
	public int selectOneCount(CodeGroupVo vo);
}
