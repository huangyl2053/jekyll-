/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.hihokenshashoa4;

import jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4.HihokenshashoA4BodyItem;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4.HihokenshashoA4Joho;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4.HihokenshashoA4Proerty;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4.HihokenshashoA4Report;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashoa4.HihokenshashoA4ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 介護保険被保険者証Printクラスです。
 *
 * @reamsid_L DBU-0490-070 suguangjun
 */
public class HihokenshashoA4PrintService {

    /**
     * 介護保険被保険者証Printします。
     *
     * @param hihokenshashoA4Joho 介護保険被保険者証作成_帳票クラスパラメータ
     * @return 介護保険被保険者証作成_帳票
     */
    public SourceDataCollection print(HihokenshashoA4Joho hihokenshashoA4Joho) {
        HihokenshashoA4Proerty property = new HihokenshashoA4Proerty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HihokenshashoA4ReportSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HihokenshashoA4ReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBA介護資格,
                        property.reportId(),
                        FlexibleDate.getNowDate(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        KenmeiFuyoKubunType.付与なし,
                        reportSourceWriter);
                for (HihokenshashoA4BodyItem item : hihokenshashoA4Joho.getBodyItem()) {
                    item.setImageField1(ninshoshaSource.denshiKoin);
                }
                HihokenshashoA4Report report = HihokenshashoA4Report.createReport(hihokenshashoA4Joho.getBodyItem());
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
            IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}
