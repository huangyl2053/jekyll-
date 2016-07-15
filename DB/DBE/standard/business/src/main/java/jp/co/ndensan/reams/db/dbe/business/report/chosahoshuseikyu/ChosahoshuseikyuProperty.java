/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshuseikyu;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshuseikyu.ChosahoshuseikyuReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 認定調査報酬請求書のプロパティです。
 *
 * @reamsid_L DBE-1980-043 suguangjun
 */
public class ChosahoshuseikyuProperty extends ReportPropertyBase<ChosahoshuseikyuReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ChosahoshuseikyuProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE621005.getReportId());
    }
}
