/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.mappers;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3104KokuhorenInterfaceKanriEntity;

/**
 *
 * @author N2810 久保 里史
 */
public interface IKokuhorenInterfaceKanriMapper {

    //select
    List<DbT3104KokuhorenInterfaceKanriEntity> selectbyKey(Map<String, Object> parameter);

    //update
    Integer shoriJotaiKubunUpdater(Map<String, Object> parameter);

    Integer torikomiShoriUpdater(Map<String, Object> parameter);

}
