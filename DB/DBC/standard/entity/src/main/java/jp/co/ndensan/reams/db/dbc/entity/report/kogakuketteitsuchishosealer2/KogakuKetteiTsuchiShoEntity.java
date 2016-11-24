/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer2;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票情報 Entityクラスです。
 *
 * @reamsid_L DBC-2000-070 lijian
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KogakuKetteiTsuchiShoEntity {

    private ShikibetsuCode 識別コード;
    private boolean テスト出力フラグ;
    private boolean 自動償還対象フラグ;
    private boolean ゆうちょ銀行フラグ;
    private RString 被保険者氏名;
    private HihokenshaNo 被保険者番号;
    private FlexibleDate 受付年月日;
    private FlexibleYearMonth 対象年月1;
    private FlexibleYearMonth 提供年月;
    private FlexibleDate 決定年月日;
    private Decimal 本人支払額;
    private Decimal 支払金額合計;
    private FlexibleYearMonth 対象年月;
    private RString 給付の種類;
    private RString 支給結果;
    private Decimal 決定額;
    private Decimal 支給金額;
    private RString 不支給理由;
    private RString 窓口払;
    private RString 口座払;
    private RString 金融機関;
    private RString お持ちいただくもの１;
    private RString お持ちいただくもの２;
    private RString お持ちいただくもの３;
    private RString 支払場所;
    private FlexibleDate 支払期間;
    private FlexibleDate 支払期間開始年月日;
    private FlexibleDate 支払期間終了年月日;
    private RString 支払窓口開始時間;
    private RString 支払窓口終了時間;
    private RString 金融機関コード;
    private RString 口座種別;
    private RString 通帳記号;
    private RString 通帳番号;
    private RString 口座名義人;
    private RString 口座番号;
    private FlexibleDate 支払予定日;
    private RString 決定通知書番号;
    private RString 支払方法区分;
    private Decimal 支給金額1;
    private RString 金融機関上段;
    private RString 金融機関下段;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private RString 支給不支給決定区分;
}
