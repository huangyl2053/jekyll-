/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe233001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書督促対象者一覧表を特定するためのProcess用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShujiiIkenTokusokujoHakkoProcessParamter implements IBatchProcessParameter {

    private RDate temp_印刷期間開始日;
    private RDate temp_印刷期間終了日;
    private RString temp_保険者コード;
    private RString temp_主治医医療機関コード;
    private RString temp_主治医コード;

    /**
     * 主治医意見書督促対象者一覧表のMybatisパラメータを作成します。
     *
     * @return 主治医意見書督促対象者一覧表のMybatisパラメータ
     */
    public ShujiiIkenTokusokujoHakkoMybitisParamter toShujiiIkenTokusokujoHakkoMybitisParamter() {
        return new ShujiiIkenTokusokujoHakkoMybitisParamter(this.temp_印刷期間開始日.toDateString(),
                this.temp_印刷期間終了日.toDateString(),
                this.temp_保険者コード,
                this.temp_主治医医療機関コード,
                this.temp_主治医コード);
    }
}
