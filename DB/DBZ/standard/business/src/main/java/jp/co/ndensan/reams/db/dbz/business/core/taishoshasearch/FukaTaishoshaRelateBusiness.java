/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.business.core.taishoshasearch;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV7902FukaSearchEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.FukaTaishoshaRelateEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

 /**
 * FukaTaishoshaRelateEntityを保持するクラスです。
 *
 */
public class FukaTaishoshaRelateBusiness {

    private final FukaTaishoshaRelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity FukaTaishoshaRelateEntity
     */
    public FukaTaishoshaRelateBusiness(FukaTaishoshaRelateEntity entity) {
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
     * 賦課検索エンティティを返します。
     *
     * @return 賦課検索エンティティ
     */
    public DbV7902FukaSearchEntity get賦課検索エンティティ() {
        return this.entity.get賦課検索エンティティ();
    }

}
