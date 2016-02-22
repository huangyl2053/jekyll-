/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.juryoininharaikeiyakushinseisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.juryoininharaikeiyakushinseisho.JuryoIninharaiKeiyakuShinseishoItem;
import jp.co.ndensan.reams.db.dba.business.report.juryoininharaikeiyakushinseisho.JuryoIninharaiKeiyakuShinseishoProerty;
import jp.co.ndensan.reams.db.dba.business.report.juryoininharaikeiyakushinseisho.JuryoIninharaiKeiyakuShinseishoReport;
import jp.co.ndensan.reams.db.dba.entity.report.juryoininharaikeiyakushinseisho.JuryoIninharaiKeiyakuShinseishoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilder.ReportSourceBuilders;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
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
 *
 * 介護保険受領委任払い契約申請書Printクラスです。
 */
public class JuryoIninbaraiKeiyakuShinseisho {
     
    private final static RString 住宅福祉出力区分_住宅改修用 = new RString("1");
    private final static RString 住宅福祉出力区分_福祉用具用 = new RString("2");
    
    /**
     * 介護保険受領委任払い契約申請書Printします。
     *
     * @param 住宅福祉出力区分 住宅福祉出力区分
     * @return 介護保険受領委任払い契約申請書作成_帳票
     */
    public SourceDataCollection createJuryoIninbaraiKeiyakuShinseishoChohyo(
            RString 住宅福祉出力区分) {
        JuryoIninharaiKeiyakuShinseishoProerty proerty = new JuryoIninharaiKeiyakuShinseishoProerty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<JuryoIninharaiKeiyakuShinseishoReportSource> assembler = createAssembler(proerty, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険,
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        null, null);
                for (JuryoIninharaiKeiyakuShinseishoReport report : toReports(住宅福祉出力区分,
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei)) {
                    ReportSourceWriter<JuryoIninharaiKeiyakuShinseishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private List<JuryoIninharaiKeiyakuShinseishoReport> toReports(RString 住宅福祉出力区分,
            RString ninshoshaYakushokuMei) {
        List<JuryoIninharaiKeiyakuShinseishoReport> list = new ArrayList<>();
        
        
        JuryoIninharaiKeiyakuShinseishoItem item = new JuryoIninharaiKeiyakuShinseishoItem(ninshoshaYakushokuMei,
                RString.EMPTY,
                get文言項目(住宅福祉出力区分).get(0),
                get文言項目(住宅福祉出力区分).get(1),
                get文言項目(住宅福祉出力区分).get(2),
                get文言項目(住宅福祉出力区分).get(3),
                get文言項目(住宅福祉出力区分).get(4));
        list.add(JuryoIninharaiKeiyakuShinseishoReport.createReport(item));
        return list;

    }
    
    private List<RString> get文言項目(RString 住宅福祉出力区分) {
        List<RString> 文言項目List = new ArrayList<>();
        if (住宅福祉出力区分_福祉用具用.equals(住宅福祉出力区分)) {
            文言項目List.add(get帳票文言(2, 2));
            文言項目List.add(get帳票文言(2, 3));
            文言項目List.add(get帳票文言(2, 4));
            文言項目List.add(get帳票文言(2, 5));
            文言項目List.add(get帳票文言(2, 1));
            return 文言項目List;
        } else if (住宅福祉出力区分_住宅改修用.equals(住宅福祉出力区分)) {
            文言項目List.add(get帳票文言(1, 2));
            文言項目List.add(get帳票文言(1, 3));
            文言項目List.add(get帳票文言(1, 4));
            文言項目List.add(get帳票文言(1, 5));
            文言項目List.add(get帳票文言(1, 1));
            return 文言項目List;
        } else {
            文言項目List.add(RString.EMPTY);
            文言項目List.add(RString.EMPTY);
            文言項目List.add(RString.EMPTY);
            文言項目List.add(RString.EMPTY);
            文言項目List.add(RString.EMPTY);
            return 文言項目List;
        }
    }
    
    private RString get帳票文言(int パタン番号, int 項目番号) {
        TsuchishoTeikeibunManager tsuchisho = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = tsuchisho.get通知書定形文検索(
                SubGyomuCode.DBC介護給付,
                new ReportId("DBC800002_JuryoIninharaiKeiyakuShinseisho"),
                KamokuCode.EMPTY,
                パタン番号,
                項目番号,
                new FlexibleDate(RDate.getNowDate().toDateString()));
        if (tsuchishoTeikeibunInfo != null) {
            if (tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity() != null) {
                return tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity().getSentence();
            }
        }
        return RString.EMPTY;
    }

    private <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
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
