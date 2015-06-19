/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5031NinteiChosaHoshuTankaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査報酬単価のモデルクラスです。
 *
 * @author LDNS 焦蘇晋
 */
public class NinteiChosaHoshuTankaModel implements Serializable {

    private DbT5031NinteiChosaHoshuTankaEntity entity;

    /**
     * コンストラクタです。
     */
    public NinteiChosaHoshuTankaModel() {
        entity = new DbT5031NinteiChosaHoshuTankaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT5031NinteiChosaHoshuTankaEntity
     */
    public NinteiChosaHoshuTankaModel(DbT5031NinteiChosaHoshuTankaEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT5031NinteiChosaHoshuTankaEntityを返します。
     *
     * @return DbT5031NinteiChosaHoshuTankaEntity
     */
    public DbT5031NinteiChosaHoshuTankaEntity getEntity() {
        return entity;
    }

    /**
     * DbT5031NinteiChosaHoshuTankaEntityを設定します。
     *
     * @param entity DbT5031NinteiChosaHoshuTankaEntity
     */
    public void setEntity(DbT5031NinteiChosaHoshuTankaEntity entity) {
        this.entity = entity;
    }

    /**
     * 調査区分を返します。
     *
     * @return 調査区分
     */
    public Code get調査区分() {
        return entity.getChosaKubun();
    }

    /**
     * 訪問種別を返します。
     *
     * @return 訪問種別
     */
    public Code get訪問種別() {
        return entity.getHomonShubetsu();
    }

    /**
     * 意見書入手パターンを返します。
     *
     * @return 意見書入手パターン
     */
    public Code get意見書入手パターン() {
        return entity.getIkenshoNyushuPatern();
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
     * 調査区分を設定します。
     *
     * @param 調査区分 調査区分
     */
    public void set調査区分(Code 調査区分) {
        requireNonNull(調査区分, UrSystemErrorMessages.値がnull.getReplacedMessage("調査区分"));
        entity.setChosaKubun(調査区分);
    }

    /**
     * 訪問種別を設定します。
     *
     * @param 訪問種別 訪問種別
     */
    public void set訪問種別(Code 訪問種別) {
        requireNonNull(訪問種別, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問種別"));
        entity.setHomonShubetsu(訪問種別);
    }

    /**
     * 意見書入手パターンを設定します。
     *
     * @param 意見書入手パターン 意見書入手パターン
     */
    public void set意見書入手パターン(Code 意見書入手パターン) {
        requireNonNull(意見書入手パターン, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書入手パターン"));
        entity.setIkenshoNyushuPatern(意見書入手パターン);
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
