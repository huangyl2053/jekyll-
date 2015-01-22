/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 構成市町村支所マスタのモデルクラスです。
 *
 * @author LDNS 宋文娟
 */
public class KoseiShichosonShishoMasterModel implements Serializable {

    private DbT7052KoseiShichosonShishoMasterEntity entity;

    /**
     * コンストラクタです。
     */
    public KoseiShichosonShishoMasterModel() {
        entity = new DbT7052KoseiShichosonShishoMasterEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7052KoseiShichosonShishoMasterEntity
     */
    public KoseiShichosonShishoMasterModel(DbT7052KoseiShichosonShishoMasterEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7052KoseiShichosonShishoMasterEntityを返します。
     *
     * @return DbT7052KoseiShichosonShishoMasterEntity
     */
    public DbT7052KoseiShichosonShishoMasterEntity getEntity() {
        return entity;
    }

    /**
     * DbT7052KoseiShichosonShishoMasterEntityを設定します。
     *
     * @param entity DbT7052KoseiShichosonShishoMasterEntity
     */
    public void setEntity(DbT7052KoseiShichosonShishoMasterEntity entity) {
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
     * 支所コードを返します。
     *
     * @return 支所コード
     */
    public ShishoCode get支所コード() {
        return entity.getShishoCode();
    }

    /**
     * 支所名を返します。
     *
     * @return 支所名
     */
    public RString get支所名() {
        return entity.getShishoMei();
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
     * 支所コードを設定します。
     *
     * @param 支所コード 支所コード
     */
    public void set支所コード(ShishoCode 支所コード) {
        requireNonNull(支所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支所コード"));
        entity.setShishoCode(支所コード);
    }

    /**
     * 支所名を設定します。
     *
     * @param 支所名 支所名
     */
    public void set支所名(RString 支所名) {
        requireNonNull(支所名, UrSystemErrorMessages.値がnull.getReplacedMessage("支所名"));
        entity.setShishoMei(支所名);
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
