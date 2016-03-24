/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120070;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakukyufutaishoshain.KogakuKyufuTaishoshaIchiranhyo;
import jp.co.ndensan.reams.db.dbc.business.report.kogakukyufutaishoshaichiran.KogakuKyufuTaishoshaIchiranItem;
import jp.co.ndensan.reams.db.dbc.business.report.kogakukyufutaishoshaichiran.KogakuKyufuTaishoshaIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishoshaichiran.DbT3054CSVDataMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishoshaichiran.DbT3055CSVDataGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishoshaichiran.DbTKogakuKyufuCSVDataHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishoshain.DbTKogakuKyufuTaishoshaDataTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishoshain.KogakuKyufuMeisaiGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishoshain.KogakuKyufuTaishoshaInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufutaishoshaichiran.KogakuKyufuTaishoshaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額介護サービス費給付対象者取込の帳票出力
 *
 */
public class KogakuKyufuTaishoshaInWriteReportProcess extends BatchProcessBase<DbTKogakuKyufuTaishoshaDataTempTableEntity> {

    /**
     * 出力順ID
     */
    public static final RString INPUT_PARAM_KEY_出力順ID;

    static {
        INPUT_PARAM_KEY_出力順ID = new RString("出力順ID");
    }
    List<KogakuKyufuTaishoshaInEntity> resultList;
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukyufutaishoshain.IKogakuKyufuTaishoshaInMapper.select一時テーブル");

    InputParameter<Long> 出力順ID;

    @BatchWriter
    private BatchReportWriter<KogakuKyufuTaishoshaIchiranSource> batchReportWriter;
    private ReportSourceWriter<KogakuKyufuTaishoshaIchiranSource> reportSourceWriter;

    @Override
    protected void initialize() {
        super.initialize();
        resultList = new ArrayList<>();
    }

