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
 */
public interface IJutakuKaishuJizenShinseiTsuchishoMapper {

    KuJigyoshaEntity get事業者情報(JutakuKaishuJizenShinseiParameter parameter);
}
