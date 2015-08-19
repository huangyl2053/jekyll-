/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity;
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
 * {@link KyufuhiKashitsukekinShakuyoshoJuri}の編集を行うビルダークラスです。
 */
public class KyufuhiKashitsukekinShakuyoshoJuriBuilder {

    private final DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity entity;
    private final KyufuhiKashitsukekinShakuyoshoJuriIdentifier id;

    /**
     * {@link DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity}より{@link KyufuhiKashitsukekinShakuyoshoJuri}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity}
     * @param id {@link KyufuhiKashitsukekinShakuyoshoJuriIdentifier}
     *
     */
    KyufuhiKashitsukekinShakuyoshoJuriBuilder(
            DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity entity,
            KyufuhiKashitsukekinShakuyoshoJuriIdentifier id
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
     * @return {@link KyufuhiKashitsukekinShakuyoshoJuriBuilder}
     */
    public KyufuhiKashitsukekinShakuyoshoJuriBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 借入申請年月日を設定します。
     *
     * @param 借入申請年月日 借入申請年月日
     * @return {@link KyufuhiKashitsukekinShakuyoshoJuriBuilder}
     */
    public KyufuhiKashitsukekinShakuyoshoJuriBuilder set借入申請年月日(FlexibleDate 借入申請年月日) {
        requireNonNull(借入申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借入申請年月日"));
        entity.setKariireShinseiYMD(借入申請年月日);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KyufuhiKashitsukekinShakuyoshoJuriBuilder}
     */
    public KyufuhiKashitsukekinShakuyoshoJuriBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 借受年月日を設定します。
     *
     * @param 借受年月日 借受年月日
     * @return {@link KyufuhiKashitsukekinShakuyoshoJuriBuilder}
     */
    public KyufuhiKashitsukekinShakuyoshoJuriBuilder set借受年月日(FlexibleDate 借受年月日) {
        requireNonNull(借受年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借受年月日"));
        entity.setKariukeYMD(借受年月日);
        return this;
    }

    /**
     * 借受人郵便番号を設定します。
     *
     * @param 借受人郵便番号 借受人郵便番号
     * @return {@link KyufuhiKashitsukekinShakuyoshoJuriBuilder}
     */
    public KyufuhiKashitsukekinShakuyoshoJuriBuilder set借受人郵便番号(YubinNo 借受人郵便番号) {
        requireNonNull(借受人郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("借受人郵便番号"));
        entity.setKariukeninYubinNo(借受人郵便番号);
        return this;
    }

    /**
     * 借受人住所を設定します。
     *
     * @param 借受人住所 借受人住所
     * @return {@link KyufuhiKashitsukekinShakuyoshoJuriBuilder}
     */
    public KyufuhiKashitsukekinShakuyoshoJuriBuilder set借受人住所(RString 借受人住所) {
        requireNonNull(借受人住所, UrSystemErrorMessages.値がnull.getReplacedMessage("借受人住所"));
        entity.setKariukeninJusho(借受人住所);
        return this;
    }

    /**
     * 借受人氏名カナを設定します。
     *
     * @param 借受人氏名カナ 借受人氏名カナ
     * @return {@link KyufuhiKashitsukekinShakuyoshoJuriBuilder}
     */
    public KyufuhiKashitsukekinShakuyoshoJuriBuilder set借受人氏名カナ(AtenaKanaMeisho 借受人氏名カナ) {
        requireNonNull(借受人氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("借受人氏名カナ"));
        entity.setKariukeninShimeiKana(借受人氏名カナ);
        return this;
    }

    /**
     * 借受人氏名を設定します。
     *
     * @param 借受人氏名 借受人氏名
     * @return {@link KyufuhiKashitsukekinShakuyoshoJuriBuilder}
     */
    public KyufuhiKashitsukekinShakuyoshoJuriBuilder set借受人氏名(AtenaMeisho 借受人氏名) {
        requireNonNull(借受人氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("借受人氏名"));
        entity.setKariukeninShimei(借受人氏名);
        return this;
    }

    /**
     * 借受人電話番号を設定します。
     *
     * @param 借受人電話番号 借受人電話番号
     * @return {@link KyufuhiKashitsukekinShakuyoshoJuriBuilder}
     */
    public KyufuhiKashitsukekinShakuyoshoJuriBuilder set借受人電話番号(TelNo 借受人電話番号) {
        requireNonNull(借受人電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("借受人電話番号"));
        entity.setKariukeninTelNo(借受人電話番号);
        return this;
    }

    /**
     * 保証人氏名カナを設定します。
     *
     * @param 保証人氏名カナ 保証人氏名カナ
     * @return {@link KyufuhiKashitsukekinShakuyoshoJuriBuilder}
     */
    public KyufuhiKashitsukekinShakuyoshoJuriBuilder set保証人氏名カナ(AtenaKanaMeisho 保証人氏名カナ) {
        requireNonNull(保証人氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人氏名カナ"));
        entity.setHoshoninShimeiKana(保証人氏名カナ);
        return this;
    }

    /**
     * 保証人氏名を設定します。
     *
     * @param 保証人氏名 保証人氏名
     * @return {@link KyufuhiKashitsukekinShakuyoshoJuriBuilder}
     */
    public KyufuhiKashitsukekinShakuyoshoJuriBuilder set保証人氏名(AtenaKanaMeisho 保証人氏名) {
        requireNonNull(保証人氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人氏名"));
        entity.setHoshoninShimei(保証人氏名);
        return this;
    }

    /**
     * 保証人郵便番号を設定します。
     *
     * @param 保証人郵便番号 保証人郵便番号
     * @return {@link KyufuhiKashitsukekinShakuyoshoJuriBuilder}
     */
    public KyufuhiKashitsukekinShakuyoshoJuriBuilder set保証人郵便番号(YubinNo 保証人郵便番号) {
        requireNonNull(保証人郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人郵便番号"));
        entity.setHoshoninYubinNo(保証人郵便番号);
        return this;
    }

    /**
     * 保証人住所を設定します。
     *
     * @param 保証人住所 保証人住所
     * @return {@link KyufuhiKashitsukekinShakuyoshoJuriBuilder}
     */
    public KyufuhiKashitsukekinShakuyoshoJuriBuilder set保証人住所(RString 保証人住所) {
        requireNonNull(保証人住所, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人住所"));
        entity.setHoshoninJusho(保証人住所);
        return this;
    }

    /**
     * 保証人電話番号を設定します。
     *
     * @param 保証人電話番号 保証人電話番号
     * @return {@link KyufuhiKashitsukekinShakuyoshoJuriBuilder}
     */
    public KyufuhiKashitsukekinShakuyoshoJuriBuilder set保証人電話番号(TelNo 保証人電話番号) {
        requireNonNull(保証人電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人電話番号"));
        entity.setHoshoninTelNo(保証人電話番号);
        return this;
    }

    /**
     * {@link KyufuhiKashitsukekinShakuyoshoJuri}のインスタンスを生成します。
     *
     * @return {@link KyufuhiKashitsukekinShakuyoshoJuri}のインスタンス
     */
    public KyufuhiKashitsukekinShakuyoshoJuri build() {
        return new KyufuhiKashitsukekinShakuyoshoJuri(entity, id);
    }
}
