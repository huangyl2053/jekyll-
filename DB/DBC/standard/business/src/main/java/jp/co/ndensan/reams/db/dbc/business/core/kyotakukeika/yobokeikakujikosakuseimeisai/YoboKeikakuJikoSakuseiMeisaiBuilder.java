/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.yobokeikakujikosakuseimeisai;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.yobokeikakujikosakuseigokei.YoboKeikakuJikoSakuseiGokei;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.yobokeikakujikosakuseigokei.YoboKeikakuJikoSakuseiGokeiIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.yobokeikakujikosakuseitankiriyonissu.YoboKeikakuJikoSakuseiTankiRiyoNissu;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.yobokeikakujikosakuseitankiriyonissu.YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3011YoboKeikakuJikoSakuseiMeisaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link YoboKeikakuJikoSakuseiMeisai}の編集を行うビルダークラスです。
 */
public class YoboKeikakuJikoSakuseiMeisaiBuilder {

    private final DbT3011YoboKeikakuJikoSakuseiMeisaiEntity entity;
    private final YoboKeikakuJikoSakuseiMeisaiIdentifier id;
    private final Models<YoboKeikakuJikoSakuseiGokeiIdentifier, YoboKeikakuJikoSakuseiGokei> yoboKeikakuJikoSakuseiGokei;
    private final Models<YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier, YoboKeikakuJikoSakuseiTankiRiyoNissu> yoboKeikakuJikoSakuseiTankiRiyoNissu;

    /**
     * {@link DbT3011YoboKeikakuJikoSakuseiMeisaiEntity}より{@link YoboKeikakuJikoSakuseiMeisai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3011YoboKeikakuJikoSakuseiMeisaiEntity}
     * @param id {@link YoboKeikakuJikoSakuseiMeisaiIdentifier}
     * @param yoboKeikakuJikoSakuseiGokei {@link Models}
     * @param yoboKeikakuJikoSakuseiTankiRiyoNissu {@link Models}
     *
     */
    YoboKeikakuJikoSakuseiMeisaiBuilder(
            DbT3011YoboKeikakuJikoSakuseiMeisaiEntity entity,
            YoboKeikakuJikoSakuseiMeisaiIdentifier id,
            Models<YoboKeikakuJikoSakuseiGokeiIdentifier, YoboKeikakuJikoSakuseiGokei> yoboKeikakuJikoSakuseiGokei,
            Models<YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier, YoboKeikakuJikoSakuseiTankiRiyoNissu> yoboKeikakuJikoSakuseiTankiRiyoNissu
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.yoboKeikakuJikoSakuseiGokei = yoboKeikakuJikoSakuseiGokei.clone();
        this.yoboKeikakuJikoSakuseiTankiRiyoNissu = yoboKeikakuJikoSakuseiTankiRiyoNissu.clone();

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
        requireNonNull(区分限度超過単位数_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("区分限度超過単位数・日数")
        );
        entity.setKubunGendoChokaTaniSu_Nissu(区分限度超過単位数_日数
        );
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
     * 予防給付計画自己作成合計のキー情報について判定します。<br>
     * 予防給付計画自己作成合計に関連できる予防給付計画自己作成合計である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は予防給付計画自己作成合計リストに予防給付計画自己作成合計{@link YoboKeikakuJikoSakuseiGokei}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 予防給付計画自己作成合計 {@link YoboKeikakuJikoSakuseiGokei}
     * @return {@link SeishinTechoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder setYoboKeikakuJikoSakuseiGokei(YoboKeikakuJikoSakuseiGokei 予防給付計画自己作成合計) {
        if (hasSameIdentifier(予防給付計画自己作成合計.identifier())) {
            yoboKeikakuJikoSakuseiGokei.add(予防給付計画自己作成合計);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(YoboKeikakuJikoSakuseiGokeiIdentifier 予防給付計画自己作成合計識別子) {
        return (id.get履歴番号() == 予防給付計画自己作成合計識別子.get履歴番号()
                && id.get対象年月().equals(予防給付計画自己作成合計識別子.get対象年月())
                && id.get被保険者番号().equals(予防給付計画自己作成合計識別子.get被保険者番号())
                && id.get居宅サービス区分().equals(予防給付計画自己作成合計識別子.get居宅サービス区分())
                && id.getサービス提供事業者番号().equals(予防給付計画自己作成合計識別子.getサービス提供事業者番号())
                && id.getサービス種類コード().equals(予防給付計画自己作成合計識別子.getサービス種類コード()));
    }

    /**
     * 予防給付計画自己作成短期利用日数のキー情報について判定します。<br>
     * 予防給付計画自己作成合計に関連できる予防給付計画自己作成短期利用日数である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は予防給付計画自己作成短期利用日数リストに予防給付計画自己作成短期利用日数{@link YoboKeikakuJikoSakuseiTankiRiyoNissu}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 予防給付計画自己作成短期利用日数 {@link YoboKeikakuJikoSakuseiTankiRiyoNissu}
     * @return Builder
     * @throws IllegalStateException キーが一致しない場合
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder setYoboKeikakuJikoSakuseiTankiRiyoNissu(YoboKeikakuJikoSakuseiTankiRiyoNissu 予防給付計画自己作成短期利用日数) {
        if (hasSameIdentifier(予防給付計画自己作成短期利用日数.identifier())) {
            yoboKeikakuJikoSakuseiTankiRiyoNissu.add(予防給付計画自己作成短期利用日数);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier 予防給付計画自己作成短期利用日数識別子) {
        return (id.get被保険者番号().equals(予防給付計画自己作成短期利用日数識別子.get被保険者番号())
                && id.get対象年月().equals(予防給付計画自己作成短期利用日数識別子.get対象年月())
                && id.get履歴番号() == 予防給付計画自己作成短期利用日数識別子.get履歴番号());
    }

    /**
     * {@link YoboKeikakuJikoSakuseiMeisai}のインスタンスを生成します。
     *
     * @return {@link YoboKeikakuJikoSakuseiMeisai}のインスタンス
     */
    public YoboKeikakuJikoSakuseiMeisai build() {
        return new YoboKeikakuJikoSakuseiMeisai(entity, id, yoboKeikakuJikoSakuseiGokei, yoboKeikakuJikoSakuseiTankiRiyoNissu);
    }
}
