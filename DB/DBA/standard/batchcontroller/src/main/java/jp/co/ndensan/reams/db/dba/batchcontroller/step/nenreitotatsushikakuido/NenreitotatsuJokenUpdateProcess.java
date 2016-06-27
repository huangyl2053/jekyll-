/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.nenreitotatsushikakuido;

import jp.co.ndensan.reams.db.dba.definition.processprm.nenreitotatsushikakuido.NenreitotatsuJokenUpdateProcessParameter;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaichokoshin.HihokenshaDaichoKoshin;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 年齢到達条件の更新_バッチ処理クラスです。
 *
 * @reamsid_L DBA-0330-010 xuyue
 */
public class NenreitotatsuJokenUpdateProcess extends SimpleBatchProcessBase {

    private NenreitotatsuJokenUpdateProcessParameter parameter;
    private HihokenshaDaichoKoshin hihokenshaDaichoKoshin;

    @Override
    protected void beforeExecute() {
        this.hihokenshaDaichoKoshin = HihokenshaDaichoKoshin.createInstance();
    }

    @Override
    @Transaction
    protected void process() {
        hihokenshaDaichoKoshin.updNenreitotatsuJoken(parameter.getFlowParam());
    }

}