    @Override
    protected void createWriter() {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200014.getReportId(),
                        ReportIdDBC.DBC200014.getReportId().value(), 出力順ID.getValue());
        List<RString> 改頁項目リスト = new ArrayList<>();
        if (null != 並び順) {
            改頁項目リスト.add(並び順.get改頁項目ID());
        }
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200014.getReportId().value(), SubGyomuCode.DBC介護給付)
                .addBreak(new BreakerCatalog<KogakuKyufuTaishoshaIchiranSource>()
                        .simplePageBreaker(改頁項目リスト)).create();
        this.reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void process(DbTKogakuKyufuTaishoshaDataTempTableEntity entity) {
        DbT3054CSVDataMeisaiEntity meisaiEntity = new DbT3054CSVDataMeisaiEntity();

        meisaiEntity.setHihokenshaNo(entity.getHihokenshaNo() == null
                ? RString.EMPTY : entity.getHihokenshaNo().value());

        meisaiEntity.setHiHokenshaSimei(entity.getHiHokenshaSimei());
        meisaiEntity.setServiceTeikyoYM(entity.getServiceTeikyoYM() == null
                ? RString.EMPTY : new RString(entity.getServiceTeikyoYM().toString()));
        meisaiEntity.setJigyoshaNo(entity.getJigyoshaNo() == null
                ? RString.EMPTY : entity.getJigyoshaNo().value());
        meisaiEntity.setJigyoshaName(entity.getJigyoshaName());

        meisaiEntity.setServiceShuruiCode(entity.getServiceShuruiCode() == null
                ? RString.EMPTY : entity.getServiceShuruiCode().value());
        meisaiEntity.setServiceShuruiName(entity.getServiceShuruiName());

        meisaiEntity.setServiceHiyoGokeiGaku(entity.getServiceHiyoGokeiGaku());

        meisaiEntity.setRiyoshaFutanGaku(entity.getRiyoshaFutanGaku());
        meisaiEntity.setNo(entity.getNo());
        meisaiEntity.setBikou(entity.getBikou());

        DbT3055CSVDataGokeiEntity gokeiEntity = new DbT3055CSVDataGokeiEntity();
        gokeiEntity.setHihokenshaNo(entity.getHihokenshaNo() == null
                ? RString.EMPTY : entity.getHihokenshaNo().value());
        gokeiEntity.setKogakuShikyuGaku(entity.getKogakuShikyuGaku());
        gokeiEntity.setRiyoshaFutanGakuGokei(entity.getRiyoshaFutanGakuGokei());
        gokeiEntity.setSanteiKijunGaku(entity.getSanteiKijunGaku());
        gokeiEntity.setServiceHiyoGokeiGakuGokei(entity.getServiceHiyoGokeiGakuGokei());
        gokeiEntity.setShiharaiSumiKingakuGokei(entity.getShiharaiSumiKingakuGokei());
        DbTKogakuKyufuCSVDataHeadEntity headEntity = new DbTKogakuKyufuCSVDataHeadEntity();
        headEntity.setHihokenshaName(entity.getHihokenshaName());
        headEntity.setHokenshaNo(entity.getHokenshaNo() == null
                ? RString.EMPTY : entity.getHokenshaNo().value());
        headEntity.setKokanShikibetsuNo(entity.getKokanShikibetsuNo());
        headEntity.setKokukoRengoukaiNa(entity.getKokukoRengoukaiNa());
        headEntity.setSakuseiYMD(entity.getSakuseiYMD() == null
                ? RString.EMPTY : new RString(entity.getSakuseiYMD().toString()));
        headEntity.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo() == null
                ? RString.EMPTY : entity.getShoKisaiHokenshaNo().value());
        FlexibleDate 資格喪失日 = FlexibleDate.EMPTY;
        if (entity.getShikakuSoshitsuYMD() != null) {
            資格喪失日 = entity.getShikakuSoshitsuYMD();
        }
        KogakuKyufuMeisaiGokeiEntity 明細集計Entity
                = new KogakuKyufuMeisaiGokeiEntity(meisaiEntity, gokeiEntity, 資格喪失日);
        KogakuKyufuTaishoshaInEntity 情報Entity = getHeaderFrom情報Entity(headEntity, resultList);
        if (情報Entity == null) {
            List<KogakuKyufuMeisaiGokeiEntity> entityList = new ArrayList<>();
            entityList.add(明細集計Entity);
            情報Entity = new KogakuKyufuTaishoshaInEntity(headEntity, entityList);
            resultList.add(情報Entity);
        } else {
            情報Entity.get明細集計List().add(明細集計Entity);
        }
    }

    private KogakuKyufuTaishoshaInEntity getHeaderFrom情報Entity(
            DbTKogakuKyufuCSVDataHeadEntity headEntity, List<KogakuKyufuTaishoshaInEntity> 情報Entity) {
        if (null == 情報Entity) {
            return null;
        }
        for (KogakuKyufuTaishoshaInEntity entity : 情報Entity) {
            if (headEntity.equalsToEntity(entity.getHeadEntity())) {
                return entity;
            }
        }
        return null;
    }

    @Override
    protected void afterExecute() {
        KogakuKyufuTaishoshaIchiranhyo business = new KogakuKyufuTaishoshaIchiranhyo();

        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200014.getReportId(), 出力順ID.getValue());
        RString 改頁 = (並び順 == null ? RString.EMPTY : 並び順.getFormated改頁項目());
        List<KogakuKyufuTaishoshaIchiranItem> targetList
                = business.getKogakuKyufuTaishoshaIchiranhyoData(RString.EMPTY, RString.EMPTY, RString.EMPTY,
                        RString.EMPTY, RString.EMPTY, 改頁, resultList);
        KogakuKyufuTaishoshaIchiranReport report
                = KogakuKyufuTaishoshaIchiranReport.createForm(targetList);
        report.writeBy(reportSourceWriter);
    }

}
