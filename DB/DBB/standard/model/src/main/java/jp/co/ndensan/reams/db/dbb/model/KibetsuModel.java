/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.model;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static java.util.Objects.requireNonNull;

/**
 * 介護期別のモデルクラスです。
 *
 * @author N8156 宮本 康
 */
public class KibetsuModel implements Serializable {

    private DbT2003KibetsuEntity entity;

    /**
     * コンストラクタです。
     */
    public KibetsuModel() {
        entity = new DbT2003KibetsuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT2003KibetsuEntity
     */
    public KibetsuModel(DbT2003KibetsuEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT2003KibetsuEntityを返します。
     *
     * @return DbT2003KibetsuEntity
     */
    public DbT2003KibetsuEntity getEntity() {
        return entity;
    }

    /**
     * DbT2003KibetsuEntityを設定します。
     *
     * @param entity DbT2003KibetsuEntity
     */
    public void setEntity(DbT2003KibetsuEntity entity) {
        this.entity = entity;
    }

    /**
     * 調定年度を返します。
     *
     * @return 調定年度
     */
    public FlexibleYear get調定年度() {
        return entity.getChoteiNendo();
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FlexibleYear get賦課年度() {
        return entity.getFukaNendo();
    }

    /**
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    public TsuchishoNo get通知書番号() {
        return entity.getTsuchishoNo();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public RDateTime get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 徴収方法を返します。
     *
     * @return 徴収方法
     */
    public RString get徴収方法() {
        return entity.getChoshuHoho();
    }

    /**
     * 期を返します。
     *
     * @return 期
     */
    public int get期() {
        return entity.getKi();
    }

    /**
     * 調定IDを返します。
     *
     * @return 調定ID
     */
    public long get調定ID() {
        return entity.getChoteiId();
    }

    /**
     * 調定年度を設定します。
     *
     * @param 調定年度 調定年度
     */
    public void set調定年度(FlexibleYear 調定年度) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        entity.setChoteiNendo(調定年度);
    }

    /**
     * 賦課年度を設定します。
     *
     * @param 賦課年度 賦課年度
     */
    public void set賦課年度(FlexibleYear 賦課年度) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        entity.setFukaNendo(賦課年度);
    }

    /**
     * 通知書番号を設定します。
     *
     * @param 通知書番号 通知書番号
     */
    public void set通知書番号(TsuchishoNo 通知書番号) {
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        entity.setTsuchishoNo(通知書番号);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(RDateTime 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 徴収方法を設定します。
     *
     * @param 徴収方法 徴収方法
     */
    public void set徴収方法(RString 徴収方法) {
        requireNonNull(徴収方法, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法"));
        entity.setChoshuHoho(徴収方法);
    }

    /**
     * 期を設定します。
     *
     * @param 期 期
     */
    public void set期(int 期) {
        requireNonNull(期, UrSystemErrorMessages.値がnull.getReplacedMessage("期"));
        entity.setKi(期);
    }

    /**
     * 調定IDを設定します。
     *
     * @param 調定ID 調定ID
     */
    public void set調定ID(long 調定ID) {
        requireNonNull(調定ID, UrSystemErrorMessages.値がnull.getReplacedMessage("調定ID"));
        entity.setChoteiId(調定ID);
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
