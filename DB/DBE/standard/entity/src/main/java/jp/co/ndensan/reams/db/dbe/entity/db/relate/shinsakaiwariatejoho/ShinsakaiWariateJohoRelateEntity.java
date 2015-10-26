/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiwariatejoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5594ShinsakaiIinJohoEntity;

/**
 * 介護認定審査会割当情報RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class ShinsakaiWariateJohoRelateEntity {

    /**
     * -- GETTER -- 介護認定審査会割当情報EntityListを返します。
     *
     * @return 介護認定審査会割当情報Entity -- SETTER -- 介護認定審査会割当情報Entityを設定します。
     *
     * @param 介護認定審査会割当情報Entity 介護認定審査会割当情報Entity
     */
    private DbT5502ShinsakaiWariateJohoEntity 介護認定審査会割当情報Entity;

    /**
     * -- GETTER -- 介護認定審査会委員情報Entityを返します。
     *
     * @return 介護認定審査会委員情報EntityList -- SETTER -- 介護認定審査会委員情報EntityListを設定します。
     *
     * @param 介護認定審査会委員情報EntityList 介護認定審査会委員情報EntityList
     */
    private List<DbT5594ShinsakaiIinJohoEntity> 介護認定審査会委員情報Entity;

    /**
     * コンストラクタです。
     */
    public ShinsakaiWariateJohoRelateEntity() {

        介護認定審査会割当情報Entity = new DbT5502ShinsakaiWariateJohoEntity();

        介護認定審査会委員情報Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * ShinsakaiKaisaiYoteiJohoEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/>
     * {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.介護認定審査会割当情報Entity.initializeMd5();

        for (DbT5594ShinsakaiIinJohoEntity entity : this.介護認定審査会委員情報Entity) {
            entity.initializeMd5();
        }

    }
}
