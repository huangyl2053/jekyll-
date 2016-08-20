/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hihokenshajohosoufudatasakuseyi;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hihokenshajohosoufudatasakuseyi.KokuhorenSofuJohoEntity;

/**
 * 保険者情報送付データ作成
 *
 * @reamsid_L DBC-3300-170 wangxingpeng
 */
public interface IKokuhorenSofuJohoMapper {

    /**
     * select国保連送付情報取得
     *
     * @param map Map<String, Object>
     * @return List<KokuhorenSofuJohoEntity> 国保連送付情報
     */
    List<KokuhorenSofuJohoEntity> select国保連送付情報取得(Map<String, Object> map);
}
