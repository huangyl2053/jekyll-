/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120090;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanshikyuketteiin.ShokanShikyuKetteiInEntityCreater;
import jp.co.ndensan.reams.db.dbc.definition.processprm.shokanshikyuketteiin.ShokanShikyuKetteiInProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.ShokanShikyuKetteiInHeaderCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.ShokanShikyuKetteiInMeisaiCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho.ShokanBaraShiketteiJohoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanbaraishikyuketteijoho.IShokanBaraiShikyuKetteiJohoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * CSVファイルのデータを読む込み、償還払支給決定情報一時TBLに登録のクラスです。
 *
 * @reamsid_L DBC-0980-330 gongliang
 */
public class RegistTempSaveProcess extends BatchProcessBase<RString> {

    private static final RString レコード種別ヘッダ部 = new RString("H1");
    private static final RString レコード種別明細部 = new RString("D1");
    private static final RString 区切り文字 = new RString(",");
    private static final int INDEX_RECORDTYPE = 1;
    private ShokanShikyuKetteiInProcessParameter parameter;

    private ShokanShikyuKetteiInEntityCreater creater;
    private ShokanShikyuKetteiInHeaderCSVEntity csvHeader;
    private List<ShokanShikyuKetteiInMeisaiCSVEntity> csvMeisaiList;
    private List<ShokanBaraShiketteiJohoEntity> shokanList;
    private IShokanBaraiShikyuKetteiJohoMapper mapper;

    @Override
    protected void initialize() {
        super.initialize();
        mapper = getMapper(IShokanBaraiShikyuKetteiJohoMapper.class);
        creater = new ShokanShikyuKetteiInEntityCreater();
        csvMeisaiList = new ArrayList<>();
    }

    @Override
    protected void beforeExecute() {
        mapper.create償還払支給決定情報一時TBL();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(parameter.getSaveFilePath());
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
        for (ShokanShikyuKetteiInMeisaiCSVEntity csvMeisai : csvMeisaiList) {
            if (csvHeader.get証記載保険者番号().equals(csvMeisai.get被保険者番号())) {
                ShokanBaraShiketteiJohoEntity entity = creater.createShokanBaraShiketteiJohoEntity(csvHeader, csvMeisai);
                shokanList.add(entity);
            }
        }
    }

    @Override
    protected void afterExecute() {
        for (ShokanBaraShiketteiJohoEntity entity : shokanList) {
            mapper.insert償還払支給決定情報一時TBL(creater.createShokanBaraiShikyuKetteiJohoItijiEntity(entity));
        }
    }
}
