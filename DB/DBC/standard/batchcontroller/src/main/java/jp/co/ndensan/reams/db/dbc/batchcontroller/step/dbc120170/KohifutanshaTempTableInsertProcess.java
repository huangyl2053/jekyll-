/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120170;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kagoketteikohifutanshain.KagoKetteiKohifutanshaInEntityCreater;
import jp.co.ndensan.reams.db.dbc.entity.csv.KagoKetteiKohifutanshaInHeaderCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.KagoKetteiKohifutanshaInMesaiCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.KagoKetteiKohifutanshaInShukeiCSVEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteikohifutanshain.IKagoKetteiKohishaMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイルのデータを一時テーブルに設定する。
 *
 * @reamsid_L DBC-0980-420 zhangrui
 */
public class KohifutanshaTempTableInsertProcess extends BatchProcessBase<RString> {

    /**
     * ファイルパス
     */
    public static final RString PARAMETER_FILEPATH;

    static {
        PARAMETER_FILEPATH = new RString("filePath");
    }
    private static final RString レコード種別ヘッダ部 = new RString("H1");
    private static final RString レコード種別明細部 = new RString("D1");
    private static final RString レコード種別集計部 = new RString("T1");
    private static final RString 区切り文字 = new RString(",");
    private static final int INDEX_RECORDTYPE = 1;

//    InputParameter<RString> filePath;
    private KagoKetteiKohifutanshaInEntityCreater creater;
    private KagoKetteiKohifutanshaInHeaderCSVEntity csvHeader;
    private List<KagoKetteiKohifutanshaInMesaiCSVEntity> csvMeisaiList;
    private KagoKetteiKohifutanshaInShukeiCSVEntity csvShukei;
    private IKagoKetteiKohishaMapper mapper;

    @Override
    protected void initialize() {
        super.initialize();
        mapper = getMapper(IKagoKetteiKohishaMapper.class);
        creater = new KagoKetteiKohifutanshaInEntityCreater();
        csvMeisaiList = new ArrayList<>();
    }

    @Override
    protected void beforeExecute() {
        mapper.create過誤決定明細一時テーブル();
        mapper.create過誤決定集計一時テーブル();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(RString.EMPTY);
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
        } else if (レコード種別集計部.equals(レコード種別)) {
            csvShukei = creater.createCsvShukei(data);
        }
    }

    @Override
    protected void afterExecute() {
        for (KagoKetteiKohifutanshaInMesaiCSVEntity csvMeisai : csvMeisaiList) {
            mapper.insert過誤決定明細一時テーブル(creater.createMeisaiEntity(csvHeader, csvMeisai));
        }
        mapper.insert過誤決定集計一時テーブル(creater.createShukeiEntity(csvHeader, csvShukei));
    }
}
