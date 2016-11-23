/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijiari;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票設計_DBCMN43002_高額サービス等支給（不支給）決定通知書((支払予定日あり))のEntityクラスです。
 *
 * @reamsid_L DBC-2000-040 zhengshenlei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity {

    private HihokenshaNo 被保険者番号;
    private boolean テスト出力フラグ;
    private RString 被保険者氏名;
    private RDate 受付年月日;
    private RDate 決定年月日;
    private Decimal 本人支払額;
    private FlexibleYearMonth 対象年月;
    private RString 給付の種類;
    private RString 支給_不支給決定区分;
    private Decimal 決定額;
    private Decimal 支給金額;
    private RString 不支給理由;
    private RString 窓口払;
    private RString 口座払;
    private RString 金融機関;
    private RString 支給_不支給区分;
    private RString お持ちいただくもの１;
    private RString お持ちいただくもの２;
    private RString お持ちいただくもの３;
    private RString 支払方法区分;
    private RString 支払場所;
    private RDate 支払期間;
    private RDate 支払期間開始年月日;
    private RDate 支払期間終了年月日;
    private RString 支払窓口開始時間;
    private RString 支払窓口終了時間;
    private RString 金融機関上段;
    private RString 金融機関下段;
    private RString 支払方法;
    private RString 口座種別;
    private RString 通帳記号;
    private RString 口座番号;
    private RString 通帳番号;
    private boolean ゆうちょ銀行フラグ;
    private RString 口座名義人;
    private RDate 支払予定日;
    private RString 決定通知書番号;
    private Decimal 支給額;
    private RString 文書番号;
    private ShikibetsuCode 識別コード;

}
