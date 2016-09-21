/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010.HihokenshaAtenaMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.HihokenshaAtenaResultEntity;

/**
 * 被保険者台帳と宛名情報のMapperクラスです。
 *
 * @reamsid_L DBC-5010-030 donghj
 */
public interface IHihokenshaAtenaJohoMapper {

    /**
     * 被保険者台帳・宛名情報の取得。
     *
     * @param parameter HihokenshaAtenaMybatisParameter
     * @return List<HihokenshaAtenaResultEntity>
     */
    List<HihokenshaAtenaResultEntity> get被保険者台帳と宛名情報(HihokenshaAtenaMybatisParameter parameter);

}
