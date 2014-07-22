/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.relate;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5014ShinsakaiIinJogaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5102ShinsakaiIinJohoEntity;

/**
 * 除外対象となる審査会委員の情報を持つクラスです。
 *
 * @author n8178 城間篤人
 */
public class JogaiShinsakaiIinEntity {

    private DbT5102ShinsakaiIinJohoEntity 審査会委員Entity;
    private DbT5014ShinsakaiIinJogaiJohoEntity 除外委員情報Entity;

    /**
     * デフォルトコンストラクタです。
     */
    public JogaiShinsakaiIinEntity() {
    }

    /**
     * 引数から値を受け取るコンストラクタです。
     *
     * @param 審査会委員Entity 審査会委員Entity
     * @param 除外委員情報Entity 除外委員情報Entity
     */
    public JogaiShinsakaiIinEntity(DbT5102ShinsakaiIinJohoEntity 審査会委員Entity, DbT5014ShinsakaiIinJogaiJohoEntity 除外委員情報Entity) {
        this.審査会委員Entity = 審査会委員Entity;
        this.除外委員情報Entity = 除外委員情報Entity;
    }

    /**
     * 審査会審査会委員Entityを返します。
     *
     * @return 審査会審査会委員Entity
     */
    public DbT5102ShinsakaiIinJohoEntity get審査会委員Entity() {
        return 審査会委員Entity;
    }

    /**
     * 除外委員情報Entityを取得します。
     *
     * @return 除外委員情報Entity
     */
    public DbT5014ShinsakaiIinJogaiJohoEntity get除外委員情報Entity() {
        return 除外委員情報Entity;
    }

    /**
     * 引数から審査会委員Entityを設定します。
     *
     * @param 審査会委員Entity 審査会委員Entity
     */
    public void set審査会委員Entity(DbT5102ShinsakaiIinJohoEntity 審査会委員Entity) {
        this.審査会委員Entity = 審査会委員Entity;
    }

    /**
     * 引数から除外委員情報Entityを設定します。
     *
     * @param 除外委員情報Entity 除外委員情報Entity
     */
    public void set除外委員情報Entity(DbT5014ShinsakaiIinJogaiJohoEntity 除外委員情報Entity) {
        this.除外委員情報Entity = 除外委員情報Entity;
    }

}
