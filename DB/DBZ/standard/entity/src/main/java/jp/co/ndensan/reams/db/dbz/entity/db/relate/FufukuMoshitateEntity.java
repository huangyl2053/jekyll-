/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7002BemmeiNaiyoEntity;

/**
 * 不服審査申立情報RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class FufukuMoshitateEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 不服審査申立情報Entityを返します。
     *
     * @return 不服審査申立情報Entity -- SETTER -- 不服審査申立情報Entityを設定します。
     *
     * @param 不服審査申立情報Entity 不服審査申立情報Entity
     */
    private DbT7001FufukuMoshitateEntity 不服審査申立情報Entity;
    //TODO List型が適切かどうか見直してください
    /**
     * -- GETTER -- 弁明内容EntityListを返します。
     *
     * @return 弁明内容EntityList -- SETTER -- 弁明内容EntityListを設定します。
     *
     * @param 弁明内容EntityList 弁明内容EntityList
     */
    private List<DbT7002BemmeiNaiyoEntity> 弁明内容Entity;

    /**
     * コンストラクタです。
     */
    public FufukuMoshitateEntity() {
        不服審査申立情報Entity = new DbT7001FufukuMoshitateEntity();
        弁明内容Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * FufukuMoshitateEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/>
     * {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.不服審査申立情報Entity.initializeMd5();
        for (DbT7002BemmeiNaiyoEntity entity : this.弁明内容Entity) {
            entity.initializeMd5();
        }
    }
}
