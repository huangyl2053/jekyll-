/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import lombok.Value;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;

/**
 * 住宅改修理由書作成手数料請求集計の識別子です。
 */
@Value
public class JutakuKaishuRiyushoTesuryoShukeiIdentifier implements Serializable {

    private final HokenshaNo 証記載保険者番号;
    private final FlexibleYearMonth 集計開始年月;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 集計開始年月 集計開始年月
     * @param 履歴番号 履歴番号
     */
    public JutakuKaishuRiyushoTesuryoShukeiIdentifier(HokenshaNo 証記載保険者番号,
            FlexibleYearMonth 集計開始年月,
            Decimal 履歴番号) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.集計開始年月 = 集計開始年月;
        this.履歴番号 = 履歴番号;
    }
}
