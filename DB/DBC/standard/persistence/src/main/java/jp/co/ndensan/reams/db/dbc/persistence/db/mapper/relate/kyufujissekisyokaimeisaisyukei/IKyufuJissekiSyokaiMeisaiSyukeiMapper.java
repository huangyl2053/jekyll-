/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufujissekisyokaimeisaisyukei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekisyokaimeisaisyukei.KyufuJissekiSyokaiMeisaiSyukeiEntity;

/**
 * 給付実績照会_明細集計画面処理のインタフェースクラスです。
 *
 * @reamsid_L DBC-2970-040 zhaoyao
 */
public interface IKyufuJissekiSyokaiMeisaiSyukeiMapper {

    /**
     * 保険者情報を取得します。
     *
     * @return List<KyufuJissekiSyokaiMeisaiSyukeiEntity>
     */
    List<KyufuJissekiSyokaiMeisaiSyukeiEntity> get保険者情報();
}
