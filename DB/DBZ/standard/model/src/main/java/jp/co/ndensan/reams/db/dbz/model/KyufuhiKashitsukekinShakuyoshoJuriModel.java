/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付費貸付金借用書受理のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class KyufuhiKashitsukekinShakuyoshoJuriModel implements Serializable {

    private DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufuhiKashitsukekinShakuyoshoJuriModel() {
        entity = new DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity
     */
    public KyufuhiKashitsukekinShakuyoshoJuriModel(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityを返します。
     *
     * @return DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity
     */
    public DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity getEntity() {
        return entity;
    }

    /**
     * DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityを設定します。
     *
     * @param entity DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity
     */
    public void setEntity(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity entity) {
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
     * 借入申請年月日を返します。
     *
     * @return 借入申請年月日
     */
    public FlexibleDate get借入申請年月日() {
        return entity.getKariireShinseiYMD();
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
     * 借受年月日を返します。
     *
     * @return 借受年月日
     */
    public FlexibleDate get借受年月日() {
        return entity.getKariukeYMD();
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
     * 保証人氏名カナを返します。
     *
     * @return 保証人氏名カナ
     */
    public AtenaKanaMeisho get保証人氏名カナ() {
        return entity.getHoshoninShimeiKana();
    }

    /**
     * 保証人氏名を返します。
     *
     * @return 保証人氏名
     */
    public AtenaKanaMeisho get保証人氏名() {
        return entity.getHoshoninShimei();
    }

    /**
     * 保証人郵便番号を返します。
     *
     * @return 保証人郵便番号
     */
    public YubinNo get保証人郵便番号() {
        return entity.getHoshoninYubinNo();
    }

    /**
     * 保証人住所を返します。
     *
     * @return 保証人住所
     */
    public RString get保証人住所() {
        return entity.getHoshoninJusho();
    }

    /**
     * 保証人電話番号を返します。
     *
     * @return 保証人電話番号
     */
    public TelNo get保証人電話番号() {
        return entity.getHoshoninTelNo();
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
     * 借入申請年月日を設定します。
     *
     * @param 借入申請年月日 借入申請年月日
     */
    public void set借入申請年月日(FlexibleDate 借入申請年月日) {
        requireNonNull(借入申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借入申請年月日"));
        entity.setKariireShinseiYMD(借入申請年月日);
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
     * 借受年月日を設定します。
     *
     * @param 借受年月日 借受年月日
     */
    public void set借受年月日(FlexibleDate 借受年月日) {
        requireNonNull(借受年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借受年月日"));
        entity.setKariukeYMD(借受年月日);
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
     * 保証人氏名カナを設定します。
     *
     * @param 保証人氏名カナ 保証人氏名カナ
     */
    public void set保証人氏名カナ(AtenaKanaMeisho 保証人氏名カナ) {
        requireNonNull(保証人氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人氏名カナ"));
        entity.setHoshoninShimeiKana(保証人氏名カナ);
    }

    /**
     * 保証人氏名を設定します。
     *
     * @param 保証人氏名 保証人氏名
     */
    public void set保証人氏名(AtenaKanaMeisho 保証人氏名) {
        requireNonNull(保証人氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人氏名"));
        entity.setHoshoninShimei(保証人氏名);
    }

    /**
     * 保証人郵便番号を設定します。
     *
     * @param 保証人郵便番号 保証人郵便番号
     */
    public void set保証人郵便番号(YubinNo 保証人郵便番号) {
        requireNonNull(保証人郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人郵便番号"));
        entity.setHoshoninYubinNo(保証人郵便番号);
    }

    /**
     * 保証人住所を設定します。
     *
     * @param 保証人住所 保証人住所
     */
    public void set保証人住所(RString 保証人住所) {
        requireNonNull(保証人住所, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人住所"));
        entity.setHoshoninJusho(保証人住所);
    }

    /**
     * 保証人電話番号を設定します。
     *
     * @param 保証人電話番号 保証人電話番号
     */
    public void set保証人電話番号(TelNo 保証人電話番号) {
        requireNonNull(保証人電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人電話番号"));
        entity.setHoshoninTelNo(保証人電話番号);
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
