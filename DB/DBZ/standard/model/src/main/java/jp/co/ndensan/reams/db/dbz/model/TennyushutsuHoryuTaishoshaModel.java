/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1010TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 転入保留対象者のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class TennyushutsuHoryuTaishoshaModel implements Serializable {

    private DbT1010TennyushutsuHoryuTaishoshaEntity entity;

    /**
     * コンストラクタです。
     */
    public TennyushutsuHoryuTaishoshaModel() {
        entity = new DbT1010TennyushutsuHoryuTaishoshaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT1010TennyushutsuHoryuTaishoshaEntity
     */
    public TennyushutsuHoryuTaishoshaModel(DbT1010TennyushutsuHoryuTaishoshaEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT1010TennyushutsuHoryuTaishoshaEntityを返します。
     *
     * @return DbT1010TennyushutsuHoryuTaishoshaEntity
     */
    public DbT1010TennyushutsuHoryuTaishoshaEntity getEntity() {
        return entity;
    }

    /**
     * DbT1010TennyushutsuHoryuTaishoshaEntityを設定します。
     *
     * @param entity DbT1010TennyushutsuHoryuTaishoshaEntity
     */
    public void setEntity(DbT1010TennyushutsuHoryuTaishoshaEntity entity) {
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
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimeStamp();
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
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimeStamp(処理日時);
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
