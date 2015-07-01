/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5033ShinsakaiIinHoshuTankaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護認定調査委員報酬単価のモデルクラスです。
 *
 * @author LDNS 焦蘇晋
 */
public class ShinsakaiIinHoshuTankaModel implements Serializable {

    private DbT5033ShinsakaiIinHoshuTankaEntity entity;

    /**
     * コンストラクタです。
     */
    public ShinsakaiIinHoshuTankaModel() {
        entity = new DbT5033ShinsakaiIinHoshuTankaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT5033ShinsakaiIinHoshuTankaEntity
     */
    public ShinsakaiIinHoshuTankaModel(DbT5033ShinsakaiIinHoshuTankaEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT5033ShinsakaiIinHoshuTankaEntityを返します。
     *
     * @return DbT5033ShinsakaiIinHoshuTankaEntity
     */
    public DbT5033ShinsakaiIinHoshuTankaEntity getEntity() {
        return entity;
    }

    /**
     * DbT5033ShinsakaiIinHoshuTankaEntityを設定します。
     *
     * @param entity DbT5033ShinsakaiIinHoshuTankaEntity
     */
    public void setEntity(DbT5033ShinsakaiIinHoshuTankaEntity entity) {
        this.entity = entity;
    }

    /**
     * 介護認定審査委員種別を返します。
     *
     * @return 介護認定審査委員種別
     */
    public CodeShubetsu get介護認定審査委員種別() {
        return entity.getKaigoNinteiShinsaIinShubetsu();
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
     * 介護認定審査委員種別を設定します。
     *
     * @param 介護認定審査委員種別 介護認定審査委員種別
     */
    public void set介護認定審査委員種別(CodeShubetsu 介護認定審査委員種別) {
        requireNonNull(介護認定審査委員種別, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査委員種別"));
        entity.setKaigoNinteiShinsaIinShubetsu(介護認定審査委員種別);
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
