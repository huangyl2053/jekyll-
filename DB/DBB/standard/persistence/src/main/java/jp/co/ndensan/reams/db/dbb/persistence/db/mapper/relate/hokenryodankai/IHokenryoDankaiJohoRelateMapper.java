/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.hokenryodankai;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.hokenryodankai.HokenryoDankaiJohoRelateMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hokenryodankai.HokenryoDankaiJohoRelateEntity;

/**
 * 保険料ランクの情報のマッパーインタフェースです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public interface IHokenryoDankaiJohoRelateMapper {

    /**
     * 保険料ランクの情報情報をキー検索で１件取得します。
     *
     * @param 保険料ランクの情報検索条件 保険料ランクの情報検索条件
     * @return HokenryoDankaiJohoRelateEntity
     */
    HokenryoDankaiJohoRelateEntity select保険料ランクの情報ByKey(HokenryoDankaiJohoRelateMapperParameter 保険料ランクの情報検索条件);

}
