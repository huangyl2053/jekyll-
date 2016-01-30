/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.shokanketteitsuchishoshiharaiyoteibiyijinashi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerItem;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerProperty;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerReport;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoSealerReportSource;
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
 * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）Printerです。
 */
public class ShokanKetteiTsuchiShoSealerService {

    /**
     * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）を印刷します。
     *
     * @param itemList 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ShokanKetteiTsuchiShoSealerItem> itemList) {

        ShokanKetteiTsuchiShoSealerProperty property = new ShokanKetteiTsuchiShoSealerProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<ShokanKetteiTsuchiShoSealerReportSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaSourceBuilderCreator builderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder builder = builderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
                        RDate.getNowDate(), assembler.getImageFolderPath());
                for (ShokanKetteiTsuchiShoSealerReport report : toReports(itemList, builder.buildSource())) {
                    ReportSourceWriter<ShokanKetteiTsuchiShoSealerReportSource> reportWriter = new ReportSourceWriter(assembler);
                    report.writeBy(reportWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private List<ShokanKetteiTsuchiShoSealerReport> toReports(
            List<ShokanKetteiTsuchiShoSealerItem> itemList, NinshoshaSource ninshoshaSource) {
        List<ShokanKetteiTsuchiShoSealerReport> list = new ArrayList<>();
        List<ShokanKetteiTsuchiShoSealerItem> newItemList = new ArrayList<>();
        for (ShokanKetteiTsuchiShoSealerItem item : itemList) {
            newItemList.add(setShokanKetteiTsuchiShoSealerReport(item, ninshoshaSource));
        }
        list.add(ShokanKetteiTsuchiShoSealerReport.createFrom(newItemList));
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

    private ShokanKetteiTsuchiShoSealerItem
            setShokanKetteiTsuchiShoSealerReport(ShokanKetteiTsuchiShoSealerItem item,
                    NinshoshaSource ninshoshaSource) {

        return new ShokanKetteiTsuchiShoSealerItem(
                item.getTsuban(),
                item.getTitle1(),
                item.getBunshoNo(),
                item.getPage(),
                item.getPages(),
                item.getTitle(),
                item.getTitle2(),
                item.getHihokenshaName2(),
                item.getHihokenshaNo(),
                item.getHihokenshaName(),
                item.getTsuchibun1(),
                item.getKetteiYMD(),
                item.getShiharaiGaku(),
                item.getShiharaiYoteiYMD(),
                item.getKyufuShurui1(),
                item.getTaishoYM1(),
                item.getShikyuGaku1(),
                item.getYen1(),
                item.getInfo(),
                item.getKyufuShurui2(),
                item.getTaishoYM2(),
                item.getShikyuGaku2(),
                item.getYen2(),
                item.getKyufuShurui3(),
                item.getTaishoYM3(),
                item.getShikyuGaku3(),
                item.getYen3(),
                item.getKyufuShurui4(),
                item.getTaishoYM4(),
                item.getShikyuGaku4(),
                item.getYen4(),
                item.getBankName(),
                item.getBranchBankName(),
                item.getShumokuTitle(),
                item.getKouzaShu(),
                item.getBangoTitle(),
                item.getKouzaNo(),
                item.getKouzaMeigi(),
                item.getHakkoYMD(),
                ninshoshaSource.denshiKoin,
                ninshoshaSource.ninshoshaYakushokuMei,
                ninshoshaSource.ninshoshaYakushokuMei1,
                ninshoshaSource.koinMojiretsu,
                ninshoshaSource.ninshoshaYakushokuMei2,
                ninshoshaSource.ninshoshaShimeiKakenai,
                ninshoshaSource.ninshoshaShimeiKakeru,
                ninshoshaSource.koinShoryaku,
                item.getYubinNo(),
                item.getGyoseiku1(),
                item.getJusho4(),
                item.getJushoText(),
                item.getJusho5(),
                item.getJusho6(),
                item.getKatagakiText(),
                item.getKatagaki3(),
                item.getKatagakiSmall2(),
                item.getKatagaki4(),
                item.getKatagakiSmall1(),
                item.getShimei5(),
                item.getShimeiSmall2(),
                item.getShimeiText(),
                item.getMeishoFuyo2(),
                item.getShimeiSmall1(),
                item.getDainoKubunMei(),
                item.getShimei6(),
                item.getMeishoFuyo1(),
                item.getSamabunShimeiText(),
                item.getSamaBun2(),
                item.getKakkoLeft2(),
                item.getSamabunShimei2(),
                item.getSamabunShimeiSmall2(),
                item.getKakkoRight2(),
                item.getKakkoLeft1(),
                item.getSamabunShimei1(),
                item.getSamaBun1(),
                item.getKakkoRight1(),
                item.getSamabunShimeiSmall1(),
                item.getCustomerBarCode());
    }
}
