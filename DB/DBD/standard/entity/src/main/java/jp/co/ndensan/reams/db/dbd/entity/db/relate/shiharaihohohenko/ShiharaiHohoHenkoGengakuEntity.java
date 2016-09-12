/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4025ShiharaiHohoHenkoGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity;

/**
 * 支払方法変更減額RelateEntityクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
@lombok.Getter
@lombok.Setter
public class ShiharaiHohoHenkoGengakuEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 支払方法変更減額Entityを返します。
     *
     * @return 支払方法変更減額Entity -- SETTER -- 支払方法変更減額Entityを設定します。
     *
     * @param 支払方法変更減額Entity 支払方法変更減額Entity
     */
    private DbT4025ShiharaiHohoHenkoGengakuEntity 支払方法変更減額Entity;
    /**
     * -- GETTER -- 支払方法変更減額明細EntityListを返します。
     *
     * @return 支払方法変更減額明細EntityList -- SETTER -- 支払方法変更減額明細EntityListを設定します。
     *
     * @param 支払方法変更減額明細EntityList 支払方法変更減額明細EntityList
     */
    private List<DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity> 支払方法変更減額明細Entity;

    /**
     * コンストラクタです。
     */
    public ShiharaiHohoHenkoGengakuEntity() {
        支払方法変更減額Entity = new DbT4025ShiharaiHohoHenkoGengakuEntity();
        支払方法変更減額明細Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * ShiharaiHohoHenkoGengakuEntityが持つ{@link DbT4025ShiharaiHohoHenkoGengakuEntity}と<br/>
     * {@link DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.支払方法変更減額Entity.initializeMd5();
        for (DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity entity : this.支払方法変更減額明細Entity) {
            entity.initializeMd5();
        }
    }
}
