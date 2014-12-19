/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1012Minashi2GoshaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * みなし2号者台帳のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class Minashi2GoshaDaichoModel implements Serializable {

    private DbT1012Minashi2GoshaDaichoEntity entity;

    /**
     * コンストラクタです。
     */
    public Minashi2GoshaDaichoModel() {
        entity = new DbT1012Minashi2GoshaDaichoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT1012Minashi2GoshaDaichoEntity
     */
    public Minashi2GoshaDaichoModel(DbT1012Minashi2GoshaDaichoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT1012Minashi2GoshaDaichoEntityを返します。
     *
     * @return DbT1012Minashi2GoshaDaichoEntity
     */
    public DbT1012Minashi2GoshaDaichoEntity getEntity() {
        return entity;
    }

    /**
     * DbT1012Minashi2GoshaDaichoEntityを設定します。
     *
     * @param entity DbT1012Minashi2GoshaDaichoEntity
     */
    public void setEntity(DbT1012Minashi2GoshaDaichoEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
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
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
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
     * 被保険者区分コードを返します。
     *
     * @return 被保険者区分コード
     */
    public RString get被保険者区分コード() {
        return entity.getHihokenshaKubunCode();
    }

    /**
     * 登録年月日を返します。
     *
     * @return 登録年月日
     */
    public FlexibleDate get登録年月日() {
        return entity.getMinashi2GoshaTorokuYMD();
    }

    /**
     * 解除年月日を返します。
     *
     * @return 解除年月日
     */
    public FlexibleDate get解除年月日() {
        return entity.getMinashi2GoshaKaijoYMD();
    }

    /**
     * 福祉被保険者番号を返します。
     *
     * @return 福祉被保険者番号
     */
    public HihokenshaNo get福祉被保険者番号() {
        return entity.getFukushiHihokenshaNo();
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     */
    public void set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
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
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
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
     * 被保険者区分コードを設定します。
     *
     * @param 被保険者区分コード 被保険者区分コード
     */
    public void set被保険者区分コード(RString 被保険者区分コード) {
        requireNonNull(被保険者区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者区分コード"));
        entity.setHihokenshaKubunCode(被保険者区分コード);
    }

    /**
     * 登録年月日を設定します。
     *
     * @param 登録年月日 登録年月日
     */
    public void set登録年月日(FlexibleDate 登録年月日) {
        requireNonNull(登録年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("登録年月日"));
        entity.setMinashi2GoshaTorokuYMD(登録年月日);
    }

    /**
     * 解除年月日を設定します。
     *
     * @param 解除年月日 解除年月日
     */
    public void set解除年月日(FlexibleDate 解除年月日) {
        requireNonNull(解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除年月日"));
        entity.setMinashi2GoshaKaijoYMD(解除年月日);
    }

    /**
     * 福祉被保険者番号を設定します。
     *
     * @param 福祉被保険者番号 福祉被保険者番号
     */
    public void set福祉被保険者番号(HihokenshaNo 福祉被保険者番号) {
        requireNonNull(福祉被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉被保険者番号"));
        entity.setFukushiHihokenshaNo(福祉被保険者番号);
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
