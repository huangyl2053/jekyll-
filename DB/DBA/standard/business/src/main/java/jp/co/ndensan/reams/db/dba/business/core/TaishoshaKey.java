/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 *
 * @author n8178
 */
public class TaishoshaKey implements Serializable {

    public TaishoshaKey(HihokenshaNo hihokenshaNo, ShikibetsuCode EMPTY, SetaiCode EMPTY0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ShikibetsuCode get識別コード() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //TODO n8178 城間 過去にMedelに存在したクラスのダミーです。不要になったタイミングで削除します。
}
