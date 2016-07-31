/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiihoshumeisai;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiihoshumeisai.ShujiiHoshumeisaiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBE622001_主治医意見書作成報酬支払明細書のShujiiHoshumeisaiPropertyです。
 *
 * @reamsid_L DBE-1980-044 xuyongchao
 */
public class ShujiiHoshumeisaiProperty extends ReportPropertyBase<ShujiiHoshumeisaiReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShujiiHoshumeisaiProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE622001.getReportId());
    }
}
