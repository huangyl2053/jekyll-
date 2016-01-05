/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choshuyuyo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2007KibetsuChoshuYuyoEntity;

/**
 * 介護賦課徴収猶予RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class ChoshuYuyoEntity implements Cloneable, Serializable {


    /**
     * -- GETTER --
     * 介護賦課徴収猶予Entityを返します。
     *
     * @return 介護賦課徴収猶予Entity
     * -- SETTER --
     * 介護賦課徴収猶予Entityを設定します。
     *
     * @param 介護賦課徴収猶予Entity 介護賦課徴収猶予Entity
     */
    private DbT2006ChoshuYuyoEntity 介護賦課徴収猶予Entity;

    /**
     * -- GETTER --
     * 介護期別徴収猶予EntityListを返します。
     *
     * @return 介護期別徴収猶予EntityList
     * -- SETTER --
     * 介護期別徴収猶予EntityListを設定します。
     *
     * @param 介護期別徴収猶予EntityList 介護期別徴収猶予EntityList
     */
    private List<DbT2007KibetsuChoshuYuyoEntity> 介護期別徴収猶予Entity;

    /**
     * コンストラクタです。
     */
    public ChoshuYuyoEntity() {
        介護賦課徴収猶予Entity = new DbT2006ChoshuYuyoEntity();
        介護期別徴収猶予Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * ChoshuYuyoEntityが持つ{@link DbT2006ChoshuYuyoEntity}と{@link DbT2007KibetsuChoshuYuyoEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.介護賦課徴収猶予Entity.initializeMd5();
        for (DbT2007KibetsuChoshuYuyoEntity entity : this.介護期別徴収猶予Entity) {
            entity.initializeMd5();
        }
    }
}
