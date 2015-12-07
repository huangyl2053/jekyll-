/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ikensho.shujiiIkenshoIraiJoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikensho.shujiiIkenshoJoho.ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;

/**
 * 主治医意見書作成依頼情報RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class ShujiiIkenshoIraiJohoEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 主治医意見書作成依頼情報Entityを返します。
     *
     * @return 主治医意見書作成依頼情報Entity -- SETTER -- 主治医意見書作成依頼情報Entityを設定します。
     *
     * @param 主治医意見書作成依頼情報Entity 主治医意見書作成依頼情報Entity
     */
    private DbT5301ShujiiIkenshoIraiJohoEntity 主治医意見書作成依頼情報Entity;
    /**
     * -- GETTER -- 要介護認定主治医意見書情報EntityListを返します。
     *
     * @return 要介護認定主治医意見書情報EntityList -- SETTER --
     * 要介護認定主治医意見書情報EntityListを設定します。
     *
     * @param 要介護認定主治医意見書情報EntityList 要介護認定主治医意見書情報EntityList
     */
    private List<ShujiiIkenshoJohoEntity> 要介護認定主治医意見書情報Entity;

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoIraiJohoEntity() {
        主治医意見書作成依頼情報Entity = new DbT5301ShujiiIkenshoIraiJohoEntity();
        要介護認定主治医意見書情報Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * ShujiiIkenshoIraiJohoEntityが持つ<br/>
     * {@link ShujiiIkenshoJohoEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.主治医意見書作成依頼情報Entity.initializeMd5();
        for (ShujiiIkenshoJohoEntity entity : this.要介護認定主治医意見書情報Entity) {
            entity.initializeMd5ToEntities();
        }
    }
}
