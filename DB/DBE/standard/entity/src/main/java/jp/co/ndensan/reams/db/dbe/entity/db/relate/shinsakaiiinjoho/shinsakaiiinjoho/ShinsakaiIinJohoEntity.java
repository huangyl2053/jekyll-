/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinjoho.shinsakaiiinjoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5594ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity;

/**
 * 介護認定審査会委員情報RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class ShinsakaiIinJohoEntity implements Cloneable, Serializable {

    private static final long serialVersionUID = -5586836242413746270L;

    /**
     * -- GETTER -- 介護認定審査会委員情報Entityを返します。
     *
     * @return 介護認定審査会委員情報Entity -- SETTER -- 介護認定審査会委員情報Entityを設定します。
     *
     * @param 介護認定審査会委員情報Entity 介護認定審査会委員情報Entity
     */
    private DbT5594ShinsakaiIinJohoEntity 介護認定審査会委員情報Entity;

    /**
     * -- GETTER -- 介護認定審査会委員所属機関情報EntityListを返します。
     *
     * @return 介護認定審査会委員所属機関情報EntityList -- SETTER -- 介護認定審査会委員所属機関情報EntityListを設定します。
     *
     * @param 介護認定審査会委員所属機関情報EntityList 介護認定審査会委員所属機関情報EntityList
     */
    private List<DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity> 介護認定審査会委員所属機関情報Entity;

    /**
     * コンストラクタです。
     */
    public ShinsakaiIinJohoEntity() {
        介護認定審査会委員情報Entity = new DbT5594ShinsakaiIinJohoEntity();
        介護認定審査会委員所属機関情報Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * ShinsakaiIinJohoEntityが持つ{@link DbT5594ShinsakaiIinJohoEntity}と<br/>
     * {@link DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.介護認定審査会委員情報Entity.initializeMd5();
        for (DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity entity : this.介護認定審査会委員所属機関情報Entity) {
            entity.initializeMd5();
        }
    }
}
