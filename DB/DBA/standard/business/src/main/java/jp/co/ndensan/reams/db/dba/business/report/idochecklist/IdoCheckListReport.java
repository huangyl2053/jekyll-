/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.idochecklist;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.idochecklist.IdoCheckListReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 異動チェックリスト帳票作成
 */
public class IdoCheckListReport extends Report<IdoCheckListReportSource> {

    private final List<IdoCheckListItem> targets;

    protected IdoCheckListReport(List<IdoCheckListItem> targets) {
        this.targets = targets;
    }

    /**
     * インスタンスを生成します。
     *
     * @param IdoCheckListItems 異動チェックリストのITEMリスト
     * @return 異動チェックリストのReport
     */

    public static IdoCheckListReport createFrom(@NonNull List<IdoCheckListItem> IdoCheckListItems) {
        return new IdoCheckListReport(IdoCheckListItems);
    }

    /**
     *
     * @param reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<IdoCheckListReportSource> reportSourceWriter) {
        for (IdoCheckListItem target : targets) {
            IIdoCheckListEditor headerEditor = new IdoCheckListHeaderEditor(target);
            IIdoCheckListEditor hyojiBodyEditor = new IdoCheckListBodyEditor(target);
            IIdoCheckListBuilder builder = new IdoCheckListBuilderImpl(headerEditor, hyojiBodyEditor);
            reportSourceWriter.writeLine(builder);
        }

    }

}
