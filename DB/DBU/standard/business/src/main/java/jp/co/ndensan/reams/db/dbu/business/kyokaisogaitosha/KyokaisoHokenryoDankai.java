/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.kyokaisogaitosha;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1007KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 境界層保険料段階情報を管理するビジネスです。
 */
public class KyokaisoHokenryoDankai {

    private final DbT1007KyokaisoHokenryoDankaiEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 境界層保険料段階情報Entity
     */
    public KyokaisoHokenryoDankai(DbT1007KyokaisoHokenryoDankaiEntity entity) {
        this.entity = entity;
    }

    /**
     * 適用開始年月を取得します。
     *
     * @return 適用開始年月
     */
    public FlexibleYearMonth get適用開始年月() {
        return entity.getTekiyoKaishiYM();
    }

    /**
     * 適用終了年月を取得します。
     *
     * @return 適用終了年月
     */
    public FlexibleYearMonth get適用終了年月() {
        return entity.getTekiyoShuryoYM();
    }

    /**
     * 保険料納付減額後保険料段階を取得します。
     *
     * @return 保険料納付減額後保険料段階
     */
    public RString get保険料納付減額後保険料段階() {
        return entity.getGengakuGoHokenryoDankai();
    }
}
