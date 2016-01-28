/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.chikushichoson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5224ChikuShichosonEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5225ChosaChikuGroupEntity;

/**
 * 地区市町村RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class ChikuShichosonEntity implements Cloneable, Serializable {
    
    private static final long serialVersionUID = 3266209005122297444L;


    /**
     * -- GETTER --
     * 地区市町村Entityを返します。
     *
     * @return 地区市町村Entity
     * -- SETTER --
     * 地区市町村Entityを設定します。
     *
     * @param 地区市町村Entity 地区市町村Entity
     */
    private DbT5224ChikuShichosonEntity 地区市町村Entity;
    /**
     * -- GETTER --
     * 調査地区グループマスタEntityListを返します。
     *
     * @return 調査地区グループマスタEntityList
     * -- SETTER --
     * 調査地区グループマスタEntityListを設定します。
     *
     * @param 調査地区グループマスタEntityList 調査地区グループマスタEntityList
     */
    private List<DbT5225ChosaChikuGroupEntity> 調査地区グループマスタEntity;

    /**
     * コンストラクタです。
     */
    public ChikuShichosonEntity() {
        地区市町村Entity = new DbT5224ChikuShichosonEntity();
        調査地区グループマスタEntity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * ChikuShichosonEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/>
     * {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.地区市町村Entity.initializeMd5();
        for (DbT5225ChosaChikuGroupEntity entity : this.調査地区グループマスタEntity) {
            entity.initializeMd5();
        }
    }
}
