/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 納入通知書期情報です。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NonyuTsuchiShoKiJoho {

    private int 銀振印字位置;
    private int コンビニ連帳印字位置;
    private int コンビニカット印字位置;
    private int ブック開始位置;
    private int 期;
    private Tsuki 月;
    private RString 期表記;
    private RString 月表記;
    private RString 随時表記;
    private RString 科目名称;
    private RDate 納期開始日;
    private RString 納期開始日表記;
    private RDate 納期終了日;
    private RString 納期終了日表記;
    private RDate 納期限;
    private RString 納期限表記;
    private Decimal 納付額;
    private RString 納付額表記;
    private Decimal 調定額;
    private RString 調定額表記;
    private Decimal 収入額;
    private RString 収入額表記;
    private Decimal 差額;
    private RString 差額表記;
    private RString 収納機関番号表示用;
    private RString 納付番号;
    private RString 確認番号;
    private RString 納付区分;
    private RString OCRID;
    private Map<Integer, RString> OCR;
    private RString バーコード情報;
    private RString バーコード情報上段;
    private RString バーコード情報下段;
    private RDate コンビニ支払期限;
    private RString 領収証書納付額欄;
    private RString 納付書納付額欄;
    private RString 領収証書領収印欄;
    private RString 納付書領収印欄;
    private RString 領収日付印欄;
    private RString 領収日付欄;
    private RString 領収書日付欄期月;

}
