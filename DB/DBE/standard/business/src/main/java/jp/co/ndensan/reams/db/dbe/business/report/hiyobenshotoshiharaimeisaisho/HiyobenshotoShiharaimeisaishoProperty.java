/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.hiyobenshotoshiharaimeisaisho;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.hiyobenshotoshiharaimeisaisho.HiyobenshotoShiharaimeisaishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護認定審査委員報酬・費用弁償等支払明細書のプロパティです。
 *
 * @reamsid_L DBE-1980-048 suguangjun
 */
public class HiyobenshotoShiharaimeisaishoProperty extends ReportPropertyBase<HiyobenshotoShiharaimeisaishoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public HiyobenshotoShiharaimeisaishoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE622006.getReportId());
    }
}
