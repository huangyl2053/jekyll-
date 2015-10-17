/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3097TandokuJoseikinKyufuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3098TandokuJoseikinKyufuShinseiEntity;

/**
 * 市町村単独助成金給付申請RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class TandokuJoseikinKyufuShinseiEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 市町村単独助成金給付申請Entityを返します。
     *
     * @return 市町村単独助成金給付申請Entity -- SETTER -- 市町村単独助成金給付申請Entityを設定します。
     *
     * @param 市町村単独助成金給付申請Entity 市町村単独助成金給付申請Entity
     */
    private DbT3098TandokuJoseikinKyufuShinseiEntity 市町村単独助成金給付申請Entity;
    //TODO List型が適切かどうか見直してください
    /**
     * -- GETTER -- 市町村単独助成金給付決定EntityListを返します。
     *
     * @return 市町村単独助成金給付決定EntityList -- SETTER -- 市町村単独助成金給付決定EntityListを設定します。
     *
     * @param 市町村単独助成金給付決定EntityList 市町村単独助成金給付決定EntityList
     */
    private List<DbT3097TandokuJoseikinKyufuKetteiEntity> 市町村単独助成金給付決定Entity;

    /**
     * コンストラクタです。
     */
    public TandokuJoseikinKyufuShinseiEntity() {
        市町村単独助成金給付申請Entity = new DbT3098TandokuJoseikinKyufuShinseiEntity();
        市町村単独助成金給付決定Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * TandokuJoseikinKyufuShinseiEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/>
     * {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.市町村単独助成金給付申請Entity.initializeMd5();
        for (DbT3097TandokuJoseikinKyufuKetteiEntity entity : this.市町村単独助成金給付決定Entity) {
            entity.initializeMd5();
        }
    }
}
