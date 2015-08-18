/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.relate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7066ChohyoSeigyoKyotsuControlEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7067ChohyoSeigyoHanyoEntity;

/**
 * 帳票制御共通RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class ChohyoSeigyoKyotsuEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 帳票制御共通Entityを返します。
     *
     * @return 帳票制御共通Entity -- SETTER -- 帳票制御共通Entityを設定します。
     *
     * @param 帳票制御共通Entity 帳票制御共通Entity
     */
    private DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通Entity;
    //TODO List型が適切かどうか見直してください
    /**
     * -- GETTER -- 帳票制御共通コントロールEntityListを返します。
     *
     * @return 帳票制御共通コントロールEntityList -- SETTER -- 帳票制御共通コントロールEntityListを設定します。
     *
     * @param 帳票制御共通コントロールEntityList 帳票制御共通コントロールEntityList
     */
    private List<DbT7066ChohyoSeigyoKyotsuControlEntity> 帳票制御共通コントロールEntity;
    //TODO List型が適切かどうか見直してください
    /**
     * -- GETTER -- 帳票制御汎用EntityListを返します。
     *
     * @return 帳票制御汎用EntityList -- SETTER -- 帳票制御汎用EntityListを設定します。
     *
     * @param 帳票制御汎用EntityList 帳票制御汎用EntityList
     */
    private List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用Entity;

    /**
     * コンストラクタです。
     */
    public ChohyoSeigyoKyotsuEntity() {
        帳票制御共通Entity = new DbT7065ChohyoSeigyoKyotsuEntity();
        帳票制御共通コントロールEntity = new ArrayList<>();
        帳票制御汎用Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * ChohyoSeigyoKyotsuEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/>
     * {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.帳票制御共通Entity.initializeMd5();
        for (DbT7066ChohyoSeigyoKyotsuControlEntity entity : this.帳票制御共通コントロールEntity) {
            entity.initializeMd5();
        }
        for (DbT7067ChohyoSeigyoHanyoEntity entity : this.帳票制御汎用Entity) {
            entity.initializeMd5();
        }
    }
}
