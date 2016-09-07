/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.renrakuhyodatacreator;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 介護保険連絡票作成のBusinessクラスです。
 *
 * @reamsid_L DBA-1290-020 linghuhang
 */
public class KyufuJissekiKihonBuseiness {

    private final DbT3017KyufujissekiKihonEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity DbT3017KyufujissekiKihonEntity
     */
    public KyufuJissekiKihonBuseiness(DbT3017KyufujissekiKihonEntity entity) {
        this.entity = entity;
    }

    /**
     * サービス提供年月を取得します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
    }
}
