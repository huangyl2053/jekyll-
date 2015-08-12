/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * {@link KyufuhiKashitsukekinEntaiRisokuKeisan}の編集を行うビルダークラスです。
 */
public class KyufuhiKashitsukekinEntaiRisokuKeisanBuilder {

    private final DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity entity;
    private final KyufuhiKashitsukekinEntaiRisokuKeisanIdentifier id;

    /**
     * {@link DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity}より{@link KyufuhiKashitsukekinEntaiRisokuKeisan}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity}
     * @param id {@link KyufuhiKashitsukekinEntaiRisokuKeisanIdentifier}
     *
     */
    KyufuhiKashitsukekinEntaiRisokuKeisanBuilder(
            DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity entity,
            KyufuhiKashitsukekinEntaiRisokuKeisanIdentifier id
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
     * @return {@link KyufuhiKashitsukekinEntaiRisokuKeisanBuilder}
     */
    public KyufuhiKashitsukekinEntaiRisokuKeisanBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 貸付管理番号を設定します。
     *
     * @param 貸付管理番号 貸付管理番号
     * @return {@link KyufuhiKashitsukekinEntaiRisokuKeisanBuilder}
     */
    public KyufuhiKashitsukekinEntaiRisokuKeisanBuilder set貸付管理番号(RString 貸付管理番号) {
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        entity.setKashitsukeKanriNo(貸付管理番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KyufuhiKashitsukekinEntaiRisokuKeisanBuilder}
     */
    public KyufuhiKashitsukekinEntaiRisokuKeisanBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 貸付金延滞日数を設定します。
     *
     * @param 貸付金延滞日数 貸付金延滞日数
     * @return {@link KyufuhiKashitsukekinEntaiRisokuKeisanBuilder}
     */
    public KyufuhiKashitsukekinEntaiRisokuKeisanBuilder set貸付金延滞日数(RString 貸付金延滞日数) {
        requireNonNull(貸付金延滞日数, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付金延滞日数"));
        entity.setEntaiNissu(貸付金延滞日数);
        return this;
    }

    /**
     * 貸付金延滞利息金額を設定します。
     *
     * @param 貸付金延滞利息金額 貸付金延滞利息金額
     * @return {@link KyufuhiKashitsukekinEntaiRisokuKeisanBuilder}
     */
    public KyufuhiKashitsukekinEntaiRisokuKeisanBuilder set貸付金延滞利息金額(Decimal 貸付金延滞利息金額) {
        requireNonNull(貸付金延滞利息金額, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付金延滞利息金額"));
        entity.setEntaiRisokuKingaku(貸付金延滞利息金額);
        return this;
    }

    /**
     * {@link KyufuhiKashitsukekinEntaiRisokuKeisan}のインスタンスを生成します。
     *
     * @return {@link KyufuhiKashitsukekinEntaiRisokuKeisan}のインスタンス
     */
    public KyufuhiKashitsukekinEntaiRisokuKeisan build() {
        return new KyufuhiKashitsukekinEntaiRisokuKeisan(entity, id);
    }
}
