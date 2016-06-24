/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.roreifukushinenkinjoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;

/**
 * 【共有子Div】 老齢福祉年金Mapperです。
 *
 * @reamsid_L DBD-3560-090 wangjie2
 */
public interface IRoreiFukushiNenkinJohoMapper {

    /**
     * 老齢福祉年金情報の取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<DbT7006RoreiFukushiNenkinJukyushaEntity>
     */
    List<DbT7006RoreiFukushiNenkinJukyushaEntity> get老齢福祉年金情報(HihokenshaNo 被保険者番号);

}
