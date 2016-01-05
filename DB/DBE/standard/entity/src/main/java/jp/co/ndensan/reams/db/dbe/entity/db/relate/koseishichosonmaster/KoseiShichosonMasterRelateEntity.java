/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.koseishichosonmaster;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.syujii.shujiiiryokikanjoho.ShujiiIryoKikanJohoRelateEntity;

/**
 * 構成市町村マスタRelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class KoseiShichosonMasterRelateEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 構成市町村マスタEntityを返します。
     *
     * @return 構成市町村マスタEntity -- SETTER -- 構成市町村マスタEntityを設定します。
     *
     * @param 構成市町村マスタEntity 構成市町村マスタEntity
     */
    private DbT5051KoseiShichosonMasterEntity 構成市町村マスタEntity;

    /**
     * -- GETTER -- 主治医医療機関情報EntityListを返します。
     *
     * @return 主治医医療機関情報EntityList -- SETTER -- 主治医医療機関情報EntityListを設定します。
     *
     * @param 主治医医療機関情報EntityList 主治医医療機関情報EntityList
     */
    private List<ShujiiIryoKikanJohoRelateEntity> 主治医医療機関情報RelateEntity;

    /**
     * コンストラクタです。
     */
    public KoseiShichosonMasterRelateEntity() {
        構成市町村マスタEntity = new DbT5051KoseiShichosonMasterEntity();
        主治医医療機関情報RelateEntity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * KoseiShichosonMasterEntityが持つ{@link 構成市町村マスタEntity}と{@link 主治医医療機関情報RelateEntity}と<br/>
     * {@link ShujiiIryoKikanJohoRelateEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.構成市町村マスタEntity.initializeMd5();
        for (ShujiiIryoKikanJohoRelateEntity relateEntity : this.主治医医療機関情報RelateEntity) {
            relateEntity.initializeMd5ToEntities();
        }
    }
}
