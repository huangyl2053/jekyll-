/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fukajoho.KibetsuMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity;

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

    /**
     * 主キー1に合致する介護期別のリストを取得します。
     *
     * @param 介護期別検索条件 介護期別検索条件
     * @return KibetsuEntityの{@code list}
     */
    List<KibetsuEntity> select介護期別リストBy主キー1(KibetsuMapperParameter 介護期別検索条件);
}
