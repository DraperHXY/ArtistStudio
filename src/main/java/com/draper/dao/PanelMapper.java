package com.draper.dao;

import com.draper.entity.Panel;

import java.util.List;

public interface PanelMapper {

    void insertPanel(Panel panel);

    Panel selectPanelByProductionId(long id);

    void updatePanelByProductionId(long id);

    void deletePanelByProductionId(long id);

    List<Panel> getAllPanelList();

}