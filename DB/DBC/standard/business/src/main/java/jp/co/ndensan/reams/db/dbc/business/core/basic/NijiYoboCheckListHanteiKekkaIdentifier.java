/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import lombok.Value;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 二次予防チェックリスト判定結果の識別子です。
 */
@Value
public class NijiYoboCheckListHanteiKekkaIdentifier implements Serializable {

    private final ShikibetsuCode 識別コード;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleDate 受付年月日;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 受付年月日 受付年月日
     * @param 履歴番号 履歴番号
     */
    public NijiYoboCheckListHanteiKekkaIdentifier(ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号,
            FlexibleDate 受付年月日,
            Decimal 履歴番号) {
        this.識別コード = 識別コード;
        this.被保険者番号 = 被保険者番号;
        this.受付年月日 = 受付年月日;
        this.履歴番号 = 履歴番号;
    }
}
