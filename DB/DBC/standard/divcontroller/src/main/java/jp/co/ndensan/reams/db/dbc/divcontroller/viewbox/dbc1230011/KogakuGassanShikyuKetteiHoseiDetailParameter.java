/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc1230011;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 画面設計_DBCMN62004_DBCMNN1005_支給決定情報補正（単）(事業分兼)
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShikyuKetteiHoseiDetailParameter implements Serializable {

    private RDate 対象計算期間開始年月日;
    private RDate 対象計算期間終了年月日;
    private RString 自己負担額証明書整理番号;
    private RDate 申請日;
    private RDate 決定日;
    private Decimal 自己負担総額;
    private RString 支給区分;
    private Decimal 支給額;
    private RString 給付の種類;
    private RString 備考;
    private RDate 受取年月;
    private RDate 決定通知書作成日;
    private RDate 振込明細書作成日;
    private RString 窓口払い_支払場所;
    private RString 窓口払い_開始日;
    private RString 窓口払い_開始時間;
    private RString 窓口払い_終了日;
    private RString 窓口払い_終了時間;
    private RString 口座払い_口座ＩＤ;
    private RString 受領委任払い_契約番号;

}
