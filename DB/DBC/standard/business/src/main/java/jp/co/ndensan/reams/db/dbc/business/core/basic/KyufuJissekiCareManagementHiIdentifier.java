/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Value;

/**
 * 給付実績ケアマネジメント費の識別子です。
 */
@Value
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiCareManagementHiIdentifier implements Serializable {

    private final KokanShikibetsuNo 交換情報識別番号;
    private final NyuryokuShikibetsuNo 入力識別番号;
    private final RString レコード種別コード;
    private final HokenshaNo 証記載保険者番号;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final JigyoshaNo 事業所番号;
    private final RString 指定_基準該当事業所区分コード;
    private final FlexibleDate 居宅サービス計画作成依頼届出年月日;
    private final RString 通し番号;
    private final RString サービス計画費明細行番号;

    /**
     * コンストラクタです。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 入力識別番号 入力識別番号
     * @param レコード種別コード レコード種別コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号 事業所番号
     * @param 指定_基準該当事業所区分コード 指定／基準該当事業所区分コード
     * @param 居宅サービス計画作成依頼届出年月日 居宅サービス計画作成依頼届出年月日
     * @param 通し番号 通し番号
     * @param サービス計画費明細行番号 サービス計画費明細行番号
     */
    public KyufuJissekiCareManagementHiIdentifier(KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 指定_基準該当事業所区分コード,
            FlexibleDate 居宅サービス計画作成依頼届出年月日,
            RString 通し番号,
            RString サービス計画費明細行番号) {
        this.交換情報識別番号 = 交換情報識別番号;
        this.入力識別番号 = 入力識別番号;
        this.レコード種別コード = レコード種別コード;
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.事業所番号 = 事業所番号;
        this.指定_基準該当事業所区分コード = 指定_基準該当事業所区分コード;
        this.居宅サービス計画作成依頼届出年月日 = 居宅サービス計画作成依頼届出年月日;
        this.通し番号 = 通し番号;
        this.サービス計画費明細行番号 = サービス計画費明細行番号;
    }
}
