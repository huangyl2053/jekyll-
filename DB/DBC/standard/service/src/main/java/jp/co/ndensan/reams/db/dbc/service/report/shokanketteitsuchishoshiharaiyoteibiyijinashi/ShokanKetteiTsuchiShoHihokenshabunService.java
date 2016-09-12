/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.shokanketteitsuchishoshiharaiyoteibiyijinashi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishohihokenshabun.ShokanKetteiTsuchiShoHihokenshabunItem;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishohihokenshabun.ShokanKetteiTsuchiShoHihokenshabunProperty;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishohihokenshabun.ShokanKetteiTsuchiShoHihokenshabunReport;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoHihokenshabunReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
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
 * 償還払い支給（不支給）決定通知書Printerです。
 *
 * @reamsid_L DBC-1000-120 zuotao
 */
public class ShokanKetteiTsuchiShoHihokenshabunService {

    /**
     * 償還払い支給（不支給）決定通知書を印刷します。
     *
     * @param itemList 償還払い支給（不支給）決定通知書_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ShokanKetteiTsuchiShoHihokenshabunItem> itemList) {

        ShokanKetteiTsuchiShoHihokenshabunProperty property = new ShokanKetteiTsuchiShoHihokenshabunProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<ShokanKetteiTsuchiShoHihokenshabunReportSource> assembler = createAssembler(property, reportManager)) {
                Ninshosha nishosha = NinshoshaFinderFactory.createInstance().get帳票認証者(
                        GyomuCode.DB介護保険, RString.EMPTY);
                Association association = AssociationFinderFactory.createInstance().getAssociation();
                INinshoshaSourceBuilder builder = NinshoshaSourceBuilderFactory.createInstance(
                        nishosha, association, assembler.getImageFolderPath(), RDate.getNowDate());
                for (ShokanKetteiTsuchiShoHihokenshabunReport report : toReports(itemList, builder.buildSource())) {
                    ReportSourceWriter<ShokanKetteiTsuchiShoHihokenshabunReportSource> reportWriter = new ReportSourceWriter(assembler);
                    report.writeBy(reportWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<ShokanKetteiTsuchiShoHihokenshabunReport> toReports(
            List<ShokanKetteiTsuchiShoHihokenshabunItem> itemList, NinshoshaSource ninshoshaSource) {
        List<ShokanKetteiTsuchiShoHihokenshabunReport> list = new ArrayList<>();
        List<ShokanKetteiTsuchiShoHihokenshabunItem> newItemList = new ArrayList<>();
        for (ShokanKetteiTsuchiShoHihokenshabunItem item : itemList) {
            newItemList.add(setShokanKetteiTsuchiShoHihokenshabunItem(item, ninshoshaSource));
        }
        list.add(ShokanKetteiTsuchiShoHihokenshabunReport.createFrom(newItemList));
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

    private static ShokanKetteiTsuchiShoHihokenshabunItem
            setShokanKetteiTsuchiShoHihokenshabunItem(ShokanKetteiTsuchiShoHihokenshabunItem item,
                    NinshoshaSource ninshoshaSource) {

        return new ShokanKetteiTsuchiShoHihokenshabunItem(
                item.getBunshoNo(),
                item.getTitle(),
                item.getTitle2_1(),
                item.getTitle2_2_1(),
                item.getTitle2_2_2(),
                item.getTitle2_3_1(),
                item.getTitle2_3_2(),
                item.getTitle2_4(),
                item.getTsuchibun1(),
                item.getHihokenshaName(),
                item.getHihokenshaNo1(),
                item.getHihokenshaNo2(),
                item.getHihokenshaNo3(),
                item.getHihokenshaNo4(),
                item.getHihokenshaNo5(),
                item.getHihokenshaNo6(),
                item.getHihokenshaNo7(),
                item.getHihokenshaNo8(),
                item.getHihokenshaNo9(),
                item.getHihokenshaNo10(),
                item.getUketsukeYMD(),
                item.getKetteiYMD(),
                item.getHonninShiharaiGaku(),
                item.getTaishoYM(),
                item.getKyufuShu1(),
                item.getKyufuShu2(),
                item.getKyufuShu3(),
                item.getKekka(),
                item.getShikyuGaku(),
                item.getRiyu1(),
                item.getRiyuTitle(),
                item.getRiyu2(),
                item.getRiyu3(),
                item.getJigyoshoName(),
                item.getDaihyoshaName(),
                item.getJigyoshoYubinNo(),
                item.getJigyoshoJusho(),
                item.getJigyoshoTelNo(),
                item.getTsuchibun2(),
                item.getSeirino(),
                item.getTsuchino(),
                item.getRemban(),
                item.getTsuchibunLarge3(),
                item.getTsuchibunMix1(),
                item.getTsuchibunMix2(),
                item.getTsuchibunMixtwo1(),
                item.getTsuchibunMixtwo2(),
                ninshoshaSource.hakkoYMD,
                ninshoshaSource.denshiKoin,
                ninshoshaSource.ninshoshaYakushokuMei,
                ninshoshaSource.ninshoshaYakushokuMei1,
                ninshoshaSource.koinMojiretsu,
                ninshoshaSource.ninshoshaYakushokuMei2,
                ninshoshaSource.ninshoshaShimeiKakenai,
                ninshoshaSource.ninshoshaShimeiKakeru,
                ninshoshaSource.koinShoryaku,
                item.getYubinNo(),
                item.getGyoseiku2(),
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
                item.getKakkoLeft2(),
                item.getSamabunShimei2(),
                item.getSamabunShimeiSmall2(),
                item.getSamaBun2(),
                item.getKakkoRight2(),
                item.getKakkoLeft1(),
                item.getSamabunShimei1(),
                item.getSamaBun1(),
                item.getKakkoRight1(),
                item.getSamabunShimeiSmall1(),
                item.getCustomerBarCode());
    }
}
