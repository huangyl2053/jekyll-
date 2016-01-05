/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakukeika.kyotakukeikakujikosakuseimeisai;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;

/**
 * 居宅給付計画自己作成明細RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class KyotakuKeikakuJikosakuseiMeisaiEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 居宅給付計画自己作成明細Entityを返します。
     *
     * @return 居宅給付計画自己作成明細Entity -- SETTER -- 居宅給付計画自己作成明細Entityを設定します。
     *
     * @param 居宅給付計画自己作成明細Entity 居宅給付計画自己作成明細Entity
     */
    private DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity 居宅給付計画自己作成明細Entity;
    /**
     * -- GETTER -- 居宅給付計画自己作成合計EntityListを返します。
     *
     * @return 居宅給付計画自己作成合計EntityList -- SETTER -- 居宅給付計画自己作成合計EntityListを設定します。
     *
     * @param 居宅給付計画自己作成合計EntityList 居宅給付計画自己作成合計EntityList
     */
    private List<DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity> 居宅給付計画自己作成合計Entity;
    /**
     * -- GETTER -- 居宅給付計画自己作成短期入所利用日数EntityListを返します。
     *
     * @return 居宅給付計画自己作成短期入所利用日数EntityList -- SETTER -- 居宅給付計画自己作成短期入所利用日数EntityListを設定します。
     *
     * @param 居宅給付計画自己作成短期入所利用日数EntityList 居宅給付計画自己作成短期入所利用日数EntityList
     */
    private List<DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity> 居宅給付計画自己作成短期入所利用日数Entity;

    /**
     * コンストラクタです。
     */
    public KyotakuKeikakuJikosakuseiMeisaiEntity() {
        居宅給付計画自己作成明細Entity = new DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity();
        居宅給付計画自己作成合計Entity = new ArrayList<>();
        居宅給付計画自己作成短期入所利用日数Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * KyotakuKeikakuJikosakuseiMeisaiEntityが持つ{@link DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity}と{@link DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity}と<br/>
     * {@link DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.居宅給付計画自己作成明細Entity.initializeMd5();
        for (DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity : this.居宅給付計画自己作成合計Entity) {
            entity.initializeMd5();
        }
        for (DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity : this.居宅給付計画自己作成短期入所利用日数Entity) {
            entity.initializeMd5();
        }
    }
}
