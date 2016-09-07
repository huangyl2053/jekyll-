/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.karisanteiidokekka.KarisanteiIdoKekkaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.karisanteiidofuka.KariSanteiIdoFukaBatch;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 仮算定異動(一括)結果一覧表出力クラスです。
 *
 * @reamsid_L DBB-0850-010 zhaowei
 */
public class SpoolKariSanteiIdoKekkaIchiranProcess extends SimpleBatchProcessBase {

    private KarisanteiIdoKekkaProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        KariSanteiIdoFukaBatch manager = KariSanteiIdoFukaBatch.createInstance();
        if (processParameter.get出力帳票List() != null && !processParameter.get出力帳票List().isEmpty()) {
            manager.spoolKariSanteiIdoKekkaIchiran(processParameter.get調定年度(),
                    processParameter.get賦課年度(), new YMDHMS(processParameter.get調定日時()),
                    Long.parseLong(processParameter.get出力帳票List().get(0).get出力順ID().toString()));
        }
    }

    @Override
    protected void afterExecute() {

    }
}
