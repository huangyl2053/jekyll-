/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5031NinteiChosaHoshuTankaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link NinteiChosaHoshuTanka}の編集を行うビルダークラスです。
 */
public class NinteiChosaHoshuTankaBuilder {

    private final DbT5031NinteiChosaHoshuTankaEntity entity;
    private final NinteiChosaHoshuTankaIdentifier id;

    /**
     * {@link DbT5031NinteiChosaHoshuTankaEntity}より{@link NinteiChosaHoshuTanka}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5031NinteiChosaHoshuTankaEntity}
     * @param id {@link NinteiChosaHoshuTankaIdentifier}
     *
     */
    NinteiChosaHoshuTankaBuilder(
            DbT5031NinteiChosaHoshuTankaEntity entity,
            NinteiChosaHoshuTankaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 調査区分を設定します。
     *
     * @param 調査区分 調査区分
     * @return {@link NinteiChosaHoshuTankaBuilder}
     */
    public NinteiChosaHoshuTankaBuilder set調査区分(Code 調査区分) {
        requireNonNull(調査区分, UrSystemErrorMessages.値がnull.getReplacedMessage("調査区分"));
        entity.setChosaKubun(調査区分);
        return this;
    }

    /**
     * 訪問種別を設定します。
     *
     * @param 訪問種別 訪問種別
     * @return {@link NinteiChosaHoshuTankaBuilder}
     */
    public NinteiChosaHoshuTankaBuilder set訪問種別(Code 訪問種別) {
        requireNonNull(訪問種別, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問種別"));
        entity.setHomonShubetsu(訪問種別);
        return this;
    }

    /**
     * 意見書入手パターンを設定します。
     *
     * @param 意見書入手パターン 意見書入手パターン
     * @return {@link NinteiChosaHoshuTankaBuilder}
     */
    public NinteiChosaHoshuTankaBuilder set意見書入手パターン(Code 意見書入手パターン) {
        requireNonNull(意見書入手パターン, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書入手パターン"));
        entity.setIkenshoNyushuPatern(意見書入手パターン);
        return this;
    }

    /**
     * 開始年月を設定します。
     *
     * @param 開始年月 開始年月
     * @return {@link NinteiChosaHoshuTankaBuilder}
     */
    public NinteiChosaHoshuTankaBuilder set開始年月(FlexibleYearMonth 開始年月) {
        requireNonNull(開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月"));
        entity.setKaishiYM(開始年月);
        return this;
    }

    /**
     * 終了年月を設定します。
     *
     * @param 終了年月 終了年月
     * @return {@link NinteiChosaHoshuTankaBuilder}
     */
    public NinteiChosaHoshuTankaBuilder set終了年月(FlexibleYearMonth 終了年月) {
        requireNonNull(終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月"));
        entity.setShuryoYM(終了年月);
        return this;
    }

    /**
     * 単価を設定します。
     *
     * @param 単価 単価
     * @return {@link NinteiChosaHoshuTankaBuilder}
     */
    public NinteiChosaHoshuTankaBuilder set単価(Decimal 単価) {
        requireNonNull(単価, UrSystemErrorMessages.値がnull.getReplacedMessage("単価"));
        entity.setTanka(単価);
        return this;
    }

    /**
     * {@link NinteiChosaHoshuTanka}のインスタンスを生成します。
     *
     * @return {@link NinteiChosaHoshuTanka}のインスタンス
     */
    public NinteiChosaHoshuTanka build() {
        return new NinteiChosaHoshuTanka(entity, id);
    }
}
