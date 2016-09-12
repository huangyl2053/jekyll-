/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahyoikenshochecklist;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyoikenshochecklist.ChosahyoIkenshoCheckListReportEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyoikenshochecklist.ChosahyoIkenshoCheckListReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定調査予定未定者一覧表のReportです。
 *
 * @reamsid_L DBE-1390-190 dongyabin
 */
public class ChosahyoIkenshoCheckListReport extends Report<ChosahyoIkenshoCheckListReportSource> {

    private final ChosahyoIkenshoCheckListReportEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public ChosahyoIkenshoCheckListReport(ChosahyoIkenshoCheckListReportEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ChosahyoIkenshoCheckListReportSource> reportSourceWriter) {
        IChosahyoIkenshoCheckListEditor editor = new ChosahyoIkenshoCheckListEditor(data);
        IChosahyoIkenshoCheckListBuilder builder = new ChosahyoIkenshoCheckListBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
