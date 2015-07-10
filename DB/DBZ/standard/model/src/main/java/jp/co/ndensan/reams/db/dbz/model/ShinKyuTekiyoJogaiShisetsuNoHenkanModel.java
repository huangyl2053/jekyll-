/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 新旧適用除外施設番号変換テーブルのモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class ShinKyuTekiyoJogaiShisetsuNoHenkanModel implements Serializable {

    private DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity entity;

    /**
     * コンストラクタです。
     */
    public ShinKyuTekiyoJogaiShisetsuNoHenkanModel() {
        entity = new DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity
     */
    public ShinKyuTekiyoJogaiShisetsuNoHenkanModel(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityを返します。
     *
     * @return DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity
     */
    public DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity getEntity() {
        return entity;
    }

    /**
     * DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityを設定します。
     *
     * @param entity DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity
     */
    public void setEntity(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity entity) {
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
     * 新適用除外施設番号を返します。
     *
     * @return 新適用除外施設番号
     */
    public RString get新適用除外施設番号() {
        return entity.getShinTekiyoJogaiShisetsuNo();
    }

    /**
     * 旧適用除外施設番号を返します。
     *
     * @return 旧適用除外施設番号
     */
    public RString get旧適用除外施設番号() {
        return entity.getKyuTekiyoJogaiShisetsuNo();
    }

    /**
     * 市町村コード２を返します。
     *
     * @return 市町村コード２
     */
    public LasdecCode get市町村コード２() {
        return entity.getShichosonCode2();
    }

    /**
     * 旧適用除外施設番号２を返します。
     *
     * @return 旧適用除外施設番号２
     */
    public RString get旧適用除外施設番号２() {
        return entity.getKyuTekiyoJogaiShisetsuNo2();
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
     * 新適用除外施設番号を設定します。
     *
     * @param 新適用除外施設番号 新適用除外施設番号
     */
    public void set新適用除外施設番号(RString 新適用除外施設番号) {
        requireNonNull(新適用除外施設番号, UrSystemErrorMessages.値がnull.getReplacedMessage("新適用除外施設番号"));
        entity.setShinTekiyoJogaiShisetsuNo(新適用除外施設番号);
    }

    /**
     * 旧適用除外施設番号を設定します。
     *
     * @param 旧適用除外施設番号 旧適用除外施設番号
     */
    public void set旧適用除外施設番号(RString 旧適用除外施設番号) {
        requireNonNull(旧適用除外施設番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧適用除外施設番号"));
        entity.setKyuTekiyoJogaiShisetsuNo(旧適用除外施設番号);
    }

    /**
     * 市町村コード２を設定します。
     *
     * @param 市町村コード２ 市町村コード２
     */
    public void set市町村コード２(LasdecCode 市町村コード２) {
        requireNonNull(市町村コード２, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード２"));
        entity.setShichosonCode2(市町村コード２);
    }

    /**
     * 旧適用除外施設番号２を設定します。
     *
     * @param 旧適用除外施設番号２ 旧適用除外施設番号２
     */
    public void set旧適用除外施設番号２(RString 旧適用除外施設番号２) {
        requireNonNull(旧適用除外施設番号２, UrSystemErrorMessages.値がnull.getReplacedMessage("旧適用除外施設番号２"));
        entity.setKyuTekiyoJogaiShisetsuNo2(旧適用除外施設番号２);
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
