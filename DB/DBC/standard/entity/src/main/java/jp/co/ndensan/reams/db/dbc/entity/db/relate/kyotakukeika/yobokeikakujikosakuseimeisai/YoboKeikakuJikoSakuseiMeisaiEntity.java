/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakukeika.yobokeikakujikosakuseimeisai;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3012YoboKeikakuJikoSakuseiGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3011YoboKeikakuJikoSakuseiMeisaiEntity;

/**
 * 予防給付計画自己作成明細RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class YoboKeikakuJikoSakuseiMeisaiEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 予防給付計画自己作成明細Entityを返します。
     *
     * @return 予防給付計画自己作成明細Entity -- SETTER -- 予防給付計画自己作成明細Entityを設定します。
     *
     * @param 予防給付計画自己作成明細Entity 予防給付計画自己作成明細Entity
     */
    private DbT3011YoboKeikakuJikoSakuseiMeisaiEntity 予防給付計画自己作成明細Entity;
    /**
     * -- GETTER -- 予防給付計画自己作成合計EntityListを返します。
     *
     * @return 予防給付計画自己作成合計EntityList -- SETTER -- 予防給付計画自己作成合計EntityListを設定します。
     *
     * @param 予防給付計画自己作成合計EntityList 予防給付計画自己作成合計EntityList
     */
    private List<DbT3012YoboKeikakuJikoSakuseiGokeiEntity> 予防給付計画自己作成合計Entity;
    /**
     * -- GETTER -- 予防給付計画自己作成短期利用日数EntityListを返します。
     *
     * @return 予防給付計画自己作成短期利用日数EntityList -- SETTER -- 予防給付計画自己作成短期利用日数EntityListを設定します。
     *
     * @param 予防給付計画自己作成短期利用日数EntityList 予防給付計画自己作成短期利用日数EntityList
     */
    private List<DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity> 予防給付計画自己作成短期利用日数Entity;

    /**
     * コンストラクタです。
     */
    public YoboKeikakuJikoSakuseiMeisaiEntity() {
        予防給付計画自己作成明細Entity = new DbT3011YoboKeikakuJikoSakuseiMeisaiEntity();
        予防給付計画自己作成合計Entity = new ArrayList<>();
        予防給付計画自己作成短期利用日数Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * YoboKeikakuJikoSakuseiMeisaiEntityが持つ{@link DbT3011YoboKeikakuJikoSakuseiMeisaiEntity}と{@link DbT3012YoboKeikakuJikoSakuseiGokeiEntity}と<br/>
     * {@link DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.予防給付計画自己作成明細Entity.initializeMd5();
        for (DbT3012YoboKeikakuJikoSakuseiGokeiEntity entity : this.予防給付計画自己作成合計Entity) {
            entity.initializeMd5();
        }
        for (DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity entity : this.予防給付計画自己作成短期利用日数Entity) {
            entity.initializeMd5();
        }
    }
}
