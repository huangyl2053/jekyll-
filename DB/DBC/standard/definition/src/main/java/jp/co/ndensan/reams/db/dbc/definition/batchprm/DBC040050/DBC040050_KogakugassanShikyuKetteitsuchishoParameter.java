/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC040050;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBCMN63004_高額合算支給決定通知書（一括）
 *
 * @reamsid_L DBC-2300-010 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC040050_KogakugassanShikyuKetteitsuchishoParameter extends BatchParameterBase {

    private static final String KEY_日付選択区分 = "日付選択区分";
    private static final String KEY_受取年月 = "受取年月";
    private static final String KEY_申請開始年月日 = "申請開始年月日";
    private static final String KEY_申請終了年月日 = "申請終了年月日";
    private static final String KEY_決定開始年月日 = "決定開始年月日";
    private static final String KEY_決定終了年月日 = "決定終了年月日";
    private static final String KEY_印書区分 = "印書区分";
    private static final String KEY_改頁出力順ID = "改頁出力順ID";
    private static final String KEY_発行日 = "発行日";
    private static final String KEY_支払予定日印字有無 = "支払予定日印字有無";
    private static final String KEY_支払予定日 = "支払予定日";
    private static final String KEY_決定日一括更新区分 = "決定日一括更新区分";
    private static final String KEY_決定日 = "決定日";
    private static final String KEY_文書番号 = "文書番号";
    private static final String KEY_処理日時 = "処理日時";
    @BatchParameter(key = KEY_日付選択区分, name = "日付選択区分")
    private RString 日付選択区分;
    @BatchParameter(key = KEY_受取年月, name = "受取年月")
    private FlexibleYearMonth 受取年月;
    @BatchParameter(key = KEY_申請開始年月日, name = "申請開始年月日")
    private FlexibleDate 申請開始年月日;
    @BatchParameter(key = KEY_申請終了年月日, name = "申請終了年月日")
    private FlexibleDate 申請終了年月日;
    @BatchParameter(key = KEY_決定開始年月日, name = "決定開始年月日")
    private FlexibleDate 決定開始年月日;
    @BatchParameter(key = KEY_決定終了年月日, name = "決定終了年月日")
    private FlexibleDate 決定終了年月日;
    @BatchParameter(key = KEY_印書区分, name = "印書区分")
    private RString 印書区分;
    @BatchParameter(key = KEY_改頁出力順ID, name = "改頁出力順ID")
    private RString 改頁出力順ID;
    @BatchParameter(key = KEY_発行日, name = "発行日")
    private FlexibleDate 発行日;
    @BatchParameter(key = KEY_支払予定日印字有無, name = "支払予定日印字有無")
    private RString 支払予定日印字有無;
    @BatchParameter(key = KEY_支払予定日, name = "支払予定日")
    private FlexibleDate 支払予定日;
    @BatchParameter(key = KEY_決定日一括更新区分, name = "決定日一括更新区分")
    private RString 決定日一括更新区分;
    @BatchParameter(key = KEY_決定日, name = "決定日")
    private FlexibleDate 決定日;
    @BatchParameter(key = KEY_文書番号, name = "文書番号")
    private RString 文書番号;
    @BatchParameter(key = KEY_処理日時, name = "処理日時")
    private YMDHMS 処理日時;
}
