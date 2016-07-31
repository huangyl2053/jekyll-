/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4022ShiharaiHohoHenkoTainoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitomeEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;

/**
 * 支払方法変更RelateEntityクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
@lombok.Getter
@lombok.Setter
public class ShiharaiHohoHenkoEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 支払方法変更Entityを返します。
     *
     * @return 支払方法変更Entity -- SETTER -- 支払方法変更Entityを設定します。
     *
     * @param 支払方法変更Entity 支払方法変更Entity
     */
    private DbT4021ShiharaiHohoHenkoEntity 支払方法変更Entity;
    /**
     * -- GETTER -- 支払方法変更滞納EntityListを返します。
     *
     * @return 支払方法変更滞納EntityList -- SETTER -- 支払方法変更滞納EntityListを設定します。
     *
     * @param 支払方法変更滞納EntityList 支払方法変更滞納EntityList
     */
    private List<DbT4022ShiharaiHohoHenkoTainoEntity> 支払方法変更滞納Entity;
    /**
     * -- GETTER -- 支払方法変更差止EntityListを返します。
     *
     * @return 支払方法変更差止EntityList -- SETTER -- 支払方法変更差止EntityListを設定します。
     *
     * @param 支払方法変更差止EntityList 支払方法変更差止EntityList
     */
    private List<DbT4024ShiharaiHohoHenkoSashitomeEntity> 支払方法変更差止Entity;
    /**
     * -- GETTER -- 支払方法変更減額EntityListを返します。
     *
     * @return 支払方法変更減額EntityList -- SETTER -- 支払方法変更減額EntityListを設定します。
     *
     * @param 支払方法変更減額EntityList 支払方法変更減額EntityList
     */
    private List<ShiharaiHohoHenkoGengakuEntity> 支払方法変更減額Entity;

    /**
     * コンストラクタです。
     */
    public ShiharaiHohoHenkoEntity() {
        支払方法変更Entity = new DbT4021ShiharaiHohoHenkoEntity();
        支払方法変更滞納Entity = new ArrayList<>();
        支払方法変更差止Entity = new ArrayList<>();
        支払方法変更減額Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * ShiharaiHohoHenkoEntityが持つ{@link DbT4021ShiharaiHohoHenkoEntity}と{@link DbT4022ShiharaiHohoHenkoTainoEntity}と<br/>
     * {@link ShiharaiHohoHenkoGengakuEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.支払方法変更Entity.initializeMd5();
        for (DbT4022ShiharaiHohoHenkoTainoEntity entity : this.支払方法変更滞納Entity) {
            entity.initializeMd5();
        }
        for (DbT4024ShiharaiHohoHenkoSashitomeEntity entity : this.支払方法変更差止Entity) {
            entity.initializeMd5();
        }
        for (ShiharaiHohoHenkoGengakuEntity entity : this.支払方法変更減額Entity) {
            entity.initializeMd5ToEntities();
        }
    }
}
