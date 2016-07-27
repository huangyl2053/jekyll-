/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120100;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanfushikyuketteiin.ShokanFushikyuKetteiInEntityCreater;
import jp.co.ndensan.reams.db.dbc.entity.csv.ShokanFushikyuKetteiInHeaderCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.ShokanFushikyuKetteiInMeisaiCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.ShokanFushikyuKetteiInEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * ファイルのデータを一時テーブルに設定する。
 *
 * @reamsid_L DBC-2590-010 xuhao
 */
public class ShokanFushikyuTableInsertProcess extends BatchProcessBase<RString> {

    /**
     * ファイルパス
     */
    public static final RString PARAMETER_FILEPATH;

    static {
        PARAMETER_FILEPATH = new RString("filePath");
    }

    /**
     * TABLE_NAME
     */
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = new RString("DbTShokanFushikyuKetteiInTempTable");
    }
    private static final RString レコード種別ヘッダ部 = new RString("H1");
    private static final RString レコード種別明細部 = new RString("D1");
    private static final RString 区切り文字 = new RString(",");
    private static final int INDEX_RECORDTYPE = 1;

    InputParameter<RString> filePath;

    private ShokanFushikyuKetteiInEntityCreater creater;
    private ShokanFushikyuKetteiInHeaderCSVEntity csvHeader;
    private List<ShokanFushikyuKetteiInMeisaiCSVEntity> csvMeisaiList;

    @BatchWriter
    BatchEntityCreatedTempTableWriter tempTableWriter;

    @Override
    protected void initialize() {
        super.initialize();
        creater = new ShokanFushikyuKetteiInEntityCreater();
        csvMeisaiList = new ArrayList<>();
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(filePath.getValue());
    }

    @Override
    protected void createWriter() {
        tempTableWriter
                = new BatchEntityCreatedTempTableWriter(TABLE_NAME,
                        ShokanFushikyuKetteiInEntity.class);
    }

    @Override
    protected void process(RString line) {
        List<RString> data = line.split(区切り文字.toString());
        if (null == data || INDEX_RECORDTYPE >= data.size()) {
            return;
        }
        RString レコード種別 = creater.trim囲み文字(data.get(INDEX_RECORDTYPE));
        if (レコード種別ヘッダ部.equals(レコード種別)) {
            csvHeader = creater.createCsvHeader(data);
        } else if (レコード種別明細部.equals(レコード種別)) {
            csvMeisaiList.add(creater.createCsvMeisai(data));
        }
    }

    @Override
    protected void afterExecute() {
        for (ShokanFushikyuKetteiInMeisaiCSVEntity csvMeisai : csvMeisaiList) {
            tempTableWriter.insert((IDbAccessable) creater.createFushikyuEntity(csvHeader, csvMeisai));
        }
    }

}
