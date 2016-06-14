/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.business.core.taishoshasearch;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV7901ShikakuSearchEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.TaishoshaRelateEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

 /**
 * FukaTaishoshaRelateEntityを保持するクラスです。
 *
 */
public class TaishoshaRelateBusiness {

    private final TaishoshaRelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity FukaTaishoshaRelateEntity
     */
    public TaishoshaRelateBusiness(TaishoshaRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 住基個人住登外エンティティを返します。
     *
     * @return 住基個人住登外エンティティ
     */
    public UaFt200FindShikibetsuTaishoEntity get住基個人住登外エンティティ() {
        return this.entity.get住基個人住登外エンティティ();
    }

    /**
     * 資格検索エンティティを返します。
     *
     * @return 資格検索エンティティ
     */
    public DbV7901ShikakuSearchEntity get資格検索エンティティ() {
        return this.entity.get資格検索エンティティ();
    }

}
