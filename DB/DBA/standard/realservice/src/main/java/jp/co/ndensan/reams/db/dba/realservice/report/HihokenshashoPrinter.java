/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice.report;

import jp.co.ndensan.reams.db.dba.business.report.DBA10000X.HihokenshashoBuilderFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.db.dba.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dba.model.report.DBA10000X.IHihokenshasho;
import jp.co.ndensan.reams.db.dba.model.report.DBA10000X.HihokenshashoA4;
import jp.co.ndensan.reams.db.dba.model.report.DBA10000X.HihokenshashoB4;
import jp.co.ndensan.reams.ur.urz.business.report.IReportBuilder;
import jp.co.ndensan.reams.ur.urz.realservice.report.core.IReportManager;
import jp.co.ndensan.reams.ur.urz.realservice.report.core.IReportWriter;
import jp.co.ndensan.reams.ur.urz.realservice.report.core.ReportManagerFactory;

/**
 * 被保険者証を発行するために使用するPrinterクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshashoPrinter {

    private static final RString REPORT_ID_B4;
    private static final RString REPORT_ID_A4;

    static {
        REPORT_ID_B4 = new RString("DBA100001");
        REPORT_ID_A4 = new RString("DBA100002");
    }

    /**
     * 引数から印刷対象の賦課エラー一覧を受け取り、ソースデータに変換して返します。
     *
     * @param target 印字する被保険者証情報
     * @return 帳票ソースデータ
     */
    public SourceDataCollection print(HihokenshashoModel target) {
        Class formType;
        RString reportId;
        IReportBuilder<IHihokenshasho> builder;

        //TODO
        //1, 印刷対象のレポートIDを、DBA業務コンフィグ_被保険者証表示方法_証表示タイプの値に合わせて設定する。
        //   また、使用するBuilderもここで取得する。
        //  1-1, "01"(A4横)の場合、REPORT_ID_A4を設定する。
        formType = HihokenshashoA4.class;
        reportId = REPORT_ID_A4;
        builder = HihokenshashoBuilderFactory
                .createInstanceForA4(target //,
                //ReportSourceEditors.atesakiEditor().create()
                );
        //  1-2, "21"(B4横)の場合、REPORT_ID_B4を設定する。
        formType = HihokenshashoB4.class;
        reportId = REPORT_ID_B4;
        builder = HihokenshashoBuilderFactory
                .createInstanceForB4(target //,
                //ReportSourceEditors.atesakiEditor().create()
                );

        return print(formType, reportId, builder);
    }

    private SourceDataCollection print(Class formType, RString reportId, IReportBuilder<IHihokenshasho> builder) {
        try (IReportManager manager = ReportManagerFactory.createInstance()) {
            try (IReportWriter<IHihokenshasho> writer
                    = manager.reportWriter(formType)
                    .reportId(reportId)
                    .create()) {

                /* ソースファイルへ出力 */
                writer.writeLine(builder);
            }
            return manager.publish();
        }
    }
}
