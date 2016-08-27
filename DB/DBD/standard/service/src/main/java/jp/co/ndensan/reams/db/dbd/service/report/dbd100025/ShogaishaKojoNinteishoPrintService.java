/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd100025;

import jp.co.ndensan.reams.db.dbd.business.core.dbt4030011.NinteishoJohoBusiness;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100025.ShogaishaKojoNinteishoProperty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100025.ShogaishaKojoNinteishoReport;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd4030011.NinteishoJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100025.NinteishoJohoReportSource;
import jp.co.ndensan.reams.db.dbd.service.core.ninteishojoho.NinteiShoJohoFinder;
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
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 障がい者控除対象者認定ハンドラクラスです
 *
 * @reamsid_L DBD-3870-010 jinge
 */
public class ShogaishaKojoNinteishoPrintService {

    /**
     * 帳票を出力します。
     *
     * @param target 認定書情報Entity
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(NinteishoJohoBusiness target, ReportManager reportManager) {
        ShogaishaKojoNinteishoProperty property = new ShogaishaKojoNinteishoProperty();
        try (ReportAssembler<NinteishoJohoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<NinteishoJohoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            target.set文書番号(NinteiShoJohoFinder.createInstance().文書番号取得());
            NinteishoJohoEntity ninteishoJohoentity = NinteiShoJohoFinder.createInstance().set障がい者控除と認定年月日(target.get被保険者番号());
            if (ninteishoJohoentity != null) {
                target.set障害理由区分(ninteishoJohoentity.get障害理由区分());
                target.set障害理由内容(ninteishoJohoentity.get障害理由内容());
                target.set要介護認定日(ninteishoJohoentity.get要介護認定日());
                target.set対象年度(ninteishoJohoentity.get対象年度());
            }
            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100025.getReportId(),
                    FlexibleDate.getNowDate(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                    KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            ShogaishaKojoNinteishoReport report = new ShogaishaKojoNinteishoReport(target.getNinteishoJohoEntity(), ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private <T extends IReportSource, R extends Report<T>> ReportAssembler<T>
            createAssembler(IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}
