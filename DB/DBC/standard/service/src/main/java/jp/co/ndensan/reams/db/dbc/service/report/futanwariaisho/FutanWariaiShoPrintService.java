/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.futanwariaisho;

import jp.co.ndensan.reams.db.dbc.business.report.futanwariaisho.FutanWariaiShoProperty;
import jp.co.ndensan.reams.db.dbc.business.report.futanwariaisho.FutanWariaiShoReport;
import jp.co.ndensan.reams.db.dbc.entity.report.source.futanwariaisho.FutanWariaiShoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.futanwariaisho.FutanWariaiShoSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
 * 帳票設計_DBC100065_負担割合証PrintService
 *
 * @reamsid_L DBC-5010-030 surun
 */
public class FutanWariaiShoPrintService {

    private static final RString 種別コード = NinshoshaDenshikoinshubetsuCode.保険者印.getコード();
    private static final ReportId 帳票分類ID = new ReportId("DBC100065_FutanWariaiSho");
    private static final RString RSTRING_1 = new RString("1");

    /**
     * printSingle
     *
     * @param entity FutanWariaiShoEntity
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(FutanWariaiShoEntity entity) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(entity, reportManager);
            collection = reportManager.publish();
        }
        return collection;

    }

    /**
     * print
     *
     * @param entity FutanWariaiShoEntity
     * @param reportManager ReportManager
     */
    public void print(FutanWariaiShoEntity entity, ReportManager reportManager) {
        FutanWariaiShoProperty property = new FutanWariaiShoProperty();
        try (ReportAssembler<FutanWariaiShoSource> assembler
                = createAssembler(property, reportManager)) {

            Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険, 種別コード,
                    FlexibleDate.getNowDate());
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
            ChohyoSeigyoKyotsu 帳票制御共通 = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付, 帳票分類ID);
            boolean is公印に掛ける = false;
            boolean is公印を省略 = false;
            if (RSTRING_1.equals(帳票制御共通.get首長名印字位置())) {
                is公印に掛ける = true;
            }
            if (!帳票制御共通.is電子公印印字有無()) {
                is公印を省略 = true;
            }
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                    地方公共団体,
                    assembler.getImageFolderPath(),
                    RDate.getNowDate(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();

            ReportSourceWriter<FutanWariaiShoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            FutanWariaiShoReport report = new FutanWariaiShoReport(entity, sourceBuilder);
            report.writeBy(reportSourceWriter);
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
