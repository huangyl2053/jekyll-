/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.InputShikibetsuNoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付実績集計のデータアクセスインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IKyufuJissekiShukeiDac extends
        IReplaceable<DbT3033KyufujissekiShukeiEntity>,
        IDeletable<DbT3033KyufujissekiShukeiEntity> {

    /**
     * 引数の条件に該当する給付実績集計エンティティを取得します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 入力識別番号 入力識別番号
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保番号 被保番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号 事業所番号
     * @param 通番 通番
     * @return 給付実績集計エンティティ
     */
    @Transaction
    List<DbT3033KyufujissekiShukeiEntity> select(
            KokanShikibetsuNo 交換情報識別番号,
            InputShikibetsuNoCode 入力識別番号,
            ShoKisaiHokenshaNo 証記載保険者番号,
            KaigoHihokenshaNo 被保番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            ToshiNo 通番);
}
