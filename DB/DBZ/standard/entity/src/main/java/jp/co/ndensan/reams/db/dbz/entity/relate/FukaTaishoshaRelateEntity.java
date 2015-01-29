/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.relate;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbV7902FukaSearchEntity;
import jp.co.ndensan.reams.ur.urz.entity.basic.JutogaiYusenEntity;
import jp.co.ndensan.reams.ur.urz.entity.basic.JutonaiYusenEntity;
import jp.co.ndensan.reams.ur.urz.entity.relate.IKojinRelateEntity;

/**
 * 対象者のエンティティです。（賦課系）
 *
 * @author N8156 宮本 康
 */
public class FukaTaishoshaRelateEntity implements IKojinRelateEntity {

    private JutonaiYusenEntity 住基個人住登内エンティティ;
    private JutogaiYusenEntity 住基個人住登外エンティティ;
    private DbV7902FukaSearchEntity 賦課検索エンティティ;

    /**
     * 住基個人住登内エンティティを返します。
     *
     * @return 住基個人住登内エンティティ
     */
    @Override
    public JutonaiYusenEntity get住基個人住登内エンティティ() {
        return 住基個人住登内エンティティ;
    }

    /**
     * 住基個人住登内エンティティを設定します。
     *
     * @param 住基個人住登内エンティティ 住基個人住登内エンティティ
     */
    public void set住基個人住登内エンティティ(JutonaiYusenEntity 住基個人住登内エンティティ) {
        this.住基個人住登内エンティティ = 住基個人住登内エンティティ;
    }

    /**
     * 住基個人住登外エンティティを返します。
     *
     * @return 住基個人住登外エンティティ
     */
    @Override
    public JutogaiYusenEntity get住基個人住登外エンティティ() {
        return 住基個人住登外エンティティ;
    }

    /**
     * 住基個人住登外エンティティを設定します。
     *
     * @param 住基個人住登外エンティティ 住基個人住登外エンティティ
     */
    public void set住基個人住登外エンティティ(JutogaiYusenEntity 住基個人住登外エンティティ) {
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
