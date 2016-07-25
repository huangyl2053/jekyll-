/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.shokanketteitsuchishoikkatsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharai;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishoshiharaiyoteibiyijiari.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishoshiharaiyoteibiyijinashi.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiItem;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishoshiharaiyoteibiyijinashi.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReport;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharaiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraishikyuketteitsuchishojuryouininshamuke.ShokanBaraiShikyuKetteiTsuchishoJuryoIninshaMuke;
import jp.co.ndensan.reams.db.dbc.service.report.shokanbaraishikyufushikyuketteitsuhchishochohyo.ShokanBaraiShikyuFushikyuKetteiTsuchishoBatch;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票DBC100002_償還払い支給（不支給）決定通知書を出力します。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public class ShiharaiYoteiBiYijiNashiOutputProcess extends BatchProcessBase<ShokanKetteiTsuchiShoShiharaiRelateEntity> {

    private static final RString 帳票取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper.get帳票データ");
    private static final RString FLAG_FALSE = new RString("0");
    List<ShokanKetteiTsuchiShoShiharai> 帳票データリスト = new ArrayList<>();
    ShokanKetteiTsuchiShoSealerBatchParameter batchPram;
    @BatchWriter
    private BatchReportWriter<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource> batchWrite;
    private ReportSourceWriter<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource> reportSourceWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(帳票取得SQL);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100002.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void process(ShokanKetteiTsuchiShoShiharaiRelateEntity entity) {
        帳票データリスト.add(new ShokanKetteiTsuchiShoShiharai(entity));
    }

    @Override
    protected void afterExecute() {
        if (帳票データリスト.isEmpty()) {
            return;
        }

        List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiItem> itemList = new ArrayList<>();
        if (FLAG_FALSE.equals(batchPram.get受領委任者向け決定通知書フラグ())) {
            ShokanBaraiShikyuKetteiTsuchishoJuryoIninshaMuke ichiranhyo = new ShokanBaraiShikyuKetteiTsuchishoJuryoIninshaMuke();
            List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem> ariItemList
                    = ichiranhyo.getShokanBaraiShikyuKetteiTsuchishoJuryoIninshaMukeData(帳票データリスト, batchPram, reportSourceWriter);
            for (ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem item : ariItemList) {
                itemList.add(setShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiItem(item));
            }
        } else {
            ShokanBaraiShikyuFushikyuKetteiTsuchishoBatch sbsfktb = new ShokanBaraiShikyuFushikyuKetteiTsuchishoBatch();
            List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem> nashiItemList
                    = sbsfktb.getShokanHaraiShikyuFushikyuKetteiTsuhchishoChohyoData(帳票データリスト, batchPram, reportSourceWriter);
            for (ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem item : nashiItemList) {
                itemList.add(setShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiItem(item));
            }
        }

        ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReport report
                = ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReport.createFrom(itemList);
        report.writeBy(reportSourceWriter);
    }

    private ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiItem
            setShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiItem(ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem item) {

        return new ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiItem(
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
                item.getTorikeshi1(),
                item.getTorikeshi2(),
                item.getBankName(),
                item.getMochimono1(),
                item.getTorikeshiMochimono1(),
                item.getBranchBankName(),
                item.getMochimono2(),
                item.getTorikeshiMochimono2(),
                item.getMochimono3(),
                item.getShiharaiBasho(),
                item.getTorikeshiShiharaibasho(),
                item.getShumokuTitle(),
                item.getKouzaShu(),
                item.getBangoTitle(),
                item.getKouzaNo(),
                item.getShiharaiStartYMD(),
                item.getKouzaMeigi(),
                item.getTorikeshiShiharaikikan(),
                item.getShiharaiEndYMD(),
                item.getKaraFugo(),
                item.getShiharaiStartHMS(),
                item.getShiharaiEndHMS(),
                item.getTsuchibun２(),
                item.getSeirino(),
                item.getTsuchino(),
                item.getRemban(),
                item.getTsuchibunLarge(),
                item.getTsuchibunMix1(),
                item.getTsuchibunMix2(),
                item.getTsuchibunMixtwo1(),
                item.getTsuchibunMixtwo2(),
                item.getHakkoYMD(),
                item.getDenshiKoin(),
                item.getNinshoshaYakushokuMei(),
                item.getNinshoshaYakushokuMei1(),
                item.getKoinMojiretsu(),
                item.getNinshoshaYakushokuMei2(),
                item.getNinshoshaShimeiKakenai(),
                item.getNinshoshaShimeiKakeru(),
                item.getKoinShoryaku(),
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
