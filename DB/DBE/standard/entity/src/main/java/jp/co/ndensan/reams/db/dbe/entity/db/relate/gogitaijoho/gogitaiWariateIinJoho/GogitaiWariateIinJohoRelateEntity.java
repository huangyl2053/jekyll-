/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijoho.gogitaiWariateIinJoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5593GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5594ShinsakaiIinJohoEntity;

/**
 * 合議体割当委員情報RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class GogitaiWariateIinJohoRelateEntity implements Cloneable, Serializable {


    /**
     * -- GETTER --
     * 合議体割当委員情報Entityを返します。
     *
     * @return 合議体割当委員情報Entity
     * -- SETTER --
     * 合議体割当委員情報Entityを設定します。
     *
     * @param 合議体割当委員情報Entity 合議体割当委員情報Entity
     */
    private DbT5593GogitaiWariateIinJohoEntity 合議体割当委員情報Entity;
    /**
     * -- GETTER --
     * 介護認定審査会委員情報EntityListを返します。
     *
     * @return 介護認定審査会委員情報EntityList
     * -- SETTER --
     * 介護認定審査会委員情報EntityListを設定します。
     *
     * @param 介護認定審査会委員情報EntityList 介護認定審査会委員情報EntityList
     */
    private List<DbT5594ShinsakaiIinJohoEntity> 介護認定審査会委員情報Entity;

    /**
     * コンストラクタです。
     */
    public GogitaiWariateIinJohoRelateEntity() {
        合議体割当委員情報Entity = new DbT5593GogitaiWariateIinJohoEntity();
        介護認定審査会委員情報Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * GogitaiWariateIinJohoRelateEntityが持つ{@link DbT5593GogitaiWariateIinJohoEntity}と<br/>
     * {@link DbT5594ShinsakaiIinJohoEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.合議体割当委員情報Entity.initializeMd5();
        for (DbT5594ShinsakaiIinJohoEntity entity : this.介護認定審査会委員情報Entity) {
            entity.initializeMd5();
        }
    }
}
