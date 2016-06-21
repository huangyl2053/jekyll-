/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shiharaihohojyoho;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.KeiyakushaParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;

/**
 * 支払方法情報を取得するマッパーインタフェースです。
 *
 * @reamsid_L DBC-0300-020 houtianpeng
 */
public interface IShiharaiHohoJyohoMapper {

    /**
     * 口座IDで口座情報を取得します。
     *
     * @param parameter 支払方法情報Parameter
     * @return DbT3077JuryoininKeiyakuJigyoshaEntity
     */
    DbT3077JuryoininKeiyakuJigyoshaEntity get契約事業者情報(KeiyakushaParameter parameter);
}
