package com.idolticketing.idolticketing.service.Impl;

import com.idolticketing.idolticketing.dao.HelpMapper;
import dto.HelpDTO;
import com.idolticketing.idolticketing.service.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelpServiceImpl implements HelpService {

    @Autowired
    HelpMapper helpMapper;

    @Override
    public int board(HelpDTO helpDTO) {
        return helpMapper.createBoard(helpDTO);
    }


    @Override
    public int patchdesc(HelpDTO helpDTO) {
        return helpMapper.updateBoard(helpDTO);
    }

    @Override
    public int deletedesc(HelpDTO helpDTO) {
        return helpMapper.deleteBoard(helpDTO);
    }

    @Override
    public int deleteDescAdmin(HelpDTO helpDTO) {
        return helpMapper.deleteBoardAdmin(helpDTO);
    }
}
