
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120160;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kagoketteihokenshain.KagoKetteiHokenshaInEntityCreater;
import jp.co.ndensan.reams.db.dbc.entity.csv.KagoKetteiHokenshaInCSVHeaderEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.KagoKetteiHokenshaInCSVMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.KagoKetteiHokenshaInCSVShukeiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteihokenshain.IKagoKetteiHokenshaInMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一時テーブルの登録
 *
 * @reamsid_L DBC-0980-300 xupeng
 */
public class KagoKetteiHokenshaInTempSaveProcess extends BatchProcessBase<RString> {

    /**
     * ファイルパス
     */
    public static final RString PARAMETER_FILEPATH;

    static {
        PARAMETER_FILEPATH = new RString("filePath");
    }
    InputParameter<RString> filePath;

    private final Integer レコード種別 = 1;
    private final RString 区切り文字 = new RString(",");
    private KagoKetteiHokenshaInCSVHeaderEntity header;
    private KagoKetteiHokenshaInCSVMeisaiEntity meisai;
    private KagoKetteiHokenshaInCSVShukeiEntity shukei;
    private final RString レコード種別_ヘッダ = new RString("H1");
    private final RString レコード種別_明細 = new RString("D1");
    private final RString レコード種別_集計 = new RString("T1");
    private IKagoKetteiHokenshaInMapper mapper;
    private KagoKetteiHokenshaInEntityCreater creater;

    @Override
    protected void initialize() {
        super.initialize();
        mapper = getMapper(IKagoKetteiHokenshaInMapper.class);
        creater = new KagoKetteiHokenshaInEntityCreater();
    }

    @Override
    protected void beforeExecute() {
        mapper.create保険者分情報_明細();
        mapper.create保険者分情報_集計();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(filePath.getValue());
    }

    @Override
    protected void process(RString line) {
        List<RString> data = line.split(区切り文字.toString());
        if (null == data || 1 >= data.size()) {
            return;
        }
        if (レコード種別_ヘッダ.equals(data.get(レコード種別))) {
            header = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInCSVHeaderEntity.class, data);
        } else if (レコード種別_明細.equals(data.get(レコード種別))) {
            meisai = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInCSVMeisaiEntity.class, data);
            mapper.insert保険者分情報_明細(creater.createMeiseiRecord(header, meisai));
        } else if (レコード種別_集計.equals(data.get(レコード種別))) {
            shukei = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInCSVShukeiEntity.class, data);
            mapper.insert保険者分情報_集計(creater.createShukeiRecord(header, shukei));
        }
    }
}
