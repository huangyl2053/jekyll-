/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc020030;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額サービス費支給決定通知書作成バッチパラメータクラスです。
 *
 * @reamsid_L DBC-2000-010 chenhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;
    
    private static final String TYUUSHUTU_MODEL = "抽出モード";
    @BatchParameter(key = TYUUSHUTU_MODEL, name = "抽出モード")
    private RString 抽出モード;

    private static final String TYUUSHUTU_DATE_FROM = "抽出条件日付From";
    @BatchParameter(key = TYUUSHUTU_DATE_FROM, name = "抽出条件日付From")
    private RDate 抽出条件日付From;

    private static final String TYUUSHUTU_DATE_TO = "抽出条件日付To";
    @BatchParameter(key = TYUUSHUTU_DATE_TO, name = "抽出条件日付To")
    private RDate 抽出条件日付To;

    private static final String KETTEISHAU_KETSUKE_YM = "決定者受付年月";
    @BatchParameter(key = KETTEISHAU_KETSUKE_YM, name = "決定者受付年月")
    private RDate 決定者受付年月;

    private static final String INNSHO = "印書";
    @BatchParameter(key = INNSHO, name = "印書")
    private RString 印書;

    private static final String KOGAKUJIDO_SYOKAN_TAISYO = "高額自動償還";
    @BatchParameter(key = KOGAKUJIDO_SYOKAN_TAISYO, name = "高額自動償還")
    private RString 高額自動償還;

    private static final String HAKKOBI = "発行日";
    @BatchParameter(key = HAKKOBI, name = "発行日")
    private RDate 発行日;

    private static final String SHIHARAI_YOTEI_YMD = "支払い予定日";
    @BatchParameter(key = SHIHARAI_YOTEI_YMD, name = "支払い予定日")
    private RDate 支払い予定日;

    private static final String BUNNSHO_NO = "文書番号";
    @BatchParameter(key = BUNNSHO_NO, name = "文書番号")
    private RString 文書番号;

    private static final String TEST_FLG = "テスト出力フラグ";
    @BatchParameter(key = TEST_FLG, name = "テスト出力フラグ")
    private RString テスト出力フラグ;

    private static final String KEQTEI_KUBUN = "決定日一括更新区分";
    @BatchParameter(key = KEQTEI_KUBUN, name = "決定日一括更新区分")
    private RString 決定日一括更新区分;

    private static final String KETTEIDATE = "決定日";
    @BatchParameter(key = KETTEIDATE, name = "決定日")
    private RDate 決定日;

    private static final String RIYOU_FLG = "利用者向け決定通知書フラグ";
    @BatchParameter(key = RIYOU_FLG, name = "利用者向け決定通知書フラグ")
    private RString 利用者向け決定通知書フラグ;

    private static final String JURYOU_FLG = "受領委任者向け決定通知書フラグ";
    @BatchParameter(key = JURYOU_FLG, name = "受領委任者向け決定通知書フラグ")
    private RString 受領委任者向け決定通知書フラグ;

    private static final String SHIHARAIHOHO = "支払方法";
    @BatchParameter(key = SHIHARAIHOHO, name = "支払方法")
    private RString 支払方法;

    private static final String FURIKOMI_KA = "振込予定日";
    @BatchParameter(key = FURIKOMI_KA, name = "振込予定日")
    private RDate 振込予定日;

    private static final String SHIHARAI_BASHO = "支払場所";
    @BatchParameter(key = SHIHARAI_BASHO, name = "支払場所")
    private RString 支払場所;

    private static final String SHIHARAI_FROM = "支払期間From";
    @BatchParameter(key = SHIHARAI_FROM, name = "支払期間From")
    private RDate 支払期間From;

    private static final String SHIHARAI_TO = "支払期間To";
    @BatchParameter(key = SHIHARAI_TO, name = "支払期間To")
    private RDate 支払期間To;

    private static final String KAISHI_JIKANN = "開始時間";
    @BatchParameter(key = KAISHI_JIKANN, name = "開始時間")
    private RTime 開始時間;

    private static final String SHUURYOU_JIKANN = "終了時間";
    @BatchParameter(key = SHUURYOU_JIKANN, name = "終了時間")
    private RTime 終了時間;

    private static final String SHUTURYOKU_ID = "出力順ID";
    @BatchParameter(key = SHUTURYOKU_ID, name = "出力順ID")
    private long 出力順ID;
}
