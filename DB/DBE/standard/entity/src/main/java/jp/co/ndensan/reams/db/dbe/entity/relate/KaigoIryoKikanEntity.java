/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.relate;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.ur.urz.entity.IryoKikanEntity;

/**
 * 業務共通の医療機関、講座、介護業務独自の主治医医療機関の情報をまとめたrelateエンティティです。
 *
 * @author n8178 城間篤人
 */
public class KaigoIryoKikanEntity {

    private DbT7011ShujiiIryoKikanJohoEntity shujiiIryoKikanJohoEntity;
    private IryoKikanEntity iryoKikanEntity;

    /**
     * 主治医医療機関情報エンティティを返します。
     *
     * @return 医療機関情報エンティティ
     */
    public DbT7011ShujiiIryoKikanJohoEntity getDbT7011ShujiiIryoKikanJohoEntity() {
        return shujiiIryoKikanJohoEntity;
    }

    /**
     * 主治医医療機関情報エンティティを設定します。
     *
     * @param shujiiIryoKikanJohoEntity 主治医医療機関情報エンティティ
     */
    public void setDbT7011ShujiiIryoKikanJohoEntity(DbT7011ShujiiIryoKikanJohoEntity shujiiIryoKikanJohoEntity) {
        this.shujiiIryoKikanJohoEntity = shujiiIryoKikanJohoEntity;
    }

    /**
     * 医療機関エンティティを返します。
     *
     * @return 医療機関エンティティ
     */
    public IryoKikanEntity getIryoKikanEntity() {
        return iryoKikanEntity;
    }

    /**
     * 医療機関エンティティを設定します。
     *
     * @param iryoKikanEntity 医療機関エンティティ
     */
    public void setIryoKikanEntity(IryoKikanEntity iryoKikanEntity) {
        this.iryoKikanEntity = iryoKikanEntity;
    }
}
