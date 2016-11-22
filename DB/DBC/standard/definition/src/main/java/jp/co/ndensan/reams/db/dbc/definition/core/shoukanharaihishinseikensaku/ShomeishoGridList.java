/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 証明書グリッドListクラスです
 *
 * @reamsid_L DBC-1030-130 chenxin
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShomeishoGridList {

    private RString 処理;
    private JigyoshaNo 事業者番号;
    private RString 事業者名;
    private RString 明細;
    private RString サービス提供証明書;
    private RString 処理区分;
}
