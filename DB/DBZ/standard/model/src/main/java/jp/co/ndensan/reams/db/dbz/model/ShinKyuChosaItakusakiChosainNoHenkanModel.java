/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 新旧調査委託先調査員番号変換テーブルのモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class ShinKyuChosaItakusakiChosainNoHenkanModel implements Serializable {

    private DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity;

    /**
     * コンストラクタです。
     */
    public ShinKyuChosaItakusakiChosainNoHenkanModel() {
        entity = new DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity
     */
    public ShinKyuChosaItakusakiChosainNoHenkanModel(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityを返します。
     *
     * @return DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity
     */
    public DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity getEntity() {
        return entity;
    }

    /**
     * DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityを設定します。
     *
     * @param entity DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity
     */
    public void setEntity(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity) {
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
     * 新調査委託先番号を返します。
     *
     * @return 新調査委託先番号
     */
    public RString get新調査委託先番号() {
        return entity.getShinChosaItakusakiNo();
    }

    /**
     * 新調査員番号を返します。
     *
     * @return 新調査員番号
     */
    public RString get新調査員番号() {
        return entity.getShinChosainNo();
    }

    /**
     * 旧調査委託先番号を返します。
     *
     * @return 旧調査委託先番号
     */
    public RString get旧調査委託先番号() {
        return entity.getKyuChosaItakusakiNo();
    }

    /**
     * 旧調査員番号を返します。
     *
     * @return 旧調査員番号
     */
    public RString get旧調査員番号() {
        return entity.getKyuChosainNo();
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
     * 旧調査委託先番号２を返します。
     *
     * @return 旧調査委託先番号２
     */
    public RString get旧調査委託先番号２() {
        return entity.getKyuChosaItakusakiNo2();
    }

    /**
     * 旧調査員番号２を返します。
     *
     * @return 旧調査員番号２
     */
    public RString get旧調査員番号２() {
        return entity.getKyuChosainNo2();
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
     * 新調査委託先番号を設定します。
     *
     * @param 新調査委託先番号 新調査委託先番号
     */
    public void set新調査委託先番号(RString 新調査委託先番号) {
        requireNonNull(新調査委託先番号, UrSystemErrorMessages.値がnull.getReplacedMessage("新調査委託先番号"));
        entity.setShinChosaItakusakiNo(新調査委託先番号);
    }

    /**
     * 新調査員番号を設定します。
     *
     * @param 新調査員番号 新調査員番号
     */
    public void set新調査員番号(RString 新調査員番号) {
        requireNonNull(新調査員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("新調査員番号"));
        entity.setShinChosainNo(新調査員番号);
    }

    /**
     * 旧調査委託先番号を設定します。
     *
     * @param 旧調査委託先番号 旧調査委託先番号
     */
    public void set旧調査委託先番号(RString 旧調査委託先番号) {
        requireNonNull(旧調査委託先番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧調査委託先番号"));
        entity.setKyuChosaItakusakiNo(旧調査委託先番号);
    }

    /**
     * 旧調査員番号を設定します。
     *
     * @param 旧調査員番号 旧調査員番号
     */
    public void set旧調査員番号(RString 旧調査員番号) {
        requireNonNull(旧調査員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧調査員番号"));
        entity.setKyuChosainNo(旧調査員番号);
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
     * 旧調査委託先番号２を設定します。
     *
     * @param 旧調査委託先番号２ 旧調査委託先番号２
     */
    public void set旧調査委託先番号２(RString 旧調査委託先番号２) {
        requireNonNull(旧調査委託先番号２, UrSystemErrorMessages.値がnull.getReplacedMessage("旧調査委託先番号２"));
        entity.setKyuChosaItakusakiNo2(旧調査委託先番号２);
    }

    /**
     * 旧調査員番号２を設定します。
     *
     * @param 旧調査員番号２ 旧調査員番号２
     */
    public void set旧調査員番号２(RString 旧調査員番号２) {
        requireNonNull(旧調査員番号２, UrSystemErrorMessages.値がnull.getReplacedMessage("旧調査員番号２"));
        entity.setKyuChosainNo2(旧調査員番号２);
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
