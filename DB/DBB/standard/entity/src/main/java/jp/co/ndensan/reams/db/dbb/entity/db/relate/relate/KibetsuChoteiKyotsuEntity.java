/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.relate;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;

/**
 * 介護期別調定共通RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class KibetsuChoteiKyotsuEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 介護期別Entityを返します。
     *
     * @return 介護期別Entity -- SETTER -- 介護期別Entityを設定します。
     *
     * @param 介護期別Entity 介護期別Entity
     */
    private DbT2003KibetsuEntity 介護期別Entity;
    /**
     * -- GETTER -- 調定共通Entityを返します。
     *
     * @return 調定共通Entity -- SETTER -- 調定共通Entityを設定します。
     *
     * @param 調定共通Entity 調定共通Entity
     */
    private UrT0705ChoteiKyotsuEntity 調定共通Entity;

    /**
     * コンストラクタです。
     */
    public KibetsuChoteiKyotsuEntity() {
        介護期別Entity = new DbT2003KibetsuEntity();
        調定共通Entity = new UrT0705ChoteiKyotsuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param 介護期別Entity 介護期別Entity
     * @param 調定共通Entity 調定共通Entity
     */
    public KibetsuChoteiKyotsuEntity(DbT2003KibetsuEntity 介護期別Entity, UrT0705ChoteiKyotsuEntity 調定共通Entity) {
        this.介護期別Entity = 介護期別Entity;
        this.調定共通Entity = 調定共通Entity;
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * ChoshuYuyoEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/> {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.介護期別Entity.initializeMd5();
        this.調定共通Entity.initializeMd5();
    }
}
