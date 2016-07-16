/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.gemmen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;

/**
 * 介護期別RelateEntityクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
@lombok.Getter
@lombok.Setter
public class KibetsuEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 介護期別Entityを返します。
     *
     * @return 介護期別Entity -- SETTER -- 介護期別Entityを設定します。
     *
     * @param 介護期別Entity 介護期別Entity
     */
    private DbT2003KibetsuEntity 介護期別Entity;
    /**
     * -- GETTER -- 調定共通EntityListを返します。
     *
     * @return 調定共通EntityList -- SETTER -- 調定共通EntityListを設定します。
     *
     * @param 調定共通EntityList 調定共通EntityList
     */
    private List<UrT0705ChoteiKyotsuEntity> 調定共通EntityList;

    /**
     * コンストラクタです。
     */
    public KibetsuEntity() {
        介護期別Entity = new DbT2003KibetsuEntity();
        調定共通EntityList = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * KibetsuEntityが持つ{@link DbT2003KibetsuEntity}と{@link UrT0705ChoteiKyotsuEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.介護期別Entity.initializeMd5();
        for (UrT0705ChoteiKyotsuEntity entity : this.調定共通EntityList) {
            entity.initializeMd5();
        }
    }
}
