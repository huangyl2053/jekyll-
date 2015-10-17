/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3115RiyoshaFutanWariaiKonkyoEntity;

/**
 * 利用者負担割合明細RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class RiyoshaFutanWariaiMeisaiEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 利用者負担割合明細Entityを返します。
     *
     * @return 利用者負担割合明細Entity -- SETTER -- 利用者負担割合明細Entityを設定します。
     *
     * @param 利用者負担割合明細Entity 利用者負担割合明細Entity
     */
    private DbT3114RiyoshaFutanWariaiMeisaiEntity 利用者負担割合明細Entity;
    //TODO List型が適切かどうか見直してください
    /**
     * -- GETTER -- 利用者負担割合世帯員EntityListを返します。
     *
     * @return 利用者負担割合世帯員EntityList -- SETTER -- 利用者負担割合世帯員EntityListを設定します。
     *
     * @param 利用者負担割合世帯員EntityList 利用者負担割合世帯員EntityList
     */
    private List<DbT3115RiyoshaFutanWariaiKonkyoEntity> 利用者負担割合世帯員Entity;

    /**
     * コンストラクタです。
     */
    public RiyoshaFutanWariaiMeisaiEntity() {
        利用者負担割合明細Entity = new DbT3114RiyoshaFutanWariaiMeisaiEntity();
        利用者負担割合世帯員Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * RiyoshaFutanWariaiMeisaiEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/>
     * {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.利用者負担割合明細Entity.initializeMd5();
        for (DbT3115RiyoshaFutanWariaiKonkyoEntity entity : this.利用者負担割合世帯員Entity) {
            entity.initializeMd5();
        }
    }
}
