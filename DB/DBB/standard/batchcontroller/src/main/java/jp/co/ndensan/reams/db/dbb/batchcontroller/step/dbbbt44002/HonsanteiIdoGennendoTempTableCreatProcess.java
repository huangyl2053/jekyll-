/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt44002;

import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteiidogennendotsuchisyoikatsuhako.IHonsanteiIdoGennendoTsuchisyoIkatsuMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 一時テーブル作成するクラスです。
 *
 * @reamsid_L DBB-0880-030 xicongwang
 */
public class HonsanteiIdoGennendoTempTableCreatProcess extends SimpleBatchProcessBase {

    private IHonsanteiIdoGennendoTsuchisyoIkatsuMapper mapper;

    @BatchWriter
    BatchEntityCreatedTempTableWriter tempTableWriter;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IHonsanteiIdoGennendoTsuchisyoIkatsuMapper.class);
    }

    @Override
    protected void process() {
        mapper.creat賦課情報一時();
        mapper.creat特徴仮算定一時();
    }
}
