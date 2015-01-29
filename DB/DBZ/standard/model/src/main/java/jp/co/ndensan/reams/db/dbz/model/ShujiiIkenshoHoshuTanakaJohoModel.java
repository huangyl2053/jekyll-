/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7108ShujiiIkenshoHoshuTanakaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定主治医意見書報酬単価情報のモデルクラスです。
 *
 * @author LDNS 宋文娟
 */
public class ShujiiIkenshoHoshuTanakaJohoModel implements Serializable {

    private DbT7108ShujiiIkenshoHoshuTanakaJohoEntity entity;

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoHoshuTanakaJohoModel() {
        entity = new DbT7108ShujiiIkenshoHoshuTanakaJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7108ShujiiIkenshoHoshuTanakaJohoEntity
     */
    public ShujiiIkenshoHoshuTanakaJohoModel(DbT7108ShujiiIkenshoHoshuTanakaJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7108ShujiiIkenshoHoshuTanakaJohoEntityを返します。
     *
     * @return DbT7108ShujiiIkenshoHoshuTanakaJohoEntity
     */
    public DbT7108ShujiiIkenshoHoshuTanakaJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT7108ShujiiIkenshoHoshuTanakaJohoEntityを設定します。
     *
     * @param entity DbT7108ShujiiIkenshoHoshuTanakaJohoEntity
     */
    public void setEntity(DbT7108ShujiiIkenshoHoshuTanakaJohoEntity entity) {
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
     * 医師区分を返します。
     *
     * @return 医師区分
     */
    public Code get医師区分() {
        return entity.getIshiKubunCode();
    }

    /**
     * 意見書作成回数を返します。
     *
     * @return 意見書作成回数
     */
    public int get意見書作成回数() {
        return entity.getIkenshoSakuseiKaisu();
    }

    /**
     * 意見書作成料種別を返します。
     *
     * @return 意見書作成料種別
     */
    public RString get意見書作成料種別() {
        return entity.getIkenshoSakuseiryoShubetsu();
    }

    /**
     * 主治医意見書作成料単価を返します。
     *
     * @return 主治医意見書作成料単価
     */
    public int get主治医意見書作成料単価() {
        return entity.getShujiiIkenshoSakuseiryoTanka();
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
     * 医師区分を設定します。
     *
     * @param 医師区分 医師区分
     */
    public void set医師区分(Code 医師区分) {
        requireNonNull(医師区分, UrSystemErrorMessages.値がnull.getReplacedMessage("医師区分"));
        entity.setIshiKubunCode(医師区分);
    }

    /**
     * 意見書作成回数を設定します。
     *
     * @param 意見書作成回数 意見書作成回数
     */
    public void set意見書作成回数(int 意見書作成回数) {
        requireNonNull(意見書作成回数, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書作成回数"));
        entity.setIkenshoSakuseiKaisu(意見書作成回数);
    }

    /**
     * 意見書作成料種別を設定します。
     *
     * @param 意見書作成料種別 意見書作成料種別
     */
    public void set意見書作成料種別(RString 意見書作成料種別) {
        requireNonNull(意見書作成料種別, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書作成料種別"));
        entity.setIkenshoSakuseiryoShubetsu(意見書作成料種別);
    }

    /**
     * 主治医意見書作成料単価を設定します。
     *
     * @param 主治医意見書作成料単価 主治医意見書作成料単価
     */
    public void set主治医意見書作成料単価(int 主治医意見書作成料単価) {
        requireNonNull(主治医意見書作成料単価, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成料単価"));
        entity.setShujiiIkenshoSakuseiryoTanka(主治医意見書作成料単価);
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
