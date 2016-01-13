/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.nenreitotatsukakuninlist;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.nenreitotatsukakuninlist.NenreitotatsuKakuninListReportSource;

import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * @author yuyong3
 */
public class NenreitotatsuKakuninListReport extends Report<NenreitotatsuKakuninListReportSource> {

    private final List<NenreitotatsuKakuninListItem> targets;

    protected NenreitotatsuKakuninListReport(List<NenreitotatsuKakuninListItem> targets) {
        this.targets = targets;

    }

    public static NenreitotatsuKakuninListReport createFrom(@NonNull List<NenreitotatsuKakuninListItem> NenreitotatsuKakuninListItems) {
        return new NenreitotatsuKakuninListReport(NenreitotatsuKakuninListItems);

    }

    /**
     *
     * @param reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<NenreitotatsuKakuninListReportSource> reportSourceWriter) {
        for (NenreitotatsuKakuninListItem target : targets) {
            INenreitotatsuKakuninListEdiotr headerEditor = new NenreitotatsuKakuninListHeaderEditor(target);
            INenreitotatsuKakuninListEdiotr hyojiBodyEditor = new NenreitotatsuKakuninListBodyEdiotr(target);
            INenreitotatsuKakuninListBuilder builder = new NenreitotatsuKakuninListBuilderImpl(headerEditor, hyojiBodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
