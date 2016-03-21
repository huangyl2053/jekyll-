/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.shujiiikenshosakuseitokusokujo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 主治医意見書提出督促状Printerです。
 *
 */
public class ShujiiIkenshoSakuseiTokusokujoService {

    /**
     * 主治医意見書提出督促状を印刷します。
     *
     * @param item 主治医意見書提出督促状作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ShujiiIkenshoSakuseiTokusokujoItem> item) {

        ShujiiIkenshoSakuseiTokusokujoProperty property = new ShujiiIkenshoSakuseiTokusokujoProperty();
        return new Printer<ShujiiIkenshoSakuseiTokusokujoReportSource>().spool(property, toReports(item));
    }

    private static List<ShujiiIkenshoSakuseiTokusokujoReport> toReports(List<ShujiiIkenshoSakuseiTokusokujoItem> item) {
        List<ShujiiIkenshoSakuseiTokusokujoReport> list = new ArrayList<>();
        list.add(ShujiiIkenshoSakuseiTokusokujoReport.createFrom(item));
        return list;
    }

//        ShujiiIkenshoSakuseiTokusokujoProperty property = new ShujiiIkenshoSakuseiTokusokujoProperty();
//        try (ReportManager reportManager = new ReportManager()) {
//            try (ReportAssembler<ShujiiIkenshoSakuseiTokusokujoReportSource> assembler = createAssembler(property, reportManager)) {
//                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
//                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
//                        RDate.getNowDate(), assembler.getImageFolderPath());
//                item = setShujiiIkenshoSakuseiTokusokujoItem(item);
//                ReportSourceWriter<ShujiiIkenshoSakuseiTokusokujoReportSource> reportSourceWriter
//                        = new ReportSourceWriter(assembler);
//                ShujiiIkenshoSakuseiTokusokujoReport.createFrom(item).writeBy(reportSourceWriter);
//            }
//            return reportManager.publish();
//        }
//    }
//
//    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
//            IReportProperty<T> property, ReportManager manager) {
//        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
//        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
//            builder.addBreak(breaker);
//        }
//        builder.isHojinNo(property.containsHojinNo());
//        builder.isKojinNo(property.containsKojinNo());
//        return builder.<T>create();
//    }
//
//    private static ShujiiIkenshoSakuseiTokusokujoItem
//            setShujiiIkenshoSakuseiTokusokujoItem(ShujiiIkenshoSakuseiTokusokujoItem item) {
//
//        return new ShujiiIkenshoSakuseiTokusokujoItem(
//                item.getBunshoNo(),
//                item.getDenshikoin(),
//                item.getHakkoYMD1(),
//                item.getKoinMojiretsu(),
//                item.getKoinShoryaku(),
//                item.getNinshoshaShimeiKakeru(),
//                item.getNinshoshaYakushokuMei(),
//                item.getNinshoshaShimeiKakenai(),
//                item.getNinshoshaYakushokuMei1(),
//                item.getNinshoshaYakushokuMei2(),
//                item.getAtenaRenban(),
//                item.getCustomerBarCode(),
//                item.getYubinNo1(),
//                item.getJushoText(),
//                item.getKikanNameText(),
//                item.getShimeiText(),
//                item.getMeishoFuyo(),
//                item.getSonota(),
//                item.getTsuchibun1(),
//                item.getTsuchibun2(),
//                item.getHihokenshaNo1(),
//                item.getHihokenshaNo2(),
//                item.getHihokenshaNo3(),
//                item.getHihokenshaNo4(),
//                item.getHihokenshaNo5(),
//                item.getHihokenshaNo6(),
//                item.getHihokenshaNo7(),
//                item.getHihokenshaNo8(),
//                item.getHihokenshaNo9(),
//                item.getHihokenshaNo10(),
//                item.getHokenshaNo1(),
//                item.getHokenshaNo2(),
//                item.getHokenshaNo3(),
//                item.getHokenshaNo4(),
//                item.getHokenshaNo5(),
//                item.getHokenshaNo6(),
//                item.getShinseiKubun(),
//                item.getHihokenshaNameKana(),
//                item.getHihokennsyaName(),
//                item.getShinseiYMD(),
//                item.getYubinNo(),
//                item.getJusho(),
//                item.getBirthYMD(),
//                item.getRemban(),
//                item.getSeyibenMan(),
//                item.getSeyibenWoman(),
//                item.getBirthGengoMeiji(),
//                item.getBirthGengoTaisho(),
//                item.getBirthGengoShowa(),
//                item.getShoriName());
//    }
}
