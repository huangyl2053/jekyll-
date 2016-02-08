/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.syujii.shujiiiryokikanjoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;

/**
 * 主治医医療機関情報RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class ShujiiIryoKikanJohoRelateEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 主治医医療機関情報Entityを返します。
     *
     * @return 主治医医療機関情報Entity -- SETTER -- 主治医医療機関情報Entityを設定します。
     *
     * @param 主治医医療機関情報Entity 主治医医療機関情報Entity
     */
    private DbT5911ShujiiIryoKikanJohoEntity 主治医医療機関情報Entity;

    /**
     * -- GETTER -- 主治医情報EntityListを返します。
     *
     * @return 主治医情報EntityList -- SETTER -- 主治医情報EntityListを設定します。
     *
     * @param 主治医情報EntityList 主治医情報EntityList
     */
    private List<DbT5912ShujiiJohoEntity> 主治医情報Entity;

    /**
     * コンストラクタです。
     */
    public ShujiiIryoKikanJohoRelateEntity() {
        主治医医療機関情報Entity = new DbT5911ShujiiIryoKikanJohoEntity();
        主治医情報Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * ShujiiIryoKikanJohoEntityが持つ{@link 主治医医療機関情報Entity}と{@link DbT5912ShujiiJohoEntity}と<br/>
     * {@link DbT5911ShujiiIryoKikanJohoEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.主治医医療機関情報Entity.initializeMd5();
        for (DbT5912ShujiiJohoEntity entity : this.主治医情報Entity) {
            entity.initializeMd5();
        }
    }
}
