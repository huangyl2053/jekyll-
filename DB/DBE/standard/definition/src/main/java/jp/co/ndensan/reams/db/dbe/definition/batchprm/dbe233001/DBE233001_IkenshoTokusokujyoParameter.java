/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE233001;

import jp.co.ndensan.reams.db.dbe.definition.core.shujiiikentokusokujohakko.ShujiiIkenTokusokujoHakkoTempData;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書督促状発行のバッチパラメータクラスです。
 *
 * @reamsid_L DBE-0060-010 zhangzhiming
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class DBE233001_IkenshoTokusokujyoParameter extends BatchParameterBase {

    private static final long serialVersionUID = -5216323955138548895L;

    private static final String HOKENN_CODE = "temp_保険者コード";
    private static final String HOKENN_NAME = "temp_保険者名称";
    private static final String SHUJII_IRYOU_CODE = "temp_主治医医療機関コード";
    private static final String SHUJII_CODE = "temp_主治医コード";
    private static final String KIZYUNNYMD = "temp_基準日";
    private static final String KIGENN_HIKAZU = "temp_主治医意見書督促期限日数";
    private static final String SHUJII_IKENTOKUSO_KUJO = "temp_主治医意見書督促状";
    private static final String SHUJII_IKENTOKUSOKUJO_HAKKO = "temp_主治医意見書督促対象者一覧表";
    private static final String CSV_SHUTURYOKU = "temp_CSV出力";
    private static final String INNSATU_TAI_ZOU_MONO = "temp_印刷済対象者";
    private static final String HAKKOU_RIREKI = "temp_発行履歴";
    private static final String IKENSHO_SAKUSEI_TOKU_SOKUHOHO = "temp_督促方法";
    private static final String IKENSHO_TOKUSOKU_MEMO = "temp_督促メモ";
    private static final String IKENSHO_TOKUSOKUYMD = "temp_督促日";
    private static final String IKENSHO_SAKUSEI_TOKU_HAKKOU = "temp_印刷期間開始日";
    private static final String IKENSHO_SAKUSEI_IRAI_HAKKOU = "temp_印刷期間終了日";

    @BatchParameter(key = HOKENN_CODE, name = "保険者コード")
    private RString temp_保険者コード;
    @BatchParameter(key = HOKENN_NAME, name = "保険者名称")
    private RString temp_保険者名称;
    @BatchParameter(key = SHUJII_IRYOU_CODE, name = "主治医医療機関コード")
    private RString temp_主治医医療機関コード;
    @BatchParameter(key = SHUJII_CODE, name = "主治医コード")
    private RString temp_主治医コード;
    @BatchParameter(key = KIZYUNNYMD, name = "基準日")
    private FlexibleDate temp_基準日;
    @BatchParameter(key = KIGENN_HIKAZU, name = "主治医意見書督促期限日数")
    private Decimal temp_主治医意見書督促期限日数;
    @BatchParameter(key = SHUJII_IKENTOKUSO_KUJO, name = "主治医意見書督促状")
    private RString temp_主治医意見書督促状;
    @BatchParameter(key = SHUJII_IKENTOKUSOKUJO_HAKKO, name = "主治医意見書督促対象者一覧表")
    private RString temp_主治医意見書督促対象者一覧表;
    @BatchParameter(key = CSV_SHUTURYOKU, name = "CSV出力")
    private RString temp_CSV出力;
    @BatchParameter(key = INNSATU_TAI_ZOU_MONO, name = "印刷済対象者")
    private RString temp_印刷済対象者;
    @BatchParameter(key = HAKKOU_RIREKI, name = "発行履歴")
    private RString temp_発行履歴;
    @BatchParameter(key = IKENSHO_SAKUSEI_TOKU_SOKUHOHO, name = "督促方法")
    private int temp_督促方法;
    @BatchParameter(key = IKENSHO_TOKUSOKU_MEMO, name = "督促メモ")
    private RString temp_督促メモ;
    @BatchParameter(key = IKENSHO_TOKUSOKUYMD, name = "督促日")
    private FlexibleDate temp_督促日;
    @BatchParameter(key = IKENSHO_SAKUSEI_TOKU_HAKKOU, name = "印刷期間開始日")
    private RDate temp_印刷期間開始日;
    @BatchParameter(key = IKENSHO_SAKUSEI_IRAI_HAKKOU, name = "印刷期間終了日")
    private RDate temp_印刷期間終了日;

    /**
     * 画面からのパラメータを作成します。
     *
     * @param tempData 画面データ
     */
    public void toDBE233001Parameter(ShujiiIkenTokusokujoHakkoTempData tempData) {
        this.temp_保険者コード = tempData.getTemp_保険者コード();
        this.temp_保険者名称 = tempData.getTemp_保険者名称();
        this.temp_主治医医療機関コード = tempData.getTemp_主治医医療機関コード();
        this.temp_主治医コード = tempData.getTemp_主治医コード();
        this.temp_基準日 = tempData.getTemp_基準日();
        this.temp_主治医意見書督促期限日数 = tempData.getTemp_主治医意見書督促期限日数();
        this.temp_主治医意見書督促状 = tempData.getTemp_主治医意見書督促状();
        this.temp_主治医意見書督促対象者一覧表 = tempData.getTemp_主治医意見書督促対象者一覧表();
        this.temp_CSV出力 = tempData.getTemp_CSV出力();
        this.temp_印刷済対象者 = tempData.getTemp_印刷済対象者();
        this.temp_発行履歴 = tempData.getTemp_発行履歴();
        this.temp_督促方法 = tempData.getTemp_督促方法();
        this.temp_督促メモ = tempData.getTemp_督促メモ();
        this.temp_督促日 = tempData.getTemp_督促日();
        this.temp_印刷期間開始日 = tempData.getTemp_印刷期間開始日();
        this.temp_印刷期間終了日 = tempData.getTemp_印刷期間終了日();
    }

    /**
     * 出力条件表のパラメータを作成します。
     *
     * @return 出力条件表のパラメータ
     */
    public ShuturyokuJyoukenProcessParamter toShuturyokuJyoukenProcessParamter() {
        ShuturyokuJyoukenProcessParamter param = new ShuturyokuJyoukenProcessParamter();
        param.setTemp_保険者コード(this.temp_保険者コード);
        param.setTemp_主治医医療機関コード(this.temp_主治医医療機関コード);
        param.setTemp_主治医コード(this.temp_主治医コード);
        param.setTemp_基準日(this.temp_基準日);
        param.setTemp_主治医意見書督促期限日数(this.temp_主治医意見書督促期限日数);
        param.setTemp_印刷済対象者(this.temp_印刷済対象者);
        param.setTemp_印刷期間開始日(this.temp_印刷期間開始日);
        param.setTemp_印刷期間終了日(this.temp_印刷期間終了日);
        param.setTemp_CSV出力(this.temp_CSV出力);
        param.setTemp_主治医意見書督促対象者一覧表(this.temp_主治医意見書督促対象者一覧表);
        param.setTemp_主治医意見書督促状(this.temp_主治医意見書督促状);
        param.setTemp_督促日(this.temp_督促日);
        param.setTemp_督促方法(this.temp_督促方法);
        param.setTemp_督促メモ(this.temp_督促メモ);
        param.setTemp_発行履歴(this.temp_発行履歴);
        param.setTemp_保険者名称(this.temp_保険者名称);
        return param;
    }
}
