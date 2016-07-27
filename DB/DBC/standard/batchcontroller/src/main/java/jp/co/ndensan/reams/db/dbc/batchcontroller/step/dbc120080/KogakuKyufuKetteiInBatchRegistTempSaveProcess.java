/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120080;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakukyufuketteiin.KogakuKyufuKetteiInEntityCreater;
import jp.co.ndensan.reams.db.dbc.entity.csv.KogakuKyufuKetteiInHeaderCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.KogakuKyufuKetteiInMeisaiCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin.KogakuKyufuKetteiInTempTableEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakuserviceketteijoho.IKogakuServiceKetteiJohoTorikomiDataHenshuMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイルのデータを一時デーブルに設定する
 *
 * @reamsid_L DBC-0980-390 lijunjun
 */
public class KogakuKyufuKetteiInBatchRegistTempSaveProcess extends BatchProcessBase<RString> {

    /**
     * ファイルパス
     */
    public static final RString PARAMETER_FILEPATH;

    static {
        PARAMETER_FILEPATH = new RString("filePath");
    }

    private static final RString レコード種別ヘッダ部 = new RString("H1");
    private static final RString レコード種別明細部 = new RString("D1");
    private static final int INDEX_RECORDTYPE = 1;
    private static final RString 区切り文字 = new RString(",");

    InputParameter<RString> filePath;

    private IKogakuServiceKetteiJohoTorikomiDataHenshuMapper mapper;

    private KogakuKyufuKetteiInEntityCreater creater;
    private KogakuKyufuKetteiInHeaderCSVEntity csvHeader;
    private List<KogakuKyufuKetteiInMeisaiCSVEntity> csvMeisaiList;

    @Override
    protected void initialize() {
        super.initialize();
        mapper = getMapper(IKogakuServiceKetteiJohoTorikomiDataHenshuMapper.class);
        creater = new KogakuKyufuKetteiInEntityCreater();
        csvMeisaiList = new ArrayList<>();
    }

    @Override
    protected void beforeExecute() {
        mapper.creat高額サービス費決定情報一時テーブル();
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
        }

    }

    @Override
    protected void afterExecute() {
        for (KogakuKyufuKetteiInMeisaiCSVEntity csvMeisai : csvMeisaiList) {
            if (csvHeader.get証記載保険者番号().equals(csvMeisai.get被保険者番号())) {
                KogakuKyufuKetteiInTempTableEntity entity = creater.createEntity(csvHeader, csvMeisai);
                mapper.insert高額サービス費決定情報一時テーブル(entity);
            }
        }
    }
}
