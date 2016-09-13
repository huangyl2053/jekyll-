/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.chosairaisho;

import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.chosairaisho.ChosaIraishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link 要介護認定調査依頼書のReport}のプロパティです。
 *
 * @reamsid_L DBE-0010-020 lishengli
 */
public class ChosaIraishoProperty extends ReportPropertyBase<ChosaIraishoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ChosaIraishoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBZ.DBE220001.getReportId());
    }
}
