/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2009RentaiGimushaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 連帯納付義務者のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class RentaiGimushaModel implements Serializable {

    private DbT2009RentaiGimushaEntity entity;

    /**
     * コンストラクタです。
     */
    public RentaiGimushaModel() {
        entity = new DbT2009RentaiGimushaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT2009RentaiGimushaEntity
     */
    public RentaiGimushaModel(DbT2009RentaiGimushaEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT2009RentaiGimushaEntityを返します。
     *
     * @return DbT2009RentaiGimushaEntity
     */
    public DbT2009RentaiGimushaEntity getEntity() {
        return entity;
    }

    /**
     * DbT2009RentaiGimushaEntityを設定します。
     *
     * @param entity DbT2009RentaiGimushaEntity
     */
    public void setEntity(DbT2009RentaiGimushaEntity entity) {
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
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public RDateTime get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetuCode();
    }

    /**
     * 開始年月日を返します。
     *
     * @return 開始年月日
     */
    public FlexibleDate get開始年月日() {
        return entity.getStartYMD();
    }

    /**
     * 終了年月日を返します。
     *
     * @return 終了年月日
     */
    public FlexibleDate get終了年月日() {
        return entity.getEndYMD();
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
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(RDateTime 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     */
    public void set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetuCode(識別コード);
    }

    /**
     * 開始年月日を設定します。
     *
     * @param 開始年月日 開始年月日
     */
    public void set開始年月日(FlexibleDate 開始年月日) {
        requireNonNull(開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月日"));
        entity.setStartYMD(開始年月日);
    }

    /**
     * 終了年月日を設定します。
     *
     * @param 終了年月日 終了年月日
     */
    public void set終了年月日(FlexibleDate 終了年月日) {
        requireNonNull(終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月日"));
        entity.setEndYMD(終了年月日);
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
