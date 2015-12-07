/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ikensho.shujiiIkenshoJoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5303ShujiiIkenshoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;

/**
 * 要介護認定主治医意見書情報RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class ShujiiIkenshoJohoEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 要介護認定主治医意見書情報Entityを返します。
     *
     * @return 要介護認定主治医意見書情報Entity -- SETTER -- 要介護認定主治医意見書情報Entityを設定します。
     *
     * @param 要介護認定主治医意見書情報Entity 要介護認定主治医意見書情報Entity
     */
    private DbT5302ShujiiIkenshoJohoEntity 要介護認定主治医意見書情報Entity;
    /**
     * -- GETTER -- 要介護認定主治医意見書記入項目EntityListを返します。
     *
     * @return 要介護認定主治医意見書記入項目EntityList -- SETTER --
     * 要介護認定主治医意見書記入項目EntityListを設定します。
     *
     * @param 要介護認定主治医意見書記入項目EntityList 要介護認定主治医意見書記入項目EntityList
     */
    private List<DbT5303ShujiiIkenshoKinyuItemEntity> 要介護認定主治医意見書記入項目Entity;
    /**
     * -- GETTER -- 要介護認定主治医意見書意見項目EntityListを返します。
     *
     * @return 要介護認定主治医意見書意見項目EntityList -- SETTER --
     * 要介護認定主治医意見書意見項目EntityListを設定します。
     *
     * @param 要介護認定主治医意見書意見項目EntityList 要介護認定主治医意見書意見項目EntityList
     */
    private List<DbT5304ShujiiIkenshoIkenItemEntity> 要介護認定主治医意見書意見項目Entity;

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoJohoEntity() {
        要介護認定主治医意見書情報Entity = new DbT5302ShujiiIkenshoJohoEntity();
        要介護認定主治医意見書記入項目Entity = new ArrayList<>();
        要介護認定主治医意見書意見項目Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * ShujiiIkenshoJohoEntityが持つ{@link DbT5303ShujiiIkenshoKinyuItemEntity}<br/>
     * {@link DbT5304ShujiiIkenshoIkenItemEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.要介護認定主治医意見書情報Entity.initializeMd5();
        for (DbT5303ShujiiIkenshoKinyuItemEntity entity : this.要介護認定主治医意見書記入項目Entity) {
            entity.initializeMd5();
        }
        for (DbT5304ShujiiIkenshoIkenItemEntity entity : this.要介護認定主治医意見書意見項目Entity) {
            entity.initializeMd5();
        }
    }
}
