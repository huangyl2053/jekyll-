/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.ninteichosaschedule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.chikuninteichosain.ChikuNinteiChosainEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemoEntity;

/**
 * 認定調査スケジュール情報RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class NinteichosaScheduleEntity implements Cloneable, Serializable {

    private static final long serialVersionUID = -7403649900478063342L;

    /**
     * -- GETTER -- 認定調査スケジュール情報Entityを返します。
     *
     * @return 認定調査スケジュール情報Entity -- SETTER -- 認定調査スケジュール情報Entityを設定します。
     *
     * @param 認定調査スケジュール情報Entity 認定調査スケジュール情報Entity
     */
    private DbT5221NinteichosaScheduleEntity 認定調査スケジュール情報Entity;
    /**
     * -- GETTER -- 認定調査スケジュールメモ情報EntityListを返します。
     *
     * @return 認定調査スケジュールメモ情報EntityList -- SETTER -- 認定調査スケジュールメモ情報EntityListを設定します。
     *
     * @param 認定調査スケジュールメモ情報EntityList 認定調査スケジュールメモ情報EntityList
     */
    private List<DbT5222NinteiChosaScheduleMemoEntity> 認定調査スケジュールメモ情報Entity;
    /**
     * -- GETTER -- 要介護認定申請情報EntityListを返します。
     *
     * @return 要介護認定申請情報EntityList -- SETTER -- 要介護認定申請情報EntityListを設定します。
     *
     * @param 要介護認定申請情報EntityList 要介護認定申請情報EntityList
     */
    private List<DbT5101NinteiShinseiJohoEntity> 要介護認定申請情報Entity;
    /**
     * -- GETTER -- 地区認定調査員EntityListを返します。
     *
     * @return 地区認定調査員EntityList -- SETTER -- 地区認定調査員EntityListを設定します。
     *
     * @param 地区認定調査員EntityList 地区認定調査員EntityList
     */
    private List<ChikuNinteiChosainEntity> 地区認定調査員Entity;

    /**
     * コンストラクタです。
     */
    public NinteichosaScheduleEntity() {
        認定調査スケジュール情報Entity = new DbT5221NinteichosaScheduleEntity();
        認定調査スケジュールメモ情報Entity = new ArrayList<>();
        要介護認定申請情報Entity = new ArrayList<>();
        地区認定調査員Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * NinteichosaScheduleEntityが持つ{@link DbT5222NinteiChosaScheduleMemoEntity}と{@link DbT5101NinteiShinseiJohoEntity}と<br/>
     * {@link ChikuNinteiChosainEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.認定調査スケジュール情報Entity.initializeMd5();
        for (DbT5222NinteiChosaScheduleMemoEntity entity : this.認定調査スケジュールメモ情報Entity) {
            entity.initializeMd5();
        }
        for (DbT5101NinteiShinseiJohoEntity entity : this.要介護認定申請情報Entity) {
            entity.initializeMd5();
        }
        for (ChikuNinteiChosainEntity entity : this.地区認定調査員Entity) {
            entity.initializeMd5ToEntities();
        }
    }
}
