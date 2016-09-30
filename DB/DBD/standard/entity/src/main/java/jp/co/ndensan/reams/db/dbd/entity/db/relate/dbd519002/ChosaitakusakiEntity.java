/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査委託先情報ＩＦのcsv情報。
 *
 * @reamsid_L DBD-2100-020 liwul
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaitakusakiEntity {

    private ChosaItakusakiCode 認定調査委託先コード;
    private RString 事業者名称;
    private RString 事業者名称カナ;
    private YubinNo 郵便番号;
    private RString 住所;
    private TelNo 電話番号;
    private RString 調査委託区分;
    private boolean 状況フラグ;
}
