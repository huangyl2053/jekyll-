/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.shokanketteitsuchishoikkatsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharai;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerItem;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerReport;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealer;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharaiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoSealerReportSource;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraishikyuketteitsuchishosealertype.ShokanBaraiShikyuKetteiTsuchishoSealerType1;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraishikyuketteitsuchishosealertype.TensoData;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.IDaikoPrint;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * DBC100004_償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）を出力します。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public class ShokanKetteiTsuchiShoSealerOutputProcess extends BatchProcessBase<ShokanKetteiTsuchiShoShiharaiRelateEntity> {

    private static final RString 帳票取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper.get帳票データ");

    List<ShokanKetteiTsuchiShoShiharai> 帳票データリスト = new ArrayList<>();
    ShokanKetteiTsuchiShoSealerBatchParameter batchPram;
    @BatchWriter
    private BatchReportWriter<ShokanKetteiTsuchiShoSealerReportSource> batchWrite;
    private ReportSourceWriter<ShokanKetteiTsuchiShoSealerReportSource> reportSourceWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(帳票取得SQL);
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
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100004.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
        ShokanBaraiShikyuKetteiTsuchishoSealerType1 ichiranhyo = new ShokanBaraiShikyuKetteiTsuchishoSealerType1();
        TensoData data
                = ichiranhyo.createChoHyoData(帳票データリスト, batchPram, reportSourceWriter);
        IDaikoPrint daikoPrint = data.get代行プリント送付票();
        daikoPrint.print();
        List<ShokanKetteiTsuchiShoSealerItem> itemList = new ArrayList<>();
        for (ShokanKetteiTsuchiShoSealer sealer : data.get帳票ソースデータ()) {
            itemList.add(setShokanKetteiTsuchiShoSealerReport(sealer));
        }
        ShokanKetteiTsuchiShoSealerReport report = ShokanKetteiTsuchiShoSealerReport.createFrom(itemList);
        report.writeBy(reportSourceWriter);
    }

    private ShokanKetteiTsuchiShoSealerItem
            setShokanKetteiTsuchiShoSealerReport(ShokanKetteiTsuchiShoSealer item) {

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
                item.getDenshiKoin(),
                item.getNinshoshaYakushokuMei(),
                item.getNinshoshaYakushokuMei1(),
                item.getKoinMojiretsu(),
                item.getNinshoshaYakushokuMei2(),
                item.getNinshoshaShimeiKakenai(),
                item.getNinshoshaShimeiKakeru(),
                item.getKoinShoryaku(),
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
