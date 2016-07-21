/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.karisanteiidokekka.KarisanteiIdoKekkaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.karisanteiidofuka.KariSanteiIdoFukaBatch;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 依頼金計算処理区分クラスです。
 *
 * @reamsid_L DBB-0850-010 zhaowei
 */
public class IraikinKeisanShoriKubunProcess extends SimpleBatchProcessBase {

    private KarisanteiIdoKekkaProcessParameter processParameter;

    /**
     * OutputParameter用キー shoriKubun
     */
    public static final RString 依頼金計算処理区分;

    static {
        依頼金計算処理区分 = new RString("shoriKubun");
    }

    private OutputParameter<RString> shoriKubun;

    RString 処理区分;

    @Override
    protected void beforeExecute() {
        shoriKubun = new OutputParameter<>();
    }

    @Override
    protected void process() {
        KariSanteiIdoFukaBatch manager = KariSanteiIdoFukaBatch.createInstance();
        処理区分 = manager.getIraikinKeisanShoriKubun(processParameter.get調定年度(),
                Integer.parseInt(processParameter.get処理対象月().toString()));

    }

    @Override
    protected void afterExecute() {
        shoriKubun.setValue(処理区分);
    }
}
