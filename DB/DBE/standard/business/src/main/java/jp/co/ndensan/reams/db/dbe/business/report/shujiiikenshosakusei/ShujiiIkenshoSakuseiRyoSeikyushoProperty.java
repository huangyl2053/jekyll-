/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakusei;

import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * {@link 主治医意見書作成料請求書のReport}のプロパティです。
 */
public class ShujiiIkenshoSakuseiRyoSeikyushoProperty extends ReportPropertyBase<ShujiiIkenshoSakuseiRyoSeikyushoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShujiiIkenshoSakuseiRyoSeikyushoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE234001.getReportId());
    }
}
