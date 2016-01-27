/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosairaijoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosahyogaikyochosa.NinteichosahyoGaikyoChosaEntity;

/**
 * 認定調査依頼情報RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class NinteichosaIraiJohoEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 認定調査依頼情報Entityを返します。
     *
     * @return 認定調査依頼情報Entity -- SETTER -- 認定調査依頼情報Entityを設定します。
     *
     * @param 認定調査依頼情報Entity 認定調査依頼情報Entity
     */
    private DbT5201NinteichosaIraiJohoEntity 認定調査依頼情報Entity;
    /**
     * -- GETTER -- 認定調査票（概況調査）EntityListを返します。
     *
     * @return 認定調査票（概況調査）EntityList -- SETTER -- 認定調査票（概況調査）EntityListを設定します。
     *
     * @param 認定調査票（概況調査）EntityList 認定調査票（概況調査）EntityList
     */
    private List<NinteichosahyoGaikyoChosaEntity> 認定調査票_概況調査Entity;

    /**
     * コンストラクタです。
     */
    public NinteichosaIraiJohoEntity() {
        認定調査依頼情報Entity = new DbT5201NinteichosaIraiJohoEntity();
        認定調査票_概況調査Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * NinteichosaIraiJohoEntityが持つ{@link DbT5201NinteichosaIraiJohoEntity}と<br/>
     * {@link NinteichosahyoGaikyoChosaEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.認定調査依頼情報Entity.initializeMd5();
        for (NinteichosahyoGaikyoChosaEntity entity : this.認定調査票_概況調査Entity) {
            entity.initializeMd5ToEntities();
        }
    }
}
