/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;

/**
 * 合併情報RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class GappeiJohoRelateEntity implements Cloneable, Serializable {

    private static final long serialVersionUID = 3237029436447733283L;

    /**
     * -- GETTER -- 合併情報Entityを返します。
     *
     * @return 合併情報Entity -- SETTER -- 合併情報Entityを設定します。
     *
     * @param 合併情報Entity 合併情報Entity
     */
    private DbT7055GappeiJohoEntity 合併情報Entity;

    /**
     * -- GETTER -- 合併市町村EntityListを返します。
     *
     * @return 合併市町村EntityList -- SETTER -- 合併市町村EntityListを設定します。
     *
     * @param 合併市町村EntityList 合併市町村EntityList
     */
    private List<DbT7056GappeiShichosonEntity> 合併市町村Entity;

    /**
     * コンストラクタです。
     */
    public GappeiJohoRelateEntity() {
        合併情報Entity = new DbT7055GappeiJohoEntity();
        合併市町村Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * GappeiJohoEntityが持つ{@link DbT7055GappeiJohoEntity}と<br/> {@link DbT7056GappeiShichosonEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.合併情報Entity.initializeMd5();
        for (DbT7056GappeiShichosonEntity entity : this.合併市町村Entity) {
            entity.initializeMd5();
        }
    }
}
