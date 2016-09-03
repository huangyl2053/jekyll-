/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC020070;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 画面設計_DBCMNN1004_事業分支給額計算のParameter
 *
 * @reamsid_L DBC-4830-010 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC020070_JigyobunShikyugakuKeisanParameter extends BatchParameterBase {

    private static final String KEY_年度 = "年度";
    private static final String KEY_出力対象区分 = "出力対象区分";
    private static final String KEY_被保険者番号 = "被保険者番号";
    private static final String KEY_受取年月 = "受取年月";
    private static final String KEY_処理日 = "処理日";
    private static final String KEY_処理時間 = "処理時間";
    private static final String KEY_決定年月日 = "決定年月日";
    private static final String KEY_窓口払開始年月日 = "窓口払開始年月日";
    private static final String KEY_窓口払開始時刻 = "窓口払開始時刻";
    private static final String KEY_窓口払終了年月日 = "窓口払終了年月日";
    private static final String KEY_窓口払終了時刻 = "窓口払終了時刻";
    private static final String KEY_出力順ID = "出力順ID";
    @BatchParameter(key = KEY_年度, name = "年度")
    private FlexibleYear 年度;
    @BatchParameter(key = KEY_出力対象区分, name = "出力対象区分")
    private RString 出力対象区分;
    @BatchParameter(key = KEY_被保険者番号, name = "被保険者番号")
    private HihokenshaNo 被保険者番号;
    @BatchParameter(key = KEY_受取年月, name = "受取年月")
    private FlexibleYearMonth 受取年月;
    @BatchParameter(key = KEY_処理日, name = "処理日")
    private FlexibleDate 処理日;
    @BatchParameter(key = KEY_処理時間, name = "処理時間")
    private RTime 処理時間;
    @BatchParameter(key = KEY_決定年月日, name = "決定年月日")
    private FlexibleDate 決定年月日;
    @BatchParameter(key = KEY_窓口払開始年月日, name = "窓口払開始年月日")
    private FlexibleDate 窓口払開始年月日;
    @BatchParameter(key = KEY_窓口払開始時刻, name = "窓口払開始時刻")
    private RTime 窓口払開始時刻;
    @BatchParameter(key = KEY_窓口払終了年月日, name = "窓口払終了年月日")
    private FlexibleDate 窓口払終了年月日;
    @BatchParameter(key = KEY_窓口払終了時刻, name = "窓口払終了時刻")
    private RTime 窓口払終了時刻;
    @BatchParameter(key = KEY_出力順ID, name = "出力順ID")
    private Long 出力順ID;

}
