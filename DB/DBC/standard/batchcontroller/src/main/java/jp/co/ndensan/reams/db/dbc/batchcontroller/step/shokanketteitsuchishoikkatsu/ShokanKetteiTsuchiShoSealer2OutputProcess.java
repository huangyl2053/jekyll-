/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.shokanketteitsuchishoikkatsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharai;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteissuchishosealer.ShokanKetteiTsuchiShoSealer2Item;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteissuchishosealer.ShokanKetteiTsuchiShoSealer2Report;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealer;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharaiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealer2ReportSource;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraishikyuketteitsuchishosealertype.ShokanBaraiShikyuKetteiTsuchishoSealerType1;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraishikyuketteitsuchishosealertype.TensoData;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * DBC100006_償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）を出力します。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public class ShokanKetteiTsuchiShoSealer2OutputProcess extends BatchProcessBase<ShokanKetteiTsuchiShoShiharaiRelateEntity> {

    private static final RString 帳票取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper.get帳票データ");

    List<ShokanKetteiTsuchiShoShiharai> 帳票データリスト = new ArrayList<>();
    ShokanKetteiTsuchiShoSealerBatchParameter batchPram;
    @BatchWriter
    private BatchReportWriter<ShokanKetteiTsuchiShoSealer2ReportSource> batchWrite;
    private ReportSourceWriter<ShokanKetteiTsuchiShoSealer2ReportSource> reportSourceWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(帳票取得SQL);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100006.getReportId().value()).create();
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
        ShokanBaraiShikyuKetteiTsuchishoSealerType1 ichiranhyo = new ShokanBaraiShikyuKetteiTsuchishoSealerType1();
        TensoData data
                = ichiranhyo.createChoHyoData(帳票データリスト, batchPram, reportSourceWriter);
        List<ShokanKetteiTsuchiShoSealer2Item> itemList = new ArrayList<>();
        for (ShokanKetteiTsuchiShoSealer sealer : data.get帳票ソースデータ()) {
            itemList.add(setShokanKetteiTsuchiShoSealer2Item(sealer));
        }
        ShokanKetteiTsuchiShoSealer2Report report = ShokanKetteiTsuchiShoSealer2Report.createFrom(itemList);
        report.writeBy(reportSourceWriter);
    }

    private ShokanKetteiTsuchiShoSealer2Item setShokanKetteiTsuchiShoSealer2Item(ShokanKetteiTsuchiShoSealer item) {

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
                item.getShiharaiYoteiYMD(),
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
                item.getTitle1(),
                item.getTitle2(),
                item.getPage(),
                item.getPages(),
                item.getHihokenshaName2(),
                item.getTsuchibun1(),
                item.getInfo(),
                item.getYen1(),
                item.getYen2(),
                item.getYen3(),
                item.getYen4(),
                item.getTitle(),
                item.getTorikeshiShiharaibasho(),
                item.getHihokenshaNo21(),
                item.getGyoseiku2());
    }
}
