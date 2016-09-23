/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.shikakushogohyojyoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.shikakushogohyojyoho.ShikakuShogohyoJyohoReadCsvFileParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.shikakushogohyojyoho.ShikakuShogohyoJyohoInDataHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.shikakushogohyojyoho.ShikakuShogohyoJyohoInDataMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikakushogohyojyoho.DbWT1211ShikakuShogohyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0001HihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbc.service.core.shikakushogohyojyoho.ShikakuShogohyoJyohoReadCsvFileService;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchCsvListReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格照合表情報取込共通処理（CSVファイル取込）Process
 *
 * @reamsid_L DBC-2890-013 wangxue
 */
public class ShikakuShogohyoJyohoReadCsvFileProcess extends BatchProcessBase<List<RString>> {

    private static final RString 帳票レコード種別_H1 = new RString("H1");
    private static final RString 帳票レコード種別_D1 = new RString("D1");
    private static final RString カンマ = new RString(",");
    private static final RString レコード種別 = new RString("1");
    private static final RString レコード種別_3 = new RString("3");
    private static final int INDEX_0 = 0;
    private static final int INDEX_3 = 3;
    private static final int INDEX_1 = 1;

    private ShikakuShogohyoJyohoReadCsvFileService service;
    private ShikakuShogohyoJyohoReadCsvFileParameter parameter;
    private ShikakuShogohyoJyohoInDataHeadEntity headCsvEntity;
    private ShikakuShogohyoJyohoInDataMeisaiEntity meisaiCsvcsvEntity;
    private KagoKetteiHokenshaInControlCsvEntity controlCsvEntity;

    /**
     * CSVファイル取込後の返したエンティティ
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }
    private OutputParameter<FlowEntity> flowEntity;
    private FlowEntity returnEntity;
    private int 連番;

    @BatchWriter
    private IBatchTableWriter 資格照合表一時tableWriter;
    @BatchWriter
    private IBatchTableWriter 被保険者一時tableWriter;
    @BatchWriter
    private IBatchTableWriter 処理結果リスト一時tableWriter;
    private static final RString 資格照合表一時_TABLE_NAME = new RString("DbWT1211ShikakuShogohyo");
    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT0001Hihokensha");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");

    @Override
    protected void initialize() {

        service = ShikakuShogohyoJyohoReadCsvFileService.createInstance();
        controlCsvEntity = new KagoKetteiHokenshaInControlCsvEntity();
        returnEntity = new FlowEntity();
        連番 = parameter.get連番();

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchCsvListReader(new CsvListReader.InstanceBuilder(parameter.get保存先フォルダ())
                .setDelimiter(カンマ).setEncode(Encode.SJIS).hasHeader(false).setNewLine(NewLine.CRLF).build());
    }

    @Override
    protected void createWriter() {

        資格照合表一時tableWriter
                = new BatchEntityCreatedTempTableWriter(資格照合表一時_TABLE_NAME, DbWT1211ShikakuShogohyoTempEntity.class);
        被保険者一時tableWriter
                = new BatchEntityCreatedTempTableWriter(被保険者一時_TABLE_NAME, DbWT0001HihokenshaEntity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME, DbWT0002KokuhorenTorikomiErrorEntity.class);
    }

    @Override
    protected void process(List<RString> data) {
        if (!レコード種別_3.equals(data.get(INDEX_0))) {
            if (レコード種別.equals(data.get(INDEX_0))) {
                controlCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInControlCsvEntity.class, data);
            } else if (帳票レコード種別_H1.equals(data.get(INDEX_3))) {
                headCsvEntity = ListToObjectMappingHelper.toObject(ShikakuShogohyoJyohoInDataHeadEntity.class, data);
            } else if (帳票レコード種別_D1.equals(data.get(INDEX_3))) {
                meisaiCsvcsvEntity = ListToObjectMappingHelper.toObject(ShikakuShogohyoJyohoInDataMeisaiEntity.class, data);
                addMeisai();
            }
        }
    }

    @Override
    protected void afterExecute() {
        if (parameter.isLast() && 連番 == INDEX_0) {
            処理結果リスト一時tableWriter.insert(service.to処理結果リスト一時());
        }
        if (null == returnEntity.getShoriYM()) {
            returnEntity.setShoriYM(new FlexibleYearMonth(controlCsvEntity.getShoriYM()));
        }
        returnEntity.set明細データ登録件数(連番);
        int codeNum;
        if (controlCsvEntity.getCodeNum() != null && !controlCsvEntity.getCodeNum().isEmpty()) {
            codeNum = parameter.getCodeNum() + Integer.valueOf(controlCsvEntity.getCodeNum().toString());
        } else {
            codeNum = parameter.getCodeNum();
        }
        returnEntity.setCodeNum(codeNum);
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(returnEntity);
    }

    private void addMeisai() {
        if (headCsvEntity != null && meisaiCsvcsvEntity != null) {
            連番 = 連番 + INDEX_1;
            資格照合表一時tableWriter.insert(service.to資格照合表一時(controlCsvEntity, meisaiCsvcsvEntity, 連番));
            被保険者一時tableWriter.insert(service.to被保険者一時(headCsvEntity, meisaiCsvcsvEntity, 連番));
            meisaiCsvcsvEntity = null;
        }
    }

}
