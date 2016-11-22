/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshasearch;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;

/**
 *
 * 市町村特別給付・サービス事業者を管理するクラスです。
 *
 * @reamsid_L DBC-3430-010 liuwei2
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class TokubetsuKyufuJigyoshaSearchIdentifier implements Serializable {

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
    public TokubetsuKyufuJigyoshaSearchIdentifier(JigyoshaNo 市町村特別給付用事業者番号,
            ServiceCode 市町村特別給付用サービスコード,
            int 履歴番号) {
        this.市町村特別給付用事業者番号 = 市町村特別給付用事業者番号;
        this.市町村特別給付用サービスコード = 市町村特別給付用サービスコード;
        this.履歴番号 = 履歴番号;
    }
}
