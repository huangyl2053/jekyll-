/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.shoukanbaraisuuchishoikkatsusakusei;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 償還払い支給（不支給）決定通知書作成画面divEntityクラスです。
 *
 * @reamsid_L DBC-1000-070 lizhuoxuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoukanBaraiSuuchiShoIkatsuParamter {

    private RString 抽出モード;
    private RDate 決定日付From;
    private RDate 決定日付To;
    private RDate 受付日付From;
    private RDate 受付日付To;
    private RYearMonth 決定者受付年月;
    private RString 印書;
    private RDate 発行日;
    private RString 文書番号;
    private RString テスト出力フラグ;
    private RString 決定日一括更新区分;
    private RDate 決定日;
    private RString 利用者向け決定通知書フラグ;
    private RString 受領委任者向け決定通知書フラグ;
    private RDate 振込予定日;
    private RString 支払場所;
    private RDate 支払期間From;
    private RDate 支払期間To;
    private RTime 開始時間;
    private RTime 終了時間;
    private RString 出力順ID;
    private RString 窓口払い一括更新区分;
}
