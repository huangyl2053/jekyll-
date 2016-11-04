/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kaigokyufujuryoininkeiyakutoroku;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufujuryoininkeiyakutoroku.HihokenshaJohoEntity;

/**
 * 介護保険受領委任契約承認（不承認）確認書のMapperクラスです。
 *
 * @reamsid_L DBC-2130-050 cuilin
 */
public interface IKaigoKyufuJuryoininKeiyakuTorokuMapper {

    /**
     * 被保険者情報を取得します。
     *
     * @param map Map<String,Object>
     * @return HihokenshaJohoEntity
     */
    HihokenshaJohoEntity get被保険者情報(Map<String, Object> map);
}
