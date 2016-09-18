/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査員情報ＩＦのcsv情報。
 *
 * @reamsid_L DBD-2100-020 liwul
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosainEntity {

    private ChosaItakusakiCode 認定調査委託先コード;
    private ChosainCode 認定調査員コード;
    private RString 調査員氏名;
    private RString 調査員氏名カナ;
    private RString 調査員資格;
    private boolean 状況フラグ;
}
