/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.relate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;

/**
 * 利用者負担割合RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class RiyoshaFutanWariaiEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 利用者負担割合Entityを返します。
     *
     * @return 利用者負担割合Entity -- SETTER -- 利用者負担割合Entityを設定します。
     *
     * @param 利用者負担割合Entity 利用者負担割合Entity
     */
    private DbT3113RiyoshaFutanWariaiEntity 利用者負担割合Entity;
    //TODO List型が適切かどうか見直してください
    /**
     * -- GETTER -- 利用者負担割合明細EntityListを返します。
     *
     * @return 利用者負担割合明細EntityList -- SETTER -- 利用者負担割合明細EntityListを設定します。
     *
     * @param 利用者負担割合明細EntityList 利用者負担割合明細EntityList
     */
    private List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 利用者負担割合明細Entity;

    /**
     * コンストラクタです。
     */
    public RiyoshaFutanWariaiEntity() {
        利用者負担割合Entity = new DbT3113RiyoshaFutanWariaiEntity();
        利用者負担割合明細Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * RiyoshaFutanWariaiEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/>
     * {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.利用者負担割合Entity.initializeMd5();
        for (DbT3114RiyoshaFutanWariaiMeisaiEntity entity : this.利用者負担割合明細Entity) {
            entity.initializeMd5();
        }
    }
}
