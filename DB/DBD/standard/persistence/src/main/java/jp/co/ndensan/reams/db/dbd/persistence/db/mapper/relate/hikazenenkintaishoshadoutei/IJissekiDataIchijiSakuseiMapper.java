/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hikazenenkintaishoshadoutei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100202.JissekiDataIchijiSakuseiMybatisprmParamter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.JissekiDataIchijiSakuseiJohoEntity;

/**
 * 実績データ一時作成のマッパーインタフェースです。
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
public interface IJissekiDataIchijiSakuseiMapper {

    /**
     * 実績データ一情報を取得する
     *
     * @param 実績データ一時作成検索条件 実績データ一時作成検索条件
     * @return JissekiDataIchijiSakuseiJohoEntity
     */
    List<JissekiDataIchijiSakuseiJohoEntity> select実績データ一作成(JissekiDataIchijiSakuseiMybatisprmParamter 実績データ一時作成検索条件);
}
