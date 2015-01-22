/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付費貸付金償還期限変更のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class KyufuhiKashitsukekinShokanKigenHenkoModel implements Serializable {

    private DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufuhiKashitsukekinShokanKigenHenkoModel() {
        entity = new DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity
     */
    public KyufuhiKashitsukekinShokanKigenHenkoModel(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityを返します。
     *
     * @return DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity
     */
    public DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity getEntity() {
        return entity;
    }

    /**
     * DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityを設定します。
     *
     * @param entity DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity
     */
    public void setEntity(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity entity) {
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
     * 貸付管理番号を返します。
     *
     * @return 貸付管理番号
     */
    public RString get貸付管理番号() {
        return entity.getKashitsukeKanriNo();
    }

    /**
     * 償還期限延長受付年月日を返します。
     *
     * @return 償還期限延長受付年月日
     */
    public FlexibleDate get償還期限延長受付年月日() {
        return entity.getShokanKigenEnchoUketsukeYMD();
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
     * 償還期限延長申請年月日を返します。
     *
     * @return 償還期限延長申請年月日
     */
    public FlexibleDate get償還期限延長申請年月日() {
        return entity.getShokanKigenEnchoShinseiYMD();
    }

    /**
     * 借受人郵便番号を返します。
     *
     * @return 借受人郵便番号
     */
    public YubinNo get借受人郵便番号() {
        return entity.getKariukeninYubinNo();
    }

    /**
     * 借受人住所を返します。
     *
     * @return 借受人住所
     */
    public RString get借受人住所() {
        return entity.getKariukeninJusho();
    }

    /**
     * 借受人氏名カナを返します。
     *
     * @return 借受人氏名カナ
     */
    public AtenaKanaMeisho get借受人氏名カナ() {
        return entity.getKariukeninShimeiKana();
    }

    /**
     * 借受人氏名を返します。
     *
     * @return 借受人氏名
     */
    public AtenaMeisho get借受人氏名() {
        return entity.getKariukeninShimei();
    }

    /**
     * 借受人電話番号を返します。
     *
     * @return 借受人電話番号
     */
    public TelNo get借受人電話番号() {
        return entity.getKariukeninTelNo();
    }

    /**
     * 未償還金額を返します。
     *
     * @return 未償還金額
     */
    public Decimal get未償還金額() {
        return entity.getMiShokanKingaku();
    }

    /**
     * 償還期限延長希望期間開始年月日を返します。
     *
     * @return 償還期限延長希望期間開始年月日
     */
    public FlexibleDate get償還期限延長希望期間開始年月日() {
        return entity.getEnchoKiboKaishiYMD();
    }

    /**
     * 償還期限延長希望期間終了年月日を返します。
     *
     * @return 償還期限延長希望期間終了年月日
     */
    public FlexibleDate get償還期限延長希望期間終了年月日() {
        return entity.getEnchoKiboShuryoYMD();
    }

    /**
     * 償還期限延長理由等を返します。
     *
     * @return 償還期限延長理由等
     */
    public RString get償還期限延長理由等() {
        return entity.getEnchoRiyu();
    }

    /**
     * 償還期限変更決定年月日を返します。
     *
     * @return 償還期限変更決定年月日
     */
    public FlexibleDate get償還期限変更決定年月日() {
        return entity.getHenkoKetteiYMD();
    }

    /**
     * 償還期限変更承認_不承認区分を返します。
     *
     * @return 償還期限変更承認_不承認区分
     */
    public RString get償還期限変更承認_不承認区分() {
        return entity.getHenkoShonin_FuShoninKubun();
    }

    /**
     * 変更後償還期限を返します。
     *
     * @return 変更後償還期限
     */
    public FlexibleDate get変更後償還期限() {
        return entity.getHenkoGoShokanKigenYMD();
    }

    /**
     * 償還期限変更不承認理由を返します。
     *
     * @return 償還期限変更不承認理由
     */
    public RString get償還期限変更不承認理由() {
        return entity.getHenkoFuShoninRiyu();
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
     * 貸付管理番号を設定します。
     *
     * @param 貸付管理番号 貸付管理番号
     */
    public void set貸付管理番号(RString 貸付管理番号) {
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        entity.setKashitsukeKanriNo(貸付管理番号);
    }

    /**
     * 償還期限延長受付年月日を設定します。
     *
     * @param 償還期限延長受付年月日 償還期限延長受付年月日
     */
    public void set償還期限延長受付年月日(FlexibleDate 償還期限延長受付年月日) {
        requireNonNull(償還期限延長受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限延長受付年月日"));
        entity.setShokanKigenEnchoUketsukeYMD(償還期限延長受付年月日);
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
     * 償還期限延長申請年月日を設定します。
     *
     * @param 償還期限延長申請年月日 償還期限延長申請年月日
     */
    public void set償還期限延長申請年月日(FlexibleDate 償還期限延長申請年月日) {
        requireNonNull(償還期限延長申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限延長申請年月日"));
        entity.setShokanKigenEnchoShinseiYMD(償還期限延長申請年月日);
    }

    /**
     * 借受人郵便番号を設定します。
     *
     * @param 借受人郵便番号 借受人郵便番号
     */
    public void set借受人郵便番号(YubinNo 借受人郵便番号) {
        requireNonNull(借受人郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("借受人郵便番号"));
        entity.setKariukeninYubinNo(借受人郵便番号);
    }

    /**
     * 借受人住所を設定します。
     *
     * @param 借受人住所 借受人住所
     */
    public void set借受人住所(RString 借受人住所) {
        requireNonNull(借受人住所, UrSystemErrorMessages.値がnull.getReplacedMessage("借受人住所"));
        entity.setKariukeninJusho(借受人住所);
    }

    /**
     * 借受人氏名カナを設定します。
     *
     * @param 借受人氏名カナ 借受人氏名カナ
     */
    public void set借受人氏名カナ(AtenaKanaMeisho 借受人氏名カナ) {
        requireNonNull(借受人氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("借受人氏名カナ"));
        entity.setKariukeninShimeiKana(借受人氏名カナ);
    }

    /**
     * 借受人氏名を設定します。
     *
     * @param 借受人氏名 借受人氏名
     */
    public void set借受人氏名(AtenaMeisho 借受人氏名) {
        requireNonNull(借受人氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("借受人氏名"));
        entity.setKariukeninShimei(借受人氏名);
    }

    /**
     * 借受人電話番号を設定します。
     *
     * @param 借受人電話番号 借受人電話番号
     */
    public void set借受人電話番号(TelNo 借受人電話番号) {
        requireNonNull(借受人電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("借受人電話番号"));
        entity.setKariukeninTelNo(借受人電話番号);
    }

    /**
     * 未償還金額を設定します。
     *
     * @param 未償還金額 未償還金額
     */
    public void set未償還金額(Decimal 未償還金額) {
        requireNonNull(未償還金額, UrSystemErrorMessages.値がnull.getReplacedMessage("未償還金額"));
        entity.setMiShokanKingaku(未償還金額);
    }

    /**
     * 償還期限延長希望期間開始年月日を設定します。
     *
     * @param 償還期限延長希望期間開始年月日 償還期限延長希望期間開始年月日
     */
    public void set償還期限延長希望期間開始年月日(FlexibleDate 償還期限延長希望期間開始年月日) {
        requireNonNull(償還期限延長希望期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限延長希望期間開始年月日"));
        entity.setEnchoKiboKaishiYMD(償還期限延長希望期間開始年月日);
    }

    /**
     * 償還期限延長希望期間終了年月日を設定します。
     *
     * @param 償還期限延長希望期間終了年月日 償還期限延長希望期間終了年月日
     */
    public void set償還期限延長希望期間終了年月日(FlexibleDate 償還期限延長希望期間終了年月日) {
        requireNonNull(償還期限延長希望期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限延長希望期間終了年月日"));
        entity.setEnchoKiboShuryoYMD(償還期限延長希望期間終了年月日);
    }

    /**
     * 償還期限延長理由等を設定します。
     *
     * @param 償還期限延長理由等 償還期限延長理由等
     */
    public void set償還期限延長理由等(RString 償還期限延長理由等) {
        requireNonNull(償還期限延長理由等, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限延長理由等"));
        entity.setEnchoRiyu(償還期限延長理由等);
    }

    /**
     * 償還期限変更決定年月日を設定します。
     *
     * @param 償還期限変更決定年月日 償還期限変更決定年月日
     */
    public void set償還期限変更決定年月日(FlexibleDate 償還期限変更決定年月日) {
        requireNonNull(償還期限変更決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限変更決定年月日"));
        entity.setHenkoKetteiYMD(償還期限変更決定年月日);
    }

    /**
     * 償還期限変更承認_不承認区分を設定します。
     *
     * @param 償還期限変更承認_不承認区分 償還期限変更承認_不承認区分
     */
    public void set償還期限変更承認_不承認区分(RString 償還期限変更承認_不承認区分) {
        requireNonNull(償還期限変更承認_不承認区分, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限変更承認_不承認区分"));
        entity.setHenkoShonin_FuShoninKubun(償還期限変更承認_不承認区分);
    }

    /**
     * 変更後償還期限を設定します。
     *
     * @param 変更後償還期限 変更後償還期限
     */
    public void set変更後償還期限(FlexibleDate 変更後償還期限) {
        requireNonNull(変更後償還期限, UrSystemErrorMessages.値がnull.getReplacedMessage("変更後償還期限"));
        entity.setHenkoGoShokanKigenYMD(変更後償還期限);
    }

    /**
     * 償還期限変更不承認理由を設定します。
     *
     * @param 償還期限変更不承認理由 償還期限変更不承認理由
     */
    public void set償還期限変更不承認理由(RString 償還期限変更不承認理由) {
        requireNonNull(償還期限変更不承認理由, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限変更不承認理由"));
        entity.setHenkoFuShoninRiyu(償還期限変更不承認理由);
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
