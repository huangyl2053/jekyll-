/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7102ZeiritsuJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 税率情報のモデルクラスです。
 *
 * @author LDNS 宋文娟
 */
public class ZeiritsuJohoModel implements Serializable {

    private DbT7102ZeiritsuJohoEntity entity;

    /**
     * コンストラクタです。
     */
    public ZeiritsuJohoModel() {
        entity = new DbT7102ZeiritsuJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7102ZeiritsuJohoEntity
     */
    public ZeiritsuJohoModel(DbT7102ZeiritsuJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7102ZeiritsuJohoEntityを返します。
     *
     * @return DbT7102ZeiritsuJohoEntity
     */
    public DbT7102ZeiritsuJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT7102ZeiritsuJohoEntityを設定します。
     *
     * @param entity DbT7102ZeiritsuJohoEntity
     */
    public void setEntity(DbT7102ZeiritsuJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 税率を返します。
     *
     * @return 税率
     */
    public int get税率() {
        return entity.getZeiritsu();
    }

    /**
     * 開始年月を返します。
     *
     * @return 開始年月
     */
    public FlexibleDate get開始年月() {
        return entity.getZeiritsuKaishiYMD();
    }

    /**
     * 終了年月を返します。
     *
     * @return 終了年月
     */
    public FlexibleDate get終了年月() {
        return entity.getZeiritsuShuryoYMD();
    }

    /**
     * 税率を設定します。
     *
     * @param 税率 税率
     */
    public void set税率(int 税率) {
        requireNonNull(税率, UrSystemErrorMessages.値がnull.getReplacedMessage("税率"));
        entity.setZeiritsu(税率);
    }

    /**
     * 開始年月を設定します。
     *
     * @param 開始年月 開始年月
     */
    public void set開始年月(FlexibleDate 開始年月) {
        requireNonNull(開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月"));
        entity.setZeiritsuKaishiYMD(開始年月);
    }

    /**
     * 終了年月を設定します。
     *
     * @param 終了年月 終了年月
     */
    public void set終了年月(FlexibleDate 終了年月) {
        requireNonNull(終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月"));
        entity.setZeiritsuShuryoYMD(終了年月);
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
