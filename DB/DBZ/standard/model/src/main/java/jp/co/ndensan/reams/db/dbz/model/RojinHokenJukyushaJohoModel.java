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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7005RojinHokenJukyushaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 老人保健受給者情報のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class RojinHokenJukyushaJohoModel implements Serializable {

    private DbT7005RojinHokenJukyushaJohoEntity entity;

    /**
     * コンストラクタです。
     */
    public RojinHokenJukyushaJohoModel() {
        entity = new DbT7005RojinHokenJukyushaJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7005RojinHokenJukyushaJohoEntity
     */
    public RojinHokenJukyushaJohoModel(DbT7005RojinHokenJukyushaJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7005RojinHokenJukyushaJohoEntityを返します。
     *
     * @return DbT7005RojinHokenJukyushaJohoEntity
     */
    public DbT7005RojinHokenJukyushaJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT7005RojinHokenJukyushaJohoEntityを設定します。
     *
     * @param entity DbT7005RojinHokenJukyushaJohoEntity
     */
    public void setEntity(DbT7005RojinHokenJukyushaJohoEntity entity) {
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
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
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
     * 老人保健市町村コードを返します。
     *
     * @return 老人保健市町村コード
     */
    public LasdecCode get老人保健市町村コード() {
        return entity.getRojinHokenShichosonCode();
    }

    /**
     * 老人保健受給者番号を返します。
     *
     * @return 老人保健受給者番号
     */
    public RString get老人保健受給者番号() {
        return entity.getRojinHokenJukyushaNo();
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
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
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
     * 老人保健市町村コードを設定します。
     *
     * @param 老人保健市町村コード 老人保健市町村コード
     */
    public void set老人保健市町村コード(LasdecCode 老人保健市町村コード) {
        requireNonNull(老人保健市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健市町村コード"));
        entity.setRojinHokenShichosonCode(老人保健市町村コード);
    }

    /**
     * 老人保健受給者番号を設定します。
     *
     * @param 老人保健受給者番号 老人保健受給者番号
     */
    public void set老人保健受給者番号(RString 老人保健受給者番号) {
        requireNonNull(老人保健受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健受給者番号"));
        entity.setRojinHokenJukyushaNo(老人保健受給者番号);
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
