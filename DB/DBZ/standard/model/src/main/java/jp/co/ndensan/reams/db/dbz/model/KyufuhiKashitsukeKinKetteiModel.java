/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3087KyufuhiKashitsukeKinKetteiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付費貸付金決定のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class KyufuhiKashitsukeKinKetteiModel implements Serializable {

    private DbT3087KyufuhiKashitsukeKinKetteiEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufuhiKashitsukeKinKetteiModel() {
        entity = new DbT3087KyufuhiKashitsukeKinKetteiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3087KyufuhiKashitsukeKinKetteiEntity
     */
    public KyufuhiKashitsukeKinKetteiModel(DbT3087KyufuhiKashitsukeKinKetteiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3087KyufuhiKashitsukeKinKetteiEntityを返します。
     *
     * @return DbT3087KyufuhiKashitsukeKinKetteiEntity
     */
    public DbT3087KyufuhiKashitsukeKinKetteiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3087KyufuhiKashitsukeKinKetteiEntityを設定します。
     *
     * @param entity DbT3087KyufuhiKashitsukeKinKetteiEntity
     */
    public void setEntity(DbT3087KyufuhiKashitsukeKinKetteiEntity entity) {
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
     * 貸付審査決定年月日を返します。
     *
     * @return 貸付審査決定年月日
     */
    public FlexibleDate get貸付審査決定年月日() {
        return entity.getKashitsukeShinsaKetteiYMD();
    }

    /**
     * 貸付承認_不承認区分を返します。
     *
     * @return 貸付承認_不承認区分
     */
    public RString get貸付承認_不承認区分() {
        return entity.getKashitsukeShonin_FuShoninKubun();
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
     * 貸付金額を返します。
     *
     * @return 貸付金額
     */
    public Decimal get貸付金額() {
        return entity.getKashitsukeKingaku();
    }

    /**
     * 償還方法を返します。
     *
     * @return 償還方法
     */
    public RString get償還方法() {
        return entity.getShokanHoho();
    }

    /**
     * 償還期限を返します。
     *
     * @return 償還期限
     */
    public FlexibleDate get償還期限() {
        return entity.getShokanKigenYMD();
    }

    /**
     * 貸付年月日を返します。
     *
     * @return 貸付年月日
     */
    public FlexibleDate get貸付年月日() {
        return entity.getKashitsukeYMD();
    }

    /**
     * 貸付支払方法を返します。
     *
     * @return 貸付支払方法
     */
    public RString get貸付支払方法() {
        return entity.getKashitsukeShiharaiHoho();
    }

    /**
     * 貸付窓口支払場所を返します。
     *
     * @return 貸付窓口支払場所
     */
    public RString get貸付窓口支払場所() {
        return entity.getKashitsukeMadoguchiShiharaiBasho();
    }

    /**
     * 貸付窓口開始年月日を返します。
     *
     * @return 貸付窓口開始年月日
     */
    public FlexibleDate get貸付窓口開始年月日() {
        return entity.getKashitsukeMadoguchiKaishiYMD();
    }

    /**
     * 貸付窓口終了年月日を返します。
     *
     * @return 貸付窓口終了年月日
     */
    public FlexibleDate get貸付窓口終了年月日() {
        return entity.getKashitsukeMadoguchiShuryoYMD();
    }

    /**
     * 貸付窓口閉庁内容を返します。
     *
     * @return 貸付窓口閉庁内容
     */
    public RString get貸付窓口閉庁内容() {
        return entity.getKashitsukeMadoguchiHeichoNaiyo();
    }

    /**
     * 貸付窓口開始時間を返します。
     *
     * @return 貸付窓口開始時間
     */
    public RString get貸付窓口開始時間() {
        return entity.getKashitsukeMadoguchiKaishiTime();
    }

    /**
     * 貸付窓口終了時間を返します。
     *
     * @return 貸付窓口終了時間
     */
    public RString get貸付窓口終了時間() {
        return entity.getKashitsukeMadoguchiShuryoTime();
    }

    /**
     * 貸付不承認理由を返します。
     *
     * @return 貸付不承認理由
     */
    public RString get貸付不承認理由() {
        return entity.getKashitsukeFuShoninRiyu();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
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
     * 貸付審査決定年月日を設定します。
     *
     * @param 貸付審査決定年月日 貸付審査決定年月日
     */
    public void set貸付審査決定年月日(FlexibleDate 貸付審査決定年月日) {
        requireNonNull(貸付審査決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付審査決定年月日"));
        entity.setKashitsukeShinsaKetteiYMD(貸付審査決定年月日);
    }

    /**
     * 貸付承認_不承認区分を設定します。
     *
     * @param 貸付承認_不承認区分 貸付承認_不承認区分
     */
    public void set貸付承認_不承認区分(RString 貸付承認_不承認区分) {
        requireNonNull(貸付承認_不承認区分, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付承認_不承認区分"));
        entity.setKashitsukeShonin_FuShoninKubun(貸付承認_不承認区分);
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
     * 貸付金額を設定します。
     *
     * @param 貸付金額 貸付金額
     */
    public void set貸付金額(Decimal 貸付金額) {
        requireNonNull(貸付金額, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付金額"));
        entity.setKashitsukeKingaku(貸付金額);
    }

    /**
     * 償還方法を設定します。
     *
     * @param 償還方法 償還方法
     */
    public void set償還方法(RString 償還方法) {
        requireNonNull(償還方法, UrSystemErrorMessages.値がnull.getReplacedMessage("償還方法"));
        entity.setShokanHoho(償還方法);
    }

    /**
     * 償還期限を設定します。
     *
     * @param 償還期限 償還期限
     */
    public void set償還期限(FlexibleDate 償還期限) {
        requireNonNull(償還期限, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限"));
        entity.setShokanKigenYMD(償還期限);
    }

    /**
     * 貸付年月日を設定します。
     *
     * @param 貸付年月日 貸付年月日
     */
    public void set貸付年月日(FlexibleDate 貸付年月日) {
        requireNonNull(貸付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付年月日"));
        entity.setKashitsukeYMD(貸付年月日);
    }

    /**
     * 貸付支払方法を設定します。
     *
     * @param 貸付支払方法 貸付支払方法
     */
    public void set貸付支払方法(RString 貸付支払方法) {
        requireNonNull(貸付支払方法, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付支払方法"));
        entity.setKashitsukeShiharaiHoho(貸付支払方法);
    }

    /**
     * 貸付窓口支払場所を設定します。
     *
     * @param 貸付窓口支払場所 貸付窓口支払場所
     */
    public void set貸付窓口支払場所(RString 貸付窓口支払場所) {
        requireNonNull(貸付窓口支払場所, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付窓口支払場所"));
        entity.setKashitsukeMadoguchiShiharaiBasho(貸付窓口支払場所);
    }

    /**
     * 貸付窓口開始年月日を設定します。
     *
     * @param 貸付窓口開始年月日 貸付窓口開始年月日
     */
    public void set貸付窓口開始年月日(FlexibleDate 貸付窓口開始年月日) {
        requireNonNull(貸付窓口開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付窓口開始年月日"));
        entity.setKashitsukeMadoguchiKaishiYMD(貸付窓口開始年月日);
    }

    /**
     * 貸付窓口終了年月日を設定します。
     *
     * @param 貸付窓口終了年月日 貸付窓口終了年月日
     */
    public void set貸付窓口終了年月日(FlexibleDate 貸付窓口終了年月日) {
        requireNonNull(貸付窓口終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付窓口終了年月日"));
        entity.setKashitsukeMadoguchiShuryoYMD(貸付窓口終了年月日);
    }

    /**
     * 貸付窓口閉庁内容を設定します。
     *
     * @param 貸付窓口閉庁内容 貸付窓口閉庁内容
     */
    public void set貸付窓口閉庁内容(RString 貸付窓口閉庁内容) {
        requireNonNull(貸付窓口閉庁内容, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付窓口閉庁内容"));
        entity.setKashitsukeMadoguchiHeichoNaiyo(貸付窓口閉庁内容);
    }

    /**
     * 貸付窓口開始時間を設定します。
     *
     * @param 貸付窓口開始時間 貸付窓口開始時間
     */
    public void set貸付窓口開始時間(RString 貸付窓口開始時間) {
        requireNonNull(貸付窓口開始時間, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付窓口開始時間"));
        entity.setKashitsukeMadoguchiKaishiTime(貸付窓口開始時間);
    }

    /**
     * 貸付窓口終了時間を設定します。
     *
     * @param 貸付窓口終了時間 貸付窓口終了時間
     */
    public void set貸付窓口終了時間(RString 貸付窓口終了時間) {
        requireNonNull(貸付窓口終了時間, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付窓口終了時間"));
        entity.setKashitsukeMadoguchiShuryoTime(貸付窓口終了時間);
    }

    /**
     * 貸付不承認理由を設定します。
     *
     * @param 貸付不承認理由 貸付不承認理由
     */
    public void set貸付不承認理由(RString 貸付不承認理由) {
        requireNonNull(貸付不承認理由, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付不承認理由"));
        entity.setKashitsukeFuShoninRiyu(貸付不承認理由);
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
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
