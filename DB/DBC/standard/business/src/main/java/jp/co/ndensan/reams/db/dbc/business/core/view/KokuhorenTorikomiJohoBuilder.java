/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.view;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3104KokuhorenTorikomiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KokuhorenTorikomiJoho}の編集を行うビルダークラスです。
 */
public class KokuhorenTorikomiJohoBuilder {

    private final DbV3104KokuhorenTorikomiJohoEntity entity;
    private final KokuhorenTorikomiJohoIdentifier id;

    /**
     * {@link DbV3104KokuhorenTorikomiJohoEntity}より{@link KokuhorenTorikomiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbV3104KokuhorenTorikomiJohoEntity}
     * @param id {@link KokuhorenTorikomiJohoIdentifier}
     *
     */
    KokuhorenTorikomiJohoBuilder(
            DbV3104KokuhorenTorikomiJohoEntity entity,
            KokuhorenTorikomiJohoIdentifier id
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
     * @return {@link KokuhorenTorikomiJohoBuilder}
     */
    public KokuhorenTorikomiJohoBuilder set処理年月(FlexibleYearMonth 処理年月) {
        requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年月"));
        entity.setShoriYM(処理年月);
        return this;
    }

    /**
     * 交換情報識別番号を設定します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @return {@link KokuhorenTorikomiJohoBuilder}
     */
    public KokuhorenTorikomiJohoBuilder set交換情報識別番号(RString 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanShikibetsuNo(交換情報識別番号);
        return this;
    }

    /**
     * 処理状態区分を設定します。
     *
     * @param 処理状態区分 処理状態区分
     * @return {@link KokuhorenTorikomiJohoBuilder}
     */
    public KokuhorenTorikomiJohoBuilder set処理状態区分(RString 処理状態区分) {
        requireNonNull(処理状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("処理状態区分"));
        entity.setShoriJotaiKubun(処理状態区分);
        return this;
    }

    /**
     * 前_処理状態区分を設定します。
     *
     * @param 前_処理状態区分 前_処理状態区分
     * @return {@link KokuhorenTorikomiJohoBuilder}
     */
    public KokuhorenTorikomiJohoBuilder set前_処理状態区分(RString 前_処理状態区分) {
        requireNonNull(前_処理状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("前_処理状態区分"));
        entity.setZen_shorijotaikubun(前_処理状態区分);
        return this;
    }

    /**
     * 前々_処理状態区分を設定します。
     *
     * @param 前々_処理状態区分 前々_処理状態区分
     * @return {@link KokuhorenTorikomiJohoBuilder}
     */
    public KokuhorenTorikomiJohoBuilder set前々_処理状態区分(RString 前々_処理状態区分) {
        requireNonNull(前々_処理状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("前々_処理状態区分"));
        entity.setZenzen_shorijotaikubun(前々_処理状態区分);
        return this;
    }

    /**
     * 処理実施日時を設定します。
     *
     * @param 処理実施日時 処理実施日時
     * @return {@link KokuhorenTorikomiJohoBuilder}
     */
    public KokuhorenTorikomiJohoBuilder set処理実施日時(YMDHMS 処理実施日時) {
        requireNonNull(処理実施日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理実施日時"));
        entity.setTougetsushoridate(処理実施日時);
        return this;
    }

    /**
     * 再処理可能区分を設定します。
     *
     * @param 再処理可能区分 再処理可能区分
     * @return {@link KokuhorenTorikomiJohoBuilder}
     */
    public KokuhorenTorikomiJohoBuilder set再処理可能区分(boolean 再処理可能区分) {
        requireNonNull(再処理可能区分, UrSystemErrorMessages.値がnull.getReplacedMessage("再処理可能区分"));
        entity.setSaiShoriKahiKubun(再処理可能区分);
        return this;
    }

    /**
     * {@link KokuhorenTorikomiJoho}のインスタンスを生成します。
     *
     * @return {@link KokuhorenTorikomiJoho}のインスタンス
     */
    public KokuhorenTorikomiJoho build() {
        return new KokuhorenTorikomiJoho(entity, id);
    }
}
