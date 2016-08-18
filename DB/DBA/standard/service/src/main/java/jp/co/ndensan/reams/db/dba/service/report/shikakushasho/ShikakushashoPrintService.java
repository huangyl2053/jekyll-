/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.shikakushasho;

import jp.co.ndensan.reams.db.dba.business.report.shikakushasho.ShikakushashoBodyItem;
import jp.co.ndensan.reams.db.dba.business.report.shikakushasho.ShikakushashoJoho;
import jp.co.ndensan.reams.db.dba.business.report.shikakushasho.ShikakushashoProerty;
import jp.co.ndensan.reams.db.dba.business.report.shikakushasho.ShikakushashoReport;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.shikakushasho.ShikakushashoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilders.ReportSourceBuilders;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護保険資格者証Printクラスです。
 *
 * @reamsid_L DBU-0490-080 suguangjun
 */
public class ShikakushashoPrintService {

    private DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通Entity;
    private DbT7065ChohyoSeigyoKyotsuDac dbT7065dac;

    /**
     * 介護保険資格者証Printします。
     *
     * @param reportJoho 介護保険資格者証作成_帳票クラスパラメータ
     * @return 介護保険資格者証作成_帳票
     */
    public SourceDataCollection print(ShikakushashoJoho reportJoho) {
        ShikakushashoProerty property = new ShikakushashoProerty();
        dbT7065dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        帳票制御共通Entity = dbT7065dac.selectByKey(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA100003.getReportId());
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<ShikakushashoReportSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<ShikakushashoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                RString 認証者電子公印種別コード;
                if (帳票制御共通Entity.getDenshiKoinInjiUmu()) {
                    認証者電子公印種別コード = NinshoshaDenshikoinshubetsuCode.保険者印.getコード();
                } else {
                    認証者電子公印種別コード = NinshoshaDenshikoinshubetsuCode.印の字.getコード();
                }
                INinshoshaSourceBuilderCreator builderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSource = builderCreator.create(
                        GyomuCode.DB介護保険,
                        認証者電子公印種別コード,
                        null,
                        reportSourceWriter.getImageFolderPath());
                for (ShikakushashoBodyItem item : reportJoho.getBodyItem()) {
                    item.setDenshiKoin(ninshoshaSource.buildSource().denshiKoin);
                }
                ShikakushashoReport report = ShikakushashoReport.createReport(reportJoho.getBodyItem());
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
