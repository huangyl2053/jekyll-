/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200037;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.LowerEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.UpperEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200037.JukyushaIdoCheckListReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 受給者台帳異動チェックリスト帳票のReportです。
 *
 * @reamsid_L DBD-1770-040 donghj
 */
public class JukyushaIdoCheckListReport extends Report<JukyushaIdoCheckListReportSource> {

    private final UpperEntity upperEntity;
    private final LowerEntity lowerEntity;
    private final IOutputOrder iOutputOrder;

    /**
     * インスタンスを生成します。
     *
     * @param upperEntity UpperEntity
     * @param lowerEntity LowerEntity
     * @param iOutputOrder IOutputOrder
     */
    public JukyushaIdoCheckListReport(UpperEntity upperEntity, LowerEntity lowerEntity, IOutputOrder iOutputOrder) {
        this.upperEntity = upperEntity;
        this.lowerEntity = lowerEntity;
        this.iOutputOrder = iOutputOrder;
    }

    @Override
    public void writeBy(ReportSourceWriter<JukyushaIdoCheckListReportSource> reportSourceWriter) {
        IJukyushaIdoCheckListEditor editor = new JukyushaIdoCheckListEditor(upperEntity, lowerEntity, iOutputOrder);
        IJukyushaIdoCheckListBuilder builder = new JukyushaIdoCheckListBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
