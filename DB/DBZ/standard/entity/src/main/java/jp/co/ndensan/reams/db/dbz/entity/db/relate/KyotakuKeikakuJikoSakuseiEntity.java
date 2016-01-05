/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity;

/**
 * 居宅給付計画自己作成RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class KyotakuKeikakuJikoSakuseiEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 居宅給付計画自己作成Entityを返します。
     *
     * @return 居宅給付計画自己作成Entity -- SETTER -- 居宅給付計画自己作成Entityを設定します。
     *
     * @param 居宅給付計画自己作成Entity 居宅給付計画自己作成Entity
     */
    private DbT3007KyotakuKeikakuJikoSakuseiEntity 居宅給付計画自己作成Entity;
    //TODO List型が適切かどうか見直してください
    /**
     * -- GETTER -- 居宅給付計画自己作成明細EntityListを返します。
     *
     * @return 居宅給付計画自己作成明細EntityList -- SETTER -- 居宅給付計画自己作成明細EntityListを設定します。
     *
     * @param 居宅給付計画自己作成明細EntityList 居宅給付計画自己作成明細EntityList
     */
    private List<DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity> 居宅給付計画自己作成明細Entity;
    //TODO List型が適切かどうか見直してください
    /**
     * -- GETTER -- 予防給付計画自己作成明細EntityListを返します。
     *
     * @return 予防給付計画自己作成明細EntityList -- SETTER -- 予防給付計画自己作成明細EntityListを設定します。
     *
     * @param 予防給付計画自己作成明細EntityList 予防給付計画自己作成明細EntityList
     */
    private List<DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity> 予防給付計画自己作成明細Entity;

    /**
     * コンストラクタです。
     */
    public KyotakuKeikakuJikoSakuseiEntity() {
        居宅給付計画自己作成Entity = new DbT3007KyotakuKeikakuJikoSakuseiEntity();
        居宅給付計画自己作成明細Entity = new ArrayList<>();
        予防給付計画自己作成明細Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * KyotakuKeikakuJikoSakuseiEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/>
     * {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.居宅給付計画自己作成Entity.initializeMd5();
        for (DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity entity : this.居宅給付計画自己作成明細Entity) {
            entity.initializeMd5();
        }
        for (DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity : this.予防給付計画自己作成明細Entity) {
            entity.initializeMd5();
        }
    }
}
