/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;

/**
 * 旧市町村コード情報のモデルクラスです。
 *
 */
public class KyuShichosonCodeJohoRelateEntity implements Serializable {

    private List<DbT7056GappeiShichosonEntity> entitys;
    private boolean gappeiShichoUmuFlag;

    /**
     * コンストラクタです。
     */
    public KyuShichosonCodeJohoRelateEntity() {
        entitys = new ArrayList<>();
    }

    /**
     * DbT7056GappeiShichosonEntityを返します。
     *
     * @return List<DbT7056GappeiShichosonEntity>
     */
    public List<DbT7056GappeiShichosonEntity> getEntitys() {
        return new ArrayList<>(entitys);
    }

    /**
     * DbT7056GappeiShichosonEntityを設定します。
     *
     * @param entitys List<DbT7056GappeiShichosonEntity>
     */
    public void setEntitys(List<DbT7056GappeiShichosonEntity> entitys) {
        this.entitys = new ArrayList<>(entitys);
    }

    /**
     * 合併市町村有無フラグのgetメソッドです。
     *
     * @return 合併市町村有無フラグ
     */
    public boolean getGappeiShichoUmuFlag() {
        return gappeiShichoUmuFlag;
    }

    /**
     * 合併市町村有無フラグのsetメソッドです。
     *
     * @param gappeiShichoUmuFlag 合併市町村有無フラグ
     */
    public void setGappeiShichoUmuFlag(boolean gappeiShichoUmuFlag) {
        this.gappeiShichoUmuFlag = gappeiShichoUmuFlag;
    }

}
