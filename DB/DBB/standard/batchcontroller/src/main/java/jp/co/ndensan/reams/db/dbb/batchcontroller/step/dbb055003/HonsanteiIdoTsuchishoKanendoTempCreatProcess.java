/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055003;

import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteiidokanendotsuchishoikkatsuhakko.IKanendoTsuchishoIkkatsuHakkoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 全件賦課情報一時テーブル/異動賦課情報一時テーブル作成するクラスです。
 *
 * @reamsid_L DBB-0920-030 huzongcheng
 */
public class HonsanteiIdoTsuchishoKanendoTempCreatProcess extends SimpleBatchProcessBase {

    private IKanendoTsuchishoIkkatsuHakkoMapper mapper;

    @BatchWriter
    BatchEntityCreatedTempTableWriter tempTableWriter;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IKanendoTsuchishoIkkatsuHakkoMapper.class);
    }

    @Override
    protected void process() {
        mapper.creat賦課情報一時テーブル();
    }
}
