/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.shokanketteitsuchishosealer;

import jp.co.ndensan.reams.db.dbc.business.report.ｓhokanｋetteiｓsuchiｓhoｓealer.ShokanKetteiTsuchiShoSealer2Item;
import jp.co.ndensan.reams.db.dbc.business.report.ｓhokanｋetteiｓsuchiｓhoｓealer.ShokanKetteiTsuchiShoSealer2Property;
import jp.co.ndensan.reams.db.dbc.business.report.ｓhokanｋetteiｓsuchiｓhoｓealer.ShokanKetteiTsuchiShoSealer2Report;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealer2ReportSource;
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
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilder.ReportSourceBuilders;

/**
 * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）Printerです。
 *
 */
public class ShokanKetteiTsuchiShoSealer2Service {

    /**
     * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）を印刷します。
     *
     * @param item 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(ShokanKetteiTsuchiShoSealer2Item item) {

        ShokanKetteiTsuchiShoSealer2Property property = new ShokanKetteiTsuchiShoSealer2Property();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<ShokanKetteiTsuchiShoSealer2ReportSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
                        RDate.getNowDate(), assembler.getImageFolderPath());
                item = setShokanKetteiTsuchiShoSealer2Item(item, ninshoshaSourceBuilder.buildSource());
                ReportSourceWriter<ShokanKetteiTsuchiShoSealer2ReportSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                ShokanKetteiTsuchiShoSealer2Report.createFrom(item).writeBy(reportSourceWriter);
            }
            return reportManager.publish();
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

    private static ShokanKetteiTsuchiShoSealer2Item
            setShokanKetteiTsuchiShoSealer2Item(ShokanKetteiTsuchiShoSealer2Item item,
                    NinshoshaSource ninshoshaSource) {

        return new ShokanKetteiTsuchiShoSealer2Item(
                item.getBunshoNo(),
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
                item.getShiharaiGaku(),
                item.getTaishoYM(),
                item.getKyufuShurui1(),
                item.getKyufuShurui2(),
                item.getKyufuShurui3(),
                item.getKekka(),
                item.getShikyuGaku(),
                item.getRiyu1(),
                item.getRiyu2(),
                item.getRiyu3(),
                item.getShiharaiBasho(),
                item.getBankName(),
                item.getBranchBankName(),
                item.getKouzaShu(),
                item.getKouzaNo(),
                item.getKouzaMeigi(),
                item.get支払予定日(),
                item.get整理番号(),
                item.get決定通知書番号(),
                item.getShiharaiStartYMD(),
                item.getShiharaiEndYMD(),
                item.getShiharaiStartHMS(),
                item.getShiharaiEndHMS(),
                item.getKaraFugo(),
                item.getTsuban(),
                item.getShumokuTitle(),
                item.getBangoTitle(),
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
                item.getCustomerBarCode(),
                item.getTitle2_1(),
                item.getTitle2_2_1(),
                item.getTitle2_2_2(),
                item.getTitle2_3_1(),
                item.getTitle2_3_2(),
                item.getTitle2_4(),
                item.getTorikeshi1(),
                item.getTorikeshi2(),
                item.getMochimono1(),
                item.getTorikeshiMochimono1(),
                item.getMochimono2(),
                item.getTorikeshiMochimono2(),
                item.getMochimono3(),
                item.getShoHokenshaNo(),
                item.getServiceYM(),
                item.getTsuban2(),
                item.getTorikeshiShiharaikikan(),
                item.getRiyuTitle(),
                item.get増減の理由(),
                item.getタイトル1(),
                item.getタイトル2(),
                item.get当ページ(),
                item.getページ総数(),
                item.get被保険者氏名２(),
                item.get通知文(),
                item.get情報文(),
                item.get円1(),
                item.get円2(),
                item.get円3(),
                item.get円4(),
                item.getTitle(),
                item.getTorikeshiShiharaibasho(),
                item.getHihokenshaNo21(),
                item.getGyoseiku2());

    }

}
