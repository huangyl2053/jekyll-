/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import lombok.Value;

/**
 * 給付管理票200004の識別子です。
 */
@Value
public class KyufuKanrihyo200004Identifier implements Serializable {

    private final FlexibleYearMonth 審査年月;
    private final FlexibleYearMonth サービス提供年月;
    private final HokenshaNo 証記載保険者番号;
    private final JigyoshaNo 居宅支援事業所番号;
    private final RString 給付管理票情報作成区分コード;
    private final FlexibleDate 給付管理票作成年月日;
    private final RString 給付管理票種別区分コード;
    private final RString 給付管理票明細行番号;

    /**
     * コンストラクタです。
     *
     * @param 審査年月 審査年月
     * @param サービス提供年月 サービス提供年月
     * @param 証記載保険者番号 証記載保険者番号
     * @param 居宅支援事業所番号 居宅支援事業所番号
     * @param 給付管理票情報作成区分コード 給付管理票情報作成区分コード
     * @param 給付管理票作成年月日 給付管理票作成年月日
     * @param 給付管理票種別区分コード 給付管理票種別区分コード
     * @param 給付管理票明細行番号 給付管理票明細行番号
     */
    public KyufuKanrihyo200004Identifier(FlexibleYearMonth 審査年月,
FlexibleYearMonth サービス提供年月,
HokenshaNo 証記載保険者番号,
JigyoshaNo 居宅支援事業所番号,
RString 給付管理票情報作成区分コード,
FlexibleDate 給付管理票作成年月日,
RString 給付管理票種別区分コード,
RString 給付管理票明細行番号) {
        this.審査年月 = 審査年月;
        this.サービス提供年月 = サービス提供年月;
        this.証記載保険者番号 = 証記載保険者番号;
        this.居宅支援事業所番号 = 居宅支援事業所番号;
        this.給付管理票情報作成区分コード = 給付管理票情報作成区分コード;
        this.給付管理票作成年月日 = 給付管理票作成年月日;
        this.給付管理票種別区分コード = 給付管理票種別区分コード;
        this.給付管理票明細行番号 = 給付管理票明細行番号;
    }
}
