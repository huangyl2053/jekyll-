/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.jyuryoitakuatukaijigyoshatorokutsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.jyuryoitakuatukaijigyoshatorokutsuchisho.JyuryoItakuAtukaiJigyoshaTorokuTsuchishoProperty;
import jp.co.ndensan.reams.db.dbc.business.report.jyuryoitakuatukaijigyoshatorokutsuchisho.JyuryoItakuAtukaiJigyoshaTorokuTsuchishoReport;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hokenjuryoininharaitoriatsukai.HokenJuryoIninHaraiToriatsukaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.jyuryoitakuatukaijigyoshatorokutsuchishosource.JyuryoItakuAtukaiJigyoshaTorokuTsuchishoSource;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.core.toiawasesaki.Toiawasesaki;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.business.report.parts.toiawasesaki.IToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.ur.urz.business.report.parts.toiawasesaki._ToiawasesakiSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.toiawasesaki.ToiawasesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.toiawasesaki.IToiawasesakiFinder;
import jp.co.ndensan.reams.ur.urz.service.core.toiawasesaki.ToiawasesakiFinderFactory;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibun;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunFinder;
import jp.co.ndensan.reams.uz.uza.biz.BushoCode;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
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

    private static final SubGyomuCode サブ業務コード = SubGyomuCode.DBC介護給付;
    private static final ReportId ID = ReportIdDBC.DBC100032.getReportId();
    private static final int パターン番号 = 1;
    private static final int 項目番号_1 = 1;
    private static final int 項目番号_2 = 2;
    private static final GyomuCode 業務コード = GyomuCode.DB介護保険;
    private ToiawasesakiSource toiawasesakiSource;

    /**
     *
     * @param targets List<HokenJuryoIninHaraiToriatsukaiEntity>
     * @param 発行日 FlexibleDate
     * @return SourceDataCollection
     */
    public SourceDataCollection print(
            List<HokenJuryoIninHaraiToriatsukaiEntity> targets,
            FlexibleDate 発行日) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(targets, 発行日, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 介護保険受領委任払い取扱事業者登録通知書を印刷します。
     *
     * @param targets List<HokenJuryoIninHaraiToriatsukaiEntity>
     * @param 発行日 FlexibleDate
     * @param reportManager ReportManager
     */
    public void print(
            List<HokenJuryoIninHaraiToriatsukaiEntity> targets,
            FlexibleDate 発行日, ReportManager reportManager) {
        JyuryoItakuAtukaiJigyoshaTorokuTsuchishoProperty property = new JyuryoItakuAtukaiJigyoshaTorokuTsuchishoProperty();
        try (ReportAssembler<JyuryoItakuAtukaiJigyoshaTorokuTsuchishoSource> assembler = createAssembler(property, reportManager)) {
            IBunshoNoFinder finder = BunshoNoFinderFactory.createInstance();
            RString 文書番号 = finder.get文書番号管理(ID, FlexibleDate.getNowDate()).edit文書番号();
            if (文書番号 == null) {
                文書番号 = RString.EMPTY;
            }

            RString 通知書定型文１ = RString.EMPTY;
            TsuchishoTeikeibun keibun1 = new TsuchishoTeikeibunFinder()
                    .get通知書定型文(サブ業務コード, ID, KamokuCode.EMPTY, パターン番号, 項目番号_1, FlexibleDate.getNowDate());
            if (keibun1 != null) {
                // TODO QA:874
                通知書定型文１ = keibun1.get文章();
            }

            RString 通知書定型文2 = RString.EMPTY;
            TsuchishoTeikeibun keibun2 = new TsuchishoTeikeibunFinder()
                    .get通知書定型文(サブ業務コード, ID, KamokuCode.EMPTY, パターン番号, 項目番号_2, FlexibleDate.getNowDate());
            if (keibun2 != null) {
                // TODO QA:874
                通知書定型文2 = keibun2.get文章();
            }

            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().
                    get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), 発行日);
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者, 地方公共団体, assembler.getImageFolderPath(), new RDate(発行日.toString())).buildSource();

            IToiawasesakiFinder iToiawasesakiFinder = ToiawasesakiFinderFactory.createInstance();
            Toiawasesaki toiawase = iToiawasesakiFinder.get問合せ先(業務コード, ID, BushoCode.EMPTY, RDate.getNowDate());
            IToiawasesakiSourceBuilder 問合せ先 = _ToiawasesakiSourceBuilderFactory.createInstance(toiawase);
            if (問合せ先 != null) {
                toiawasesakiSource = 問合せ先.buildSource();
            }

            ReportSourceWriter<JyuryoItakuAtukaiJigyoshaTorokuTsuchishoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new JyuryoItakuAtukaiJigyoshaTorokuTsuchishoReport(targets, sourceBuilder, toiawasesakiSource,
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
