package com.idolticketing.idolticketing.service;

import com.idolticketing.idolticketing.dto.HelpDTO;

public interface HelpService {

    void board(HelpDTO a);
    void patchdesc(int id);
    void deletedesc(int id);
}
