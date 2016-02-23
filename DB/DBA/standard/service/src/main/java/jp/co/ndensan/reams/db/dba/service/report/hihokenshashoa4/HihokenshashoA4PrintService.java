/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.hihokenshashoa4;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4.HihokenshashoA4BodyItem;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4.HihokenshashoA4Joho;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4.HihokenshashoA4Proerty;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4.HihokenshashoA4Report;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashoa4.HihokenshashoA4ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilder.ReportSourceBuilders;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
 *
 * 介護保険被保険者証Printクラスです。
 */
public class HihokenshashoA4PrintService {

    /**
     * 介護保険被保険者証Printします。
     *
     * @param bodyItemlist 介護保険被保険者証作成_帳票クラスパラメータ
     * @return 介護保険被保険者証作成_帳票
     */
    public SourceDataCollection print(List<HihokenshashoA4BodyItem> bodyItemlist) {
        HihokenshashoA4Proerty property = new HihokenshashoA4Proerty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HihokenshashoA4ReportSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険,
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), null, RString.EMPTY);
                for (HihokenshashoA4BodyItem bodyItem : bodyItemlist) {
                    bodyItem = new HihokenshashoA4BodyItem(
                            bodyItem.getYukokigen(),
                            bodyItem.getYukokigen2(),
                            bodyItem.getHihokenshanno(),
                            bodyItem.getYubinno(),
                            bodyItem.getGyoseiku(),
                            bodyItem.getGyoseikuS(),
                            bodyItem.getHihojusho(),
                            bodyItem.getHihokana(),
                            bodyItem.getHihoname(),
                            bodyItem.getUmareG(),
                            bodyItem.getUmareYyyy(),
                            bodyItem.getUmareMm(),
                            bodyItem.getUmareDd(),
                            bodyItem.getSeibetsu(),
                            bodyItem.getKofuymd(),
                            bodyItem.getSaikofu1(),
                            bodyItem.getHokenshano1(),
                            bodyItem.getHokenshano2(),
                            bodyItem.getHokenshano3(),
                            bodyItem.getHokenshano4(),
                            bodyItem.getHokenshano5(),
                            bodyItem.getHokenshano6(),
                            bodyItem.getKaigokbn(),
                            bodyItem.getNinteiymd(),
                            bodyItem.getYukokikanst(),
                            bodyItem.getYukokikannamisen(),
                            bodyItem.getYukokikaned(),
                            bodyItem.getHomonkikanst(),
                            bodyItem.getHomonkikannamisen(),
                            bodyItem.getHomonkikaned(),
                            bodyItem.getService1(),
                            bodyItem.getTen0(),
                            bodyItem.getShurui1(),
                            bodyItem.getShurui2(),
                            bodyItem.getShurui3(),
                            bodyItem.getShurui4(),
                            bodyItem.getShurui5(),
                            bodyItem.getShurui6(),
                            bodyItem.getShuruigendo1(),
                            bodyItem.getShuruigendo2(),
                            bodyItem.getShuruigendo3(),
                            bodyItem.getShuruigendo4(),
                            bodyItem.getShuruigendo5(),
                            bodyItem.getShuruigendo6(),
                            bodyItem.getTen1(),
                            bodyItem.getTen2(),
                            bodyItem.getTen3(),
                            bodyItem.getTen4(),
                            bodyItem.getTen5(),
                            bodyItem.getTen6(),
                            bodyItem.getRyui(),
                            bodyItem.getSaikofu2(),
                            bodyItem.getSeigen1(),
                            bodyItem.getSeigenLong1(),
                            bodyItem.getSeigen2(),
                            bodyItem.getSeigenLong2(),
                            bodyItem.getSeigen3(),
                            bodyItem.getSeigenLong3(),
                            bodyItem.getSeigen4(),
                            bodyItem.getSeigenLong4(),
                            bodyItem.getSeigen5(),
                            bodyItem.getSeigenLong5(),
                            bodyItem.getSeigen6(),
                            bodyItem.getSeigenLong6(),
                            bodyItem.getSeigenSt1(),
                            bodyItem.getSeigenEd1(),
                            bodyItem.getSeigenSt2(),
                            bodyItem.getSeigenEd2(),
                            bodyItem.getSeigenSt3(),
                            bodyItem.getSeigenEd3(),
                            bodyItem.getGyosha1(),
                            bodyItem.getTodokeYmd1(),
                            bodyItem.getGyosha2(),
                            bodyItem.getTodokeYmd2(),
                            bodyItem.getGyosha3(),
                            bodyItem.getTodokeYmd3(),
                            bodyItem.getShisetsuSyu1(),
                            bodyItem.getShisetsuname1(),
                            bodyItem.getNyushochk1(),
                            bodyItem.getNyuinchk1(),
                            bodyItem.getTaishochk1(),
                            bodyItem.getTaiinchk1(),
                            bodyItem.getNyushoymd1(),
                            bodyItem.getTaiinymd1(),
                            bodyItem.getShisetsuSyu2(),
                            bodyItem.getShisetsuname2(),
                            bodyItem.getNyushochk2(),
                            bodyItem.getNyuinchk2(),
                            bodyItem.getTaishochk2(),
                            bodyItem.getTaiinchk2(),
                            bodyItem.getNyushoymd2(),
                            bodyItem.getTaiinymd2(),
                            bodyItem.getRenban(),
                            bodyItem.getSeiShogai11(),
                            bodyItem.getSeiShogai12(),
                            bodyItem.getKosekiSeibetsu11(),
                            bodyItem.getKosekiSeibetsu12(),
                            bodyItem.getItakuGyosha1(),
                            bodyItem.getItakuGyosha2(),
                            bodyItem.getItakuGyosha3(),
                            ninshoshaSourceBuilder.buildSource().denshiKoin);
                    for (HihokenshashoA4Report report : toReports(new HihokenshashoA4Joho(bodyItem))) {
                        ReportSourceWriter<HihokenshashoA4ReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                        report.writeBy(reportSourceWriter);
                    }
                }
            }
            return reportManager.publish();
        }
    }

    private static List<HihokenshashoA4Report> toReports(HihokenshashoA4Joho joho) {
        List<HihokenshashoA4Report> list = new ArrayList<>();
        list.add(HihokenshashoA4Report.createReport(joho.getBodyItem()));
        return list;
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
