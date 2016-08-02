/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd550001;

import jp.co.ndensan.reams.db.dbd.business.report.dbd550001.YokaigoNinteiKyakkaTshuchishoProperty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd550001.YokaigoNinteiKyakkaTshuchishoReport;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteikekkatshuchishohakko.NinteikyakkaTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd550001.YokaigoNinteiKyakkaTshuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 要介護認定却下通知書
 *
 * @reamsid_L DBD-1430-060 b_zhengs
 */
public class YokaigoNinteiKyakkaTshuchishoPrintService {

    /**
     * 帳票を出力
     *
     * @param entity NinteikyakkaTsuchishoEntity
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param 帳票分類ID 帳票分類ID
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(NinteikyakkaTsuchishoEntity entity, ChohyoSeigyoKyotsu 帳票制御共通,
            ReportId 帳票分類ID, ReportManager reportManager) {
        YokaigoNinteiKyakkaTshuchishoProperty property = new YokaigoNinteiKyakkaTshuchishoProperty();
        try (ReportAssembler<YokaigoNinteiKyakkaTshuchishoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<YokaigoNinteiKyakkaTshuchishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, 帳票分類ID,
                    entity.getHakkoYMD(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                    KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            YokaigoNinteiKyakkaTshuchishoReport report = new YokaigoNinteiKyakkaTshuchishoReport(entity,
                    帳票制御共通,
                    ninshoshaSource);
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
