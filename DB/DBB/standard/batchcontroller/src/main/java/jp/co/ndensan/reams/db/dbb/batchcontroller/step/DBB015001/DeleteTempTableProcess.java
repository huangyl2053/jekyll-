/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB015001;

import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.karisanteiidofuka.IKariSanteiIdoFukaBatchMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 一時テーブルの削除クラスです。
 *
 * @reamsid_L DBB-0850-010 chenaoqi
 */
public class DeleteTempTableProcess extends SimpleBatchProcessBase {

    private IKariSanteiIdoFukaBatchMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IKariSanteiIdoFukaBatchMapper.class);
    }

    @Override
    protected void process() {
        mapper.delete賦課の情報一時テーブル();
        mapper.deleteUrT0700ShunoKanri_work();
        mapper.deleteUrT0705ChoteiKyotsu_work();
    }

    @Override
    protected void afterExecute() {

    }
}
