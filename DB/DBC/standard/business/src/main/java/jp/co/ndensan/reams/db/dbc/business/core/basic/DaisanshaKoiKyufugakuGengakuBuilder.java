/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3081DaisanshaKoiKyufugakuGengakuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link DaisanshaKoiKyufugakuGengaku}の編集を行うビルダークラスです。
 */
public class DaisanshaKoiKyufugakuGengakuBuilder {

    private final DbT3081DaisanshaKoiKyufugakuGengakuEntity entity;
    private final DaisanshaKoiKyufugakuGengakuIdentifier id;

    /**
     * {@link DbT3081DaisanshaKoiKyufugakuGengakuEntity}より{@link DaisanshaKoiKyufugakuGengaku}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3081DaisanshaKoiKyufugakuGengakuEntity}
     * @param id {@link DaisanshaKoiKyufugakuGengakuIdentifier}
     *
     */
    DaisanshaKoiKyufugakuGengakuBuilder(
            DbT3081DaisanshaKoiKyufugakuGengakuEntity entity,
            DaisanshaKoiKyufugakuGengakuIdentifier id
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
     * @return {@link DaisanshaKoiKyufugakuGengakuBuilder}
     */
    public DaisanshaKoiKyufugakuGengakuBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 第三者行為届出管理番号を設定します。
     *
     * @param 第三者行為届出管理番号 第三者行為届出管理番号
     * @return {@link DaisanshaKoiKyufugakuGengakuBuilder}
     */
    public DaisanshaKoiKyufugakuGengakuBuilder set第三者行為届出管理番号(RString 第三者行為届出管理番号) {
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        entity.setTodokedeKanriNo(第三者行為届出管理番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link DaisanshaKoiKyufugakuGengakuBuilder}
     */
    public DaisanshaKoiKyufugakuGengakuBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 減額対象金額を設定します。
     *
     * @param 減額対象金額 減額対象金額
     * @return {@link DaisanshaKoiKyufugakuGengakuBuilder}
     */
    public DaisanshaKoiKyufugakuGengakuBuilder set減額対象金額(Decimal 減額対象金額) {
        requireNonNull(減額対象金額, UrSystemErrorMessages.値がnull.getReplacedMessage("減額対象金額"));
        entity.setGengakuTaishoKingaku(減額対象金額);
        return this;
    }

    /**
     * 給付額減額期間開始年月日を設定します。
     *
     * @param 給付額減額期間開始年月日 給付額減額期間開始年月日
     * @return {@link DaisanshaKoiKyufugakuGengakuBuilder}
     */
    public DaisanshaKoiKyufugakuGengakuBuilder set給付額減額期間開始年月日(FlexibleDate 給付額減額期間開始年月日) {
        requireNonNull(給付額減額期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("給付額減額期間開始年月日"));
        entity.setGengakuKaishiYMD(給付額減額期間開始年月日);
        return this;
    }

    /**
     * 給付額減額期間終了年月日を設定します。
     *
     * @param 給付額減額期間終了年月日 給付額減額期間終了年月日
     * @return {@link DaisanshaKoiKyufugakuGengakuBuilder}
     */
    public DaisanshaKoiKyufugakuGengakuBuilder set給付額減額期間終了年月日(FlexibleDate 給付額減額期間終了年月日) {
        requireNonNull(給付額減額期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("給付額減額期間終了年月日"));
        entity.setGengakuShuryoYMD(給付額減額期間終了年月日);
        return this;
    }

    /**
     * {@link DaisanshaKoiKyufugakuGengaku}のインスタンスを生成します。
     *
     * @return {@link DaisanshaKoiKyufugakuGengaku}のインスタンス
     */
    public DaisanshaKoiKyufugakuGengaku build() {
        return new DaisanshaKoiKyufugakuGengaku(entity, id);
    }
}
