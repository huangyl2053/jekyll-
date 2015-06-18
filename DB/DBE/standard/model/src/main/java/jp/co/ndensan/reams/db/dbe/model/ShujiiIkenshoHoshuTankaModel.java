/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5032ShujiiIkenshoHoshuTankaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 意見書作成報酬単価のモデルクラスです。
 *
 * @author LDNS 焦蘇晋
 */
public class ShujiiIkenshoHoshuTankaModel implements Serializable {

    private DbT5032ShujiiIkenshoHoshuTankaEntity entity;

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoHoshuTankaModel() {
        entity = new DbT5032ShujiiIkenshoHoshuTankaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT5032ShujiiIkenshoHoshuTankaEntity
     */
    public ShujiiIkenshoHoshuTankaModel(DbT5032ShujiiIkenshoHoshuTankaEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT5032ShujiiIkenshoHoshuTankaEntityを返します。
     *
     * @return DbT5032ShujiiIkenshoHoshuTankaEntity
     */
    public DbT5032ShujiiIkenshoHoshuTankaEntity getEntity() {
        return entity;
    }

    /**
     * DbT5032ShujiiIkenshoHoshuTankaEntityを設定します。
     *
     * @param entity DbT5032ShujiiIkenshoHoshuTankaEntity
     */
    public void setEntity(DbT5032ShujiiIkenshoHoshuTankaEntity entity) {
        this.entity = entity;
    }

    /**
     * 在宅施設区分を返します。
     *
     * @return 在宅施設区分
     */
    public Code get在宅施設区分() {
        return entity.getZaitakuShisetsuKubun();
    }

    /**
     * 意見書作成回数区分を返します。
     *
     * @return 意見書作成回数区分
     */
    public Code get意見書作成回数区分() {
        return entity.getIkenshoSakuseiKaisuKubun();
    }

    /**
     * 開始年月を返します。
     *
     * @return 開始年月
     */
    public FlexibleYearMonth get開始年月() {
        return entity.getKaishiYM();
    }

    /**
     * 終了年月を返します。
     *
     * @return 終了年月
     */
    public FlexibleYearMonth get終了年月() {
        return entity.getShuryoYM();
    }

    /**
     * 単価を返します。
     *
     * @return 単価
     */
    public Decimal get単価() {
        return entity.getTanka();
    }

    /**
     * 在宅施設区分を設定します。
     *
     * @param 在宅施設区分 在宅施設区分
     */
    public void set在宅施設区分(Code 在宅施設区分) {
        requireNonNull(在宅施設区分, UrSystemErrorMessages.値がnull.getReplacedMessage("在宅施設区分"));
        entity.setZaitakuShisetsuKubun(在宅施設区分);
    }

    /**
     * 意見書作成回数区分を設定します。
     *
     * @param 意見書作成回数区分 意見書作成回数区分
     */
    public void set意見書作成回数区分(Code 意見書作成回数区分) {
        requireNonNull(意見書作成回数区分, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書作成回数区分"));
        entity.setIkenshoSakuseiKaisuKubun(意見書作成回数区分);
    }

    /**
     * 開始年月を設定します。
     *
     * @param 開始年月 開始年月
     */
    public void set開始年月(FlexibleYearMonth 開始年月) {
        requireNonNull(開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月"));
        entity.setKaishiYM(開始年月);
    }

    /**
     * 終了年月を設定します。
     *
     * @param 終了年月 終了年月
     */
    public void set終了年月(FlexibleYearMonth 終了年月) {
        requireNonNull(終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月"));
        entity.setShuryoYM(終了年月);
    }

    /**
     * 単価を設定します。
     *
     * @param 単価 単価
     */
    public void set単価(Decimal 単価) {
        requireNonNull(単価, UrSystemErrorMessages.値がnull.getReplacedMessage("単価"));
        entity.setTanka(単価);
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
