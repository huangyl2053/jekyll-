/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business.report.hakkogoidotaishoshaichiran;

import jp.co.ndensan.reams.db.dbb.definition.reportId.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.hakkogoidotaishoshaichiran.HakkogoIdoTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 通知書発行後異動把握帳票HakkogoIdoTaishoshaIchiranProperty
 */
public class HakkogoIdoTaishoshaIchiranProperty extends ReportPropertyBase<HakkogoIdoTaishoshaIchiranSource> {

    private static final ReportId ID = ReportIdDBB.DBB200028.getReportId();

    /**
     * コンストラクタです。
     */
    public HakkogoIdoTaishoshaIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ID);
    }

    /**
     * 改頁メソッド
     * 
     * @param breakers Breakers<HakkogoIdoTaishoshaIchiranSource>
     * @param catalog BreakerCatalog<HakkogoIdoTaishoshaIchiranSource>
     * @return Breaker
     */
    @Override
    protected Breakers<HakkogoIdoTaishoshaIchiranSource> defineBreakers(
            Breakers<HakkogoIdoTaishoshaIchiranSource> breakers, 
            BreakerCatalog<HakkogoIdoTaishoshaIchiranSource> catalog) {
        return super.defineBreakers(breakers, catalog);
    }

}
