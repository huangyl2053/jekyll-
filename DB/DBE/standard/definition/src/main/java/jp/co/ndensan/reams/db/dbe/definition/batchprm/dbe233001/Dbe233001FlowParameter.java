/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe233001;

import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shujiiikentokusokujohakko.ShujiiIkenTokusokujoHakkoTempData;
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
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class Dbe233001FlowParameter extends BatchParameterBase {

    private static final long serialVersionUID = -5216323955138548895L;

    private RString temp_保険者コード;
    private RString temp_保険者名称;
    private RString temp_主治医医療機関コード;
    private RString temp_主治医コード;
    private FlexibleDate temp_基準日;
    private Decimal temp_主治医意見書督促期限日数;
    private RString temp_主治医意見書督促状;
    private RString temp_主治医意見書督促対象者一覧表;
    private RString temp_CSV出力;
    private RString temp_印刷済対象者;
    private RString temp_発行履歴;
    private int temp_督促方法;
    private RString temp_督促メモ;
    private FlexibleDate temp_督促日;
    private RDate temp_印刷期間開始日;
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
     * 主治医意見書督促状のパラメータを作成します。
     *
     * @return 主治医意見書督促状のパラメータ
     */
    public ShujiiIkenTokusokujoProcessParamter toShujiiIkenTokusokujoProcessParamter() {
        ShujiiIkenTokusokujoProcessParamter param = new ShujiiIkenTokusokujoProcessParamter();
        param.setTemp_保険者コード(this.temp_保険者コード);
        param.setTemp_主治医医療機関コード(this.temp_主治医医療機関コード);
        param.setTemp_主治医コード(this.temp_主治医コード);
        param.setTemp_基準日(this.temp_基準日);
        param.setTemp_主治医意見書督促期限日数(this.temp_主治医意見書督促期限日数);
        param.setTemp_印刷済対象者(this.temp_印刷済対象者);
        return param;
    }

    /**
     * 主治医意見書督促対象者一覧表作成のパラメータを作成します。
     *
     * @return 主治医意見書督促対象者一覧表作成のパラメータ
     */
    public ShujiiIkenTokusokujoHakkoProcessParamter toShujiiIkenTokusokujoHakkoProcessParamter() {
        ShujiiIkenTokusokujoHakkoProcessParamter param = new ShujiiIkenTokusokujoHakkoProcessParamter();
        param.setTemp_印刷期間開始日(this.temp_印刷期間開始日);
        param.setTemp_印刷期間終了日(this.temp_印刷期間終了日);
        param.setTemp_保険者コード(this.temp_保険者コード);
        param.setTemp_主治医医療機関コード(this.temp_主治医医療機関コード);
        param.setTemp_主治医コード(this.temp_主治医コード);
        return param;
    }
}
