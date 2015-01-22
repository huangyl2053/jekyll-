/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護世帯のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class KaigoSetaiModel implements Serializable {

    private DbT7014KaigoSetaiEntity entity;

    /**
     * コンストラクタです。
     */
    public KaigoSetaiModel() {
        entity = new DbT7014KaigoSetaiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7014KaigoSetaiEntity
     */
    public KaigoSetaiModel(DbT7014KaigoSetaiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7014KaigoSetaiEntityを返します。
     *
     * @return DbT7014KaigoSetaiEntity
     */
    public DbT7014KaigoSetaiEntity getEntity() {
        return entity;
    }

    /**
     * DbT7014KaigoSetaiEntityを設定します。
     *
     * @param entity DbT7014KaigoSetaiEntity
     */
    public void setEntity(DbT7014KaigoSetaiEntity entity) {
        this.entity = entity;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 世帯基準年月日を返します。
     *
     * @return 世帯基準年月日
     */
    public FlexibleDate get世帯基準年月日() {
        return entity.getSetaiKijunYMD();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public int get連番() {
        return entity.getRenban();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public RDateTime get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 世帯員識別コードを返します。
     *
     * @return 世帯員識別コード
     */
    public ShikibetsuCode get世帯員識別コード() {
        return entity.getSetaiInshikibetsuCode();
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 世帯基準年月日を設定します。
     *
     * @param 世帯基準年月日 世帯基準年月日
     */
    public void set世帯基準年月日(FlexibleDate 世帯基準年月日) {
        requireNonNull(世帯基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯基準年月日"));
        entity.setSetaiKijunYMD(世帯基準年月日);
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     */
    public void set連番(int 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRenban(連番);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(RDateTime 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 世帯員識別コードを設定します。
     *
     * @param 世帯員識別コード 世帯員識別コード
     */
    public void set世帯員識別コード(ShikibetsuCode 世帯員識別コード) {
        requireNonNull(世帯員識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員識別コード"));
        entity.setSetaiInshikibetsuCode(世帯員識別コード);
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
