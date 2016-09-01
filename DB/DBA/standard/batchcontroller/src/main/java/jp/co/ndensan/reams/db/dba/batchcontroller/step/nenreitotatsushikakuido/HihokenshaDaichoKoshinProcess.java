/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.nenreitotatsushikakuido;

import jp.co.ndensan.reams.db.dba.definition.processprm.dba010010.HihokenshaDaichoKoshinProcessParameter;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaichokoshin.HihokenshaDaichoKoshin;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 資格異動対象者の取得と被保険者台帳の更新_バッチフ処理クラスです。
 *
 * @reamsid_L DBA-0330-010 xuyue
 */
public class HihokenshaDaichoKoshinProcess extends SimpleBatchProcessBase {

    private HihokenshaDaichoKoshin hihokenshaDaichoKoshin;
    private HihokenshaDaichoKoshinProcessParameter parameter;

    @Override
    protected void beforeExecute() {
        hihokenshaDaichoKoshin = HihokenshaDaichoKoshin.createInstance();
    }

    @Override
    protected void process() {
        hihokenshaDaichoKoshin.資格異動対象者の取得と被保険者台帳の更新(parameter);
    }

}
