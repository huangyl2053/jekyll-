/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.riyoshafutanwariaihanteimanager;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.riyoshafutanwariaihanteimanager.RiyoshaFutanWariaiHanteiManagerParameter;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;

/**
 * ビジネス設計_DBCMNK2001_利用者負担割合判定（service）
 *
 * @reamsid_L DBC-5010-040 quxiaodong
 */
public interface IRiyoshaFutanWariaiHanteiManagerMapper {

    /**
     * 生活保護受給者entity取得
     *
     * @param parameter RiyoshaFutanWariaiHanteiManagerParameter
     * @return UrT0508SeikatsuHogoJukyusha
     */
    UrT0508SeikatsuHogoJukyushaEntity get生活保護受給者entity(RiyoshaFutanWariaiHanteiManagerParameter parameter);

}
