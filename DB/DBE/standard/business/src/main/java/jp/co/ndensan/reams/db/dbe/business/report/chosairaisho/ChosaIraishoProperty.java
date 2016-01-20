/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaisho;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaisho.ChosaIraishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * {@link 要介護認定調査依頼書のReport}のプロパティです。
 */
public class ChosaIraishoProperty extends ReportPropertyBase<ChosaIraishoReportSource> {

    private static final ReportId ID = new ReportId("DBE220001");

    /**
     * インスタンスを生成します。
     */
    public ChosaIraishoProperty() {
        super(SubGyomuCode.DBE認定支援, ID);
    }
}
