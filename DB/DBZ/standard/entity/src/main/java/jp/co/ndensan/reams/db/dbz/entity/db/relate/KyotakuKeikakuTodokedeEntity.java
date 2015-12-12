/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3007KyotakuKeikakuJikoSakuseiEntity;

/**
 * 居宅給付計画届出RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class KyotakuKeikakuTodokedeEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 居宅給付計画届出Entityを返します。
     *
     * @return 居宅給付計画届出Entity -- SETTER -- 居宅給付計画届出Entityを設定します。
     *
     * @param 居宅給付計画届出Entity 居宅給付計画届出Entity
     */
    private DbT3005KyotakuKeikakuTodokedeEntity 居宅給付計画届出Entity;
    //TODO List型が適切かどうか見直してください
    /**
     * -- GETTER -- 居宅給付計画事業者作成EntityListを返します。
     *
     * @return 居宅給付計画事業者作成EntityList -- SETTER -- 居宅給付計画事業者作成EntityListを設定します。
     *
     * @param 居宅給付計画事業者作成EntityList 居宅給付計画事業者作成EntityList
     */
    private List<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> 居宅給付計画事業者作成Entity;
    //TODO List型が適切かどうか見直してください
    /**
     * -- GETTER -- 居宅給付計画自己作成EntityListを返します。
     *
     * @return 居宅給付計画自己作成EntityList -- SETTER -- 居宅給付計画自己作成EntityListを設定します。
     *
     * @param 居宅給付計画自己作成EntityList 居宅給付計画自己作成EntityList
     */
    private List<DbT3007KyotakuKeikakuJikoSakuseiEntity> 居宅給付計画自己作成Entity;

    /**
     * コンストラクタです。
     */
    public KyotakuKeikakuTodokedeEntity() {
        居宅給付計画届出Entity = new DbT3005KyotakuKeikakuTodokedeEntity();
        居宅給付計画事業者作成Entity = new ArrayList<>();
        居宅給付計画自己作成Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * KyotakuKeikakuTodokedeEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/>
     * {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.居宅給付計画届出Entity.initializeMd5();
        for (DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity : this.居宅給付計画事業者作成Entity) {
            entity.initializeMd5();
        }
        for (DbT3007KyotakuKeikakuJikoSakuseiEntity entity : this.居宅給付計画自己作成Entity) {
            entity.initializeMd5();
        }
    }
}
