/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.shokanrenrakuhyooutputreport;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 帳票出力用パラメータクラスです。
 *
 * @reamsid_L DBC-2570-030 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanRenrakuhyoOutputReportProcessParam implements IBatchProcessParameter {

    private FlexibleYearMonth syoriYM;
    private Long shutsuryokujunId;

    /**
     * コンストラクタです。
     *
     * @param syoriYM FlexibleYearMonth
     * @param shutsuryokujunId Long
     */
    public ShokanRenrakuhyoOutputReportProcessParam(FlexibleYearMonth syoriYM, Long shutsuryokujunId) {
        this.syoriYM = syoriYM;
        this.shutsuryokujunId = shutsuryokujunId;
    }

}
