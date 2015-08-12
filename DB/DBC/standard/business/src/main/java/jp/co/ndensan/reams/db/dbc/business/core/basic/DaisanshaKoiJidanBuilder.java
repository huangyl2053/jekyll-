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
 * {@link DaisanshaKoiJidan}の編集を行うビルダークラスです。
 */
public class DaisanshaKoiJidanBuilder {

    private final DbT3080DaisanshaKoiJidanEntity entity;
    private final DaisanshaKoiJidanIdentifier id;

    /**
     * {@link DbT3080DaisanshaKoiJidanEntity}より{@link DaisanshaKoiJidan}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3080DaisanshaKoiJidanEntity}
     * @param id {@link DaisanshaKoiJidanIdentifier}
     *
     */
    DaisanshaKoiJidanBuilder(
            DbT3080DaisanshaKoiJidanEntity entity,
            DaisanshaKoiJidanIdentifier id
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
     * @return {@link DaisanshaKoiJidanBuilder}
     */
    public DaisanshaKoiJidanBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 第三者行為届出管理番号を設定します。
     *
     * @param 第三者行為届出管理番号 第三者行為届出管理番号
     * @return {@link DaisanshaKoiJidanBuilder}
     */
    public DaisanshaKoiJidanBuilder set第三者行為届出管理番号(RString 第三者行為届出管理番号) {
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        entity.setTodokedeKanriNo(第三者行為届出管理番号);
        return this;
    }

    /**
     * 示談報告書受付年月日を設定します。
     *
     * @param 示談報告書受付年月日 示談報告書受付年月日
     * @return {@link DaisanshaKoiJidanBuilder}
     */
    public DaisanshaKoiJidanBuilder set示談報告書受付年月日(FlexibleDate 示談報告書受付年月日) {
        requireNonNull(示談報告書受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("示談報告書受付年月日"));
        entity.setJidanHokokushoUketukeYMD(示談報告書受付年月日);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link DaisanshaKoiJidanBuilder}
     */
    public DaisanshaKoiJidanBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 第三者行為求償協議区分を設定します。
     *
     * @param 第三者行為求償協議区分 第三者行為求償協議区分
     * @return {@link DaisanshaKoiJidanBuilder}
     */
    public DaisanshaKoiJidanBuilder set第三者行為求償協議区分(RString 第三者行為求償協議区分) {
        requireNonNull(第三者行為求償協議区分, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為求償協議区分"));
        entity.setKyushoKyogiKubun(第三者行為求償協議区分);
        return this;
    }

    /**
     * 示談報告書提出年月日を設定します。
     *
     * @param 示談報告書提出年月日 示談報告書提出年月日
     * @return {@link DaisanshaKoiJidanBuilder}
     */
    public DaisanshaKoiJidanBuilder set示談報告書提出年月日(FlexibleDate 示談報告書提出年月日) {
        requireNonNull(示談報告書提出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("示談報告書提出年月日"));
        entity.setJidanHokokushoTeishutsuYMD(示談報告書提出年月日);
        return this;
    }

    /**
     * 示談成立年月日を設定します。
     *
     * @param 示談成立年月日 示談成立年月日
     * @return {@link DaisanshaKoiJidanBuilder}
     */
    public DaisanshaKoiJidanBuilder set示談成立年月日(FlexibleDate 示談成立年月日) {
        requireNonNull(示談成立年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("示談成立年月日"));
        entity.setJidanSeiritsuYMD(示談成立年月日);
        return this;
    }

    /**
     * 給付期間開始年月を設定します。
     *
     * @param 給付期間開始年月 給付期間開始年月
     * @return {@link DaisanshaKoiJidanBuilder}
     */
    public DaisanshaKoiJidanBuilder set給付期間開始年月(FlexibleYearMonth 給付期間開始年月) {
        requireNonNull(給付期間開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("給付期間開始年月"));
        entity.setKyufuKaishiYMD(給付期間開始年月);
        return this;
    }

    /**
     * 給付期間終了年月を設定します。
     *
     * @param 給付期間終了年月 給付期間終了年月
     * @return {@link DaisanshaKoiJidanBuilder}
     */
    public DaisanshaKoiJidanBuilder set給付期間終了年月(FlexibleYearMonth 給付期間終了年月) {
        requireNonNull(給付期間終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("給付期間終了年月"));
        entity.setKyufuShuryoYMD(給付期間終了年月);
        return this;
    }

    /**
     * 過失割合・加害者を設定します。
     *
     * @param 過失割合・加害者 過失割合・加害者
     * @return {@link DaisanshaKoiJidanBuilder}
     */
    public DaisanshaKoiJidanBuilder set過失割合・加害者(RString 過失割合・加害者) {
        requireNonNull(過失割合・加害者, UrSystemErrorMessages.値がnull.getReplacedMessage("過失割合・加害者"));
        entity.setKashitsuWariai_Kagaisha(過失割合・加害者);
        return this;
    }

    /**
     * 過失割合・被害者を設定します。
     *
     * @param 過失割合・被害者 過失割合・被害者
     * @return {@link DaisanshaKoiJidanBuilder}
     */
    public DaisanshaKoiJidanBuilder set過失割合・被害者(RString 過失割合・被害者) {
        requireNonNull(過失割合・被害者, UrSystemErrorMessages.値がnull.getReplacedMessage("過失割合・被害者"));
        entity.setKashitsuWariai_Higaisha(過失割合・被害者);
        return this;
    }

    /**
     * {@link DaisanshaKoiJidan}のインスタンスを生成します。
     *
     * @return {@link DaisanshaKoiJidan}のインスタンス
     */
    public DaisanshaKoiJidan build() {
        return new DaisanshaKoiJidan(entity, id);
    }
}
