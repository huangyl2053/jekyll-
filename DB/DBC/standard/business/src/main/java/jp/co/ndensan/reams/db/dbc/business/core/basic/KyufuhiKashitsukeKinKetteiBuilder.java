/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3087KyufuhiKashitsukeKinKetteiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyufuhiKashitsukeKinKettei}の編集を行うビルダークラスです。
 */
public class KyufuhiKashitsukeKinKetteiBuilder {

    private final DbT3087KyufuhiKashitsukeKinKetteiEntity entity;
    private final KyufuhiKashitsukeKinKetteiIdentifier id;

    /**
     * {@link DbT3087KyufuhiKashitsukeKinKetteiEntity}より{@link KyufuhiKashitsukeKinKettei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3087KyufuhiKashitsukeKinKetteiEntity}
     * @param id {@link KyufuhiKashitsukeKinKetteiIdentifier}
     *
     */
    KyufuhiKashitsukeKinKetteiBuilder(
            DbT3087KyufuhiKashitsukeKinKetteiEntity entity,
            KyufuhiKashitsukeKinKetteiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyufuhiKashitsukeKinKetteiBuilder}
     */
    public KyufuhiKashitsukeKinKetteiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 借入申請年月日を設定します。
     *
     * @param 借入申請年月日 借入申請年月日
     * @return {@link KyufuhiKashitsukeKinKetteiBuilder}
     */
    public KyufuhiKashitsukeKinKetteiBuilder set借入申請年月日(FlexibleDate 借入申請年月日) {
        requireNonNull(借入申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借入申請年月日"));
        entity.setKariireShinseiYMD(借入申請年月日);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KyufuhiKashitsukeKinKetteiBuilder}
     */
    public KyufuhiKashitsukeKinKetteiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 貸付審査決定年月日を設定します。
     *
     * @param 貸付審査決定年月日 貸付審査決定年月日
     * @return {@link KyufuhiKashitsukeKinKetteiBuilder}
     */
    public KyufuhiKashitsukeKinKetteiBuilder set貸付審査決定年月日(FlexibleDate 貸付審査決定年月日) {
        requireNonNull(貸付審査決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付審査決定年月日"));
        entity.setKashitsukeShinsaKetteiYMD(貸付審査決定年月日);
        return this;
    }

    /**
     * 貸付承認・不承認区分を設定します。
     *
     * @param 貸付承認_不承認区分 貸付承認・不承認区分
     * @return {@link KyufuhiKashitsukeKinKetteiBuilder}
     */
    public KyufuhiKashitsukeKinKetteiBuilder set貸付承認_不承認区分(RString 貸付承認_不承認区分) {
        requireNonNull(貸付承認_不承認区分, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付承認・不承認区分"));
        entity.setKashitsukeShonin_FuShoninKubun(貸付承認_不承認区分);
        return this;
    }

    /**
     * 貸付管理番号を設定します。
     *
     * @param 貸付管理番号 貸付管理番号
     * @return {@link KyufuhiKashitsukeKinKetteiBuilder}
     */
    public KyufuhiKashitsukeKinKetteiBuilder set貸付管理番号(RString 貸付管理番号) {
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        entity.setKashitsukeKanriNo(貸付管理番号);
        return this;
    }

    /**
     * 貸付金額を設定します。
     *
     * @param 貸付金額 貸付金額
     * @return {@link KyufuhiKashitsukeKinKetteiBuilder}
     */
    public KyufuhiKashitsukeKinKetteiBuilder set貸付金額(Decimal 貸付金額) {
        requireNonNull(貸付金額, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付金額"));
        entity.setKashitsukeKingaku(貸付金額);
        return this;
    }

    /**
     * 償還方法を設定します。
     *
     * @param 償還方法 償還方法
     * @return {@link KyufuhiKashitsukeKinKetteiBuilder}
     */
    public KyufuhiKashitsukeKinKetteiBuilder set償還方法(RString 償還方法) {
        requireNonNull(償還方法, UrSystemErrorMessages.値がnull.getReplacedMessage("償還方法"));
        entity.setShokanHoho(償還方法);
        return this;
    }

    /**
     * 償還期限を設定します。
     *
     * @param 償還期限 償還期限
     * @return {@link KyufuhiKashitsukeKinKetteiBuilder}
     */
    public KyufuhiKashitsukeKinKetteiBuilder set償還期限(FlexibleDate 償還期限) {
        requireNonNull(償還期限, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限"));
        entity.setShokanKigenYMD(償還期限);
        return this;
    }

    /**
     * 貸付年月日を設定します。
     *
     * @param 貸付年月日 貸付年月日
     * @return {@link KyufuhiKashitsukeKinKetteiBuilder}
     */
    public KyufuhiKashitsukeKinKetteiBuilder set貸付年月日(FlexibleDate 貸付年月日) {
        requireNonNull(貸付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付年月日"));
        entity.setKashitsukeYMD(貸付年月日);
        return this;
    }

    /**
     * 貸付支払方法を設定します。
     *
     * @param 貸付支払方法 貸付支払方法
     * @return {@link KyufuhiKashitsukeKinKetteiBuilder}
     */
    public KyufuhiKashitsukeKinKetteiBuilder set貸付支払方法(RString 貸付支払方法) {
        requireNonNull(貸付支払方法, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付支払方法"));
        entity.setKashitsukeShiharaiHoho(貸付支払方法);
        return this;
    }

    /**
     * 貸付窓口支払場所を設定します。
     *
     * @param 貸付窓口支払場所 貸付窓口支払場所
     * @return {@link KyufuhiKashitsukeKinKetteiBuilder}
     */
    public KyufuhiKashitsukeKinKetteiBuilder set貸付窓口支払場所(RString 貸付窓口支払場所) {
        requireNonNull(貸付窓口支払場所, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付窓口支払場所"));
        entity.setKashitsukeMadoguchiShiharaiBasho(貸付窓口支払場所);
        return this;
    }

    /**
     * 貸付窓口開始年月日を設定します。
     *
     * @param 貸付窓口開始年月日 貸付窓口開始年月日
     * @return {@link KyufuhiKashitsukeKinKetteiBuilder}
     */
    public KyufuhiKashitsukeKinKetteiBuilder set貸付窓口開始年月日(FlexibleDate 貸付窓口開始年月日) {
        requireNonNull(貸付窓口開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付窓口開始年月日"));
        entity.setKashitsukeMadoguchiKaishiYMD(貸付窓口開始年月日);
        return this;
    }

    /**
     * 貸付窓口終了年月日を設定します。
     *
     * @param 貸付窓口終了年月日 貸付窓口終了年月日
     * @return {@link KyufuhiKashitsukeKinKetteiBuilder}
     */
    public KyufuhiKashitsukeKinKetteiBuilder set貸付窓口終了年月日(FlexibleDate 貸付窓口終了年月日) {
        requireNonNull(貸付窓口終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付窓口終了年月日"));
        entity.setKashitsukeMadoguchiShuryoYMD(貸付窓口終了年月日);
        return this;
    }

    /**
     * 貸付窓口閉庁内容を設定します。
     *
     * @param 貸付窓口閉庁内容 貸付窓口閉庁内容
     * @return {@link KyufuhiKashitsukeKinKetteiBuilder}
     */
    public KyufuhiKashitsukeKinKetteiBuilder set貸付窓口閉庁内容(RString 貸付窓口閉庁内容) {
        requireNonNull(貸付窓口閉庁内容, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付窓口閉庁内容"));
        entity.setKashitsukeMadoguchiHeichoNaiyo(貸付窓口閉庁内容);
        return this;
    }

    /**
     * 貸付窓口開始時間を設定します。
     *
     * @param 貸付窓口開始時間 貸付窓口開始時間
     * @return {@link KyufuhiKashitsukeKinKetteiBuilder}
     */
    public KyufuhiKashitsukeKinKetteiBuilder set貸付窓口開始時間(RString 貸付窓口開始時間) {
        requireNonNull(貸付窓口開始時間, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付窓口開始時間"));
        entity.setKashitsukeMadoguchiKaishiTime(貸付窓口開始時間);
        return this;
    }

    /**
     * 貸付窓口終了時間を設定します。
     *
     * @param 貸付窓口終了時間 貸付窓口終了時間
     * @return {@link KyufuhiKashitsukeKinKetteiBuilder}
     */
    public KyufuhiKashitsukeKinKetteiBuilder set貸付窓口終了時間(RString 貸付窓口終了時間) {
        requireNonNull(貸付窓口終了時間, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付窓口終了時間"));
        entity.setKashitsukeMadoguchiShuryoTime(貸付窓口終了時間);
        return this;
    }

    /**
     * 貸付不承認理由を設定します。
     *
     * @param 貸付不承認理由 貸付不承認理由
     * @return {@link KyufuhiKashitsukeKinKetteiBuilder}
     */
    public KyufuhiKashitsukeKinKetteiBuilder set貸付不承認理由(RString 貸付不承認理由) {
        requireNonNull(貸付不承認理由, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付不承認理由"));
        entity.setKashitsukeFuShoninRiyu(貸付不承認理由);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link KyufuhiKashitsukeKinKetteiBuilder}
     */
    public KyufuhiKashitsukeKinKetteiBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * {@link KyufuhiKashitsukeKinKettei}のインスタンスを生成します。
     *
     * @return {@link KyufuhiKashitsukeKinKettei}のインスタンス
     */
    public KyufuhiKashitsukeKinKettei build() {
        return new KyufuhiKashitsukeKinKettei(entity, id);
    }
}
