/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoriTimestamp;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;

/**
 * ビルドエラー回避のための暫定modelクラス
 *
 * @author n8187
 */
public class HihokendhaDaichoKey {

    HihokendhaDaichoKey(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    HihokendhaDaichoKey(Object object, HihokenshaNo 被保険者番号, ShoriTimestamp 処理日時) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean evaluate(HihokenshaDaichoModel model) {
        return true;
    }

}
