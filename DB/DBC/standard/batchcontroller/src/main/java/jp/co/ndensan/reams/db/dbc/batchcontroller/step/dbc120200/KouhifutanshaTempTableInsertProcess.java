/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120200;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsa.SaishinsaKohifutanshaEntityCreater;
import jp.co.ndensan.reams.db.dbc.entity.csv.SaishinsaKohifutanshaHeaderCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.SaishinsaKohifutanshaMesaiCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.SaishinsaKohifutanshaShukeiCSVEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.saishinsakohifutansha.ISaishinsaKohishaMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイルのデータを一時テーブルに設定する。
 *
 * @reamsid_L DBC-2820-010 sunhui
 */
public class KouhifutanshaTempTableInsertProcess extends BatchProcessBase<RString> {

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

    InputParameter<RString> filePath;

    private SaishinsaKohifutanshaEntityCreater creater;
    private SaishinsaKohifutanshaHeaderCSVEntity csvHeader;
    private List<SaishinsaKohifutanshaMesaiCSVEntity> csvMeisaiList;
    private SaishinsaKohifutanshaShukeiCSVEntity csvShukei;
    private ISaishinsaKohishaMapper mapper;

    @Override
    protected void initialize() {
        super.initialize();
        mapper = getMapper(ISaishinsaKohishaMapper.class);
        creater = new SaishinsaKohifutanshaEntityCreater();
        csvMeisaiList = new ArrayList<>();
    }

    @Override
    protected void beforeExecute() {
        mapper.create再審査明細一時テーブル();
        mapper.create再審査集計一時テーブル();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(filePath.getValue());
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
        for (SaishinsaKohifutanshaMesaiCSVEntity csvMeisai : csvMeisaiList) {
            mapper.insert再審査決定明細一時テーブル(creater.createMeisaiEntity(csvHeader, csvMeisai));
        }
        mapper.insert再審査決定集計一時テーブル(creater.createShukeiEntity(csvHeader, csvShukei));
    }

}
