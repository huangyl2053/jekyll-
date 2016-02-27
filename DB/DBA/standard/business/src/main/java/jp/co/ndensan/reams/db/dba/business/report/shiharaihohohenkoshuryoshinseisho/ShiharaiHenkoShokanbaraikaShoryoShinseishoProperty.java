/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shiharaihohohenkoshuryoshinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.shiharaihohohenkoshuryoshinseisho.ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link ShiharaiHenkoShokanbaraikaShoryoShinseishoReport}のプロパティです。
 */
public class ShiharaiHenkoShokanbaraikaShoryoShinseishoProperty extends ReportPropertyBase<ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShiharaiHenkoShokanbaraikaShoryoShinseishoProperty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBD800009.getReportId());
    }

}
