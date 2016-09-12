/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.shotokujohochushutsurenkei;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigoshotokutemp.DbtKaigoShotokuTempEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.shutokujohochushutsurenkei.IShutokuJohoChushutsuRenkeiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得情報抽出・連携（バッチ）バッチフロークラスです。
 *
 * @reamsid_L DBB-1690-060 sunhui
 */
public class ShotokuJohoChushutsuRenkeiInsertTempProcess extends SimpleBatchProcessBase {

    private IShutokuJohoChushutsuRenkeiMapper mapper;
    private static final RString TABLE_NAME = new RString("DbTKaigoShotokuTempTable");

    @BatchWriter
    BatchEntityCreatedTempTableWriter tempTableWriter;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IShutokuJohoChushutsuRenkeiMapper.class);
    }

    /**
     * 一時テーブルの取り込み
     */
    protected void createWriter() {
        tempTableWriter
                = new BatchEntityCreatedTempTableWriter(TABLE_NAME,
                        DbtKaigoShotokuTempEntity.class);
    }

    @Override
    protected void process() {
        mapper.get介護所得一時テーブルの情報();
    }

}
