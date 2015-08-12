/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyufuhiKashitsukeKinKyoseiHenkan}の編集を行うビルダークラスです。
 */
public class KyufuhiKashitsukeKinKyoseiHenkanBuilder {

    private final DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity entity;
    private final KyufuhiKashitsukeKinKyoseiHenkanIdentifier id;

    /**
     * {@link DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity}より{@link KyufuhiKashitsukeKinKyoseiHenkan}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity}
     * @param id {@link KyufuhiKashitsukeKinKyoseiHenkanIdentifier}
     *
     */
    KyufuhiKashitsukeKinKyoseiHenkanBuilder(
            DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity entity,
            KyufuhiKashitsukeKinKyoseiHenkanIdentifier id
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
     * @return {@link KyufuhiKashitsukeKinKyoseiHenkanBuilder}
     */
    public KyufuhiKashitsukeKinKyoseiHenkanBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 貸付管理番号を設定します。
     *
     * @param 貸付管理番号 貸付管理番号
     * @return {@link KyufuhiKashitsukeKinKyoseiHenkanBuilder}
     */
    public KyufuhiKashitsukeKinKyoseiHenkanBuilder set貸付管理番号(RString 貸付管理番号) {
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        entity.setKashitsukeKanriNo(貸付管理番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KyufuhiKashitsukeKinKyoseiHenkanBuilder}
     */
    public KyufuhiKashitsukeKinKyoseiHenkanBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 返還金区分を設定します。
     *
     * @param 返還金区分 返還金区分
     * @return {@link KyufuhiKashitsukeKinKyoseiHenkanBuilder}
     */
    public KyufuhiKashitsukeKinKyoseiHenkanBuilder set返還金区分(RString 返還金区分) {
        requireNonNull(返還金区分, UrSystemErrorMessages.値がnull.getReplacedMessage("返還金区分"));
        entity.setHenkanKinKubun(返還金区分);
        return this;
    }

    /**
     * 返還金額を設定します。
     *
     * @param 返還金額 返還金額
     * @return {@link KyufuhiKashitsukeKinKyoseiHenkanBuilder}
     */
    public KyufuhiKashitsukeKinKyoseiHenkanBuilder set返還金額(Decimal 返還金額) {
        requireNonNull(返還金額, UrSystemErrorMessages.値がnull.getReplacedMessage("返還金額"));
        entity.setHenkanKingaku(返還金額);
        return this;
    }

    /**
     * 返還期限を設定します。
     *
     * @param 返還期限 返還期限
     * @return {@link KyufuhiKashitsukeKinKyoseiHenkanBuilder}
     */
    public KyufuhiKashitsukeKinKyoseiHenkanBuilder set返還期限(FlexibleDate 返還期限) {
        requireNonNull(返還期限, UrSystemErrorMessages.値がnull.getReplacedMessage("返還期限"));
        entity.setHenkanKigenYMD(返還期限);
        return this;
    }

    /**
     * 返還理由を設定します。
     *
     * @param 返還理由 返還理由
     * @return {@link KyufuhiKashitsukeKinKyoseiHenkanBuilder}
     */
    public KyufuhiKashitsukeKinKyoseiHenkanBuilder set返還理由(RString 返還理由) {
        requireNonNull(返還理由, UrSystemErrorMessages.値がnull.getReplacedMessage("返還理由"));
        entity.setHenkanRiyu(返還理由);
        return this;
    }

    /**
     * {@link KyufuhiKashitsukeKinKyoseiHenkan}のインスタンスを生成します。
     *
     * @return {@link KyufuhiKashitsukeKinKyoseiHenkan}のインスタンス
     */
    public KyufuhiKashitsukeKinKyoseiHenkan build() {
        return new KyufuhiKashitsukeKinKyoseiHenkan(entity, id);
    }
}
