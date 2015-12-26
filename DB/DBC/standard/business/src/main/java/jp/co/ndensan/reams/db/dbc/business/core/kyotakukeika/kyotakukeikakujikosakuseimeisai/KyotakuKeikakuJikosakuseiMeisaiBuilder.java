/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseimeisai;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseigokei.KyotakuKeikakuJikoSakuseiGokei;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseigokei.KyotakuKeikakuJikoSakuseiGokeiIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseitankinyushoriyonissu.KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseitankinyushoriyonissu.KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyotakuKeikakuJikosakuseiMeisai}の編集を行うビルダークラスです。
 */
public class KyotakuKeikakuJikosakuseiMeisaiBuilder {

    private final DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity entity;
    private final KyotakuKeikakuJikosakuseiMeisaiIdentifier id;
    private final Models<KyotakuKeikakuJikoSakuseiGokeiIdentifier, KyotakuKeikakuJikoSakuseiGokei> kyotakuKeikakuJikoSakuseiGokei;
    private final Models<KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier, KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu> kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu;

    /**
     * {@link DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity}より{@link KyotakuKeikakuJikosakuseiMeisai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity}
     * @param id {@link KyotakuKeikakuJikosakuseiMeisaiIdentifier}
     * @param kyotakuKeikakuJikoSakuseiGokei {@link Models}
     * @param kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu {@link Models}
     *
     */
    KyotakuKeikakuJikosakuseiMeisaiBuilder(
            DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity entity,
            KyotakuKeikakuJikosakuseiMeisaiIdentifier id,
            Models<KyotakuKeikakuJikoSakuseiGokeiIdentifier, KyotakuKeikakuJikoSakuseiGokei> kyotakuKeikakuJikoSakuseiGokei,
            Models<KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier, KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu> kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.kyotakuKeikakuJikoSakuseiGokei = kyotakuKeikakuJikoSakuseiGokei.clone();
        this.kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu = kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu.clone();

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
     * @param 回数_日数 回数・日数
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set回数_日数(Decimal 回数_日数) {
        requireNonNull(回数_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("回数・日数"));
        entity.setKaisu_Nissu(回数_日数);
        return this;
    }

    /**
     * 種類限度内単位数・日数を設定します。
     *
     * @param 種類限度内単位数_日数 種類限度内単位数・日数
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set種類限度内単位数_日数(Decimal 種類限度内単位数_日数) {
        requireNonNull(種類限度内単位数_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("種類限度内単位数・日数"));
        entity.setShuruiGendoNaiTaniSu_Nissu(種類限度内単位数_日数);
        return this;
    }

    /**
     * 種類限度超過単位数・日数を設定します。
     *
     * @param 種類限度超過単位数_日数 種類限度超過単位数・日数
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set種類限度超過単位数_日数(Decimal 種類限度超過単位数_日数) {
        requireNonNull(種類限度超過単位数_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("種類限度超過単位数・日数"));
        entity.setShuruiGendoChokaTaniSu_Nissu(種類限度超過単位数_日数);
        return this;
    }

    /**
     * 区分限度内単位数・日数を設定します。
     *
     * @param 区分限度内単位数_日数 区分限度内単位数・日数
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set区分限度内単位数_日数(Decimal 区分限度内単位数_日数) {
        requireNonNull(区分限度内単位数_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("区分限度内単位数・日数"));
        entity.setKubunGendoNaiTaniSu_Nissu(区分限度内単位数_日数);
        return this;
    }

    /**
     * 区分限度超過単位数・日数を設定します。
     *
     * @param 区分限度超過単位数_日数 区分限度超過単位数・日数
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder set区分限度超過単位数_日数(Decimal 区分限度超過単位数_日数) {
        requireNonNull(区分限度超過単位数_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("区分限度超過単位数・日数"));
        entity.setKubunGendoChokaTaniSu_Nissu(区分限度超過単位数_日数);
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
     * 居宅給付計画自己作成合計のキー情報について判定します。<br>
     * 居宅給付計画自己作成合計に関連できる居宅給付計画自己作成合計である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は居宅給付計画自己作成合計リストに居宅給付計画自己作成合計{@link KyotakuKeikakuJikoSakuseiGokei}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 居宅給付計画自己作成合計 {@link KyotakuKeikakuJikoSakuseiGokei}
     * @return {@link SeishinTechoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder setKyotakuKeikakuJikoSakuseiGokei(KyotakuKeikakuJikoSakuseiGokei 居宅給付計画自己作成合計) {
        if (hasSameIdentifier(居宅給付計画自己作成合計.identifier())) {
            kyotakuKeikakuJikoSakuseiGokei.add(居宅給付計画自己作成合計);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(KyotakuKeikakuJikoSakuseiGokeiIdentifier 居宅給付計画自己作成合計識別子) {
        return (id.get被保険者番号().equals(居宅給付計画自己作成合計識別子.get被保険者番号())
                && id.getサービス提供事業者番号().equals(居宅給付計画自己作成合計識別子.getサービス提供事業者番号())
                && id.getサービス種類コード().equals(居宅給付計画自己作成合計識別子.getサービス種類コード())
                && id.get対象年月().equals(居宅給付計画自己作成合計識別子.get対象年月())
                && id.get居宅サービス区分().equals(居宅給付計画自己作成合計識別子.get居宅サービス区分())
                && id.get履歴番号() == 居宅給付計画自己作成合計識別子.get履歴番号());
    }

    /**
     * 居宅給付計画自己作成短期入所利用日数のキー情報について判定します。<br>
     * 居宅給付計画自己作成短期入所利用日数に関連できる居宅給付計画自己作成短期入所利用日数である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は居宅給付計画自己作成短期入所利用日数リストに居宅給付計画自己作成短期入所利用日数{@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 居宅給付計画自己作成短期入所利用日数 {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu}
     * @return Builder
     * @throws IllegalStateException キーが一致しない場合
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder setKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu 居宅給付計画自己作成短期入所利用日数) {
        if (hasSameIdentifier(居宅給付計画自己作成短期入所利用日数.identifier())) {
            kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu.add(居宅給付計画自己作成短期入所利用日数);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier 居宅給付計画自己作成短期入所利用日数識別子) {
        return (id.get対象年月().equals(居宅給付計画自己作成短期入所利用日数識別子.get対象年月())
                && id.get被保険者番号().equals(居宅給付計画自己作成短期入所利用日数識別子.get被保険者番号())
                && id.get履歴番号() == 居宅給付計画自己作成短期入所利用日数識別子.get履歴番号());
    }

    /**
     * {@link KyotakuKeikakuJikosakuseiMeisai}のインスタンスを生成します。
     *
     * @return {@link KyotakuKeikakuJikosakuseiMeisai}のインスタンス
     */
    public KyotakuKeikakuJikosakuseiMeisai build() {
        return new KyotakuKeikakuJikosakuseiMeisai(entity, id, kyotakuKeikakuJikoSakuseiGokei, kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu);
    }
}
