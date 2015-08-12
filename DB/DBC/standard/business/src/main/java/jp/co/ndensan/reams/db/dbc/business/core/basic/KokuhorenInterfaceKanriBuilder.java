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
 * {@link KokuhorenInterfaceKanri}の編集を行うビルダークラスです。
 */
public class KokuhorenInterfaceKanriBuilder {

    private final DbT3104KokuhorenInterfaceKanriEntity entity;
    private final KokuhorenInterfaceKanriIdentifier id;

    /**
     * {@link DbT3104KokuhorenInterfaceKanriEntity}より{@link KokuhorenInterfaceKanri}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3104KokuhorenInterfaceKanriEntity}
     * @param id {@link KokuhorenInterfaceKanriIdentifier}
     *
     */
    KokuhorenInterfaceKanriBuilder(
            DbT3104KokuhorenInterfaceKanriEntity entity,
            KokuhorenInterfaceKanriIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 処理年月を設定します。
     *
     * @param 処理年月 処理年月
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder set処理年月(FlexibleYearMonth 処理年月) {
        requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年月"));
        entity.setShoriYM(処理年月);
        return this;
    }

    /**
     * 交換情報識別番号を設定します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder set交換情報識別番号(RString 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanShikibetsuNo(交換情報識別番号);
        return this;
    }

    /**
     * 送付取込区分を設定します。
     *
     * @param 送付取込区分 送付取込区分
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder set送付取込区分(RString 送付取込区分) {
        requireNonNull(送付取込区分, UrSystemErrorMessages.値がnull.getReplacedMessage("送付取込区分"));
        entity.setSofuTorikomiKubun(送付取込区分);
        return this;
    }

    /**
     * 処理状態区分を設定します。
     *
     * @param 処理状態区分 処理状態区分
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder set処理状態区分(RString 処理状態区分) {
        requireNonNull(処理状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("処理状態区分"));
        entity.setShoriJotaiKubun(処理状態区分);
        return this;
    }

    /**
     * 処理実施日時を設定します。
     *
     * @param 処理実施日時 処理実施日時
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder set処理実施日時(YMDHMS 処理実施日時) {
        requireNonNull(処理実施日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理実施日時"));
        entity.setShoriJisshiTimestamp(処理実施日時);
        return this;
    }

    /**
     * 抽出開始日時を設定します。
     *
     * @param 抽出開始日時 抽出開始日時
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder set抽出開始日時(YMDHMS 抽出開始日時) {
        requireNonNull(抽出開始日時, UrSystemErrorMessages.値がnull.getReplacedMessage("抽出開始日時"));
        entity.setChushutsuKaishiTimestamp(抽出開始日時);
        return this;
    }

    /**
     * 抽出終了日時を設定します。
     *
     * @param 抽出終了日時 抽出終了日時
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder set抽出終了日時(YMDHMS 抽出終了日時) {
        requireNonNull(抽出終了日時, UrSystemErrorMessages.値がnull.getReplacedMessage("抽出終了日時"));
        entity.setChushutsuShuryoTimestamp(抽出終了日時);
        return this;
    }

    /**
     * 再処理可能区分を設定します。
     *
     * @param 再処理可能区分 再処理可能区分
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder set再処理可能区分(boolean 再処理可能区分) {
        requireNonNull(再処理可能区分, UrSystemErrorMessages.値がnull.getReplacedMessage("再処理可能区分"));
        entity.setSaiShoriKahiKubun(再処理可能区分);
        return this;
    }

    /**
     * 処理実行回数を設定します。
     *
     * @param 処理実行回数 処理実行回数
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder set処理実行回数(Decimal 処理実行回数) {
        requireNonNull(処理実行回数, UrSystemErrorMessages.値がnull.getReplacedMessage("処理実行回数"));
        entity.setShoriJikkoKaisu(処理実行回数);
        return this;
    }

    /**
     * ファイル名称１を設定します。
     *
     * @param ファイル名称１ ファイル名称１
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder setファイル名称１(RString ファイル名称１) {
        requireNonNull(ファイル名称１, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル名称１"));
        entity.setFileName1(ファイル名称１);
        return this;
    }

    /**
     * ファイル名称２を設定します。
     *
     * @param ファイル名称２ ファイル名称２
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder setファイル名称２(RString ファイル名称２) {
        requireNonNull(ファイル名称２, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル名称２"));
        entity.setFileName2(ファイル名称２);
        return this;
    }

    /**
     * ファイル名称３を設定します。
     *
     * @param ファイル名称３ ファイル名称３
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder setファイル名称３(RString ファイル名称３) {
        requireNonNull(ファイル名称３, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル名称３"));
        entity.setFileName3(ファイル名称３);
        return this;
    }

    /**
     * ファイル名称４を設定します。
     *
     * @param ファイル名称４ ファイル名称４
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder setファイル名称４(RString ファイル名称４) {
        requireNonNull(ファイル名称４, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル名称４"));
        entity.setFileName4(ファイル名称４);
        return this;
    }

    /**
     * ファイル名称５を設定します。
     *
     * @param ファイル名称５ ファイル名称５
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder setファイル名称５(RString ファイル名称５) {
        requireNonNull(ファイル名称５, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル名称５"));
        entity.setFileName5(ファイル名称５);
        return this;
    }

    /**
     * ファイル件数１を設定します。
     *
     * @param ファイル件数１ ファイル件数１
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder setファイル件数１(int ファイル件数１) {
        requireNonNull(ファイル件数１, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル件数１"));
        entity.setFileKensu1(ファイル件数１);
        return this;
    }

    /**
     * ファイル件数２を設定します。
     *
     * @param ファイル件数２ ファイル件数２
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder setファイル件数２(int ファイル件数２) {
        requireNonNull(ファイル件数２, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル件数２"));
        entity.setFileKensu2(ファイル件数２);
        return this;
    }

    /**
     * ファイル件数３を設定します。
     *
     * @param ファイル件数３ ファイル件数３
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder setファイル件数３(int ファイル件数３) {
        requireNonNull(ファイル件数３, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル件数３"));
        entity.setFileKensu3(ファイル件数３);
        return this;
    }

    /**
     * ファイル件数４を設定します。
     *
     * @param ファイル件数４ ファイル件数４
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder setファイル件数４(int ファイル件数４) {
        requireNonNull(ファイル件数４, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル件数４"));
        entity.setFileKensu4(ファイル件数４);
        return this;
    }

    /**
     * ファイル件数５を設定します。
     *
     * @param ファイル件数５ ファイル件数５
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder setファイル件数５(int ファイル件数５) {
        requireNonNull(ファイル件数５, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル件数５"));
        entity.setFileKensu5(ファイル件数５);
        return this;
    }

    /**
     * 再処理設定不可区分を設定します。
     *
     * @param 再処理設定不可区分 再処理設定不可区分
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder set再処理設定不可区分(boolean 再処理設定不可区分) {
        requireNonNull(再処理設定不可区分, UrSystemErrorMessages.値がnull.getReplacedMessage("再処理設定不可区分"));
        entity.setSaiShoriFukaKubun(再処理設定不可区分);
        return this;
    }

    /**
     * コントロール上レコード件数を設定します。
     *
     * @param コントロール上レコード件数 コントロール上レコード件数
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder setコントロール上レコード件数(int コントロール上レコード件数) {
        requireNonNull(コントロール上レコード件数, UrSystemErrorMessages.値がnull.getReplacedMessage("コントロール上レコード件数"));
        entity.setCtrlRecordKensu(コントロール上レコード件数);
        return this;
    }

    /**
     * コントロール上処理年月を設定します。
     *
     * @param コントロール上処理年月 コントロール上処理年月
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder setコントロール上処理年月(FlexibleYearMonth コントロール上処理年月) {
        requireNonNull(コントロール上処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("コントロール上処理年月"));
        entity.setCtrlShoriYM(コントロール上処理年月);
        return this;
    }

    /**
     * 過誤コントロール上レコード件数を設定します。
     *
     * @param 過誤コントロール上レコード件数 過誤コントロール上レコード件数
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder set過誤コントロール上レコード件数(int 過誤コントロール上レコード件数) {
        requireNonNull(過誤コントロール上レコード件数, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤コントロール上レコード件数"));
        entity.setKagoCtrlRecordKensu(過誤コントロール上レコード件数);
        return this;
    }

    /**
     * 過誤コントロール上処理年月を設定します。
     *
     * @param 過誤コントロール上処理年月 過誤コントロール上処理年月
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder set過誤コントロール上処理年月(FlexibleYearMonth 過誤コントロール上処理年月) {
        requireNonNull(過誤コントロール上処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤コントロール上処理年月"));
        entity.setKagoCtrlShoriYM(過誤コントロール上処理年月);
        return this;
    }

    /**
     * 実績データ上審査年月を設定します。
     *
     * @param 実績データ上審査年月 実績データ上審査年月
     * @return {@link KokuhorenInterfaceKanriBuilder}
     */
    public KokuhorenInterfaceKanriBuilder set実績データ上審査年月(FlexibleYearMonth 実績データ上審査年月) {
        requireNonNull(実績データ上審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("実績データ上審査年月"));
        entity.setJissekiDataShinsaYM(実績データ上審査年月);
        return this;
    }

    /**
     * {@link KokuhorenInterfaceKanri}のインスタンスを生成します。
     *
     * @return {@link KokuhorenInterfaceKanri}のインスタンス
     */
    public KokuhorenInterfaceKanri build() {
        return new KokuhorenInterfaceKanri(entity, id);
    }
}
