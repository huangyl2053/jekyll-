/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7054KanrenHihokenshaNoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 関連被保険者番号のモデルクラスです。
 *
 * @author LDNS 宋文娟
 */
public class KanrenHihokenshaNoModel implements Serializable {

    private DbT7054KanrenHihokenshaNoEntity entity;

    /**
     * コンストラクタです。
     */
    public KanrenHihokenshaNoModel() {
        entity = new DbT7054KanrenHihokenshaNoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7054KanrenHihokenshaNoEntity
     */
    public KanrenHihokenshaNoModel(DbT7054KanrenHihokenshaNoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7054KanrenHihokenshaNoEntityを返します。
     *
     * @return DbT7054KanrenHihokenshaNoEntity
     */
    public DbT7054KanrenHihokenshaNoEntity getEntity() {
        return entity;
    }

    /**
     * DbT7054KanrenHihokenshaNoEntityを設定します。
     *
     * @param entity DbT7054KanrenHihokenshaNoEntity
     */
    public void setEntity(DbT7054KanrenHihokenshaNoEntity entity) {
        this.entity = entity;
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 最新被保険者番号を返します。
     *
     * @return 最新被保険者番号
     */
    public HihokenshaNo get最新被保険者番号() {
        return entity.getSaishinHihokenshaNo();
    }

    /**
     * 旧被保険者番号を返します。
     *
     * @return 旧被保険者番号
     */
    public HihokenshaNo get旧被保険者番号() {
        return entity.getKyuuHihokenshaNo();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
    }

    /**
     * 最新被保険者番号を設定します。
     *
     * @param 最新被保険者番号 最新被保険者番号
     */
    public void set最新被保険者番号(HihokenshaNo 最新被保険者番号) {
        requireNonNull(最新被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("最新被保険者番号"));
        entity.setSaishinHihokenshaNo(最新被保険者番号);
    }

    /**
     * 旧被保険者番号を設定します。
     *
     * @param 旧被保険者番号 旧被保険者番号
     */
    public void set旧被保険者番号(HihokenshaNo 旧被保険者番号) {
        requireNonNull(旧被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧被保険者番号"));
        entity.setKyuuHihokenshaNo(旧被保険者番号);
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
    }

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    public void setDeletedState(boolean deleteFlag) {
        if (deleteFlag) {
            entity.setState(EntityDataState.Deleted);
        } else {
            entity.unsetState();
        }
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return entity.getState();
    }
}
