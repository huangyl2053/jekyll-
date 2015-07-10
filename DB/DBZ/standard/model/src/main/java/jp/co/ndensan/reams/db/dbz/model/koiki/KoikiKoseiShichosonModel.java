/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.koiki;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域構成市町村のモデルクラスです。<br/>
 * （※別チケットで対応）
 */
public class KoikiKoseiShichosonModel implements IKoikiKoseiShichoson {

    public KoikiKoseiShichosonModel(DbT7051KoseiShichosonMasterEntity entity) {
    }

    @Override
    public RString get市町村識別ID() {
        return null;
    }

    @Override
    public LasdecCode get市町村コード() {
        return null;
    }

    @Override
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return null;
    }

    @Override
    public RString get市町村名称() {
        return null;
    }

    @Override
    public FlexibleDate get加入日() {
        return null;
    }

    @Override
    public FlexibleDate get離脱日() {
        return null;
    }

    @Override
    public RString get合併旧市町村区分() {
        return null;
    }

    @Override
    public RString get合併旧市町村表示有無() {
        return null;
    }

    @Override
    public RString get合併情報地域番号() {
        return null;
    }
}
