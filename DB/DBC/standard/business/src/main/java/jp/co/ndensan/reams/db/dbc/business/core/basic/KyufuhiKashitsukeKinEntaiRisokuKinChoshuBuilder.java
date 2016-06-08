/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyufuhiKashitsukeKinEntaiRisokuKinChoshu}の編集を行うビルダークラスです。
 */
public class KyufuhiKashitsukeKinEntaiRisokuKinChoshuBuilder {

    private final DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity entity;
    private final KyufuhiKashitsukeKinEntaiRisokuKinChoshuIdentifier id;

    /**
     * {@link DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity}より{@link KyufuhiKashitsukeKinEntaiRisokuKinChoshu}の編集用Builderクラスを生成します。
     *
     * @param entity
     * {@link DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity}
     * @param id {@link KyufuhiKashitsukeKinEntaiRisokuKinChoshuIdentifier}
     *
     */
    KyufuhiKashitsukeKinEntaiRisokuKinChoshuBuilder(
            DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity entity,
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuIdentifier id
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
     * @return {@link KyufuhiKashitsukeKinEntaiRisokuKinChoshuBuilder}
     */
    public KyufuhiKashitsukeKinEntaiRisokuKinChoshuBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 貸付管理番号を設定します。
     *
     * @param 貸付管理番号 貸付管理番号
     * @return {@link KyufuhiKashitsukeKinEntaiRisokuKinChoshuBuilder}
     */
    public KyufuhiKashitsukeKinEntaiRisokuKinChoshuBuilder set貸付管理番号(RString 貸付管理番号) {
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        entity.setKashitsukeKanriNo(貸付管理番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KyufuhiKashitsukeKinEntaiRisokuKinChoshuBuilder}
     */
    public KyufuhiKashitsukeKinEntaiRisokuKinChoshuBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 延滞利息金徴収年月日を設定します。
     *
     * @param 延滞利息金徴収年月日 延滞利息金徴収年月日
     * @return {@link KyufuhiKashitsukeKinEntaiRisokuKinChoshuBuilder}
     */
    public KyufuhiKashitsukeKinEntaiRisokuKinChoshuBuilder set延滞利息金徴収年月日(FlexibleDate 延滞利息金徴収年月日) {
        requireNonNull(延滞利息金徴収年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("延滞利息金徴収年月日"));
        entity.setEntaiRisokuKinChoshuYMD(延滞利息金徴収年月日);
        return this;
    }

    /**
     * 延滞利息徴収金額を設定します。
     *
     * @param 延滞利息徴収金額 延滞利息徴収金額
     * @return {@link KyufuhiKashitsukeKinEntaiRisokuKinChoshuBuilder}
     */
    public KyufuhiKashitsukeKinEntaiRisokuKinChoshuBuilder set延滞利息徴収金額(Decimal 延滞利息徴収金額) {
        requireNonNull(延滞利息徴収金額, UrSystemErrorMessages.値がnull.getReplacedMessage("延滞利息徴収金額"));
        entity.setEntaiRisokuChoshuKingaku(延滞利息徴収金額);
        return this;
    }

    /**
     * {@link KyufuhiKashitsukeKinEntaiRisokuKinChoshu}のインスタンスを生成します。
     *
     * @return {@link KyufuhiKashitsukeKinEntaiRisokuKinChoshu}のインスタンス
     */
    public KyufuhiKashitsukeKinEntaiRisokuKinChoshu build() {
        return new KyufuhiKashitsukeKinEntaiRisokuKinChoshu(entity, id);
    }
}
