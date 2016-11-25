/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.hokenryodankai;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;

/**
 * 保険料ランクの情報RelateEntityクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
@lombok.Getter
@lombok.Setter
public class HokenryoDankaiJohoRelateEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 保険料段階Entityを返します。
     *
     * @return 保険料段階Entity -- SETTER -- 保険料段階Entityを設定します。
     *
     * @param 保険料段階Entity 保険料段階Entity
     */
    private DbT2013HokenryoDankaiEntity 保険料段階Entity;
    /**
     * -- GETTER -- ランク情報EntityListを返します。
     *
     * @return ランク情報EntityList -- SETTER -- ランク情報EntityListを設定します。
     *
     * @param ランク情報EntityList ランク情報EntityList
     */
    private List<RankJohoEntity> ランク情報Entity;

    /**
     * コンストラクタです。
     */
    public HokenryoDankaiJohoRelateEntity() {
        保険料段階Entity = new DbT2013HokenryoDankaiEntity();
        ランク情報Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * HokenryoDankaiJohoRelateEntityが持つ{@link DbT2013HokenryoDankaiEntity}と{@link RankJohoEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.保険料段階Entity.initializeMd5();
        for (RankJohoEntity entity : this.ランク情報Entity) {
            entity.initializeMd5ToEntities();
        }
    }
}
