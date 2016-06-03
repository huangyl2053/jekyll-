/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendoidohakkoichiran;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBPR45002_保険料納入通知書（本算定過年度異動）発行一覧表のプロパティです。
 *
 * @reamsid_L DBB-0920-050 zhangrui
 *
 */
public class HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranProperty
        extends ReportPropertyBase<NonyuTsuchIchiranSource> {

    private static final ReportId ID = ReportIdDBB.DBB200017.getReportId();

    /**
     * コンストラクタです。
     */
    public HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ID);
    }

    @Override
    protected Breakers<NonyuTsuchIchiranSource> defineBreakers(Breakers<NonyuTsuchIchiranSource> breakers,
            BreakerCatalog<NonyuTsuchIchiranSource> catalog) {
        return super.defineBreakers(breakers, catalog);
    }

}
