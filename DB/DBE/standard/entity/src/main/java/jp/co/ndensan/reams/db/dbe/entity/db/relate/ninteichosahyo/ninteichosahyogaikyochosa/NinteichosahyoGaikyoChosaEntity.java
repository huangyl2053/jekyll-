/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosahyogaikyochosa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosahyokihonchosa.NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5206GaikyoTokkiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;

/**
 * 認定調査票（概況調査）RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class NinteichosahyoGaikyoChosaEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 認定調査票（概況調査）Entityを返します。
     *
     * @return 認定調査票（概況調査）Entity -- SETTER -- 認定調査票（概況調査）Entityを設定します。
     *
     * @param 認定調査票（概況調査）Entity 認定調査票（概況調査）Entity
     */
    private DbT5202NinteichosahyoGaikyoChosaEntity 認定調査票_概況調査Entity;
    /**
     * -- GETTER -- 認定調査票（概況特記）EntityListを返します。
     *
     * @return 認定調査票（概況特記）EntityList -- SETTER -- 認定調査票（概況特記）EntityListを設定します。
     *
     * @param 認定調査票（概況特記）EntityList 認定調査票（概況特記）EntityList
     */
    private List<DbT5206GaikyoTokkiEntity> 認定調査票_概況特記Entity;
    /**
     * -- GETTER -- 認定調査票（特記情報）EntityListを返します。
     *
     * @return 認定調査票（特記情報）EntityList -- SETTER -- 認定調査票（特記情報）EntityListを設定します。
     *
     * @param 認定調査票（特記情報）EntityList 認定調査票（特記情報）EntityList
     */
    private List<DbT5205NinteichosahyoTokkijikoEntity> 認定調査票_特記情報Entity;
    /**
     * -- GETTER -- 認定調査票（概況調査）サービスの状況EntityListを返します。
     *
     * @return 認定調査票（概況調査）サービスの状況EntityList -- SETTER --
     * 認定調査票（概況調査）サービスの状況EntityListを設定します。
     *
     * @param 認定調査票（概況調査）サービスの状況EntityList 認定調査票（概況調査）サービスの状況EntityList
     */
    private List<DbT5207NinteichosahyoServiceJokyoEntity> 認定調査票_概況調査_サービスの状況Entity;
    /**
     * -- GETTER -- 認定調査票（概況調査）サービスの状況フラグEntityListを返します。
     *
     * @return 認定調査票（概況調査）サービスの状況フラグEntityList -- SETTER --
     * 認定調査票（概況調査）サービスの状況フラグEntityListを設定します。
     *
     * @param 認定調査票（概況調査）サービスの状況フラグEntityList 認定調査票（概況調査）サービスの状況フラグEntityList
     */
    private List<DbT5208NinteichosahyoServiceJokyoFlagEntity> 認定調査票_概況調査_サービスの状況フラグEntity;
    /**
     * -- GETTER -- 認定調査票（概況調査）記入項目EntityListを返します。
     *
     * @return 認定調査票（概況調査）記入項目EntityList -- SETTER --
     * 認定調査票（概況調査）記入項目EntityListを設定します。
     *
     * @param 認定調査票（概況調査）記入項目EntityList 認定調査票（概況調査）記入項目EntityList
     */
    private List<DbT5209NinteichosahyoKinyuItemEntity> 認定調査票_概況調査_記入項目Entity;
    /**
     * -- GETTER -- 認定調査票（概況調査）施設利用EntityListを返します。
     *
     * @return 認定調査票（概況調査）施設利用EntityList -- SETTER --
     * 認定調査票（概況調査）施設利用EntityListを設定します。
     *
     * @param 認定調査票（概況調査）施設利用EntityList 認定調査票（概況調査）施設利用EntityList
     */
    private List<DbT5210NinteichosahyoShisetsuRiyoEntity> 認定調査票_概況調査_施設利用Entity;
    /**
     * -- GETTER -- 認定調査票（基本調査）EntityListを返します。
     *
     * @return 認定調査票（基本調査）EntityList -- SETTER -- 認定調査票（基本調査）EntityListを設定します。
     *
     * @param 認定調査票（基本調査）EntityList 認定調査票（基本調査）EntityList
     */
    private List<NinteichosahyoKihonChosaEntity> 認定調査票_基本調査Entity;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoGaikyoChosaEntity() {
        認定調査票_概況調査Entity = new DbT5202NinteichosahyoGaikyoChosaEntity();
        認定調査票_概況特記Entity = new ArrayList<>();
        認定調査票_特記情報Entity = new ArrayList<>();
        認定調査票_概況調査_サービスの状況Entity = new ArrayList<>();
        認定調査票_概況調査_サービスの状況フラグEntity = new ArrayList<>();
        認定調査票_概況調査_記入項目Entity = new ArrayList<>();
        認定調査票_概況調査_施設利用Entity = new ArrayList<>();
        認定調査票_基本調査Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * NinteichosahyoGaikyoChosaEntityが持つ{@link DbT5206GaikyoTokkiEntity}と{@link DbT5205NinteichosahyoTokkijikoEntity}と<br/>
     * {@link DbT5202NinteichosahyoGaikyoChosaEntity}と{@link DbT5207NinteichosahyoServiceJokyoEntity}と{@link DbT5208NinteichosahyoServiceJokyoFlagEntity}と
     * {@link DbT5209NinteichosahyoKinyuItemEntity}と{@link DbT5210NinteichosahyoShisetsuRiyoEntity}と
     * {@link NinteichosahyoKihonChosaEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.認定調査票_概況調査Entity.initializeMd5();
        for (DbT5206GaikyoTokkiEntity entity : this.認定調査票_概況特記Entity) {
            entity.initializeMd5();
        }
        for (DbT5205NinteichosahyoTokkijikoEntity entity : this.認定調査票_特記情報Entity) {
            entity.initializeMd5();
        }
        for (DbT5207NinteichosahyoServiceJokyoEntity entity : this.認定調査票_概況調査_サービスの状況Entity) {
            entity.initializeMd5();
        }
        for (DbT5208NinteichosahyoServiceJokyoFlagEntity entity : this.認定調査票_概況調査_サービスの状況フラグEntity) {
            entity.initializeMd5();
        }
        for (DbT5209NinteichosahyoKinyuItemEntity entity : this.認定調査票_概況調査_記入項目Entity) {
            entity.initializeMd5();
        }
        for (DbT5210NinteichosahyoShisetsuRiyoEntity entity : this.認定調査票_概況調査_施設利用Entity) {
            entity.initializeMd5();
        }
        for (NinteichosahyoKihonChosaEntity entity : this.認定調査票_基本調査Entity) {
            entity.initializeMd5ToEntities();
        }
    }
}
