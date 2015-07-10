/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 新旧医療機関主治医番号変換テーブルのモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class ShinKyuIryoKikanShujiiNoHenkanModel implements Serializable {

    private DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity;

    /**
     * コンストラクタです。
     */
    public ShinKyuIryoKikanShujiiNoHenkanModel() {
        entity = new DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity
     */
    public ShinKyuIryoKikanShujiiNoHenkanModel(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityを返します。
     *
     * @return DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity
     */
    public DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity getEntity() {
        return entity;
    }

    /**
     * DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityを設定します。
     *
     * @param entity DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity
     */
    public void setEntity(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity) {
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
     * 新医療機関番号を返します。
     *
     * @return 新医療機関番号
     */
    public RString get新医療機関番号() {
        return entity.getShinIryoKikanNo();
    }

    /**
     * 新主治医番号を返します。
     *
     * @return 新主治医番号
     */
    public RString get新主治医番号() {
        return entity.getShinShujiiNo();
    }

    /**
     * 旧医療機関番号を返します。
     *
     * @return 旧医療機関番号
     */
    public RString get旧医療機関番号() {
        return entity.getKyuIryoKikanNo();
    }

    /**
     * 旧主治医番号を返します。
     *
     * @return 旧主治医番号
     */
    public RString get旧主治医番号() {
        return entity.getKyuShujiiNo();
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
     * 旧医療機関番号２を返します。
     *
     * @return 旧医療機関番号２
     */
    public RString get旧医療機関番号２() {
        return entity.getKyuIryoKikanNo2();
    }

    /**
     * 旧主治医番号２を返します。
     *
     * @return 旧主治医番号２
     */
    public RString get旧主治医番号２() {
        return entity.getKyuShujiiNo2();
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
     * 新医療機関番号を設定します。
     *
     * @param 新医療機関番号 新医療機関番号
     */
    public void set新医療機関番号(RString 新医療機関番号) {
        requireNonNull(新医療機関番号, UrSystemErrorMessages.値がnull.getReplacedMessage("新医療機関番号"));
        entity.setShinIryoKikanNo(新医療機関番号);
    }

    /**
     * 新主治医番号を設定します。
     *
     * @param 新主治医番号 新主治医番号
     */
    public void set新主治医番号(RString 新主治医番号) {
        requireNonNull(新主治医番号, UrSystemErrorMessages.値がnull.getReplacedMessage("新主治医番号"));
        entity.setShinShujiiNo(新主治医番号);
    }

    /**
     * 旧医療機関番号を設定します。
     *
     * @param 旧医療機関番号 旧医療機関番号
     */
    public void set旧医療機関番号(RString 旧医療機関番号) {
        requireNonNull(旧医療機関番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧医療機関番号"));
        entity.setKyuIryoKikanNo(旧医療機関番号);
    }

    /**
     * 旧主治医番号を設定します。
     *
     * @param 旧主治医番号 旧主治医番号
     */
    public void set旧主治医番号(RString 旧主治医番号) {
        requireNonNull(旧主治医番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧主治医番号"));
        entity.setKyuShujiiNo(旧主治医番号);
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
     * 旧医療機関番号２を設定します。
     *
     * @param 旧医療機関番号２ 旧医療機関番号２
     */
    public void set旧医療機関番号２(RString 旧医療機関番号２) {
        requireNonNull(旧医療機関番号２, UrSystemErrorMessages.値がnull.getReplacedMessage("旧医療機関番号２"));
        entity.setKyuIryoKikanNo2(旧医療機関番号２);
    }

    /**
     * 旧主治医番号２を設定します。
     *
     * @param 旧主治医番号２ 旧主治医番号２
     */
    public void set旧主治医番号２(RString 旧主治医番号２) {
        requireNonNull(旧主治医番号２, UrSystemErrorMessages.値がnull.getReplacedMessage("旧主治医番号２"));
        entity.setKyuShujiiNo2(旧主治医番号２);
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
