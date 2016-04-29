/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.hokenryodankai;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2011RankJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2012HokenryoRankEntity;

/**
 * ランク情報RelateEntityクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
@lombok.Getter
@lombok.Setter
public class RankJohoEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- ランク情報Entityを返します。
     *
     * @return ランク情報Entity -- SETTER -- ランク情報Entityを設定します。
     *
     * @param ランク情報Entity ランク情報Entity
     */
    private DbT2011RankJohoEntity ランク情報Entity;
    /**
     * -- GETTER -- 保険料ランクEntityListを返します。
     *
     * @return 保険料ランクEntityList -- SETTER -- 保険料ランクEntityListを設定します。
     *
     * @param 保険料ランクEntityList 保険料ランクEntityList
     */
    private List<DbT2012HokenryoRankEntity> 保険料ランクEntity;

    /**
     * コンストラクタです。
     */
    public RankJohoEntity() {
        ランク情報Entity = new DbT2011RankJohoEntity();
        保険料ランクEntity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * RankJohoEntityが持つ{@link DbT2011RankJohoEntity}と{@link DbT2012HokenryoRankEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.ランク情報Entity.initializeMd5();
        for (DbT2012HokenryoRankEntity entity : this.保険料ランクEntity) {
            entity.initializeMd5();
        }
    }
}
