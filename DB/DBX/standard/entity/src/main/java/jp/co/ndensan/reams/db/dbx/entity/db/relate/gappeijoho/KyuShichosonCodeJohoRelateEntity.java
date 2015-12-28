/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;

/**
 * 旧市町村コード情報のモデルクラスです。
 *
 */
public class KyuShichosonCodeJohoRelateEntity implements Serializable, Iterable<DbT7056GappeiShichosonEntity> {

    private final List<DbT7056GappeiShichosonEntity> entities;
    private final boolean gappeiShichoUmuFlag;

    /**
     * コンストラクタです。
     */
    KyuShichosonCodeJohoRelateEntity() {
        entities = Collections.emptyList();
        gappeiShichoUmuFlag = false;
    }

    public KyuShichosonCodeJohoRelateEntity(List<DbT7056GappeiShichosonEntity> entities, boolean contains合併市町村) {
        this.entities = Collections.unmodifiableList(entities);
        this.gappeiShichoUmuFlag = contains合併市町村;
    }

    public static KyuShichosonCodeJohoRelateEntity empty() {
        return new KyuShichosonCodeJohoRelateEntity();
    }

    /**
     * 合併市町村有無フラグのgetメソッドです。
     *
     * @return 合併市町村有無フラグ
     */
    public boolean contains合併市町村() {
        return gappeiShichoUmuFlag;
    }

    public boolean isEmpty() {
        return this.entities.isEmpty();
    }

    public int size() {
        return this.entities.size();
    }

    @Override
    public Iterator<DbT7056GappeiShichosonEntity> iterator() {
        return this.entities.iterator();
    }
}
