/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC050022;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050021.FurikomimeisaiFurikomiDataProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込明細・振込みデータ作成（事業高額）のバッチパラメータです。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC050022_FurikomimeisaiFurikomiDataJigyoKogakuParameter extends BatchParameterBase {

    private static final String KEY_委託者コード = "委託者コード";
    private static final String KEY_代表金融機関コード = "代表金融機関コード";
    private static final String KEY_振込グループコード = "振込グループコード";
    private static final String KEY_処理区分 = "処理区分";
    private static final String KEY_振込指定年月日 = "振込指定年月日";
    private static final String KEY_再処理フラグ = "再処理フラグ";
    private static final String KEY_誤振込指定年月日 = "誤振込指定年月日";
    private static final String KEY_正振込指定年月日 = "正振込指定年月日";
    private static final String KEY_支払方法 = "支払方法";
    private static final String KEY_開始年月日 = "開始年月日";
    private static final String KEY_終了年月日 = "終了年月日";
    private static final String KEY_開始受取年月 = "開始受取年月";
    private static final String KEY_終了受取年月 = "終了受取年月";
    private static final String KEY_抽出対象 = "抽出対象";
    private static final String KEY_対象作成年月日 = "対象作成年月日";
    private static final String KEY_出力順ID = "出力順ID";

    @BatchParameter(key = KEY_委託者コード, name = "委託者コード")
    private RString 委託者コード;
    @BatchParameter(key = KEY_代表金融機関コード, name = "代表金融機関コード")
    private KinyuKikanCode 代表金融機関コード;
    @BatchParameter(key = KEY_振込グループコード, name = "振込グループコード")
    private RString 振込グループコード;
    @BatchParameter(key = KEY_処理区分, name = "処理区分")
    private RString 処理区分;
    @BatchParameter(key = KEY_振込指定年月日, name = "振込指定年月日")
    private RDate 振込指定年月日;
    @BatchParameter(key = KEY_再処理フラグ, name = "再処理フラグ")
    private boolean 再処理フラグ;
    @BatchParameter(key = KEY_誤振込指定年月日, name = "誤振込指定年月日")
    private RDate 誤振込指定年月日;
    @BatchParameter(key = KEY_正振込指定年月日, name = "正振込指定年月日")
    private RDate 正振込指定年月日;
    @BatchParameter(key = KEY_支払方法, name = "支払方法")
    private RString 支払方法;
    @BatchParameter(key = KEY_開始年月日, name = "開始年月日")
    private FlexibleDate 開始年月日;
    @BatchParameter(key = KEY_終了年月日, name = "終了年月日")
    private FlexibleDate 終了年月日;
    @BatchParameter(key = KEY_開始受取年月, name = "開始受取年月")
    private FlexibleYearMonth 開始受取年月;
    @BatchParameter(key = KEY_終了受取年月, name = "終了受取年月")
    private FlexibleYearMonth 終了受取年月;
    @BatchParameter(key = KEY_抽出対象, name = "抽出対象")
    private RString 抽出対象;
    @BatchParameter(key = KEY_対象作成年月日, name = "対象作成年月日")
    private FlexibleDate 対象作成年月日;
    @BatchParameter(key = KEY_出力順ID, name = "出力順ID")
    private RString 出力順ID;

    /**
     * processParameterを取得する。
     *
     * @return processParameter FurikomimeisaiFurikomiDataProcessParameter
     */
    public FurikomimeisaiFurikomiDataProcessParameter toProcessParameter() {
        return new FurikomimeisaiFurikomiDataProcessParameter(
                支払方法, 抽出対象, 対象作成年月日, 再処理フラグ, 開始年月日, 終了年月日, 開始受取年月, 終了受取年月,
                振込指定年月日, 処理区分, 誤振込指定年月日, 正振込指定年月日, 委託者コード);
    }
}
