/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC815001;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigotaishoshachushutsusokyubun.KogakuKaigoTaishoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 画面設計_DBCMN41003_高額介護対象者抽出（遡及分）のパラメータ。
 *
 * @reamsid_L DBC-5750-010 zhengsongling
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBC815001_KogakuKaigoTaishoshaChushutsuSokyubunParameter extends BatchParameterBase {

    private static final String NENDO = "年度";
    private static final String SHIRINENKABBI = "処理年月日";
    private static final String SHORINICHIJI = "処理日時";
    private static final String CHUUSHUTSUKIKANKAISHINICHIJI = "抽出期間開始日時";
    private static final String CHUUSHUTSUKIKANSHUURYOUNICHIJI = "抽出期間終了日時";
    private static final String CYOYHYOUID = "帳票ID";
    private static final String SHUTSURYOJYUNID = "出力順ID";
    private static final String KAISHINENGAB1 = "開始年月１";
    private static final String SHUURYOUNENGAB1 = "終了年月１";
    private static final String KAISHINENGAB2 = "開始年月２";
    private static final String SHUURYOUNENGAB2 = "終了年月２";
    private static final String TESTSHUTSURYOKU = "テスト出力";

    @BatchParameter(key = NENDO, name = "年度")
    private RString 年度;
    @BatchParameter(key = SHIRINENKABBI, name = "処理年月日")
    private FlexibleYearMonth 処理年月日;
    @BatchParameter(key = SHORINICHIJI, name = "処理日時")
    private RString 処理日時;
    @BatchParameter(key = CHUUSHUTSUKIKANKAISHINICHIJI, name = "抽出期間開始日時")
    private RDateTime 抽出期間開始日時;
    @BatchParameter(key = CHUUSHUTSUKIKANSHUURYOUNICHIJI, name = "抽出期間終了日時")
    private RDateTime 抽出期間終了日時;
    @BatchParameter(key = CYOYHYOUID, name = "帳票ID")
    private RString 帳票ID;
    @BatchParameter(key = SHUTSURYOJYUNID, name = "出力順ID")
    private Long 出力順ID;
    @BatchParameter(key = KAISHINENGAB1, name = "開始年月１")
    private FlexibleYearMonth 開始年月１;
    @BatchParameter(key = SHUURYOUNENGAB1, name = "終了年月１")
    private FlexibleYearMonth 終了年月１;
    @BatchParameter(key = KAISHINENGAB2, name = "開始年月２")
    private RString 開始年月２;
    @BatchParameter(key = SHUURYOUNENGAB2, name = "終了年月２")
    private RString 終了年月２;
    @BatchParameter(key = TESTSHUTSURYOKU, name = "テスト出力")
    private boolean テスト出力;

    /**
     * コンストラクタです。
     */
    public DBC815001_KogakuKaigoTaishoshaChushutsuSokyubunParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @return JKogakuKaigoTaishoshaProcessParameter
     */
    public KogakuKaigoTaishoProcessParameter toProcessParameter() {

        return new KogakuKaigoTaishoProcessParameter(
                処理年月日,
                抽出期間開始日時,
                抽出期間終了日時,
                出力順ID,
                開始年月１,
                終了年月１,
                テスト出力);

    }
}
