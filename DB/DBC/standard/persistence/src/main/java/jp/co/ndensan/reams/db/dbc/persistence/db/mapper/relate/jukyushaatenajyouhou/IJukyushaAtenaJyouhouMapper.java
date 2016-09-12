/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushaatenajyouhou;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jukyushaatenaayouhou.JukyushaAtenaJyouhouParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaatenaayouhou.JukyushaAtenaJyouhouEntity;

/**
 * 宛名取得PSM取得Entityクラスです。
 *
 * @reamsid_L DBC-4350-110 chenhui
 */
public interface IJukyushaAtenaJyouhouMapper {

    /**
     * 宛名識別対象取得PSMを呼び出して、宛名情報を取得する。
     *
     * @param parameter parameter
     * @return DealKyufujissekiEntity
     */
    JukyushaAtenaJyouhouEntity get宛名情報(JukyushaAtenaJyouhouParameter parameter);

}
