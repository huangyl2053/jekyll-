/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.relate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3100NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3101NijiYoboKihonCheckListEntity;

/**
 * 二次予防事業対象者RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class NijiYoboJigyoTaishoshaEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 二次予防事業対象者Entityを返します。
     *
     * @return 二次予防事業対象者Entity -- SETTER -- 二次予防事業対象者Entityを設定します。
     *
     * @param 二次予防事業対象者Entity 二次予防事業対象者Entity
     */
    private DbT3100NijiYoboJigyoTaishoshaEntity 二次予防事業対象者Entity;
    //TODO List型が適切かどうか見直してください
    /**
     * -- GETTER -- 二次予防基本チェックリストEntityListを返します。
     *
     * @return 二次予防基本チェックリストEntityList -- SETTER --
     * 二次予防基本チェックリストEntityListを設定します。
     *
     * @param 二次予防基本チェックリストEntityList 二次予防基本チェックリストEntityList
     */
    private List<DbT3101NijiYoboKihonCheckListEntity> 二次予防基本チェックリストEntity;

    /**
     * コンストラクタです。
     */
    public NijiYoboJigyoTaishoshaEntity() {
        二次予防事業対象者Entity = new DbT3100NijiYoboJigyoTaishoshaEntity();
        二次予防基本チェックリストEntity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * NijiYoboJigyoTaishoshaEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/>
     * {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.二次予防事業対象者Entity.initializeMd5();
        for (DbT3101NijiYoboKihonCheckListEntity entity : this.二次予防基本チェックリストEntity) {
            entity.initializeMd5();
        }
    }
}
