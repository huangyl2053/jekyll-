/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額介護サービス費給付対象者合計のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class KogakuKyufuTaishoshaGokeiModel implements Serializable {

    private DbT3055KogakuKyufuTaishoshaGokeiEntity entity;

    /**
     * コンストラクタです。
     */
    public KogakuKyufuTaishoshaGokeiModel() {
        entity = new DbT3055KogakuKyufuTaishoshaGokeiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3055KogakuKyufuTaishoshaGokeiEntity
     */
    public KogakuKyufuTaishoshaGokeiModel(DbT3055KogakuKyufuTaishoshaGokeiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3055KogakuKyufuTaishoshaGokeiEntityを返します。
     *
     * @return DbT3055KogakuKyufuTaishoshaGokeiEntity
     */
    public DbT3055KogakuKyufuTaishoshaGokeiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3055KogakuKyufuTaishoshaGokeiEntityを設定します。
     *
     * @param entity DbT3055KogakuKyufuTaishoshaGokeiEntity
     */
    public void setEntity(DbT3055KogakuKyufuTaishoshaGokeiEntity entity) {
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
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * サービス費用合計額合計を返します。
     *
     * @return サービス費用合計額合計
     */
    public Decimal getサービス費用合計額合計() {
        return entity.getServiceHiyoGokeiGakuGokei();
    }

    /**
     * 利用者負担額合計を返します。
     *
     * @return 利用者負担額合計
     */
    public Decimal get利用者負担額合計() {
        return entity.getRiyoshaFutanGakuGokei();
    }

    /**
     * 算定基準額を返します。
     *
     * @return 算定基準額
     */
    public Decimal get算定基準額() {
        return entity.getSanteiKijunGaku();
    }

    /**
     * 支払済金額合計を返します。
     *
     * @return 支払済金額合計
     */
    public Decimal get支払済金額合計() {
        return entity.getShiharaiSumiKingakuGokei();
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
     * 対象者受取年月を返します。
     *
     * @return 対象者受取年月
     */
    public FlexibleYearMonth get対象者受取年月() {
        return entity.getTashoshaUketoriYM();
    }

    /**
     * 対象者判定審査年月を返します。
     *
     * @return 対象者判定審査年月
     */
    public FlexibleYearMonth get対象者判定審査年月() {
        return entity.getTaishoshaHanteiShinsaYM();
    }

    /**
     * 世帯集約番号を返します。
     *
     * @return 世帯集約番号
     */
    public RString get世帯集約番号() {
        return entity.getSetaiShuyakuNo();
    }

    /**
     * 境界層対象者フラグを返します。
     *
     * @return 境界層対象者フラグ
     */
    public boolean get境界層対象者フラグ() {
        return entity.getKyokaisoTaishoshaFlag();
    }

    /**
     * 社会福祉法人軽減対象フラグを返します。
     *
     * @return 社会福祉法人軽減対象フラグ
     */
    public boolean get社会福祉法人軽減対象フラグ() {
        return entity.getHojinKeigenTaishoFlag();
    }

    /**
     * 高額対象外フラグを返します。
     *
     * @return 高額対象外フラグ
     */
    public boolean get高額対象外フラグ() {
        return entity.getKogakuTaishoGaiFlag();
    }

    /**
     * 自動償還対象フラグを返します。
     *
     * @return 自動償還対象フラグ
     */
    public boolean get自動償還対象フラグ() {
        return entity.getJidoShokanTaishoFlag();
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
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * サービス費用合計額合計を設定します。
     *
     * @param サービス費用合計額合計 サービス費用合計額合計
     */
    public void setサービス費用合計額合計(Decimal サービス費用合計額合計) {
        requireNonNull(サービス費用合計額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス費用合計額合計"));
        entity.setServiceHiyoGokeiGakuGokei(サービス費用合計額合計);
    }

    /**
     * 利用者負担額合計を設定します。
     *
     * @param 利用者負担額合計 利用者負担額合計
     */
    public void set利用者負担額合計(Decimal 利用者負担額合計) {
        requireNonNull(利用者負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額合計"));
        entity.setRiyoshaFutanGakuGokei(利用者負担額合計);
    }

    /**
     * 算定基準額を設定します。
     *
     * @param 算定基準額 算定基準額
     */
    public void set算定基準額(Decimal 算定基準額) {
        requireNonNull(算定基準額, UrSystemErrorMessages.値がnull.getReplacedMessage("算定基準額"));
        entity.setSanteiKijunGaku(算定基準額);
    }

    /**
     * 支払済金額合計を設定します。
     *
     * @param 支払済金額合計 支払済金額合計
     */
    public void set支払済金額合計(Decimal 支払済金額合計) {
        requireNonNull(支払済金額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("支払済金額合計"));
        entity.setShiharaiSumiKingakuGokei(支払済金額合計);
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
     * 対象者受取年月を設定します。
     *
     * @param 対象者受取年月 対象者受取年月
     */
    public void set対象者受取年月(FlexibleYearMonth 対象者受取年月) {
        requireNonNull(対象者受取年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象者受取年月"));
        entity.setTashoshaUketoriYM(対象者受取年月);
    }

    /**
     * 対象者判定審査年月を設定します。
     *
     * @param 対象者判定審査年月 対象者判定審査年月
     */
    public void set対象者判定審査年月(FlexibleYearMonth 対象者判定審査年月) {
        requireNonNull(対象者判定審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象者判定審査年月"));
        entity.setTaishoshaHanteiShinsaYM(対象者判定審査年月);
    }

    /**
     * 世帯集約番号を設定します。
     *
     * @param 世帯集約番号 世帯集約番号
     */
    public void set世帯集約番号(RString 世帯集約番号) {
        requireNonNull(世帯集約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯集約番号"));
        entity.setSetaiShuyakuNo(世帯集約番号);
    }

    /**
     * 境界層対象者フラグを設定します。
     *
     * @param 境界層対象者フラグ 境界層対象者フラグ
     */
    public void set境界層対象者フラグ(boolean 境界層対象者フラグ) {
        requireNonNull(境界層対象者フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層対象者フラグ"));
        entity.setKyokaisoTaishoshaFlag(境界層対象者フラグ);
    }

    /**
     * 社会福祉法人軽減対象フラグを設定します。
     *
     * @param 社会福祉法人軽減対象フラグ 社会福祉法人軽減対象フラグ
     */
    public void set社会福祉法人軽減対象フラグ(boolean 社会福祉法人軽減対象フラグ) {
        requireNonNull(社会福祉法人軽減対象フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("社会福祉法人軽減対象フラグ"));
        entity.setHojinKeigenTaishoFlag(社会福祉法人軽減対象フラグ);
    }

    /**
     * 高額対象外フラグを設定します。
     *
     * @param 高額対象外フラグ 高額対象外フラグ
     */
    public void set高額対象外フラグ(boolean 高額対象外フラグ) {
        requireNonNull(高額対象外フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("高額対象外フラグ"));
        entity.setKogakuTaishoGaiFlag(高額対象外フラグ);
    }

    /**
     * 自動償還対象フラグを設定します。
     *
     * @param 自動償還対象フラグ 自動償還対象フラグ
     */
    public void set自動償還対象フラグ(boolean 自動償還対象フラグ) {
        requireNonNull(自動償還対象フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("自動償還対象フラグ"));
        entity.setJidoShokanTaishoFlag(自動償還対象フラグ);
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
