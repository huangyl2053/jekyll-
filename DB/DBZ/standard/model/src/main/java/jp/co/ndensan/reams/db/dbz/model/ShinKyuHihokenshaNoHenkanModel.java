/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 新旧被保険者番号変換テーブルのモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class ShinKyuHihokenshaNoHenkanModel implements Serializable {

    private DbT7026ShinKyuHihokenshaNoHenkanEntity entity;

    /**
     * コンストラクタです。
     */
    public ShinKyuHihokenshaNoHenkanModel() {
        entity = new DbT7026ShinKyuHihokenshaNoHenkanEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7026ShinKyuHihokenshaNoHenkanEntity
     */
    public ShinKyuHihokenshaNoHenkanModel(DbT7026ShinKyuHihokenshaNoHenkanEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7026ShinKyuHihokenshaNoHenkanEntityを返します。
     *
     * @return DbT7026ShinKyuHihokenshaNoHenkanEntity
     */
    public DbT7026ShinKyuHihokenshaNoHenkanEntity getEntity() {
        return entity;
    }

    /**
     * DbT7026ShinKyuHihokenshaNoHenkanEntityを設定します。
     *
     * @param entity DbT7026ShinKyuHihokenshaNoHenkanEntity
     */
    public void setEntity(DbT7026ShinKyuHihokenshaNoHenkanEntity entity) {
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
     * 新番号を返します。
     *
     * @return 新番号
     */
    public RString get新番号() {
        return entity.getShinNo();
    }

    /**
     * 旧番号を返します。
     *
     * @return 旧番号
     */
    public RString get旧番号() {
        return entity.getKyuNo();
    }

    /**
     * 旧市町村コード２を返します。
     *
     * @return 旧市町村コード２
     */
    public LasdecCode get旧市町村コード２() {
        return entity.getKyuShichosonCode();
    }

    /**
     * 旧番号２を返します。
     *
     * @return 旧番号２
     */
    public RString get旧番号２() {
        return entity.getKyuNo2();
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
     * 新番号を設定します。
     *
     * @param 新番号 新番号
     */
    public void set新番号(RString 新番号) {
        requireNonNull(新番号, UrSystemErrorMessages.値がnull.getReplacedMessage("新番号"));
        entity.setShinNo(新番号);
    }

    /**
     * 旧番号を設定します。
     *
     * @param 旧番号 旧番号
     */
    public void set旧番号(RString 旧番号) {
        requireNonNull(旧番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧番号"));
        entity.setKyuNo(旧番号);
    }

    /**
     * 旧市町村コード２を設定します。
     *
     * @param 旧市町村コード２ 旧市町村コード２
     */
    public void set旧市町村コード２(LasdecCode 旧市町村コード２) {
        requireNonNull(旧市町村コード２, UrSystemErrorMessages.値がnull.getReplacedMessage("旧市町村コード２"));
        entity.setKyuShichosonCode(旧市町村コード２);
    }

    /**
     * 旧番号２を設定します。
     *
     * @param 旧番号２ 旧番号２
     */
    public void set旧番号２(RString 旧番号２) {
        requireNonNull(旧番号２, UrSystemErrorMessages.値がnull.getReplacedMessage("旧番号２"));
        entity.setKyuNo2(旧番号２);
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
