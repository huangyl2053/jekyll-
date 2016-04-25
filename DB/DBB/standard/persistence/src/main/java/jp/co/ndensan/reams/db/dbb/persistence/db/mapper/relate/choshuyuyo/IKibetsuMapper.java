/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.choshuyuyo;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choshuyuyo.KibetsuMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choshuyuyo.KibetsuEntity;

/**
 * 介護期別のマッパーインタフェースです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public interface IKibetsuMapper {

    /**
     * 介護期別情報をキー検索で１件取得します。
     *
     * @param 介護期別検索条件 介護期別検索条件
     * @return KibetsuEntity
     */
    KibetsuEntity select介護期別ByKey(KibetsuMapperParameter 介護期別検索条件);

}
