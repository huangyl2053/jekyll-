/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.relate;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5102ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJohoEntity;

/**
 * 合議体割当情報と介護認定審査会委員の情報を関連付けたEntityです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiWariateShinsakaiIinEntity {

    private DbT5107GogitaiWariateIinJohoEntity 割当Entity;
    private DbT5102ShinsakaiIinJohoEntity 委員Entity;

    /**
     * デフォルトコンストラクタです。
     */
    public GogitaiWariateShinsakaiIinEntity() {
    }

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 合議体割当Entity 合議体割当Entity
     * @param 審査会委員Entity 審査会委員Entity
     */
    public GogitaiWariateShinsakaiIinEntity(DbT5107GogitaiWariateIinJohoEntity 合議体割当Entity, DbT5102ShinsakaiIinJohoEntity 審査会委員Entity) {
        this.割当Entity = 合議体割当Entity;
        this.委員Entity = 審査会委員Entity;
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
}
