/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.jyuryoitakuatukaijigyoshatorokutsuchisho;

import jp.co.ndensan.reams.db.dbc.business.report.jyuryoitakuatukaijigyoshatorokutsuchisho.JyuryoItakuAtukaiJigyoshaTorokuTsuchishoProperty;
import jp.co.ndensan.reams.db.dbc.business.report.jyuryoitakuatukaijigyoshatorokutsuchisho.JyuryoItakuAtukaiJigyoshaTorokuTsuchishoReport;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hokenjuryoininharaitoriatsukai.HokenJuryoIninHaraiToriatsukaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.jyuryoitakuatukaijigyoshatorokutsuchishosource.JyuryoItakuAtukaiJigyoshaTorokuTsuchishoSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.toiawasesaki.Toiawasesaki;
import jp.co.ndensan.reams.ur.urz.business.report.parts.toiawasesaki.IToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.ur.urz.business.report.parts.toiawasesaki._ToiawasesakiSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.toiawasesaki.ToiawasesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.toiawasesaki.IToiawasesakiFinder;
import jp.co.ndensan.reams.ur.urz.service.core.toiawasesaki.ToiawasesakiFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.BushoCode;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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

/**
 * 帳票設計_DBC100032_介護保険受領委任払い取扱事業者登録通知書 PrintService
 *
 * @reamsid_L DBC-2120-050 sunhui
 */
public class JyuryoItakuAtukaiJigyoshaTorokuTsuchishoPrintService {

    private static final int パターン番号 = 1;
    private static final int 項目番号_1 = 1;
    private static final int 項目番号_2 = 2;

    /**
     * 介護保険受領委任払い取扱事業者登録通知書を印刷します。
     *
     * @param target HokenJuryoIninHaraiToriatsukaiEntity
     * @param 発行日 FlexibleDate
     * @return SourceDataCollection
     */
    public SourceDataCollection print(
            HokenJuryoIninHaraiToriatsukaiEntity target,
            FlexibleDate 発行日) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(target, 発行日, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 介護保険受領委任払い取扱事業者登録通知書を印刷します。
     *
     * @param target HokenJuryoIninHaraiToriatsukaiEntity
     * @param 発行日 FlexibleDate
     * @param reportManager ReportManager
     */
    private void print(
            HokenJuryoIninHaraiToriatsukaiEntity target,
            FlexibleDate 発行日, ReportManager reportManager) {
        JyuryoItakuAtukaiJigyoshaTorokuTsuchishoProperty property = new JyuryoItakuAtukaiJigyoshaTorokuTsuchishoProperty();
        try (ReportAssembler<JyuryoItakuAtukaiJigyoshaTorokuTsuchishoSource> assembler = createAssembler(property, reportManager)) {
            IBunshoNoFinder finder = BunshoNoFinderFactory.createInstance();
            RString 文書番号 = finder.get文書番号管理(ReportIdDBC.DBC100032.getReportId(), FlexibleDate.getNowDate()).edit文書番号();
            if (文書番号 == null) {
                文書番号 = RString.EMPTY;
            }

            RString 通知書定型文１ = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100032.getReportId(),
                    KamokuCode.EMPTY, パターン番号, 項目番号_1, FlexibleDate.getNowDate());

            RString 通知書定型文2 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100032.getReportId(),
                    KamokuCode.EMPTY, パターン番号, 項目番号_2, FlexibleDate.getNowDate());

            ReportSourceWriter<JyuryoItakuAtukaiJigyoshaTorokuTsuchishoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource sourceBuilder = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC100032.getReportId(), 発行日, NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                    KenmeiFuyoKubunType.付与なし, reportSourceWriter);

            IToiawasesakiFinder iToiawasesakiFinder = ToiawasesakiFinderFactory.createInstance();
            Toiawasesaki toiawase = iToiawasesakiFinder.
                    get問合せ先(GyomuCode.DB介護保険, ReportIdDBC.DBC100032.getReportId(),
                            BushoCode.EMPTY, RDate.getNowDate());
            IToiawasesakiSourceBuilder 問合せ先 = _ToiawasesakiSourceBuilderFactory.createInstance(toiawase);
            ToiawasesakiSource toiawasesakiSource = null;
            if (問合せ先 != null) {
                toiawasesakiSource = 問合せ先.buildSource();
            }

            new JyuryoItakuAtukaiJigyoshaTorokuTsuchishoReport(target, sourceBuilder, toiawasesakiSource,
                    文書番号, 通知書定型文１, 通知書定型文2).writeBy(reportSourceWriter);
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
