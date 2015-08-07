/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7050KaigoHokenshaEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険者エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7050KaigoHokenshaEntityGenerator {

    public static final LasdecCode DEFAULT_広域保険者市町村コード = new LasdecCode(new RString("012345"));
    public static final ShoKisaiHokenshaNo DEFAULT_広域保険者番号 = new ShoKisaiHokenshaNo(new RString("2"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7050KaigoHokenshaEntityGenerator() {
    }

    public static DbT7050KaigoHokenshaEntity createDbT7050KaigoHokenshaEntity() {
        DbT7050KaigoHokenshaEntity entity = new DbT7050KaigoHokenshaEntity();
        entity.setKoikiHokenshaShichosonCode(DEFAULT_広域保険者市町村コード);
        entity.setKoikiHokenshaNo(DEFAULT_広域保険者番号);
        return entity;
    }
}
