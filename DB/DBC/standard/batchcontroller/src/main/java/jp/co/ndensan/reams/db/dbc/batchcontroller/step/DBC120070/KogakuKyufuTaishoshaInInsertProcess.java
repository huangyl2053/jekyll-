/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120070;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishoshaichiran.DbT3054CSVDataMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishoshaichiran.DbT3055CSVDataGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishoshaichiran.DbTKogakuKyufuCSVDataHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishoshain.DbTKogakuKyufuTaishoshaDataTempTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額介護サービス費給付対象者取込のCSVファイル読取
 */
public class KogakuKyufuTaishoshaInInsertProcess extends BatchProcessBase<RString> {

    /**
     * ファイルパス
     */
    public static final RString PARAMETER_FILEPATH;
    /**
     * TABLE_NAME
     */
    public static final RString TABLE_NAME;

    InputParameter<RString> filePath;
    private static final Integer INDEX_1 = 1;

    static {
        PARAMETER_FILEPATH = new RString("filePath");
        TABLE_NAME = new RString("DbTKogakuKyufuTaishoshaDataTempTable");
    }
    private DbTKogakuKyufuCSVDataHeadEntity headEntity;
    private DbT3054CSVDataMeisaiEntity meisaiEntity;
    private DbT3055CSVDataGokeiEntity gokeiEntity;
    private List<DbT3054CSVDataMeisaiEntity> meisaiList;
    private List<DbT3055CSVDataGokeiEntity> gokeiList;
    private final RString レコード種別_H1 = new RString("H1");
    private final RString レコード種別_D1 = new RString("D1");
    private final RString レコード種別_T1 = new RString("T1");

    @BatchWriter
    BatchEntityCreatedTempTableWriter tempTableWriter;

    @Override
    protected void initialize() {
        super.initialize();
        meisaiList = new ArrayList<>();
        gokeiList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(filePath.getValue());
    }

    @Override
    protected void createWriter() {

        tempTableWriter
                = new BatchEntityCreatedTempTableWriter(TABLE_NAME,
                        DbTKogakuKyufuTaishoshaDataTempTableEntity.class);
    }

    @Override
    protected void process(RString line) {

        List<RString> data = line.split(",");
        if (data == null || INDEX_1 >= data.size()) {
            return;
        }
        if (レコード種別_H1.equals(data.get(INDEX_1))) {
            headEntity = ListToObjectMappingHelper.toObject(DbTKogakuKyufuCSVDataHeadEntity.class, data);
        } else if (レコード種別_D1.equals(data.get(INDEX_1))) {
            meisaiEntity = ListToObjectMappingHelper.toObject(DbT3054CSVDataMeisaiEntity.class, data);
            meisaiList.add(meisaiEntity);
        } else if (レコード種別_T1.equals(data.get(INDEX_1))) {
            gokeiEntity = ListToObjectMappingHelper.toObject(DbT3055CSVDataGokeiEntity.class, data);
            gokeiList.add(gokeiEntity);
        }
    }

    @Override
    protected void afterExecute() {
        if (meisaiList == null || meisaiList.isEmpty() || gokeiList == null || gokeiList.isEmpty()) {
            tempTableWriter.insert(createDataRecord(headEntity));
        } else {
            for (DbT3054CSVDataMeisaiEntity 明細entity : meisaiList) {
                for (DbT3055CSVDataGokeiEntity 合計Entity : gokeiList) {
                    if (明細entity.getHihokenshaNo().equals(合計Entity.getHihokenshaNo())) {
                        tempTableWriter.insert(createDataRecord(headEntity, 明細entity, 合計Entity));
                    }

                }

            }
        }
    }

