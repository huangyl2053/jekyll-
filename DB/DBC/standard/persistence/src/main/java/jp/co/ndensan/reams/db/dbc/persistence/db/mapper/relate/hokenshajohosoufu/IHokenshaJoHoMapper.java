/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshajohosoufu;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.soufujouhou.hokenshajohosoufu.HokenshaJoHoParamter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hokenshajohosoufu.HokenshaJoHoEntity;

/**
 * 保険者情報送付の共有ファイルエントリ情報の取得のMapperインタフェイスです。
 *
 * @reamsid_L DBC-3480-010 dongyabin
 */
public interface IHokenshaJoHoMapper {

    /**
     * 共有ファイルエントリ情報を取得します。
     *
     * @param paramter paramter
     * @return HokenshaJoHoEntity
     */
    HokenshaJoHoEntity get共有ファイルエントリ情報(HokenshaJoHoParamter paramter);

}
