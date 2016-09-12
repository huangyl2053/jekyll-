/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.shogaishakoujo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4038ShogaishaKoujoEntity;

/**
 * 障がい書控除RelateEntityクラスです。
 *
 * @reamsid_L DBD-3840-010 wangjie2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShogaishaKoujoEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 障がい書控除Entityを返します。
     *
     * @return 障がい書控除Entity -- SETTER -- 障がい書控除Entityを設定します。
     *
     * @param 障がい書控除Entity 障がい書控除Entity
     */
    private DbT4038ShogaishaKoujoEntity 障がい書控除Entity;
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
    public ShogaishaKoujoEntity() {
        障がい書控除Entity = new DbT4038ShogaishaKoujoEntity();
        減免減額申請Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * ShogaishaKoujoEntityが持つ{@link DbT4038ShogaishaKoujoEntity}と<br/> {@link DbT4010GemmenGengakuShinseiEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.障がい書控除Entity.initializeMd5();
        for (DbT4010GemmenGengakuShinseiEntity entity : this.減免減額申請Entity) {
            entity.initializeMd5();
        }
    }

}
