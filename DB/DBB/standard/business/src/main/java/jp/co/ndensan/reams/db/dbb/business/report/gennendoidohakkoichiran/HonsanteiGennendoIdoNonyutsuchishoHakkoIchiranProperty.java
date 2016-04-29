/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gennendoidohakkoichiran;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBRP44002_1_保険料納入通知書（本算定現年度異動）発行一覧表のプロパティです。
 *
 * @reamsid_L DBB-0880-050 zhangrui
 *
 */
public class HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranProperty
        extends ReportPropertyBase<NonyuTsuchIchiranSource> {

    private static final ReportId ID = ReportIdDBB.DBB200016.getReportId();

    /**
     * コンストラクタです。
     */
    public HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ID);
    }

    @Override
    protected Breakers<NonyuTsuchIchiranSource> defineBreakers(Breakers<NonyuTsuchIchiranSource> breakers,
            BreakerCatalog<NonyuTsuchIchiranSource> catalog) {
        return super.defineBreakers(breakers, catalog);
    }

}
