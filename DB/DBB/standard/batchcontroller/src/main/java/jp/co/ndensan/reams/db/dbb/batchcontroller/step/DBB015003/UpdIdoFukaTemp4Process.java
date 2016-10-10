/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB015003;

import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.karisanteiidotsuchisho.IKarisanteiIdoFukaMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 「生活保護区分を更新」処理クラスです。
 *
 * @reamsid_L DBB-0890-030 xicongwang
 */
public class UpdIdoFukaTemp4Process extends SimpleBatchProcessBase {

    private IKarisanteiIdoFukaMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IKarisanteiIdoFukaMapper.class);
    }

    @Override
    protected void process() {
        mapper.update異動賦課情報一時テーブル生活保護区分();
    }

    @Override
    protected void afterExecute() {
    }

}
