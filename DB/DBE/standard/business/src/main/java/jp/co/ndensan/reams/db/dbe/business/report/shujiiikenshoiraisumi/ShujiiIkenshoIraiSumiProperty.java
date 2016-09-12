/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoiraisumi;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoiraisumi.ShujiiIkenshoIraiSumiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 主治医意見書依頼済み一覧表のプロパティです。
 *
 * @reamsid_L DBE-1390-160 suguangjun
 */
public class ShujiiIkenshoIraiSumiProperty extends ReportPropertyBase<ShujiiIkenshoIraiSumiReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShujiiIkenshoIraiSumiProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE013004.getReportId());
    }
}
