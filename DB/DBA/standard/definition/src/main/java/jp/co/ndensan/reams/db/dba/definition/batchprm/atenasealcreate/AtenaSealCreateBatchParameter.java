/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.batchprm.atenasealcreate;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 宛名シール作成のBatchParameterです。
 *
 * @reamsid_L DBA-1210-010 zhengsongling
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AtenaSealCreateBatchParameter extends BatchParameterBase {

    private static final String CHUUSHUTSUTAISHOUSHA = "chuushutsutaishousha";
    private static final String CHUYSHUTSUKUKANTXT = "chuyshutsukukantxt";
    private static final String CHUUSHUTSUKIKANKAISHIBI = "chuushutsukikankaishibi";
    private static final String CHUUSHUTSUKIKANSHUURYOUBI = "chuushutsukikanshuuryoubi";
    private static final String SHIKAKUKUBUN = "shikakukubun";
    private static final String SHICHOUSONSHITEI = "shichousonshitei";
    private static final String SAIYUUSENJYUSHO = "saiyuusenjyusho";
    private static final String KEISHOU = "keishou";
    private static final String HITEMOTSUBANGOUHYOUJI = "hitemotsubangouhyouji";
    private static final String ISKATAGAKI = "iskatagaki";
    private static final String ISSHICHOSONMEISHO = "isshichosonmeisho";
    private static final String ISTODOFUKENMEISHO = "istodofukenmeisho";
    private static final String ISGUNMEISHO = "isgunmeisho";
    private static final String SHUTSUTUOKUJYUNID = "shutsutuokujyunid";
    private static final String GYOUMUCODE = "gyoumucode";

    @BatchParameter(key = CHUUSHUTSUTAISHOUSHA, name = "抽出対象者")
    private RString chuushutsutaishousha;
    @BatchParameter(key = CHUYSHUTSUKUKANTXT, name = "抽出期間TXT")
    private RString chuyshutsukukantxt;
    @BatchParameter(key = CHUUSHUTSUKIKANKAISHIBI, name = "抽出期間開始日")
    private RString chuushutsukikankaishibi;
    @BatchParameter(key = CHUUSHUTSUKIKANSHUURYOUBI, name = "抽出期間終了日")
    private RString chuushutsukikanshuuryoubi;
    @BatchParameter(key = SHIKAKUKUBUN, name = "資格区分")
    private RString shikakukubun;
    @BatchParameter(key = SHICHOUSONSHITEI, name = "市町村指定")
    private RString shichousonshitei;
    @BatchParameter(key = SAIYUUSENJYUSHO, name = "最優先住所")
    private RString saiyuusenjyusho;
    @BatchParameter(key = KEISHOU, name = "敬称")
    private RString keishou;
    @BatchParameter(key = HITEMOTSUBANGOUHYOUJI, name = "被保番号表示")
    private RString hitemotsubangouhyouji;
    @BatchParameter(key = ISKATAGAKI, name = "方書")
    private boolean iskatagaki;
    @BatchParameter(key = ISSHICHOSONMEISHO, name = "市町村名称")
    private boolean isshichosonmeisho;
    @BatchParameter(key = ISTODOFUKENMEISHO, name = "都道府県名称")
    private boolean istodofukenmeisho;
    @BatchParameter(key = ISGUNMEISHO, name = "郡名称")
    private boolean isgunmeisho;
    @BatchParameter(key = SHUTSUTUOKUJYUNID, name = "出力順ID")
    private Long shutsutuokujyunid;
    @BatchParameter(key = GYOUMUCODE, name = "業務コード")
    private RString gyoumucode;

    /**
     * コンストラクタです。
     */
    public AtenaSealCreateBatchParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param chuushutsutaishousha 抽出対象者
     * @param chuyshutsukukantxt 抽出期間TXT
     * @param chuushutsukikankaishibi 抽出期間開始日
     * @param chuushutsukikanshuuryoubi 抽出期間終了日
     * @param shikakukubun 資格区分
     * @param shichousonshitei 市町村指定
     * @param saiyuusenjyusho 最優先住所
     * @param keishou 敬称
     * @param hitemotsubangouhyouji 被保番号表示
     * @param iskatagaki 方書
     * @param isshichosonmeisho 市町村名称
     * @param istodofukenmeisho 都道府県名称
     * @param isgunmeisho 郡名称
     * @param shutsutuokujyunid 出力順ID
     * @param gyoumucode 業務コード
     */
    public AtenaSealCreateBatchParameter(
            RString chuushutsutaishousha,
            RString chuyshutsukukantxt,
            RString chuushutsukikankaishibi,
            RString chuushutsukikanshuuryoubi,
            RString shikakukubun,
            RString shichousonshitei,
            RString saiyuusenjyusho,
            RString keishou,
            RString hitemotsubangouhyouji,
            boolean iskatagaki,
            boolean isshichosonmeisho,
            boolean istodofukenmeisho,
            boolean isgunmeisho,
            Long shutsutuokujyunid,
            RString gyoumucode) {
        this.chuushutsutaishousha = chuushutsutaishousha;
        this.chuyshutsukukantxt = chuyshutsukukantxt;
        this.chuushutsukikankaishibi = chuushutsukikankaishibi;
        this.chuushutsukikanshuuryoubi = chuushutsukikanshuuryoubi;
        this.shikakukubun = shikakukubun;
        this.shichousonshitei = shichousonshitei;
        this.saiyuusenjyusho = saiyuusenjyusho;
        this.keishou = keishou;
        this.hitemotsubangouhyouji = hitemotsubangouhyouji;
        this.iskatagaki = iskatagaki;
        this.isshichosonmeisho = isshichosonmeisho;
        this.shutsutuokujyunid = shutsutuokujyunid;
        this.istodofukenmeisho = istodofukenmeisho;
        this.isgunmeisho = isgunmeisho;
        this.gyoumucode = gyoumucode;
    }
}
