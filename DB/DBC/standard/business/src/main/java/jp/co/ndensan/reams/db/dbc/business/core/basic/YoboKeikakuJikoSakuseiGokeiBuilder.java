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
 * {@link YoboKeikakuJikoSakuseiGokei}の編集を行うビルダークラスです。
 */
public class YoboKeikakuJikoSakuseiGokeiBuilder {

    private final DbT3012YoboKeikakuJikoSakuseiGokeiEntity entity;
    private final YoboKeikakuJikoSakuseiGokeiIdentifier id;

    /**
     * {@link DbT3012YoboKeikakuJikoSakuseiGokeiEntity}より{@link YoboKeikakuJikoSakuseiGokei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3012YoboKeikakuJikoSakuseiGokeiEntity}
     * @param id {@link YoboKeikakuJikoSakuseiGokeiIdentifier}
     *
     */
    YoboKeikakuJikoSakuseiGokeiBuilder(
            DbT3012YoboKeikakuJikoSakuseiGokeiEntity entity,
            YoboKeikakuJikoSakuseiGokeiIdentifier id
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
     * @return {@link YoboKeikakuJikoSakuseiGokeiBuilder}
     */
    public YoboKeikakuJikoSakuseiGokeiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 対象年月を設定します。
     *
     * @param 対象年月 対象年月
     * @return {@link YoboKeikakuJikoSakuseiGokeiBuilder}
     */
    public YoboKeikakuJikoSakuseiGokeiBuilder set対象年月(FlexibleYearMonth 対象年月) {
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        entity.setTaishoYM(対象年月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link YoboKeikakuJikoSakuseiGokeiBuilder}
     */
    public YoboKeikakuJikoSakuseiGokeiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 居宅サービス区分を設定します。
     *
     * @param 居宅サービス区分 居宅サービス区分
     * @return {@link YoboKeikakuJikoSakuseiGokeiBuilder}
     */
    public YoboKeikakuJikoSakuseiGokeiBuilder set居宅サービス区分(RString 居宅サービス区分) {
        requireNonNull(居宅サービス区分, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス区分"));
        entity.setKyotakuServiceKubun(居宅サービス区分);
        return this;
    }

    /**
     * サービス提供事業者番号を設定します。
     *
     * @param サービス提供事業者番号 サービス提供事業者番号
     * @return {@link YoboKeikakuJikoSakuseiGokeiBuilder}
     */
    public YoboKeikakuJikoSakuseiGokeiBuilder setサービス提供事業者番号(JigyoshaNo サービス提供事業者番号) {
        requireNonNull(サービス提供事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供事業者番号"));
        entity.setServiceTeikyoJigyoshaNo(サービス提供事業者番号);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link YoboKeikakuJikoSakuseiGokeiBuilder}
     */
    public YoboKeikakuJikoSakuseiGokeiBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * 給付計画単位数を設定します。
     *
     * @param 給付計画単位数 給付計画単位数
     * @return {@link YoboKeikakuJikoSakuseiGokeiBuilder}
     */
    public YoboKeikakuJikoSakuseiGokeiBuilder set給付計画単位数(Decimal 給付計画単位数) {
        requireNonNull(給付計画単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("給付計画単位数"));
        entity.setKeikakuTaniSu(給付計画単位数);
        return this;
    }

    /**
     * {@link YoboKeikakuJikoSakuseiGokei}のインスタンスを生成します。
     *
     * @return {@link YoboKeikakuJikoSakuseiGokei}のインスタンス
     */
    public YoboKeikakuJikoSakuseiGokei build() {
        return new YoboKeikakuJikoSakuseiGokei(entity, id);
    }
}
