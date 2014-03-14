/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.relate;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5102ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5103GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5104ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJohoEntity;

/**
 * 合議体関連の情報である合議体情報、合議体開催場所情報、合議体割当委員、審査会委員の情報を扱うEntityです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiWariateShinsakaiIinEntity {

    private DbT5103GogitaiJohoEntity 合議体情報Entity;
    private DbT5107GogitaiWariateIinJohoEntity 割当Entity;
    private DbT5102ShinsakaiIinJohoEntity 委員Entity;
    private DbT5104ShinsakaiKaisaiBashoJohoEntity 開催場所Entity;

    /**
     * デフォルトコンストラクタです。
     */
    public GogitaiWariateShinsakaiIinEntity() {
    }

    /**
     * 引数から値を受け取るコンストラクタです。
     *
     * @param 合議体情報Entity 合議体情報Entity
     * @param 割当Entity 割当Entity
     * @param 委員Entity 委員Entity
     * @param 開催場所Entity 開催場所Entity
     */
    public GogitaiWariateShinsakaiIinEntity(DbT5103GogitaiJohoEntity 合議体情報Entity, DbT5107GogitaiWariateIinJohoEntity 割当Entity,
            DbT5102ShinsakaiIinJohoEntity 委員Entity, DbT5104ShinsakaiKaisaiBashoJohoEntity 開催場所Entity) {
        this.合議体情報Entity = 合議体情報Entity;
        this.割当Entity = 割当Entity;
        this.委員Entity = 委員Entity;
        this.開催場所Entity = 開催場所Entity;
    }

    /**
     * 合議体情報Entityを返します。
     *
     * @return 合議体情報Entity
     */
    public DbT5103GogitaiJohoEntity get合議体情報Entity() {
        return 合議体情報Entity;
    }

    /**
     * 合議体割当Entityを返します。
     *
     * @return 合議体割当Entity
     */
    public DbT5107GogitaiWariateIinJohoEntity get合議体割当Entity() {
        return 割当Entity;
    }

    /**
     * 審査会委員Entityを返します。
     *
     * @return 審査会委員Entity
     */
    public DbT5102ShinsakaiIinJohoEntity get審査会委員Entity() {
        return 委員Entity;
    }

    /**
     * 開催場所Entityを取得します。
     *
     * @return 開催場所Entity
     */
    public DbT5104ShinsakaiKaisaiBashoJohoEntity get開催場所Entity() {
        return 開催場所Entity;
    }

    /**
     * 引数から渡した合議体情報Entityを、メンバにセットします。
     *
     * @param 合議体情報Entity 合議体情報Entity
     */
    public void set合議体情報Entity(DbT5103GogitaiJohoEntity 合議体情報Entity) {
        this.合議体情報Entity = 合議体情報Entity;
    }

    /**
     * 引数から渡した合議体割当Entityを、メンバにセットします。
     *
     * @param 合議体割当Entity 合議体割当Entity
     */
    public void set割当Entity(DbT5107GogitaiWariateIinJohoEntity 合議体割当Entity) {
        this.割当Entity = 合議体割当Entity;
    }

    /**
     * 引数から渡した審査会委員Entityを、メンバにセットします。
     *
     * @param 審査会委員Entity 審査会委員Entity
     */
    public void set委員Entity(DbT5102ShinsakaiIinJohoEntity 審査会委員Entity) {
        this.委員Entity = 審査会委員Entity;
    }

    /**
     * 引数から渡した開催場所Entityを、メンバにセットします。
     *
     * @param 開催場所Entity 開催場所Entity
     */
    public void set開催場所Entity(DbT5104ShinsakaiKaisaiBashoJohoEntity 開催場所Entity) {
        this.開催場所Entity = 開催場所Entity;
    }
}
