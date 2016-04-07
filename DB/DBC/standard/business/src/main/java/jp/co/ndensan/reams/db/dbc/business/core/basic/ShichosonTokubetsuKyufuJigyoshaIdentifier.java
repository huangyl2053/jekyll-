/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import lombok.Value;

/**
 * 市町村特別給付サービス事業者の識別子です。
 */
@Value
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShichosonTokubetsuKyufuJigyoshaIdentifier implements Serializable {

    private final JigyoshaNo 市町村特別給付用事業者番号;
    private final ServiceCode 市町村特別給付用サービスコード;
    private final int 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 市町村特別給付用事業者番号 市町村特別給付用事業者番号
     * @param 市町村特別給付用サービスコード 市町村特別給付用サービスコード
     * @param 履歴番号 履歴番号
     */
    public ShichosonTokubetsuKyufuJigyoshaIdentifier(JigyoshaNo 市町村特別給付用事業者番号,
            ServiceCode 市町村特別給付用サービスコード,
            int 履歴番号) {
        this.市町村特別給付用事業者番号 = 市町村特別給付用事業者番号;
        this.市町村特別給付用サービスコード = 市町村特別給付用サービスコード;
        this.履歴番号 = 履歴番号;
    }
}
