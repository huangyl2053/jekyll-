/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.fuka;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護期別徴収猶予のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KibetsuChoshuYuyoModel implements Serializable {

    private DbT2007KibetsuChoshuYuyoEntity entity;

    /**
     * コンストラクタです。
     */
    public KibetsuChoshuYuyoModel() {
        entity = new DbT2007KibetsuChoshuYuyoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT2007KibetsuChoshuYuyoEntity
     */
    public KibetsuChoshuYuyoModel(DbT2007KibetsuChoshuYuyoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT2007KibetsuChoshuYuyoEntityを返します。
     *
     * @return DbT2007KibetsuChoshuYuyoEntity
     */
    public DbT2007KibetsuChoshuYuyoEntity getEntity() {
        return entity;
    }

    /**
     * DbT2007KibetsuChoshuYuyoEntityを設定します。
     *
     * @param entity DbT2007KibetsuChoshuYuyoEntity
     */
    public void setEntity(DbT2007KibetsuChoshuYuyoEntity entity) {
        this.entity = entity;
    }

    /**
     * 調定年度を返します。
     *
     * @return 調定年度
     */
    public ChoteiNendo get調定年度() {
        return new ChoteiNendo(entity.getChoteiNendo());
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FukaNendo get賦課年度() {
        return new FukaNendo(entity.getFukaNendo());
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
    public ChoshuHohoKibetsu get徴収方法() {
        return ChoshuHohoKibetsu.toValue(entity.getChoshuHoho());
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
     * 徴収猶予開始年月日を返します。
     *
     * @return 徴収猶予開始年月日
     */
    public FlexibleDate get徴収猶予開始年月日() {
        return entity.getYuyoStartYMD();
    }

    /**
     * 徴収猶予終了年月日を返します。
     *
     * @return 徴収猶予終了年月日
     */
    public FlexibleDate get徴収猶予終了年月日() {
        return entity.getYuyoEndYMD();
    }

    /**
     * 調定年度を設定します。
     *
     * @param 調定年度 調定年度
     */
    public void set調定年度(ChoteiNendo 調定年度) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        entity.setChoteiNendo(調定年度.value());
    }

    /**
     * 賦課年度を設定します。
     *
     * @param 賦課年度 賦課年度
     */
    public void set賦課年度(FukaNendo 賦課年度) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        entity.setFukaNendo(賦課年度.value());
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
    public void set徴収方法(ChoshuHohoKibetsu 徴収方法) {
        requireNonNull(徴収方法, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法"));
        entity.setChoshuHoho(徴収方法.code());
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
     * 徴収猶予開始年月日を設定します。
     *
     * @param 徴収猶予開始年月日 徴収猶予開始年月日
     */
    public void set徴収猶予開始年月日(FlexibleDate 徴収猶予開始年月日) {
        requireNonNull(徴収猶予開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予開始年月日"));
        entity.setYuyoStartYMD(徴収猶予開始年月日);
    }

    /**
     * 徴収猶予終了年月日を設定します。
     *
     * @param 徴収猶予終了年月日 徴収猶予終了年月日
     */
    public void set徴収猶予終了年月日(FlexibleDate 徴収猶予終了年月日) {
        requireNonNull(徴収猶予終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予終了年月日"));
        entity.setYuyoEndYMD(徴収猶予終了年月日);
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
