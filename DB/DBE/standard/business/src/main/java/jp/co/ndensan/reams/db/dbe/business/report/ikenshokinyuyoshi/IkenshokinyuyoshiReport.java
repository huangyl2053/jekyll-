/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshi;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshokinyuyoshi.IkenshokinyuyoshiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.ikenshokinyuyoshi.IkenshokinyuyoshiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定主治医意見書記入用紙のReportです。
 *
 * @reamsid_L DBE-0050-030 xuyannan
 */
public class IkenshokinyuyoshiReport extends Report<IkenshokinyuyoshiReportSource> {

    private final IkenshokinyuyoshiEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 要介護認定主治医意見書記入用紙のentity
     */
    public IkenshokinyuyoshiReport(IkenshokinyuyoshiEntity entity) {
        this.entity = entity;
    }

    /**
     * 要介護認定主治医意見書記入用紙を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<IkenshokinyuyoshiReportSource> reportSourceWriter) {
        IIkenshokinyuyoshiEditor editor = new IkenshokinyuyoshiEditorImpl(entity);
        IIkenshokinyuyoshiBuilder builder = new IkenshokinyuyoshiBuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
