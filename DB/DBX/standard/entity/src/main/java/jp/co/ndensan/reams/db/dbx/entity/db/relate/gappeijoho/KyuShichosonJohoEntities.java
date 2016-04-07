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
 */
public final class KyuShichosonJohoEntities implements Serializable, Iterable<DbT7056GappeiShichosonEntity> {

    private static final long serialVersionUID = 1L;

    private final List<DbT7056GappeiShichosonEntity> entities;
    private final boolean gappeiShichoUmuFlag;

    /**
     * コンストラクタです。
     */
    KyuShichosonJohoEntities() {
        entities = Collections.emptyList();
        gappeiShichoUmuFlag = false;
    }

    /**
     * 指定のlistの要素をすべて保持するインスタンスを生成します。 合併市町村を含む場合は、第2引数にtrueを設定してください。
     *
     * @param entities 全要素
     * @param contains合併市町村 合併市町村を含むかどうか
     */
    public KyuShichosonJohoEntities(List<DbT7056GappeiShichosonEntity> entities, boolean contains合併市町村) {
        this.entities = Collections.unmodifiableList(entities);
        this.gappeiShichoUmuFlag = contains合併市町村;
    }

    /**
     * 空のlistを保持するインスタンスを生成します。
     *
     * @return 空のlistを保持するインスタンス
     */
    public static KyuShichosonJohoEntities empty() {
        return new KyuShichosonJohoEntities();
    }

    /**
     * 合併市町村有無フラグのgetメソッドです。
     *
     * @return 合併市町村有無フラグ
     */
    public boolean contains合併市町村() {
        return gappeiShichoUmuFlag;
    }

    /**
     * 保持する要素が0件の場合、{@code true}を返します。
     *
     * @return 保持する要素が0件の場合{@code true}
     */
    public boolean isEmpty() {
        return this.entities.isEmpty();
    }

    /**
     * 要素数を返却します。
     *
     * @return 要素数
     */
    public int size() {
        return this.entities.size();
    }

    @Override
    public Iterator<DbT7056GappeiShichosonEntity> iterator() {
        return this.entities.iterator();
    }

    /**
     * 合併市町村有無フラグを設定します。
     *
     * @param 合併市町村有無フラグ boolean
     */
    public void setGappeiShichoUmuFlag(boolean 合併市町村有無フラグ) {
        gappeiShichoUmuFlag = 合併市町村有無フラグ;
    }

    /**
     * 合併市町村有無フラグを返却します。
     *
     * @return 合併市町村有無フラグ
     */
    public boolean hasGappeiShichoUmuFlag() {
        return gappeiShichoUmuFlag;
    }
    
    
    /**
     * DbT7056GappeiShichosonEntityのリストを設定します。
     *
     * @param dbT7056EntityList List<DbT7056GappeiShichosonEntity>
     */
    public void setEntitys(List<DbT7056GappeiShichosonEntity> dbT7056EntityList) {
        entities = dbT7056EntityList;
    }
    
    /**
     * DbT7056GappeiShichosonEntityのリストを返却します。
     *
     * @return DbT7056GappeiShichosonEntityのリスト
     */
    public List<DbT7056GappeiShichosonEntity> getEntitys() {
        return entities;
    }
}
