/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.dba010010;

import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA010010.DBA010010_NenreitotatsuShikakuIdoParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;

/**
 * 認定調査督促対象者一覧表CSV作成_バッチ処理クラスパラメータクラスです。
 *
 * @reamsid_L DBA-0330-010 xuyue
 */
@lombok.Getter
@lombok.Setter
public class NenreitotatsuJokenUpdateProcessParameter implements IBatchProcessParameter {

    private DBA010010_NenreitotatsuShikakuIdoParameter flowParam;

    /**
     * 65歳年齢到達資格異動バッチパラメータの取得です。
     *
     * @return 65歳年齢到達資格異動バッチパラメータ
     */
    public DBA010010_NenreitotatsuShikakuIdoParameter getFlowParam() {
        return flowParam;
    }

    /**
     * 65歳年齢到達資格異動バッチパラメータの設定です。
     *
     * @param flowParam 65歳年齢到達資格異動バッチパラメータ
     */
    public void setFlowParam(DBA010010_NenreitotatsuShikakuIdoParameter flowParam) {
        this.flowParam = flowParam;
    }

}
