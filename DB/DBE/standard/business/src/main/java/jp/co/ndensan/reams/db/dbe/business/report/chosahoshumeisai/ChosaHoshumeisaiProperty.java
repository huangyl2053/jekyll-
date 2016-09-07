/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshumeisai;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshumeisai.ChosaHoshumeisaiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 認定調査報酬支払明細書のプロパティです。
 *
 * @reamsid_L DBE-1980-045 suguangjun
 */
public class ChosaHoshumeisaiProperty extends ReportPropertyBase<ChosaHoshumeisaiReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ChosaHoshumeisaiProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE622002.getReportId());
    }
}
