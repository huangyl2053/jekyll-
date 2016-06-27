/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shiharaihohohenkoshuryoshinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.shiharaihohohenkoshuryoshinseisho.ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link ShiharaiHenkoShokanbaraikaShoryoShinseishoReport}のプロパティです。
 *
 * @reamsid_L DBA-0540-697 zhangguopeng
 */
public class ShiharaiHenkoShokanbaraikaShoryoShinseishoProperty extends ReportPropertyBase<ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShiharaiHenkoShokanbaraikaShoryoShinseishoProperty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBA.DBD800009.getReportId());
    }

}