    /**
     * 額介護サービス費給付対象者取込の一時テーブル
     *
     * @param headEntity headEntity
     * @param meisaiList meisaiList
     * @param gokeiList gokeiList
     * @return DbTKogakuKyufuTaishoshaDataTempTableEntity
     */
    private DbTKogakuKyufuTaishoshaDataTempTableEntity createDataRecord(DbTKogakuKyufuCSVDataHeadEntity headEntity,
            DbT3054CSVDataMeisaiEntity meisaiEntity,
            DbT3055CSVDataGokeiEntity gokeiEntity) {

        DbTKogakuKyufuTaishoshaDataTempTableEntity result = new DbTKogakuKyufuTaishoshaDataTempTableEntity();
        result.setKokanShikibetsuNo((trim囲み文字(headEntity.getKokanShikibetsuNo())));
        result.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(trim囲み文字(headEntity.getShoKisaiHokenshaNo())));
        result.setHokenshaNo(new HokenshaNo(trim囲み文字(headEntity.getHokenshaNo())));
        result.setHihokenshaName(trim囲み文字(headEntity.getHihokenshaName()));
        result.setSakuseiYMD(new FlexibleDate(trim囲み文字(headEntity.getSakuseiYMD())));
        result.setKokukoRengoukaiNa(trim囲み文字(headEntity.getKokukoRengoukaiNa()));
        result.setNo(trim囲み文字(meisaiEntity.getNo()));
        result.setHihokenshaNo(new HihokenshaNo(trim囲み文字(meisaiEntity.getHihokenshaNo())));
        result.setHiHokenshaSimei(trim囲み文字(meisaiEntity.getHiHokenshaSimei()));
        result.setServiceTeikyoYM(new FlexibleYearMonth(trim囲み文字(meisaiEntity.getServiceTeikyoYM())));
        result.setJigyoshaNo(new JigyoshaNo(trim囲み文字(meisaiEntity.getJigyoshaNo())));
        result.setJigyoshaName(trim囲み文字(meisaiEntity.getJigyoshaName()));
        result.setServiceShuruiCode(new ServiceShuruiCode(trim囲み文字(meisaiEntity.getServiceShuruiCode())));
        result.setServiceShuruiName(trim囲み文字(meisaiEntity.getServiceShuruiName()));
        result.setServiceHiyoGokeiGaku(checkDecimal(meisaiEntity.getServiceHiyoGokeiGaku()));
        result.setRiyoshaFutanGaku(checkDecimal(meisaiEntity.getRiyoshaFutanGaku()));
        result.setBikou(trim囲み文字(meisaiEntity.getBikou()));
        result.setShikakuSoshitsuYMD(FlexibleDate.EMPTY);
        result.setServiceHiyoGokeiGakuGokei(checkDecimal(gokeiEntity.getServiceHiyoGokeiGakuGokei()));
        result.setRiyoshaFutanGakuGokei(checkDecimal(gokeiEntity.getRiyoshaFutanGakuGokei()));
        result.setSanteiKijunGaku(checkDecimal(gokeiEntity.getSanteiKijunGaku()));
        result.setShiharaiSumiKingakuGokei(checkDecimal(gokeiEntity.getShiharaiSumiKingakuGokei()));
        result.setKogakuShikyuGaku(checkDecimal(gokeiEntity.getKogakuShikyuGaku()));
        result.setSetaiShuyakuNo(HihokenshaNo.EMPTY);

        return result;
    }

    private DbTKogakuKyufuTaishoshaDataTempTableEntity createDataRecord(DbTKogakuKyufuCSVDataHeadEntity headEntity) {
        DbTKogakuKyufuTaishoshaDataTempTableEntity result = new DbTKogakuKyufuTaishoshaDataTempTableEntity();
        result.setKokanShikibetsuNo((trim囲み文字(headEntity.getKokanShikibetsuNo())));
        result.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(trim囲み文字(headEntity.getShoKisaiHokenshaNo())));
        result.setHokenshaNo(new HokenshaNo(trim囲み文字(headEntity.getHokenshaNo())));
        result.setHihokenshaName(trim囲み文字(headEntity.getHihokenshaName()));
        result.setSakuseiYMD(new FlexibleDate(trim囲み文字(headEntity.getSakuseiYMD())));
        result.setKokukoRengoukaiNa(trim囲み文字(headEntity.getKokukoRengoukaiNa()));
        return result;
    }

    private RString trim囲み文字(RString 対象文字列) {

        final char trim文字 = '"';

        try {

            対象文字列 = 対象文字列.trim(trim文字);
        } catch (NullPointerException e) {
            対象文字列 = RString.EMPTY;
        }
        return 対象文字列;
    }

    private Decimal checkDecimal(Decimal 金額) {
        if (金額 == null) {
            return new Decimal(0);
        }

        return 金額;
    }

}
