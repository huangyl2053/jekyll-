/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.relate;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5013ShujiiIkenshoShosaiJohoEntity;

/**
 * 一次判定の計算に必要な、認定調査票と主治医意見書詳細の情報を持つエンティティです。
 *
 * @author n8178 城間篤人
 */
public class NinteichosahyoAndShujiiIkenshoShosaiEntity {

    private DbT5009NinteichosahyoJohoEntity 認定調査票Entity;
    private DbT5013ShujiiIkenshoShosaiJohoEntity 主治医意見書Entity;

    /**
     * 認定調査票Entityを返します。
     *
     * @return 認定調査票Entity
     */
    public DbT5009NinteichosahyoJohoEntity get認定調査票Entity() {
        return 認定調査票Entity;
    }

    /**
     * 引数から認定調査票Entityを設定します。
     *
     * @param 認定調査票Entity 認定調査票Entity
     */
    public void set認定調査票Entity(DbT5009NinteichosahyoJohoEntity 認定調査票Entity) {
        this.認定調査票Entity = 認定調査票Entity;
    }

    /**
     * 主治医意見書Entityを取得します。
     *
     * @return 主治医意見書Entity
     */
    public DbT5013ShujiiIkenshoShosaiJohoEntity get主治医意見書Entity() {
        return 主治医意見書Entity;
    }

    /**
     * 引数から主治医意見書Entityを設定します。
     *
     * @param 主治医意見書Entity 主治医意見書Entity
     */
    public void set主治医意見書Entity(DbT5013ShujiiIkenshoShosaiJohoEntity 主治医意見書Entity) {
        this.主治医意見書Entity = 主治医意見書Entity;
    }
}
