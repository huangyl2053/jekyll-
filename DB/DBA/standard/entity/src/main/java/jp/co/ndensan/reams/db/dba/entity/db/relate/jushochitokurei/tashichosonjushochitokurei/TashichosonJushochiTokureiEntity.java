/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.jushochitokurei.tashichosonjushochitokurei;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;

/**
 * 他市町村住所地特例RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class TashichosonJushochiTokureiEntity implements Cloneable, Serializable {


    /**
     * -- GETTER --
     * 他市町村住所地特例Entityを返します。
     *
     * @return 他市町村住所地特例Entity
     * -- SETTER --
     * 他市町村住所地特例Entityを設定します。
     *
     * @param 他市町村住所地特例Entity 他市町村住所地特例Entity
     */
    private DbT1003TashichosonJushochiTokureiEntity 他市町村住所地特例Entity;
    /**
     * -- GETTER --
     * 介護保険施設入退所EntityListを返します。
     *
     * @return 介護保険施設入退所EntityList
     * -- SETTER --
     * 介護保険施設入退所EntityListを設定します。
     *
     * @param 介護保険施設入退所EntityList 介護保険施設入退所EntityList
     */
    private List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所Entity;

    /**
     * コンストラクタです。
     */
    public TashichosonJushochiTokureiEntity() {
        他市町村住所地特例Entity = new DbT1003TashichosonJushochiTokureiEntity();
        介護保険施設入退所Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * TashichosonJushochiTokureiEntityが持つ{@link DbT1003TashichosonJushochiTokureiEntity}と<br/>
     * {@link DbT1004ShisetsuNyutaishoEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.他市町村住所地特例Entity.initializeMd5();
        for (DbT1004ShisetsuNyutaishoEntity entity : this.介護保険施設入退所Entity) {
            entity.initializeMd5();
        }
    }
}
