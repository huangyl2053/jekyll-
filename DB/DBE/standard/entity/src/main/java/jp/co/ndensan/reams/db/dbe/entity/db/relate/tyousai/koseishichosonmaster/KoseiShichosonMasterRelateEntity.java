/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.tyousai.koseishichosonmaster;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJohoRelateEntity;

/**
 * 構成市町村マスタRelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class KoseiShichosonMasterRelateEntity implements Cloneable, Serializable {

    private static final long serialVersionUID = 8087708415366841076L;

    /**
     * -- GETTER -- 構成市町村マスタEntityを返します。
     *
     * @return 構成市町村マスタEntity -- SETTER -- 構成市町村マスタEntityを設定します。
     *
     * @param 構成市町村マスタEntity 構成市町村マスタEntity
     */
    private DbT5051KoseiShichosonMasterEntity 構成市町村マスタEntity;
    /**
     * -- GETTER -- 認定調査委託先情報EntityListを返します。
     *
     * @return 認定調査委託先情報EntityList -- SETTER -- 認定調査委託先情報EntityListを設定します。
     *
     * @param 認定調査委託先情報EntityList 認定調査委託先情報EntityList
     */
    private List<NinteichosaItakusakiJohoRelateEntity> 認定調査委託先情報Entity;
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
    public KoseiShichosonMasterRelateEntity() {
        構成市町村マスタEntity = new DbT5051KoseiShichosonMasterEntity();
        認定調査委託先情報Entity = new ArrayList<>();
        調査員情報Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * KoseiShichosonMasterRelateEntityが持つ{@link DbT5051KoseiShichosonMasterEntity}と{@link NinteichosaItakusakiJohoEntity}と<br/>
     * {@link DbT5913ChosainJohoEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.構成市町村マスタEntity.initializeMd5();
        for (NinteichosaItakusakiJohoRelateEntity entity : this.認定調査委託先情報Entity) {
            entity.initializeMd5ToEntities();
        }
        for (DbT5913ChosainJohoEntity entity : this.調査員情報Entity) {
            entity.initializeMd5();
        }
    }
}
