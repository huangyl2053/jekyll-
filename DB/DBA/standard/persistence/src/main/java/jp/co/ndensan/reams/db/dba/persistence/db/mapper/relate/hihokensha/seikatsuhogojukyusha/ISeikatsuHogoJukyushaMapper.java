/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokensha.seikatsuhogojukyusha;

import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaMapperParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;

/**
 * 生活保護受給者のマッパーインタフェースです。
 */
public interface ISeikatsuHogoJukyushaMapper {

    /**
     * 生活保護受給者情報をキー検索で１件取得します。
     *
     * @param 生活保護受給者検索条件 生活保護受給者検索条件
     * @return SeikatsuHogoJukyushaEntity
     */
    SeikatsuHogoJukyushaRelateEntity select生活保護受給者ByKey(SeikatsuHogoJukyushaMapperParameter 生活保護受給者検索条件);
}
