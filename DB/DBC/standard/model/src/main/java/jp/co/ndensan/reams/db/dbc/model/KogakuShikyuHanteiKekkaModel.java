/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額介護サービス費支給判定結果のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class KogakuShikyuHanteiKekkaModel implements Serializable {

    private DbT3057KogakuShikyuHanteiKekkaEntity entity;

    /**
     * コンストラクタです。
     */
    public KogakuShikyuHanteiKekkaModel() {
        entity = new DbT3057KogakuShikyuHanteiKekkaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3057KogakuShikyuHanteiKekkaEntity
     */
    public KogakuShikyuHanteiKekkaModel(DbT3057KogakuShikyuHanteiKekkaEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3057KogakuShikyuHanteiKekkaEntityを返します。
     *
     * @return DbT3057KogakuShikyuHanteiKekkaEntity
     */
    public DbT3057KogakuShikyuHanteiKekkaEntity getEntity() {
        return entity;
    }

    /**
     * DbT3057KogakuShikyuHanteiKekkaEntityを設定します。
     *
     * @param entity DbT3057KogakuShikyuHanteiKekkaEntity
     */
    public void setEntity(DbT3057KogakuShikyuHanteiKekkaEntity entity) {
        this.entity = entity;
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
     * 本人支払額を返します。
     *
     * @return 本人支払額
     */
    public Decimal get本人支払額() {
        return entity.getHonninShiharaiGaku();
    }

    /**
     * 支給区分コードを返します。
     *
     * @return 支給区分コード
     */
    public RString get支給区分コード() {
        return entity.getShiharaiKubunCode();
    }

    /**
     * 支給金額を返します。
     *
     * @return 支給金額
     */
    public Decimal get支給金額() {
        return entity.getShiharaiKingaku();
    }

    /**
     * 不支給理由を返します。
     *
     * @return 不支給理由
     */
    public RString get不支給理由() {
        return entity.getFushikyuRiyu();
    }

    /**
     * 審査方法区分を返します。
     *
     * @return 審査方法区分
     */
    public RString get審査方法区分() {
        return entity.getShinsaHohoKubun();
    }

    /**
     * 判定結果送付年月を返します。
     *
     * @return 判定結果送付年月
     */
    public FlexibleYearMonth get判定結果送付年月() {
        return entity.getHanteiKekkaSofuYM();
    }

    /**
     * 再送付フラグを返します。
     *
     * @return 再送付フラグ
     */
    public boolean get再送付フラグ() {
        return entity.getSaiSofuFlag();
    }

    /**
     * 判定結果送付不要フラグを返します。
     *
     * @return 判定結果送付不要フラグ
     */
    public boolean get判定結果送付不要フラグ() {
        return entity.getHanteiKekkaSofuFuyoFlag();
    }

    /**
     * 審査結果反映区分を返します。
     *
     * @return 審査結果反映区分
     */
    public RString get審査結果反映区分() {
        return entity.getShinsaKekkaHaneiKubun();
    }

    /**
     * 決定通知書作成年月日を返します。
     *
     * @return 決定通知書作成年月日
     */
    public FlexibleDate get決定通知書作成年月日() {
        return entity.getKetteiTsuchishoSakuseiYMD();
    }

    /**
     * 振込明細書作成年月日を返します。
     *
     * @return 振込明細書作成年月日
     */
    public FlexibleDate get振込明細書作成年月日() {
        return entity.getFurikomiMeisaishoSakuseiYMD();
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
     * 本人支払額を設定します。
     *
     * @param 本人支払額 本人支払額
     */
    public void set本人支払額(Decimal 本人支払額) {
        requireNonNull(本人支払額, UrSystemErrorMessages.値がnull.getReplacedMessage("本人支払額"));
        entity.setHonninShiharaiGaku(本人支払額);
    }

    /**
     * 支給区分コードを設定します。
     *
     * @param 支給区分コード 支給区分コード
     */
    public void set支給区分コード(RString 支給区分コード) {
        requireNonNull(支給区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支給区分コード"));
        entity.setShiharaiKubunCode(支給区分コード);
    }

    /**
     * 支給金額を設定します。
     *
     * @param 支給金額 支給金額
     */
    public void set支給金額(Decimal 支給金額) {
        requireNonNull(支給金額, UrSystemErrorMessages.値がnull.getReplacedMessage("支給金額"));
        entity.setShiharaiKingaku(支給金額);
    }

    /**
     * 不支給理由を設定します。
     *
     * @param 不支給理由 不支給理由
     */
    public void set不支給理由(RString 不支給理由) {
        requireNonNull(不支給理由, UrSystemErrorMessages.値がnull.getReplacedMessage("不支給理由"));
        entity.setFushikyuRiyu(不支給理由);
    }

    /**
     * 審査方法区分を設定します。
     *
     * @param 審査方法区分 審査方法区分
     */
    public void set審査方法区分(RString 審査方法区分) {
        requireNonNull(審査方法区分, UrSystemErrorMessages.値がnull.getReplacedMessage("審査方法区分"));
        entity.setShinsaHohoKubun(審査方法区分);
    }

    /**
     * 判定結果送付年月を設定します。
     *
     * @param 判定結果送付年月 判定結果送付年月
     */
    public void set判定結果送付年月(FlexibleYearMonth 判定結果送付年月) {
        requireNonNull(判定結果送付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("判定結果送付年月"));
        entity.setHanteiKekkaSofuYM(判定結果送付年月);
    }

    /**
     * 再送付フラグを設定します。
     *
     * @param 再送付フラグ 再送付フラグ
     */
    public void set再送付フラグ(boolean 再送付フラグ) {
        requireNonNull(再送付フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("再送付フラグ"));
        entity.setSaiSofuFlag(再送付フラグ);
    }

    /**
     * 判定結果送付不要フラグを設定します。
     *
     * @param 判定結果送付不要フラグ 判定結果送付不要フラグ
     */
    public void set判定結果送付不要フラグ(boolean 判定結果送付不要フラグ) {
        requireNonNull(判定結果送付不要フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("判定結果送付不要フラグ"));
        entity.setHanteiKekkaSofuFuyoFlag(判定結果送付不要フラグ);
    }

    /**
     * 審査結果反映区分を設定します。
     *
     * @param 審査結果反映区分 審査結果反映区分
     */
    public void set審査結果反映区分(RString 審査結果反映区分) {
        requireNonNull(審査結果反映区分, UrSystemErrorMessages.値がnull.getReplacedMessage("審査結果反映区分"));
        entity.setShinsaKekkaHaneiKubun(審査結果反映区分);
    }

    /**
     * 決定通知書作成年月日を設定します。
     *
     * @param 決定通知書作成年月日 決定通知書作成年月日
     */
    public void set決定通知書作成年月日(FlexibleDate 決定通知書作成年月日) {
        requireNonNull(決定通知書作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定通知書作成年月日"));
        entity.setKetteiTsuchishoSakuseiYMD(決定通知書作成年月日);
    }

    /**
     * 振込明細書作成年月日を設定します。
     *
     * @param 振込明細書作成年月日 振込明細書作成年月日
     */
    public void set振込明細書作成年月日(FlexibleDate 振込明細書作成年月日) {
        requireNonNull(振込明細書作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("振込明細書作成年月日"));
        entity.setFurikomiMeisaishoSakuseiYMD(振込明細書作成年月日);
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
