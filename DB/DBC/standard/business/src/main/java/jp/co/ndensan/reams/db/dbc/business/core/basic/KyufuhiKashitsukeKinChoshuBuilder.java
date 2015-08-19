/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3092KyufuhiKashitsukeKinChoshuEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyufuhiKashitsukeKinChoshu}の編集を行うビルダークラスです。
 */
public class KyufuhiKashitsukeKinChoshuBuilder {

    private final DbT3092KyufuhiKashitsukeKinChoshuEntity entity;
    private final KyufuhiKashitsukeKinChoshuIdentifier id;

    /**
     * {@link DbT3092KyufuhiKashitsukeKinChoshuEntity}より{@link KyufuhiKashitsukeKinChoshu}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3092KyufuhiKashitsukeKinChoshuEntity}
     * @param id {@link KyufuhiKashitsukeKinChoshuIdentifier}
     *
     */
    KyufuhiKashitsukeKinChoshuBuilder(
            DbT3092KyufuhiKashitsukeKinChoshuEntity entity,
            KyufuhiKashitsukeKinChoshuIdentifier id
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
     * @return {@link KyufuhiKashitsukeKinChoshuBuilder}
     */
    public KyufuhiKashitsukeKinChoshuBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 貸付管理番号を設定します。
     *
     * @param 貸付管理番号 貸付管理番号
     * @return {@link KyufuhiKashitsukeKinChoshuBuilder}
     */
    public KyufuhiKashitsukeKinChoshuBuilder set貸付管理番号(RString 貸付管理番号) {
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        entity.setKashitsukeKanriNo(貸付管理番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KyufuhiKashitsukeKinChoshuBuilder}
     */
    public KyufuhiKashitsukeKinChoshuBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 貸付金返還徴収方法を設定します。
     *
     * @param 貸付金返還徴収方法 貸付金返還徴収方法
     * @return {@link KyufuhiKashitsukeKinChoshuBuilder}
     */
    public KyufuhiKashitsukeKinChoshuBuilder set貸付金返還徴収方法(RString 貸付金返還徴収方法) {
        requireNonNull(貸付金返還徴収方法, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付金返還徴収方法"));
        entity.setHenkanChoshuHoho(貸付金返還徴収方法);
        return this;
    }

    /**
     * 貸付金返還徴収年月日を設定します。
     *
     * @param 貸付金返還徴収年月日 貸付金返還徴収年月日
     * @return {@link KyufuhiKashitsukeKinChoshuBuilder}
     */
    public KyufuhiKashitsukeKinChoshuBuilder set貸付金返還徴収年月日(FlexibleDate 貸付金返還徴収年月日) {
        requireNonNull(貸付金返還徴収年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付金返還徴収年月日"));
        entity.setHenkanChoshuYMD(貸付金返還徴収年月日);
        return this;
    }

    /**
     * 貸付金返還徴収金額を設定します。
     *
     * @param 貸付金返還徴収金額 貸付金返還徴収金額
     * @return {@link KyufuhiKashitsukeKinChoshuBuilder}
     */
    public KyufuhiKashitsukeKinChoshuBuilder set貸付金返還徴収金額(Decimal 貸付金返還徴収金額) {
        requireNonNull(貸付金返還徴収金額, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付金返還徴収金額"));
        entity.setHenkanChoshuKingaku(貸付金返還徴収金額);
        return this;
    }

    /**
     * 過不足判定結果区分を設定します。
     *
     * @param 過不足判定結果区分 過不足判定結果区分
     * @return {@link KyufuhiKashitsukeKinChoshuBuilder}
     */
    public KyufuhiKashitsukeKinChoshuBuilder set過不足判定結果区分(RString 過不足判定結果区分) {
        requireNonNull(過不足判定結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("過不足判定結果区分"));
        entity.setKabusokuHanteiKekkaKubun(過不足判定結果区分);
        return this;
    }

    /**
     * {@link KyufuhiKashitsukeKinChoshu}のインスタンスを生成します。
     *
     * @return {@link KyufuhiKashitsukeKinChoshu}のインスタンス
     */
    public KyufuhiKashitsukeKinChoshu build() {
        return new KyufuhiKashitsukeKinChoshu(entity, id);
    }
}
