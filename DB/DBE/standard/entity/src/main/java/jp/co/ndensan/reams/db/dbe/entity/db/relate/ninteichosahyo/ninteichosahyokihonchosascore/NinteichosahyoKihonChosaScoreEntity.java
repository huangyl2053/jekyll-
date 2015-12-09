/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosahyokihonchosascore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5204NinteichosahyoKihonChosaScoreEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5212NinteichosahyoKihonChosaScoreItemEntity;

/**
 * 認定調査票（基本調査素点）RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class NinteichosahyoKihonChosaScoreEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 認定調査票（基本調査素点）Entityを返します。
     *
     * @return 認定調査票（基本調査素点）Entity -- SETTER -- 認定調査票（基本調査素点）Entityを設定します。
     *
     * @param 認定調査票（基本調査素点）Entity 認定調査票（基本調査素点）Entity
     */
    private DbT5204NinteichosahyoKihonChosaScoreEntity 認定調査票_基本調査素点Entity;
    /**
     * -- GETTER -- 認定調査票（基本調査素点項目）EntityListを返します。
     *
     * @return 認定調査票（基本調査素点項目）EntityList -- SETTER --
     * 認定調査票（基本調査素点項目）EntityListを設定します。
     *
     * @param 認定調査票（基本調査素点項目）EntityList 認定調査票（基本調査素点項目）EntityList
     */
    private List<DbT5212NinteichosahyoKihonChosaScoreItemEntity> 認定調査票_基本調査素点項目Entity;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoKihonChosaScoreEntity() {
        認定調査票_基本調査素点Entity = new DbT5204NinteichosahyoKihonChosaScoreEntity();
        認定調査票_基本調査素点項目Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * NinteichosahyoKihonChosaScoreEntityが持つ{@link DbT5204NinteichosahyoKihonChosaScoreEntity}と<br/>
     * {@link DbT5212NinteichosahyoKihonChosaScoreItemEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.認定調査票_基本調査素点Entity.initializeMd5();
        for (DbT5212NinteichosahyoKihonChosaScoreItemEntity entity : this.認定調査票_基本調査素点項目Entity) {
            entity.initializeMd5();
        }
    }
}
