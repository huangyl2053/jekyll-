/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigojigyosha.kaigojigyosha;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7063KaigoJigyoshaShiteiServiceEntity;

/**
 * 介護事業者RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class KaigoJigyoshaEntity implements Cloneable, Serializable {

    private static final long serialVersionUID = 60905490633288395L;

    /**
     * -- GETTER -- 介護事業者Entityを返します。
     *
     * @return 介護事業者Entity -- SETTER -- 介護事業者Entityを設定します。
     *
     * @param 介護事業者Entity 介護事業者Entity
     */
    private DbT7060KaigoJigyoshaEntity 介護事業者Entity;

    /**
     * -- GETTER -- 介護事業者代表者EntityListを返します。
     *
     * @return 介護事業者代表者EntityList -- SETTER -- 介護事業者代表者EntityListを設定します。
     *
     * @param 介護事業者代表者EntityList 介護事業者代表者EntityList
     */
    private List<DbT7062KaigoJigyoshaDaihyoshaEntity> 介護事業者代表者Entity;

    /**
     * -- GETTER -- 介護事業者指定サービスEntityListを返します。
     *
     * @return 介護事業者指定サービスEntityList -- SETTER -- 介護事業者指定サービスEntityListを設定します。
     *
     * @param 介護事業者指定サービスEntityList 介護事業者指定サービスEntityList
     */
    private List<DbT7063KaigoJigyoshaShiteiServiceEntity> 介護事業者指定サービスEntity;

    /**
     * コンストラクタです。
     */
    public KaigoJigyoshaEntity() {
        介護事業者Entity = new DbT7060KaigoJigyoshaEntity();
        介護事業者代表者Entity = new ArrayList<>();
        介護事業者指定サービスEntity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * KaigoJigyoshaEntityが持つ{@link DbT7060KaigoJigyoshaEntity}と{@link DbT7062KaigoJigyoshaDaihyoshaEntity}と<br/>
     * {@link DbT7063KaigoJigyoshaShiteiServiceEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.介護事業者Entity.initializeMd5();
        for (DbT7062KaigoJigyoshaDaihyoshaEntity entity : this.介護事業者代表者Entity) {
            entity.initializeMd5();
        }
        for (DbT7063KaigoJigyoshaShiteiServiceEntity entity : this.介護事業者指定サービスEntity) {
            entity.initializeMd5();
        }
    }
}
