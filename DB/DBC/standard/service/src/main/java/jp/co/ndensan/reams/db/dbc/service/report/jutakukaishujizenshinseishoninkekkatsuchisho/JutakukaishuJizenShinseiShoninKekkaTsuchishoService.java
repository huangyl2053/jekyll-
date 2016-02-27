/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.jutakukaishujizenshinseishoninkekkatsuchisho;

import jp.co.ndensan.reams.db.dbc.business.report.jutakukaishujizenshinseishoninkekkatsuchisho.JutakukaishuJizenShinseiShoninKekkaTsuchishoItem;
import jp.co.ndensan.reams.db.dbc.business.report.jutakukaishujizenshinseishoninkekkatsuchisho.JutakukaishuJizenShinseiShoninKekkaTsuchishoProperty;
import jp.co.ndensan.reams.db.dbc.business.report.jutakukaishujizenshinseishoninkekkatsuchisho.JutakukaishuJizenShinseiShoninKekkaTsuchishoReport;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jutakukaishujizenshinseishoninkekka.JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource;
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
 * 住宅改修事前申請承認結果通知書Printerです。
 */
public class JutakukaishuJizenShinseiShoninKekkaTsuchishoService {

    /**
     * 住宅改修事前申請承認結果通知書を印刷します。
     *
     * @param item 住宅改修事前申請承認結果通知書_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(JutakukaishuJizenShinseiShoninKekkaTsuchishoItem item) {

        JutakukaishuJizenShinseiShoninKekkaTsuchishoProperty property = new JutakukaishuJizenShinseiShoninKekkaTsuchishoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
                        RDate.getNowDate(), assembler.getImageFolderPath());
                item = setJutakukaishuJizenShinseiShoninKekkaTsuchishoItem(item, ninshoshaSourceBuilder.buildSource());
                ReportSourceWriter<JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                JutakukaishuJizenShinseiShoninKekkaTsuchishoReport.createFrom(item).writeBy(reportSourceWriter);
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

    private static JutakukaishuJizenShinseiShoninKekkaTsuchishoItem
            setJutakukaishuJizenShinseiShoninKekkaTsuchishoItem(JutakukaishuJizenShinseiShoninKekkaTsuchishoItem item,
                    NinshoshaSource ninshoshaSource) {

        return new JutakukaishuJizenShinseiShoninKekkaTsuchishoItem(
                item.getBunshoNo(),
                item.getTitle(),
                item.getTsuchibun1(),
                item.getHihokenshaName(),
                item.getHihokenshaNo(),
                item.getUketsukeYMD(),
                item.getShoninKbn(),
                item.getShoninYMD(),
                item.getFushoninRiyu(),
                item.getKyufuShurui(),
                item.getJigyoshaName(),
                item.getJigyoshaYubinNo(),
                item.getJigyoshoJusho(),
                item.getJigyoshoTelNo(),
                item.getRiyushoSakuseisha(),
                item.getHiyogakuGokei(),
                item.getHokenHiyogaku(),
                item.getRiyoFutangaku(),
                item.getHokenKyufuhigaku(),
                item.getTsuchibun2(),
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
