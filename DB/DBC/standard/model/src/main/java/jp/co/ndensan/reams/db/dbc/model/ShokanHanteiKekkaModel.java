/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払支給判定結果のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class ShokanHanteiKekkaModel implements Serializable {

    private DbT3036ShokanHanteiKekkaEntity entity;

    /**
     * コンストラクタです。
     */
    public ShokanHanteiKekkaModel() {
        entity = new DbT3036ShokanHanteiKekkaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3036ShokanHanteiKekkaEntity
     */
    public ShokanHanteiKekkaModel(DbT3036ShokanHanteiKekkaEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3036ShokanHanteiKekkaEntityを返します。
     *
     * @return DbT3036ShokanHanteiKekkaEntity
     */
    public DbT3036ShokanHanteiKekkaEntity getEntity() {
        return entity;
    }

    /**
     * DbT3036ShokanHanteiKekkaEntityを設定します。
     *
     * @param entity DbT3036ShokanHanteiKekkaEntity
     */
    public void setEntity(DbT3036ShokanHanteiKekkaEntity entity) {
        this.entity = entity;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHiHokenshaNo();
    }

    /**
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNo();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 決定年月日を返します。
     *
     * @return 決定年月日
     */
    public FlexibleDate get決定年月日() {
        return entity.getKetteiYMD();
    }

    /**
     * 支給_不支給決定区分を返します。
     *
     * @return 支給_不支給決定区分
     */
    public RString get支給_不支給決定区分() {
        return entity.getShikyuHushikyuKetteiKubun();
    }

    /**
     * 支払金額を返します。
     *
     * @return 支払金額
     */
    public Decimal get支払金額() {
        return entity.getShiharaiKingaku();
    }

    /**
     * 支払金額内訳_利用者分を返します。
     *
     * @return 支払金額内訳_利用者分
     */
    public Decimal get支払金額内訳_利用者分() {
        return entity.getShiharaiKingakuUchiwakeRiyoshabun();
    }

    /**
     * 決定一覧取込年月を返します。
     *
     * @return 決定一覧取込年月
     */
    public FlexibleYearMonth get決定一覧取込年月() {
        return entity.getKetteiIchiranTorikomiYM();
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     */
    public void setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     */
    public void set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     */
    public void set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
    }

    /**
     * 支給_不支給決定区分を設定します。
     *
     * @param 支給_不支給決定区分 支給_不支給決定区分
     */
    public void set支給_不支給決定区分(RString 支給_不支給決定区分) {
        requireNonNull(支給_不支給決定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("支給_不支給決定区分"));
        entity.setShikyuHushikyuKetteiKubun(支給_不支給決定区分);
    }

    /**
     * 支払金額を設定します。
     *
     * @param 支払金額 支払金額
     */
    public void set支払金額(Decimal 支払金額) {
        requireNonNull(支払金額, UrSystemErrorMessages.値がnull.getReplacedMessage("支払金額"));
        entity.setShiharaiKingaku(支払金額);
    }

    /**
     * 支払金額内訳_利用者分を設定します。
     *
     * @param 支払金額内訳_利用者分 支払金額内訳_利用者分
     */
    public void set支払金額内訳_利用者分(Decimal 支払金額内訳_利用者分) {
        requireNonNull(支払金額内訳_利用者分, UrSystemErrorMessages.値がnull.getReplacedMessage("支払金額内訳_利用者分"));
        entity.setShiharaiKingakuUchiwakeRiyoshabun(支払金額内訳_利用者分);
    }

    /**
     * 決定一覧取込年月を設定します。
     *
     * @param 決定一覧取込年月 決定一覧取込年月
     */
    public void set決定一覧取込年月(FlexibleYearMonth 決定一覧取込年月) {
        requireNonNull(決定一覧取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("決定一覧取込年月"));
        entity.setKetteiIchiranTorikomiYM(決定一覧取込年月);
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
