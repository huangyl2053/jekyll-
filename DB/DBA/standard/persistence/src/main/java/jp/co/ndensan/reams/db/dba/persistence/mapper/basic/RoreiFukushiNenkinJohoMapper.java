/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.core.roreifukushinenkinjoho.RoreiFukushiNenkinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;

/**
 *
 * @author LINGHUHANG
 */
public interface RoreiFukushiNenkinJohoMapper {

    /**
     * 受給開始年月日の重複チェック
     *
     * @param params
     * @return
     */
    List<DbT7006RoreiFukushiNenkinJukyushaEntity> checkSameJukyuKaishibi(RoreiFukushiNenkinJohoMapperParameter params);

}
