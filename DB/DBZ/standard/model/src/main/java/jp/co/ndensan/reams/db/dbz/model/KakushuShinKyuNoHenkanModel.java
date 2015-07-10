/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7028KakushuShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 各種新旧番号変換テーブルのモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class KakushuShinKyuNoHenkanModel implements Serializable {

    private DbT7028KakushuShinKyuNoHenkanEntity entity;

    /**
     * コンストラクタです。
     */
    public KakushuShinKyuNoHenkanModel() {
        entity = new DbT7028KakushuShinKyuNoHenkanEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7028KakushuShinKyuNoHenkanEntity
     */
    public KakushuShinKyuNoHenkanModel(DbT7028KakushuShinKyuNoHenkanEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7028KakushuShinKyuNoHenkanEntityを返します。
     *
     * @return DbT7028KakushuShinKyuNoHenkanEntity
     */
    public DbT7028KakushuShinKyuNoHenkanEntity getEntity() {
        return entity;
    }

    /**
     * DbT7028KakushuShinKyuNoHenkanEntityを設定します。
     *
     * @param entity DbT7028KakushuShinKyuNoHenkanEntity
     */
    public void setEntity(DbT7028KakushuShinKyuNoHenkanEntity entity) {
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
     * 番号区分を返します。
     *
     * @return 番号区分
     */
    public RString get番号区分() {
        return entity.getNoKubun();
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
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 番号区分を設定します。
     *
     * @param 番号区分 番号区分
     */
    public void set番号区分(RString 番号区分) {
        requireNonNull(番号区分, UrSystemErrorMessages.値がnull.getReplacedMessage("番号区分"));
        entity.setNoKubun(番号区分);
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
