/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.kyokaisogaitosha;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1007KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1013KyokaisoSochiShinseiEntity;

/**
 * 境界層該当者RelateEntityクラスです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
@lombok.Getter
@lombok.Setter
public class KyokaisoGaitoshaEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 境界層該当者Entityを返します。
     *
     * @return 境界層該当者Entity -- SETTER -- 境界層該当者Entityを設定します。
     *
     * @param 境界層該当者Entity 境界層該当者Entity
     */
    private DbT1006KyokaisoGaitoshaEntity 境界層該当者Entity;

    /**
     * -- GETTER -- 境界層保険料段階EntityListを返します。
     *
     * @return 境界層保険料段階EntityList -- SETTER -- 境界層保険料段階EntityListを設定します。
     *
     * @param 境界層保険料段階EntityList 境界層保険料段階EntityList
     */
    private List<DbT1007KyokaisoHokenryoDankaiEntity> 境界層保険料段階Entity;

    /**
     * -- GETTER -- 境界層措置申請Entityを返します。
     *
     * @return 境界層措置申請Entity -- SETTER -- 境界層措置申請Entityを設定します。
     *
     * @param 境界層措置申請Entity 境界層措置申請Entity
     */
    private DbT1013KyokaisoSochiShinseiEntity 境界層措置申請Entity;

    /**
     * コンストラクタです。
     */
    public KyokaisoGaitoshaEntity() {
        境界層該当者Entity = new DbT1006KyokaisoGaitoshaEntity();
        境界層保険料段階Entity = new ArrayList<>();
        境界層措置申請Entity = new DbT1013KyokaisoSochiShinseiEntity();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * KyokaisoGaitoshaEntityが持つ{@link DbT1007KyokaisoHokenryoDankaiEntity}と{@link DbT1013KyokaisoSochiShinseiEntity}と<br/>
     * {@link DbT1006KyokaisoGaitoshaEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.境界層該当者Entity.initializeMd5();
        for (DbT1007KyokaisoHokenryoDankaiEntity entity : this.境界層保険料段階Entity) {
            entity.initializeMd5();
        }
        this.境界層措置申請Entity.initializeMd5();
    }
    private static final long serialVersionUID = -3784576946116778506L;
}
