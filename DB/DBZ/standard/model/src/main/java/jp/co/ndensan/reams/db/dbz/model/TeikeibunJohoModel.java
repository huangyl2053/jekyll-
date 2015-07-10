/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7103TeikeibunJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 定型文情報のモデルクラスです。
 *
 * @author LDNS 宋文娟
 */
public class TeikeibunJohoModel implements Serializable {

    private DbT7103TeikeibunJohoEntity entity;

    /**
     * コンストラクタです。
     */
    public TeikeibunJohoModel() {
        entity = new DbT7103TeikeibunJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7103TeikeibunJohoEntity
     */
    public TeikeibunJohoModel(DbT7103TeikeibunJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7103TeikeibunJohoEntityを返します。
     *
     * @return DbT7103TeikeibunJohoEntity
     */
    public DbT7103TeikeibunJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT7103TeikeibunJohoEntityを設定します。
     *
     * @param entity DbT7103TeikeibunJohoEntity
     */
    public void setEntity(DbT7103TeikeibunJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 定型区分を返します。
     *
     * @return 定型区分
     */
    public RString get定型区分() {
        return entity.getTeikeiKubun();
    }

    /**
     * 種別を返します。
     *
     * @return 種別
     */
    public RString get種別() {
        return entity.getShubetsu();
    }

    /**
     * 定型文コードを返します。
     *
     * @return 定型文コード
     */
    public RString get定型文コード() {
        return entity.getTeikeibunCd();
    }

    /**
     * 定型文内容を返します。
     *
     * @return 定型文内容
     */
    public RString get定型文内容() {
        return entity.getTeikeibunNaiyo();
    }

    /**
     * 定型区分を設定します。
     *
     * @param 定型区分 定型区分
     */
    public void set定型区分(RString 定型区分) {
        requireNonNull(定型区分, UrSystemErrorMessages.値がnull.getReplacedMessage("定型区分"));
        entity.setTeikeiKubun(定型区分);
    }

    /**
     * 種別を設定します。
     *
     * @param 種別 種別
     */
    public void set種別(RString 種別) {
        requireNonNull(種別, UrSystemErrorMessages.値がnull.getReplacedMessage("種別"));
        entity.setShubetsu(種別);
    }

    /**
     * 定型文コードを設定します。
     *
     * @param 定型文コード 定型文コード
     */
    public void set定型文コード(RString 定型文コード) {
        requireNonNull(定型文コード, UrSystemErrorMessages.値がnull.getReplacedMessage("定型文コード"));
        entity.setTeikeibunCd(定型文コード);
    }

    /**
     * 定型文内容を設定します。
     *
     * @param 定型文内容 定型文内容
     */
    public void set定型文内容(RString 定型文内容) {
        requireNonNull(定型文内容, UrSystemErrorMessages.値がnull.getReplacedMessage("定型文内容"));
        entity.setTeikeibunNaiyo(定型文内容);
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
