package com.idolticketing.idolticketing.service;

import com.idolticketing.idolticketing.dto.HelpDTO;

public interface HelpService {

    int board(HelpDTO helpDTO);
    int patchdesc(HelpDTO helpDTO);
    int deletedesc(HelpDTO helpDTO);
}
