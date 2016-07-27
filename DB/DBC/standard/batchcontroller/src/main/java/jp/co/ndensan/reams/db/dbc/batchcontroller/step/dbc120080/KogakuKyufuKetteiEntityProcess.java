/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120080;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteishaichiran.KogakuShikyuFushikyuKetteishaIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin.KogakuKyufuKetteiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin.KogakuKyufuKetteiInYiLanEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufukettei.KogakuShikyuFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakuserviceketteijoho.IKogakuServiceKetteiJohoTorikomiDataHenshuMapper;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額サービス費決定情報Entity作成
 *
 * @reamsid_L DBC-0980-390 lijunjun
 */
public class KogakuKyufuKetteiEntityProcess extends SimpleBatchProcessBase {

    /**
     * 出力順ID
     */
    public static final RString PARAMETER_出力順ID;
    /**
     * listLower_2
     */
    private static final RString KAI_PAGE_HIHOKENSHA;

    static {
        PARAMETER_出力順ID = new RString("出力順ID");
        KAI_PAGE_HIHOKENSHA = new RString("listLower_2");
    }
    private IKogakuServiceKetteiJohoTorikomiDataHenshuMapper mapper;
    private RString 改頁;
    private RString 出力順;
    private KogakuKyufuKetteiInEntity 決定情報Entity;

    @BatchWriter
    private BatchReportWriter<KogakuShikyuFushikyuKetteishaIchiranSource> batchReportWriter;
    private ReportSourceWriter<KogakuShikyuFushikyuKetteishaIchiranSource> reportSourceWriter;

    InputParameter<Long> 出力順ID;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IKogakuServiceKetteiJohoTorikomiDataHenshuMapper.class);
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200051.getReportId(), 出力順ID.getValue());
        List<RString> 改頁項目リスト = new ArrayList<>();
        改頁項目リスト.add(KAI_PAGE_HIHOKENSHA);
        if (null != 並び順) {
            改頁項目リスト.add(並び順.get改頁項目ID());
        }
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200051.getReportId().value(), SubGyomuCode.DBC介護給付)
                .addBreak(new BreakerCatalog<KogakuShikyuFushikyuKetteishaIchiranSource>()
                        .simplePageBreaker(改頁項目リスト)).create();
        this.reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process() {
        List<KogakuKyufuKetteiInYiLanEntity> 高額サービス費決定情報一覧リスト
                = mapper.select一時TBLから高額サービス費決定情報一覧リスト();
        // TODO
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200015.getReportId(), 出力順ID.getValue());
        改頁 = 並び順.getFormated改頁項目();
        出力順 = 並び順.getFormated出力順項目();
        決定情報Entity.set出力順１(出力順);
        決定情報Entity.set出力順2(出力順);
        決定情報Entity.set出力順3(出力順);
        決定情報Entity.set出力順4(出力順);
        決定情報Entity.set出力順5(出力順);
        決定情報Entity.set改頁１(改頁);
        決定情報Entity.set改頁2(改頁);
        決定情報Entity.set改頁3(改頁);
        決定情報Entity.set改頁4(改頁);
        決定情報Entity.set改頁5(改頁);
        決定情報Entity.set高額サービス費決定情報一覧EntityList(高額サービス費決定情報一覧リスト);
    }

    @Override
    protected void afterExecute() {
//        KogakuServiceKetteishaIchiranhyoData sut = new KogakuServiceKetteishaIchiranhyoData();
//        List<KogakuShikyuFushikyuKetteishaIchiranItem> resultList = sut.getKogakuServiceKetteishaIchiranhyoData(決定情報Entity);

        KogakuShikyuFushikyuKetteishaIchiranReport report
                = new KogakuShikyuFushikyuKetteishaIchiranReport(Collections.EMPTY_LIST, Collections.EMPTY_LIST,
                        new HashMap<RString, RString>(), RDateTime.now());
        report.writeBy(reportSourceWriter);
    }
}
