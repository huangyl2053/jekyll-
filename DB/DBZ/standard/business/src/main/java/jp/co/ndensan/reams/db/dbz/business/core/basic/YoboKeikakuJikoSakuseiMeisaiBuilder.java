/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link YoboKeikakuJikoSakuseiMeisai}の編集を行うビルダークラスです。
 */
public class YoboKeikakuJikoSakuseiMeisaiBuilder {

    private final DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity;
    private final YoboKeikakuJikoSakuseiMeisaiIdentifier id;

    /**
     * {@link DbT3011YoboKeikakuJikoSakuseiMeisaiEntity}より{@link YoboKeikakuJikoSakuseiMeisai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3011YoboKeikakuJikoSakuseiMeisaiEntity}
     * @param id {@link YoboKeikakuJikoSakuseiMeisaiIdentifier}
     *
     */
    YoboKeikakuJikoSakuseiMeisaiBuilder(
            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity,
            YoboKeikakuJikoSakuseiMeisaiIdentifier id
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
     * @return {@link YoboKeikakuJikoSakuseiMeisaiBuilder}
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 対象年月を設定します。
     *
     * @param 対象年月 対象年月
     * @return {@link YoboKeikakuJikoSakuseiMeisaiBuilder}
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder set対象年月(FlexibleYearMonth 対象年月) {
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        entity.setTaishoYM(対象年月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link YoboKeikakuJikoSakuseiMeisaiBuilder}
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 居宅サービス区分を設定します。
     *
     * @param 居宅サービス区分 居宅サービス区分
     * @return {@link YoboKeikakuJikoSakuseiMeisaiBuilder}
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder set居宅サービス区分(RString 居宅サービス区分) {
        requireNonNull(居宅サービス区分, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス区分"));
        entity.setKyotakuServiceKubun(居宅サービス区分);
        return this;
    }

    /**
     * サービス提供事業者番号を設定します。
     *
     * @param サービス提供事業者番号 サービス提供事業者番号
     * @return {@link YoboKeikakuJikoSakuseiMeisaiBuilder}
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder setサービス提供事業者番号(JigyoshaNo サービス提供事業者番号) {
        requireNonNull(サービス提供事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供事業者番号"));
        entity.setServiceTeikyoJigyoshaNo(サービス提供事業者番号);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link YoboKeikakuJikoSakuseiMeisaiBuilder}
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * サービス項目コードを設定します。
     *
     * @param サービス項目コード サービス項目コード
     * @return {@link YoboKeikakuJikoSakuseiMeisaiBuilder}
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder setサービス項目コード(ServiceKomokuCode サービス項目コード) {
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        entity.setServiceKomokuCode(サービス項目コード);
        return this;
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     * @return {@link YoboKeikakuJikoSakuseiMeisaiBuilder}
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder set単位数(Decimal 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTaniSu(単位数);
        return this;
    }

    /**
     * 回数・日数を設定します。
     *
     * @param 回数_日数 回数・日数
     * @return {@link YoboKeikakuJikoSakuseiMeisaiBuilder}
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder set回数_日数(Decimal 回数_日数) {
        requireNonNull(回数_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("回数・日数"));
        entity.setKaisu_Nissu(回数_日数);
        return this;
    }

    /**
     * 種類限度内単位数・日数を設定します。
     *
     * @param 種類限度内単位数_日数 種類限度内単位数・日数
     * @return {@link YoboKeikakuJikoSakuseiMeisaiBuilder}
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder set種類限度内単位数_日数(Decimal 種類限度内単位数_日数) {
        requireNonNull(種類限度内単位数_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("種類限度内単位数・日数"));
        entity.setShuruiGendoNaiTaniSu_Nissu(種類限度内単位数_日数);
        return this;
    }

    /**
     * 種類限度超過単位数・日数を設定します。
     *
     * @param 種類限度超過単位数_日数 種類限度超過単位数・日数
     * @return {@link YoboKeikakuJikoSakuseiMeisaiBuilder}
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder set種類限度超過単位数_日数(Decimal 種類限度超過単位数_日数) {
        requireNonNull(種類限度超過単位数_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("種類限度超過単位数・日数"));
        entity.setShuruiGendoChokaTaniSu_Nissu(種類限度超過単位数_日数);
        return this;
    }

    /**
     * 区分限度内単位数・日数を設定します。
     *
     * @param 区分限度内単位数_日数 区分限度内単位数・日数
     * @return {@link YoboKeikakuJikoSakuseiMeisaiBuilder}
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder set区分限度内単位数_日数(Decimal 区分限度内単位数_日数) {
        requireNonNull(区分限度内単位数_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("区分限度内単位数・日数"));
        entity.setKubunGendoNaiTaniSu_Nissu(区分限度内単位数_日数);
        return this;
    }

    /**
     * 区分限度超過単位数・日数を設定します。
     *
     * @param 区分限度超過単位数_日数 区分限度超過単位数・日数
     * @return {@link YoboKeikakuJikoSakuseiMeisaiBuilder}
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder set区分限度超過単位数_日数(Decimal 区分限度超過単位数_日数) {
        requireNonNull(区分限度超過単位数_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("区分限度超過単位数・日数"));
        entity.setKubunGendoChokaTaniSu_Nissu(区分限度超過単位数_日数);
        return this;
    }

    /**
     * 単位数単価を設定します。
     *
     * @param 単位数単価 単位数単価
     * @return {@link YoboKeikakuJikoSakuseiMeisaiBuilder}
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder set単位数単価(Decimal 単位数単価) {
        requireNonNull(単位数単価, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数単価"));
        entity.setTaniSuTanka(単位数単価);
        return this;
    }

    /**
     * 給付率を設定します。
     *
     * @param 給付率 給付率
     * @return {@link YoboKeikakuJikoSakuseiMeisaiBuilder}
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder set給付率(HokenKyufuRitsu 給付率) {
        requireNonNull(給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("給付率"));
        entity.setKyufuRitsu(給付率);
        return this;
    }

    /**
     * 割引後適用率を設定します。
     *
     * @param 割引後適用率 割引後適用率
     * @return {@link YoboKeikakuJikoSakuseiMeisaiBuilder}
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder set割引後適用率(HokenKyufuRitsu 割引後適用率) {
        requireNonNull(割引後適用率, UrSystemErrorMessages.値がnull.getReplacedMessage("割引後適用率"));
        entity.setWaribikiGoTekiyoRitsu(割引後適用率);
        return this;
    }

    /**
     * 割引後適用単位数を設定します。
     *
     * @param 割引後適用単位数 割引後適用単位数
     * @return {@link YoboKeikakuJikoSakuseiMeisaiBuilder}
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder set割引後適用単位数(Decimal 割引後適用単位数) {
        requireNonNull(割引後適用単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("割引後適用単位数"));
        entity.setWaribikiGoTekiyoTaniSu(割引後適用単位数);
        return this;
    }

    /**
     * 定額利用者負担単価金額を設定します。
     *
     * @param 定額利用者負担単価金額 定額利用者負担単価金額
     * @return {@link YoboKeikakuJikoSakuseiMeisaiBuilder}
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder set定額利用者負担単価金額(Decimal 定額利用者負担単価金額) {
        requireNonNull(定額利用者負担単価金額, UrSystemErrorMessages.値がnull.getReplacedMessage("定額利用者負担単価金額"));
        entity.setTeigakuRiyoshaFutanTankaKingaku(定額利用者負担単価金額);
        return this;
    }

    /**
     * {@link YoboKeikakuJikoSakuseiMeisai}のインスタンスを生成します。
     *
     * @return {@link YoboKeikakuJikoSakuseiMeisai}のインスタンス
     */
    public YoboKeikakuJikoSakuseiMeisai build() {
        return new YoboKeikakuJikoSakuseiMeisai(entity, id);
    }
}
