/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5591GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5592ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaiwariateiinjoho.GogitaiWariateIinJohoRelateEntity;

/**
 * 合議体情報RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class GogitaiJohoRelateEntity implements Cloneable, Serializable {

    private static final long serialVersionUID = -591710391188486675L;

    /**
     * -- GETTER -- 合議体情報Entityを返します。
     *
     * @return 合議体情報Entity -- SETTER -- 合議体情報Entityを設定します。
     *
     * @param 合議体情報Entity 合議体情報Entity
     */
    private DbT5591GogitaiJohoEntity 合議体情報Entity;
    /**
     * -- GETTER -- 介護認定審査会開催場所情報EntityListを返します。
     *
     * @return 介護認定審査会開催場所情報EntityList -- SETTER -- 介護認定審査会開催場所情報EntityListを設定します。
     *
     * @param 介護認定審査会開催場所情報EntityList 介護認定審査会開催場所情報EntityList
     */
    private List<DbT5592ShinsakaiKaisaiBashoJohoEntity> 介護認定審査会開催場所情報Entity;

    /**
     * -- GETTER -- 合議体割当委員情報EntityListを返します。
     *
     * @return 合議体割当委員情報EntityList -- SETTER -- 合議体割当委員情報EntityListを設定します。
     *
     * @param 合議体割当委員情報EntityList 合議体割当委員情報EntityList
     */
    private List<GogitaiWariateIinJohoRelateEntity> 合議体割当委員情報RelateEntity;

    /**
     * コンストラクタです。
     */
    public GogitaiJohoRelateEntity() {
        合議体情報Entity = new DbT5591GogitaiJohoEntity();
        介護認定審査会開催場所情報Entity = new ArrayList<>();
        合議体割当委員情報RelateEntity = new ArrayList<>();

    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * GogitaiJohoEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/> {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.合議体情報Entity.initializeMd5();
        for (DbT5592ShinsakaiKaisaiBashoJohoEntity entity : this.介護認定審査会開催場所情報Entity) {
            entity.initializeMd5();
        }
        for (GogitaiWariateIinJohoRelateEntity wariateRelateEntity : this.合議体割当委員情報RelateEntity) {
            wariateRelateEntity.initializeMd5ToEntities();
        }
    }
}
