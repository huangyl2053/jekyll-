/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC815001;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
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
    private RString 処理年月日;
    @BatchParameter(key = SHORINICHIJI, name = "処理日時")
    private RString 処理日時;
    @BatchParameter(key = CHUUSHUTSUKIKANKAISHINICHIJI, name = "抽出期間開始日時")
    private RString 抽出期間開始日時;
    @BatchParameter(key = CHUUSHUTSUKIKANSHUURYOUNICHIJI, name = "抽出期間終了日時")
    private RString 抽出期間終了日時;
    @BatchParameter(key = CYOYHYOUID, name = "帳票ID")
    private RString 帳票ID;
    @BatchParameter(key = SHUTSURYOJYUNID, name = "出力順ID")
    private Long 出力順ID;
    @BatchParameter(key = KAISHINENGAB1, name = "開始年月１")
    private RString 開始年月１;
    @BatchParameter(key = SHUURYOUNENGAB1, name = "終了年月１")
    private RString 終了年月１;
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
     * @param 年度 年度
     * @param 処理年月日 処理年月日
     * @param 処理日時 処理日時
     * @param 抽出期間開始日時 抽出期間開始日時
     * @param 抽出期間終了日時 抽出期間終了日時
     * @param 帳票ID 帳票ID
     * @param 出力順ID 出力順ID
     * @param 開始年月１ 開始年月１
     * @param 終了年月１ 終了年月１
     * @param 開始年月２ 開始年月２
     * @param 終了年月２ 終了年月２
     * @param テスト出力 テスト出力
     */
    public DBC815001_KogakuKaigoTaishoshaChushutsuSokyubunParameter(
            RString 年度,
            RString 処理年月日,
            RString 処理日時,
            RString 抽出期間開始日時,
            RString 抽出期間終了日時,
            RString 帳票ID,
            Long 出力順ID,
            RString 開始年月１,
            RString 終了年月１,
            RString 開始年月２,
            RString 終了年月２,
            boolean テスト出力) {
        this.年度 = 年度;
        this.処理年月日 = 処理年月日;
        this.処理日時 = 処理日時;
        this.抽出期間開始日時 = 抽出期間開始日時;
        this.抽出期間終了日時 = 抽出期間終了日時;
        this.帳票ID = 帳票ID;
        this.出力順ID = 出力順ID;
        this.開始年月１ = 開始年月１;
        this.終了年月１ = 終了年月１;
        this.開始年月２ = 開始年月２;
        this.終了年月２ = 終了年月２;
        this.テスト出力 = テスト出力;
    }
}
