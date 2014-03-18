/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJohoEntity;

/**
 * 認定進捗、認定申請、認定調査依頼、介護認定調査員の情報をまとめた認定調査結果取込対象者のエンティティクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteichosaKekkaTorikomiTaishoshaEntity {

    private DbT5001NinteiShinseiJohoEntity ninteiShinseiJohoEntity;
    private DbT5006NinteichosaIraiJohoEntity ninteichosaIraiJohoEntity;
    private List<KaigoNinteichosainEntity> ninteichosainEntityList;

    /**
     * 認定申請情報エンティティを取得します。
     *
     * @return ninteiShinseiJohoEntity 認定申請情報エンティティ
     */
    public DbT5001NinteiShinseiJohoEntity getNinteiShinseiJohoEntity() {
        return ninteiShinseiJohoEntity;
    }

    /**
     * 認定進捗情報エンティティを設定します。
     *
     * @param ninteiShinseiJohoEntity 認定申請情報エンティティ
     */
    public void setNinteiShinseiJohoEntity(DbT5001NinteiShinseiJohoEntity ninteiShinseiJohoEntity) {
        this.ninteiShinseiJohoEntity = ninteiShinseiJohoEntity;
    }

    /**
     * 認定調査依頼情報エンティティを取得します。
     *
     * @return ninteichosaIraiJohoEntity 認定調査依頼情報エンティティ
     */
    public DbT5006NinteichosaIraiJohoEntity getNinteichosaIraiJohoEntity() {
        return ninteichosaIraiJohoEntity;
    }

    /**
     * 認定調査依頼情報エンティティを設定します。
     *
     * @param ninteichosaIraiJohoEntity 認定調査依頼情報エンティティ
     */
    public void setNinteichosaIraiJohoEntity(DbT5006NinteichosaIraiJohoEntity ninteichosaIraiJohoEntity) {
        this.ninteichosaIraiJohoEntity = ninteichosaIraiJohoEntity;
    }

    /**
     * 認定調査員エンティティのリストを取得します。
     *
     * @return ninteichosainEntityList 認定調査員エンティティのリスト
     */
    public List<KaigoNinteichosainEntity> getNinteichosainEntityList() {
        return ninteichosainEntityList;
    }

    /**
     * 認定調査員エンティティのリストを設定します。
     *
     * @param ninteichosainEntityList 認定調査員エンティティのリスト
     */
    public void setNinteichosainEntityList(List<KaigoNinteichosainEntity> ninteichosainEntityList) {
        this.ninteichosainEntityList = ninteichosainEntityList;
    }
}
