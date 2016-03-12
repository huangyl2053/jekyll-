/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120170;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kagoketteikohifutanshain.KagoKetteiTsuchishoJohoTorikomiIchiranhyoKouhiFutanshabun;
import jp.co.ndensan.reams.db.dbc.business.report.kagoketteikohifutanshain.KagoKetteiKohifutanshaInItem;
import jp.co.ndensan.reams.db.dbc.business.report.kagoketteikohifutanshain.KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunReport;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteikohifutanshain.KagoKetteiKohifutanshaInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteitsuchishotorikomiichirankohifutanshabun.KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunSource;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufutaishoshaichiran.KogakuKyufuTaishoshaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票用Entityリスト作成と作成したdataを帳票に出力する。
 */
public class KohifutanshaWriteReportProcess extends BatchKeyBreakBase<KagoKetteiKohifutanshaInEntity> {

    public static final RString PARAMETER_IN_SHORIYM = new RString("shoriYM");
    public static final RString PARAMETER_IN_SHUTSURYOKUJUNID = new RString("shutsuryokujunID");
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.kagoketteikohifutanshain."
            + "IKagoKetteiKohishaMapper.select一時テーブル");

    @BatchWriter
    private BatchReportWriter<KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunSource> batchReportWriter;
    private ReportSourceWriter<KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunSource> reportSourceWriter;

    List<KagoKetteiKohifutanshaInEntity> entityList;

    InputParameter<FlexibleYearMonth> shoriYM;
    InputParameter<Long> shutsuryokujunID;

    @Override
    protected void initialize() {
        super.initialize();
        entityList = new ArrayList<>();
    }

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected void createWriter() {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200051.getReportId(),
                        ReportIdDBC.DBC200051.getReportId().value(), shutsuryokujunID.getValue());
        List<RString> 改頁項目リスト = new ArrayList<>();
        if (null != 並び順) {
            改頁項目リスト.add(並び順.get改頁項目ID());
        }
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200051.getReportId().value(), SubGyomuCode.DBC介護給付)
                .addBreak(new BreakerCatalog<KogakuKyufuTaishoshaIchiranSource>()
                        .simplePageBreaker(改頁項目リスト)).create();
        this.reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void keyBreakProcess(KagoKetteiKohifutanshaInEntity t) {
    }

    @Override
    protected void usualProcess(KagoKetteiKohifutanshaInEntity t) {
        entityList.add(t);
    }

    @Override
    protected void afterExecute() {
        KagoKetteiTsuchishoJohoTorikomiIchiranhyoKouhiFutanshabun business
                = new KagoKetteiTsuchishoJohoTorikomiIchiranhyoKouhiFutanshabun();
        // TODO 並び順
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200051.getReportId(),
                        ReportIdDBC.DBC200051.getReportId().value(), shutsuryokujunID.getValue());
        List<KagoKetteiKohifutanshaInItem> targetList
                = business.createKagoKetteiTsuchishoJohoTorikomiIchiranhyoKouhiFutanshabun(
                        shoriYM.getValue(), 並び順, entityList);
        KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunReport report
                = KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunReport.createForm(targetList);
        report.writeBy(reportSourceWriter);
//        batchReportWriter.close();
    }

}
