/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.realservice.report;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorInternalReport;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorInternalReportItem;
import jp.co.ndensan.reams.db.dbb.business.report.FukaErrorListBuilder;
import jp.co.ndensan.reams.db.dbb.business.report.parts.IFukaErrorListEditor;
import jp.co.ndensan.reams.db.dbb.business.report.parts.FukaErrorListSource;
import jp.co.ndensan.reams.db.dbb.business.report.parts.FukaErrorListEditorFactory;
import jp.co.ndensan.reams.ur.urz.business.internalreport.IInternalReportCommon;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 賦課エラー一覧内部帳票のプリンタです。
 *
 * @author N9606 漢那 憲作
 */
public class FukaErrorListPrinter {

    private static final RString REPORT_ID;

    static {
        REPORT_ID = new RString("FukaErrorList");
    }

    /**
     * 引数から印刷対象の賦課エラー一覧を受け取り、ソースデータに変換して返します。
     *
     * @param report 賦課エラー一覧
     * @return 帳票ソースデータ
     */
    public SourceDataCollection print(FukaErrorInternalReport report) {
        try (ReportManager manager = new ReportManager()) {
            try (ReportAssembler<FukaErrorListSource> assembler = manager
                    .reportAssembler(REPORT_ID)
                    .create()) {

                List<FukaErrorListSource> editorList = new ArrayList<>();
                for (FukaErrorInternalReportItem item : report.getInternalReportItemList()) {
                    IFukaErrorListEditor editor = FukaErrorListEditorFactory.createInstance(report, item);
                    FukaErrorListBuilder builder = new FukaErrorListBuilder(editor);
                    editorList.add(builder.buildSource());
                }
                assembler.writeMultiLine(editorList);
            }
            return manager.publish();
        }
    }
}
