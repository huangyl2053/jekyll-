/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe233001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 主治医意見書督促状発行を特定するためのProcess用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShujiiIkenTokusokujoProcessParamter implements IBatchProcessParameter {

    private FlexibleDate temp_基準日;
    private RString temp_印刷済対象者;
    private RString temp_保険者コード;
    private RString temp_主治医医療機関コード;
    private RString temp_主治医コード;
    private Decimal temp_主治医意見書督促期限日数;

    /**
     * 主治医意見書督促状発行のMybatisパラメータを作成します。
     *
     * @return 主治医意見書督促状発行のMybatisパラメータ
     */
    public ShujiiIkenTokusokujoMybitisParamter toShujiiIkenTokusokujoMybitisParamter() {
        this.temp_基準日 = this.temp_基準日.minusDay(Integer.parseInt(temp_主治医意見書督促期限日数.toString()));

        return new ShujiiIkenTokusokujoMybitisParamter(this.temp_基準日,
                this.temp_印刷済対象者,
                this.temp_保険者コード,
                this.temp_主治医医療機関コード,
                this.temp_主治医コード);
    }
}
