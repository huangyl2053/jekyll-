/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.futangendogakunintei;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiEntity;

/**
 * 負担限度額認定RelateEntityクラスです。
 *
 * @reamsid_L DBD-9999-011 sunhaidi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanGendogakuNinteiEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 介護保険負担限度額認定Entityを返します。
     *
     * @return 介護保険負担限度額認定Entity -- SETTER -- 介護保険負担限度額認定Entityを設定します。
     *
     * @param 介護保険負担限度額認定Entity 介護保険負担限度額認定Entity
     */
    private DbT4018KaigoHokenFutanGendogakuNinteiEntity 介護保険負担限度額認定Entity;
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
    public FutanGendogakuNinteiEntity() {
        介護保険負担限度額認定Entity = new DbT4018KaigoHokenFutanGendogakuNinteiEntity();
        減免減額申請Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * FutanGendogakuNinteiEntityが持つ{@link DbT4018KaigoHokenFutanGendogakuNinteiEntity}と<br/>
     * {@link DbT4010GemmenGengakuShinseiEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.介護保険負担限度額認定Entity.initializeMd5();
        for (DbT4010GemmenGengakuShinseiEntity entity : this.減免減額申請Entity) {
            entity.initializeMd5();
        }
    }
}
