/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiwariateiinjoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5503ShinsakaiWariateIinJohoEntity;

/**
 * 介護認定審査会割当情報RelateEntityクラスです。
 */
public class ShinsakaiWariateIinJohoRelateEntity {

    /**
     * -- GETTER -- 介護認定審査会割当委員情報EntityListを返します。
     *
     * @return 介護認定審査会割当委員情報EntityList -- SETTER -- 介護認定審査会割当委員情報EntityListを設定します。
     *
     * @param 介護認定審査会割当委員情報EntityList 介護認定審査会割当委員情報EntityList
     */
    private DbT5503ShinsakaiWariateIinJohoEntity 介護認定審査会割当委員情報Entity;

    /**
     * -- GETTER -- 要介護認定申請情報EntityListを返します。
     *
     * @return 要介護認定申請情報EntityList -- SETTER -- 要介護認定申請情報EntityListを設定します。
     *
     * @param 要介護認定申請情報EntityList 要介護認定申請情報EntityList
     */
    private List<DbT5101NinteiShinseiJohoEntity> 要介護認定申請情報Entity;

    public ShinsakaiWariateIinJohoRelateEntity() {

        介護認定審査会割当委員情報Entity = new DbT5503ShinsakaiWariateIinJohoEntity();

        要介護認定申請情報Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * ShinsakaiKaisaiYoteiJohoEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/>
     * {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.get介護認定審査会割当委員情報Entity().initializeMd5();

        for (DbT5101NinteiShinseiJohoEntity entity : this.get要介護認定申請情報Entity()) {
            entity.initializeMd5();
        }

    }

    /**
     * 介護認定審査会割当委員情報Entityを取得します。
     * @return 介護認定審査会割当委員情報Entity
     */
    public DbT5503ShinsakaiWariateIinJohoEntity get介護認定審査会割当委員情報Entity() {
        return 介護認定審査会割当委員情報Entity;
    }

    /**
     * 介護認定審査会割当委員情報Entityを設定します。
     * @param 介護認定審査会割当委員情報Entity 
     */
    public void set介護認定審査会割当委員情報Entity(DbT5503ShinsakaiWariateIinJohoEntity 介護認定審査会割当委員情報Entity) {
        this.介護認定審査会割当委員情報Entity = 介護認定審査会割当委員情報Entity;
    }

     /**
     * 要介護認定申請情報Entityを取得します。
     * @return 要介護認定申請情報Entity
     */
    public List<DbT5101NinteiShinseiJohoEntity> get要介護認定申請情報Entity() {
        return 要介護認定申請情報Entity;
    }

     /**
     * 要介護認定申請情報Entityを設定します。
     * @param 要介護認定申請情報Entity
     */
    public void set要介護認定申請情報Entity(List<DbT5101NinteiShinseiJohoEntity> 要介護認定申請情報Entity) {
        this.要介護認定申請情報Entity = 要介護認定申請情報Entity;
    }

}
