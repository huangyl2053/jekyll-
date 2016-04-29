/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120070;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakukyufutaishoshain.KogakuKyufuTaishoshaIchiranhyo;
import jp.co.ndensan.reams.db.dbc.business.core.kogakukyufutaishoshain.KogakuKyufuTaishoshaInPageBreak;
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
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 高額介護サービス費給付対象者取込の帳票出力
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
public class KogakuKyufuTaishoshaInWriteReportProcess extends BatchKeyBreakBase<DbTKogakuKyufuTaishoshaDataTempTableEntity> {

    /**
     * 出力順ID
     */
    public static final RString INPUT_PARAM_KEY_出力順ID;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    static {
        INPUT_PARAM_KEY_出力順ID = new RString("出力順ID");
    }

    private static final RString KAI_PAGE_HIHOKENSHA = new RString("hokenshaNo");

    private List<KogakuKyufuTaishoshaInEntity> resultList;
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukyufutaishoshain.IKogakuKyufuTaishoshaInMapper.select一時テーブル");

    InputParameter<Long> 出力順ID;

    @BatchWriter
    private BatchReportWriter<KogakuKyufuTaishoshaIchiranSource> batchReportWriter;
    private ReportSourceWriter<KogakuKyufuTaishoshaIchiranSource> reportSourceWriter;

    private KogakuKyufuTaishoshaIchiranhyo business;

    @Override
    protected void initialize() {
        super.initialize();
        resultList = new ArrayList<>();
        business = new KogakuKyufuTaishoshaIchiranhyo();
    }

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected void createWriter() {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200014.getReportId(), 出力順ID.getValue());
        List<RString> 改頁項目リスト = new ArrayList<>();
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目リスト.add(item.get項目ID());
                }
            }
        }
        if (改頁項目リスト.isEmpty()) {
            改頁項目リスト.add(KAI_PAGE_HIHOKENSHA);
        }
        PageBreaker<KogakuKyufuTaishoshaIchiranSource> breaker = new KogakuKyufuTaishoshaInPageBreak(改頁項目リスト);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200014.getReportId().value(), SubGyomuCode.DBC介護給付)
                .addBreak(breaker).create();
        this.reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void keyBreakProcess(DbTKogakuKyufuTaishoshaDataTempTableEntity entity) {

    }

    @Override
    protected void usualProcess(DbTKogakuKyufuTaishoshaDataTempTableEntity entity) {
        addItem(entity);
    }

    private void addItem(DbTKogakuKyufuTaishoshaDataTempTableEntity entity) {
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

        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200014.getReportId(), 出力順ID.getValue());
        RString 改頁 = RString.EMPTY;
        int i = 0;
        RString 並び順の１件目 = RString.EMPTY;
        RString 並び順の２件目 = RString.EMPTY;
        RString 並び順の３件目 = RString.EMPTY;
        RString 並び順の４件目 = RString.EMPTY;
        RString 並び順の５件目 = RString.EMPTY;
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁 = item.get項目名();
                }
                if (i == INDEX_0) {
                    並び順の１件目 = item.get項目名();
                } else if (i == INDEX_1) {
                    並び順の２件目 = item.get項目名();
                } else if (i == INDEX_2) {
                    並び順の３件目 = item.get項目名();
                } else if (i == INDEX_3) {
                    並び順の４件目 = item.get項目名();
                } else if (i == INDEX_4) {
                    並び順の５件目 = item.get項目名();
                }
                i = i + 1;
            }
        }
        List<KogakuKyufuTaishoshaIchiranItem> targetList
                = business.getKogakuKyufuTaishoshaIchiranhyoData(並び順の１件目, 並び順の２件目,
                        並び順の３件目, 並び順の４件目,
                        並び順の５件目, 改頁, resultList);
        KogakuKyufuTaishoshaIchiranReport report
                = KogakuKyufuTaishoshaIchiranReport.createForm(targetList);
        report.writeBy(reportSourceWriter);
    }

}
