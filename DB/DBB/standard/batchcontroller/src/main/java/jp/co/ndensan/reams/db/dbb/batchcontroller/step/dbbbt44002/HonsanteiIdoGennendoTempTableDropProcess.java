/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt44002;

import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteiidogennendotsuchisyoikatsuhako.IHonsanteiIdoGennendoTsuchisyoIkatsuMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 計算後情報一時テーブル削除するクラスです。
 *
 * @reamsid_L DBB-0880-030 xicongwang
 */
public class HonsanteiIdoGennendoTempTableDropProcess extends SimpleBatchProcessBase {

    private IHonsanteiIdoGennendoTsuchisyoIkatsuMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IHonsanteiIdoGennendoTsuchisyoIkatsuMapper.class);
    }

    @Override
    protected void process() {
        mapper.drop計算後情報中間一時();
        mapper.drop計算後情報一時();
    }
}
