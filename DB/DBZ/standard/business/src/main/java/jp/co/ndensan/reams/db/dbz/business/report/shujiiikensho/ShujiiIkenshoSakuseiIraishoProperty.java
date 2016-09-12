/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.shujiiikensho;

import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * {@link 主治医意見書作成依頼書のReport}のプロパティです。
 *
 * @reamsid_L DBE-0050-020 sunhaidi
 */
public class ShujiiIkenshoSakuseiIraishoProperty extends ReportPropertyBase<ShujiiIkenshoSakuseiIraishoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShujiiIkenshoSakuseiIraishoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBZ.DBE230001.getReportId());
    }
}
