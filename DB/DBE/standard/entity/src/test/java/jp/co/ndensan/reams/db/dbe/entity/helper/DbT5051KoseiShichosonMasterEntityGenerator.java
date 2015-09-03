/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 構成市町村マスタエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5051KoseiShichosonMasterEntityGenerator {

    public static final RString DEFAULT_市町村識別ID = new RString("名称");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5051KoseiShichosonMasterEntityGenerator() {
    }

    public static DbT5051KoseiShichosonMasterEntity createDbT5051KoseiShichosonMasterEntity() {
        DbT5051KoseiShichosonMasterEntity entity = new DbT5051KoseiShichosonMasterEntity();
        entity.setShichosonShokibetsuID(DEFAULT_市町村識別ID);
        return entity;
    }
}
