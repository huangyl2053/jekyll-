/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710100;

import jp.co.ndensan.reams.db.dbd.definition.processprm.hikazeinenkintaishosha.HikazeiNenkinTaishoshaProcessParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 画面設計_DBD1330001_汎用リスト出力(非課税年金対象者)のパラメータ。
 *
 * @reamsid_L DBD-5820-010 zhengsongling
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBD710100_HanyoListHikazeiNenkinTaishoshaParameter extends BatchParameterBase {

    private static final String CYUUSYUTSUHUUHUU = "抽出方法";
    private static final String CYUUSYUTSUNENDO = "抽出年度";
    private static final String HIHUKENSHACYUUSYUTSUHUUHUU = "被保険者抽出方法";
    private static final String SAISAHNJYOUHUU = "最新情報";
    private static final String KOMOKUMEIFUKA = "項目名付加";
    private static final String RENBANFUKA = "連番付加";
    private static final String HITSUKEHENSHU = "日付編集";
    private static final String ATENACYUUSHUTSUJYOUKEN = "宛名抽出条件";
    private static final String SHUTSURYOKUJUN = "出力順";
    private static final String SHUTSURYOKUKOMOKU = "出力項目";

    @BatchParameter(key = CYUUSYUTSUHUUHUU, name = "抽出方法")
    private RString 抽出方法;
    @BatchParameter(key = CYUUSYUTSUNENDO, name = "抽出年度")
    private RString 抽出年度;
    @BatchParameter(key = HIHUKENSHACYUUSYUTSUHUUHUU, name = "被保険者抽出方法")
    private RString 被保険者抽出方法;
    @BatchParameter(key = SAISAHNJYOUHUU, name = "最新情報")
    private boolean 最新情報;
    @BatchParameter(key = KOMOKUMEIFUKA, name = "項目名付加")
    private boolean 項目名付加;
    @BatchParameter(key = RENBANFUKA, name = "連番付加")
    private boolean 連番付加;
    @BatchParameter(key = HITSUKEHENSHU, name = "日付編集")
    private boolean 日付編集;
    @BatchParameter(key = ATENACYUUSHUTSUJYOUKEN, name = "宛名抽出条件")
    private AtenaSelectBatchParameter 宛名抽出条件;
    @BatchParameter(key = SHUTSURYOKUJUN, name = "出力順")
    private Long 出力順;
    @BatchParameter(key = SHUTSURYOKUKOMOKU, name = "出力項目")
    private RString 出力項目;

    /**
     * コンストラクタです。
     */
    public DBD710100_HanyoListHikazeiNenkinTaishoshaParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param 抽出方法 抽出方法
     * @param 抽出年度 抽出年度
     * @param 被保険者抽出方法 被保険者抽出方法
     * @param 最新情報 最新情報
     * @param 項目名付加 項目名付加
     * @param 連番付加 連番付加
     * @param 日付編集 日付編集
     * @param 宛名抽出条件 宛名抽出条件
     * @param 出力順 出力順
     * @param 出力項目 出力項目
     */
    public DBD710100_HanyoListHikazeiNenkinTaishoshaParameter(
            RString 抽出方法,
            RString 抽出年度,
            RString 被保険者抽出方法,
            boolean 最新情報,
            boolean 項目名付加,
            boolean 連番付加,
            boolean 日付編集,
            AtenaSelectBatchParameter 宛名抽出条件,
            Long 出力順,
            RString 出力項目) {
        this.抽出方法 = 抽出方法;
        this.抽出年度 = 抽出年度;
        this.被保険者抽出方法 = 被保険者抽出方法;
        this.最新情報 = 最新情報;
        this.項目名付加 = 項目名付加;
        this.連番付加 = 連番付加;
        this.日付編集 = 日付編集;
        this.宛名抽出条件 = 宛名抽出条件;
        this.出力順 = 出力順;
        this.出力項目 = 出力項目;
    }

    /**
     * 汎用リスト出力(非課税年金対象者)のパラメータを作成します。
     *
     * @param date date
     * @return SaishinsamoshitateProcessParameter
     */
    public HikazeiNenkinTaishoshaProcessParameter toProcessParameter(RDate date) {
        return new HikazeiNenkinTaishoshaProcessParameter(
                抽出方法,
                抽出年度,
                被保険者抽出方法,
                最新情報,
                項目名付加,
                連番付加,
                日付編集,
                宛名抽出条件,
                出力順,
                出力項目,
                date
        );
    }
}
