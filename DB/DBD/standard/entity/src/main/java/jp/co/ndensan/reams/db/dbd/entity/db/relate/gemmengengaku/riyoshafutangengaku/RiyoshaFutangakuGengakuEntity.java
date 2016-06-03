/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.riyoshafutangengaku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengakuEntity;

/**
 * 利用者負担額減額RelateEntityクラスです。
 *
 * @reamsid_L DBD-9999-011 sunhaidi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyoshaFutangakuGengakuEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 利用者負担額減額Entityを返します。
     *
     * @return 利用者負担額減額Entity -- SETTER -- 利用者負担額減額Entityを設定します。
     *
     * @param 利用者負担額減額Entity 利用者負担額減額Entity
     */
    private DbT4014RiyoshaFutangakuGengakuEntity 利用者負担額減額Entity;

    /**
     * -- GETTER -- 減免減額申請EntityListを返します。
     *
     * @return 減免減額申請EntityList -- SETTER -- 減免減額申請EntityListを設定します。
     *
     * @param 減免減額申請EntityList 減免減額申請EntityList
     */
    private List<DbT4010GemmenGengakuShinseiEntity> 減免減額申請Entity;

    /**
     * コンストラクタです。
     */
    public RiyoshaFutangakuGengakuEntity() {
        利用者負担額減額Entity = new DbT4014RiyoshaFutangakuGengakuEntity();
        減免減額申請Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * DbT4014RiyoshaFutangakuGengakuEntityが持つ{@link DbT4010GemmenGengakuShinseiEntity}<br/>
     * のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.利用者負担額減額Entity.initializeMd5();
        for (DbT4010GemmenGengakuShinseiEntity entity : this.減免減額申請Entity) {
            entity.initializeMd5();
        }
    }
}
