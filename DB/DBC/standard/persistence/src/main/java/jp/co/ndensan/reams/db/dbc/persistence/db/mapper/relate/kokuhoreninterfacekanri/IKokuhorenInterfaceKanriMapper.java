/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhoreninterfacekanri;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;

/**
 *
 * @author N2810 久保 里史
 */
public interface IKokuhorenInterfaceKanriMapper {

    /**
     * selectbyKey
     *
     * @param parameter keyのパラメーター
     * @return List<DbT3104KokuhorenInterfaceKanriEntity>
     */
    List<DbT3104KokuhorenInterfaceKanriEntity> selectbyKey(Map<String, Object> parameter);

    /**
     * update
     *
     * @param parameter keyのパラメーター
     * @return Integer
     */
    Integer shoriJotaiKubunUpdater(Map<String, Object> parameter);

    /**
     * update
     *
     * @param parameter keyのパラメーター
     * @return Integer
     */
    Integer torikomiShoriUpdater(Map<String, Object> parameter);

}
