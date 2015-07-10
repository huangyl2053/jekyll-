/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額介護サービス費支給審査決定のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class KogakuShikyuShinsaKetteiModel implements Serializable {

    private DbT3058KogakuShikyuShinsaKetteiEntity entity;

    /**
     * コンストラクタです。
     */
    public KogakuShikyuShinsaKetteiModel() {
        entity = new DbT3058KogakuShikyuShinsaKetteiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3058KogakuShikyuShinsaKetteiEntity
     */
    public KogakuShikyuShinsaKetteiModel(DbT3058KogakuShikyuShinsaKetteiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3058KogakuShikyuShinsaKetteiEntityを返します。
     *
     * @return DbT3058KogakuShikyuShinsaKetteiEntity
     */
    public DbT3058KogakuShikyuShinsaKetteiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3058KogakuShikyuShinsaKetteiEntityを設定します。
     *
     * @param entity DbT3058KogakuShikyuShinsaKetteiEntity
     */
    public void setEntity(DbT3058KogakuShikyuShinsaKetteiEntity entity) {
        this.entity = entity;
    }

    /**
     * 決定者受取年月を返します。
     *
     * @return 決定者受取年月
     */
    public FlexibleYearMonth get決定者受取年月() {
        return entity.getKetteishaUketoriYM();
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
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
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
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    public RString get通知書番号() {
        return entity.getTsuchishoNo();
    }

    /**
     * 利用者負担額を返します。
     *
     * @return 利用者負担額
     */
    public Decimal get利用者負担額() {
        return entity.getRiyoshaFutanGaku();
    }

    /**
     * 支給区分コードを返します。
     *
     * @return 支給区分コード
     */
    public RString get支給区分コード() {
        return entity.getShikyuKubunCode();
    }

    /**
     * 決定年月を返します。
     *
     * @return 決定年月
     */
    public FlexibleYearMonth get決定年月() {
        return entity.getKetteiYM();
    }

    /**
     * 高額支給額を返します。
     *
     * @return 高額支給額
     */
    public Decimal get高額支給額() {
        return entity.getKogakuShikyuGaku();
    }

    /**
     * 決定者受取年月を設定します。
     *
     * @param 決定者受取年月 決定者受取年月
     */
    public void set決定者受取年月(FlexibleYearMonth 決定者受取年月) {
        requireNonNull(決定者受取年月, UrSystemErrorMessages.値がnull.getReplacedMessage("決定者受取年月"));
        entity.setKetteishaUketoriYM(決定者受取年月);
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
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
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
     * 通知書番号を設定します。
     *
     * @param 通知書番号 通知書番号
     */
    public void set通知書番号(RString 通知書番号) {
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        entity.setTsuchishoNo(通知書番号);
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     */
    public void set利用者負担額(Decimal 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutanGaku(利用者負担額);
    }

    /**
     * 支給区分コードを設定します。
     *
     * @param 支給区分コード 支給区分コード
     */
    public void set支給区分コード(RString 支給区分コード) {
        requireNonNull(支給区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支給区分コード"));
        entity.setShikyuKubunCode(支給区分コード);
    }

    /**
     * 決定年月を設定します。
     *
     * @param 決定年月 決定年月
     */
    public void set決定年月(FlexibleYearMonth 決定年月) {
        requireNonNull(決定年月, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月"));
        entity.setKetteiYM(決定年月);
    }

    /**
     * 高額支給額を設定します。
     *
     * @param 高額支給額 高額支給額
     */
    public void set高額支給額(Decimal 高額支給額) {
        requireNonNull(高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("高額支給額"));
        entity.setKogakuShikyuGaku(高額支給額);
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
