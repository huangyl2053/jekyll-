/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jutakukaishujizenshinseitsuchisho;

import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishujizenshinseitsuchisho.JutakuKaishuJizenShinseiParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujizenshinseitsuchisho.KuJigyoshaEntity;

/**
 * 事業者情報取得
 *
 * @reamsid_L DBC-0990-070 xicongwang
 */
public interface IJutakuKaishuJizenShinseiTsuchishoMapper {

    /**
     * 事業者情報取得
     *
     * @param parameter parameter
     * @return KuJigyoshaEntity
     */
    KuJigyoshaEntity get事業者情報(JutakuKaishuJizenShinseiParameter parameter);
}
