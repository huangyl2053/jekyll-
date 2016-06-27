/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.nenreitotatsushikakuido;

import jp.co.ndensan.reams.db.dba.definition.batchprm.nenreitotatsushikakuido.NenreitotatsuShikakuIdoBatchFlowParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;

/**
 * 認定調査督促対象者一覧表CSV作成_バッチ処理クラスパラメータクラスです。
 *
 * @reamsid_L DBA-0330-010 xuyue
 */
@lombok.Getter
@lombok.Setter
public class NenreitotatsuJokenUpdateProcessParameter implements IBatchProcessParameter {

    private NenreitotatsuShikakuIdoBatchFlowParameter flowParam;

    /**
     * 65歳年齢到達資格異動バッチパラメータの取得です。
     *
     * @return 65歳年齢到達資格異動バッチパラメータ
     */
    public NenreitotatsuShikakuIdoBatchFlowParameter getFlowParam() {
        return flowParam;
    }

    /**
     * 65歳年齢到達資格異動バッチパラメータの設定です。
     *
     * @param flowParam 65歳年齢到達資格異動バッチパラメータ
     */
    public void setFlowParam(NenreitotatsuShikakuIdoBatchFlowParameter flowParam) {
        this.flowParam = flowParam;
    }

}
