/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7107ShinsainHoshuTankaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定審査員報酬単価情報のモデルクラスです。
 *
 * @author LDNS 宋文娟
 */
public class ShinsainHoshuTankaJohoModel implements Serializable {

    private DbT7107ShinsainHoshuTankaJohoEntity entity;

    /**
     * コンストラクタです。
     */
    public ShinsainHoshuTankaJohoModel() {
        entity = new DbT7107ShinsainHoshuTankaJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7107ShinsainHoshuTankaJohoEntity
     */
    public ShinsainHoshuTankaJohoModel(DbT7107ShinsainHoshuTankaJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7107ShinsainHoshuTankaJohoEntityを返します。
     *
     * @return DbT7107ShinsainHoshuTankaJohoEntity
     */
    public DbT7107ShinsainHoshuTankaJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT7107ShinsainHoshuTankaJohoEntityを設定します。
     *
     * @param entity DbT7107ShinsainHoshuTankaJohoEntity
     */
    public void setEntity(DbT7107ShinsainHoshuTankaJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 報酬単価適用開始年月日を返します。
     *
     * @return 報酬単価適用開始年月日
     */
    public FlexibleDate get報酬単価適用開始年月日() {
        return entity.getHoshuTankaTekiyoKaishiYMD();
    }

    /**
     * 報酬単価適用終了年月日を返します。
     *
     * @return 報酬単価適用終了年月日
     */
    public FlexibleDate get報酬単価適用終了年月日() {
        return entity.getHoshuTankaTekiyoShuryoYMD();
    }

    /**
     * 合議体長区分を返します。
     *
     * @return 合議体長区分
     */
    public Code get合議体長区分() {
        return entity.getGogitaiChoKubunCode();
    }

    /**
     * 介護認定審査報酬単価を返します。
     *
     * @return 介護認定審査報酬単価
     */
    public int get介護認定審査報酬単価() {
        return entity.getNinteiShinsaHoshuTanka();
    }

    /**
     * 課税非課税区分を返します。
     *
     * @return 課税非課税区分
     */
    public RString get課税非課税区分() {
        return entity.getKazeiHikazeiKubun();
    }

    /**
     * 報酬単価適用開始年月日を設定します。
     *
     * @param 報酬単価適用開始年月日 報酬単価適用開始年月日
     */
    public void set報酬単価適用開始年月日(FlexibleDate 報酬単価適用開始年月日) {
        requireNonNull(報酬単価適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("報酬単価適用開始年月日"));
        entity.setHoshuTankaTekiyoKaishiYMD(報酬単価適用開始年月日);
    }

    /**
     * 報酬単価適用終了年月日を設定します。
     *
     * @param 報酬単価適用終了年月日 報酬単価適用終了年月日
     */
    public void set報酬単価適用終了年月日(FlexibleDate 報酬単価適用終了年月日) {
        requireNonNull(報酬単価適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("報酬単価適用終了年月日"));
        entity.setHoshuTankaTekiyoShuryoYMD(報酬単価適用終了年月日);
    }

    /**
     * 合議体長区分を設定します。
     *
     * @param 合議体長区分 合議体長区分
     */
    public void set合議体長区分(Code 合議体長区分) {
        requireNonNull(合議体長区分, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体長区分"));
        entity.setGogitaiChoKubunCode(合議体長区分);
    }

    /**
     * 介護認定審査報酬単価を設定します。
     *
     * @param 介護認定審査報酬単価 介護認定審査報酬単価
     */
    public void set介護認定審査報酬単価(int 介護認定審査報酬単価) {
        requireNonNull(介護認定審査報酬単価, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査報酬単価"));
        entity.setNinteiShinsaHoshuTanka(介護認定審査報酬単価);
    }

    /**
     * 課税非課税区分を設定します。
     *
     * @param 課税非課税区分 課税非課税区分
     */
    public void set課税非課税区分(RString 課税非課税区分) {
        requireNonNull(課税非課税区分, UrSystemErrorMessages.値がnull.getReplacedMessage("課税非課税区分"));
        entity.setKazeiHikazeiKubun(課税非課税区分);
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
