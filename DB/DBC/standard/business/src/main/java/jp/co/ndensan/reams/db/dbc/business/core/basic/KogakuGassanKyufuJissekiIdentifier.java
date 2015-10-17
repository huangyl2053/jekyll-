/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import lombok.Value;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額合算給付実績の識別子です。
 */
@Value
public class KogakuGassanKyufuJissekiIdentifier implements Serializable {

    private final KokanShikibetsuNo 交換情報識別番号;
    private final HihokenshaNo 被保険者番号;
    private final RString 支給申請書整理番号;
    private final RString 整理番号;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 被保険者番号 被保険者番号
     * @param 支給申請書整理番号 支給申請書整理番号
     * @param 整理番号 整理番号
     * @param 履歴番号 履歴番号
     */
    public KogakuGassanKyufuJissekiIdentifier(KokanShikibetsuNo 交換情報識別番号,
            HihokenshaNo 被保険者番号,
            RString 支給申請書整理番号,
            RString 整理番号,
            Decimal 履歴番号) {
        this.交換情報識別番号 = 交換情報識別番号;
        this.被保険者番号 = 被保険者番号;
        this.支給申請書整理番号 = 支給申請書整理番号;
        this.整理番号 = 整理番号;
        this.履歴番号 = 履歴番号;
    }
}
