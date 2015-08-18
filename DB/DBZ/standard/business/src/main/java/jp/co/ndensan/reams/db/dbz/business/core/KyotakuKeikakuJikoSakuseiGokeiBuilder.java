/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyotakuKeikakuJikoSakuseiGokei}の編集を行うビルダークラスです。
 */
public class KyotakuKeikakuJikoSakuseiGokeiBuilder {

    private final DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity;
    private final KyotakuKeikakuJikoSakuseiGokeiIdentifier id;

    /**
     * {@link DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity}より{@link KyotakuKeikakuJikoSakuseiGokei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity}
     * @param id {@link KyotakuKeikakuJikoSakuseiGokeiIdentifier}
     *
     */
    KyotakuKeikakuJikoSakuseiGokeiBuilder(
            DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity,
            KyotakuKeikakuJikoSakuseiGokeiIdentifier id
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
     * @return {@link KyotakuKeikakuJikoSakuseiGokeiBuilder}
     */
    public KyotakuKeikakuJikoSakuseiGokeiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 対象年月を設定します。
     *
     * @param 対象年月 対象年月
     * @return {@link KyotakuKeikakuJikoSakuseiGokeiBuilder}
     */
    public KyotakuKeikakuJikoSakuseiGokeiBuilder set対象年月(FlexibleYearMonth 対象年月) {
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        entity.setTaishoYM(対象年月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KyotakuKeikakuJikoSakuseiGokeiBuilder}
     */
    public KyotakuKeikakuJikoSakuseiGokeiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 居宅サービス区分を設定します。
     *
     * @param 居宅サービス区分 居宅サービス区分
     * @return {@link KyotakuKeikakuJikoSakuseiGokeiBuilder}
     */
    public KyotakuKeikakuJikoSakuseiGokeiBuilder set居宅サービス区分(RString 居宅サービス区分) {
        requireNonNull(居宅サービス区分, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス区分"));
        entity.setKyotakuServiceKubun(居宅サービス区分);
        return this;
    }

    /**
     * サービス提供事業者番号を設定します。
     *
     * @param サービス提供事業者番号 サービス提供事業者番号
     * @return {@link KyotakuKeikakuJikoSakuseiGokeiBuilder}
     */
    public KyotakuKeikakuJikoSakuseiGokeiBuilder setサービス提供事業者番号(JigyoshaNo サービス提供事業者番号) {
        requireNonNull(サービス提供事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供事業者番号"));
        entity.setServiceTeikyoJigyoshaNo(サービス提供事業者番号);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link KyotakuKeikakuJikoSakuseiGokeiBuilder}
     */
    public KyotakuKeikakuJikoSakuseiGokeiBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * 給付計画単位数を設定します。
     *
     * @param 給付計画単位数 給付計画単位数
     * @return {@link KyotakuKeikakuJikoSakuseiGokeiBuilder}
     */
    public KyotakuKeikakuJikoSakuseiGokeiBuilder set給付計画単位数(Decimal 給付計画単位数) {
        requireNonNull(給付計画単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("給付計画単位数"));
        entity.setKyufuKeikakuTaniSu(給付計画単位数);
        return this;
    }

    /**
     * {@link KyotakuKeikakuJikoSakuseiGokei}のインスタンスを生成します。
     *
     * @return {@link KyotakuKeikakuJikoSakuseiGokei}のインスタンス
     */
    public KyotakuKeikakuJikoSakuseiGokei build() {
        return new KyotakuKeikakuJikoSakuseiGokei(entity, id);
    }
}
