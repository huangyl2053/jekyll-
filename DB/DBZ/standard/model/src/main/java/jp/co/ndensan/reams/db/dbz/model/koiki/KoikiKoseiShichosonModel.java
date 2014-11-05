/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.koiki;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域構成市町村のモデルクラスです。<br/>
 * （※別チケットで対応）
 */
public class KoikiKoseiShichosonModel implements IKoikiKoseiShichoson {

    public KoikiKoseiShichosonModel(DbT7051KoseiShichosonMasterEntity entity) {
    }

    @Override
    public RString get合併情報地域番号() {
        return null;
    }
}
