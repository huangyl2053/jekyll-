/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaisha.tekiyojogaisha;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;

/**
 * 適用除外者RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class TekiyoJogaishaEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 適用除外者Entityを返します。
     *
     * @return 適用除外者Entity -- SETTER -- 適用除外者Entityを設定します。
     *
     * @param 適用除外者Entity 適用除外者Entity
     */
    private DbT1002TekiyoJogaishaEntity 適用除外者Entity;
    /**
     * -- GETTER -- 介護保険施設入退所EntityListを返します。
     *
     * @return 介護保険施設入退所EntityList -- SETTER -- 介護保険施設入退所EntityListを設定します。
     *
     * @param 介護保険施設入退所EntityList 介護保険施設入退所EntityList
     */
    private List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所Entity;

    /**
     * コンストラクタです。
     */
    public TekiyoJogaishaEntity() {
        適用除外者Entity = new DbT1002TekiyoJogaishaEntity();
        介護保険施設入退所Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * TekiyoJogaishaEntityが持つ{@link DbT1002TekiyoJogaishaEntity}と<br/>
     * {@link DbT1004ShisetsuNyutaishoEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.適用除外者Entity.initializeMd5();
        for (DbT1004ShisetsuNyutaishoEntity entity : this.介護保険施設入退所Entity) {
            entity.initializeMd5();
        }
    }
}
