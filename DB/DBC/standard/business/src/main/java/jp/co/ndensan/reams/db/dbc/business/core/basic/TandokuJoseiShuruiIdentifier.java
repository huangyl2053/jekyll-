/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import lombok.Value;

/**
 * 市町村単独助成種類の識別子です。
 */
@Value
public class TandokuJoseiShuruiIdentifier implements Serializable {

    private final RString 市町村単独助成種類;
    private final ServiceShuruiCode 助成サービス種類コード;
    private final FlexibleYearMonth 適用開始年月;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 市町村単独助成種類 市町村単独助成種類
     * @param 助成サービス種類コード 助成サービス種類コード
     * @param 適用開始年月 適用開始年月
     * @param 履歴番号 履歴番号
     */
    public TandokuJoseiShuruiIdentifier(RString 市町村単独助成種類,
ServiceShuruiCode 助成サービス種類コード,
FlexibleYearMonth 適用開始年月,
Decimal 履歴番号) {
        this.市町村単独助成種類 = 市町村単独助成種類;
        this.助成サービス種類コード = 助成サービス種類コード;
        this.適用開始年月 = 適用開始年月;
        this.履歴番号 = 履歴番号;
    }
}
