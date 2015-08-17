/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.relate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7002BemmeiNaiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7003BemmeishaJohoEntity;

/**
 * 弁明内容RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class BemmeiNaiyoEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 弁明内容Entityを返します。
     *
     * @return 弁明内容Entity -- SETTER -- 弁明内容Entityを設定します。
     *
     * @param 弁明内容Entity 弁明内容Entity
     */
    private DbT7002BemmeiNaiyoEntity 弁明内容Entity;
    //TODO List型が適切かどうか見直してください
    /**
     * -- GETTER -- 弁明者情報EntityListを返します。
     *
     * @return 弁明者情報EntityList -- SETTER -- 弁明者情報EntityListを設定します。
     *
     * @param 弁明者情報EntityList 弁明者情報EntityList
     */
    private List<DbT7003BemmeishaJohoEntity> 弁明者情報Entity;

    /**
     * コンストラクタです。
     */
    public BemmeiNaiyoEntity() {
        弁明内容Entity = new DbT7002BemmeiNaiyoEntity();
        弁明者情報Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * BemmeiNaiyoEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/>
     * {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.弁明内容Entity.initializeMd5();
        for (DbT7003BemmeishaJohoEntity entity : this.弁明者情報Entity) {
            entity.initializeMd5();
        }
    }
}
