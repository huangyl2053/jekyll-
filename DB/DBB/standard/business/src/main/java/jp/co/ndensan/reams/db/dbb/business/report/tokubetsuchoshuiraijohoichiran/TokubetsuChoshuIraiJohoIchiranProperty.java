/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraijohoichiran;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokuChoHeijunkaKeisanJuneKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBPR82001_1_特別徴収依頼情報一覧表クラスです。
 *
 * @reamsid_L DBB-1840-060 xuzhao
 */
public class TokubetsuChoshuIraiJohoIchiranProperty extends ReportPropertyBase<TokuChoHeijunkaKeisanJuneKekkaIchiranSource> {

    private static final ReportId ID = ReportIdDBB.DBB200019.getReportId();

    /**
     * コンストラクタです。
     */
    public TokubetsuChoshuIraiJohoIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ID);
    }

    /**
     * 改頁メソッド
     *
     * @param breakers Breakers<KariNonyuTsuchishoHakkoIchiranSource>
     * @param catalog BreakerCatalog<KariNonyuTsuchishoHakkoIchiranSource>
     * @return Breaker
     */
    @Override
    protected Breakers<TokuChoHeijunkaKeisanJuneKekkaIchiranSource> defineBreakers(
            Breakers<TokuChoHeijunkaKeisanJuneKekkaIchiranSource> breakers,
            BreakerCatalog<TokuChoHeijunkaKeisanJuneKekkaIchiranSource> catalog) {
        return super.defineBreakers(breakers, catalog);
    }
}
