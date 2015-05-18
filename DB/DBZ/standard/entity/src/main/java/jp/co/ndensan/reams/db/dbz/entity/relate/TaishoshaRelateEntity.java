/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.relate;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbV7901ShikakuSearchEntity;
import jp.co.ndensan.reams.ua.uax.entity.basic.JutonaiYusenEntity;
import jp.co.ndensan.reams.ua.uax.entity.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.relate.IKojinRelateEntity;

/**
 * 対象者のエンティティです。（資格系）
 *
 * @author N8156 宮本 康
 */
public class TaishoshaRelateEntity implements IKojinRelateEntity {

    private JutonaiYusenEntity 住基個人住登内エンティティ;
    private UaFt200FindShikibetsuTaishoEntity 住基個人住登外エンティティ;
    private DbV7901ShikakuSearchEntity 資格検索エンティティ;

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
     * 資格検索エンティティを返します。
     *
     * @return 資格検索エンティティ
     */
    public DbV7901ShikakuSearchEntity get資格検索エンティティ() {
        return 資格検索エンティティ;
    }

    /**
     * 資格検索エンティティを設定します。
     *
     * @param 資格検索エンティティ 資格検索エンティティ
     */
    public void set資格検索エンティティ(DbV7901ShikakuSearchEntity 資格検索エンティティ) {
        this.資格検索エンティティ = 資格検索エンティティ;
    }
}
