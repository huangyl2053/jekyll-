/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import lombok.Value;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 二次予防任意チェックリストの識別子です。
 */
@Value
public class NijiYoboNiniCheckListIdentifier implements Serializable {

    private final ShikibetsuCode 識別コード;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleDate 受付年月日;
    private final Decimal 任意質問番号;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 受付年月日 受付年月日
     * @param 任意質問番号 任意質問番号
     * @param 履歴番号 履歴番号
     */
    public NijiYoboNiniCheckListIdentifier(ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号,
            FlexibleDate 受付年月日,
            Decimal 任意質問番号,
            Decimal 履歴番号) {
        this.識別コード = 識別コード;
        this.被保険者番号 = 被保険者番号;
        this.受付年月日 = 受付年月日;
        this.任意質問番号 = 任意質問番号;
        this.履歴番号 = 履歴番号;
    }
}
