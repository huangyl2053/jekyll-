/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3101NijiYoboKihonCheckListEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3102NijiYoboNiniCheckListEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3103NijiYoboCheckListHanteiKekkaEntity;

/**
 * 二次予防基本チェックリストRelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class NijiYoboKihonCheckListEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 二次予防基本チェックリストEntityを返します。
     *
     * @return 二次予防基本チェックリストEntity -- SETTER -- 二次予防基本チェックリストEntityを設定します。
     *
     * @param 二次予防基本チェックリストEntity 二次予防基本チェックリストEntity
     */
    private DbT3101NijiYoboKihonCheckListEntity 二次予防基本チェックリストEntity;
    //TODO List型が適切かどうか見直してください
    /**
     * -- GETTER -- 二次予防任意チェックリストEntityListを返します。
     *
     * @return 二次予防任意チェックリストEntityList -- SETTER --
     * 二次予防任意チェックリストEntityListを設定します。
     *
     * @param 二次予防任意チェックリストEntityList 二次予防任意チェックリストEntityList
     */
    private List<DbT3102NijiYoboNiniCheckListEntity> 二次予防任意チェックリストEntity;
    //TODO List型が適切かどうか見直してください
    /**
     * -- GETTER -- 二次予防チェックリスト判定結果EntityListを返します。
     *
     * @return 二次予防チェックリスト判定結果EntityList -- SETTER --
     * 二次予防チェックリスト判定結果EntityListを設定します。
     *
     * @param 二次予防チェックリスト判定結果EntityList 二次予防チェックリスト判定結果EntityList
     */
    private List<DbT3103NijiYoboCheckListHanteiKekkaEntity> 二次予防チェックリスト判定結果Entity;

    /**
     * コンストラクタです。
     */
    public NijiYoboKihonCheckListEntity() {
        二次予防基本チェックリストEntity = new DbT3101NijiYoboKihonCheckListEntity();
        二次予防任意チェックリストEntity = new ArrayList<>();
        二次予防チェックリスト判定結果Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * NijiYoboKihonCheckListEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/>
     * {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.二次予防基本チェックリストEntity.initializeMd5();
        for (DbT3102NijiYoboNiniCheckListEntity entity : this.二次予防任意チェックリストEntity) {
            entity.initializeMd5();
        }
        for (DbT3103NijiYoboCheckListHanteiKekkaEntity entity : this.二次予防チェックリスト判定結果Entity) {
            entity.initializeMd5();
        }
    }
}
