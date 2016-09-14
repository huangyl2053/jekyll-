/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc150030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.DbWT3470chohyouShutsuryokuyouTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票出力用一時TBLの取得処理Processクラスです。
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
public class ChohyouShutsuryokuyouProcess
        extends BatchProcessBase<DbWT3470chohyouShutsuryokuyouTempEntity> {

    /**
     * 登録結果返した
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicecoderiyojokyo."
                    + "IServicecodeRiyojokyoMapper.get帳票出力用一時TBL");

    private OutputParameter<List<DbWT3470chohyouShutsuryokuyouTempEntity>> flowEntity;
    List<DbWT3470chohyouShutsuryokuyouTempEntity> tempEntityList;

    @Override
    protected void initialize() {
        tempEntityList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
    }

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected void process(DbWT3470chohyouShutsuryokuyouTempEntity entity) {
        tempEntityList.add(entity);
    }

    @Override
    protected void afterExecute() {
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(tempEntityList);
    }

}
