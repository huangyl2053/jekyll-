/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahyoikenshochecklist;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyoikenshochecklist.ChosahyoIkenshoCheckListRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyoikenshochecklist.ChosahyoIkenshoCheckListReportSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定調査予定未定者一覧表のReportです。
 *
 * @reamsid_L DBE-1390-110 dongyabin
 */
public class ChosahyoIkenshoCheckListReport extends Report<ChosahyoIkenshoCheckListReportSource> {

    private final List<ChosahyoIkenshoCheckListRelateEntity> data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public ChosahyoIkenshoCheckListReport(List<ChosahyoIkenshoCheckListRelateEntity> data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ChosahyoIkenshoCheckListReportSource> reportSourceWriter) {
        for (ChosahyoIkenshoCheckListRelateEntity dataBody : data) {
            IChosahyoIkenshoCheckListEditor editor = new ChosahyoIkenshoCheckListEditor(dataBody);
            IChosahyoIkenshoCheckListBuilder builder = new ChosahyoIkenshoCheckListBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
        if (data.isEmpty()) {
            ChosahyoIkenshoCheckListRelateEntity entity = new ChosahyoIkenshoCheckListRelateEntity();
            entity.setDbT5101_hihokenshaName(new AtenaMeisho("該当データがありません"));
            IChosahyoIkenshoCheckListEditor editor = new ChosahyoIkenshoCheckListEditor(entity);
            IChosahyoIkenshoCheckListBuilder builder = new ChosahyoIkenshoCheckListBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
