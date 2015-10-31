/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.tyousai.ninteichosaitakusakijoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5913ChosainJohoEntity;

/**
 * 認定調査委託先情報RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class NinteichosaItakusakiJohoRelateEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 認定調査委託先情報Entityを返します。
     *
     * @return 認定調査委託先情報Entity -- SETTER -- 認定調査委託先情報Entityを設定します。
     *
     * @param 認定調査委託先情報Entity 認定調査委託先情報Entity
     */
    private DbT5910NinteichosaItakusakiJohoEntity 認定調査委託先情報Entity;

    /**
     * -- GETTER -- 構成市町村マスタEntityListを返します。
     *
     * @return 構成市町村マスタEntityList -- SETTER -- 構成市町村マスタEntityListを設定します。
     *
     * @param 構成市町村マスタEntityList 構成市町村マスタEntityList
     */
    private List<DbT5051KoseiShichosonMasterEntity> 構成市町村マスタEntity;

    /**
     * -- GETTER -- 調査員情報EntityListを返します。
     *
     * @return 調査員情報EntityList -- SETTER -- 調査員情報EntityListを設定します。
     *
     * @param 調査員情報EntityList 調査員情報EntityList
     */
    private List<DbT5913ChosainJohoEntity> 調査員情報Entity;

    /**
     * コンストラクタです。
     */
    public NinteichosaItakusakiJohoRelateEntity() {
        認定調査委託先情報Entity = new DbT5910NinteichosaItakusakiJohoEntity();
        構成市町村マスタEntity = new ArrayList<>();
        調査員情報Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * NinteichosaItakusakiJohoEntityが持つ{@link DbT5051KoseiShichosonMasterEntity}と{@link DbT5913ChosainJohoEntity}と<br/>
     * {@link DbT5910NinteichosaItakusakiJohoEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.認定調査委託先情報Entity.initializeMd5();
        for (DbT5051KoseiShichosonMasterEntity entity : this.構成市町村マスタEntity) {
            entity.initializeMd5();
        }
        for (DbT5913ChosainJohoEntity entity : this.調査員情報Entity) {
            entity.initializeMd5();
        }
    }
}
