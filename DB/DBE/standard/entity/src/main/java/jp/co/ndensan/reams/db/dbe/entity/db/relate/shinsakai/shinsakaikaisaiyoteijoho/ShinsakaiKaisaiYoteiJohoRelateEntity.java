/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaikaisaiyoteijoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5511ShinsakaiKaisaiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5512ShinsakaiOnseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJohoRelateEntity;

/**
 * 介護認定審査会開催予定情報RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class ShinsakaiKaisaiYoteiJohoRelateEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 介護認定審査会開催予定情報Entityを返します。
     *
     * @return 介護認定審査会開催予定情報Entity -- SETTER -- 介護認定審査会開催予定情報Entityを設定します。
     *
     * @param 介護認定審査会開催予定情報Entity 介護認定審査会開催予定情報Entity
     */
    private DbT5501ShinsakaiKaisaiYoteiJohoEntity 介護認定審査会開催予定情報Entity;

    /**
     * -- GETTER -- 介護認定審査会割当情報EntityListを返します。
     *
     * @return 介護認定審査会割当情報EntityList -- SETTER -- 介護認定審査会割当情報EntityListを設定します。
     *
     * @param 介護認定審査会割当情報EntityList 介護認定審査会割当情報EntityList
     */
    private List<ShinsakaiWariateJohoRelateEntity> 介護認定審査会割当情報RelateEntity;

    /**
     * -- GETTER -- 介護認定審査会割当委員情報EntityListを返します。
     *
     * @return 介護認定審査会割当委員情報EntityList -- SETTER --
     * 介護認定審査会割当委員情報EntityListを設定します。
     *
     * @param 介護認定審査会割当委員情報EntityList 介護認定審査会割当委員情報EntityList
     */
    private List<ShinsakaiWariateIinJohoRelateEntity> 介護認定審査会割当委員情報RelateEntity;

    /**
     * -- GETTER -- 介護認定審査会開催結果情報EntityListを返します。
     *
     * @return 介護認定審査会開催結果情報EntityList -- SETTER --
     * 介護認定審査会開催結果情報EntityListを設定します。
     *
     * @param 介護認定審査会開催結果情報EntityList 介護認定審査会開催結果情報EntityList
     */
    private List<DbT5511ShinsakaiKaisaiKekkaJohoEntity> 介護認定審査会開催結果情報Entity;

    /**
     * -- GETTER -- 介護認定審査会音声情報EntityListを返します。
     *
     * @return 介護認定審査会音声情報EntityList -- SETTER -- 介護認定審査会音声情報EntityListを設定します。
     *
     * @param 介護認定審査会音声情報EntityList 介護認定審査会音声情報EntityList
     */
    private List<DbT5512ShinsakaiOnseiJohoEntity> 介護認定審査会音声情報Entity;

    /**
     * コンストラクタです。
     */
    public ShinsakaiKaisaiYoteiJohoRelateEntity() {
        介護認定審査会開催予定情報Entity = new DbT5501ShinsakaiKaisaiYoteiJohoEntity();
        介護認定審査会割当情報RelateEntity = new ArrayList<>();
        介護認定審査会割当委員情報RelateEntity = new ArrayList<>();
        介護認定審査会開催結果情報Entity = new ArrayList<>();
        介護認定審査会音声情報Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * ShinsakaiKaisaiYoteiJohoEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/>
     * {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.介護認定審査会開催予定情報Entity.initializeMd5();
        for (ShinsakaiWariateJohoRelateEntity relateEntity : this.介護認定審査会割当情報RelateEntity) {
            relateEntity.initializeMd5ToEntities();
        }
        for (ShinsakaiWariateIinJohoRelateEntity relateEntity : this.介護認定審査会割当委員情報RelateEntity) {
            relateEntity.initializeMd5ToEntities();
        }
        for (DbT5511ShinsakaiKaisaiKekkaJohoEntity entity : this.介護認定審査会開催結果情報Entity) {
            entity.initializeMd5();
        }
        for (DbT5512ShinsakaiOnseiJohoEntity entity : this.介護認定審査会音声情報Entity) {
            entity.initializeMd5();
        }
    }
}
