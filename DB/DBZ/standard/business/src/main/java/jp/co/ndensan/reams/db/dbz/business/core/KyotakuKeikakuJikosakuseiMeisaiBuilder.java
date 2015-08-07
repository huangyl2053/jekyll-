/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * {@link KyotakuKeikakuJikosakuseiMeisai}の編集を行うビルダークラスです。
 */
public class KyotakuKeikakuJikosakuseiMeisaiBuilder {

    private final DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity entity;
    private final KyotakuKeikakuJikosakuseiMeisaiIdentifier id;

    /**
     * {@link DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity}より{@link KyotakuKeikakuJikosakuseiMeisai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity}
     * @param id {@link KyotakuKeikakuJikosakuseiMeisaiIdentifier}
     *
     */
    KyotakuKeikakuJikosakuseiMeisaiBuilder(
            DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity entity,
            KyotakuKeikakuJikosakuseiMeisaiIdentifier id
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
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 対象年月を設定します。
     *
     * @param 対象年月 対象年月
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set対象年月(FlexibleYearMonth 対象年月) {
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        entity.setTaishoYM(対象年月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 居宅サービス区分を設定します。
     *
     * @param 居宅サービス区分 居宅サービス区分
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set居宅サービス区分(RString 居宅サービス区分) {
        requireNonNull(居宅サービス区分, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス区分"));
        entity.setKyotakuServiceKubun(居宅サービス区分);
        return this;
    }

    /**
     * サービス提供事業者番号を設定します。
     *
     * @param サービス提供事業者番号 サービス提供事業者番号
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder setサービス提供事業者番号(JigyoshaNo サービス提供事業者番号) {
        requireNonNull(サービス提供事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供事業者番号"));
        entity.setServiceTeikyoJigyoshaNo(サービス提供事業者番号);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * サービス項目コードを設定します。
     *
     * @param サービス項目コード サービス項目コード
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder setサービス項目コード(ServiceKomokuCode サービス項目コード) {
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        entity.setServiceKomokuCode(サービス項目コード);
        return this;
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set単位数(Decimal 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTaniSu(単位数);
        return this;
    }

    /**
     * 回数・日数を設定します。
     *
     * @param 回数・日数 回数・日数
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set回数・日数(Decimal 回数・日数) {
        requireNonNull(回数・日数, UrSystemErrorMessages.値がnull.getReplacedMessage("回数・日数"));
        entity.setKaisu_Nissu(回数・日数);
        return this;
    }

    /**
     * 種類限度内単位数・日数を設定します。
     *
     * @param 種類限度内単位数・日数 種類限度内単位数・日数
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set種類限度内単位数・日数(Decimal 種類限度内単位数・日数) {
        requireNonNull(種類限度内単位数・日数, UrSystemErrorMessages.値がnull.getReplacedMessage("種類限度内単位数・日数"));
        entity.setShuruiGendoNaiTaniSu_Nissu(種類限度内単位数・日数);
        return this;
    }

    /**
     * 種類限度超過単位数・日数を設定します。
     *
     * @param 種類限度超過単位数・日数 種類限度超過単位数・日数
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set種類限度超過単位数・日数(Decimal 種類限度超過単位数・日数) {
        requireNonNull(種類限度超過単位数・日数, UrSystemErrorMessages.値がnull.getReplacedMessage("種類限度超過単位数・日数"));
        entity.setShuruiGendoChokaTaniSu_Nissu(種類限度超過単位数・日数);
        return this;
    }

    /**
     * 区分限度内単位数・日数を設定します。
     *
     * @param 区分限度内単位数・日数 区分限度内単位数・日数
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set区分限度内単位数・日数(Decimal 区分限度内単位数・日数) {
        requireNonNull(区分限度内単位数・日数, UrSystemErrorMessages.値がnull.getReplacedMessage("区分限度内単位数・日数"));
        entity.setKubunGendoNaiTaniSu_Nissu(区分限度内単位数・日数);
        return this;
    }

    /**
     * 区分限度超過単位数・日数を設定します。
     *
     * @param 区分限度超過単位数・日数 区分限度超過単位数・日数
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set区分限度超過単位数・日数(Decimal 区分限度超過単位数・日数) {
        requireNonNull(区分限度超過単位数・日数, UrSystemErrorMessages.値がnull.getReplacedMessage("区分限度超過単位数・日数"));
        entity.setKubunGendoChokaTaniSu_Nissu(区分限度超過単位数・日数);
        return this;
    }

    /**
     * 単位数単価を設定します。
     *
     * @param 単位数単価 単位数単価
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set単位数単価(Decimal 単位数単価) {
        requireNonNull(単位数単価, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数単価"));
        entity.setTaniSuTanka(単位数単価);
        return this;
    }

    /**
     * 給付率を設定します。
     *
     * @param 給付率 給付率
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set給付率(HokenKyufuRitsu 給付率) {
        requireNonNull(給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("給付率"));
        entity.setKyufuRitsu(給付率);
        return this;
    }

    /**
     * 割引後適用率を設定します。
     *
     * @param 割引後適用率 割引後適用率
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set割引後適用率(HokenKyufuRitsu 割引後適用率) {
        requireNonNull(割引後適用率, UrSystemErrorMessages.値がnull.getReplacedMessage("割引後適用率"));
        entity.setWaribikiGoTekiyoRitsu(割引後適用率);
        return this;
    }

    /**
     * 割引後適用単位数を設定します。
     *
     * @param 割引後適用単位数 割引後適用単位数
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set割引後適用単位数(Decimal 割引後適用単位数) {
        requireNonNull(割引後適用単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("割引後適用単位数"));
        entity.setWaribikiGoTekiyoTaniSu(割引後適用単位数);
        return this;
    }

    /**
     * 給付対象日数を設定します。
     *
     * @param 給付対象日数 給付対象日数
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set給付対象日数(Decimal 給付対象日数) {
        requireNonNull(給付対象日数, UrSystemErrorMessages.値がnull.getReplacedMessage("給付対象日数"));
        entity.setKyufuTaishoNissu(給付対象日数);
        return this;
    }

    /**
     * {@link KyotakuKeikakuJikosakuseiMeisai}のインスタンスを生成します。
     *
     * @return {@link KyotakuKeikakuJikosakuseiMeisai}のインスタンス
     */
    public KyotakuKeikakuJikosakuseiMeisai build() {
        return new KyotakuKeikakuJikosakuseiMeisai(entity, id);
    }
}
