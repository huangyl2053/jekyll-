/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiiryokikanjoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5912ShujiiJohoEntity;

/**
 * 構成市町村マスタRelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class ShujiiIryoKikanJohoRelateEntity implements Cloneable, Serializable {

    private static final long serialVersionUID = -2612585073907782723L;

    /**
     * -- GETTER -- 主治医医療機関情報EntityListを返します。
     *
     * @return 主治医医療機関情報EntityList -- SETTER -- 主治医医療機関情報EntityListを設定します。
     *
     * @param 主治医医療機関情報EntityList 主治医医療機関情報EntityList
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

    public void initializeMd5ToEntities() {

        this.主治医医療機関情報Entity.initializeMd5();
        for (DbT5912ShujiiJohoEntity entity : this.主治医情報Entity) {
            entity.initializeMd5();
        }
    }
}
