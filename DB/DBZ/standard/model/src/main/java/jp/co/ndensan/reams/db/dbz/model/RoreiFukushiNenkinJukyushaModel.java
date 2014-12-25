/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 老齢福祉年金受給者のモデルクラスです。
 *
 * @author LDNS 賈楽楽
 */
public class RoreiFukushiNenkinJukyushaModel implements Serializable {

    private DbT7006RoreiFukushiNenkinJukyushaEntity entity;

    /**
     * コンストラクタです。
     */
    public RoreiFukushiNenkinJukyushaModel() {
        entity = new DbT7006RoreiFukushiNenkinJukyushaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7006RoreiFukushiNenkinJukyushaEntity
     */
    public RoreiFukushiNenkinJukyushaModel(DbT7006RoreiFukushiNenkinJukyushaEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7006RoreiFukushiNenkinJukyushaEntityを返します。
     *
     * @return DbT7006RoreiFukushiNenkinJukyushaEntity
     */
    public DbT7006RoreiFukushiNenkinJukyushaEntity getEntity() {
        return entity;
    }

    /**
     * DbT7006RoreiFukushiNenkinJukyushaEntityを設定します。
     *
     * @param entity DbT7006RoreiFukushiNenkinJukyushaEntity
     */
    public void setEntity(DbT7006RoreiFukushiNenkinJukyushaEntity entity) {
        this.entity = entity;
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
     * 受給開始日を返します。
     *
     * @return 受給開始日
     */
    public FlexibleDate get受給開始日() {
        return entity.getJukyuKaishiYMD();
    }

    /**
     * 受給廃止日を返します。
     *
     * @return 受給廃止日
     */
    public FlexibleDate get受給廃止日() {
        return entity.getJukyuHaishiYMD();
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
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
    }

    /**
     * 受給開始日を設定します。
     *
     * @param 受給開始日 受給開始日
     */
    public void set受給開始日(FlexibleDate 受給開始日) {
        requireNonNull(受給開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給開始日"));
        entity.setJukyuKaishiYMD(受給開始日);
    }

    /**
     * 受給廃止日を設定します。
     *
     * @param 受給廃止日 受給廃止日
     */
    public void set受給廃止日(FlexibleDate 受給廃止日) {
        requireNonNull(受給廃止日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給廃止日"));
        entity.setJukyuHaishiYMD(受給廃止日);
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
