/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.ikenshosakuseiiraiichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilder.ReportSourceBuilders;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
 * 主治医意見書作成依頼一覧Printerです。
 *
 */
public class IkenshoSakuseiIraiIchiranhyoService {

    /**
     * 主治医意見書作成依頼一覧を印刷します。
     *
     * @param itemList 主治医意見書作成依頼一覧_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<IkenshoSakuseiIraiIchiranhyoItem> itemList) {

        IkenshoSakuseiIraiIchiranhyoProperty property = new IkenshoSakuseiIraiIchiranhyoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<IkenshoSakuseiIraiIchiranhyoReportSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaSourceBuilderCreator builderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder builder = builderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
                        RDate.getNowDate(), assembler.getImageFolderPath());
                for (IkenshoSakuseiIraiIchiranhyoReport report : toReports(itemList, builder.buildSource())) {
                    ReportSourceWriter<IkenshoSakuseiIraiIchiranhyoReportSource> reportWriter = new ReportSourceWriter(assembler);
                    report.writeBy(reportWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private List<IkenshoSakuseiIraiIchiranhyoReport> toReports(
            List<IkenshoSakuseiIraiIchiranhyoItem> itemList, NinshoshaSource ninshoshaSource) {
        List<IkenshoSakuseiIraiIchiranhyoReport> list = new ArrayList<>();
        List<IkenshoSakuseiIraiIchiranhyoItem> newItemList = new ArrayList<>();
        for (IkenshoSakuseiIraiIchiranhyoItem item : itemList) {
            newItemList.add(setShokanKetteiTsuchiShoSealerReport(item, ninshoshaSource));
        }
        list.add(IkenshoSakuseiIraiIchiranhyoReport.createFrom(newItemList));
        return list;
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T>
            createAssembler(IReportProperty<T> property, ReportManager manager) {

        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaks : property.breakers()) {
            builder.addBreak(breaks);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }

    private IkenshoSakuseiIraiIchiranhyoItem
            setShokanKetteiTsuchiShoSealerReport(IkenshoSakuseiIraiIchiranhyoItem item,
                    NinshoshaSource ninshoshaSource) {

        return new IkenshoSakuseiIraiIchiranhyoItem(
                ninshoshaSource.hakkoYMD,
                item.getShichosonMei(),
                item.getShuchoMei(),
                ninshoshaSource.koinShoryaku,
                ninshoshaSource.denshiKoin,
                item.getPrintTimeStamp(),
                item.getPageCount(),
                item.getIryokikanName(),
                item.getYubinNo(),
                item.getIryokikanJusho(),
                item.getTitle(),
                item.getNo(),
                item.getShujiiName(),
                item.getHihokenshaNo(),
                item.getHihokenshaName(),
                item.getHihokenshaNameKana(),
                item.getJusho(),
                item.getSeinengappiYMD(),
                item.getSeibetsu(),
                item.getIkenshoSakuseiKigenYMD(),
                item.getToiawasesaki(),
                item.getShujiiIryokikanCode());
    }
}
