/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho;

import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho.ShujiiIkenshoSakuseiIraishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * {@link 主治医意見書作成依頼書のReport}のプロパティです。
 */
public class ShujiiIkenshoSakuseiIraishoProperty extends ReportPropertyBase<ShujiiIkenshoSakuseiIraishoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShujiiIkenshoSakuseiIraishoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE230001.getReportId());
    }
}
