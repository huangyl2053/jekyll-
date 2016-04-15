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
 * 異動チェックリスト帳票作成。
 *
 * @reamsid_L DBA-0530-060 xuyue
 */
public class IdoCheckListReport extends Report<IdoCheckListReportSource> {

    private final List<IdoCheckListItem> targets;

    /**
     * コンストラクタです。
     *
     * @param targets IdoCheckListItem
     */
    protected IdoCheckListReport(List<IdoCheckListItem> targets) {
        this.targets = targets;
    }

    /**
     * インスタンスを生成します。
     *
     * @param idoCheckListItems 異動チェックリストのITEMリスト
     * @return 異動チェックリストのReport
     */
    public static IdoCheckListReport createFrom(@NonNull List<IdoCheckListItem> idoCheckListItems) {
        return new IdoCheckListReport(idoCheckListItems);
    }

    /**
     *
     * @param reportSourceWriter IdoCheckListReportSource
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
