/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE233001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 出力条件表を特定するためのProcess用パラメータクラスです。
 *
 * @reamsid_L DBE-0060-040 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShujiiIkenTokusokujoHakkoReportProcessParameter implements IBatchProcessParameter {

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
     * 主治医意見書督促状発行のMybatisパラメータを作成します。
     *
     * @return 主治医意見書督促状発行のMybatisパラメータ
     */
    public ShujiiIkenTokusokujoMybitisParamter toShujiiIkenTokusokujoMybitisParamter() {
        this.temp_基準日 = this.temp_基準日.minusDay(Integer.parseInt(temp_主治医意見書督促期限日数.toString()));

        return ShujiiIkenTokusokujoMybitisParamter.createParam(this.temp_基準日,
                this.temp_印刷済対象者,
                this.temp_保険者コード,
                this.temp_主治医医療機関コード,
                this.temp_主治医コード,
                false,
                false,
                false,
                false,
                null);
    }

    /**
     * 主治医意見書督促状発行のMybatisパラメータを作成します。
     *
     * @param temp_市町村コード 市町村コード
     * @return 主治医意見書督促状発行のMybatisパラメータ
     */
    public ShujiiIkenTokusokujoMybitisParamter toShujiiIkenTokusokujoMybitisParamter(LasdecCode temp_市町村コード) {
        this.temp_基準日 = this.temp_基準日.minusDay(Integer.parseInt(temp_主治医意見書督促期限日数.toString()));

        return ShujiiIkenTokusokujoMybitisParamter.createParam(this.temp_基準日,
                this.temp_印刷済対象者,
                this.temp_保険者コード,
                this.temp_主治医医療機関コード,
                this.temp_主治医コード,
                false,
                false,
                false,
                false,
                temp_市町村コード);
    }

    /**
     * 主治医意見書督促対象者一覧表のMybatisパラメータを作成します。
     *
     * @return 主治医意見書督促対象者一覧表のMybatisパラメータ
     */
    public ShujiiIkenTokusokujoHakkoMybitisParamter toShujiiIkenTokusokujoHakkoMybitisParamter() {
        return ShujiiIkenTokusokujoHakkoMybitisParamter.createParam(this.temp_印刷期間開始日 == null ? null : this.temp_印刷期間開始日.toDateString(),
                this.temp_印刷期間終了日 == null ? null : this.temp_印刷期間終了日.toDateString(),
                this.temp_保険者コード,
                this.temp_主治医医療機関コード,
                this.temp_主治医コード,
                false,
                false,
                false,
                false,
                false,
                false);
    }
}
