/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.chikuninteichosain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.chikushichoson.ChikuShichosonEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosainEntity;

/**
 * 地区認定調査員RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class ChikuNinteiChosainEntity implements Cloneable, Serializable {
    
    private static final long serialVersionUID = 533531674374723338L;


    /**
     * -- GETTER --
     * 地区認定調査員Entityを返します。
     *
     * @return 地区認定調査員Entity
     * -- SETTER --
     * 地区認定調査員Entityを設定します。
     *
     * @param 地区認定調査員Entity 地区認定調査員Entity
     */
    private DbT5223ChikuNinteiChosainEntity 地区認定調査員Entity;
    /**
     * -- GETTER --
     * 地区市町村EntityListを返します。
     *
     * @return 地区市町村EntityList
     * -- SETTER --
     * 地区市町村EntityListを設定します。
     *
     * @param 地区市町村EntityList 地区市町村EntityList
     */
    private List<ChikuShichosonEntity> 地区市町村Entity;

    /**
     * コンストラクタです。
     */
    public ChikuNinteiChosainEntity() {
        地区認定調査員Entity = new DbT5223ChikuNinteiChosainEntity();
        地区市町村Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * ChikuNinteiChosainEntityが持つ{@link DbT5223ChikuNinteiChosainEntity}と
     * {@link ChikuShichosonEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.地区認定調査員Entity.initializeMd5();
        for (ChikuShichosonEntity entity : this.地区市町村Entity) {
            entity.initializeMd5ToEntities();
        }
    }
}
