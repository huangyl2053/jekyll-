/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufujissekisyokaimeisaisyukei;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekisyokaimeisaisyukei.KyufuJissekiSyokaiMeisaiSyukeiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績照会_明細集計画面処理Businessクラスです。
 *
 * @reamsid_L DBC-2970-040 zhaoyao
 */
public class KyufuJissekiSyokaiMeisaiSyukeiBusiness {

    private final KyufuJissekiSyokaiMeisaiSyukeiEntity entity;

    /**
     * コンストラクタです
     *
     * @param entity 給付実績照会_明細集計画面処理のEntit
     */
    public KyufuJissekiSyokaiMeisaiSyukeiBusiness(KyufuJissekiSyokaiMeisaiSyukeiEntity entity) {
        this.entity = entity;
    }

    /**
     * 保険者種別を取得します。
     *
     * @return 保険者種別
     */
    public RString get保険者種別() {
        return entity.getHokenjaShubetsu();
    }

    /**
     * 保険者番号を取得します。
     *
     * @return 保険者番号
     */
    public RString get保険者番号() {
        return entity.getHokenjaNo();
    }

    /**
     * 保険者名を取得します。
     *
     * @return 保険者名
     */
    public RString get保険者名() {
        return entity.getHokenjaName();
    }
}
