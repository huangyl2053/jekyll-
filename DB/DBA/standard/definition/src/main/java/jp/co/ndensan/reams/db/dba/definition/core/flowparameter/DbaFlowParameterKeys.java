/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.flowparameter;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * フローパラメータとして使用するキーを定義します。
 *
 * @author n8178
 */
public enum DbaFlowParameterKeys {

    /**
     * 証発行管理リストを生成する際に、「被保険者/資格者 + 発行管理リスト/未回収者リスト」で起動するバッチのIDを切り替えるために使用する。
     */
    被保険者_資格者証発行管理リスト_対象切替("shutsuryokuTaisho");

    private final RString flowParameterName;

    private DbaFlowParameterKeys(String str) {
        flowParameterName = new RString(str);
    }

    public RString getフローパラメータ名() {
        return flowParameterName;
    }
}
