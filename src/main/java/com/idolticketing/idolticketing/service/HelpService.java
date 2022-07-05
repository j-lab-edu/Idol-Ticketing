package com.idolticketing.idolticketing.service;

import com.idolticketing.idolticketing.dto.HelpDTO;
import com.sun.corba.se.impl.orbutil.HexOutputStream;

public interface HelpService {

    int board(HelpDTO helpDTO);
    int patchdesc(HelpDTO helpDTO);
    int deletedesc(HelpDTO helpDTO);
    int deleteDescAdmin(HelpDTO helpDTO);
}
