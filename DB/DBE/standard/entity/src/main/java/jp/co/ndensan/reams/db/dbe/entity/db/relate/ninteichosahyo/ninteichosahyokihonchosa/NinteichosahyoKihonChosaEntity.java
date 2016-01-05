/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosahyokihonchosa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosahyokihonchosascore.NinteichosahyoKihonChosaScoreEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;

/**
 * 認定調査票（基本調査）RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class NinteichosahyoKihonChosaEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 認定調査票（基本調査）Entityを返します。
     *
     * @return 認定調査票（基本調査）Entity -- SETTER -- 認定調査票（基本調査）Entityを設定します。
     *
     * @param 認定調査票（基本調査）Entity 認定調査票（基本調査）Entity
     */
    private DbT5203NinteichosahyoKihonChosaEntity 認定調査票_基本調査Entity;
    /**
     * -- GETTER -- 認定調査票（基本調査）調査項目EntityListを返します。
     *
     * @return 認定調査票（基本調査）調査項目EntityList -- SETTER --
     * 認定調査票（基本調査）調査項目EntityListを設定します。
     *
     * @param 認定調査票（基本調査）調査項目EntityList 認定調査票（基本調査）調査項目EntityList
     */
    private List<DbT5211NinteichosahyoChosaItemEntity> 認定調査票_基本調査_調査項目Entity;
    /**
     * -- GETTER -- 認定調査票（基本調査素点）EntityListを返します。
     *
     * @return 認定調査票（基本調査素点）EntityList -- SETTER --
     * 認定調査票（基本調査素点）EntityListを設定します。
     *
     * @param 認定調査票（基本調査素点）EntityList 認定調査票（基本調査素点）EntityList
     */
    private List<NinteichosahyoKihonChosaScoreEntity> 認定調査票_基本調査素点Entity;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoKihonChosaEntity() {
        認定調査票_基本調査Entity = new DbT5203NinteichosahyoKihonChosaEntity();
        認定調査票_基本調査_調査項目Entity = new ArrayList<>();
        認定調査票_基本調査素点Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * NinteichosahyoKihonChosaEntityが持つ{@link DbT5203NinteichosahyoKihonChosaEntity}と{@link DbT5211NinteichosahyoChosaItemEntity}と<br/>
     * {@link NinteichosahyoKihonChosaScoreEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.認定調査票_基本調査Entity.initializeMd5();
        for (DbT5211NinteichosahyoChosaItemEntity entity : this.認定調査票_基本調査_調査項目Entity) {
            entity.initializeMd5();
        }
        for (NinteichosahyoKihonChosaScoreEntity entity : this.認定調査票_基本調査素点Entity) {
            entity.initializeMd5ToEntities();
        }
    }
}
