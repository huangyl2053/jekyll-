/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.koseishichosonmaster;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7052KoseiShichosonShishoMasterEntity;

/**
 * 構成市町村マスタRelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class KoseiShichosonMasterRelateEntity implements Cloneable, Serializable {

    private static final long serialVersionUID = -7293038234715949928L;

    /**
     * -- GETTER -- 構成市町村マスタEntityを返します。
     *
     * @return 構成市町村マスタEntity -- SETTER -- 構成市町村マスタEntityを設定します。
     *
     * @param 構成市町村マスタEntity 構成市町村マスタEntity
     */
    private DbT7051KoseiShichosonMasterEntity 構成市町村マスタEntity;

    /**
     * -- GETTER -- 構成市町村支所マスタEntityListを返します。
     *
     * @return 構成市町村支所マスタEntityList -- SETTER -- 構成市町村支所マスタEntityListを設定します。
     *
     * @param 構成市町村支所マスタEntityList 構成市町村支所マスタEntityList
     */
    private List<DbT7052KoseiShichosonShishoMasterEntity> 構成市町村支所マスタEntity;

    /**
     * コンストラクタです。
     */
    public KoseiShichosonMasterRelateEntity() {
        構成市町村マスタEntity = new DbT7051KoseiShichosonMasterEntity();
        構成市町村支所マスタEntity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * KoseiShichosonMasterEntityが持つ{@link DbT7051KoseiShichosonMasterEntity}と
     * <br/> {@link DbT7052KoseiShichosonShishoMasterEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.構成市町村マスタEntity.initializeMd5();
        for (DbT7052KoseiShichosonShishoMasterEntity entity : this.構成市町村支所マスタEntity) {
            entity.initializeMd5();
        }
    }
}
