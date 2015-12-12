/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigoserviceshurui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7131KaigoServiceNaiyouEntity;

/**
 * 介護サービス種類RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class KaigoServiceShuruiEntity implements Cloneable, Serializable {


    /**
     * -- GETTER --
     * 介護サービス種類Entityを返します。
     *
     * @return 介護サービス種類Entity
     * -- SETTER --
     * 介護サービス種類Entityを設定します。
     *
     * @param 介護サービス種類Entity 介護サービス種類Entity
     */
    private DbT7130KaigoServiceShuruiEntity 介護サービス種類Entity;

    /**
     * -- GETTER --
     * 介護サービス内容EntityListを返します。
     *
     * @return 介護サービス内容EntityList
     * -- SETTER --
     * 介護サービス内容EntityListを設定します。
     *
     * @param 介護サービス内容EntityList 介護サービス内容EntityList
     */
    private List<DbT7131KaigoServiceNaiyouEntity> 介護サービス内容Entity;



    /**
     * コンストラクタです。
     */
    public KaigoServiceShuruiEntity() {
        介護サービス種類Entity = new DbT7130KaigoServiceShuruiEntity();
        介護サービス内容Entity = new ArrayList<>();

    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * KaigoServiceShuruiEntityが持つ{@link DbT7130KaigoServiceShuruiEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.介護サービス種類Entity.initializeMd5();
        for (DbT7131KaigoServiceNaiyouEntity entity : this.介護サービス内容Entity) {
            entity.initializeMd5();
        }

    }
}
