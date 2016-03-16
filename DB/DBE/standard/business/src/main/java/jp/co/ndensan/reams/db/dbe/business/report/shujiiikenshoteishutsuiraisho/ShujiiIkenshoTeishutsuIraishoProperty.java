/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho;

import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * {@link 介護保険指定医依頼兼主治医意見書提出依頼書のReport}のプロパティです。
 */
public class ShujiiIkenshoTeishutsuIraishoProperty extends ReportPropertyBase<ShujiiIkenshoTeishutsuIraishoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShujiiIkenshoTeishutsuIraishoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE236001.getReportId());
    }
}
