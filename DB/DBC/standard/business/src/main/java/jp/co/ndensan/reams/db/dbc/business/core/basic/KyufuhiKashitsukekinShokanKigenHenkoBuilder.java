/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyufuhiKashitsukekinShokanKigenHenko}の編集を行うビルダークラスです。
 */
public class KyufuhiKashitsukekinShokanKigenHenkoBuilder {

    private final DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity entity;
    private final KyufuhiKashitsukekinShokanKigenHenkoIdentifier id;

    /**
     * {@link DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity}より{@link KyufuhiKashitsukekinShokanKigenHenko}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity}
     * @param id {@link KyufuhiKashitsukekinShokanKigenHenkoIdentifier}
     *
     */
    KyufuhiKashitsukekinShokanKigenHenkoBuilder(
            DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity entity,
            KyufuhiKashitsukekinShokanKigenHenkoIdentifier id
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
     * @return {@link KyufuhiKashitsukekinShokanKigenHenkoBuilder}
     */
    public KyufuhiKashitsukekinShokanKigenHenkoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 貸付管理番号を設定します。
     *
     * @param 貸付管理番号 貸付管理番号
     * @return {@link KyufuhiKashitsukekinShokanKigenHenkoBuilder}
     */
    public KyufuhiKashitsukekinShokanKigenHenkoBuilder set貸付管理番号(RString 貸付管理番号) {
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        entity.setKashitsukeKanriNo(貸付管理番号);
        return this;
    }

    /**
     * 償還期限延長受付年月日を設定します。
     *
     * @param 償還期限延長受付年月日 償還期限延長受付年月日
     * @return {@link KyufuhiKashitsukekinShokanKigenHenkoBuilder}
     */
    public KyufuhiKashitsukekinShokanKigenHenkoBuilder set償還期限延長受付年月日(FlexibleDate 償還期限延長受付年月日) {
        requireNonNull(償還期限延長受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限延長受付年月日"));
        entity.setShokanKigenEnchoUketsukeYMD(償還期限延長受付年月日);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KyufuhiKashitsukekinShokanKigenHenkoBuilder}
     */
    public KyufuhiKashitsukekinShokanKigenHenkoBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 償還期限延長申請年月日を設定します。
     *
     * @param 償還期限延長申請年月日 償還期限延長申請年月日
     * @return {@link KyufuhiKashitsukekinShokanKigenHenkoBuilder}
     */
    public KyufuhiKashitsukekinShokanKigenHenkoBuilder set償還期限延長申請年月日(FlexibleDate 償還期限延長申請年月日) {
        requireNonNull(償還期限延長申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限延長申請年月日"));
        entity.setShokanKigenEnchoShinseiYMD(償還期限延長申請年月日);
        return this;
    }

    /**
     * 借受人郵便番号を設定します。
     *
     * @param 借受人郵便番号 借受人郵便番号
     * @return {@link KyufuhiKashitsukekinShokanKigenHenkoBuilder}
     */
    public KyufuhiKashitsukekinShokanKigenHenkoBuilder set借受人郵便番号(YubinNo 借受人郵便番号) {
        requireNonNull(借受人郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("借受人郵便番号"));
        entity.setKariukeninYubinNo(借受人郵便番号);
        return this;
    }

    /**
     * 借受人住所を設定します。
     *
     * @param 借受人住所 借受人住所
     * @return {@link KyufuhiKashitsukekinShokanKigenHenkoBuilder}
     */
    public KyufuhiKashitsukekinShokanKigenHenkoBuilder set借受人住所(RString 借受人住所) {
        requireNonNull(借受人住所, UrSystemErrorMessages.値がnull.getReplacedMessage("借受人住所"));
        entity.setKariukeninJusho(借受人住所);
        return this;
    }

    /**
     * 借受人氏名カナを設定します。
     *
     * @param 借受人氏名カナ 借受人氏名カナ
     * @return {@link KyufuhiKashitsukekinShokanKigenHenkoBuilder}
     */
    public KyufuhiKashitsukekinShokanKigenHenkoBuilder set借受人氏名カナ(AtenaKanaMeisho 借受人氏名カナ) {
        requireNonNull(借受人氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("借受人氏名カナ"));
        entity.setKariukeninShimeiKana(借受人氏名カナ);
        return this;
    }

    /**
     * 借受人氏名を設定します。
     *
     * @param 借受人氏名 借受人氏名
     * @return {@link KyufuhiKashitsukekinShokanKigenHenkoBuilder}
     */
    public KyufuhiKashitsukekinShokanKigenHenkoBuilder set借受人氏名(AtenaMeisho 借受人氏名) {
        requireNonNull(借受人氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("借受人氏名"));
        entity.setKariukeninShimei(借受人氏名);
        return this;
    }

    /**
     * 借受人電話番号を設定します。
     *
     * @param 借受人電話番号 借受人電話番号
     * @return {@link KyufuhiKashitsukekinShokanKigenHenkoBuilder}
     */
    public KyufuhiKashitsukekinShokanKigenHenkoBuilder set借受人電話番号(TelNo 借受人電話番号) {
        requireNonNull(借受人電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("借受人電話番号"));
        entity.setKariukeninTelNo(借受人電話番号);
        return this;
    }

    /**
     * 未償還金額を設定します。
     *
     * @param 未償還金額 未償還金額
     * @return {@link KyufuhiKashitsukekinShokanKigenHenkoBuilder}
     */
    public KyufuhiKashitsukekinShokanKigenHenkoBuilder set未償還金額(Decimal 未償還金額) {
        requireNonNull(未償還金額, UrSystemErrorMessages.値がnull.getReplacedMessage("未償還金額"));
        entity.setMiShokanKingaku(未償還金額);
        return this;
    }

    /**
     * 償還期限延長希望期間開始年月日を設定します。
     *
     * @param 償還期限延長希望期間開始年月日 償還期限延長希望期間開始年月日
     * @return {@link KyufuhiKashitsukekinShokanKigenHenkoBuilder}
     */
    public KyufuhiKashitsukekinShokanKigenHenkoBuilder set償還期限延長希望期間開始年月日(FlexibleDate 償還期限延長希望期間開始年月日) {
        requireNonNull(償還期限延長希望期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限延長希望期間開始年月日"));
        entity.setEnchoKiboKaishiYMD(償還期限延長希望期間開始年月日);
        return this;
    }

    /**
     * 償還期限延長希望期間終了年月日を設定します。
     *
     * @param 償還期限延長希望期間終了年月日 償還期限延長希望期間終了年月日
     * @return {@link KyufuhiKashitsukekinShokanKigenHenkoBuilder}
     */
    public KyufuhiKashitsukekinShokanKigenHenkoBuilder set償還期限延長希望期間終了年月日(FlexibleDate 償還期限延長希望期間終了年月日) {
        requireNonNull(償還期限延長希望期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限延長希望期間終了年月日"));
        entity.setEnchoKiboShuryoYMD(償還期限延長希望期間終了年月日);
        return this;
    }

    /**
     * 償還期限延長理由等を設定します。
     *
     * @param 償還期限延長理由等 償還期限延長理由等
     * @return {@link KyufuhiKashitsukekinShokanKigenHenkoBuilder}
     */
    public KyufuhiKashitsukekinShokanKigenHenkoBuilder set償還期限延長理由等(RString 償還期限延長理由等) {
        requireNonNull(償還期限延長理由等, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限延長理由等"));
        entity.setEnchoRiyu(償還期限延長理由等);
        return this;
    }

    /**
     * 償還期限変更決定年月日を設定します。
     *
     * @param 償還期限変更決定年月日 償還期限変更決定年月日
     * @return {@link KyufuhiKashitsukekinShokanKigenHenkoBuilder}
     */
    public KyufuhiKashitsukekinShokanKigenHenkoBuilder set償還期限変更決定年月日(FlexibleDate 償還期限変更決定年月日) {
        requireNonNull(償還期限変更決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限変更決定年月日"));
        entity.setHenkoKetteiYMD(償還期限変更決定年月日);
        return this;
    }

    /**
     * 償還期限変更承認・不承認区分を設定します。
     *
     * @param 償還期限変更承認_不承認区分 償還期限変更承認・不承認区分
     * @return {@link KyufuhiKashitsukekinShokanKigenHenkoBuilder}
     */
    public KyufuhiKashitsukekinShokanKigenHenkoBuilder set償還期限変更承認_不承認区分(RString 償還期限変更承認_不承認区分) {
        requireNonNull(償還期限変更承認_不承認区分, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限変更承認・不承認区分"));
        entity.setHenkoShonin_FuShoninKubun(償還期限変更承認_不承認区分);
        return this;
    }

    /**
     * 変更後償還期限を設定します。
     *
     * @param 変更後償還期限 変更後償還期限
     * @return {@link KyufuhiKashitsukekinShokanKigenHenkoBuilder}
     */
    public KyufuhiKashitsukekinShokanKigenHenkoBuilder set変更後償還期限(FlexibleDate 変更後償還期限) {
        requireNonNull(変更後償還期限, UrSystemErrorMessages.値がnull.getReplacedMessage("変更後償還期限"));
        entity.setHenkoGoShokanKigenYMD(変更後償還期限);
        return this;
    }

    /**
     * 償還期限変更不承認理由を設定します。
     *
     * @param 償還期限変更不承認理由 償還期限変更不承認理由
     * @return {@link KyufuhiKashitsukekinShokanKigenHenkoBuilder}
     */
    public KyufuhiKashitsukekinShokanKigenHenkoBuilder set償還期限変更不承認理由(RString 償還期限変更不承認理由) {
        requireNonNull(償還期限変更不承認理由, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限変更不承認理由"));
        entity.setHenkoFuShoninRiyu(償還期限変更不承認理由);
        return this;
    }

    /**
     * {@link KyufuhiKashitsukekinShokanKigenHenko}のインスタンスを生成します。
     *
     * @return {@link KyufuhiKashitsukekinShokanKigenHenko}のインスタンス
     */
    public KyufuhiKashitsukekinShokanKigenHenko build() {
        return new KyufuhiKashitsukekinShokanKigenHenko(entity, id);
    }
}
