/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.kensaku.DbV7902FukaSearchEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 対象者のエンティティです。（賦課系）
 *
 * @author N8156 宮本 康
 */
public class FukaTaishoshaRelateEntity {

    private UaFt200FindShikibetsuTaishoEntity 住基個人住登外エンティティ;
    private DbV7902FukaSearchEntity 賦課検索エンティティ;

    /**
     * 住基個人住登外エンティティを返します。
     *
     * @return 住基個人住登外エンティティ
     */
    public UaFt200FindShikibetsuTaishoEntity get住基個人住登外エンティティ() {
        return 住基個人住登外エンティティ;
    }

    /**
     * 住基個人住登外エンティティを設定します。
     *
     * @param 住基個人住登外エンティティ 住基個人住登外エンティティ
     */
    public void set住基個人住登外エンティティ(UaFt200FindShikibetsuTaishoEntity 住基個人住登外エンティティ) {
        this.住基個人住登外エンティティ = 住基個人住登外エンティティ;
    }

    /**
     * 賦課検索エンティティを返します。
     *
     * @return 賦課検索エンティティ
     */
    public DbV7902FukaSearchEntity get賦課検索エンティティ() {
        return 賦課検索エンティティ;
    }

    /**
     * 賦課検索エンティティを設定します。
     *
     * @param 賦課検索エンティティ 賦課検索エンティティ
     */
    public void set賦課検索エンティティ(DbV7902FukaSearchEntity 賦課検索エンティティ) {
        this.賦課検索エンティティ = 賦課検索エンティティ;
    }
}
