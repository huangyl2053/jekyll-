/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB015001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.karisanteiidokekka.KarisanteiIdoKekkaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.karisanteiidofuka.KariSanteiIdoFukaBatch;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
        Long 出力順ID = null;
        if (!RString.isNullOrEmpty(processParameter.get出力帳票Entity().get出力順ID())) {
            出力順ID = Long.parseLong(processParameter.get出力帳票Entity().get出力順ID().toString());
        }
        if (processParameter.get出力帳票Entity() != null) {
            manager.spoolKariSanteiIdoKekkaIchiran(processParameter.get調定年度(), processParameter.get賦課年度(),
                    new YMDHMS(processParameter.get調定日時()), 出力順ID, processParameter.get抽出開始日時(),
                    processParameter.get抽出終了日時());
        }
    }

    @Override
    protected void afterExecute() {

    }
}
