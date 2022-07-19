package com.idolticketing.idolticketing.service;

import dto.HelpDTO;

public interface HelpService {

    int board(HelpDTO helpDTO);
    int patchdesc(HelpDTO helpDTO);
    int deletedesc(HelpDTO helpDTO);
    int deleteDescAdmin(HelpDTO helpDTO);
}
