/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd100030;

import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.KenshoKakuninshoinfo;
import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.ShugiiIkenshoKakuninshoEntity;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100030.ShujiiIkenshoKakuninshoProperty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100030.ShujiiIkenshoKakuninshoReport;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100030.ShujiiIkenshoKakuninshoReportSource;
import jp.co.ndensan.reams.db.dbd.service.core.iryohikojokakuninsinsei.IryoHiKojoKakuninSinsei;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
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
 * 主治医意見書確認書帳票クラスです。
 *
 * @reamsid_L DBD-5790-030 x_zhaowen
 */
public class ShujiiIkenshoKakuninshoPrintService {

    /**
     * printメソッド(単一帳票出力用)
     *
     * @param 主治医意見書確認書情報 KenshoKakuninshoinfo
     * @return collection
     */
    public SourceDataCollection printSingle(KenshoKakuninshoinfo 主治医意見書確認書情報) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            ShugiiIkenshoKakuninshoEntity 主治医意見書確認書Entity = IryoHiKojoKakuninSinsei.createIntance().editsyujiikensho_Kakunisho(主治医意見書確認書情報);
            print(reportManager, 主治医意見書確認書Entity, 主治医意見書確認書情報);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票を出力
     *
     * @param reportManager ReportManager
     * @param 主治医意見書確認書Entity ShugiiIkenshoKakuninshoEntity
     * @param 主治医意見書確認書情報 ShugiiIkenshoKakuninshoEntity
     */
    public void print(ReportManager reportManager, ShugiiIkenshoKakuninshoEntity 主治医意見書確認書Entity, KenshoKakuninshoinfo 主治医意見書確認書情報) {
        ShujiiIkenshoKakuninshoProperty property = new ShujiiIkenshoKakuninshoProperty();
        try (ReportAssembler<ShujiiIkenshoKakuninshoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<ShujiiIkenshoKakuninshoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            NinshoshaSource 認証者ソースビルダー = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, new ReportId(主治医意見書確認書情報.get帳票分類ID()),
                    new FlexibleDate(主治医意見書確認書情報.get作成日().toDateString()), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                    KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            主治医意見書確認書Entity.set認証者(認証者ソースビルダー);
            ShujiiIkenshoKakuninshoReport report = new ShujiiIkenshoKakuninshoReport(主治医意見書確認書Entity);
            report.writeBy(reportSourceWriter);
        }
    }

    private <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}
