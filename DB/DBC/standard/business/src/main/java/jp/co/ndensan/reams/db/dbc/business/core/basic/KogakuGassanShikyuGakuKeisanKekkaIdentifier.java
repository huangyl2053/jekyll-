/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import lombok.Value;

/**
 * 高額合算支給額計算結果の識別子です。
 */
@Value
public class KogakuGassanShikyuGakuKeisanKekkaIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYear 対象年度;
    private final HokenshaNo 証記載保険者番号;
    private final RString 支給申請書整理番号;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年度 対象年度
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支給申請書整理番号 支給申請書整理番号
     * @param 履歴番号 履歴番号
     */
    public KogakuGassanShikyuGakuKeisanKekkaIdentifier(HihokenshaNo 被保険者番号,
FlexibleYear 対象年度,
HokenshaNo 証記載保険者番号,
RString 支給申請書整理番号,
Decimal 履歴番号) {
        this.被保険者番号 = 被保険者番号;
        this.対象年度 = 対象年度;
        this.証記載保険者番号 = 証記載保険者番号;
        this.支給申請書整理番号 = 支給申請書整理番号;
        this.履歴番号 = 履歴番号;
    }
}
