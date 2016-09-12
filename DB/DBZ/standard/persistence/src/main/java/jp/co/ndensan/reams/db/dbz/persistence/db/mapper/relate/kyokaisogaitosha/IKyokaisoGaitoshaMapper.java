/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.kyokaisogaitosha;

import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.kyokaisogaitosha.KyokaisoMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoshaEntity;

/**
 * 境界層該当者のマッパーインタフェースです。
 *
 * @reamsid_L DBA-9999-013 huangh
 */
public interface IKyokaisoGaitoshaMapper {

    /**
     * 境界層該当者情報をキー検索で１件取得します。
     *
     * @param 境界層該当者検索条件 境界層該当者検索条件
     * @return KyokaisoGaitoshaEntity
     */
    KyokaisoGaitoshaEntity select境界層該当者ByKey(KyokaisoMapperParameter 境界層該当者検索条件);

}
