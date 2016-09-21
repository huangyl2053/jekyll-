/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB015001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.karisanteiidokekka.KarisanteiIdoKekkaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.karisanteiidofuka.KariSanteiIdoFukaBatch;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.fuka.ISetaiShotokuKazeiHanteiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 賦課計算(資格取得)クラスです。
 *
 * @reamsid_L DBB-0850-010 zhaowei
 */
public class CaluculateFukaShikakuShutokuProcess extends SimpleBatchProcessBase {

    private KarisanteiIdoKekkaProcessParameter processParameter;
    private ISetaiShotokuKazeiHanteiMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(ISetaiShotokuKazeiHanteiMapper.class);
        mapper.createTmpSetaiShotoku();
    }

    @Override
    protected void process() {
        KariSanteiIdoFukaBatch manager = KariSanteiIdoFukaBatch.createInstance();
        manager.caluculateFukaShikakuShutoku(processParameter.get調定年度(), processParameter.get賦課年度(),
                new YMDHMS(processParameter.get調定日時()), processParameter.get処理対象月());
    }

    @Override
    protected void afterExecute() {
    }
}
