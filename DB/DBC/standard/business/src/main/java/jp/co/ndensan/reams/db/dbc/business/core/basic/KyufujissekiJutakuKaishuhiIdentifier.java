/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import lombok.Value;

/**
 * 給付実績住宅改修費の識別子です。
 */
@Value
public class KyufujissekiJutakuKaishuhiIdentifier implements Serializable {

    private final KokanShikibetsuCode 交換情報識別番号;
    private final NyuryokuShikibetsuCode 入力識別番号;
    private final RString レコード種別コード;
    private final HokenshaNo 証記載保険者番号;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final JigyoshaNo 事業所番号;
    private final RString 通し番号;
    private final RString 明細番号;

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
     * @param 通し番号 通し番号
     * @param 明細番号 明細番号
     */
    public KyufujissekiJutakuKaishuhiIdentifier(KokanShikibetsuCode 交換情報識別番号,
NyuryokuShikibetsuCode 入力識別番号,
RString レコード種別コード,
HokenshaNo 証記載保険者番号,
HihokenshaNo 被保険者番号,
FlexibleYearMonth サービス提供年月,
JigyoshaNo 事業所番号,
RString 通し番号,
RString 明細番号) {
        this.交換情報識別番号 = 交換情報識別番号;
        this.入力識別番号 = 入力識別番号;
        this.レコード種別コード = レコード種別コード;
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.事業所番号 = 事業所番号;
        this.通し番号 = 通し番号;
        this.明細番号 = 明細番号;
    }
}
