/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ikensho.ninteishinseijoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5300GeninShikkanEntity;

/**
 * 要介護認定申請情報RelateEntityクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
@lombok.Getter
@lombok.Setter
public class NinteiShinseiJohoEntity implements Serializable {

    /**
     * -- GETTER -- 要介護認定申請情報Entityを返します。
     *
     * @return 要介護認定申請情報Entity -- SETTER -- 要介護認定申請情報Entityを設定します。
     *
     * @param 要介護認定申請情報Entity 要介護認定申請情報Entity
     */
    private DbT5101NinteiShinseiJohoEntity 要介護認定申請情報Entity;
    /**
     * -- GETTER -- 原因疾患EntityListを返します。
     *
     * @return 原因疾患EntityList -- SETTER -- 原因疾患EntityListを設定します。
     *
     * @param 原因疾患EntityList 原因疾患EntityList
     */
    private List<DbT5300GeninShikkanEntity> 原因疾患Entity;
    /**
     * -- GETTER -- 主治医意見書作成依頼情報EntityListを返します。
     *
     * @return 主治医意見書作成依頼情報EntityList -- SETTER -- 主治医意見書作成依頼情報EntityListを設定します。
     *
     * @param 主治医意見書作成依頼情報EntityList 主治医意見書作成依頼情報EntityList
     */
    private List<ShujiiIkenshoIraiJohoEntity> 主治医意見書作成依頼情報Entity;

    /**
     * コンストラクタです。
     */
    public NinteiShinseiJohoEntity() {
        要介護認定申請情報Entity = new DbT5101NinteiShinseiJohoEntity();
        原因疾患Entity = new ArrayList<>();
        主治医意見書作成依頼情報Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * NinteiShinseiJohoEntityが持つ{@link DbT5300GeninShikkanEntity}と<br/> {@link ShujiiIkenshoIraiJohoEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.要介護認定申請情報Entity.initializeMd5();
        for (DbT5300GeninShikkanEntity entity : this.原因疾患Entity) {
            entity.initializeMd5();
        }
        for (ShujiiIkenshoIraiJohoEntity entity : this.主治医意見書作成依頼情報Entity) {
            entity.initializeMd5ToEntities();
        }
    }
}
