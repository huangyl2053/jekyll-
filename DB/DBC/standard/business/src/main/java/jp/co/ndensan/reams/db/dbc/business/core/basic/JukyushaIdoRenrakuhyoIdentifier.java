/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import lombok.Value;

/**
 * 受給者異動送付の識別子です。
 */
@Value
public class JukyushaIdoRenrakuhyoIdentifier implements Serializable {

    private final FlexibleDate 異動年月日;
    private final RString 異動区分コード;
    private final RString 受給者異動事由;
    private final HokenshaNo 証記載保険者番号;
    private final HihokenshaNo 被保険者番号;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 異動年月日 異動年月日
     * @param 異動区分コード 異動区分コード
     * @param 受給者異動事由 受給者異動事由
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public JukyushaIdoRenrakuhyoIdentifier(FlexibleDate 異動年月日,
RString 異動区分コード,
RString 受給者異動事由,
HokenshaNo 証記載保険者番号,
HihokenshaNo 被保険者番号,
Decimal 履歴番号) {
        this.異動年月日 = 異動年月日;
        this.異動区分コード = 異動区分コード;
        this.受給者異動事由 = 受給者異動事由;
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.履歴番号 = 履歴番号;
    }
}
